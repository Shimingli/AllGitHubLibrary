package com.lsm.ironmanlog;

import java.io.File;

/**
 * <p>
 *
 * </p>
 *
 * @author shiming
 * @version v1.0
 * @since 2019/1/25 11:07
 */

public class FileUtils {

    /**
     * 创建目录
     *
     * @param path  目录
     * @param cover 是否覆盖
     * @return
     */
    public static void createFolder(String path, boolean cover) {
        try {
            File file = new File(path);
            if (file.exists()) {
                if (cover) {
                    FileUtils.deleteFile(path, true);
                    file.mkdirs();
                }
            } else {
                file.mkdirs();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 删除文件
     *
     * @param filePath
     * @param deleteParent 是否删除父目录
     */
    public static void deleteFile(String filePath, boolean deleteParent) {
        if (filePath == null) {
            return;
        }
        try {
            File f = new File(filePath);
            if (f.exists() && f.isDirectory()) {
                File[] delFiles = f.listFiles();
                if (delFiles != null) {
                    for (File delFile : delFiles) {
                        deleteFile(delFile.getAbsolutePath(), deleteParent);
                    }
                }
            }
            if (deleteParent) {
                f.delete();
            } else if (f.isFile()) {
                f.delete();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
