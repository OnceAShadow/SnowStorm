
package com.fap.Every_Beginning.Graphics.Animations;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class SpriteSheet {
	private String path;
	public final int DIMENSIONSPRITESHEET;
	public final int WIDTH_SPRITE, HEIGHT_SPRITE;
	private int widthSpriteSheet, heightSpriteSheet;
	public int[] pixelsSpriteSheet;
	
	
	
	public static SpriteSheet tiles_Base = new SpriteSheet("/Textures/SpriteSheets/Tiles/TilesStarterKit.png", 256, 192, 64, 64);
	
	public static SpriteSheet player_Base = new SpriteSheet("/Textures/SpriteSheets/Players/Player_Base/Player_Base.png", 256, 192, 64, 64);

	public static SpriteSheet player_Base_Up = new SpriteSheet(player_Base, 2, 0, 1, 3, 64, 64);
	public static SpriteSheet player_Base_Left = new SpriteSheet(player_Base, 3, 0, 1, 3, 64, 64);
	public static SpriteSheet player_Base_Down = new SpriteSheet(player_Base, 0, 0, 1, 3, 64, 64);
	public static SpriteSheet player_Base_Right = new SpriteSheet(player_Base, 1, 0, 1, 3, 64, 64);
	
	public static SpriteSheet zombie_Base = new SpriteSheet("/Textures/SpriteSheets/Mobs/Zombie_Base/Zombie_Base.png", 256, 192, 64, 64);

	public static SpriteSheet zombie_Base_Up = new SpriteSheet(zombie_Base, 2, 0, 1, 3, 64, 64);
	public static SpriteSheet zombie_Base_Left = new SpriteSheet(zombie_Base, 3, 0, 1, 3, 64, 64);
	public static SpriteSheet zombie_Base_Down = new SpriteSheet(zombie_Base, 0, 0, 1, 3, 64, 64);
	public static SpriteSheet zombie_Base_Right = new SpriteSheet(zombie_Base, 1, 0, 1, 3, 64, 64);
	
		
	private Sprite[] sprites;
	
	public SpriteSheet(SpriteSheet spriteSheet, int x, int y, int amountSpriteWidth, int amountSpriteHeight, int dimensionSpriteWidth, int dimensionSpriteHeight) {
		int xx = x * dimensionSpriteWidth;
		int yy = y * dimensionSpriteHeight;
		int widthSprite = amountSpriteWidth * dimensionSpriteWidth;
		int heightSprite = amountSpriteHeight * dimensionSpriteHeight;
		
		if (amountSpriteWidth == amountSpriteHeight) DIMENSIONSPRITESHEET = amountSpriteWidth;
		else DIMENSIONSPRITESHEET = -1;
		
		WIDTH_SPRITE = widthSprite;
		HEIGHT_SPRITE = heightSprite;
		pixelsSpriteSheet = new int[widthSprite * heightSprite];
		
		for (int y0 = 0; y0 < heightSprite; y0++) {
			int yPosition = yy + y0;
			for (int x0 = 0; x0 < widthSprite; x0++) {
				int xPosition = xx + x0;
			
				pixelsSpriteSheet[x0 + y0 * widthSprite] = spriteSheet.pixelsSpriteSheet[xPosition + yPosition * spriteSheet.WIDTH_SPRITE];
							
			}
		}
	
		int frame = 0;
		sprites = new Sprite[amountSpriteWidth * amountSpriteHeight];
	
		for (int yAbsolu = 0; yAbsolu < amountSpriteHeight; yAbsolu++) {
			for (int xAbsolu = 0; xAbsolu < amountSpriteWidth; xAbsolu++) {
				int[] PixelsSprite = new int[dimensionSpriteWidth * dimensionSpriteHeight];
				for (int y1 = 0; y1 < dimensionSpriteHeight; y1++) {
					for (int x1 = 0; x1 < dimensionSpriteWidth; x1++) {
		 
						PixelsSprite[x1 + y1 * dimensionSpriteWidth] = pixelsSpriteSheet[(x1 + xAbsolu * dimensionSpriteWidth) + (y1 + yAbsolu * dimensionSpriteHeight) * WIDTH_SPRITE];
										
					}
				}	 
				Sprite sprite = new Sprite(PixelsSprite, dimensionSpriteWidth, dimensionSpriteHeight);	
				sprites[frame++] = sprite;
			}
		}	
		
		
	}

	public SpriteSheet(String path, int widthSpriteSheet, int heightSpriteSheet, int widthSprite, int heightSprite) {
		this.path = path;
		DIMENSIONSPRITESHEET = - 1;
		this.widthSpriteSheet = widthSpriteSheet;
		this.heightSpriteSheet = heightSpriteSheet;
		WIDTH_SPRITE = widthSprite;
		HEIGHT_SPRITE = heightSprite;
		pixelsSpriteSheet = new int[widthSpriteSheet * heightSpriteSheet];
		loadSpriteSheet();
	}

	public Sprite[] getSprites() {
		return sprites;
	}

	public int getWidthSpriteSheet() {
		return widthSpriteSheet;
	}
	
	public int getHeightSpriteSheet() {
		return heightSpriteSheet;
	}
	
	public int[] getPixels() {
		return pixelsSpriteSheet;
	}
	
	private void loadSpriteSheet() {
		
			try {
				System.out.println("Chargement" + path);
				BufferedImage imageSpriteSheet = ImageIO.read(SpriteSheet.class.getResource(path));
				System.out.println("Reussi" + path);
				
				widthSpriteSheet = imageSpriteSheet.getWidth();
				heightSpriteSheet = imageSpriteSheet.getHeight();
				pixelsSpriteSheet = new int[widthSpriteSheet * heightSpriteSheet];
				imageSpriteSheet.getRGB(0, 0, widthSpriteSheet, heightSpriteSheet, pixelsSpriteSheet, 0, widthSpriteSheet);
			} 	catch (IOException e) {
					e.printStackTrace();
				}
				catch (Exception e) {
					System.err.println("Rater");
				}
		
		
		}
}
