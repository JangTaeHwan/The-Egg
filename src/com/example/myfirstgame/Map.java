package com.example.myfirstgame;

import android.graphics.*;

public class Map {
	private ScreenConfig mScreenConfig;
	private Bitmap mBlock;
	private Bitmap mKey;
	private Bitmap mCrash1;
	private Bitmap mCrash2;
	private Bitmap mCrash3;
	private int mKeyX[],mKeyY[];
	private Bitmap mGate;
	private int mGateX[],mGateY[];
	private int mapstage;
	private int mWidth;
	private int mHeight;
	private int mGatenum;
	public int mBlocknum;
	private boolean mKeyon;
	private boolean mGateon;
	protected boolean mReset;
	public int mBlockX[];
	public int mBlockY[];
	public int mBlockOn[];
	private int mBlocksum[];
	boolean UB, DB, LB, RB;
	boolean UR,UL,DR,DL,LU,LD,RU,RD;
	private int ubY,ubX,dbX,dbY,lbX,lbY,rbX,rbY;
	
	public Map(ScreenConfig screenconfig, Bitmap key, Bitmap block, Bitmap gate,Bitmap crash1, Bitmap crash2, Bitmap crash3, int stage){
		mapstage = stage;
		mScreenConfig = screenconfig;
		mWidth = mScreenConfig.getX(100);
		mHeight = mScreenConfig.getY(100);
		mBlock = Bitmap.createScaledBitmap(block, mWidth, mHeight, false);
		mKey = Bitmap.createScaledBitmap(key, mWidth, mHeight, false);
		mGate = Bitmap.createScaledBitmap(gate, mWidth, mHeight, false);
		mCrash1 = Bitmap.createScaledBitmap(crash1, (int)(1.2*mWidth), (int)(1.2*mHeight), false);
		mCrash2 = Bitmap.createScaledBitmap(crash2, (int)(1.4*mWidth), (int)(1.4*mHeight), false);
		mCrash3 = Bitmap.createScaledBitmap(crash3, (int)(1.6*mWidth), (int)(1.6*mHeight), false);
		mBlockX = new int[100];
		mBlockY = new int[100];
		mBlockOn = new int[100];
		mBlocksum = new int[100];
		mKeyX = new int[10];
		mKeyY = new int[10];
		mGateX = new int[10];
		mGateY = new int[10];
		mGatenum =1;
		mKeyon=false;
		mReset=false;
		mGateon = false;
		DB=false;
		UB=false;
		LB=false;
		RB=false;
		UR = UL = DR = DL = RU = RD = LU = LD = false;
	}
	
