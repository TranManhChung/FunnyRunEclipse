/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thach.userinterface;

import com.thach.effect.CacheDataLoader;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

/**
 *
 * @author phamn
 */
public class GameFrame extends JFrame {
    
    public static final int SCREEN_WIDTH = 1000;
    public static final int SCREEN_HEIGHT = 600;
    
    GamePanel gamePanel;
    
    public GameFrame(){
        
        Toolkit toolkit = this.getToolkit();
        Dimension dimension = toolkit.getScreenSize();
        this.setBounds((dimension.width - SCREEN_WIDTH)/2, (dimension.height - SCREEN_HEIGHT)/2, SCREEN_WIDTH, SCREEN_HEIGHT-95);
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        try {
            CacheDataLoader.getInstance().LoadData();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        
        gamePanel = new GamePanel();
        add(gamePanel);
        
        this.addKeyListener(gamePanel);
        
    }
    
    public void startGame(){
        gamePanel.startGame();
    }
    
    public static void main(String args[]){
        
        GameFrame gameFrame = new GameFrame();
        gameFrame.setVisible(true);
        gameFrame.startGame();
        
    }
    
}
