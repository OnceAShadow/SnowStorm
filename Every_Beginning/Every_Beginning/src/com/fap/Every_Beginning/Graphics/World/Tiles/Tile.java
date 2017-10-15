package com.fap.Every_Beginning.Graphics.World.Tiles;

import com.fap.Every_Beginning.Graphics.Animations.ScreenDisplay;
import com.fap.Every_Beginning.Graphics.Animations.Sprite;

public class Tile {
	
		public static Tile tile_Grass = new TileGrass(Sprite.spriteGrass);
		public static Tile tile_Rock = new TileRock(Sprite.spriteRock);

		public static final int COLOR_GRASS = 0xff27E109;
		/*
		public static Tuile HUBGazon3 = new TuileHUBGazon(Sprite.HUBGazon3);
		public static Tuile HUBGazon4 = new TuileHUBGazon(Sprite.HUBGazon4);
		public static Tuile HUBGazon5 = new TuileHUBGazon(Sprite.HUBGazon5);
		public static Tuile HUBGazon6 = new TuileHUBGazon(Sprite.HUBGazon6);
		public static Tuile HUBGazon7 = new TuileHUBGazon(Sprite.HUBGazon7);
		public static Tuile HUBGazon8 = new TuileHUBGazon(Sprite.HUBGazon8);
		public static Tuile HUBGazon9 = new TuileHUBGazon(Sprite.HUBGazon9);
		public static Tuile HUBGazon10 = new TuileHUBGazon(Sprite.HUBGazon10);
		public static Tuile HUBGazon11 = new TuileHUBGazon(Sprite.HUBGazon11);
		public static Tuile HUBGazon12 = new TuileHUBGazon(Sprite.HUBGazon12);
		public static Tuile HUBGazon13 = new TuileHUBGazon(Sprite.HUBGazon13);
		public static Tuile HUBGazon14 = new TuileHUBGazon(Sprite.HUBGazon14);
		public static Tuile HUBSable = new TuileHUBSable(Sprite.HUBSable);
		public static Tuile HUBEau1 = new TuileHUBEau(Sprite.HUBEau1);
		public static Tuile HUBEau2 = new TuileHUBEau(Sprite.HUBEau2);
		public static Tuile HUBEau3 = new TuileHUBEau(Sprite.HUBEau3);
		public static Tuile HUBEau4 = new TuileHUBEau(Sprite.HUBEau4);
		public static Tuile HUBEau5 = new TuileHUBEau(Sprite.HUBEau5);
		public static Tuile HUBEau6 = new TuileHUBEau(Sprite.HUBEau6);
		public static Tuile HUBEau7 = new TuileHUBEau(Sprite.HUBEau7);
		public static Tuile HUBEau8 = new TuileHUBEau(Sprite.HUBEau8);
		public static Tuile HUBEau9 = new TuileHUBEau(Sprite.HUBEau9);
		public static Tuile HUBEau10 = new TuileHUBEau(Sprite.HUBEau10);
		public static Tuile HUBEau11 = new TuileHUBEau(Sprite.HUBEau11);
		public static Tuile HUBEau12 = new TuileHUBEau(Sprite.HUBEau12);
		public static Tuile HUBLave = new TuileHUBLave(Sprite.HUBLave);
		public static Tuile HUBNeige = new TuileHUBNeige(Sprite.HUBNeige);
		public static Tuile HUBRoche = new TuileHUBRoche(Sprite.HUBRoche);
		
		
		public static Tuile TuileVide = new TuileVide(Sprite.TuileVide);
		
		
		public static Tuile HUBPatio1 = new TuileHUBPatioBord(Sprite.HUBPatio1);
		public static Tuile HUBPatio2 = new TuileHUBPatioBord(Sprite.HUBPatio2);
		public static Tuile HUBPatio3 = new TuileHUBPatioBord(Sprite.HUBPatio3);
		public static Tuile HUBPatio4 = new TuileHUBPatioBord(Sprite.HUBPatio4);
		public static Tuile HUBPatio5 = new TuileHUBPatioBord(Sprite.HUBPatio5);
		public static Tuile HUBPatio6 = new TuileHUBPatioBord(Sprite.HUBPatio6);
		public static Tuile HUBPatio7 = new TuileHUBPatioBord(Sprite.HUBPatio7);
		public static Tuile HUBPatio8 = new TuileHUBPatioBord(Sprite.HUBPatio8);
		public static Tuile HUBPatio9 = new TuileHUBPatioBord(Sprite.HUBPatio9);
		public static Tuile HUBPatio10 = new TuileHUBPatio(Sprite.HUBPatio10);
		public static Tuile HUBPatio11 = new TuileHUBPatio(Sprite.HUBPatio11);
		public static Tuile HUBPatio12 = new TuileHUBPatio(Sprite.HUBPatio12);
		public static Tuile HUBPatio13 = new TuileHUBPatio(Sprite.HUBPatio13);
		public static Tuile HUBPatio14 = new TuileHUBPatio(Sprite.HUBPatio14);
		public static Tuile HUBPatio15 = new TuileHUBPatio(Sprite.HUBPatio15);
		public static Tuile HUBPatio16 = new TuileHUBPatioBord(Sprite.HUBPatio16);
		public static Tuile HUBPatio17 = new TuileHUBPatioBord(Sprite.HUBPatio17);
		public static Tuile HUBPatio18 = new TuileHUBPatio(Sprite.HUBPatio18);
		public static Tuile HUBPatio19 = new TuileHUBPatio(Sprite.HUBPatio19);
		public static Tuile HUBPatio20 = new TuileHUBPatio(Sprite.HUBPatio20);
		public static Tuile HUBPatio21 = new TuileHUBPatio(Sprite.HUBPatio21);
		public static Tuile HUBPatio22 = new TuileHUBPatio(Sprite.HUBPatio22);
		public static Tuile HUBPatio23 = new TuileHUBPatio(Sprite.HUBPatio23);
		public static Tuile HUBPatio24 = new TuileHUBPatioBord(Sprite.HUBPatio24);
		public static Tuile HUBPatio25 = new TuileHUBPatioBord(Sprite.HUBPatio25);
		public static Tuile HUBPatio26 = new TuileHUBPatioBord(Sprite.HUBPatio26);
		public static Tuile HUBPatio27 = new TuileHUBPatioBord(Sprite.HUBPatio27);
		public static Tuile HUBPatio28 = new TuileHUBPatio(Sprite.HUBPatio28);
		public static Tuile HUBPatio29 = new TuileHUBPatio(Sprite.HUBPatio29);
		public static Tuile HUBPatio30 = new TuileHUBPatioBord(Sprite.HUBPatio30);
		public static Tuile HUBPatio31 = new TuileHUBPatioBord(Sprite.HUBPatio31);
		public static Tuile HUBPatio32 = new TuileHUBPatioBord(Sprite.HUBPatio32);
		public static Tuile HUBPatio33 = new TuileHUBPatio(Sprite.HUBPatio33);
		public static Tuile HUBPatio34 = new TuileHUBPatio(Sprite.HUBPatio34);
		public static Tuile HUBPatio35 = new TuileHUBPatio(Sprite.HUBPatio35);
		public static Tuile HUBPatio36 = new TuileHUBPatio(Sprite.HUBPatio36);
		public static Tuile HUBPatio37 = new TuileHUBPatio(Sprite.HUBPatio37);
		public static Tuile HUBPatio38 = new TuileHUBPatio(Sprite.HUBPatio38);
		public static Tuile HUBPatio39 = new TuileHUBPatio(Sprite.HUBPatio39);
		public static Tuile HUBPatio40 = new TuileHUBPatio(Sprite.HUBPatio40);
		
		// Couleur dans les fichiers niveau dessiner
		
		public static final int  Couleur_HUBGazon2 = 0xff2E7C0C;
		public static final int  Couleur_HUBGazon3 = 0xff327C12;
		public static final int  Couleur_HUBGazon4 = 0xff367C18;
		public static final int  Couleur_HUBGazon5 = 0xff3B7C1F;
		public static final int  Couleur_HUBGazon6 = 0xff3F7A24;
	  	public static final int  Couleur_HUBGazon7 = 0xff447A2A;
	  	public static final int  Couleur_HUBGazon8 = 0xff487A30;
	  	public static final int  Couleur_HUBGazon9 = 0xff4C7A37;
	  	public static final int  Couleur_HUBGazon10 = 0xff000000;
	  	public static final int  Couleur_HUBGazon11 = 0xff000000;
	  	public static final int  Couleur_HUBGazon12 = 0xff000000;
	  	public static final int  Couleur_HUBGazon13 = 0xff808080;
	  	public static final int  Couleur_HUBGazon14 = 0xffFFFF00;
	  	public static final int  Couleur_HUBSable = 0xffFF9900;
	  	public static final int  Couleur_HUBEau1 = 0xff0026FF;
	  	public static final int  Couleur_HUBEau2 = 0xff193BFF;
	  	public static final int  Couleur_HUBEau3 = 0xff2646FF;
	  	public static final int  Couleur_HUBEau4 = 0xff3251FF;
	  	public static final int  Couleur_HUBEau5 = 0xff3F5CFF;
	  	public static final int  Couleur_HUBEau6 = 0xff4C67FF;
	  	public static final int  Couleur_HUBEau7 = 0xff5972FF;
	  	public static final int  Couleur_HUBEau8 = 0xff667CFF;
	  	public static final int  Couleur_HUBEau9 = 0xff7287FF;
	  	public static final int  Couleur_HUBEau10 = 0xff000000;
	  	public static final int  Couleur_HUBEau11 = 0xff000000;
	  	public static final int  Couleur_HUBEau12 = 0xff000000;
	  	public static final int  Couleur_HUBLave = 0xffFF0000;
	  	public static final int  Couleur_HUBRoche = 0xff404040;
	  	public static final int  Couleur_HUBNeige = 0xff7FFFFF;
	  	public static final int  Couleur_HUBPatio1 = 0xff928546;
	  	public static final int  Couleur_HUBPatio2 = 0xff928547;
	  	public static final int  Couleur_HUBPatio3 = 0xff928548;
	  	public static final int  Couleur_HUBPatio4 = 0xff928549;
	  	public static final int  Couleur_HUBPatio5 = 0xff92854A;
	  	public static final int  Couleur_HUBPatio6 = 0xff92854B;
	  	public static final int  Couleur_HUBPatio7 = 0xff92854C;
	  	public static final int  Couleur_HUBPatio8 = 0xff92854D;
	  	public static final int  Couleur_HUBPatio9 = 0xff92854E;
	  	public static final int  Couleur_HUBPatio10 = 0xff92854F;
	  	public static final int  Couleur_HUBPatio11 = 0xff928550;
	  	public static final int  Couleur_HUBPatio12 = 0xff928551;
	  	public static final int  Couleur_HUBPatio13 = 0xff928552;
	  	public static final int  Couleur_HUBPatio14 = 0xff928553;
	  	public static final int  Couleur_HUBPatio15 = 0xff928554;
	  	public static final int  Couleur_HUBPatio16 = 0xff928555;
	  	public static final int  Couleur_HUBPatio17 = 0xff928556;
	  	public static final int  Couleur_HUBPatio18 = 0xff928557;
	  	public static final int  Couleur_HUBPatio19 = 0xff928558;
	  	public static final int  Couleur_HUBPatio20 = 0xff928559;
	  	public static final int  Couleur_HUBPatio21 = 0xff92855A;
	  	public static final int  Couleur_HUBPatio22 = 0xff92855B;
	  	public static final int  Couleur_HUBPatio23 = 0xff92855C;
	  	public static final int  Couleur_HUBPatio24 = 0xff92855D;
	  	public static final int  Couleur_HUBPatio25 =  0xff92855E;
	  	public static final int  Couleur_HUBPatio26 = 0xff92855F;
	  	public static final int  Couleur_HUBPatio27 = 0xff928560;
	  	public static final int  Couleur_HUBPatio28 = 0xff928561;
	  	public static final int  Couleur_HUBPatio29 = 0xff928562;
	  	public static final int  Couleur_HUBPatio30 = 0xff928563;
	  	public static final int  Couleur_HUBPatio31 = 0xff928564;
	  	public static final int  Couleur_HUBPatio32 = 0xff928565;
	  	public static final int  Couleur_HUBPatio33 = 0xff928566;
	  	public static final int  Couleur_HUBPatio34 = 0xff928567;
	  	public static final int  Couleur_HUBPatio35 = 0xff928568;
	  	public static final int  Couleur_HUBPatio36 = 0xff928569;
	  	public static final int  Couleur_HUBPatio37 = 0xff92856A;
	  	public static final int  Couleur_HUBPatio38 = 0xff92856B;
	  	public static final int  Couleur_HUBPatio39 = 0xff92856C;
	  	public static final int  Couleur_HUBPatio40 = 0xff92856D;
		
		*/
		
		public int x, y;
		public Sprite sprite;
		
		public Tile(Sprite sprite) {
			this.sprite = sprite;
		}
		
		public void renderTile(int x, int y, ScreenDisplay screen) {
		}
		
		public boolean solid() {
			return false;
		}
		
}
