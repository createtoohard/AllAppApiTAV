package com.example.animatedemo;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.animatedemo.frameanimation.FrameAnimationByXML;

public class MainActivity extends Activity implements ListView.OnItemClickListener{

    private Button mButtonl;
    private ListView mListView;
    private int TranslactionX = 0;
    private int TranslactionY = 1;
    private boolean back = false;
    private Button mButtona;
    private Button mButtond;


    String[] type = new String[]{"start", "back"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startFrameAnimationActivity();

    }

    @Override
    protected void onResume() {
        super.onResume();
        mButtonl = findViewById(R.id.view_for_animate_l);
        mButtona = findViewById(R.id.view_for_animate_a);
        mButtond = findViewById(R.id.view_for_animate_d);
        mListView = findViewById(R.id.list_view);
        ArrayAdapter<String> myAdapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, type);

        mListView.setOnItemClickListener(this);
        mListView.setAdapter(myAdapter);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Log.e("test", "position = " + position);
        switch (position) {
            case 0:
                mButtonl.animate().translationX(500).setDuration(3000).setInterpolator(new LinearInterpolator());
                mButtona.animate().translationX(500).setDuration(3000).setInterpolator(new AccelerateInterpolator());
                mButtond.animate().translationX(500).setDuration(3000).setInterpolator(new DecelerateInterpolator());
                break;

            case 1:
                //super.onResume();
                mButtonl.animate().translationX(0).setDuration(3000).setInterpolator(new LinearInterpolator());
                mButtona.animate().translationX(0).setDuration(3000).setInterpolator(new AccelerateInterpolator());
                mButtond.animate().translationX(0).setDuration(3000).setInterpolator(new DecelerateInterpolator());
                break;

        }
    }

    private void startFrameAnimationActivity() {
        Intent mIntent = new Intent();
        //ComponentName mComponentName = new ComponentName("com.example.animatedemo.frameanimation","FrameAnimationByXML");
        ComponentName mComponentName = new ComponentName(this,FrameAnimationByXML.class);
        mIntent.setComponent(mComponentName);
        startActivity(mIntent);
    }



}
