package Graphisme;

import metier.Forge;
import metier.Rocher;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import package1.Joueur;
import package1.Jeu;

import Combat.Boss;
import Menu.Inventaire;
import Menu.JournalQuete;
import Non_Combattant.DonneurQuete;
import Non_Combattant.ExpertMetier;
import Non_Combattant.Marchand;
import Non_Combattant.Personne;

public class Dialogue {

	private Image dialogue;
	 private static final int P_BAR_X = 70;
	 private static final int P_BAR_Y = 473;
	 private String tabDQ[]=new String[3];
	 private int changcompteur=1;
	 
	 public Dialogue(){
	 }
	 
	 public int getchangcompteur(){
		 return changcompteur;
	 }
	 public void setchangcompteur(int i){
		 changcompteur=i;
	 }
	 public void init() throws SlickException {
		    this.dialogue = new Image("/src/package1/ressources/hud/dialogue.png").getScaledCopy(2);
	}
	 public Image getimage(){
		 return dialogue;
	 }
	 public void render(Graphics g,DonneurQuete dq, Joueur player) throws SlickException{
		 int i,k;
		 k=dq.getcompteur();
		 if(k!=0){
			 if(k==1)changcompteur=2;
			 if(k==3)changcompteur=4;
			 for(i=0;i<3;i++){
				 tabDQ[i]=dq.gettableauDQ(i, k);
			 }
			 g.resetTransform();
			 g.drawImage(this.dialogue, P_BAR_X, P_BAR_Y);
			 dq.afficherDialogueDQ(g,tabDQ, player,P_BAR_X+12, P_BAR_Y);
		 }else {
			 g.resetTransform();
			  g.drawImage(this.dialogue, P_BAR_X, P_BAR_Y);
			  dq.afficherDialogue(g,P_BAR_X+12,P_BAR_Y,player);
		 }
		  
		  
	 }
	 public void render(Graphics g,Boss b,Joueur player,Jeu j) throws SlickException {
		 if(j.getboss().getcombat()==0 && j.getboss().getdernier()==false){
			 g.resetTransform();
			 g.drawImage(this.dialogue, P_BAR_X, P_BAR_Y);
			 b.afficherDialogueBoss(g,P_BAR_X+12,P_BAR_Y,player);
			 player.getjeu().setbossencounter(true);
		 }else if(j.getboss().getcombat()==1 && j.getboss().getbattu()==1 && j.getboss().getdernier()==false){
			 g.resetTransform();
			 g.drawImage(this.dialogue, P_BAR_X, P_BAR_Y);
			 b.afficherDialogueBossFinG(g,P_BAR_X+12,P_BAR_Y,player);
		 }else if(j.getboss().getcombat()==1 && j.getboss().getbattu()==2 && j.getboss().getdernier()==false){
			 g.resetTransform();
			 g.drawImage(this.dialogue, P_BAR_X, P_BAR_Y);
			 b.afficherDialogueBossFinP(g,P_BAR_X+12,P_BAR_Y,player);
		 }else if(j.getboss().getcombat()==2 && j.getboss().getdernier()==false){
			 g.resetTransform();
			 g.drawImage(this.dialogue, P_BAR_X, P_BAR_Y);
			 b.afficherDialogueBossAttente(g,P_BAR_X+12,P_BAR_Y,player);
		 }else if(j.getboss().getcombat()==0 && j.getboss().getdernier()==true){
			 g.resetTransform();
			 g.drawImage(this.dialogue, P_BAR_X, P_BAR_Y);
			 b.afficherDialogueBossF(g,P_BAR_X+12,P_BAR_Y,player);
			 player.getjeu().setbossencounter(true);
		 }else if(j.getboss().getcombat()==1 && j.getboss().getbattu()==1 && j.getboss().getdernier()==true){
			 g.resetTransform();
			 g.drawImage(this.dialogue, P_BAR_X, P_BAR_Y);
			 b.afficherDialogueBossFinGF(g,P_BAR_X+12,P_BAR_Y,player);
		 }else if(j.getboss().getcombat()==1 && j.getboss().getbattu()==2 && j.getboss().getdernier()==true){
			 g.resetTransform();
			 g.drawImage(this.dialogue, P_BAR_X, P_BAR_Y);
			 b.afficherDialogueBossFinPF(g,P_BAR_X+12,P_BAR_Y,player);
		 }else if(j.getboss().getcombat()==2 && j.getboss().getdernier()==true){
			 g.resetTransform();
			 g.drawImage(this.dialogue, P_BAR_X, P_BAR_Y);
			 b.afficherDialogueBossAttenteF(g,P_BAR_X+12,P_BAR_Y,player);
		 }
	 }
	 public void render(Graphics g,Personne p,Joueur player) throws SlickException {
		  g.resetTransform();
		  g.drawImage(this.dialogue, P_BAR_X, P_BAR_Y);
		  p.afficherDialogue(g,P_BAR_X+12,P_BAR_Y,player);
	 }
	 public void render(Graphics g,ExpertMetier em,Joueur player) throws SlickException {
		  if(player.getchoixapp()==0 && player.getchoixoubl()==0 && player.getmetier()==0 && player.gettour()==0){
			  g.resetTransform();
			  g.drawImage(this.dialogue, P_BAR_X, P_BAR_Y);
			  em.afficherDialogueEM(g,P_BAR_X+12,P_BAR_Y,player);
		  }
		  else if(player.getchoixapp()!=0 && player.getmetier()==0){
			  g.resetTransform();
			  g.drawImage(this.dialogue, P_BAR_X, P_BAR_Y);
			  em.afficherDialogueApp(g,P_BAR_X+12,P_BAR_Y,player);
		  }
		  else if(player.getchoixoubl()!=0){
			  g.resetTransform();
			  g.drawImage(this.dialogue, P_BAR_X, P_BAR_Y);
			  em.afficherDialogueOubl(g,P_BAR_X+12,P_BAR_Y,player);
		  }
		  else if(player.getmetier()!=0){
			  System.out.println("metier presque appris");
			  g.resetTransform();
			  g.drawImage(this.dialogue, P_BAR_X, P_BAR_Y);
			  em.afficherDialogueMetier(g,P_BAR_X+12,P_BAR_Y,player);
		  }
	 }
	 public void render(Graphics g,Marchand m,Joueur player) throws SlickException {
		 if(player.getchoix()==0){
			 g.resetTransform();
			 g.drawImage(this.dialogue, P_BAR_X, P_BAR_Y);
			 m.afficherDialogueM1(g,P_BAR_X+12,P_BAR_Y,player);
		 }else if(player.getchoix()==1){
			 g.resetTransform();
			 g.drawImage(this.dialogue, P_BAR_X, P_BAR_Y);
			 m.afficherDialogueM2(g,P_BAR_X+12,P_BAR_Y,player);
		 }
	 }
	 public void render(Graphics g,Rocher r,Joueur player,Inventaire inv) throws SlickException {
		 g.resetTransform();
		 g.drawImage(this.dialogue, P_BAR_X, P_BAR_Y);
		 r.afficherDialogueRoch(g,P_BAR_X+12,P_BAR_Y,player,inv);
	 }
	 public void render(Graphics g,Forge f,Joueur player,Inventaire inv,JournalQuete jq) throws SlickException{
		 g.resetTransform();
		 if(f.geti()>-1 || player.getMetier().getidMetier()!=2)
		 g.drawImage(this.dialogue, P_BAR_X, P_BAR_Y);
		 f.afficherDialogueForge(g,P_BAR_X+12,P_BAR_Y,player,inv,jq);	 
	 }
	
}
