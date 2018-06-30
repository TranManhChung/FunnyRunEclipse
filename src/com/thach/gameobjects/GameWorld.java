/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thach.gameobjects;

import com.thach.gameobjects.PhysicalMap;
import com.thach.userinterface.GameFrame;
import java.awt.Graphics2D;

/**
 *
 * @author phamn
 */
public class GameWorld {
    
    public Megaman megaman;
    
    public Camera camera;

	public PhysicalMap physicalMap;
    
    public GameWorld(){
        megaman = new Megaman(300,300, this);
        physicalMap = new PhysicalMap(0, 0, this);
        camera = new Camera(0, 0, GameFrame.SCREEN_WIDTH, GameFrame.SCREEN_HEIGHT, this);
    }
    
    public void Update(){
        
        megaman.Update();
        camera.Update();
        
    }
    
    public void Render(Graphics2D g2){
        megaman.draw(g2);
        physicalMap.draw(g2);
    }
    
}
