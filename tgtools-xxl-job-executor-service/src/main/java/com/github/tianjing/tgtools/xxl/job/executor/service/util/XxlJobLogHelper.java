package com.github.tianjing.tgtools.xxl.job.executor.service.util;

import com.xxl.job.core.log.XxlJobLogger;

/**
 * @author 田径
 * @create 2019-11-23 18:16
 * @desc
 **/
public class XxlJobLogHelper {

    /**
     * 日志
     * @param pAppendLogPattern
     */
    public static void log(String pAppendLogPattern) {
        XxlJobLogger.log(pAppendLogPattern);
    }

    /**
     *
     * @param pAppendLogPattern
     * @param pAppendLogArguments
     */
    public static void log(String pAppendLogPattern, Object... pAppendLogArguments) {
        XxlJobLogger.log(pAppendLogPattern, pAppendLogArguments);
    }

}
