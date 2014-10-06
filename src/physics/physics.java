package physics;

import java.awt.Component;
import java.awt.Graphics;

public class Physics {
    
    private int radio = 5;
    
    private float mX = 0;
    
    private float mY = 0;
        
    private double mVY = 0 ;
    
    private double mAY = 0.15 ;    
    
    private double mVX = 1 ;
    
    private int mH = 100;    
    
    private Component mArea = null;    
    
    private int mDireccion = 1 ; // cayendo
    
    private boolean mFin = false;
    
    private boolean mOutOfArea = false;
    
    private double mK = 0.1; 
    
    public Physics() {
     
    }
    
    public void actualizarEstado() {
      
      if( mFin || mOutOfArea )          
      {
          return;
      }
      
      //mX += mVX ;
      
      if( mDireccion == 1 )                  {
          
          mY -= mVY;
                    
          if( mY < radio*2 ) {
              
              //mY = 0 ;
              
              mDireccion = 2;
              
              double delta = mVY * mK ; 
              
              System.out.println("Delta -" + delta );
              
              System.out.println("VY " + mVY );
              
              double newVY = mVY - (delta+0.01) ;
              
              if( delta < 0.1 ) {
                    //mFin = true;
            	  
              }
              
              System.out.println("NEW VY " + newVY );
              
              mVY = (float)newVY;
                          
          } else {
              mVY += mAY;
          }
          
      } else if( mDireccion == 2 ) {
          
          //mY += mVY;
          
          mVY -= mAY;
          
          if( mVY < 0 ) {
          
            mVY = 0;
            
            mDireccion = 1; 
              
          }
          
      }
          
    }   

    public void setRadio(int radio) {
        this.radio = radio;
    }

    public int getRadio() {
        return Radio;
    }

    public int getX() {
        return (int)mX;
    }
    
    public void setX(float x){
    	this.mX = x;
    }

    public int getY() {
        return (int)mY;
    }
    public void setY(float y){
    	this.mY=y;
    }

    public void setArea(Component mArea) {
        this.mArea = mArea;
    }

    public Component getArea() {
        return mArea;
    }

    public void setH(int mH) {
        this.mY = mH;
        this.mH = mH;
    }

    public int getH() {
        return mH;
    }

    public void setVY(double mVY) {
        this.mVY = mVY;
    }

    public double getVY() {
        return mVY;
    }

    public void setAY(double mAY) {
        this.mAY = mAY;
    }

    public double getAY() {
        return mAY;
    }

    public void setVX(double mVX) {
        this.mVX = mVX;
    }

    public double getVX() {
        return mVX;
    }

    public boolean isOutOfArea() {
        return mOutOfArea || mFin ;
    }

    public void setK(double mK) {
        this.mK = mK;
    }

    public double getK() {
        return mK;
    }
    
    public void jump()
    {
    	setY(getY()+3);
    }
   
    public void moveLeft()
    {
    	setX(getX() -1);
    }
  
    public void moveRight(){
    	setX(getX() +1);
    }
    
}
