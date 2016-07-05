package com.example.myfirstgame;

import android.graphics.*;

public class MyPrisoner {
	private int mWidth;
	private int mHeight;
	private Bitmap mBitmapD;
	private Bitmap mBitmapD1;
	private Bitmap mBitmapD2;
	private Bitmap mBitmapU;
	private Bitmap mBitmapU1;
	private Bitmap mBitmapU2;
	private Bitmap mBitmapR;
	private Bitmap mBitmapR1;
	private Bitmap mBitmapL;
	private Bitmap mBitmapL1;
	private Bitmap mBitmapC1;
	private Bitmap mBitmapC2;
	private Bitmap mBitmapC3;
	private Bitmap mBitmapC4;
	private Bitmap mBitmapB;
	private ScreenConfig mScreenConfig;
	public int mDirect;
	public int mDU, mDD, mDR, mDL;
	public int mDU1, mDD1, mDR1, mDL1;
	public double mX;
	public double mY;
	private boolean EggCrash1,EggCrash2;
	private boolean EggMove;
	private boolean EggOn;
	protected boolean EggReset;
	public int Eggsum1,Eggsum2;
	
	public MyPrisoner(ScreenConfig mScreenconfig, Bitmap BD ,Bitmap BD1 ,Bitmap BD2, Bitmap BU, Bitmap BU1, Bitmap BU2, Bitmap BR, Bitmap BR1,
					   Bitmap BL, Bitmap BL1, Bitmap C1, Bitmap C2, Bitmap C3, Bitmap C4, Bitmap B){
		mDirect = 3;
		mDU=mDD=mDR=mDL = 0;
		mDU1=mDD1=mDR1=mDL1 = 0;
		mScreenConfig = mScreenconfig;
		mWidth = mScreenConfig.getX(100);
		mHeight = mScreenConfig.getY(100);
		mBitmapD = Bitmap.createScaledBitmap(BD, mWidth, mHeight, false);
		mBitmapD1 = Bitmap.createScaledBitmap(BD1, mWidth, mHeight, false);
		mBitmapD2 = Bitmap.createScaledBitmap(BD2, mWidth, mHeight, false);
		mBitmapU = Bitmap.createScaledBitmap(BU, mWidth, mHeight, false);
		mBitmapU1 = Bitmap.createScaledBitmap(BU1, mWidth, mHeight, false);
		mBitmapU2 = Bitmap.createScaledBitmap(BU2, mWidth, mHeight, false);
		mBitmapR = Bitmap.createScaledBitmap(BR, mWidth, mHeight, false);
		mBitmapR1 = Bitmap.createScaledBitmap(BR1, mWidth, mHeight, false);
		mBitmapL = Bitmap.createScaledBitmap(BL, mWidth, mHeight, false);
		mBitmapL1 = Bitmap.createScaledBitmap(BL1, mWidth, mHeight, false);
		mBitmapC1 = Bitmap.createScaledBitmap(C1, mWidth, mHeight, false);
		mBitmapC2 = Bitmap.createScaledBitmap(C2, mWidth, mHeight, false);
		mBitmapC3 = Bitmap.createScaledBitmap(C3, mWidth, mHeight, false);
		mBitmapC4 = Bitmap.createScaledBitmap(C4, mWidth, mHeight, false);
		mBitmapB = Bitmap.createScaledBitmap(B, mWidth, (int)1.2*mHeight, false);
		EggMove = false;
		EggOn = true;
		EggReset = false;
		EggCrash1 = false;
		EggCrash2 = false;
		Eggsum1 = 0;
		Eggsum2 = 0;
	}
	
	public void move(int x, int y){
		mX = mScreenConfig.getX(x);
		mY = mScreenConfig.getY(y);
	}
	
	
	// prison walking  터치시 이동
	public void walking(int k,boolean b){
		EggMove = b;
		if(b==true&&EggOn==true){
			if(k==0){
				if(mX>mWidth/2){
					mDirect = 0;
					mX=mX-mScreenConfig.getX(8);
					mDD=mDU=0;
					mDL++;
					mDL1 = mDL % 16;
				}
			}
			else if(k==1){
				if(mX<mScreenConfig.mScreenWidth-mWidth/2){
					mDirect = 1;
					mX=mX+mScreenConfig.getX(8);
					mDD=mDU=0;
					mDR++;
					mDR1 = mDR % 16;
				}
			}
			else if(k==2){
				if(mY>mHeight/2){
					mDirect = 2;
					mY=mY-mScreenConfig.getY(8);
					mDR=mDL=0;
					mDU++;
					mDU1 = mDU % 16;
					}
			}
			else if(k==3){
				if(mY<mScreenConfig.mScreenHeight-mHeight/2){
					mDirect = 3;
					mY=mY+mScreenConfig.getY(8);
					mDR = mDL = 0;
					mDD++;
					mDD1 = mDD % 16;
				}
			}
		}
	}
	