	//Block 셋팅
	public void stageset(){
		switch(mapstage){
		case 1:
			mBlocknum = 15;
			mGatenum =1;
			mKeyX[0]=mScreenConfig.getX(1950);
			mKeyY[0]=mScreenConfig.getY(950);
			mGateX[0]=mScreenConfig.getX(1950);
			mGateY[0]=mScreenConfig.getY(50);
			for(int i=0;i<3;i++){
				mBlockX[i] = mScreenConfig.getX(1750)+mWidth*(i);
				mBlockY[i] = mScreenConfig.getY(150);
			}
			mBlockX[3] = mScreenConfig.getX(1750);
			mBlockY[3] = mScreenConfig.getY(50);
			mBlockX[4] = mScreenConfig.getX(1250);
			mBlockY[4] = mScreenConfig.getY(250);
			mBlockX[5] = mScreenConfig.getX(950);
			mBlockY[5] = mScreenConfig.getY(350);
			mBlockX[6] = mScreenConfig.getX(1050);
			mBlockY[6] = mScreenConfig.getY(550);
			mBlockX[7] = mScreenConfig.getX(1350);
			mBlockY[7] = mScreenConfig.getY(550);
			mBlockX[8] = mScreenConfig.getX(1250);
			mBlockY[8] = mScreenConfig.getY(650);
			mBlockX[9] = mScreenConfig.getX(1150);
			mBlockY[9] = mScreenConfig.getY(950);
			mBlockX[10] = mScreenConfig.getX(1750);
			mBlockY[10] = mScreenConfig.getY(750);
			mBlockX[11] = mScreenConfig.getX(1850);
			mBlockY[11] = mScreenConfig.getY(750);
			mBlockX[12] = mScreenConfig.getX(1950);
			mBlockY[12] = mScreenConfig.getY(750);
			mBlockX[13] = mScreenConfig.getX(1750);
			mBlockY[13] = mScreenConfig.getY(850);
			mBlockX[14] = mScreenConfig.getX(1750);
			mBlockY[14] = mScreenConfig.getY(950);
			break;
			
		case 2:
			mBlocknum = 49;
			mGatenum =1;
			mKeyX[0]=mScreenConfig.getX(1350);
			mKeyY[0]=mScreenConfig.getY(600);
			mGateX[0]=mScreenConfig.getX(1950);
			mGateY[0]=mScreenConfig.getY(50);
			for(int i=0;i<10;i++){
				mBlockX[i] = mScreenConfig.getX(750);
				mBlockY[i] = mScreenConfig.getY(950)-mHeight*i;
			}
			for(int i=10;i<16;i++){
				mBlockX[i] = mWidth/2+mWidth*(i-10);
				mBlockY[i] = mScreenConfig.getY(450);
			}
			for(int i=16;i<19;i++){
				mBlockX[i] = mScreenConfig.getX(550);
				mBlockY[i] = mScreenConfig.getY(450)+mHeight*(i-15);
			}
			for(int i=19;i<31;i++){
				mBlockX[i] = mScreenConfig.getX(750)+mWidth*(i-18);
				mBlockY[i] = mScreenConfig.getY(1000)-mHeight/2-mHeight*7;
			}
			for(int i=31;i<35;i++){
				mBlockX[i] = mScreenConfig.getX(1050);
				mBlockY[i] = mScreenConfig.getY(450)+mHeight*(i-31);
			}
			for(int i=35;i<41;i++){
				mBlockX[i] = mScreenConfig.getX(1050)+mWidth*(i-34);
				mBlockY[i] = mScreenConfig.getY(750);
			}
			for(int i=41;i<44;i++){
				mBlockX[i] = mScreenConfig.getX(1650);
				mBlockY[i] = mScreenConfig.getY(750)-mHeight*(i-40);
			}
			
			for(int i=44;i<49;i++){
				mBlockX[i] = mScreenConfig.getX(1650)-mWidth*(i-43);
				mBlockY[i] = mScreenConfig.getY(450);
			}
			break;
			
		case 3:
			mBlocknum = 30;
			mGatenum =1;
			mKeyX[0]=mScreenConfig.getX(650);
			mKeyY[0]=mScreenConfig.getY(150);
			mGateX[0]=mScreenConfig.getX(1950);
			mGateY[0]=mScreenConfig.getY(50);
			for(int i=0;i<5;i++){
				mBlockX[i] = mScreenConfig.getX(250+i*100);
				mBlockY[i] = mScreenConfig.getY(450);
			}
			for(int i=5;i<11;i++){
				mBlockX[i] = mScreenConfig.getX(750);
				mBlockY[i] = mScreenConfig.getY(50+(i-5)*100);
			}
			for(int i=11;i<15;i++){
				mBlockX[i] = mScreenConfig.getX(1350);
				mBlockY[i] = mScreenConfig.getY(50+(i-11)*100);
			}
			for(int i=15;i<19;i++){
				mBlockX[i] = mScreenConfig.getX(1450);
				mBlockY[i] = mScreenConfig.getY(50+(i-15)*100);
			}
			for(int i=19;i<24;i++){
				mBlockX[i] = mScreenConfig.getX(1550+(i-19)*100);
				mBlockY[i] = mScreenConfig.getY(250);
			}
			for(int i=24;i<29;i++){
				mBlockX[i] = mScreenConfig.getX(1550+(i-24)*100);
				mBlockY[i] = mScreenConfig.getY(350);
			}
				mBlockX[29] = mScreenConfig.getX(1950);
				mBlockY[29] = mScreenConfig.getY(950);
			break;
			
			case 4:
				mBlocknum = 21;
				mGatenum =1;
				mKeyX[0]=mScreenConfig.getX(950);
				mKeyY[0]=mScreenConfig.getY(950);
				mGateX[0]=mScreenConfig.getX(1950);
				mGateY[0]=mScreenConfig.getY(50);

				mBlockX[0] = mScreenConfig.getX(550);
				mBlockY[0] = mScreenConfig.getY(50);
				mBlockX[1] = mScreenConfig.getX(550);
				mBlockY[1] = mScreenConfig.getY(250);
				mBlockX[2] = mScreenConfig.getX(950);
				mBlockY[2] = mScreenConfig.getY(50);
				mBlockX[3] = mScreenConfig.getX(950);
				mBlockY[3] = mScreenConfig.getY(250);
				mBlockX[4] = mScreenConfig.getX(550);
				mBlockY[4] = mScreenConfig.getY(950);
				mBlockX[5] = mScreenConfig.getX(850);
				mBlockY[5] = mScreenConfig.getY(350);
				mBlockX[6] = mScreenConfig.getX(850);
				mBlockY[6] = mScreenConfig.getY(550);
				mBlockX[7] = mScreenConfig.getX(1350);
				mBlockY[7] = mScreenConfig.getY(650);
				mBlockX[8] = mScreenConfig.getX(1450);
				mBlockY[8] = mScreenConfig.getY(350);
				for(int i=9;i<13;i++){
					mBlockX[i] = mScreenConfig.getX(750+(i-9)*100);
					mBlockY[i] = mScreenConfig.getY(850);
				}
				mBlockX[13] = mScreenConfig.getX(750);
				mBlockY[13] = mScreenConfig.getY(950);
				mBlockX[14] = mScreenConfig.getX(1050);
				mBlockY[14] = mScreenConfig.getY(950);
				for(int i=15;i<18;i++){
					mBlockX[i] = mScreenConfig.getX(1650);
					mBlockY[i] = mScreenConfig.getY(50+100*(i-15));
				}
				for(int i=18;i<21;i++){
					mBlockX[i] = mScreenConfig.getX(1750+(i-18)*100);
					mBlockY[i] = mScreenConfig.getY(250);
				}
				break;
				
			case 5:
				mBlocknum = 38;
				mGatenum =1;
				mKeyX[0]=mScreenConfig.getX(1050);
				mKeyY[0]=mScreenConfig.getY(650);
				mGateX[0]=mScreenConfig.getX(1950);
				mGateY[0]=mScreenConfig.getY(50);
				for(int i=0;i<2;i++){
					mBlockX[i] = mScreenConfig.getX(250);
					mBlockY[i] = mScreenConfig.getY(50+100*i);
				}
				for(int i=2;i<7;i++){
					mBlockX[i] = mScreenConfig.getX(450+(i-2)*100);
					mBlockY[i] = mScreenConfig.getY(250);
				}
				for(int i=7;i<13;i++){
					mBlockX[i] = mScreenConfig.getX(50+(i-7)*100);
					mBlockY[i] = mScreenConfig.getY(450);
				}
				for(int i=13;i<17;i++){
					mBlockX[i] = mScreenConfig.getX(550);
					mBlockY[i] = mScreenConfig.getY(550+(i-13)*100);
				}
				for(int i=17;i<19;i++){
					mBlockX[i] = mScreenConfig.getX(350+(i-17)*100);
					mBlockY[i] = mScreenConfig.getY(750);
				}
					mBlockX[19] = mScreenConfig.getX(650);
					mBlockY[19] = mScreenConfig.getY(850);
				for(int i=20;i<24;i++){
					mBlockX[i] = mScreenConfig.getX(850+(i-20)*100);
					mBlockY[i] = mScreenConfig.getY(450);
				}
				for(int i=24;i<27;i++){
					mBlockX[i] = mScreenConfig.getX(950);
					mBlockY[i] = mScreenConfig.getY(550+(i-24)*100);
				}
				for(int i=27;i<29;i++){
					mBlockX[i] = mScreenConfig.getX(1050+(i-27)*100);
					mBlockY[i] = mScreenConfig.getY(750);
				}
				for(int i=29;i<31;i++){
					mBlockX[i] = mScreenConfig.getX(1150);
					mBlockY[i] = mScreenConfig.getY(550+(i-29)*100);
				}
				for(int i=31;i<33;i++){
					mBlockX[i] = mScreenConfig.getX(1350+(i-31)*100);
					mBlockY[i] = mScreenConfig.getY(350);
				}
					mBlockX[33] = mScreenConfig.getX(1150);
					mBlockY[33] = mScreenConfig.getY(150);
				for(int i=34;i<37;i++){
					mBlockX[i] = mScreenConfig.getX(1750+(i-34)*100);
					mBlockY[i] = mScreenConfig.getY(150);
				}	
					mBlockX[37] = mScreenConfig.getX(1750);
					mBlockY[37] = mScreenConfig.getY(50);
				break;
				
			case 6:
				mBlocknum = 42;
				mGatenum =1;
				mKeyX[0]=mScreenConfig.getX(750);
				mKeyY[0]=mScreenConfig.getY(650);
				mGateX[0]=mScreenConfig.getX(1950);
				mGateY[0]=mScreenConfig.getY(50);
				
				for(int i=0;i<3;i++){
					mBlockX[i] = mScreenConfig.getX(50+100*i);
					mBlockY[i] = mScreenConfig.getY(250);
				}
				for(int i=3;i<5;i++){
					mBlockX[i] = mScreenConfig.getX(250);
					mBlockY[i] = mScreenConfig.getY(50+100*(i-3));
				}
				for(int i=5;i<10;i++){
					mBlockX[i] = mScreenConfig.getX(850+(i-5)*100);
					mBlockY[i] = mScreenConfig.getY(250);
				}
				for(int i=10;i<14;i++){
					mBlockX[i] = mScreenConfig.getX(650+(i-10)*100);
					mBlockY[i] = mScreenConfig.getY(550);
				}
				for(int i=14;i<16;i++){
					mBlockX[i] = mScreenConfig.getX(650);
					mBlockY[i] = mScreenConfig.getY(650+(i-14)*100);
				}
				for(int i=16;i<19;i++){
					mBlockX[i] = mScreenConfig.getX(750+(i-16)*100);
					mBlockY[i] = mScreenConfig.getY(750);
				}
					mBlockX[19] = mScreenConfig.getX(950);
					mBlockY[19] = mScreenConfig.getY(650);
				for(int i=20;i<30;i++){
						mBlockX[i] = mScreenConfig.getX(1550);
						mBlockY[i] = mScreenConfig.getY(50+100*(i-20));
				}
				for(int i=30;i<34;i++){
					mBlockX[i] = mScreenConfig.getX(1650+(i-30)*100);
					mBlockY[i] = mScreenConfig.getY(250);
				}
				for(int i=34;i<38;i++){
					mBlockX[i] = mScreenConfig.getX(1650+(i-34)*100);
					mBlockY[i] = mScreenConfig.getY(650);
				}
				for(int i=38;i<42;i++){
					mBlockX[i] = mScreenConfig.getX(1650+(i-38)*100);
					mBlockY[i] = mScreenConfig.getY(150);
				}
				break;
				
			case 7:
				mBlocknum = 43;
				mGatenum =1;
				mKeyX[0]=mScreenConfig.getX(1050);
				mKeyY[0]=mScreenConfig.getY(200);
				mGateX[0]=mScreenConfig.getX(1950);
				mGateY[0]=mScreenConfig.getY(50);
				for(int i=0;i<8;i++){
					mBlockX[i] = mScreenConfig.getX(550);
					mBlockY[i] = mScreenConfig.getY(50+i*100);
				}
				for(int i=8;i<14;i++){
					mBlockX[i] = mScreenConfig.getX(650+100*(i-8));
					mBlockY[i] = mScreenConfig.getY(550);
				}
				for(int i=14;i<16;i++){
					mBlockX[i] = mScreenConfig.getX(50+(i-14)*100);
					mBlockY[i] = mScreenConfig.getY(750);
				}
					mBlockX[16] = mScreenConfig.getX(450);
					mBlockY[16] = mScreenConfig.getY(750);
					mBlockX[17] = mScreenConfig.getX(550);
					mBlockY[17] = mScreenConfig.getY(950);
				for(int i=18;i<23;i++){
					mBlockX[i] = mScreenConfig.getX(850+(i-18)*100);
					mBlockY[i] = mScreenConfig.getY(50);
				}
				for(int i=23;i<26;i++){
					mBlockX[i] = mScreenConfig.getX(850);
					mBlockY[i] = mScreenConfig.getY(150+(i-23)*100);
				}
				for(int i=26;i<30;i++){
					mBlockX[i] = mScreenConfig.getX(950+100*(i-26));
					mBlockY[i] = mScreenConfig.getY(350);
				}
				for(int i=30;i<32;i++){
					mBlockX[i] = mScreenConfig.getX(1250);
					mBlockY[i] = mScreenConfig.getY(150+(i-30)*100);
				}
				for(int i=32;i<36;i++){
					mBlockX[i] = mScreenConfig.getX(1650);
					mBlockY[i] = mScreenConfig.getY(650+(i-32)*100);
				}
				for(int i=36;i<41;i++){
					mBlockX[i] = mScreenConfig.getX(1750);
					mBlockY[i] = mScreenConfig.getY(50+(i-36)*100);
				}
				for(int i=41;i<43;i++){
					mBlockX[i] = mScreenConfig.getX(1850+(i-41)*100);
					mBlockY[i] = mScreenConfig.getY(450);
				}
				break;
				
			case 8:
				mBlocknum = 23;
				mGatenum =1;
				mKeyX[0]=mScreenConfig.getX(50);
				mKeyY[0]=mScreenConfig.getY(50);
				mGateX[0]=mScreenConfig.getX(1950);
				mGateY[0]=mScreenConfig.getY(50);
				for(int i=0;i<3;i++){
					mBlockX[i] = mScreenConfig.getX(250);
					mBlockY[i] = mScreenConfig.getY(50+i*100);
				}
				for(int i=3;i<5;i++){
					mBlockX[i] = mScreenConfig.getX(50+(i-3)*100);
					mBlockY[i] = mScreenConfig.getY(250);
				}
				for(int i=5;i<8;i++){
					mBlockX[i] = mScreenConfig.getX(1750);
					mBlockY[i] = mScreenConfig.getY(50+(i-5)*100);
				}
				for(int i=8;i<10;i++){
					mBlockX[i] = mScreenConfig.getX(1850+(i-8)*100);
					mBlockY[i] = mScreenConfig.getY(250);
				}
				for(int i=10;i<13;i++){
					mBlockX[i] = mScreenConfig.getX(1750+(i-10)*100);
					mBlockY[i] = mScreenConfig.getY(750);
				}
				for(int i=13;i<15;i++){
					mBlockX[i] = mScreenConfig.getX(1750);
					mBlockY[i] = mScreenConfig.getY(850+(i-13)*100);
				}
				mBlockX[15] = mScreenConfig.getX(450);
				mBlockY[15] = mScreenConfig.getY(150);
				mBlockX[16] = mScreenConfig.getX(1050);
				mBlockY[16] = mScreenConfig.getY(250);
				mBlockX[17] = mScreenConfig.getX(650);
				mBlockY[17] = mScreenConfig.getY(350);
				mBlockX[18] = mScreenConfig.getX(850);
				mBlockY[18] = mScreenConfig.getY(450);
				mBlockX[19] = mScreenConfig.getX(550);
				mBlockY[19] = mScreenConfig.getY(550);
				mBlockX[20] = mScreenConfig.getX(750);
				mBlockY[20] = mScreenConfig.getY(650);
				mBlockX[21] = mScreenConfig.getX(350);
				mBlockY[21] = mScreenConfig.getY(750);
				mBlockX[22] = mScreenConfig.getX(950);
				mBlockY[22] = mScreenConfig.getY(850);
				break;
				
			case 9:
				mBlocknum = 56;
				mGatenum =1;
				mKeyX[0]=mScreenConfig.getX(50);
				mKeyY[0]=mScreenConfig.getY(50);
				mGateX[0]=mScreenConfig.getX(1950);
				mGateY[0]=mScreenConfig.getY(50);
				
				for(int i=0;i<2;i++){
					mBlockX[i] = mScreenConfig.getX(150);
					mBlockY[i] = mScreenConfig.getY(50+i*100);
				}
					mBlockX[2] = mScreenConfig.getX(50);
					mBlockY[2] = mScreenConfig.getY(150);
				for(int i=3;i<6;i++){
					mBlockX[i] = mScreenConfig.getX(250+(i-3)*100);
					mBlockY[i] = mScreenConfig.getY(450);
				}
				for(int i=6;i<16;i++){
					mBlockX[i] = mScreenConfig.getX(550);
					mBlockY[i] = mScreenConfig.getY(50+(i-6)*100);
				}
				for(int i=16;i<25;i++){
					mBlockX[i] = mScreenConfig.getX(850+(i-16)*100);
					mBlockY[i] = mScreenConfig.getY(850);
				}
				for(int i=25;i<28;i++){
					mBlockX[i] = mScreenConfig.getX(850);
					mBlockY[i] = mScreenConfig.getY(550+(i-25)*100);
				}
				for(int i=28;i<30;i++){
					mBlockX[i] = mScreenConfig.getX(1250);
					mBlockY[i] = mScreenConfig.getY(650+(i-28)*100);
				}
					mBlockX[30] = mScreenConfig.getX(1650);
					mBlockY[30] = mScreenConfig.getY(750);
				for(int i=31;i<35;i++){
					mBlockX[i] = mScreenConfig.getX(950+(i-31)*100);
					mBlockY[i] = mScreenConfig.getY(50);
				}
				for(int i=35;i<38;i++){
					mBlockX[i] = mScreenConfig.getX(950);
					mBlockY[i] = mScreenConfig.getY(150+(i-35)*100);
				}
				for(int i=38;i<41;i++){
					mBlockX[i] = mScreenConfig.getX(1050+(i-38)*100);
					mBlockY[i] = mScreenConfig.getY(350);
				}
				for(int i=41;i<43;i++){
					mBlockX[i] = mScreenConfig.getX(1250);
					mBlockY[i] = mScreenConfig.getY(150+(i-41)*100);
				}
				for(int i=43;i<46;i++){
					mBlockX[i] = mScreenConfig.getX(1750+(i-43)*100);
					mBlockY[i] = mScreenConfig.getY(150);
				}
					mBlockX[46] = mScreenConfig.getX(1750);
					mBlockY[46] = mScreenConfig.getY(50);
				for(int i=47;i<50;i++){
					mBlockX[i] = mScreenConfig.getX(1450+(i-47)*100);
					mBlockY[i] = mScreenConfig.getY(450);
				}
				for(int i=50;i<53;i++){
					mBlockX[i] = mScreenConfig.getX(1750+(i-50)*100);
					mBlockY[i] = mScreenConfig.getY(550);
				}
					mBlockX[53] = mScreenConfig.getX(1950);
					mBlockY[53] = mScreenConfig.getY(650);
					mBlockX[54] = mScreenConfig.getX(1950);
					mBlockY[54] = mScreenConfig.getY(850);
					mBlockX[55] = mScreenConfig.getX(1950);
					mBlockY[55] = mScreenConfig.getY(950);
				break;
				
		}
		for(int i=0; i<mBlocknum ;i++){
			mBlockOn[i] =1; 
			mBlocksum[i] = 0;
		}
		
	}
	
