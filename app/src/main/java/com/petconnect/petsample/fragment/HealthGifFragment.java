package com.petconnect.petsample.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.petconnect.petsample.R;
import com.petconnect.petsample.fragment.health.BaseFragment;
import com.petconnect.petsample.fragment.health.CalDayGifFragment;
import com.petconnect.petsample.fragment.health.DistDayGifFragment;
import com.petconnect.petsample.fragment.health.HeartHourGifFragment;
import com.petconnect.petsample.fragment.health.StepDayGifFragment;
import com.petconnect.petsample.fragment.health.TempHourGifFragment;
import com.petconnect.petsample.fragment.health.TimeDayGifFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * describe
 *
 * @author zev
 * @time 2018/8/9 14:21.
 */
public class HealthGifFragment extends Fragment {

    private ViewPager viewPager;
    private HealthGifAdapter mAdapter;
    private List<Fragment> fragmentList;
    private int lastPostion;
    private boolean moveLeftOrRight; // 左滑false 右滑true

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        fragmentList = new ArrayList<>();
        fragmentList.add(new HeartHourGifFragment());
        fragmentList.add(new TempHourGifFragment());
        fragmentList.add(new StepDayGifFragment());
        fragmentList.add(new DistDayGifFragment());
        fragmentList.add(new TimeDayGifFragment());
        fragmentList.add(new CalDayGifFragment());
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.health_gif_fragment, container, false);
        viewPager = rootView.findViewById(R.id.viewPager);
        mAdapter = new HealthGifAdapter(getChildFragmentManager());
        viewPager.setAdapter(mAdapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (lastPostion > positionOffsetPixels) {
                    moveLeftOrRight = true;  // 右滑
                } else if (lastPostion < positionOffsetPixels) {
                    moveLeftOrRight = false; // 左滑
                }
                lastPostion = positionOffsetPixels;
            }

            @Override
            public void onPageSelected(int position) {
                // 左右滑动停止gif播放，减少内存消耗
                if (moveLeftOrRight) {
                    ((BaseFragment) fragmentList.get(position + 1)).stopGif();
                } else {
                    ((BaseFragment) fragmentList.get(position - 1)).stopGif();
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        return rootView;
    }


    class HealthGifAdapter extends FragmentPagerAdapter {

        public HealthGifAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }
    }

}
