/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thach.gameobjects;

/**
 *
 * @author phamn
 */
import java.awt.Rectangle;

public abstract class Human extends ParticularObject{

    private boolean isJumping;
 
    private boolean isLanding;

    public Human(float x, float y, float width, float height, float mass, int blood, GameWorld gameWorld) {
        super(x, y, width, height, mass, blood, gameWorld);
    }

    
    public abstract void jump();
    
    

    public boolean getIsJumping() {
        return isJumping;
    }
    
    public void setIsLanding(boolean b){
        isLanding = b;
    }
    
    public boolean getIsLanding(){
        return isLanding;
    }
    
    public void setIsJumping(boolean isJumping) {
        this.isJumping = isJumping;
    }

    
    @Override
    public void Update(){
    	
            if(!isLanding){
                if(getGameWorld().physicalMap.haveCollisionWithRightWall(getBoundForCollisionWithMap())!=null){
                   //cho nay neu va vao tuong thi chet luon
                }
                /**
                 * Codes below check the posY of megaMan
                 */
                // plus (+2) because we must check below the character when he's speedY = 0
                Rectangle boundForCollisionWithMapFuture = getBoundForCollisionWithMap();
                boundForCollisionWithMapFuture.y += (getSpeedY()!=0?getSpeedY(): 2);
                Rectangle rectLand = getGameWorld().physicalMap.haveCollisionWithLand(boundForCollisionWithMapFuture);
                
               
               if(rectLand != null){
                    setIsJumping(false);
                    if(getSpeedY() > 0) setIsLanding(true);
                    setSpeedY(0);
                    setPosY(rectLand.y - getHeight()/2 - 1);
                }else{
                    setIsJumping(true);
                    setSpeedY(getSpeedY() + getMass());
                    setPosY(getPosY() + getSpeedY());
                }
            }
    }
    
}
