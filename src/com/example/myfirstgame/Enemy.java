package com.example.myfirstgame;

import android.graphics.*;

public class Enemy {
	private ScreenConfig eScreenConfig;
	private Bitmap eBomb1;
	private Bitmap eBomb2;
	private Bitmap eBoom1;
	private Bitmap eBoom2;
	private Bitmap eBoom3;
	private Bitmap eBoom4;
	private Bitmap eBoom5;
	private int mapstage;
	private int eWidth,eHeight;
	private int eBombDirection[];
	private int eBombCurve[];
	public int eBombX[];
	public int eBombY[];
	public int eBombOn[];
	public int eBombnum;
	public int eBoomsum;
	private int eV;
	private int eBombType[];
	
	public Enemy(ScreenConfig screenconfig, Bitmap Bomb1,Bitmap Bomb2,
				Bitmap Boom1, Bitmap Boom2, Bitmap Boom3, Bitmap Boom4, Bitmap Boom5, int stage){
		mapstage = stage;
		eScreenConfig = screenconfig;
		eWidth = eScreenConfig.getX(100);
		eHeight = eScreenConfig.getY(100);
		eBombX = new int[10];
		eBombY = new int[10];
		eBombOn = new int[10];
		eBombDirection = new int[10];
		eBombCurve = new int [10];
		eBombType = new int [10];
		eBomb1 = Bitmap.createScaledBitmap(Bomb1, eWidth, eHeight, false);
		eBomb2 = Bitmap.createScaledBitmap(Bomb2, eWidth, eHeight, false);
		eBoom1 = Bitmap.createScaledBitmap(Boom1, (int)(eWidth*1.2), (int)(eHeight*1.2), false);
		eBoom2 = Bitmap.createScaledBitmap(Boom2, (int)(eWidth*1.4), (int)(eHeight*1.4), false);
		eBoom3 = Bitmap.createScaledBitmap(Boom3, (int)(eWidth*1.6), (int)(eHeight*1.6), false);
		eBoom4 = Bitmap.createScaledBitmap(Boom4, (int)(eWidth*1.8), (int)(eHeight*1.8), false);
		eBoom5 = Bitmap.createScaledBitmap(Boom5, (int)(eWidth*2), (int)(eHeight*2), false);
		eV = 0;
		eBoomsum =0;
	}
	
