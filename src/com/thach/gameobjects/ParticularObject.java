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
import com.thach.effect.Animation;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public abstract class ParticularObject extends GameObject {

    private float width;
    private float height;
    private float mass;
    private float speedX;
    private float speedY;
    private int blood;


    public ParticularObject(float x, float y, float width, float height, float mass, int blood, GameWorld gameWorld){

        // posX and posY are the middle coordinate of the object
        super(x, y, gameWorld);
        setWidth(width);
        setHeight(height);
        setMass(mass);
        setBlood(blood);


    }
    
   
    
    public void setMass(float mass){
        this.mass = mass;
    }

    public float getMass(){
            return mass;
    }

    public void setSpeedX(float speedX){
        this.speedX = speedX;
    }

    public float getSpeedX(){
        return speedX;
    }

    public void setSpeedY(float speedY){
        this.speedY = speedY;
    }

    public float getSpeedY(){
        return speedY;
    }

    public void setBlood(int blood){
        if(blood>=0)
                this.blood = blood;
        else this.blood = 0;
    }

    public int getBlood(){
        return blood;
    }

    public void setWidth(float width){
        this.width = width;
    }

    public float getWidth(){
        return width;
    }

    public void setHeight(float height){
        this.height = height;
    }

    public float getHeight(){
        return height;
    }
    
    
    
    /*
    public boolean isObjectOutOfCameraView(){
        if(getPosX() - getGameWorld().camera.getPosX() > getGameWorld().camera.getWidthView() ||
                getPosX() - getGameWorld().camera.getPosX() < -50
            ||getPosY() - getGameWorld().camera.getPosY() > getGameWorld().camera.getHeightView()
                    ||getPosY() - getGameWorld().camera.getPosY() < -50)
            return true;
        else return false;
    }*/
    
    public Rectangle getBoundForCollisionWithMap(){
        Rectangle bound = new Rectangle();
        bound.x = (int) (getPosX() - (getWidth()/2));
        bound.y = (int) (getPosY() - (getHeight()/2));
        bound.width = (int) getWidth();
        bound.height = (int) getHeight();
        return bound;
    }



    public void drawBoundForCollisionWithMap(Graphics2D g2){
        Rectangle rect = getBoundForCollisionWithMap();
        g2.setColor(Color.BLUE);
        g2.drawRect(rect.x - (int) getGameWorld().camera.getPosX(), rect.y - (int) getGameWorld().camera.getPosY(), rect.width, rect.height);
       
    }

    public void drawBoundForCollisionWithEnemy(Graphics2D g2){
        Rectangle rect = getBoundForCollisionWithEnemy();
        g2.setColor(Color.RED);
        g2.drawRect(rect.x - (int) getGameWorld().camera.getPosX(), rect.y - (int) getGameWorld().camera.getPosY(), rect.width, rect.height);
    }

    public abstract Rectangle getBoundForCollisionWithEnemy();

    public abstract void draw(Graphics2D g2);
    
    public void hurtingCallback(){};
	
}

