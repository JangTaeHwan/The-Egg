package com.example.myfirstgame;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.*;
import android.widget.ImageView;

public class IntroActivity extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setVolumeControlStream(AudioManager.STREAM_MUSIC);
	    requestWindowFeature(Window.FEATURE_NO_TITLE);
	    getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
	    setContentView(R.layout.intro);
	    
	    int ScreenWidth = getWindowManager().getDefaultDisplay().getWidth();
	    int ScreenHeight = getWindowManager().getDefaultDisplay().getHeight();
	    
	    ImageView InitImage = (ImageView)findViewById(R.id.ImgvInit);
	    Bitmap image = BitmapFactory.decodeResource(getResources(),R.drawable.back);
	    Bitmap resized = Bitmap.createScaledBitmap(image, ScreenWidth, ScreenHeight, true);
	    InitImage.setImageBitmap(resized);
	    InitImage.setPadding(0, 0, 0, 0);
	    InitImage.setOnTouchListener(new View.OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				Intent i = new Intent(IntroActivity.this,MenuActivity.class);
				startActivity(i);
				return false;
			}
		});
	}
}
