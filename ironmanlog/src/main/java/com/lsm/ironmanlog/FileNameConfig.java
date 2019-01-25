package com.lsm.ironmanlog;

import android.os.Environment;

import java.io.File;

/**
 * @author shiming
 * @date 2016/11/15
 */
public class FileNameConfig {

    //获取
    public static final String ROOT_DIR = Environment.getExternalStorageDirectory().toString();

    /**
     * 这是上传文件的主目录
     */
    public static final String HOME_FOLDER = ROOT_DIR + File.separator + IronManLogConfig.mUploadFolderName;

    /**
     * 这是上传文件log文件名称
     */
    public static final String HOME_LOG_FOLDER = HOME_FOLDER + File.separator + IronManLogConfig.mUploadFileName;


    public static void initFolder() {
        FileUtils.createFolder(HOME_FOLDER, false);
        FileUtils.createFolder(HOME_LOG_FOLDER, false);
    }

}
