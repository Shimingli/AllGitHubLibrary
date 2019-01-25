package com.lsm.alllibrary;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.dianping.logan.Logan;
import com.lsm.ironmanlog.IronManLog;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import timber.log.Timber;

/**
 * <p>
 *
 * </p>
 *
 * @author shiming
 * @version v1.0
 * @since 2019/1/25 14:34
 */

public class IronManLogActivity extends AppCompatActivity {

    private TextView mTvInfo;
    private TextView mIvLogMsg;
    private Button mSendBtn;
    private String TAG="IronManLogActivity";

    @SuppressLint({"CheckResult", "RxLeakedSubscription"})
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ironmanlog_layout);
        mTvInfo= findViewById(R.id.tv_file_des);

        mIvLogMsg= findViewById(R.id.tv_file_des_msg);
        mSendBtn=   findViewById(R.id.send_btn);
        IronManLog.w("你好啊！",4);
        IronManLog.w("我要好好学习 天天向上——1", 1);
        IronManLog.w("我要好好学习 天天向上——2", 2);
        IronManLog.w("我要好好学习 天天向上——3", 3);
        IronManLog.w("我要好好学习 天天向上——4", 4);
        IronManLog.f();
        mSendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                @SuppressLint("SimpleDateFormat") SimpleDateFormat dataFormat = new SimpleDateFormat("yyyy-MM-dd");
                String d = dataFormat.format(new Date(System.currentTimeMillis()));
                String[] temp = new String[1];
                temp[0] = d;
                final StringBuffer stringBuffer = new StringBuffer();
                IronManLog.setOnDecryptFile(temp, new IronManLog.OnDecryptFileLisenter() {
                    @Override
                    public void readLineMsg(String temp) {
                        Timber.tag(TAG).w(temp);
                        //子线程
                        stringBuffer.append(temp);
                    }
                },false,true);
                mIvLogMsg.setText(stringBuffer);
            }
        });
        loganFilesInfo();

    }

    private void loganFilesInfo() {
        Map<String, Long> map = IronManLog.getAllFilesInfo();
        if (map != null) {
            StringBuilder info = new StringBuilder();
            for (Map.Entry<String, Long> entry : map.entrySet()) {
                info.append("文件日期：").append(entry.getKey()).append("  文件大小（bytes）：").append(
                        entry.getValue()).append("\n");
            }
            mTvInfo.setText(info.toString());
        }
    }
}
