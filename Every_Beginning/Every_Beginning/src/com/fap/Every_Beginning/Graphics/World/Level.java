package com.fap.Every_Beginning.Graphics.World;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import com.fap.Every_Beginning.Graphics.Animations.ScreenDisplay;
import com.fap.Every_Beginning.Graphics.Units.Entite;
import com.fap.Every_Beginning.Graphics.World.Tiles.Tile;

public class Level {
	
	protected int WidthLevel, HeightLevel;
	protected final Random ALEATOIRE = new Random();
	
	public int WidthLevelStart = 64;
	public int HeightLevelStart = 64;
	protected int[] RandomTiles; 
	protected int[] LevelTiles; 
	public int xStatingPosition = 32;
	public int yStartingPosition = 32;
	public static Level World = new Level("/Level/LevelStart.png");
	
	private List<Entite> Entities = new ArrayList<Entite>();
	/*
	//private List<Projectile> Projectiles = new ArrayList<Projectile>();
	//private List<Particule> Particules = new ArrayList<Particule>();
	//private List<Joueur> Joueurs = new ArrayList<Joueur>();
	
	//private Comparator<Noeud> TrieurDeNoeud = new Comparator<Noeud>() {
		public int compare(Noeud n1, Noeud n2) {
			if (n2.fCout < n1.fCout) return +1;
			if (n2.fCout > n1.fCout) return -1;		
			return 0;
		}
	}; */
	
	/*
	

	public Level(int LargeurNiveau, int HauteurNiveau) {
		this.LargeurNiveau = LargeurNiveau;
		this.HauteurNiveau = HauteurNiveau;
		TuilesAleatoire = new int[LargeurNiveau * HauteurNiveau];
		GenererNiveauAleatoire();
	}*/

	public Level(String Path) {
		LoadLevel(Path);
		GenerateLevel();
		
		// AjouterEntite(new GenerateurEntite(26 * 16, 22 *16, GenerateurEntite.TypeEntite.PARTICULE, 6000, this));
	}

	protected void LoadLevel(String Path) {
	}
	
	protected void GenerateLevel() {
	}
	
	public void TickNiveau() {
		for (int i = 0; i < Entities.size(); i++) {
			Entities.get(i).TickEntite();
		}
	/*	
		for (int i = 0; i < Projectiles.size(); i++) {
			Projectiles.get(i).TickEntite();
		}
		
		for (int i = 0; i < Particules.size(); i++) {
			Particules.get(i).TickEntite();
		}
		
		for (int i = 0; i < Joueurs.size(); i++) {
			Joueurs.get(i).TickEntite();
		}
	*/	
		RemoveEntity();
	}
	
	private void RemoveEntity() {
		for (int i = 0; i < Entities.size(); i++) {
			if (Entities.get(i).IsRemoved()) Entities.remove(i) ;
		}
		/*
		for (int i = 0; i < Projectiles.size(); i++) {
			if (Projectiles.get(i).EstRetiree()) Projectiles.remove(i) ;
		}
		
		for (int i = 0; i < Particules.size(); i++) {
			if (Particules.get(i).EstRetiree()) Particules.remove(i) ;
		}
		
		for (int i = 0; i < Joueurs.size(); i++) {
			if (Joueurs.get(i).EstRetiree()) Joueurs.remove(i) ;
		}*/
	}
/*
	public List<Projectile> SaisirProjectiles() {
		return Projectiles;
	}
*/	
	private void Temps() {	
	}
	
	public boolean CollisionEntiteTuile(int xActuelle, int yActuelle, int DimensionEntite, int xDecallage, int yDecallage) {
		boolean Solid = false;
		for (int c =0; c < 4; c++) {
			int xTemporaire = (xActuelle - (c % 2) * DimensionEntite + xDecallage) / 16;
			int yTemporaire = (yActuelle - (c / 2) * DimensionEntite + yDecallage) / 16;
			if (GetLevelTiles(xTemporaire, yTemporaire).Solid()) Solid = true;
		}return Solid;
	}
	
