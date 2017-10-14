/*
package com.fap.Gigueliou.Intrant;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Clavier implements KeyListener{
	private boolean[] Touches = new boolean[199];
	public boolean Haut, Droite, Bas, Gauche, PotionVie, PotionMagie, PotionExperience, Dommage;
	
	public void TickClavier() {
		Haut = Touches[KeyEvent.VK_UP] || Touches[KeyEvent.VK_W];
		Droite = Touches[KeyEvent.VK_RIGHT] || Touches[KeyEvent.VK_D];
		Bas = Touches[KeyEvent.VK_DOWN] || Touches[KeyEvent.VK_S];
		Gauche = Touches[KeyEvent.VK_LEFT] || Touches[KeyEvent.VK_A];		
		PotionVie = Touches[KeyEvent.VK_G];
		PotionMagie = Touches[KeyEvent.VK_H];
		PotionExperience = Touches[KeyEvent.VK_J];
		Dommage = Touches[KeyEvent.VK_T];
	}
	
	public void keyPressed(KeyEvent e) {
		Touches[e.getKeyCode()] = true;
	}

	public void keyReleased(KeyEvent e) {
		Touches[e.getKeyCode()] = false;
	}

	public void keyTyped(KeyEvent e) {
		
	}
}
*/