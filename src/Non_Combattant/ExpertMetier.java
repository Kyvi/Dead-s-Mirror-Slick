package Non_Combattant;

import java.awt.event.KeyEvent;
import java.util.Scanner;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;

import Graphisme.Dialogue;
import package1.Equipable;
import package1.Joueur;


import Menu.Inventaire;
import Menu.JournalQuete;

public class ExpertMetier extends Personne{

	
	private Joueur player;
	
	public ExpertMetier(int i, String n, String[] t, int k,int p,int x,int y,Joueur jo) {
		super(i, n, t, k,p,x,y);
		player=jo;
	}

	public void oublierMetier(Joueur p){
		p.getMetier().setnomMetier("Aucun métier");
		p.getMetier().setniveauMetier(7);
		p.getMetier().setexperienceMetier(0);
		p.getMetier().setexperienceMetierMax(1000); //On suppose que expMax vaut 100 au niveau 1
		p.getMetier().setidMetier(0);
	}

	public void ApprendreMetier(Joueur p,int choix){
		p.getMetier().setidMetier(choix);
		p.getMetier().setniveauMetier(7);
		if(choix==1)p.getMetier().setnomMetier("Mineur");
		if(choix==2)p.getMetier().setnomMetier("Forgeron");
	}
	
	public void interactionBis(JournalQuete j, Inventaire inv, Joueur p,Graphics g,Dialogue d) {
		if(this.player.getmetier()==1){
			ApprendreMetier(player,1);
			player.setfindial(0);
			player.setchoixapp(0);
			player.settour(player.gettour()+1);
		}
		else if(this.player.getmetier()==2){
			ApprendreMetier(player,2);
			player.setfindial(0);
			player.setchoixapp(0);
			player.settour(player.gettour()+1);
		}
		else if(this.player.getchoixoubl()==1){
			oublierMetier(player);
			player.setfindial(0);
			player.settour(player.gettour()+1);
		}else if(this.player.getchoixapp()==2){
			player.setfindial(0);
			player.settour(player.gettour()+1);
		}else if(this.player.getchoixoubl()==2){
			player.setfindial(0);
			player.settour(player.gettour()+1);
		}
	}
	public void afficherDialogueApp(Graphics g,int x,int y,Joueur player){
		int k=15;
	    g.setColor(new Color(255,255,255));
		if(player.getchoixapp()==1){
			g.drawString("Souhaites-tu devenir : ", x, y+k);
			k+=20;
			g.setColor(new Color(0,255,255,100));
	    	g.fillRect(x,y+k+player.getpointeur(), 75, 20);
	    	g.setColor(Color.white);
			g.drawString("Mineur", x, y+k);
	    	k+=20;
	    	g.drawString("Forgeron", x, y+k);
			k+=20;
		}else{
			g.drawString("Peut etre une autre fois je suppose.",x,y+k);
			k+=20;
			g.drawString("A la prochaine.",x,y+k);
		}
	}
	public void afficherDialogueMetier(Graphics g,int x,int y,Joueur player){
		int k=15;
	    g.setColor(new Color(255,255,255));
		if(player.getmetier()==1){
			g.drawString("Felicitation vous etes Mineur!!!", x, y+k);
			k+=20;
			g.drawString("A la prochaine.",x,y+k);
		}else if(player.getmetier()==2){
			g.drawString("Felicitation vous etes Forgeron!!!", x, y+k);
			k+=20;
			g.drawString("A la prochaine.",x,y+k);
		}
	}
	public void afficherDialogueOubl(Graphics g,int x,int y,Joueur player){
		int k=15;
	    g.setColor(new Color(255,255,255));
		if(player.getchoixoubl()==1){
			g.drawString("Felicitation vous n'avez plus de metier!!",x,y+k);
			k+=20;
			g.drawString("A la prochaine.",x,y+k);
		}else{
			g.drawString("Peut etre une autre fois je suppose.",x,y+k);
			k+=20;
			g.drawString("A la prochaine.",x,y+k);
		}
	}
	public void afficherDialogueEM(Graphics g,int x,int y,Joueur player){
		int k=15;
	    g.setColor(new Color(255,255,255));
		if(player.getMetier().getidMetier()==0){
			g.drawString("Bonjour, je suis un expert metier.",x,y+k);
			k+=20;
			g.drawString("Souhaites-tu apprendre un metier ?",x,y+k);
			k+=20;
			g.setColor(new Color(0,255,255,100));
	    	g.fillRect(x,y+k+player.getpointeur(), 50, 20);
	    	g.setColor(Color.white);
			g.drawString("Oui", x, y+k);
	    	k+=20;
	    	g.drawString("Non", x, y+k);
			k+=20;
		}else if(player.getMetier().getidMetier()!=0) {
			g.drawString("Bonjour, je suis un expert metier.",x,y+k);
			k+=20;
			g.drawString("Souhaites-tu oublier un metier ?",x,y+k);
			k+=20;
			g.setColor(new Color(0,255,255,100));
	    	g.fillRect(x,y+k+player.getpointeur(), 50, 20);
	    	g.setColor(Color.white);
			g.drawString("Oui", x, y+k);
	    	k+=20;
	    	g.drawString("Non", x, y+k);
			k+=20;
		}
	}
		 
  
}
