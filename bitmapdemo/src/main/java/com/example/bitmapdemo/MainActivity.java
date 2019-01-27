package com.example.bitmapdemo;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Shader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity {
    private Bitmap mBitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBitmap = Bitmap.createBitmap(50, 50, Bitmap.Config.ARGB_8888);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("BitmapDemo", "onStart");


    }

    @Override
    protected void onResume() {
        Log.e("BitmapDemo", "onResume");
        super.onResume();
        Canvas mCanvas = new Canvas();
        Paint mPaint = new Paint();
        BitmapShader mShader = new BitmapShader(mBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        //mPaint.setColor(Color.BLACK);
        mPaint.setShader(mShader);
        mBitmap.getWidth();

        //mBitmap.setPixel(50, 50, Color.YELLOW);
        //mCanvas.drawBitmap(mBitmap, 0, 0, mPaint);
        mCanvas.drawOval(0,0,50,50,mPaint);

    }

    @Override
    protected void onPause() {
        Log.e("BitmapDemo", "onPause");
        super.onPause();
        mBitmap.recycle();
    }
}