	// 주인공 이동시 블럭에서 막기
	public void ban(double x,double y){
		int rX=mScreenConfig.getX(95);										// 100 = 블록의 너비*0.5 + 주인공의 너비*0.5
		int rY=mScreenConfig.getY(95);										// 100 = 블록의 높이*0.5 + 주인공의 높이*0.5
		if(DB==false){
			DR = DL = false;
		}
		if(UB==false){
			UR = UL = false;
		}
		if(RB==false){
			RU = RD = false;
		}
		if(LB==false){
			LU = LD = false;
		}
		for(int i=0;i<mBlocknum;i++){
			if(mBlockOn[i]==1){
			if(x>=(mBlockX[i]-rX+mScreenConfig.getX(10))&&x<=(mBlockX[i]+rX-mScreenConfig.getX(10))){
				if(y>=mBlockY[i]-rY&&y<=mBlockY[i]-rY+mScreenConfig.getY(10)){
					if(DB==false){
						DB = true;
						dbY= mBlockY[i]-rY;
						dbX= mBlockX[i];
					}
					if(x<mBlockX[i]-mScreenConfig.getX(20)){
						DL = true;
					}
					if(x>mBlockX[i]+mScreenConfig.getX(20)){
						DR = true;
					}
					if(DL&&DR){
						DL = DR = false;
					}
				}
				if(y>=mBlockY[i]+rY-mScreenConfig.getY(10)&&y<=mBlockY[i]+rY){
					if(UB==false){
						UB = true;
						ubY = mBlockY[i]+rY;
						ubX = mBlockX[i];
					}
					if(x<mBlockX[i]-mScreenConfig.getX(20)){
						UL = true;
					}
					if(x>mBlockX[i]+mScreenConfig.getX(20)){
						UR = true;
					}
					if(UL&&UR){
						UL = UR = false;
					}
				}
				}
			if(y>=(mBlockY[i]-rY+mScreenConfig.getY(10))&&y<=(mBlockY[i]+rY-mScreenConfig.getY(10))){
				if(x>=mBlockX[i]-rX&&x<=mBlockX[i]-rX+mScreenConfig.getX(10)){
					if(RB==false){
						RB = true;
						rbX = mBlockX[i]-rX;
						rbY = mBlockY[i];
					}
					if(y<mBlockY[i]-mScreenConfig.getY(20)){
						RU = true;
					}
					if(y>mBlockY[i]+mScreenConfig.getY(20)){
						RD = true;
					}
					if(RD&&RU){
						RD = RU = false;
					}
					}
				if(x>=mBlockX[i]+rX-mScreenConfig.getX(10)&&x<=mBlockX[i]+rX){
					if(LB==false){
						LB = true;
						lbX = mBlockX[i]+rX;
						lbY = mBlockY[i];
					}
					if(y<mBlockY[i]-mScreenConfig.getY(20)){
						LU = true;
					}
					if(y>mBlockY[i]+mScreenConfig.getY(20)){
						LD = true;
					}
					if(LD&&LU){
						LD = LU = false;
					}
					}
				}
			
			if(DB==true){
				if(y<dbY){
					DB=false;
				}
				if((dbX-rX+mScreenConfig.getX(10))>x || x>(dbX+rX-mScreenConfig.getX(10))){
					DB=false;
				}
			}
			
			if(UB==true){
				if(y>ubY){
					UB=false;
				}
				if((ubX-rX+mScreenConfig.getX(10))>x || x>(ubX+rX-mScreenConfig.getX(10))){
					UB=false;
				}
			}
			
			if(RB==true){
				if(x < rbX){
					RB=false;
				}
				if((rbY-rY+mScreenConfig.getY(10))>y || y>(rbY+rY-mScreenConfig.getY(10))){
					RB=false;
				}
			}
			
			if(LB==true){
				if(x > lbX){
					LB=false;
				}
				if((lbY-rY+mScreenConfig.getY(10))>y || y>(lbY+rY-mScreenConfig.getY(10))){
					LB=false;
				}
			}
			}
		}
	}
	
