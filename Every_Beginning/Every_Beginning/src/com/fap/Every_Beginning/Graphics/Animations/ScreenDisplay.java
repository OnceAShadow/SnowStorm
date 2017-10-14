package com.fap.Every_Beginning.Graphics.Animations;

import java.util.Random;

import com.fap.Every_Beginning.Graphics.World.Tiles.Tile;

public class ScreenDisplay {

    public int WidthScreen, HeightScreen;
    public int xOffset, yOffset;
    public int[] PixelsScreen;
//    public int LargeurNiveau = 8;
//    public int HauteurNiveau = 8;
//    public int QuantiteTuilesNiveau = LargeurNiveau * HauteurNiveau;
    public int WidthTile = 64;
    public int HeightTile = 64;
//    public int PlageWidthTile = LargeurNiveau - 1;
//   public int PlageHeightTile = HauteurNiveau - 1;


//    private final int ALPHA_COULEUR1 = 0xFFFF00FF;
//    private final int ALPHA_COULEUR2 = 0xff7f007f;

    //public int[] Tuiles = new int[LargeurNiveau * HauteurNiveau];
    //private Random Aleatoire = new Random();

    public ScreenDisplay(int WidthScreen, int HeightScreen) {
        this.WidthScreen = WidthScreen;
        this.HeightScreen = HeightScreen;

        PixelsScreen = new int[WidthScreen * HeightScreen];


   /*     for (int i = 0; i < QuantiteTuilesNiveau; i++) {
            Tuiles[i] = Aleatoire.nextInt(0xffffff);
        }*/
    }

    public void Liberer() {
        for (int i = 0; i < PixelsScreen.length; i++) {
            PixelsScreen[i] = 0;
        }
    }

    public void RenduEcran(int xOffset, int yOffset) {
  
    }

    public void RenduSpriteSheet(int xPosition, int yPosition, SpriteSheet SpriteSheet, boolean Fixee) {
//        if (Fixee) {
//            xPosition -= xDecallage;
//            yPosition -= yDecallage;
//        }
//
//        for (int y = 0; y < SpriteSheet.HAUTEUR_SPRITE; y++) {
//            int yAbsolu = y + yPosition;
//            for (int x = 0; x < SpriteSheet.LARGEUR_SPRITE; x++) {
//                int xAbsolu = x + xPosition;
//                if (xAbsolu < 0 || xAbsolu >=  LargeurEcran || yAbsolu < 0 || yAbsolu >= HauteurEcran);
//                PixelsEcran[xAbsolu + yAbsolu * LargeurEcran] = SpriteSheet.PixelsSpriteSheet[x + y * SpriteSheet.LARGEUR_SPRITE];
//            }
//        }
    }

    public void RenduTexte(int xPosition, int yPosition, Sprite Sprite, boolean Fixee, int Couleur) {
//        if (Fixee) {
//            xPosition -= xDecallage;
//            yPosition -= yDecallage;
//        }
//
//        for (int y = 0; y < Sprite.SaisirHauteurSprite(); y++) {
//            int yAbsolu = y + yPosition;
//            for (int x = 0; x < Sprite.SaisirLargeurSprite(); x++) {
//                int xAbsolu = x + xPosition;
//                if (xAbsolu < 0 || xAbsolu >=  LargeurEcran || yAbsolu < 0 || yAbsolu >= HauteurEcran) continue;
//                int Coul =  Sprite.PixelsSprite[x + y * Sprite.SaisirLargeurSprite()];
//                if (Coul  != ALPHA_COULEUR1 && Coul  != ALPHA_COULEUR2) {
//                    PixelsEcran[xAbsolu + yAbsolu * LargeurEcran] = Couleur;
//                }
//            }
//        }
    }

    public void RenduSprite(int xPosition, int yPosition, Sprite Sprite, boolean Fixee) {
//        if (Fixee) {
//            xPosition -= xDecallage;
//            yPosition -= yDecallage;
//        }
//
//        for (int y = 0; y < Sprite.SaisirHauteurSprite(); y++) {
//            int yAbsolu = y + yPosition;
//            for (int x = 0; x < Sprite.SaisirLargeurSprite(); x++) {
//                int xAbsolu = x + xPosition;
//                if (xAbsolu < 0 || xAbsolu >=  LargeurEcran || yAbsolu < 0 || yAbsolu >= HauteurEcran) continue;
//                int Couleur =  Sprite.PixelsSprite[x + y * Sprite.SaisirLargeurSprite()];
//                if (Couleur  != ALPHA_COULEUR1 && Couleur  != ALPHA_COULEUR2) {
//                    PixelsEcran[xAbsolu + yAbsolu * LargeurEcran] = Couleur;
//                }
//            }
//        }
    }