	public void stageset(){
		switch(mapstage){
			case 1:
				eBombnum = 4;
				eBombX[0]=eScreenConfig.getX(850);
				eBombY[0]=eScreenConfig.getY(350);
				eBombX[1]=eScreenConfig.getX(1050);
				eBombY[1]=eScreenConfig.getY(450);
				eBombX[2]=eScreenConfig.getX(1950);
				eBombY[2]=eScreenConfig.getY(250);
				eBombX[3]=eScreenConfig.getX(1250);
				eBombY[3]=eScreenConfig.getY(750);
				eBombDirection[0] = 0;
				eBombDirection[1] = 2;
				eBombDirection[2] = 0;
				eBombDirection[3] = 1;
				eBombType[0] = 1;
				eBombType[1] = 2;
				eBombType[2] = 4;
				eBombType[3] = 3;
				break;
		
			case 2:
				eBombnum = 2;
				eBombX[0]=eScreenConfig.getX(650);
				eBombY[0]=eScreenConfig.getY(50);
				eBombX[1]=eScreenConfig.getX(1950);
				eBombY[1]=eScreenConfig.getY(850);
				eBombDirection[0] = 3;
				eBombDirection[1] = 0;
				eBombType[0] = 2;
				eBombType[1] = 3;
				break;
			case 3:
				eBombnum = 6;
				eBombX[0]=eScreenConfig.getX(250);
				eBombY[0]=eScreenConfig.getY(50);
				eBombX[1]=eScreenConfig.getX(350);
				eBombY[1]=eScreenConfig.getY(250);
				eBombX[2]=eScreenConfig.getX(450);
				eBombY[2]=eScreenConfig.getY(50);
				eBombX[3]=eScreenConfig.getX(550);
				eBombY[3]=eScreenConfig.getY(250);
				eBombX[4]=eScreenConfig.getX(850);
				eBombY[4]=eScreenConfig.getY(450);
				eBombX[5]=eScreenConfig.getX(1950);
				eBombY[5]=eScreenConfig.getY(850);
				eBombDirection[0] = 3;
				eBombDirection[1] = 2;
				eBombDirection[2] = 3;
				eBombDirection[3] = 2;
				eBombDirection[4] = 3;
				eBombDirection[5] = 2;
				eBombType[0] = 2;
				eBombType[1] = 2;
				eBombType[2] = 2;
				eBombType[3] = 2;
				eBombType[4] = 4;
				eBombType[5] = 2;
				break;
			
			case 4:
				eBombnum = 3;
				eBombX[0]=eScreenConfig.getX(850);
				eBombY[0]=eScreenConfig.getY(250);
				eBombX[1]=eScreenConfig.getX(1350);
				eBombY[1]=eScreenConfig.getY(150);
				eBombX[2]=eScreenConfig.getX(1350);
				eBombY[2]=eScreenConfig.getY(550);	
				eBombDirection[0] = 0;
				eBombDirection[1] = 0;
				eBombDirection[2] = 0;
				eBombType[0] = 3;
				eBombType[1] = 1;
				eBombType[2] = 3;
				break;
				
			case 5:
				eBombnum = 3;
				eBombX[0]=eScreenConfig.getX(350);
				eBombY[0]=eScreenConfig.getY(350);
				eBombX[1]=eScreenConfig.getX(50);
				eBombY[1]=eScreenConfig.getY(550);
				eBombX[2]=eScreenConfig.getX(650);
				eBombY[2]=eScreenConfig.getY(750);	
				eBombDirection[0] = 1;
				eBombDirection[1] = 1;
				eBombDirection[2] = 1;
				eBombType[0] = 4;
				eBombType[1] = 3;
				eBombType[2] = 4;
				break;
				
			case 6:
				eBombnum = 4;
				eBombX[0]=eScreenConfig.getX(50);
				eBombY[0]=eScreenConfig.getY(50);
				eBombX[1]=eScreenConfig.getX(1950);
				eBombY[1]=eScreenConfig.getY(350);
				eBombX[2]=eScreenConfig.getX(1650);
				eBombY[2]=eScreenConfig.getY(550);
				eBombX[3]=eScreenConfig.getX(1450);
				eBombY[3]=eScreenConfig.getY(650);
				eBombDirection[0] = 3;
				eBombDirection[1] = 3;
				eBombDirection[2] = 2;
				eBombDirection[3] = 2;
				eBombType[0] = 4;
				eBombType[1] = 3;
				eBombType[2] = 3;
				eBombType[3] = 2;
				break;
				
			case 7:
				eBombnum = 3;
				eBombX[0]=eScreenConfig.getX(50);
				eBombY[0]=eScreenConfig.getY(50);
				eBombX[1]=eScreenConfig.getX(1650);
				eBombY[1]=eScreenConfig.getY(550);
				eBombX[2]=eScreenConfig.getX(1550);
				eBombY[2]=eScreenConfig.getY(950);	
				eBombDirection[0] = 3;
				eBombDirection[1] = 0;
				eBombDirection[2] = 0;
				eBombType[0] = 4;
				eBombType[1] = 1;
				eBombType[2] = 3;
				break;
				
			case 8:
				eBombnum = 4;
				eBombX[0]=eScreenConfig.getX(950);
				eBombY[0]=eScreenConfig.getY(250);
				eBombX[1]=eScreenConfig.getX(650);
				eBombY[1]=eScreenConfig.getY(550);
				eBombX[2]=eScreenConfig.getX(1850);
				eBombY[2]=eScreenConfig.getY(850);	
				eBombX[3]=eScreenConfig.getX(1950);
				eBombY[3]=eScreenConfig.getY(950);	
				eBombDirection[0] = 3;
				eBombDirection[1] = 2;
				eBombDirection[2] = 3;
				eBombDirection[3] = 2;
				eBombType[0] = 3;
				eBombType[1] = 3;
				eBombType[2] = 4;
				eBombType[3] = 4;
				break;

			case 9:
				eBombnum = 5;
				eBombX[0]=eScreenConfig.getX(250);
				eBombY[0]=eScreenConfig.getY(50);
				eBombX[1]=eScreenConfig.getX(1150);
				eBombY[1]=eScreenConfig.getY(150);
				eBombX[2]=eScreenConfig.getX(1050);
				eBombY[2]=eScreenConfig.getY(250);	
				eBombX[3]=eScreenConfig.getX(650);
				eBombY[3]=eScreenConfig.getY(450);	
				eBombX[4]=eScreenConfig.getX(1850);
				eBombY[4]=eScreenConfig.getY(950);	
				eBombDirection[0] = 3;
				eBombDirection[1] = 0;
				eBombDirection[2] = 1;
				eBombDirection[3] = 3;
				eBombDirection[4] = 2;
				eBombType[0] = 4;
				eBombType[1] = 4;
				eBombType[2] = 4;
				eBombType[3] = 4;
				eBombType[4] = 4;
				break;
		}
		for(int i=0;i<eBombnum;i++){
			eBombOn[i] = 1;
			eBombCurve[i] = 0;
		}
	}
	
