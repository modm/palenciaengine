package physics;

import java.awt.Color;
import java.awt.Component;

public class Physics {
	
		private int mRadioBola = 5;
	    private float mX = 0;
	    private float mY = 0;
	    private double mVY = 0 ;
	    private double mAY = .9 ;    
	    private double mVX = 1 ;
	    private int mH = 100;
	    private Component mArea = null;    
	    private int mDireccion = 1 ; // cayendo
	    private boolean mFin = false;
	    private boolean mOutOfArea = false;
	    private double mK = 0.1; 
	    
	    public float getmX() {
			return mX;
		}
		public void setmX(float mX) {
			this.mX = mX;
		}
		public float getmY() {
			return mY;
		}
		public void setmY(float mY) {
			this.mY = mY;
		}
		public double getmVY() {
			return mVY;
		}
		public void setmVY(double mVY) {
			this.mVY = mVY;
		}
		public double getmAY() {
			return mAY;
		}
		public void setmAY(double mAY) {
			this.mAY = mAY;
		}
		public double getmVX() {
			return mVX;
		}
		public void setmVX(double mVX) {
			this.mVX = mVX;
		}
		public int getmH() {
			return mH;
		}
		public void setmH(int mH) {
			this.mH = mH;
		}
		public boolean ismFin() {
			return mFin;
		}
		public void setmFin(boolean mFin) {
			this.mFin = mFin;
		}
		public boolean ismOutOfArea() {
			return mOutOfArea;
		}
		public void setmOutOfArea(boolean mOutOfArea) {
			this.mOutOfArea = mOutOfArea;
		}
		
		public float Fall(float posY,float aceY){
			
			float x= posY-=aceY;
			return x;
		}
		
		
		public double Break(float VelY){
			
			double delta=(double)VelY*mK;
			double newVY = VelY - (delta+0.01) ;
			return newVY;
		}
		
		public boolean CheckEnd(double check){
			if(check<0.1){
			boolean x=true;
			return x;
			}else{
				return false;
			}
			
		}
		
		public int CheckFall(float posY,float posCenter){
			if(posY<posCenter){
			return 2;
		
			}else{
				return 1;
			}
			
		}
		
		public float UP(float posY,float aceY){
			float x=posY += aceY;
			return x;
			
		}
		
		public float LoseSpeed(float aceY,float velY){
			float x=velY -= aceY;
			return x;
			
		}
	    
	    
}