   public void RenderTile(int xPosition, int yPosition, Tile Tile) {
       xPosition -= xOffset;
       yPosition -= yOffset;

       for (int y = 0; y < Tile.sprite.DIMENSIONSPRITE; y++) {
            int yAbsolu = y + yPosition;

            for (int x = 0; x < Tile.sprite.DIMENSIONSPRITE; x++) {
                int xAbsolu = x + xPosition;
                if (xAbsolu < - 16 || xAbsolu >= WidthScreen || yAbsolu < 0 || yAbsolu >= HeightScreen) break;
                if (xAbsolu < 0) xAbsolu = 0;

                PixelsScreen[xAbsolu + yAbsolu * WidthScreen] = Tile.sprite.PixelsSprite[x + y * Tile.sprite.DIMENSIONSPRITE];
           }
        }
   }

//    public void RenduCreature(int xPosition, int yPosition, Creature Creature) {
//        xPosition -= xDecallage;
//        yPosition -= yDecallage;
//
//        for (int y = 0; y < Creature.SaisirSprite().SaisirHauteurSprite(); y++) {
//            int yAbsolu = y + yPosition;
//
//            for (int x = 0; x < Creature.SaisirSprite().SaisirLargeurSprite(); x++) {
//                int xAbsolu = x + xPosition;
//                if (xAbsolu < - Creature.SaisirSprite().SaisirLargeurSprite() || xAbsolu >= LargeurEcran || yAbsolu < 0 || yAbsolu >= HauteurEcran) break;
//                if (xAbsolu < 0) xAbsolu = 0;
//
//                int Couleur = Creature.SaisirSprite().PixelsSprite[x + y * Creature.SaisirSprite().SaisirLargeurSprite()];
//                if ((Creature instanceof FantomeSuiveur) && Couleur == 0xFFF30401) Couleur = 0xffE7EF00;
//                if ((Creature instanceof FantomeFutee) && Couleur == 0xFFF30401) Couleur = 0xfFF9900;
//                if ((Creature instanceof FantomeFeu) && Couleur == 0xFFF30401) Couleur = 0xfbb5058;
//
//                if (Couleur  != ALPHA_COULEUR1) {
//                    PixelsEcran[xAbsolu + yAbsolu * LargeurEcran] = Couleur;
//                }
//            }
//        }
//    }

    public void RenduCreature(int xPosition, int yPosition, Sprite Sprite) {
//        xPosition -= xDecallage;
//        yPosition -= yDecallage;
//
//        for (int y = 0; y < Sprite.SaisirHauteurSprite(); y++) {
//            int yAbsolu = y + yPosition;
//
//            for (int x = 0; x < Sprite.SaisirLargeurSprite(); x++) {
//                int xAbsolu = x + xPosition;
//                if (xAbsolu < - Sprite.SaisirLargeurSprite() || xAbsolu >= LargeurEcran || yAbsolu < 0 || yAbsolu >= HauteurEcran) break;
//                if (xAbsolu < 0) xAbsolu = 0;
//
//                int Couleur = Sprite.PixelsSprite[x + y * Sprite.SaisirLargeurSprite()];
//                if (Couleur  != ALPHA_COULEUR1) {
//                    PixelsEcran[xAbsolu + yAbsolu * LargeurEcran] = Couleur;
//                }
//            }
//        }
    }

    //public void RenduProjectile(int xPosition, int yPosition, Projectile Projectile) {
        /*
        xPosition -= xDecallage;
        yPosition -= yDecallage;

        for (int y = 0; y < Projectile.SaisirSpriteDimension(); y++) {
            int yAbsolu = y + yPosition;

            for (int x = 0; x < Projectile.SaisirSpriteDimension(); x++) {
                int xAbsolu = x + xPosition;
                if (xAbsolu < - Projectile.SaisirSpriteDimension() || xAbsolu >= LargeurEcran || yAbsolu < 0 || yAbsolu >= HauteurEcran) break;
                if (xAbsolu < 0) xAbsolu = 0;

                int Couleur = Projectile.SaisirSprite().PixelsSprite[x + y * Projectile.SaisirSprite().DIMENSIONSPRITE];
                if (Couleur != ALPHA_COULEUR1 && Couleur != ALPHA_COULEUR2) {
                    PixelsEcran[xAbsolu + yAbsolu * LargeurEcran] = Couleur;
                }
            }
        }
        */
    //}

    public void setOffset(int xOffset, int yOffset) {
        this.xOffset = xOffset;
        this.yOffset = yOffset;
    }

    public void DessinerRectangle(int xPosition, int yPosition, int LargeurDebug, int HauteurDebug, int Couleur, boolean Fixee) {
        if (Fixee) {
            xPosition -= xOffset;
            yPosition -= yOffset;
        }

        for (int x = xPosition; x < xPosition + LargeurDebug; x++) {
            if (x >= this.WidthScreen || x < 0 || yPosition >= this.HeightScreen) continue;
            if (yPosition > 0) PixelsScreen[x + yPosition * this.WidthScreen] = Couleur;
            if (yPosition + HauteurDebug >= this.HeightScreen) continue;
            if (yPosition + HauteurDebug > 0) PixelsScreen[x + (yPosition + HauteurDebug) * this.WidthScreen] = Couleur;

        }

        for (int y = yPosition; y <= yPosition + HauteurDebug; y++) {
            if (xPosition >= this.WidthScreen || y < 0 || y >= this.HeightScreen) continue;
            if (xPosition > 0) PixelsScreen[xPosition + y * this.WidthScreen] = Couleur;
            if (xPosition + LargeurDebug >= this.WidthScreen) continue;
            if (xPosition + LargeurDebug > 0) PixelsScreen[(xPosition + LargeurDebug) + y * this.WidthScreen] = Couleur;

        }
    }
}
