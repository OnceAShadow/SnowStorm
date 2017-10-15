package com.fap.Every_Beginning.Graphics.Animations;

import java.util.Random;

import com.fap.Every_Beginning.Graphics.World.Tiles.Tile;

public class ScreenDisplay {

    public int widthScreen, heightScreen;
    public int xOffset, yOffset;
    public int[] pixelsScreen;
    public int widthTile = 64;
    public int heightTile = 64;
//    public int LargeurNiveau = 8;
//    public int HauteurNiveau = 8;
//    public int QuantiteTuilesNiveau = LargeurNiveau * HauteurNiveau;
//    public int PlageWidthTile = LargeurNiveau - 1;
//   public int PlageHeightTile = HauteurNiveau - 1;


    private final int ALPHA_COULEUR1 = 0xFFFF00FF;
    private final int ALPHA_COULEUR2 = 0xff7f007f;

    //public int[] Tuiles = new int[LargeurNiveau * HauteurNiveau];
    //private Random Aleatoire = new Random();

    public ScreenDisplay(int widthScreen, int heightScreen) {
        this.widthScreen = widthScreen;
        this.heightScreen = heightScreen;

        pixelsScreen = new int[widthScreen * heightScreen];


   /*     for (int i = 0; i < QuantiteTuilesNiveau; i++) {
            Tuiles[i] = Aleatoire.nextInt(0xffffff);
        }*/
    }

    public void clear() {
        for (int i = 0; i < pixelsScreen.length; i++) {
            pixelsScreen[i] = 0;
        }
    }

    public void renderScreen(int xOffset, int yOffset) {
  
    }

    public void renderSpriteSheet(int xPosition, int yPosition, SpriteSheet spriteSheet, boolean fixed) {
        if (fixed) {
            xPosition -= xOffset;
            yPosition -= yOffset;
        }

        for (int y = 0; y < spriteSheet.HEIGHT_SPRITE; y++) {
            int yAbsolu = y + yPosition;
            for (int x = 0; x < spriteSheet.WIDTH_SPRITE; x++) {
                int xAbsolu = x + xPosition;
                if (xAbsolu < 0 || xAbsolu >=  widthScreen || yAbsolu < 0 || yAbsolu >= heightScreen);
                pixelsScreen[xAbsolu + yAbsolu * widthScreen] = spriteSheet.pixelsSpriteSheet[x + y * spriteSheet.WIDTH_SPRITE];
           }
        }
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

    public void renderSprite(int xPosition, int yPosition, Sprite sprite, boolean fixed) {
        if (fixed) {
            xPosition -= xOffset;
            yPosition -= yOffset;
        }

        for (int y = 0; y < sprite.getHeightSprite(); y++) {
           int yAbsolu = y + yPosition;
            for (int x = 0; x < sprite.getWidthSprite(); x++) {
                int xAbsolu = x + xPosition;
               if (xAbsolu < 0 || xAbsolu >=  widthScreen || yAbsolu < 0 || yAbsolu >= heightScreen) continue;
                int color =  sprite.pixelsSprite[x + y * sprite.getWidthSprite()];
                if (color  != ALPHA_COULEUR1 && color  != ALPHA_COULEUR2) {
                	pixelsScreen[xAbsolu + yAbsolu * widthScreen] = color;
                }
            }
        }
    }

   public void renderTile(int xPosition, int yPosition, Tile tile) {
       xPosition -= xOffset;
       yPosition -= yOffset;

       for (int y = 0; y < tile.sprite.heightSprite; y++) {
            int yAbsolu = y + yPosition;

            for (int x = 0; x < tile.sprite.widthSprite; x++) {
                int xAbsolu = x + xPosition;
                if (xAbsolu < - 64 || xAbsolu >= widthScreen || yAbsolu < 0 || yAbsolu >= heightScreen) break;
                if (xAbsolu < 0) xAbsolu = 0;

                pixelsScreen[xAbsolu + yAbsolu * widthScreen] = tile.sprite.pixelsSprite[x + y * tile.sprite.widthSprite];

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

    public void RenduCreature(int xPosition, int yPosition, Sprite sprite) {
//        xPosition -= xDecallage;
//        yPosition -= yDecallage;
//
//        for (int y = 0; y < sprite.SaisirHauteurSprite(); y++) {
//            int yAbsolu = y + yPosition;
//
//            for (int x = 0; x < sprite.SaisirLargeurSprite(); x++) {
//                int xAbsolu = x + xPosition;
//                if (xAbsolu < - sprite.SaisirLargeurSprite() || xAbsolu >= LargeurEcran || yAbsolu < 0 || yAbsolu >= HauteurEcran) break;
//                if (xAbsolu < 0) xAbsolu = 0;
//
//                int Couleur = sprite.PixelsSprite[x + y * sprite.SaisirLargeurSprite()];
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

    public void writeRectangle(int xPosition, int yPosition, int widthDebug, int heightDebug, int color, boolean fixed) {
        if (fixed) {
            xPosition -= xOffset;
            yPosition -= yOffset;
        }

        for (int x = xPosition; x < xPosition + widthDebug; x++) {
            if (x >= this.widthScreen || x < 0 || yPosition >= this.heightScreen) continue;
            if (yPosition > 0) pixelsScreen[x + yPosition * this.widthScreen] = color;
            if (yPosition + heightDebug >= this.heightScreen) continue;
            if (yPosition + heightDebug > 0) pixelsScreen[x + (yPosition + heightDebug) * this.widthScreen] = color;

        }

        for (int y = yPosition; y <= yPosition + heightDebug; y++) {
            if (xPosition >= this.widthScreen || y < 0 || y >= this.heightScreen) continue;
            if (xPosition > 0) pixelsScreen[xPosition + y * this.widthScreen] = color;
            if (xPosition + widthDebug >= this.widthScreen) continue;
            if (xPosition + widthDebug > 0) pixelsScreen[(xPosition + widthDebug) + y * this.widthScreen] = color;

        }
    }
}
