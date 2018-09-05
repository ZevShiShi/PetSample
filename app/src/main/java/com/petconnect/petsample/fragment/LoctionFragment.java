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

    private int resId = R.drawable.bg_loc_livetracking;

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
                    case R.drawable.bg_loc_livetracking:
                        resId = R.drawable.bg_loc_breadcrumb;
                        break;
                    case R.drawable.bg_loc_breadcrumb:
                        resId = R.drawable.bg_loc_fence;
                        break;
                    case R.drawable.bg_loc_fence:
                        resId = R.drawable.bg_loc_livetracking;
                        break;
                }
                v.setBackgroundResource(resId);
                return false;
            }
        });

        return rootView;
    }

}
