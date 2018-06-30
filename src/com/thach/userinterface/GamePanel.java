/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thach.userinterface;

import com.thach.gameobjects.Bird;
import com.thach.gameobjects.GameWorld;
import com.thach.gameobjects.Megaman;
import com.thach.gameobjects.Tree;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author phamn
 */
public class GamePanel extends JPanel implements Runnable, KeyListener {
    
	private Tree tree;//moi them vao
	private Bird bird;//moi them vao
	
    private Thread thread;
    
    private boolean isRunning;
    
    private InputManger inputManger;
    
    private BufferedImage bufImage,bufImage1;
    private Graphics2D bufG2D;
    
    public GameWorld gameWorld;
    
    public GamePanel(){
        
    	tree=new Tree(1000,350,500);
    	bird=new Bird(1000,200);
    	
        gameWorld = new GameWorld();
        inputManger = new InputManger(gameWorld);
        bufImage = new BufferedImage(GameFrame.SCREEN_WIDTH, GameFrame.SCREEN_HEIGHT, BufferedImage.TYPE_INT_ARGB);
        
    }
    
    @Override
    public void paint(Graphics g){
        g.drawImage(bufImage, 0, 0, this);
        tree.paint(g);
        g.setColor(Color.GREEN);
        g.fillRect(0, 442, 1000, 100);
        g.setColor(Color.BLACK);
        g.fillRect(0, 442, 1000, 3);
        
        bird.paint(g);
    }

    public void UpdateGame(){
        gameWorld.Update();
    }
    
    public void RenderGame(){
        if(bufImage == null){
        	bufImage = new BufferedImage(GameFrame.SCREEN_WIDTH, GameFrame.SCREEN_HEIGHT, BufferedImage.TYPE_INT_ARGB);
        }
        
        if(bufImage != null){
            bufG2D = (Graphics2D) bufImage.getGraphics();
        }
       
        if(bufG2D != null){
            //bufG2D.setColor(Color.BLUE);
            //bufG2D.fillRect(0, 0, GameFrame.SCREEN_WIDTH, GameFrame.SCREEN_HEIGHT);
            gameWorld.Render(bufG2D);
            
        }
    }
    
    public void startGame(){
        if(thread == null){
            isRunning = true;
            thread = new Thread(this);
            thread.start();
        }
    }
    
    @Override
    public void run() {
    
        long FPS = 80;
        long period = 1000*1000000/FPS;
        long beginTime;
        long sleepTime;
        
        beginTime = System.nanoTime();
        
        while(isRunning){
            //System.out.println("a = "+(a++));
            UpdateGame();
            RenderGame();
            repaint();
            
            long deltaTime = System.nanoTime() - beginTime;
            sleepTime = period - deltaTime;
            
            
            try {
                if(sleepTime > 0)
                    Thread.sleep(sleepTime/1000000);
                else Thread.sleep(period/2000000);
            } catch (InterruptedException ex) {}
            
            beginTime = System.nanoTime();
            
        }
    
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) { // callback method
        
        inputManger.processKeyPressed(e.getKeyCode());
    
    }

    @Override
    public void keyReleased(KeyEvent e) {
      
        inputManger.processKeyReleased(e.getKeyCode());
    }
    
}