	public void AddEntity(Entite Entity) {
		Entity.Initialiser(this);
		/*
		if (Entite instanceof Particule) {
			Particules.add((Particule)Entite);
		} else if (Entite instanceof Projectile) {
			Projectiles.add((Projectile)Entite);
		} else if (Entite instanceof Joueur) {
			Joueurs.add((Joueur)Entite);
		} else {
		
		}	*/
		Entities.add(Entity);
	}
	/*
	public List<Joueur> SaisirJoueur() {
		return Joueurs;
	}
	
	public Joueur SaisirJoueurSpecifique(int Index) {
		return Joueurs.get(Index);
	}
	
	public Joueur SaisirJoueurClient() {
		return Joueurs.get(0);
	}
	*/	
	
	public Tile GetLevelTiles(int x, int y) {
		if (x < 0 || y < 0 || x >= WidthLevelStart || y >= HeightLevelStart) return Tile.Rock;
		
	 		if (LevelTiles[x + y * WidthLevelStart] == Tile.Color_Grass) return Tile.Grass;
	 		/*
	 		if (LevelTiles[x + y * LargeurNiveauHUB] == Tuile.Couleur_HUBGazon2) return Tuile.HUBGazon2;
	 		if (LevelTiles[x + y * LargeurNiveauHUB] == Tuile.Couleur_HUBGazon3) return Tuile.HUBGazon3;
	 		if (LevelTiles[x + y * LargeurNiveauHUB] == Tuile.Couleur_HUBGazon4) return Tuile.HUBGazon4;
	 		if (LevelTiles[x + y * LargeurNiveauHUB] == Tuile.Couleur_HUBGazon5) return Tuile.HUBGazon5;
	 		if (LevelTiles[x + y * LargeurNiveauHUB] == Tuile.Couleur_HUBGazon6) return Tuile.HUBGazon6;
	 		if (LevelTiles[x + y * LargeurNiveauHUB] == Tuile.Couleur_HUBGazon7) return Tuile.HUBGazon7;
	 		if (LevelTiles[x + y * LargeurNiveauHUB] == Tuile.Couleur_HUBGazon8) return Tuile.HUBGazon8;
	 		if (LevelTiles[x + y * LargeurNiveauHUB] == Tuile.Couleur_HUBGazon9) return Tuile.HUBGazon9;
	 		if (LevelTiles[x + y * LargeurNiveauHUB] == Tuile.Couleur_HUBGazon10) return Tuile.HUBGazon10;
	 		if (LevelTiles[x + y * LargeurNiveauHUB] == Tuile.Couleur_HUBGazon11) return Tuile.HUBGazon11;
	 		if (LevelTiles[x + y * LargeurNiveauHUB] == Tuile.Couleur_HUBGazon12) return Tuile.HUBGazon12;
	 		if (LevelTiles[x + y * LargeurNiveauHUB] == Tuile.Couleur_HUBGazon13) return Tuile.HUBGazon13;
	 		if (LevelTiles[x + y * LargeurNiveauHUB] == Tuile.Couleur_HUBGazon14) return Tuile.HUBGazon14;
	 		if (LevelTiles[x + y * LargeurNiveauHUB] == Tuile.Couleur_HUBSable) return Tuile.HUBSable;
	 		if (LevelTiles[x + y * LargeurNiveauHUB] == Tuile.Couleur_HUBEau1) return Tuile.HUBEau1;
	 		if (LevelTiles[x + y * LargeurNiveauHUB] == Tuile.Couleur_HUBEau2) return Tuile.HUBEau2;
	 		if (LevelTiles[x + y * LargeurNiveauHUB] == Tuile.Couleur_HUBEau3) return Tuile.HUBEau3;
	 		if (LevelTiles[x + y * LargeurNiveauHUB] == Tuile.Couleur_HUBEau4) return Tuile.HUBEau4;
	 		if (LevelTiles[x + y * LargeurNiveauHUB] == Tuile.Couleur_HUBEau5) return Tuile.HUBEau5;
	 		if (LevelTiles[x + y * LargeurNiveauHUB] == Tuile.Couleur_HUBEau6) return Tuile.HUBEau6;
	 		if (LevelTiles[x + y * LargeurNiveauHUB] == Tuile.Couleur_HUBEau7) return Tuile.HUBEau7;
	 		if (LevelTiles[x + y * LargeurNiveauHUB] == Tuile.Couleur_HUBEau8) return Tuile.HUBEau8;
	 		if (LevelTiles[x + y * LargeurNiveauHUB] == Tuile.Couleur_HUBEau9) return Tuile.HUBEau9;
	 		if (LevelTiles[x + y * LargeurNiveauHUB] == Tuile.Couleur_HUBEau10) return Tuile.HUBEau10;
	 		if (LevelTiles[x + y * LargeurNiveauHUB] == Tuile.Couleur_HUBEau11) return Tuile.HUBEau11;
	 		if (LevelTiles[x + y * LargeurNiveauHUB] == Tuile.Couleur_HUBEau12) return Tuile.HUBEau12;
	 		if (LevelTiles[x + y * LargeurNiveauHUB] == Tuile.Couleur_HUBLave) return Tuile.HUBLave;
	 		if (LevelTiles[x + y * LargeurNiveauHUB] == Tuile.Couleur_HUBRoche) return Tuile.HUBRoche;
	 		if (LevelTiles[x + y * LargeurNiveauHUB] == Tuile.Couleur_HUBNeige) return Tuile.HUBNeige;
	
		  	if (LevelTiles[x + y * LargeurNiveauHUB] == Tuile.Couleur_HUBPatio1) return Tuile.HUBPatio1;
		  	if (LevelTiles[x + y * LargeurNiveauHUB] == Tuile.Couleur_HUBPatio2) return Tuile.HUBPatio2;
		  	if (LevelTiles[x + y * LargeurNiveauHUB] == Tuile.Couleur_HUBPatio3) return Tuile.HUBPatio3;
		  	if (LevelTiles[x + y * LargeurNiveauHUB] == Tuile.Couleur_HUBPatio4) return Tuile.HUBPatio4;
		  	if (LevelTiles[x + y * LargeurNiveauHUB] == Tuile.Couleur_HUBPatio5) return Tuile.HUBPatio5;
		  	if (LevelTiles[x + y * LargeurNiveauHUB] == Tuile.Couleur_HUBPatio6) return Tuile.HUBPatio6;
		  	if (LevelTiles[x + y * LargeurNiveauHUB] == Tuile.Couleur_HUBPatio7) return Tuile.HUBPatio7;
		  	if (LevelTiles[x + y * LargeurNiveauHUB] == Tuile.Couleur_HUBPatio8) return Tuile.HUBPatio8;
		  	if (LevelTiles[x + y * LargeurNiveauHUB] == Tuile.Couleur_HUBPatio9) return Tuile.HUBPatio9;
		  	if (LevelTiles[x + y * LargeurNiveauHUB] == Tuile.Couleur_HUBPatio10) return Tuile.HUBPatio10;
		  	if (LevelTiles[x + y * LargeurNiveauHUB] == Tuile.Couleur_HUBPatio11) return Tuile.HUBPatio11;
		  	if (LevelTiles[x + y * LargeurNiveauHUB] == Tuile.Couleur_HUBPatio12) return Tuile.HUBPatio12;
		  	if (LevelTiles[x + y * LargeurNiveauHUB] == Tuile.Couleur_HUBPatio13) return Tuile.HUBPatio13;
		  	if (LevelTiles[x + y * LargeurNiveauHUB] == Tuile.Couleur_HUBPatio14) return Tuile.HUBPatio14;
			if (LevelTiles[x + y * LargeurNiveauHUB] == Tuile.Couleur_HUBPatio15) return Tuile.HUBPatio15;
		  	if (LevelTiles[x + y * LargeurNiveauHUB] == Tuile.Couleur_HUBPatio16) return Tuile.HUBPatio16;
		  	if (LevelTiles[x + y * LargeurNiveauHUB] == Tuile.Couleur_HUBPatio17) return Tuile.HUBPatio17;
		  	if (LevelTiles[x + y * LargeurNiveauHUB] == Tuile.Couleur_HUBPatio18) return Tuile.HUBPatio18;
		  	if (LevelTiles[x + y * LargeurNiveauHUB] == Tuile.Couleur_HUBPatio19) return Tuile.HUBPatio19;
		  	if (LevelTiles[x + y * LargeurNiveauHUB] == Tuile.Couleur_HUBPatio20) return Tuile.HUBPatio20;
		  	if (LevelTiles[x + y * LargeurNiveauHUB] == Tuile.Couleur_HUBPatio21) return Tuile.HUBPatio21;
		  	if (LevelTiles[x + y * LargeurNiveauHUB] == Tuile.Couleur_HUBPatio22) return Tuile.HUBPatio22;
		  	if (LevelTiles[x + y * LargeurNiveauHUB] == Tuile.Couleur_HUBPatio23) return Tuile.HUBPatio23;
		  	if (LevelTiles[x + y * LargeurNiveauHUB] == Tuile.Couleur_HUBPatio24) return Tuile.HUBPatio24;
		  	if (LevelTiles[x + y * LargeurNiveauHUB] == Tuile.Couleur_HUBPatio25) return Tuile.HUBPatio25;
		  	if (LevelTiles[x + y * LargeurNiveauHUB] == Tuile.Couleur_HUBPatio26) return Tuile.HUBPatio26;
		  	if (LevelTiles[x + y * LargeurNiveauHUB] == Tuile.Couleur_HUBPatio27) return Tuile.HUBPatio27;
		  	if (LevelTiles[x + y * LargeurNiveauHUB] == Tuile.Couleur_HUBPatio28) return Tuile.HUBPatio28;
		  	if (LevelTiles[x + y * LargeurNiveauHUB] == Tuile.Couleur_HUBPatio29) return Tuile.HUBPatio29;
		  	if (LevelTiles[x + y * LargeurNiveauHUB] == Tuile.Couleur_HUBPatio30) return Tuile.HUBPatio30;
		  	if (LevelTiles[x + y * LargeurNiveauHUB] == Tuile.Couleur_HUBPatio31) return Tuile.HUBPatio31;
		  	if (LevelTiles[x + y * LargeurNiveauHUB] == Tuile.Couleur_HUBPatio32) return Tuile.HUBPatio32;
		  	if (LevelTiles[x + y * LargeurNiveauHUB] == Tuile.Couleur_HUBPatio33) return Tuile.HUBPatio33;
		  	if (LevelTiles[x + y * LargeurNiveauHUB] == Tuile.Couleur_HUBPatio34) return Tuile.HUBPatio34;
		  	if (LevelTiles[x + y * LargeurNiveauHUB] == Tuile.Couleur_HUBPatio35) return Tuile.HUBPatio35;
		  	if (LevelTiles[x + y * LargeurNiveauHUB] == Tuile.Couleur_HUBPatio36) return Tuile.HUBPatio36;
		  	if (LevelTiles[x + y * LargeurNiveauHUB] == Tuile.Couleur_HUBPatio37) return Tuile.HUBPatio37;
		  	if (LevelTiles[x + y * LargeurNiveauHUB] == Tuile.Couleur_HUBPatio38) return Tuile.HUBPatio38;
		  	if (LevelTiles[x + y * LargeurNiveauHUB] == Tuile.Couleur_HUBPatio39) return Tuile.HUBPatio39;
		  	if (LevelTiles[x + y * LargeurNiveauHUB] == Tuile.Couleur_HUBPatio40) return Tuile.HUBPatio40;
		  	else 
		*/
		return Tile.Grass;
	}
	/*
	public List<Noeud> TrouverChemin(Vecteur2i PointDepart, Vecteur2i Objectif) {
		List<Noeud> ListeOuverte = new ArrayList<Noeud>();
		List<Noeud> ListeFermee = new ArrayList<Noeud>();
		Noeud NoeudEnCours = new Noeud(PointDepart, null, 0, SaisirDistance(PointDepart, Objectif));
		ListeOuverte.add(NoeudEnCours);
		
		while (ListeOuverte.size() > 0) {
			
			Collections.sort(ListeOuverte, TrieurDeNoeud);
			NoeudEnCours = ListeOuverte.get(0);
			
			if (NoeudEnCours.Tuile.equals(Objectif)) {
				
				List<Noeud> Chemin = new ArrayList<Noeud>();
			
				while (NoeudEnCours.Parent != null) {
					Chemin.add(NoeudEnCours);
					NoeudEnCours = NoeudEnCours.Parent;
				}
				System.out.println(ListeOuverte.size());
				ListeOuverte.clear();
				ListeFermee.clear();
			
				return Chemin;
			
			}
			ListeOuverte.remove(NoeudEnCours);
			
			ListeFermee.add(NoeudEnCours);
			
			for (int i = 0; i < 9; i++) {
				if (i == 4) continue;
				System.out.println(i);
				System.out.println(ListeOuverte.size());
				int xEnCours = NoeudEnCours.Tuile.SaisirX();
				int yEnCours = NoeudEnCours.Tuile.SaisirY();
				int xi = (i % 3) - 1;
				int yi = (i / 3) - 1;
				Tuile Vers = SaisirTuileHUB(xEnCours + xi, yEnCours + yi);
				if (Vers == null) continue;
				if (Vers.Solide()) continue;
				Vecteur2i v = new Vecteur2i(xEnCours + xi, yEnCours + yi);
				double gCout = NoeudEnCours.gCout + (SaisirDistance(NoeudEnCours.Tuile, v) == 1 ? 1 : 0.95);
				double hCout = SaisirDistance(v, Objectif);
				Noeud noeud = new Noeud(v, NoeudEnCours, gCout, hCout);
				if (vecDansListe(ListeFermee, v) && gCout >= noeud.gCout) continue;
				if (!vecDansListe(ListeOuverte, v) || gCout < noeud.gCout) ListeOuverte.add(noeud);
			}
		}
		ListeFermee.clear();
		return null;
	}
	
	private boolean vecDansListe(List<Noeud> Liste, Vecteur2i Vecteur) {
		for (Noeud n : Liste) {
			if (n.Tuile.equals(Vecteur)) return true;
		
		}
		return false;
	}
	
	private double SaisirDistance(Vecteur2i PointDepart, Vecteur2i Objectif) {
		double DistanceX = PointDepart.SaisirX() - Objectif.SaisirX();
		double DistanceY = PointDepart.SaisirY() - Objectif.SaisirY();
		double Distance = Math.sqrt((DistanceX * DistanceX) + (DistanceY * DistanceY));
		return Distance; 
	}
	
	 */
	public List <Entite> SaisirEntitees(Entite Entity, int Radius) {
		List<Entite> Result = new ArrayList<Entite>();
		int xCentralEntity = (int) Entity.SaisirXActuelle();
		int yCentralEntity = (int) Entity.SaisirYActuelle();
				
		for (int i = 0; i < Entities.size(); i++) {
			Entite CurrentEntity = Entities.get(i);
			
			if (CurrentEntity.equals(Entity)) continue;
		//	if (EntiteEnCours instanceof GenerateurEntite) continue;
		//	if (EntiteEnCours instanceof Particule) continue;
			int xEntiteEnCours = (int) CurrentEntity.SaisirXActuelle();
			int yEntiteEnCours = (int) CurrentEntity.SaisirYActuelle();
			
			int DistanceX = Math.abs(xEntiteEnCours - xCentralEntity);
			int DistanceY = Math.abs(yEntiteEnCours - yCentralEntity);
			double Distance = Math.sqrt((DistanceX * DistanceX) + (DistanceY * DistanceY));
			if (Distance <= Radius) Result.add(CurrentEntity);
		}
		return Result;
	}
	/*
	public List <Joueur> SaisirJoueurs(Entite Entite, int Rayon) {
		List<Joueur> Resultat = new ArrayList<Joueur>();
		int xEntiteCentrale = (int) Entite.SaisirXActuelle();
		int yEntiteCentrale = (int) Entite.SaisirYActuelle();
				
		for (int i = 0; i < Joueurs.size(); i++) {
			
			Joueur JoueurEnCours = Joueurs.get(i);
			int xJoueurEnCours = (int) Joueurs.get(i).SaisirXActuelle();
			int yJoueurEnCours = (int) Joueurs.get(i).SaisirYActuelle();
			
			int DistanceX = Math.abs(xJoueurEnCours - xEntiteCentrale);
			int DistanceY = Math.abs(yJoueurEnCours - yEntiteCentrale);
			double Distance = Math.sqrt((DistanceX * DistanceX) + (DistanceY * DistanceY));
			if (Distance <= Rayon) Resultat.add(JoueurEnCours);
		
		} 
		return Resultat;
	}
*/
	
/*
	public Tuile SaisirTuileAleatoire(int x, int y) {

		if (x < 0 || y < 0 || x >= LargeurNiveau || y >= HauteurNiveau) return Tuile.TuileVide;
		if (RandomTiles[x + y * LargeurNiveau] == 0) return Tuile.HUBGazon1;
		if (RandomTiles[x + y * LargeurNiveau] == 1) return Tuile.HUBSable;
		if (RandomTiles[x + y * LargeurNiveau] == 2) return Tuile.HUBLave;
		if (RandomTiles[x + y * LargeurNiveau] == 3) return Tuile.HUBRoche;
		if (RandomTiles[x + y * LargeurNiveau] == 4) return Tuile.HUBEau1;
		if (RandomTiles[x + y * LargeurNiveau] == 5) return Tuile.HUBNeige;
			return Tuile.TuileVide;
	}
*/
	
	public void RenduNiveau(int xDecallage, int yDecallage, ScreenDisplay Screen) {
		Screen.setOffset(xDecallage, yDecallage);
		
		int x0 = (xDecallage - Screen.WidthTile) / Screen.WidthTile;
		int x1 = (xDecallage + Screen.WidthScreen + Screen.WidthTile) >> 4;
		int y0 = (yDecallage - Screen.HeightTile) / Screen.HeightTile;
		int y1 = (yDecallage + Screen.HeightScreen + Screen.HeightTile) >> 4;
		
		for (int y = y0; y < y1; y++) {
			for (int x = x0; x <x1; x++) {
				GetLevelTiles(x, y).RenderTile(x, y, Screen);
			}
		}
		
		for (int i = 0; i < Entities.size(); i++) {
			Entities.get(i).RenduEntite(Screen);
		}
		/*
		for (int i = 0; i < Projectiles.size(); i++) {
			Projectiles.get(i).RenduEntite(Ecran);
		}
		
		for (int i = 0; i < Particules.size(); i++) {
			Particules.get(i).RenduEntite(Ecran);
		}
		
		for (int i = 0; i < Joueurs.size(); i++) {
			Joueurs.get(i).RenduEntite(Ecran);
		}
		*/
	}
}
