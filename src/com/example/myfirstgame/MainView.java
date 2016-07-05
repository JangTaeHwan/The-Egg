package com.example.myfirstgame;

import java.io.BufferedInputStream;

import android.view.KeyEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.SoundPool;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.util.Log;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class MainView extends SurfaceView implements SurfaceHolder.Callback{
	
	private GameActivity gameActivity;
	MainThread mainThread;
	private Context mMainContext;
	private ScreenConfig mScreenConfig;
	boolean drawCls = false;
	private MyPrisoner mMyPrisoner;
	private Map mMap;
	private Enemy mEnemy;
	private Weapon mWeapon;
	private int stage;
	private Bitmap mDirectionKey;
	private Bitmap mBg;
	public SoundPool sound_pool;
	public int sound_beep;
	public int sound_next;
	public int sound_drip;
	public int sound_boom;
	
	public MainView(Context r, AttributeSet a){
		super(r,a);
		getHolder().addCallback(this);
		mainThread = new MainThread(getHolder(),this);
		setFocusable(true);
		mMainContext = r;
	}
	
	private void initSound(){
		sound_pool = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
		sound_boom = sound_pool.load(getContext(), R.raw.boom,1);
		sound_beep = sound_pool.load(getContext(), R.raw.beep,1);
		sound_next = sound_pool.load(getContext(), R.raw.next,1);
		sound_drip = sound_pool.load(getContext(), R.raw.drip,1);
	}
	public void playsoundBoom(){
		sound_pool.play(sound_boom,	1f, 1f, 0, 0, 1f);
	}
	public void playsoundBeep(){
		sound_pool.play(sound_beep,	1f, 1f, 0, 0, 1f);
	}
	public void playsoundNext(){
		sound_pool.play(sound_next,	1f, 1f, 0, 0, 1f);
	}
	public void playsoundDrip(){
		sound_pool.play(sound_drip,	1f, 1f, 0, 0, 1f);
	}
	
	public void init(int Stage,int width,int height, GameActivity gameActivity){
		this.gameActivity = gameActivity;
		mScreenConfig = new ScreenConfig(width,height);
		mScreenConfig.setSize(2000,1000);
		stage = Stage;
		try{
			initSound();
			
			Bitmap mMyBitmap1 = loadBitmap("Egg1.png");
			Bitmap mMyBitmap2 = loadBitmap("Egg2.png");
			Bitmap mMyBitmap3 = loadBitmap("Egg3.png");
			Bitmap mMyBitmap4 = loadBitmap("Egg4.png");
			Bitmap mMyBitmap5 = loadBitmap("Egg5.png");
			Bitmap mMyBitmap6 = loadBitmap("Egg6.png");
			Bitmap mMyBitmap7 = loadBitmap("Egg7.png");
			Bitmap mMyBitmap8 = loadBitmap("Egg8.png");
			Bitmap mMyBitmap9 = loadBitmap("Egg9.png");
			Bitmap mMyBitmap10 = loadBitmap("Egg10.png");
			Bitmap mMyBitmapEC1 = loadBitmap("Eggcrash1.png");
			Bitmap mMyBitmapEC2 = loadBitmap("Eggcrash2.png");
			Bitmap mMyBitmapEC3 = loadBitmap("Eggcrash3.png");
			Bitmap mMyBitmapEC4 = loadBitmap("Eggcrash4.png");
			Bitmap mMyBitmapEB = loadBitmap("Eggburn.png");
			mMyPrisoner = new MyPrisoner(mScreenConfig, mMyBitmap1, mMyBitmap2, mMyBitmap3, mMyBitmap4, mMyBitmap5, mMyBitmap6, mMyBitmap7, mMyBitmap8,
										mMyBitmap9, mMyBitmap10, mMyBitmapEC1, mMyBitmapEC2, mMyBitmapEC3, mMyBitmapEC4, mMyBitmapEB);
			mMyPrisoner.move(150, 850);
			
			
			Bitmap mMyBitmap11 = loadBitmap("bomb1.png");
			Bitmap mMyBitmap12 = loadBitmap("bomb2.png");
			Bitmap mMyBitmap13 = loadBitmap("boom1.png");
			Bitmap mMyBitmap14 = loadBitmap("boom2.png");
			Bitmap mMyBitmap15 = loadBitmap("boom3.png");
			Bitmap mMyBitmap16 = loadBitmap("boom4.png");
			Bitmap mMyBitmap17 = loadBitmap("boom5.png");
			mEnemy = new Enemy(mScreenConfig, mMyBitmap11, mMyBitmap12, mMyBitmap13, 
							mMyBitmap14, mMyBitmap15, mMyBitmap16, mMyBitmap17, stage);
			
			Bitmap mMyBitmap18 = loadBitmap("key.png");
			Bitmap mMyBitmap19 = loadBitmap("block.png");
			Bitmap mMyBitmap20 = loadBitmap("gate.png");
			Bitmap mMyBitmapC1 = loadBitmap("crash1.png");
			Bitmap mMyBitmapC2 = loadBitmap("crash2.png");
			Bitmap mMyBitmapC3 = loadBitmap("crash3.png");
			mMap = new Map(mScreenConfig, mMyBitmap18, mMyBitmap19, mMyBitmap20, mMyBitmapC1, mMyBitmapC2, mMyBitmapC3,stage);
			
			Bitmap mMyBitmap21 = loadBitmap("trap.png");
			mWeapon = new Weapon(mScreenConfig, mMyBitmap21, stage);
			
			Bitmap mMyBitmap22 = loadBitmap("directionKey.png");
			mDirectionKey = Bitmap.createScaledBitmap(mMyBitmap22, mScreenConfig.getX(500), mScreenConfig.getY(400), false);
			
			Bitmap mMyBitmap23 = loadBitmap("bg.png");
			mBg = Bitmap.createScaledBitmap(mMyBitmap23, gameActivity.ScreenWidth, gameActivity.ScreenHeight, false);

			drawCls = true;
		}
		catch(Exception e){
			Log.e("tag","init error");
		}
		drawCls = true;
		mMap.stageset();
		mEnemy.stageset();
		
	}
	
	public Bitmap loadBitmap(String filename) throws Exception{
		Bitmap bm;
		AssetManager am = mMainContext.getAssets();       																		
		BufferedInputStream buf = new BufferedInputStream(am.open(filename));													
		bm = BitmapFactory.decodeStream(buf);
		return bm;
	}
	
	@Override
	public void onDraw(Canvas canvas){
		if(drawCls == false)
			return;
		canvas.drawBitmap(mBg, 0, 0, null);
		walk();
		mWeapon.draw(canvas);
		mEnemy.ban(mMap.mBlocknum, mMap.mBlockX, mMap.mBlockY, mMap.mBlockOn);
		mEnemy.EnemyCurve();
		mEnemy.EnemyMove();
		mEnemy.draw(canvas);
		mEnemy.boom(mWeapon.wTrapnum, mWeapon.wTrapX, mWeapon.wTrapY, mWeapon.wTrapOn, canvas);
		if(mEnemy.eBoomsum>=1&&mEnemy.eBoomsum<=2)
			playsoundBoom();
		mMyPrisoner.draw(canvas);
		mMyPrisoner.crash(mEnemy.eBombnum,mEnemy.eBombX, mEnemy.eBombY, mEnemy.eBombOn, canvas);
		mMap.draw(canvas);
		mMap.crash(mWeapon.wTrapnum, mWeapon.wTrapX, mWeapon.wTrapY, mWeapon.wTrapOn, canvas);
		mMap.act(mMyPrisoner.mX, mMyPrisoner.mY);
		canvas.drawBitmap(mDirectionKey, (int)(mScreenConfig.getX(0)),(int)(mScreenConfig.getY(600)),null);
		
		if(mMap.mReset==true){
			stage++;
			try{
				playsoundNext();
				init(stage,gameActivity.ScreenWidth,gameActivity.ScreenHeight,gameActivity);
			}
			catch(Exception e){}
		}
		
		if(mMyPrisoner.EggReset==true){
			try{
				playsoundBeep();
				init(stage,gameActivity.ScreenWidth,gameActivity.ScreenHeight,gameActivity);
			}
			catch(Exception e){}
		}
	}
	
	int mPointerId = -1;
	public boolean moveOn=false;
	public float x,y;
	@Override
	public boolean onTouchEvent(MotionEvent event){
		if(drawCls==true){
			mPointerId = event.getPointerCount();
			final int action = event.getAction();
			switch(action & MotionEvent.ACTION_MASK){
			case MotionEvent.ACTION_DOWN:{
				if(mPointerId==1){
					x = event.getX(0);
					y = event.getY(0);
				}
				if(mScreenConfig.getX(1500)<=x&&x<=mScreenConfig.getX(2000)){
					if(mScreenConfig.getY(600)<=y&&y<=mScreenConfig.getY(1000)){
						mWeapon.trapon(mMyPrisoner.mX, mMyPrisoner.mY);
						playsoundDrip();
					}
				}
				moveOn = true;
				break;
			}
			
			case MotionEvent.ACTION_MOVE:{
				if(mPointerId==1){
					x = event.getX(0);
					y = event.getY(0);
				}
				moveOn = true;
				break;
			}
			
			case MotionEvent.ACTION_UP:{
				if(mPointerId==1){
					x = event.getX(0);
					y = event.getY(0);
				}
				moveOn = false;
				break;
			}
				
			case MotionEvent.ACTION_CANCEL:{
				if(mPointerId==1){
					x = event.getX(0);
					y = event.getY(0);
				}
				moveOn = false;
				break;
			}
		  }
		}
		return true;
	}
	
	//prison walk 터치 범위
	public void walk(){
		mMap.gateban(mMyPrisoner.mX, mMyPrisoner.mY);
		mMap.ban(mMyPrisoner.mX, mMyPrisoner.mY);
		mWeapon.ban(mMyPrisoner.mX, mMyPrisoner.mY);
			if(mScreenConfig.getX(0)<=x&&x<=mScreenConfig.getX(500)){
				if(mScreenConfig.getY(750)<=y&&y<=mScreenConfig.getY(850)){
					if(x<=mScreenConfig.getX(200)){
						if(mMap.LB==false&&mWeapon.LB==false){
							mMyPrisoner.walking(0,moveOn);
						}
						if(mMap.LU||mWeapon.LU){
							mMyPrisoner.walking(2,moveOn);
						}
						if(mMap.LD||mWeapon.LD){
							mMyPrisoner.walking(3,moveOn);
						}
					}
					
					if(x>mScreenConfig.getX(300)){
						if(mMap.RB==false&&mWeapon.RB==false){
							mMyPrisoner.walking(1,moveOn);
						}
						if(mMap.RU||mWeapon.RU){
							mMyPrisoner.walking(2,moveOn);
						}
						if(mMap.RD||mWeapon.RD){
							mMyPrisoner.walking(3,moveOn);
						}
					}
				}
			}
			
			if(mScreenConfig.getX(100)<=x&&x<=mScreenConfig.getX(400)){
				if(mScreenConfig.getY(600)<=y&&y<=mScreenConfig.getY(1000)){
					if(y<=mScreenConfig.getY(750)){
						if(mMap.UB==false&&mWeapon.UB==false){
							mMyPrisoner.walking(2,moveOn);	
						}
						if(mMap.UR||mWeapon.UR){
							mMyPrisoner.walking(1,moveOn);
						}
						if(mMap.UL||mWeapon.UL){
							mMyPrisoner.walking(0,moveOn);
						}
					}
					
					if(y>mScreenConfig.getY(850)){
						if(mMap.DB==false&&mWeapon.DB==false){
							mMyPrisoner.walking(3,moveOn);
						}
						if(mMap.DR||mWeapon.DR){
							mMyPrisoner.walking(1,moveOn);
						}
						if(mMap.DL||mWeapon.DL){
							mMyPrisoner.walking(0,moveOn);
						}
					}
				}
			}
	}

	//        //
	public void surfaceChanged(SurfaceHolder holder,int format, int width, int height){}
	
	public void surfaceCreated(SurfaceHolder holder){
		mainThread.setRunning(true);
		try{
			if(mainThread.getState()==Thread.State.TERMINATED){
				mainThread = new MainThread(getHolder(),this);
				mainThread.setRunning(true);
				setFocusable(true);
				mainThread.start();
			}
			else{
				mainThread.start();
			}
		}
		catch(Exception ex){
		}
	}
	
	public void surfaceDestroyed(SurfaceHolder holder){
		boolean retry=true;
		mainThread.setRunning(false);
		while(retry){
			try{
				mainThread.join();
				retry = false;
			}
			catch(Exception e){
				Log.i("MainView","surfaceDestoryed ex"+e.toString());
			}
		}
		
	}


}
	