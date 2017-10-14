/*
package com.fap.Gigueliou.Intrant;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Souris implements MouseListener, MouseMotionListener{

	private static int SourisX = -1;
	private static int SourisY = -1;
	private static int SourisBouton = MouseEvent.NOBUTTON;
	public static int AlternanceBoutonPresserRelacher = 0;
	
	public static int SaisirX() {
		return SourisX;
	}
	
	public static int SaisirY() {
		return SourisY;
	}
	
	public static int SaisirBouton() {
		return SourisBouton;
	}
	
	public static int SaisirAlternanceBoutonPresserRelacher() {
		return AlternanceBoutonPresserRelacher;
	}
	
	public void mouseDragged(MouseEvent e) {
		SourisX = e.getX();
		SourisY = e.getY();
		AlternanceBoutonPresserRelacher++;
	}
	
	public void mouseMoved(MouseEvent e) {
		SourisX = e.getX();
		SourisY = e.getY();
	}

	public void mouseClicked(MouseEvent e) {			
	}

	public void mousePressed(MouseEvent e) {
		SourisBouton = e.getButton();
		AlternanceBoutonPresserRelacher++;	
	}
	
	public void mouseReleased(MouseEvent e) {
		SourisBouton = MouseEvent.NOBUTTON;
		AlternanceBoutonPresserRelacher = 0;
	}

	public void mouseEntered(MouseEvent e) {
		SourisBouton = MouseEvent.NOBUTTON;
		AlternanceBoutonPresserRelacher = 0;		
	}

	public void mouseExited(MouseEvent e) {
		SourisBouton = MouseEvent.NOBUTTON;
		AlternanceBoutonPresserRelacher = 0;	
	}
}
*/