package com.example.animatedemo.frameanimation;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Icon;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.animatedemo.R;

public class FrameAnimationByXML extends Activity implements View.OnClickListener{

    private Button mStart;
    private Button mStop;
    private ImageView mImageView;
    private AnimationDrawable mAnimationDrawable;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frameanimation_layout);
        initViews();
    }

    private void initViews() {
        mStart = findViewById(R.id.frameanimation_start_btn);
        mStart.setOnClickListener(this);
        
        mStop = findViewById(R.id.frameanimation_stop_btn);
        mStop.setOnClickListener(this);
        
        mImageView = findViewById(R.id.frameanimation_iv);
        //mAnimationDrawable = (AnimationDrawable) getResources().getDrawable(R.drawable.frame_animation_by_xml);
        //mImageView.setBackground(mAnimationDrawable);
        mImageView.setImageResource(R.drawable.frame_animation_by_xml);
        //mImageView.setImageIcon(Icon.createWithResource(this, R.drawable.frame_animation_by_xml));

    }

    @Override
    protected void onResume() {
        super.onResume();
//        mAnimationDrawable = (AnimationDrawable) mImageView.getBackground();
        mAnimationDrawable = (AnimationDrawable) mImageView.getDrawable();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.frameanimation_start_btn:
                startFrame();
                break;
            case R.id.frameanimation_stop_btn:
                stopFrame();
                break;
        }
    }

    private void stopFrame() {
        Log.e("aaa", "stopFrame()");
        mAnimationDrawable.stop();
    }

    private void startFrame() {
        Log.e("aaa", "startFrame()");
        mAnimationDrawable.start();
    }
}
