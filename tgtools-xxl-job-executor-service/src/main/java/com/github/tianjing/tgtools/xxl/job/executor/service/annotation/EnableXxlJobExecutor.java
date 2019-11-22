package com.github.tianjing.tgtools.xxl.job.executor.service.annotation;

import com.github.tianjing.tgtools.xxl.job.executor.service.config.XxlJobExecutorConfig;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;

import java.lang.annotation.*;

@Retention(value = java.lang.annotation.RetentionPolicy.RUNTIME)
@Target(value = {java.lang.annotation.ElementType.TYPE})
@Documented
@ImportAutoConfiguration({XxlJobExecutorConfig.class,})
public @interface EnableXxlJobExecutor {
}
