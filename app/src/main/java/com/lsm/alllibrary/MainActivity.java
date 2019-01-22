package com.lsm.alllibrary;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


import com.lsm.rxbuslibrary.ExtendEvents;
import com.lsm.rxbuslibrary.ExtendSyncRxBus;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * 这是我生成libraty的地方
 */
public class MainActivity extends AppCompatActivity {

    private TextView mDes;

    @SuppressLint("CheckResult")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_new_extend_events).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,NewExtendEventsActivity.class));
            }
        });
        mDes = findViewById(R.id.tv_msg_events);
        ExtendSyncRxBus.getInstance().toObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
//                .compose(this.<ExtendEvents>bindUntilEvent(ActivityEvent.DESTROY))
                .subscribe(new Consumer<ExtendEvents>() {
                    @Override
                    public void accept(ExtendEvents extendEvents) throws Exception {
                        mDes.setText(extendEvents.getCode()+(String)extendEvents.getContent());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });
    }
}