	public void EnemyCurve(){
		for(int i=0;i<eBombnum;i++){
			if(eBombType[i]==1){
				if(eBombDirection[i]==0&&eBombCurve[i]==1){
					eBombDirection[i]=1;
					eBombCurve[i]=0;
				}
				if(eBombDirection[i]==1&&eBombCurve[i]==1){
					eBombDirection[i]=0;
					eBombCurve[i]=0;
				}
			}
			if(eBombType[i]==2){
				if(eBombDirection[i]==2&&eBombCurve[i]==1){
					eBombDirection[i]=3;
					eBombCurve[i]=0;
				}
				if(eBombDirection[i]==3&&eBombCurve[i]==1){
					eBombDirection[i]=2;
					eBombCurve[i]=0;
				}
			}
			if(eBombType[i]==3){
				if(eBombDirection[i]==0&&eBombCurve[i]==1){
					eBombDirection[i]=2;
					eBombCurve[i]=0;
				}
				if(eBombDirection[i]==2&&eBombCurve[i]==1){
					eBombDirection[i]=1;
					eBombCurve[i]=0;
				}
				if(eBombDirection[i]==1&&eBombCurve[i]==1){
					eBombDirection[i]=3;
					eBombCurve[i]=0;
				}
				if(eBombDirection[i]==3&&eBombCurve[i]==1){
					eBombDirection[i]=0;
					eBombCurve[i]=0;
				}
				
			}
			if(eBombType[i]==4){
				if(eBombDirection[i]==0&&eBombCurve[i]==1){
					eBombDirection[i]=3;
					eBombCurve[i]=0;
				}
				if(eBombDirection[i]==3&&eBombCurve[i]==1){
					eBombDirection[i]=1;
					eBombCurve[i]=0;
				}
				if(eBombDirection[i]==1&&eBombCurve[i]==1){
					eBombDirection[i]=2;
					eBombCurve[i]=0;
				}
				if(eBombDirection[i]==2&&eBombCurve[i]==1){
					eBombDirection[i]=0;
					eBombCurve[i]=0;
				}
			}
		}
	}
	
	public void EnemyMove(){
		eV++;
		if(eV>1000){
			eV=0;
		}
		if(eV%1 == 0){
			for(int i=0;i<eBombnum;i++){
				if(eBombOn[i]==1){
					if(eBombDirection[i]==0&&eBombCurve[i]==0){
						eBombX[i]-=eScreenConfig.getX(9);
						}
					if(eBombDirection[i]==1&&eBombCurve[i]==0){
						eBombX[i]+=eScreenConfig.getX(9);
						}
					if(eBombDirection[i]==2&&eBombCurve[i]==0){
						eBombY[i]-=eScreenConfig.getY(7);
						}
					if(eBombDirection[i]==3&&eBombCurve[i]==0){
						eBombY[i]+=eScreenConfig.getY(7);
						}
					}
				}
		}
	}
	
