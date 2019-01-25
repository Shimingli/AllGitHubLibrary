package com.lsm.ironmanlog;

import com.dianping.logan.Logan;
import com.dianping.logan.LoganConfig;
import com.dianping.logan.OnLoganProtocolStatus;
import com.dianping.logan.SendLogRunnable;

import java.io.File;
import java.util.Map;

/**
 * <p>
 *
 * </p>
 *
 * @author shiming
 * @version v1.0
 * @since 2019/1/25 11:11
 */

public class IronManLog {

    public static void init(IronManLogConfig ironManLogConfig) {
        LoganConfig config = new LoganConfig.Builder()
                .setCachePath(ironManLogConfig.mContext.getFilesDir().getAbsolutePath())
                .setPath(ironManLogConfig.mContext.getExternalFilesDir(null).getAbsolutePath()
                        + File.separator + ironManLogConfig.mCacheFolder)
                .setEncryptKey16(ironManLogConfig.mEncryptKey16) //128位aes加密Key
                .setEncryptIV16(ironManLogConfig.mEncryptIv16) //128位aes加密IV
                .build();
        Logan.init(config);
        FileNameConfig.initFolder();
    }

    /**
     * @param log  表示日志内容
     * @param type 表示日志类型
     * @brief Logan写入日志
     */
    public static void w(String log, int type) {
        Logan.w(log, type);
    }
    /**
     * @brief 立即写入日志文件
     */
    public static void f() {
        Logan.f();
    }

    /**
     * @param dates    日期数组，格式：“2018-07-27”
     * @param runnable 发送操作
     * @brief 发送日志
     */
    public static void s(String dates[], SendLogRunnable runnable) {
        Logan.s(dates, runnable);
    }

    /**
     * @brief 返回所有日志文件信息
     */
    public static Map<String, Long> getAllFilesInfo() {
        return  Logan.getAllFilesInfo();
    }

    /**
     * @brief Logan Debug开关
     */
    public static void setDebug(boolean debug) {
        Logan.setDebug(debug);
    }

    public static void setOnLoganProtocolStatus(OnLoganProtocolStatus listener) {
        Logan.setOnLoganProtocolStatus(listener);
    }

//    public static void setOnLoganProtocolStatus(OnLoganProtocolStatus listener) {
//        Logan.setOnLoganProtocolStatus(listener);
//    }
}
