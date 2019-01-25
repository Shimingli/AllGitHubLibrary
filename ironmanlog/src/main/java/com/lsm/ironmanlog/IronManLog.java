package com.lsm.ironmanlog;

import android.util.Log;

import com.dianping.logan.Logan;
import com.dianping.logan.LoganConfig;
import com.dianping.logan.OnLoganProtocolStatus;
import com.dianping.logan.SendLogRunnable;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.util.Map;

import timber.log.Timber;

import static android.util.Log.INFO;

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

    /**
     * 初始化工程
     * @param ironManLogConfig config
     * @param isDebug 是否是Debug的模式
     * @param openTestFlag 这个标记就是把平常所有的日志全部给我保存起来  上线请务必关闭
     */
    public static void init(IronManLogConfig ironManLogConfig, boolean isDebug, final boolean openTestFlag) {
        LoganConfig config = new LoganConfig.Builder()
                .setCachePath(ironManLogConfig.mContext.getFilesDir().getAbsolutePath())
                .setPath(ironManLogConfig.mContext.getExternalFilesDir(null).getAbsolutePath()
                        + File.separator + ironManLogConfig.mCacheFolder)
                .setEncryptKey16(IronManLogConfig.mEncryptKey16) //128位aes加密Key
                .setEncryptIV16(IronManLogConfig.mEncryptIv16) //128位aes加密IV
                .build();
        Logan.init(config);
        FileNameConfig.initFolder();
        //这样子初始化，有些关键的日志就会存到文档中，同时Debug的日志就不会存入到文本中
        if (isDebug) {
            Timber.plant(new Timber.DebugTree() {
                @Override
                protected void log(int priority, String tag, @NotNull String message, Throwable t) {
                    if (openTestFlag)
                    FakeCrashLibrary.log(priority, tag, message);
                    super.log(priority, tag, message, t);
                }
            });
        } else {
            Timber.plant(new CrashReportingTree());
        }
    }

    /**
     * 记录重要信息以进行故障报告的树。
     */
    private static final class CrashReportingTree extends Timber.Tree {

        @Override
        protected boolean isLoggable(@Nullable String tag, int priority) {
            return priority >= INFO;
        }

        @Override
        protected void log(int priority, @org.jetbrains.annotations.Nullable String tag, @NotNull String message, @org.jetbrains.annotations.Nullable Throwable t) {
            if (priority == Log.VERBOSE || priority == Log.DEBUG) {

                return;
            }
            FakeCrashLibrary.log(priority, tag, message);
            if (t != null) {
                if (priority == Log.ERROR) {
                    FakeCrashLibrary.logError(t);
                } else if (priority == Log.WARN) {
                    FakeCrashLibrary.logWarning(t);
                }
            }
        }
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
     * 自定义文件的操作 ，但是是加密的
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
        return Logan.getAllFilesInfo();
    }

    /**
     * 解密文件，上传文件等动作
     *
     * @param dates              日期的数组 “1820-10-10”
     * @param listener
     * @param needDeleteCopyFile 需要删除解密后的文件 默认是删除掉的
     * @param needShowLogMsg     需要回调打印日志不，如果不需要，可以节约好多的性能
     */
    public static void setOnDecryptFile(String dates[], OnDecryptFileLisenter listener, boolean needDeleteCopyFile, boolean needShowLogMsg) {
        RealSendLogRunnable realSendLogRunnable = new RealSendLogRunnable(listener);
        realSendLogRunnable.setNeedDeleteCopyFile(needDeleteCopyFile);
        realSendLogRunnable.setNeedShowLogMsg(needShowLogMsg);
        Logan.s(dates, realSendLogRunnable);
    }

    public interface OnDecryptFileLisenter {

        void readLineMsg(String temp);
    }

}
