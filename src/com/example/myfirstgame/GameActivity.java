package com.example.myfirstgame;

import android.media.AudioManager;
import android.os.Bundle;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.Intent;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Window;
import android.view.WindowManager;

public class GameActivity extends Activity {
	public int ScreenWidth;
	public int ScreenHeight;
	MainView mainView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setVolumeControlStream(AudioManager.STREAM_MUSIC);
		requestWindowFeature(Window.FEATURE_NO_TITLE);																	// 타이틀바 제거
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);	// 상단바 제거
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);											// 화면 항상 켜짐
				
		Intent intent = getIntent();
		int stage = intent.getIntExtra("stage", 1);
		setContentView(R.layout.main);
		ScreenWidth = getWindowManager().getDefaultDisplay().getWidth();
		ScreenHeight = getWindowManager().getDefaultDisplay().getHeight();
		
		mainView = (MainView) findViewById (R.id.main_view);
		mainView.init(stage,ScreenWidth,ScreenHeight,this);

	}
	
	public boolean onKeyDown( int KeyCode, KeyEvent event ){
		if( event.getAction() == KeyEvent.ACTION_DOWN ){
			if( KeyCode == KeyEvent.KEYCODE_BACK ){
				Intent finishBroadcastIntent = new Intent("com.example.myfirstgame.FINISH");
				sendBroadcast(finishBroadcastIntent);
				finish();
				return true;
				}
			}
		return super.onKeyDown( KeyCode, event );
	}
	
}
