package metier;

import java.util.Scanner;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

import package1.Joueur;

import package1.Equipable;
import Menu.Inventaire;
import Menu.JournalQuete;
import Menu.Objet;

public class Forge{

	private int nombrecreation;
	private static Objet tableaucreation[][];
	private static Equipable tableaucree[];
	private static int tableaunivrequis[];
	private static int tableauexp[];
	private int i=-1;
	private ForgeGameState fgs;
	private StateBasedGame game;
	
	public Forge(int nc, Objet tct[][], Equipable tc[], int tn[], int te[]){
		int i; int j;
		nombrecreation = nc;
		tableaucreation = new Objet [nc][2];
		tableaucree = new Equipable [nc];
		tableaunivrequis = new int[nc];
		tableauexp = new int[nc];
		for (i=0;i<nombrecreation;i++){
			for(j=0;j<2;j++) tableaucreation[i][j] = tct[i][j];
			tableaucree[i]=tc[i];
			tableaunivrequis[i] = tn[i];
			tableauexp[i]=te[i];
		}
	}
	public int getnc(){
		return nombrecreation;
	}
	
	public int getnivreq(int i){
		return tableaunivrequis[i];
	}
	
	public Objet gettabcreation(int i, int j){
		return tableaucreation[i][j];
	}
	
	public Objet getObjetcree(int i){
		return tableaucree[i];
	}
	
	public int getExp(int i){
		return tableauexp[i];
	}
	public void seti(int i){
		this.i=i;
	}
	public int geti(){
		return i;
	}
	public void interaction(Joueur p, Inventaire inv, JournalQuete jq) {
	
	}
	
	public void afficherDialogueForge(Graphics g,int x,int y,Joueur player,Inventaire inv,JournalQuete jq){
		Metier m = player.getMetier();
		g.setColor(new Color(255,255,255));
		int k=15;
		if(m.getidMetier()==2){
			if(i>-1){
				if (m.getniveauMetier() >= tableaunivrequis[i] && 
					 	inv.getquantiteObjet(tableaucreation[i][0].getidObjet()) > 0 &&
					 	inv.getquantiteObjet(tableaucreation[i][1].getidObjet()) > 0)
				{
					if(player.getarretforge()==0){
						inv.PlacerObjet(tableaucree[i].getidObjet(), 1, jq);
						inv.RetirerObjet(tableaucreation[i][0].getidObjet(), 1, jq);
						inv.RetirerObjet(tableaucreation[i][1].getidObjet(), 1, jq);
						m.setexperienceMetier(m.getexperienceMetier()+tableauexp[i]);
						while(m.getexperienceMetier()>=m.getexperienceMaxMetier()){
							m.monterNiveauMetier();
						}

						 player.setarretforge(1);
					}
					g.drawString("Felicitation !!!",x,y+k);
					k+=20;
					g.drawString("vous avez forge : "+tableaucree[i].getnomObjet(), x, y+k);
					k+=20;
					g.drawString("Votre niveau metier est de : "+m.getniveauMetier(),x,y+k);
				}else{
					g.drawString("Vous ne pouvez pas forger cet objet...",x,y+k);
				}
			}
		}else{
			g.drawString("Vous n'etes pas forgeron...",x,y+k);
		}
	}
}
