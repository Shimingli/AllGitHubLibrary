package com.lsm.ironmanlog;

import android.content.Context;
import android.text.TextUtils;

/**
 * <p>
 *
 * </p>
 *
 * @author shiming
 * @version v1.0
 * @since 2019/1/25 11:05
 */

public class IronManLogConfig {

    private static final long DAYS = 24 * 60 * 60 * 1000; //天
    private static final long M = 1024 * 1024; //M
    private static final long DEFAULT_DAY = 7 * DAYS; //默认删除天数
    private static final long DEFAULT_FILE_SIZE = 10 * M;
    private static final long DEFAULT_MIN_SDCARD_SIZE = 50 * M; //最小的SD卡小于这个大小不写入
    private static final int DEFAULT_QUEUE = 500;

    String mCachePath; //mmap缓存路径
    String mPathPath; //file文件路径

    long mMaxFile = DEFAULT_FILE_SIZE; //删除文件最大值
    long mDay = DEFAULT_DAY; //删除天数
    long mMaxQueue = DEFAULT_QUEUE;
    long mMinSDCard = DEFAULT_MIN_SDCARD_SIZE; //最小sdk卡大小

    public static byte[] mEncryptKey16; //16位aes加密Key
    public static byte[] mEncryptIv16; //16位aes加密IV

    public static String mUploadFolderName="android"; //由于文件是加密的，如果需要自己解密然后上传到后台的话，那么这里就需要一个文件夹的名称
    public static String mUploadFileName="android.log"; //由于文件是加密的，如果需要自己解密然后上传到后台的话，那么这里就需要一个文件的名称

    Context mContext; //getApplicationContext() 建议获取此方法的context
    String mCacheFolder;//这是Logan正在缓存在本地文件夹的名称

    boolean isValid() {
        boolean valid = false;
        if (!TextUtils.isEmpty(mCachePath) && !TextUtils.isEmpty(mPathPath) && mEncryptKey16 != null
                && mEncryptIv16 != null) {
            valid = true;
        }
        return valid;
    }

    IronManLogConfig() {

    }
    void setCacheFolder(String cacheFolder){
        mCacheFolder=cacheFolder;
    }
    void  setContext(Context context){
        mContext=context;
    }
    void setCachePath(String cachePath) {
        mCachePath = cachePath;
    }

    void setPathPath(String pathPath) {
        mPathPath = pathPath;
    }

    void setMaxFile(long maxFile) {
        mMaxFile = maxFile;
    }

    void setDay(long day) {
        mDay = day;
    }

    void setMinSDCard(long minSDCard) {
        mMinSDCard = minSDCard;
    }

    void setEncryptKey16(byte[] encryptKey16) {
        mEncryptKey16 = encryptKey16;
    }

    void setEncryptIV16(byte[] encryptIv16) {
        mEncryptIv16 = encryptIv16;
    }

    public static final class Builder {
        String mCachePath; //mmap缓存路径
        String mPath; //file文件路径
        long mMaxFile = DEFAULT_FILE_SIZE; //删除文件最大值
        long mDay = DEFAULT_DAY; //删除天数
        byte[] mEncryptKey16; //16位aes加密Key
        byte[] mEncryptIv16; //16位aes加密IV
        long mMinSDCard = DEFAULT_MIN_SDCARD_SIZE;
        Context mContext;
        String mCacheFolder;
        public Builder setCacheFolder(String cacheFolder){
            mCacheFolder=cacheFolder;
            return this;
        }
        public Builder setContext(Context context){
            mContext=context;
            return this;
        }

        public Builder setCachePath(String cachePath) {
            mCachePath = cachePath;
            return this;
        }

        public Builder setPath(String path) {
            mPath = path;
            return this;
        }

        public Builder setMaxFile(long maxFile) {
            mMaxFile = maxFile * M;
            return this;
        }

        public Builder setDay(long day) {
            mDay = day * DAYS;
            return this;
        }

        public Builder setEncryptKey16(byte[] encryptKey16) {
            mEncryptKey16 = encryptKey16;
            return this;
        }

        public Builder setEncryptIV16(byte[] encryptIv16) {
            mEncryptIv16 = encryptIv16;
            return this;
        }

        public Builder setMinSDCard(long minSDCard) {
            this.mMinSDCard = minSDCard;
            return this;
        }

        public IronManLogConfig build() {
            IronManLogConfig config = new IronManLogConfig();
            config.setCachePath(mCachePath);
            config.setCacheFolder(mCacheFolder);
            config.setContext(mContext);
            config.setPathPath(mPath);
            config.setMaxFile(mMaxFile);
            config.setMinSDCard(mMinSDCard);
            config.setDay(mDay);
            config.setEncryptKey16(mEncryptKey16);
            config.setEncryptIV16(mEncryptIv16);
            return config;
        }
    }
}
