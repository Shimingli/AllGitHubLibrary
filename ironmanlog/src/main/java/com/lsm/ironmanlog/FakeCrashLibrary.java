package com.lsm.ironmanlog;

import com.dianping.logan.Logan;

/**
 * <p>
 *  把有些严重的日志反馈给线上
 * </p>
 *
 * @author shiming
 * @version v1.0
 * @since 2019/1/25 14:20
 */

public class FakeCrashLibrary {

    /**
     * 将日志项添加到循环缓冲区。
     * @param priority
     * @param tag
     * @param message
     */
    public static void log(int priority, String tag, String message) {
        Logan.w(message, priority);
    }

    /**
     * 报告非致命警告。
     * @param t
     */
    public static void logWarning(Throwable t) {
        Logan.w(t.toString(), 0);
    }

    /**
     * 报告非致命错误。
     * @param t
     */
    public static void logError(Throwable t) {
        Logan.w(t.toString(), 0);
    }

    private FakeCrashLibrary() {
        throw new AssertionError("不能初始化");
    }
}