	public void crash(int bombnum,int bombx[],int bomby[],int bombon[],Canvas canvas){
		for(int i=0;i<bombnum;i++){
			if(Eggsum2==0){
			if(mX>=bombx[i]-mScreenConfig.getX(50)&&mX<=bombx[i]+mScreenConfig.getX(50)){
				if(mY>=bomby[i]-mScreenConfig.getY(50)&&mY<=bomby[i]+mScreenConfig.getY(50)){
					if(bombon[i]==1){
						EggOn = false;
						EggCrash1 = true;
					}
				}
			}
			}
			if(EggCrash1==true){
				Eggsum1++;
				if(Eggsum1>=0&&Eggsum1<5)
					canvas.drawBitmap(mBitmapC1, (int)(mX-0.5*mWidth), (int)(mY-0.5*mHeight), null);
				if(Eggsum1>=5&&Eggsum1<10)
					canvas.drawBitmap(mBitmapC2, (int)(mX-0.5*mWidth), (int)(mY-0.5*mHeight), null);
				if(Eggsum1>=10&&Eggsum1<15)
					canvas.drawBitmap(mBitmapC3, (int)(mX-0.5*mWidth), (int)(mY-0.5*mHeight), null);
				if(Eggsum1>=15&&Eggsum1<20)
					canvas.drawBitmap(mBitmapC4, (int)(mX-0.5*mWidth), (int)(mY-0.5*mHeight), null);
				if(Eggsum1==20){
					EggReset = true;
				}
			}
			
			if(Eggsum1==0){
			if(mX>=bombx[i]-mScreenConfig.getX(150)&&mX<=bombx[i]+mScreenConfig.getX(150)){
				if(mY>=bomby[i]-mScreenConfig.getY(150)&&mY<=bomby[i]+mScreenConfig.getY(150)){
					if(bombon[i]==0){
						EggOn = false;
						EggCrash2 = true;
					}
				}
			}
			}
			
			if(EggCrash2==true){
				Eggsum2++;
				if(Eggsum2>=0&&Eggsum2<40)
					canvas.drawBitmap(mBitmapB, (int)(mX-0.5*mWidth), (int)(mY-0.6*mHeight), null);
				if(Eggsum2==40){
					EggReset = true;
				}
			}
		}
	}
	
	public void destory(){
		try{
			if(mBitmapD != null){
				mBitmapD.recycle();
			}
		}
		catch(Exception e){}
	} 
	
	public void draw(Canvas canvas){
		if(EggOn==true){
		if(mDirect == 0){
			if(EggMove==false){
				canvas.drawBitmap(mBitmapL, (int)(mX-mWidth/2),(int)(mY-mHeight/2),null);
			}
			else{
				if(mDL1>=7){
					canvas.drawBitmap(mBitmapL, (int)(mX-mWidth/2),(int)(mY-mHeight/2),null);
				}
				else{
					canvas.drawBitmap(mBitmapL1, (int)(mX-mWidth/2),(int)(mY-mHeight/2),null);
				}
			}
		}
		else if(mDirect == 1){
			if(EggMove==false){
				canvas.drawBitmap(mBitmapR, (int)(mX-mWidth/2),(int)(mY-mHeight/2),null);
			}
			else{
				if(mDR1>=7){
					canvas.drawBitmap(mBitmapR, (int)(mX-mWidth/2),(int)(mY-mHeight/2),null);
				}
				else{
					canvas.drawBitmap(mBitmapR1, (int)(mX-mWidth/2),(int)(mY-mHeight/2),null);
				}
			}
		}		
		else if(mDirect == 2){
			if(EggMove==false){
				canvas.drawBitmap(mBitmapU, (int)(mX-mWidth/2),(int)(mY-mHeight/2),null);
			}
			else{
				if(mDU1>=7){
					canvas.drawBitmap(mBitmapU1, (int)(mX-mWidth/2),(int)(mY-mHeight/2),null);
				}
				else{
					canvas.drawBitmap(mBitmapU2, (int)(mX-mWidth/2),(int)(mY-mHeight/2),null);
				}
			}
		}
		else if(mDirect == 3){
			if(EggMove==false){
				canvas.drawBitmap(mBitmapD, (int)(mX-mWidth/2),(int)(mY-mHeight/2),null);
			}
			else{
				if(mDD1>=7){
					canvas.drawBitmap(mBitmapD1, (int)(mX-mWidth/2),(int)(mY-mHeight/2),null);
				}
				else{
					canvas.drawBitmap(mBitmapD2, (int)(mX-mWidth/2),(int)(mY-mHeight/2),null);
				}
			}
		}
		}
	}
}
