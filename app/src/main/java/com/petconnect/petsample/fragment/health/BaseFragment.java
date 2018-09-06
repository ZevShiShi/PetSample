package com.petconnect.petsample.fragment.health;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.request.RequestOptions;
import com.petconnect.petsample.R;

/**
 * @author zev
 * @time 2018/8/9 14:21.
 */
public class BaseFragment extends Fragment {

    private ImageView ivBg;
    public boolean isTouch;

    private int mLoadPicRes = 0;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.health_gif_fragment_item, container, false);
        ivBg = rootView.findViewById(R.id.iv_bg);
//        ivBg.setClickable(true);
        return rootView;
    }

    protected void setupPicOrGif(final int loadPicRes, final int loadGifRes) {
        mLoadPicRes = loadPicRes;

//        RequestOptions options = new RequestOptions()
//                .placeholder(loadPicRes)
//                .encodeFormat(Bitmap.CompressFormat.PNG)
//                .format(DecodeFormat.PREFER_ARGB_8888)
//                .priority(Priority.LOW)
//                .skipMemoryCache(true)
//                .diskCacheStrategy(DiskCacheStrategy.NONE)
//                .centerInside()
//                .error(loadPicRes);
//
//
//        Glide.with(getActivity())
//                .asGif()
//                .load(loadGifRes)
//                .apply(options)
//                .into(ivBg);
//
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                stopGif();
//            }
//        }, 3000);
        Glide.with(getActivity()).load(loadPicRes).into(ivBg);
        ivBg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RequestOptions options = new RequestOptions()
                        .placeholder(loadPicRes)
                        .error(loadPicRes);
                if (!isTouch) {
                    isTouch = true;
                    Glide.with(getActivity())
                            .asGif()
                            .load(loadGifRes)
                            .apply(options)
                            .into(ivBg);
                } else {
                    isTouch = false;
                    Glide.with(getActivity())
                            .load(loadPicRes)
                            .apply(options)
                            .into(ivBg);
                }
            }
        });
    }


    public void stopGif() {
        if (mLoadPicRes != 0 && isTouch) {
            RequestOptions options = new RequestOptions()
                    .placeholder(mLoadPicRes)
                    .centerInside()
                    .priority(Priority.LOW)
//                    .skipMemoryCache(true)
//                    .diskCacheStrategy(DiskCacheStrategy.NONE)
                    .error(mLoadPicRes);
            Glide.with(getActivity())
                    .load(mLoadPicRes)
                    .apply(options)
                    .into(ivBg);
        }
    }

}
