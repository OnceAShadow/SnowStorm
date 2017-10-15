package com.fap.Every_Beginning.Graphics.World;

import java.awt.image.BufferedImage;

import java.io.IOError;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class LevelWorld extends Level {

	public LevelWorld(String path) {
	    super(path);
	}
	
	protected void loadLevel(String path) {
		try {
            BufferedImage frameInScreens = ImageIO.read(LevelWorld.class.getResource(path));
            
            int w = widthLevel = frameInScreens.getWidth();
			int h = heightLevel = frameInScreens.getHeight();;
			levelTiles = new int[widthLevel * heightLevel];


			frameInScreens.getRGB(0, 0, w, h, levelTiles, 0, widthLevel);

		} catch (IOException e) { 

		}
		
		
		/*
		for (int i = 0; i < 10; i++){
			AjouterEntite(new NPCLapin(ALEATOIRE.nextInt(30) + 15, ALEATOIRE.nextInt(30) + 15));
			AjouterEntite(new NPCPapillon(ALEATOIRE.nextInt(30) + 15, ALEATOIRE.nextInt(30) + 15));
			AjouterEntite(new FantomeInofensif(ALEATOIRE.nextInt(30) + 15, ALEATOIRE.nextInt(30) + 15));
		}
		
		for (int i = 0; i < 1; i++){
			
			//AjouterEntite(new FantomeFeu(30, 35));
			//AjouterEntite(new FantomeInofensif(28, 35));
			//AjouterEntite(new FantomeFeu(28, 32));
			//AjouterEntite(new FantomeFeu(22, 38));
			
			AjouterEntite(new FantomeFutee(26, 30));
			AjouterEntite(new FantomeSuiveur(28, 30));
			
			AjouterEntite(new FantomeInofensif(45, 15));
			AjouterEntite(new NPCLapin(45, 15));
			AjouterEntite(new NPCPapillon(45, 15));
	
			
		}
				
		 */	
	}
	
	protected void generateLevel() {		
	}
}
