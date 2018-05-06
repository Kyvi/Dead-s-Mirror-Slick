package Non_Combattant;

import Graphisme.Dialogue;
import package1.Joueur;

import org.newdawn.slick.Graphics;

import Menu.Inventaire;
import Menu.JournalQuete;

public class PersonneNormale extends Personne{

	
	public PersonneNormale(int i, String n, String[] t, int k,int p,int x,int y) {
		super(i, n, t, k,p,x,y);
	}

	public void interactionBis(JournalQuete j, Inventaire inv, Joueur p,Graphics g,Dialogue d) {
	}

}