	public void gateban(double x,double y){
		int rX=mScreenConfig.getX(95);										// 100 = 블록의 너비*0.5 + 주인공의 너비*0.5
		int rY=mScreenConfig.getY(100);										// 100 = 블록의 높이*0.5 + 주인공의 높이*0.5
		
		for(int i=0;i<mGatenum;i++){
			if(x>=(mGateX[i]-rX+mScreenConfig.getX(10))&&x<=(mGateX[i]+rX-mScreenConfig.getX(10))){
				if(y>=mGateY[i]-rY&&y<=mGateY[i]-rY+mScreenConfig.getY(8)&&DB==false){
					DB = true;
					dbY= mGateY[i]-rY;
					dbX= mGateX[i];
					}
				if(y>=mGateY[i]+rY-mScreenConfig.getY(8)&&y<=mGateY[i]+rY&&UB==false){
					UB = true;
					ubY = mGateY[i]+rY;
					ubX = mGateX[i];
					}
				}
			if(y>=(mGateY[i]-rY+mScreenConfig.getY(10))&&y<=(mGateY[i]+rY-mScreenConfig.getY(10))){
				if(x>=mGateX[i]-rX&&x<=mGateX[i]-rX+mScreenConfig.getX(8)&&RB==false){
					RB = true;
					rbX = mGateX[i]-rX;
					rbY = mGateY[i];
				}
				if(x>=mGateX[i]+rX-mScreenConfig.getX(8)&&x<=mGateX[i]+rX&&LB==false){
					LB = true;
					lbX = mGateX[i]+rX;
					lbY = mGateY[i];
					}
				}
			
			if(DB==true){
				if(y<dbY){
					DB=false;
				}
				if((dbX-rX)>x || x>(dbX+rX)){
					DB=false;
				}
			}
			
			if(UB==true){
				if(y>ubY){
					UB=false;
				}
				if((ubX-rX)>x || x>(ubX+rX)){
					UB=false;
				}
			}
			
			if(RB==true){
				if(x < rbX){
					RB=false;
				}
				if((rbY-rY)>y || y>(rbY+rY)){
					RB=false;
				}
			}
			
			if(LB==true){
				if(x > lbX){
					LB=false;
				}
				if((lbY-rY)>y || y>(lbY+rY)){
					LB=false;
				}
			}
		}
	}
	
