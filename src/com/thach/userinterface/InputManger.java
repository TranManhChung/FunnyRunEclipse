/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thach.userinterface;


import java.awt.event.KeyEvent;

import com.thach.gameobjects.GameWorld;
import com.thach.gameobjects.Megaman;

/**
 *
 * @author phamn
 */
public class InputManger {

    private GameWorld gameWorld;
    
    public InputManger(GameWorld gameWorld){
        this.gameWorld = gameWorld;
    }
    

    public void processKeyPressed(int keyCode){
    
        
        switch(keyCode){
            case KeyEvent.VK_SPACE:
                gameWorld.megaman.jump();
                break;
        }
        
    }
    
    
    public void processKeyReleased(int keyCode){
        
        switch(keyCode){
            
            case KeyEvent.VK_UP:
                System.out.println("You released UP");
                break;
                
            case KeyEvent.VK_DOWN:
                System.out.println("You released DOWN");
                break;
                
            case KeyEvent.VK_LEFT:
                gameWorld.megaman.setSpeedX(0);
                break;
            case KeyEvent.VK_RIGHT:
                gameWorld.megaman.setSpeedX(0);
                break;
                
            case KeyEvent.VK_ENTER:
                
                break;
                
            case KeyEvent.VK_SPACE:
                
                break;
            case KeyEvent.VK_A:
                
                break;
            
        }
        
    }
    
}
