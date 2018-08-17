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
public class LoctionFragment extends Fragment {

    private int resId = R.drawable.bg_loc;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.loc_fragment, container, false);
        rootView.setBackgroundResource(resId);

        rootView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (resId) {
                    case R.drawable.bg_loc:
                        resId = R.drawable.bg_his;
                        v.setBackgroundResource(resId);
                        break;
                    case R.drawable.bg_his:
                        resId = R.drawable.bg_ele;
                        v.setBackgroundResource(resId);
                        break;
                    case R.drawable.bg_ele:
                        resId = R.drawable.bg_loc;
                        v.setBackgroundResource(resId);
                        break;
                }
                return false;
            }
        });

        return rootView;
    }

}