	public void ban(int blocknum, int blockx[], int blocky[], int blockon[]){
		for(int i=0;i<eBombnum;i++){
		switch(eBombDirection[i]){
			case 0:
				if(eBombX[i]<=eScreenConfig.getX(50)&&eBombX[i]>=eScreenConfig.getX(40)&&eBombCurve[i]==0){
					eBombCurve[i]=1;
				}
				for(int j=0;j<blocknum;j++){
					if(blockon[j]==1){
						if(eBombX[i]<=blockx[j]+eScreenConfig.getX(100)&&eBombX[i]>=blockx[j]+eScreenConfig.getX(90)){
							if(eBombY[i]<=blocky[j]+eScreenConfig.getY(10)&&eBombY[i]>=blocky[j]-eScreenConfig.getY(10)&&eBombCurve[i]==0){
								eBombCurve[i]=1;
							}
						}
					}
				}
				break;
				
			case 1:
				if(eBombX[i]<=eScreenConfig.getX(1960)&&eBombX[i]>=eScreenConfig.getX(1950)&&eBombCurve[i]==0){
					eBombCurve[i]=1;
				}
				if(eBombX[i]<=eScreenConfig.getX(1860)&&eBombX[i]>=eScreenConfig.getX(1850)&&eBombCurve[i]==0){
					if(eBombY[i]<=eScreenConfig.getY(50)&&eBombY[i]>=eScreenConfig.getY(40)&&eBombCurve[i]==0){
						eBombCurve[i]=1;
					}
				}
				for(int j=0;j<blocknum;j++){
					if(blockon[j]==1){
						if(eBombX[i]<=blockx[j]-eScreenConfig.getX(90)&&eBombX[i]>=blockx[j]-eScreenConfig.getX(100)){
							if(eBombY[i]<=blocky[j]+eScreenConfig.getY(10)&&eBombY[i]>=blocky[j]-eScreenConfig.getY(10)&&eBombCurve[i]==0){
								eBombCurve[i]=1;
							}
						}
					}
				}
				break;
				
			case 2:
				if(eBombY[i]<=eScreenConfig.getY(50)&&eBombY[i]>=eScreenConfig.getY(40)&&eBombCurve[i]==0){
					eBombCurve[i]=1;
				}
				if(eBombY[i]<=eScreenConfig.getY(150)&&eBombY[i]>=eScreenConfig.getY(140)&&eBombCurve[i]==0){
					if(eBombX[i]<=eScreenConfig.getX(1950)&&eBombX[i]>=eScreenConfig.getX(1940)&&eBombCurve[i]==0){
						eBombCurve[i]=1;
					}
				}
				for(int j=0;j<blocknum;j++){
					if(blockon[j]==1){
						if(eBombY[i]<=blocky[j]+eScreenConfig.getY(100)&&eBombY[i]>=blocky[j]+eScreenConfig.getY(90)){
							if(eBombX[i]<=blockx[j]+eScreenConfig.getX(10)&&eBombX[i]>=blockx[j]-eScreenConfig.getX(10)&&eBombCurve[i]==0){
								eBombCurve[i]=1;
							}
						}
					}
				}
				break;
				
			case 3:
				if(eBombY[i]<=eScreenConfig.getY(960)&&eBombY[i]>=eScreenConfig.getY(950)&&eBombCurve[i]==0){
					eBombCurve[i]=1;
				}
				for(int j=0;j<blocknum;j++){
					if(blockon[j]==1){
						if(eBombY[i]<=blocky[j]-eScreenConfig.getY(90)&&eBombY[i]>=blocky[j]-eScreenConfig.getY(100)){
							if(eBombX[i]<=blockx[j]+eScreenConfig.getX(10)&&eBombX[i]>=blockx[j]-eScreenConfig.getX(10)&&eBombCurve[i]==0){
								eBombCurve[i]=1;
							}
						}
					}
				}
				break;
		}
		}
		
	}
	
	public void boom(int trapnum,int trapx[],int trapy[],int trapon[],Canvas canvas){
		for(int i=0;i<eBombnum;i++){
			for(int j=0;j<trapnum;j++){
				if(eBombX[i]>=trapx[j]-eScreenConfig.getX(10)&&eBombX[i]<=trapx[j]+eScreenConfig.getX(10)&&trapon[j]==1){
					if(eBombY[i]>=trapy[j]-eScreenConfig.getY(10)&&eBombY[i]<=trapy[j]+eScreenConfig.getY(10)){
						eBombOn[i] = 0;
						trapon[j] = 0;
					}
				}
				if(eBombOn[i]==0){
					eBoomsum++;
					if(eBoomsum>=0&&eBoomsum<8)
						canvas.drawBitmap(eBoom1, (int)(eBombX[i]-0.6*eWidth), (int)(eBombY[i]-0.6*eHeight), null);
					if(eBoomsum>=8&&eBoomsum<15)
						canvas.drawBitmap(eBoom2, (int)(eBombX[i]-0.7*eWidth), (int)(eBombY[i]-0.7*eHeight), null);
					if(eBoomsum>=15&&eBoomsum<22)
						canvas.drawBitmap(eBoom3, (int)(eBombX[i]-0.8*eWidth), (int)(eBombY[i]-0.8*eHeight), null);
					if(eBoomsum>=22&&eBoomsum<27)
						canvas.drawBitmap(eBoom4, (int)(eBombX[i]-0.9*eWidth), (int)(eBombY[i]-0.9*eHeight), null);
					if(eBoomsum>=27&&eBoomsum<30)
						canvas.drawBitmap(eBoom5, (int)(eBombX[i]-eWidth), (int)(eBombY[i]-eHeight), null);
					if(eBoomsum==30){
						eBombX[i]=-eScreenConfig.getX(200);
						eBombY[i]=-eScreenConfig.getY(200);
						eBoomsum = 0;
						eBombOn[i] = -1;
						}
					}
				}
			}	
	}
	
	public void draw(Canvas canvas){
			for(int i=0;i<eBombnum;i++){
				if(eBombOn[i]==1){
					if(eV%16<=7)
						canvas.drawBitmap(eBomb1, (int)(eBombX[i]-eWidth/2), (int)(eBombY[i]-eHeight/2), null);
					else
						canvas.drawBitmap(eBomb2, (int)(eBombX[i]-eWidth/2), (int)(eBombY[i]-eHeight/2), null);
				}
			}
		
		}
	
	
}
