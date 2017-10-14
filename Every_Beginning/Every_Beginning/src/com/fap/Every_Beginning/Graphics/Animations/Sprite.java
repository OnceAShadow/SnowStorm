
package com.fap.Every_Beginning.Graphics.Animations;

public class Sprite {

	public final int DIMENSIONSPRITE;
	private int x, y;
	public int WidthSprite, HeightSprite;
	public int[] PixelsSprite;
	protected SpriteSheet spriteSheet;
	
	// SpritesMateriel
	public static Sprite TuileVide = new Sprite(64, 64, 0x5D3F97);
	
	
	public static Sprite Grass = new Sprite(64, 64, 0, 0, SpriteSheet.Tiles_Base);
	public static Sprite Rock = new Sprite(64, 64, 1, 0, SpriteSheet.Tiles_Base);
	public static Sprite Water = new Sprite(64, 64, 2, 0, SpriteSheet.Tiles_Base);
	public static Sprite Sand = new Sprite(64, 64, 3, 0, SpriteSheet.Tiles_Base);
	public static Sprite WoodFloor = new Sprite(64, 64, 0, 1, SpriteSheet.Tiles_Base);
	public static Sprite WoodWall = new Sprite(64, 64, 1, 1, SpriteSheet.Tiles_Base);
	public static Sprite RockWall = new Sprite(64, 64, 2, 1, SpriteSheet.Tiles_Base);
	public static Sprite RockFloor = new Sprite(64, 64, 3, 1, SpriteSheet.Tiles_Base);
	public static Sprite Ice = new Sprite(64, 64, 0, 2, SpriteSheet.Tiles_Base);
	public static Sprite Snow = new Sprite(64, 64, 1, 2, SpriteSheet.Tiles_Base);
	public static Sprite Lava = new Sprite(64, 64, 2, 2, SpriteSheet.Tiles_Base);
	public static Sprite Soil = new Sprite(64, 64, 3, 2, SpriteSheet.Tiles_Base);
	

	// Sprites Joueur
	
	public static Sprite Player_Base = new Sprite(64, 64, 0, 0, SpriteSheet.Player_Base_Down);
	
	// Sprites Monstres
	public static Sprite Zombie_Base = new Sprite(64, 64, 0, 0, SpriteSheet.Zombie_Base_Down);
	
	
	// Sprites Particules	
	public static Sprite Particules1 = new Sprite(3, 3, 0xFFAAAAAA);
	
	
	protected Sprite(SpriteSheet SpriteSheet, int LargeurSprite, int HauteurSprite) {
		
		this.WidthSprite = LargeurSprite;
		this.HeightSprite = HauteurSprite;
		this.spriteSheet = SpriteSheet;
	
		// cest la meme syntaxe que : DIMENSIONSPRITE = (LargeurSprite == HauteurSprite) ? LargeurSprite : -1;
		if (LargeurSprite == HauteurSprite) DIMENSIONSPRITE = LargeurSprite;
		else DIMENSIONSPRITE = -1;	
	}
		
	public Sprite(int WidthSprite, int HeightSprite, int x, int y, SpriteSheet spriteSheet) {
		if (WidthSprite == HeightSprite) DIMENSIONSPRITE = WidthSprite;
		else DIMENSIONSPRITE = -1;	
		this.WidthSprite = WidthSprite;
		this.HeightSprite = HeightSprite;
		PixelsSprite = new int[WidthSprite * HeightSprite];
		this.x = x * WidthSprite;
		this.y = y * HeightSprite;
		this.spriteSheet = spriteSheet;
		LoadSprite();		
	}

	
	public Sprite(int WidthSprite, int HeightSprite, int Color) {
		if (WidthSprite == HeightSprite) DIMENSIONSPRITE = WidthSprite;
		else DIMENSIONSPRITE = -1;	
		this.WidthSprite = WidthSprite;
		this.HeightSprite = HeightSprite;
		PixelsSprite = new int[WidthSprite * HeightSprite];
		SetColor(Color);
	}
	public Sprite(int[] PixelsSprite, int LargeurSprite, int HauteurSprite) {
		if (LargeurSprite == HauteurSprite) DIMENSIONSPRITE = LargeurSprite;
		else DIMENSIONSPRITE = -1;
		this.WidthSprite = LargeurSprite;
		this.HeightSprite = HauteurSprite;
		this.PixelsSprite = new int[PixelsSprite.length];
		for (int i = 0; i < PixelsSprite.length; i++) {
			this.PixelsSprite[i] = PixelsSprite[i];
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
	
	public static Sprite[] Separer(SpriteSheet Sheet) {
		int QuantiteSprite = ((Sheet.GetWidthSpriteSheet() * Sheet.GetHeightSpriteSheet()) / (Sheet.WIDTH_SPRITE * Sheet.HEIGHT_SPRITE));
		Sprite[] Sprites = new Sprite[QuantiteSprite];
		int SpriteEnCours = 0;
		int[] PixelsEnCours = new int[Sheet.WIDTH_SPRITE * Sheet.HEIGHT_SPRITE];
		
		for (int yPosition = 0; yPosition < Sheet.GetHeightSpriteSheet() / Sheet.HEIGHT_SPRITE; yPosition++) {
			for (int xPosition = 0; xPosition < Sheet.GetWidthSpriteSheet() / Sheet.WIDTH_SPRITE; xPosition++) {
				
				for (int yEnCours = 0; yEnCours < Sheet.HEIGHT_SPRITE; yEnCours++){
					for (int xEnCours = 0; xEnCours < Sheet.WIDTH_SPRITE; xEnCours++){
						int xDecallage = (xEnCours + xPosition * Sheet.WIDTH_SPRITE);
						int yDecallage = (yEnCours + yPosition * Sheet.HEIGHT_SPRITE);
						PixelsEnCours[xEnCours + yEnCours * Sheet.WIDTH_SPRITE] = Sheet.GetPixels()[xDecallage + yDecallage * Sheet.GetWidthSpriteSheet()];				
					}
				}
				
				Sprites[SpriteEnCours] = new Sprite(PixelsEnCours, Sheet.WIDTH_SPRITE, Sheet.HEIGHT_SPRITE);
				SpriteEnCours++;
			}
		}	
		return Sprites;
	}

	private void SetColor(int Color) {
		for(int i = 0; i < WidthSprite * HeightSprite; i++) {
			PixelsSprite[i] = Color;
		}
	}
	
	public int GetWidthSprite() {
		return WidthSprite;
	}
	
	public int GetHeightSprite() {
		return HeightSprite;
	}
	
	private void LoadSprite() {
		for (int y = 0; y < WidthSprite; y++) {
			for (int x =0; x < WidthSprite; x++) {
				PixelsSprite[x + y * WidthSprite] = spriteSheet.PixelsSpriteSheet[(x + this.x) + (y + this.y) * spriteSheet.WIDTH_SPRITE];
				
			}
		}
	}	
}
