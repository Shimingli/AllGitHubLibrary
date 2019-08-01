package com.lsm.update.utils;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Intent;

/**
 * Created by shiming on 2016/10/26.
 */
public class ResultRequest {
    private ResultEventDispatcherFragment fragment;

    public ResultRequest(Activity activity) {
        fragment = getEventDispatchFragment(activity);
    }

    private ResultEventDispatcherFragment getEventDispatchFragment(Activity activity) {
        final FragmentManager fragmentManager = activity.getFragmentManager();

        ResultEventDispatcherFragment fragment = findEventDispatchFragment(fragmentManager);
        if (fragment == null) {
            fragment = new ResultEventDispatcherFragment();
            fragmentManager
                    .beginTransaction()
                    .add(fragment, ResultEventDispatcherFragment.TAG)
                    .commitAllowingStateLoss();
            fragmentManager.executePendingTransactions();
        }
        return fragment;
    }

    private ResultEventDispatcherFragment findEventDispatchFragment(FragmentManager manager) {
        return (ResultEventDispatcherFragment) manager.findFragmentByTag(ResultEventDispatcherFragment.TAG);
    }

    public void startForResult(Intent intent, ICallback callback) {
        fragment.startForResult(intent, callback);
    }

}
