package com.fap.Every_Beginning.Core;

import com.fap.Every_Beginning.Graphics.Animations.ScreenDisplay;
import com.fap.Every_Beginning.Graphics.Animations.Sprite;
import com.fap.Every_Beginning.Graphics.World.GameWorld;
import com.fap.*;

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

        int widthLevel = Keeper.gameWorld.getWidthLevel();
        int HeightLevel = Keeper.gameWorld.getHeightLevel();
        int[] pixelsLevel = new int[widthLevel * HeightLevel * 64 * 64];
        for (int y = 0; y < HeightLevel; y++) {
    		for (int x = 0; x < widthLevel; x++) {
    		//System.out.println("x : " + x);
    		for (int yy = 0; yy < Keeper.gameWorld.getTile()[x + y * widthLevel].sprite.heightSprite; yy++) {
    			for (int xx = 0; xx < Keeper.gameWorld.getTile()[x + y * widthLevel].sprite.widthSprite; xx++) {
    			//	System.out.println("position pixels :  " + xx + (yy * screen.width));
    				Sprite temp = Keeper.gameWorld.getTile()[x + y * widthLevel].sprite;
    				int widhtSprite = Keeper.gameWorld.getTile()[x + y * widthLevel].sprite.widthSprite;
    				
    				pixelsLevel[((x + (y * widthLevel)) * (xx + yy * widhtSprite))] = temp.pixelsSprite[xx + yy * widhtSprite];
    				System.out.println("position pixel:  " + ((x + (y * widthLevel)) * (xx + yy * widhtSprite)));
    				System.out.println("couleur pixel :  " + pixelsLevel[((x + (y * widthLevel)) * (xx + yy * widhtSprite))]);
    				//pixelsInFrame[] = Keeper.gameWorld.getTile()[x + y * widthLevel].sprite.pixelsSprite[xx + yy * Keeper.gameWorld.getTile()[x + y * widthLevel].sprite.widthSprite];
    			}
    		}
    		//System.out.println("y : " + y);
     	}
        for (int i = 0; i < pixelsInFrame.length; i++) {
            pixelsInFrame[i] = pixelsLevel[i];
        }

        graphics.drawImage(imageInFrame, 0, 0, screen.width, screen.height, null);
    	graphics.dispose();
    	BufferStrategy.show();
//        //level.renderLevel(-100, -100, screen);
//
//
//        Graphics graphics = BufferStrategy.getDrawGraphics();
//        graphics.setColor(new Color(0xFF00FF));
//        graphics.fillRect(0, 0, screen.width, screen.height);
//
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
}
