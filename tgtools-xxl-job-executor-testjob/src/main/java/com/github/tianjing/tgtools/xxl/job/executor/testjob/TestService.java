package com.github.tianjing.tgtools.xxl.job.executor.testjob;

import tgtools.service.BaseService;
import tgtools.tasks.TaskContext;
import tgtools.util.DateUtil;

import java.util.Date;

/**
 * @author 田径
 * @create 2019-11-22 15:00
 * @desc
 **/
public class TestService extends BaseService {
    @Override
    public String getName() {
        return "TestService";
    }

    @Override
    protected int getInterval() {
        return -1;
    }

    @Override
    protected Date getEndTime() {
        return DateUtil.getMaxDate();
    }

    @Override
    public void run(TaskContext p_Param) {
       // tgtools.util.LogHelper.info("TestService","hello","run");

        tgtools.util.LogHelper.info("TestService","hello 321312321 start ","run");
        try {
            Thread.sleep(1000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        tgtools.util.LogHelper.info("TestService","hello 321312321 end","run");
    }
}
