package com.lsm.alllibrary;

import android.app.Application;

import com.dianping.logan.LoganConfig;
import com.lsm.ironmanlog.IronManLog;
import com.lsm.ironmanlog.IronManLogConfig;

import java.io.File;

/**
 * <p>
 *
 * </p>
 *
 * @author shiming
 * @version v1.0
 * @since 2019/1/25 14:35
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //记得给与存储的权限
        IronManLogConfig config = new IronManLogConfig.Builder()
                .setContext(getApplicationContext())
                .setEncryptKey16("shiminglog123456".getBytes()) //128位ase加密Key
                .setEncryptIV16("shiminglog123456".getBytes()) //128位aes加密IV
                .setCacheFolder("alllib_log")//这是Logan正在缓存在本地文件夹的名称
                .build();
        //由于文件是加密的，如果需要自己解密然后上传到后台的话，那么这里就需要一个文件夹的名称
        IronManLogConfig.mUploadFolderName ="demo";
        //由于文件是加密的，如果需要自己解密然后上传到后台的话，那么这里就需要一个文件的名称
        IronManLogConfig.mUploadFileName ="demo.log";
        IronManLog.init(config,BuildConfig.DEBUG,true);


    }
}
