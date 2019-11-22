package com.github.tianjing.tgtools.xxl.job.executor.service.config;

import com.github.tianjing.tgtools.xxl.job.executor.service.jobhandler.JarJobHandler;
import com.xxl.job.core.executor.impl.XxlJobSpringExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tgtools.util.LogHelper;
import tgtools.web.platform.Platform;

import javax.annotation.PostConstruct;

/**
 * xxl-job config
 *
 * @author xuxueli 2017-04-28
 */
@Configuration
public class XxlJobExecutorConfig {
    @Value("${xxl.job.admin.addresses}")
    private String adminAddresses;

    @Value("${xxl.job.executor.appname}")
    private String appName;

    @Value("${xxl.job.executor.ip}")
    private String ip;

    @Value("${xxl.job.executor.port}")
    private int port;

    @Value("${xxl.job.accessToken}")
    private String accessToken;

    @Value("${xxl.job.executor.logpath}")
    private String logPath;

    @Value("${xxl.job.executor.logretentiondays}")
    private int logRetentionDays;

    //@Bean(initMethod = "start", destroyMethod = "destroy")
    @Bean()
    public XxlJobSpringExecutor xxlJobExecutor() {
        tgtools.util.LogHelper.infoForce(this.getClass().getName(),"xxlJobExecutor init ======","xxlJobExecutor");
        XxlJobSpringExecutor xxlJobSpringExecutor = new XxlJobSpringExecutor();
        xxlJobSpringExecutor.setAdminAddresses(adminAddresses);
        xxlJobSpringExecutor.setAppName(appName);
        xxlJobSpringExecutor.setIp(ip);
        xxlJobSpringExecutor.setPort(port);
        xxlJobSpringExecutor.setAccessToken(accessToken);
        xxlJobSpringExecutor.setLogPath(logPath);
        xxlJobSpringExecutor.setLogRetentionDays(logRetentionDays);

        return xxlJobSpringExecutor;
    }
    @Autowired
    ApplicationContext applicationContext;

    @PostConstruct
    public void init() {
        Platform.startup(this.applicationContext, false, false, false, false, false, false);
        LogHelper.info("", "fdasfds", "fdafdsa");
    }

    @Bean
    public JarJobHandler JarJobHandler()
    {
        return new JarJobHandler();
    }
}