package com.example.myfirstgame;

import android.graphics.Canvas;
import android.util.*;
import android.view.SurfaceHolder;

public class MainThread extends Thread{
	private SurfaceHolder surfaceholder;
	private MainView mainView;
	private boolean running = false;
	
	public MainThread(SurfaceHolder surfaceHolder,MainView mainView){
		surfaceholder = surfaceHolder;
		this.mainView = mainView;
	}
	
	public SurfaceHolder getSurfaceHolder(){
		return surfaceholder;
	}
	
	public void setRunning(boolean run){
		running = run;
	}
	
	@Override
	public void run(){
		try{
			Canvas c;
			while(running){
				c=null;
				try{
					c = surfaceholder.lockCanvas(null);
					synchronized(surfaceholder){
						try{
							mainView.onDraw(c);
							}
						catch(Exception exTemp){
							exTemp.printStackTrace();
							Log.e("에러1",exTemp.toString());
						}
					}
				}
				finally{
					if(c!=null)
						surfaceholder.unlockCanvasAndPost(c);
					}
				}
		}
		catch(Exception exTot){
			Log.e("에러2",exTot.toString());
		}
	}	
}