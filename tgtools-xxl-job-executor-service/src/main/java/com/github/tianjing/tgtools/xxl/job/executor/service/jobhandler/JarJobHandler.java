package com.github.tianjing.tgtools.xxl.job.executor.service.jobhandler;

import com.github.tianjing.tgtools.xxl.job.executor.service.util.XxlJobLogHelper;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.XxlJob;
import tgtools.json.JSONObject;
import tgtools.plugin.util.JARLoader;
import tgtools.service.BaseService;
import tgtools.tasks.Task;
import tgtools.tasks.TaskContext;



/**
 * 执行Jar包（Bean模式）
 * jar 放置位置 springboot jar 同级目录 Services/${name}/*.jar
 * className 就是 反射 类 执行
 */

public class JarJobHandler {
    @XxlJob("jarJobHandler")
    public ReturnT<String> execute(String param) throws Exception {
        try {
            JARLoader jar = new JARLoader(ClassLoader.getSystemClassLoader());

            JSONObject vJson = new JSONObject(param);

            String jobname = vJson.getString("name");
            String className = vJson.getString("className");
            String path = tgtools.web.platform.Platform.getServerPath() + "Services/" + jobname;


            jar.addPath(path);
            Class clazz = jar.loadClass(className);
            Object task = clazz.newInstance();
            tgtools.web.services.ServicesEntity entity = new tgtools.web.services.ServicesEntity();
            entity.setPATH(path);
            entity.setCLASSNAME(className);
            entity.setNAME(jobname);

            if (task instanceof BaseService) {
                BaseService service = (BaseService) task;
                TaskContext cont = new TaskContext();
                cont.put("info", entity);
                cont.put("jobContext", null);
                if (service.canRun()) {
                    service.run(cont);
                }
            } else if (task instanceof Task) {
                TaskContext cont = new TaskContext();
                cont.put("info", entity);
                cont.put("jobContext", null);
                ((Task) task).run(cont);
            }
        } catch (Throwable e) {
            XxlJobLogHelper.log( "服务执行失败;原因：" + e.toString());
            return ReturnT.FAIL;
        }
        return ReturnT.SUCCESS;
    }

}
