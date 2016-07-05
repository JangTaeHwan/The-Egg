package com.example.myfirstgame;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.*;
import android.widget.ImageView;

public class Explain3 extends Activity {
	
	private BroadcastReceiver finishedReceiver = new BroadcastReceiver(){
		@Override
		public void onReceive(Context context, Intent intent){
			Explain3.this.finish();
		}
	};
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setVolumeControlStream(AudioManager.STREAM_MUSIC);
	    requestWindowFeature(Window.FEATURE_NO_TITLE);
	    getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
	    setContentView(R.layout.explain3);
	    
	    int ScreenWidth = getWindowManager().getDefaultDisplay().getWidth();
	    int ScreenHeight = getWindowManager().getDefaultDisplay().getHeight();
	    
	    ImageView InitImage = (ImageView)findViewById(R.id.explain13);
	    Bitmap image = BitmapFactory.decodeResource(getResources(),R.drawable.ex3);
	    Bitmap resized = Bitmap.createScaledBitmap(image, ScreenWidth, ScreenHeight, true);
	    InitImage.setImageBitmap(resized);
	    InitImage.setPadding(0, 0, 0, 0);
	    InitImage.setOnTouchListener(new View.OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				Intent i = new Intent(Explain3.this,Explain4.class);
				startActivity(i);
				return false;
			}
		});
	    registerFinishedReceiver();
	}
	
	protected void onDestroy(){
		unregisterFinishedReceiver();
		super.onDestroy();
	}
	
	private void registerFinishedReceiver(){
		IntentFilter filter = new IntentFilter("com.example.myfirstgame.FINISH");
		registerReceiver(finishedReceiver,filter);
	}
	
	private void unregisterFinishedReceiver(){
		unregisterReceiver(finishedReceiver);
	}
}