package com.petconnect.petsample;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.petconnect.petsample.entity.TabEntity;
import com.petconnect.petsample.fragment.CommFragment;
import com.petconnect.petsample.fragment.HealthFragment;
import com.petconnect.petsample.fragment.HealthGifFragment;
import com.petconnect.petsample.fragment.LoctionFragment;
import com.petconnect.petsample.fragment.PhotoFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private CommonTabLayout mTabLayout;


    // 底部未选中图标
    private int[] mIconUnselectIds = {
            R.drawable.ic_health_unselect, R.drawable.ic_loc_unselect, R.drawable.ic_album_unselect,
            R.drawable.ic_comm_unselect};
    // 底部已选中图标
    private int[] mIconSelectIds = {
            R.drawable.ic_health_selected,
            R.drawable.ic_loc_selected,
            R.drawable.ic_album_selected,
            R.drawable.ic_comm_selected};


    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        boolean type = getIntent().getBooleanExtra(BootActivity.BOOT_TYPE, false);

        mTabLayout = findViewById(R.id.main_BottomBar);
        final ArrayList<Fragment> fragmentList = new ArrayList<>();
        if (type) {
            fragmentList.add(new HealthFragment());
        } else {
            fragmentList.add(new HealthGifFragment());
        }

        fragmentList.add(new LoctionFragment());
        fragmentList.add(new PhotoFragment());
        fragmentList.add(new CommFragment());

        // 首页tab title
        String[] titles = new String[]{getString(R.string.tab_health)
                , getString(R.string.tab_health_loc)
                , getString(R.string.tab_photo),
                getString(R.string.tab_momment)};
        // 封装tab标题，已选未选图标
        for (int i = 0; i < titles.length; i++) {
            mTabEntities.add(new TabEntity(titles[i], mIconSelectIds[i], mIconUnselectIds[i]));
        }
        mTabLayout.setTabData(mTabEntities, this, R.id.main_frame, fragmentList);

        mTabLayout.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                }
                if (fragmentList.get(position) instanceof PhotoFragment) {
                    PhotoFragment pf = (PhotoFragment) fragmentList.get(position);
                    if (pf.getResId() == R.drawable.bg_video_record1
                            || pf.getResId() == R.drawable.bg_video_record2
                            || pf.getResId() == R.drawable.bg_video_record3
                            || pf.getResId() == R.drawable.bg_live_stream) {
                        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
                    }
                }
                mTabLayout.setCurrentTab(position);
            }

            @Override
            public void onTabReselect(int position) {

            }
        });
    }
}
