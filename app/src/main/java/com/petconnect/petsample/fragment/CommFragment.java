package com.petconnect.petsample.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.petconnect.petsample.R;

/**
 * describe
 *
 * @author zev
 * @time 2018/8/9 14:21.
 */
public class CommFragment extends Fragment {

    private int resId;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.comm_fragment, container, false);
        resId = R.drawable.bg_comm_news;
        rootView.setBackgroundResource(resId);
        rootView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (resId) {
                    case R.drawable.bg_comm_news:
                        resId = R.drawable.bg_comm_pages;
                        break;
                    case R.drawable.bg_comm_pages:
                        resId = R.drawable.bg_comm_notify;
                        break;
                    case R.drawable.bg_comm_notify:
                        resId = R.drawable.bg_comm_news;
                        break;
                }
                v.setBackgroundResource(resId);
                return false;
            }

        });
        return rootView;
    }

}
