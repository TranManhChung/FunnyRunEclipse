/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thach.gameobjects;

import com.thach.effect.Animation;
import com.thach.effect.CacheDataLoader;
import java.applet.AudioClip;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Megaman extends Human {

    public static final int RUNSPEED = 3;
    
    private Animation runForwardAnim, runBackAnim;
    private Animation idleForwardAnim, idleBackAnim;
    private Animation dickForwardAnim, dickBackAnim;
    private Animation flyForwardAnim, flyBackAnim;
    private Animation landingForwardAnim, landingBackAnim;
    
    
    public Megaman(float x, float y, GameWorld gameWorld) {
        super(x, y, 70, 90, 0.1f, 100, gameWorld);
        
        //shooting1 = CacheDataLoader.getInstance().getSound("bluefireshooting");
        //hurtingSound = CacheDataLoader.getInstance().getSound("megamanhurt");
        

        
        runForwardAnim = CacheDataLoader.getInstance().getAnimation("run");
        runBackAnim = CacheDataLoader.getInstance().getAnimation("run");
        runBackAnim.flipAllImage();   
        
        idleForwardAnim = CacheDataLoader.getInstance().getAnimation("idle");
        idleBackAnim = CacheDataLoader.getInstance().getAnimation("idle");
        idleBackAnim.flipAllImage();
        
        dickForwardAnim = CacheDataLoader.getInstance().getAnimation("dick");
        dickBackAnim = CacheDataLoader.getInstance().getAnimation("dick");
        dickBackAnim.flipAllImage();
        
        flyForwardAnim = CacheDataLoader.getInstance().getAnimation("flyingup");
        flyForwardAnim.setIsRepeated(false);
        flyBackAnim = CacheDataLoader.getInstance().getAnimation("flyingup");
        flyBackAnim.setIsRepeated(false);
        flyBackAnim.flipAllImage();
        
        landingForwardAnim = CacheDataLoader.getInstance().getAnimation("landing");
        landingBackAnim = CacheDataLoader.getInstance().getAnimation("landing");
        landingBackAnim.flipAllImage();

        
    }

    @Override
    public void Update() {

        super.Update();
        
        if(getIsLanding()){
            landingBackAnim.Update(System.nanoTime());
            if(landingBackAnim.isLastFrame()) {
                setIsLanding(false);
                landingBackAnim.reset();
                runForwardAnim.reset();
                runBackAnim.reset();
            }
        }
        
    }

    @Override
    public Rectangle getBoundForCollisionWithEnemy() {
        // TODO Auto-generated method stub
        Rectangle rect = getBoundForCollisionWithMap();

            rect.x = (int) getPosX() - 22;
            rect.y = (int) getPosY() - 40;
            rect.width = 44;
            rect.height = 80;
        return rect;
    }

    @Override
    public void draw(Graphics2D g2) {
        if(getIsJumping()){
           flyForwardAnim.Update(System.nanoTime());
           flyForwardAnim.draw(300, (int) getPosY()-80, g2);//150 va 80 la toa do dat nhan vat
        }else{
           runForwardAnim.Update(System.nanoTime());
           runForwardAnim.draw(300, (int) getPosY() - (int) getGameWorld().camera.getPosY(), g2);
           if(runForwardAnim.getCurrentFrame() == 1) runForwardAnim.setIgnoreFrame(0);       
        }

       }

    @Override
    public void jump() {
        if(!getIsJumping()){
            setIsJumping(true);
            setSpeedY(-5.0f);           
            flyBackAnim.reset();
            flyForwardAnim.reset();
        }
    }



}
