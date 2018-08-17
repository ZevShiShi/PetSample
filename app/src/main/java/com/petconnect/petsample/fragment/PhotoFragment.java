package com.petconnect.petsample.fragment;

import android.content.pm.ActivityInfo;
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
public class PhotoFragment extends Fragment {

    private int resId;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.photo_fragment, container, false);
        resId = R.drawable.bg_private_albums;
        rootView.setBackgroundResource(resId);
        rootView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (resId) {
                    case R.drawable.bg_private_albums:
                        resId = R.drawable.bg_public_albums;
                        break;
                    case R.drawable.bg_public_albums:
                        resId = R.drawable.bg_story_line;
                        break;
                    case R.drawable.bg_story_line:
                        getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
                        resId = R.drawable.bg_video_record1;
                        break;
                    case R.drawable.bg_video_record1:
                        resId = R.drawable.bg_video_record2;
                        break;
                    case R.drawable.bg_video_record2:
                        resId = R.drawable.bg_video_record3;
                        break;
                    case R.drawable.bg_video_record3:
                        getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                        resId = R.drawable.bg_private_albums;
                        break;
                }
                v.setBackgroundResource(resId);
                return false;
            }
        });
        return rootView;
    }


    public int getResId() {
        return resId;
    }

}
