package com.fap.Every_Beginning.Core;

import com.fap.Every_Beginning.Graphics.Animations.ScreenDisplay;
import com.fap.Every_Beginning.Graphics.Animations.Sprite;
import com.fap.Every_Beginning.Graphics.World.GameWorld;
import com.fap.Every_Beginning.Graphics.World.Tiles.Tile;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

public class DrawSlave {

    protected JFrame frame;
    protected ScreenDisplay screen;
    protected GameOn game;
    protected GameWorld gameWorld;

    private BufferedImage imageInFrame;
    private int[] pixelsInFrame;



    public DrawSlave(GameOn game, JFrame frame, ScreenDisplay screen, GameWorld gameWorld) {
        this.game = game;
        this.frame = frame;
        this.screen = screen;
        this.gameWorld = gameWorld;
        this.imageInFrame = new BufferedImage(screen.width, screen.height, BufferedImage.TYPE_INT_RGB);
        this.pixelsInFrame = ((DataBufferInt) imageInFrame.getRaster().getDataBuffer()).getData();
    }

    public void drawWorld() {


        BufferStrategy BufferStrategy = game.getBufferStrategy();

        if (BufferStrategy == null) {
            game.createBufferStrategy(3);
            return;
        }
        Graphics graphics = BufferStrategy.getDrawGraphics();

        graphics.drawLine(100,100, 100, 200);
        graphics.dispose();
        BufferStrategy.show();



    	for (int y = 0; y < Keeper.gameWorld.getHeightLevel(); y++) {
    		for (int x = 0; x < Keeper.gameWorld.getWidthLevel(); x++) {
    		System.out.println("x : " + x);
    		}
    		System.out.println("y : " + y);
     	}

//        //level.renderLevel(-100, -100, screen);
//
//        for (int i = 0; i < pixelsInFrame.length; i++) {
//            pixelsInFrame[i] = screen.pixelsScreen[i];
//        }
//
//        Graphics graphics = BufferStrategy.getDrawGraphics();
//        graphics.setColor(new Color(0xFF00FF));
//        graphics.fillRect(0, 0, screen.width, screen.height);
//
//        graphics.drawImage(imageInFrame, 0, 0, screen.width, screen.height, null);
//        graphics.dispose();
//        BufferStrategy.show();
    	
    	
    	
    	/*
    	boucle world
    	
    	for 
    	
    	boucle tuile
    	boucle pixel
    	
    	
    	
    	
    	*/
    	
    	
    	
    	
    	
    	
    }
}
