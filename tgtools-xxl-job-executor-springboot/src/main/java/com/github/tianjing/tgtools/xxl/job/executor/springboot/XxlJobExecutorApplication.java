package com.github.tianjing.tgtools.xxl.job.executor.springboot;

import com.github.tianjing.tgtools.xxl.job.executor.service.annotation.EnableXxlJobExecutor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author xuxueli 2018-10-28 00:38:13
 */
@EnableXxlJobExecutor
@SpringBootApplication
public class XxlJobExecutorApplication {
	public static void main(String[] args) {
        SpringApplication.run(XxlJobExecutorApplication.class, args);
	}
}