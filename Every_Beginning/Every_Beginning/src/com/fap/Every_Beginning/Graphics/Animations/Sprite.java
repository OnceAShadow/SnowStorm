
package com.fap.Every_Beginning.Graphics.Animations;

public class Sprite {

	public final int DIMENSIONSPRITE;
	private int x, y;
	public int widthSprite, heightSprite;
	public int[] pixelsSprite;
	protected SpriteSheet spriteSheet;
	
	// SpritesMateriel
	public static Sprite spriteVoid = new Sprite(64, 64, 0x5D3F97);
	public static Sprite spriteG = new Sprite(64, 64, 0xff00ff);
	public static Sprite spriteR = new Sprite(64, 64, 0xf50505);
	
	
	public static Sprite spriteGrass = new Sprite(64, 64, 0, 0, SpriteSheet.tiles_Base);
	public static Sprite spriteRock = new Sprite(64, 64, 1, 0, SpriteSheet.tiles_Base);
	/*public static Sprite spriteWater = new Sprite(64, 64, 2, 0, SpriteSheet.tiles_Base);
	public static Sprite spriteSand = new Sprite(64, 64, 3, 0, SpriteSheet.tiles_Base);
	public static Sprite spriteWoodFloor = new Sprite(64, 64, 0, 1, SpriteSheet.tiles_Base);
	public static Sprite spriteWoodWall = new Sprite(64, 64, 1, 1, SpriteSheet.tiles_Base);
	public static Sprite spriteRockWall = new Sprite(64, 64, 2, 1, SpriteSheet.tiles_Base);
	public static Sprite spriteRockFloor = new Sprite(64, 64, 3, 1, SpriteSheet.tiles_Base);
	public static Sprite spriteIce = new Sprite(64, 64, 0, 2, SpriteSheet.tiles_Base);
	public static Sprite spriteSnow = new Sprite(64, 64, 1, 2, SpriteSheet.tiles_Base);
	public static Sprite spriteLava = new Sprite(64, 64, 2, 2, SpriteSheet.tiles_Base);
	public static Sprite spriteSoil = new Sprite(64, 64, 3, 2, SpriteSheet.tiles_Base);
	

	// Sprites Joueur
	
	public static Sprite spritePlayer_Base = new Sprite(64, 64, 0, 0, SpriteSheet.player_Base_Down);
	
	// Sprites Monstres
	public static Sprite spriteZombie_Base = new Sprite(64, 64, 0, 0, SpriteSheet.zombie_Base_Down);
	
	
	// Sprites Particules	
	public static Sprite spriteParticules1 = new Sprite(3, 3, 0xFFAAAAAA);
	*/
	
	protected Sprite(SpriteSheet spriteSheet, int widthSprite, int heightSprite) {
		
		this.widthSprite = widthSprite;
		this.heightSprite = heightSprite;
		this.spriteSheet = spriteSheet;
	
		// cest la meme syntaxe que : DIMENSIONSPRITE = (LargeurSprite == HauteurSprite) ? LargeurSprite : -1;
		if (widthSprite == heightSprite) DIMENSIONSPRITE = widthSprite;
		else DIMENSIONSPRITE = -1;	
	}
		
	public Sprite(int widthSprite, int heightSprite, int x, int y, SpriteSheet spriteSheet) {
		if (widthSprite == heightSprite) DIMENSIONSPRITE = widthSprite;
		else DIMENSIONSPRITE = -1;	
		this.widthSprite = widthSprite;
		this.heightSprite = heightSprite;
		pixelsSprite = new int[widthSprite * heightSprite];
		this.x = x * widthSprite;
		this.y = y * heightSprite;
		this.spriteSheet = spriteSheet;
		loadSprite();		
	}

	
	public Sprite(int widthSprite, int heightSprite, int color) {
		if (widthSprite == heightSprite) DIMENSIONSPRITE = widthSprite;
		else DIMENSIONSPRITE = -1;	
		this.widthSprite = widthSprite;
		this.heightSprite = heightSprite;
		pixelsSprite = new int[widthSprite * heightSprite];
		setColor(color);
	}
	public Sprite(int[] pixelsSprite, int widthSprite, int heightSprite) {
		if (widthSprite == heightSprite) DIMENSIONSPRITE = widthSprite;
		else DIMENSIONSPRITE = -1;
		this.widthSprite = widthSprite;
		this.heightSprite = heightSprite;
		this.pixelsSprite = new int[pixelsSprite.length];
		for (int i = 0; i < pixelsSprite.length; i++) {
			this.pixelsSprite[i] = pixelsSprite[i];
		}			
	}
	
