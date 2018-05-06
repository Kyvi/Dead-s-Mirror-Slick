package Principal;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Splashpanel extends JPanel {

	private boolean mainscreen = false;
	private boolean objets = false;
	private boolean quetes = false;
	private boolean musiques = false;
	private boolean personnes = false;
	private boolean forges = false;
	private boolean rochers = false;
	private boolean attaques = false;
	private boolean zones = false;
	private boolean villes = false;
	private int compteur = 0;
	
	
	public void setmain(){
		mainscreen = true;
		compteur = 1;
	}
	
	public void setobjets(){
		objets = true;
		compteur = 2;
	}
	
	
	public void setmusiques(){
		musiques = true;
		compteur = 6;
	}
	
	public void setmusiquesvilles(){
		villes = true;
		compteur = 3;
	}
	public void setmusiqueszones(){
		zones = true;
		compteur = 4;
	}
	
	public void setpersonnes(){
		personnes = true;
		compteur = 7;
	}
	
	public void setforges(){
		forges = true;
		compteur = 8;
	}
	
	public void setrochers(){
		rochers = true;
		compteur = 9;
	}
	
	public void setattaques(){
		attaques = true;
		compteur = 10;
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 800, 620);
		g.setColor(Color.WHITE);
		g.drawString("Chargement en cours", 320,500 );
		if (mainscreen == true){g.drawString("Chargement Ecran Principal Terminé", 200, 150);}
		if (objets== true){g.drawString("Chargement Objets Terminé ", 200, 175);}
		if (villes== true){g.drawString("Chargement Musiques Villes Terminé ", 200, 200);}
		if (zones== true){g.drawString("Chargement Musiques Zones Terminé ", 200, 225);}
		if (musiques== true){g.drawString("Chargement Musiques Combat Terminé ", 200, 250);}
		if (personnes== true){g.drawString("Chargement Personnes Terminé ", 200, 275);}
		if (forges== true){g.drawString("Chargement Forges Terminé ", 200, 300);}
		if (rochers== true){g.drawString("Chargement Rochers Terminé ", 200, 325);}
		if (attaques == true){g.drawString("Chargement Ennemis Sprites attaques Terminé ", 200, 350);}
		g.drawRect(199, 549, 402, 22);
		g.setColor(Color.red);
		g.fillRect(200,550,compteur*40,20);
	}
}
