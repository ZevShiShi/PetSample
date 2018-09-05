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
public class HealthFragment extends Fragment {

    private int resId;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.health_fragment, container, false);
        resId = R.drawable.bg_heart_month;
        rootView.setBackgroundResource(resId);

        rootView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (resId) {
                    // 心率
                    case R.drawable.bg_heart_month:
                        resId = R.drawable.bg_heart_week;
                        break;
                    case R.drawable.bg_heart_week:
                        resId = R.drawable.bg_heart_day;
                        break;
                    case R.drawable.bg_heart_day:
                        resId = R.drawable.bg_heart_hour;
                        break;
                    case R.drawable.bg_heart_hour:
                        resId = R.drawable.bg_temp_month;
                        break;
                    // 体温
                    case R.drawable.bg_temp_month:
                        resId = R.drawable.bg_temp_week;
                        break;
                    case R.drawable.bg_temp_week:
                        resId = R.drawable.bg_temp_day;
                        break;
                    case R.drawable.bg_temp_day:
                        resId = R.drawable.bg_temp_hour;
                        break;
                    case R.drawable.bg_temp_hour:
                        resId = R.drawable.bg_step_month;
                        break;
                    // 活动步数
                    case R.drawable.bg_step_month:
                        resId = R.drawable.bg_step_week;
                        break;
                    case R.drawable.bg_step_week:
                        resId = R.drawable.bg_step_day;
                        break;
                    case R.drawable.bg_step_day:
                        resId = R.drawable.bg_dist_month;
                        break;
                    // 活动距离
                    case R.drawable.bg_dist_month:
                        resId = R.drawable.bg_dist_week;
                        break;
                    case R.drawable.bg_dist_week:
                        resId = R.drawable.bg_dist_day;
                        break;
                    case R.drawable.bg_dist_day:
                        resId = R.drawable.bg_time_month;
                        break;
                    // 活动时间
                    case R.drawable.bg_time_month:
                        resId = R.drawable.bg_time_week;
                        break;
                    case R.drawable.bg_time_week:
                        resId = R.drawable.bg_time_day;
                        break;
                    case R.drawable.bg_time_day:
                        resId = R.drawable.bg_cal_month;
                        break;
                    // 活动卡路里
                    case R.drawable.bg_cal_month:
                        resId = R.drawable.bg_cal_week;
                        break;
                    case R.drawable.bg_cal_week:
                        resId = R.drawable.bg_cal_day;
                        break;
                    case R.drawable.bg_cal_day:
                        resId = R.drawable.bg_heart_month;
                        break;
                }
                v.setBackgroundResource(resId);
                return false;
            }
        });


        return rootView;

    }


}
