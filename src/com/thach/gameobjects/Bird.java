package com.thach.gameobjects;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Bird {
private int x,y;
public BufferedImage imageBird;
 

public Bird(int x, int y) {
	super();

	this.x = x;
	this.y = y;
	
}

public int getX() {
	return x;
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

public boolean repeat=false;
public void paint(Graphics g){
	try {
		imageBird=ImageIO.read(new File("data\\chim.png"));
		g.drawImage(imageBird, x, y, null);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	giamX();
	check();
}

public void giamX(){
	x-=3;
}

public void check(){
	if(x<0)
	{		x=1000;
		if(repeat==false)
	{

		y=280;
		repeat=true;
	}
	else{
		y=150;
		repeat=false;
	}
	}
}

}
