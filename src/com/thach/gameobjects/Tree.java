package com.thach.gameobjects;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Tree {
	private int x,z;
	private int y;
	public BufferedImage bufIm;
	
	public Tree(int x, int y,int z) {
		super();
		this.x = x;
		this.y = y;
		this.z=z;
	}
	
	public int getX() {
		return x;
	}
	public int getZ(){
		return z;
	}
	public void setZ(int z){
		this.z=z;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	public void giamX(){
		x-=2;
		z-=2;
	}
	
	public void paint(Graphics g)
	{
		try {
			bufIm=ImageIO.read(new File("data\\14.png"));
			g.drawImage(bufIm, x, y, null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		try {
			bufIm=ImageIO.read(new File("data\\14.png"));
			g.drawImage(bufIm, z, y, null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		giamX();
		checkImage();
	}
	
	public void checkImage(){
		if(x<0)
		{
			x=1000;
		}
		if(z<0)
		{
			z=1000;
		}
	}
	
}