	/*
	
	public static Sprite Rotate(Sprite sprite, double Angle) {
		return new Sprite(Rotation(sprite.PixelsSprite, sprite.WidthSprite, sprite.HeightSprite, Angle), sprite.WidthSprite, sprite.HeightSprite);
	}
	
	public static int[] Rotation(int[] Pixels, int Largeur, int Hauteur, double Angle) {
		int[] Resultat = new int[Largeur * Hauteur];
		
		double nx_x = RotationX(-Angle, 1.0, 0.0);
		double nx_y = RotationY(-Angle, 1.0, 0.0);
		double ny_x = RotationX(-Angle, 0.0, 1.0);
		double ny_y = RotationY(-Angle, 0.0, 1.0);
		
		double x0 = RotationX(- Angle, - Largeur / 2.0, - Hauteur / 2.0) + Largeur / 2.0;
		double y0 = RotationY(- Angle, - Largeur / 2.0, - Hauteur / 2.0) + Hauteur / 2.0;
		
		for (int y = 0; y < Hauteur; y++) {
			double x1 = x0;
			double y1 = y0;
			
			for (int x = 0; x < Largeur; x++) {
				int xx = (int) x1;
				int yy = (int) y1;
				int Couleur = 0;
				
				if (xx < 0 || xx >= Largeur || yy < 0 || yy >= Hauteur) Couleur = 0xFFFF00FF;
				else {
					Couleur = Pixels[xx + yy * Largeur];
				}
				
			//	System.out.println("Couleur : " + Couleur);
			//	System.out.println("Alpha : " + ALPHA_COULEUR1);
				
				Resultat[x + y * Largeur] = Couleur;
				x1 += nx_x;
				y1 += nx_y;		
			}
			x0 += ny_x;
			y0 += ny_y;
		}
		return Resultat;	
	}
	
	private static double RotationX(double Angle, double x, double y) {
		double cos = Math.cos(Angle - Math.PI /1.67);
		double sin = Math.sin(Angle - Math.PI /1.67);
		double Resultat = x * cos + y * -sin;
		return Resultat;
	}
	
	private static double RotationY(double Angle, double x, double y) {
		double cos = Math.cos(Angle - Math.PI /1.14);
		double sin = Math.sin(Angle - Math.PI /1.14);
		double Resultat = x * sin + y * cos;
		return Resultat;
	}
	/*
	 */
	
	public static Sprite[] Split(SpriteSheet sheet) {
		int amountOfSprite = ((sheet.getWidthSpriteSheet() * sheet.getHeightSpriteSheet()) / (sheet.WIDTH_SPRITE * sheet.HEIGHT_SPRITE));
		Sprite[] sprites = new Sprite[amountOfSprite];
		int currentSprite = 0;
		int[] currentPixels = new int[sheet.WIDTH_SPRITE * sheet.HEIGHT_SPRITE];
		
		for (int yPosition = 0; yPosition < sheet.getHeightSpriteSheet() / sheet.HEIGHT_SPRITE; yPosition++) {
			for (int xPosition = 0; xPosition < sheet.getWidthSpriteSheet() / sheet.WIDTH_SPRITE; xPosition++) {
				
				for (int currentY = 0; currentY < sheet.HEIGHT_SPRITE; currentY++){
					for (int currentX = 0; currentX < sheet.WIDTH_SPRITE; currentX++){
						int xDecallage = (currentX + xPosition * sheet.WIDTH_SPRITE);
						int yDecallage = (currentY + yPosition * sheet.HEIGHT_SPRITE);
						currentPixels[currentX + currentY * sheet.WIDTH_SPRITE] = sheet.getPixels()[xDecallage + yDecallage * sheet.getWidthSpriteSheet()];				
					}
				}
				
				sprites[currentSprite] = new Sprite(currentPixels, sheet.WIDTH_SPRITE, sheet.HEIGHT_SPRITE);
				currentSprite++;
			}
		}	
		return sprites;
	}

	private void setColor(int color) {
		for(int i = 0; i < widthSprite * heightSprite; i++) {
			pixelsSprite[i] = color;
		}
	}
	
	public int getWidthSprite() {
		return widthSprite;
	}
	
	public int getHeightSprite() {
		return heightSprite;
	}
	
	private void loadSprite() {

		for (int y = 0; y < heightSprite; y++) {
			for (int x = 0; x < widthSprite; x++) {
				pixelsSprite[x + y * widthSprite] = spriteSheet.pixelsSpriteSheet[(x + this.x) + (y + this.y) * spriteSheet.WIDTH_SPRITE];
                System.out.println(pixelsSprite[x + y * widthSprite]);

			}
		}
	}	
}
