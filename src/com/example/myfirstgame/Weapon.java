package com.example.myfirstgame;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class Weapon {
	private Bitmap wTrap;
	private ScreenConfig wScreenConfig;
	private int wStage;
	public int wTrapX[],wTrapY[];
	public int wTrapOn[];
	public int wTrapnum;
	private int wWidth;
	private int wHeight;
	boolean UB, DB, LB, RB;
	boolean UR,UL,DR,DL,LU,LD,RU,RD;
	
	private int ubY,ubX,dbX,dbY,lbX,lbY,rbX,rbY;
	
	public Weapon(ScreenConfig mscreenconfig,Bitmap mtrap, int stage){
		wStage = stage;
		wScreenConfig = mscreenconfig;
		wTrapnum = 0;
		wTrapX = new int[100];
		wTrapY = new int[100];
		wTrapOn = new int[100];
		wWidth = wScreenConfig.getX(110);
		wHeight = wScreenConfig.getY(110);
		wTrap = Bitmap.createScaledBitmap(mtrap, (int)(wWidth*0.7), (int)(wHeight*0.6), false);
		DB=false;
		UB=false;
		LB=false;
		RB=false;
		UR = UL = DR = DL = RU = RD = LU = LD = false;
		for(int i=0;i<100;i++){
			wTrapOn[i]=0;
		}
	}
	
	public void trapon(double mx, double my){
		int x1,y1;
		
		x1 = (int)mx/wScreenConfig.getX(100);
		y1 = (int)my/wScreenConfig.getY(100);
		wTrapX[wTrapnum] = wScreenConfig.getX(100)*x1+wScreenConfig.getX(50);
		wTrapY[wTrapnum] = wScreenConfig.getY(100)*y1+wScreenConfig.getY(50);	
		wTrapOn[wTrapnum] = 1;
		wTrapnum++;
	
	}
	
	public void ban(double x,double y){
		int rX=wScreenConfig.getX(95);										
		int rY=wScreenConfig.getY(95);	
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
		for(int i=0;i<wTrapnum;i++){
			if(wTrapOn[i]==1){
			if(x>=(wTrapX[i]-rX+wScreenConfig.getX(10))&&x<=(wTrapX[i]+rX-wScreenConfig.getX(10))){
				if(y>=wTrapY[i]-rY&&y<=wTrapY[i]-rY+wScreenConfig.getY(10)){
					if(DB==false){
						DB = true;
						dbY= wTrapY[i]-rY;
						dbX= wTrapX[i];
					}
					if(x<wTrapX[i]-wScreenConfig.getX(20)){
						DL = true;
					}
					if(x>wTrapX[i]+wScreenConfig.getX(20)){
						DR = true;
					}
					if(DL&&DR){
						DL = DR = false;
					}
				}
				if(y>=wTrapY[i]+rY-wScreenConfig.getY(10)&&y<=wTrapY[i]+rY){
					if(UB==false){
						UB = true;
						ubY = wTrapY[i]+rY;
						ubX = wTrapX[i];
					}
					if(x<wTrapX[i]-wScreenConfig.getX(20)){
						UL = true;
					}
					if(x>wTrapX[i]+wScreenConfig.getX(20)){
						UR = true;
					}
					if(UL&&UR){
						UL = UR = false;
					}
				}
			}
			if(y>=(wTrapY[i]-rY+wScreenConfig.getY(10))&&y<=(wTrapY[i]+rY-wScreenConfig.getY(10))){
				if(x>=wTrapX[i]-rX&&x<=wTrapX[i]-rX+wScreenConfig.getX(10)){
					if(RB==false){
						RB = true;
						rbX = wTrapX[i]-rX;
						rbY = wTrapY[i];
					}
					if(y<wTrapY[i]-wScreenConfig.getY(20)){
						RU = true;
					}
					if(y>wTrapY[i]+wScreenConfig.getY(20)){
						RD = true;
					}
					if(RD&&RU){
						RD = RU = false;
					}
					}
				if(x>=wTrapX[i]+rX-wScreenConfig.getX(10)&&x<=wTrapX[i]+rX){
					if(LB==false){
						LB = true;
						lbX = wTrapX[i]+rX;
						lbY = wTrapY[i];
					}
					if(y<wTrapY[i]-wScreenConfig.getY(20)){
						LU = true;
					}
					if(y>wTrapY[i]+wScreenConfig.getY(20)){
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
				if((dbX-rX+wScreenConfig.getX(10))>x || x>(dbX+rX-wScreenConfig.getX(10))){
					DB=false;
				}
			}
			
			if(UB==true){
				if(y>ubY){
					UB=false;
				}
				if((ubX-rX+wScreenConfig.getX(10))>x || x>(ubX+rX-wScreenConfig.getX(10))){
					UB=false;
				}
			}
			
			if(RB==true){
				if(x < rbX){
					RB=false;
				}
				if((rbY-rY+wScreenConfig.getY(10))>y || y>(rbY+rY-wScreenConfig.getY(10))){
					RB=false;
				}
			}
			
			if(LB==true){
				if(x > lbX){
					LB=false;
				}
				if((lbY-rY+wScreenConfig.getY(10))>y || y>(lbY+rY-wScreenConfig.getY(10))){
					LB=false;
				}
			}
		}
	}
	}
	
	public void draw(Canvas canvas){
		for(int i=0;i<wTrapnum;i++){
			if(wTrapOn[i]==1){
				canvas.drawBitmap(wTrap, (int)(wTrapX[i]-(0.7*wWidth)/2),(int)(wTrapY[i]-(wHeight*0.6)/2),null);
				}
			}
		}
}
