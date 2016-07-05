package com.example.myfirstgame;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.*;
import android.widget.Button;

public class MenuActivity extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setVolumeControlStream(AudioManager.STREAM_MUSIC);
	    requestWindowFeature(Window.FEATURE_NO_TITLE);
	    getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
	    setContentView(R.layout.menu);
	    
	    Button button1 = (Button)findViewById(R.id.button1);
	    button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent i = new Intent(MenuActivity.this,Explain1.class);
				startActivity(i);
				
			}
		});
	    
	    Button button2 = (Button)findViewById(R.id.button2);
	    button2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent i = new Intent(MenuActivity.this,GameActivity.class);
				i.putExtra("stage",2);
				startActivity(i);
				
			}
		});
	
	    
	    Button button3 = (Button)findViewById(R.id.button3);
	    button3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent i = new Intent(MenuActivity.this,GameActivity.class);
				i.putExtra("stage",3);
				startActivity(i);
				
			}
		});
	    
	    Button button4 = (Button)findViewById(R.id.button4);
	    button4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent i = new Intent(MenuActivity.this,GameActivity.class);
				i.putExtra("stage",4);
				startActivity(i);
				
			}
		});
	    
	    Button button5 = (Button)findViewById(R.id.button5);
	    button5.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent i = new Intent(MenuActivity.this,GameActivity.class);
				i.putExtra("stage",5);
				startActivity(i);
				
			}
		});
	    
	    Button button6 = (Button)findViewById(R.id.button6);
	    button6.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent i = new Intent(MenuActivity.this,GameActivity.class);
				i.putExtra("stage",6);
				startActivity(i);
				
			}
		});
	    
	    Button button7 = (Button)findViewById(R.id.button7);
	    button7.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent i = new Intent(MenuActivity.this,GameActivity.class);
				i.putExtra("stage",7);
				startActivity(i);
				
			}
		});
	    
	    Button button8 = (Button)findViewById(R.id.button8);
	    button8.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent i = new Intent(MenuActivity.this,GameActivity.class);
				i.putExtra("stage",8);
				startActivity(i);
				
			}
		});
	    
	    Button button9 = (Button)findViewById(R.id.button9);
	    button9.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent i = new Intent(MenuActivity.this,GameActivity.class);
				i.putExtra("stage",9);
				startActivity(i);
				
			}
		});
	}
}