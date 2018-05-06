package Non_Combattant;

import java.util.Scanner;

import Graphisme.Dialogue;
import package1.Joueur;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;



import Menu.Inventaire;
import Menu.JournalQuete;
import Menu.Objet;

public class Marchand extends Personne{

	private Objet tableauObjetMarchand[];
	private int ind;
	
	public Marchand(int i, String n, String[] t, int k,int p,int x,int y,Objet tab[],int in) {
		super(i, n, t, k,p,x,y);
		ind=in;
		int j;
		tableauObjetMarchand=new Objet[in];
		for(j=0;j<ind;j++) tableauObjetMarchand[j]=tab[j];
	}
	public int getind(){
		return ind;
	}
	
	public void setObjet(int k, Objet ob){
		tableauObjetMarchand[k] = ob;
	}
	public Objet getObjet(int k){
		return tableauObjetMarchand[k];
	}
	public void interactionBis(JournalQuete j, Inventaire inv,Joueur p,Graphics g,Dialogue d) {
		
	}

	public void afficherDialogueM1(Graphics g,int x,int y,Joueur player){
		int k=15;
	    g.setColor(new Color(255,255,255));
		g.drawString("Bonjour, je suis un expert marchand.",x,y+k);
		k+=20;
		g.drawString("Souhaites-tu :",x,y+k);
		k+=20;
		g.setColor(new Color(0,255,255,100));
	    g.fillRect(x,y+k+player.getpointeur(), 75, 20);
	    g.setColor(Color.white);
		g.drawString("Acheter", x, y+k);
	    k+=20;
	    g.drawString("Vendre", x, y+k);
		k+=20;
	}
	public void afficherDialogueM2(Graphics g,int x,int y,Joueur player){
		int k=15;
	    g.setColor(new Color(255,255,255));
		g.drawString("Merci pour cette transaction!!!", x, y+k);
		k+=20;
		g.drawString("A la prochaine.",x,y+k);
	}

}