	// 열쇠를 먹는 동작 + 문을 여는 동작 + 리셋
	public void act(double x, double y){
		if(x>=mKeyX[0]-mScreenConfig.getX(100) && x<=mKeyX[0]+mScreenConfig.getX(100)){
			if(y>=mKeyY[0]-mScreenConfig.getY(100) && y<=mKeyY[0]+mScreenConfig.getY(100)){
				mKeyon = true;
			}
		}
		if(x>=mGateX[0]-mScreenConfig.getX(100) && x<=mGateX[0]+mScreenConfig.getX(100)){
			if(y>=mGateY[0]-mScreenConfig.getY(100) && y<=mGateY[0]+mScreenConfig.getY(100)){
				if(mKeyon==true){
					mGateon = true;
					mGateX[0] = -1;
					mGateY[0] = -1;
					mReset=true;
				}
			}
		}
	}
	
	public void crash(int trapnum,int trapx[],int trapy[],int trapon[],Canvas canvas){
		for(int i=0;i<mBlocknum;i++){
			for(int j=0;j<trapnum;j++){
				if(mBlockX[i]>=trapx[j]-mScreenConfig.getX(150)&&mBlockX[i]<=trapx[j]+mScreenConfig.getX(150)){
					if(mBlockY[i]>=trapy[j]-mScreenConfig.getY(150)&&mBlockY[i]<=trapy[j]+mScreenConfig.getY(150)){
						if(trapon[j]==0){
							mBlockOn[i]=0;
							mBlocksum[i]++;
							if(mBlocksum[i]>=0&&mBlocksum[i]<10)
								canvas.drawBitmap(mCrash1, (int)(mBlockX[i]-0.6*mWidth), (int)(mBlockY[i]-0.6*mHeight), null);
							if(mBlocksum[i]>=10&&mBlocksum[i]<20)
								canvas.drawBitmap(mCrash2, (int)(mBlockX[i]-0.7*mWidth), (int)(mBlockY[i]-0.7*mHeight), null);
							if(mBlocksum[i]>=20&&mBlocksum[i]<30)
								canvas.drawBitmap(mCrash3, (int)(mBlockX[i]-0.8*mWidth), (int)(mBlockY[i]-0.8*mHeight), null);
							if(mBlocksum[i]==30){
								mBlockX[i]=-1;
								mBlockY[i]=-1;
								mBlocksum[i] = 0;
							}
						}
					}
				}
			}
		}
	}
	
	public void draw(Canvas canvas){
			for(int i=0;i<mBlocknum;i++){
				if(mBlockOn[i]==1){
					canvas.drawBitmap(mBlock, (int)(mBlockX[i]-mWidth/2), (int)(mBlockY[i]-mHeight/2),null);
				}
			}
			if(mKeyon==false){
				canvas.drawBitmap(mKey, (int)(mKeyX[0]-mWidth/2), (int)(mKeyY[0]-mHeight/2) , null);
			}
			if(mGateon==false){
				canvas.drawBitmap(mGate, (int)(mGateX[0]-mWidth/2), (int)(mGateY[0]-mHeight/2), null);
			}
		}
}
