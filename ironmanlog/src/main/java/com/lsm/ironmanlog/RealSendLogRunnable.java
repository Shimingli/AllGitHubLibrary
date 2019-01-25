package com.lsm.ironmanlog;

import android.util.Log;

import com.dianping.logan.SendLogRunnable;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import timber.log.Timber;

/**
 * <p>
 *
 * </p>
 *
 * @author shiming
 * @version v1.0
 * @since 2019/1/25 11:29
 */

public class RealSendLogRunnable extends SendLogRunnable {

    private static final String TAG = "RealSendLogRunnable";
    //此文件就是已经解密了的文件
    private final File mCopyFile;
    private final IronManLog.OnDecryptFileLisenter mMlistener;
    //需要删除解密后的文件 默认是删除掉的
    private boolean mNeedDeleteCopyFile = true;
    //需要回调打印日志不，如果不需要，可以节约好多的性能
    private boolean mNeedShowLogMsg;

    public RealSendLogRunnable(IronManLog.OnDecryptFileLisenter listener) {
        mCopyFile = FileUtils.createFile(FileNameConfig.HOME_LOG_FOLDER);
        mMlistener = listener;
    }

    @Override
    public void sendLog(File logFile) {
        LoganParser loganParser = new LoganParser(IronManLogConfig.mEncryptKey16, IronManLogConfig.mEncryptIv16);
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            fileInputStream = new FileInputStream(logFile);
            Log.v(TAG,"创建文件目录 %s"+mCopyFile.toString());
            fileOutputStream = new FileOutputStream(mCopyFile);
            loganParser.parse(fileInputStream, fileOutputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (mNeedShowLogMsg) {
                try {
                    BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(mCopyFile)));
                    String temp = null;
                    while ((temp = reader.readLine()) != null) {
                        if (mMlistener != null) {
                            mMlistener.readLineMsg(temp);
                        }
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (mNeedDeleteCopyFile) {
                mCopyFile.delete();
            }
        }
    }

    public void setNeedDeleteCopyFile(boolean needDeleteCopyFile) {
        mNeedDeleteCopyFile = needDeleteCopyFile;
    }

    public void setNeedShowLogMsg(boolean needShowLogMsg) {
        mNeedShowLogMsg = needShowLogMsg;
    }
}
