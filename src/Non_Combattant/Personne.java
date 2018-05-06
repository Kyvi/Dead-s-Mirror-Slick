package Non_Combattant;

import Graphisme.Dialogue;
import package1.Joueur;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

import Menu.Inventaire;
import Menu.JournalQuete;

public abstract class Personne {

	private Image personne;
	private Animation[] animations = new Animation[4];
	private  int position;
	private int abs;
	private int ord;
	private int idPersonne;
	protected String nomPersonne;
	private String tableauDialogue[];
	private int indice;
	private int animposition;
	private boolean notlook=true;
	
	public Personne(int i,String n,String t[],int k,int p,int x,int y){
		position=p;
		abs=x;
		ord=y;
		int j;
		indice=k;
		tableauDialogue=new String[k];
		idPersonne=i;
		nomPersonne=n;
		for(j=0;j<k;j++)tableauDialogue[j]=t[j];
	}
	
	
	
	public String getdialogue(int i){
		return tableauDialogue[i];
	}
	
	public int getx(){
		return abs;
	}
	public int gety(){
		return ord;
	}
	
	private Animation loadAnimation(SpriteSheet spriteSheet, int startX, int endX, int y) {
		 Animation animation = new Animation();
		 for (int x = startX; x < endX; x++) {
		      animation.addFrame(spriteSheet.getSprite(x, y), 100);
		 }
		 return animation;
	 }
	public void init(StateBasedGame game,SpriteSheet t) throws SlickException {
		SpriteSheet spriteSheet = t;
	    this.animations[0] = loadAnimation(spriteSheet, 0, 1, 0);
	    this.animations[1] = loadAnimation(spriteSheet, 0, 1, 1);
	    this.animations[2] = loadAnimation(spriteSheet, 0, 1, 2);
	    this.animations[3] = loadAnimation(spriteSheet, 0, 1, 3);
	  }
	public void render(Graphics g) throws SlickException {
	    g.setColor(new Color(0, 0, 0, .5f));
	    g.fillOval(abs , ord + 35, 32, 16);
	    g.drawAnimation(animations[animposition],(int) abs,(int) ord);
	    
	    if (idPersonne<10){
	    	DonneurQuete dq = (DonneurQuete) this;
	    	if (dq.getcompteur()==1){g.drawImage(new Image("src/package1/ressources/personnes/exclamation.png").getScaledCopy(12, 35), abs+12, ord-40);
	    	
	    	} 
	    	if (dq.getQuete().getetat()==1) {g.drawImage(new Image("src/package1/ressources/personnes/question.gif").getScaledCopy(60, 65), abs-10, ord-50);
	    	} 
	}
	}
	public void update(int delta) throws SlickException {
		if (notlook){
		if(Math.random()<0.01){
			if (animposition==3){animposition=0;}
			else{animposition=animposition+1;};
		}}
	}
	
	public void setnotlook(boolean b){
		notlook=b;
	}
	
	public void lookatme(double x, double y){
		if (x<abs){animposition=1;}
		if (abs+40<x){animposition=2;}
		if(y<ord+30){animposition=3;}
		if(ord+70<y){animposition=0;}
	}
	
	
	public int getidPersonne(){
		return idPersonne;
	}
	
	public String getnomPersonne(){
		return nomPersonne;
	}
	public int ecrire(Graphics g,String s,int l,int x,int y){
		int psize=0;
		int compteur=0;
		while(psize+l<s.length()){
			int pexact=psize+l-10;
			while(s.charAt(pexact)!=' ')pexact++;
			g.drawString(s.substring(psize,pexact+1), x, y+(20*compteur));
			psize=pexact+1;
			compteur++;
		}
		g.drawString(s.substring(psize), x, y+(20*compteur));
		return compteur;
	}
	public void afficherDialogue(Graphics g,int x,int y,Joueur player)throws SlickException{
		int j,compt;
		int k=15;
	    g.setColor(new Color(255,255,255));
		for(j=0;j<indice;j++){
			compt=ecrire(g,tableauDialogue[j],67,x,y+k);
			k=k+20*(compt+1);
		}
	}
	
	public abstract void interactionBis(JournalQuete j,Inventaire inv,Joueur p,Graphics g,Dialogue d);
	public void interaction(Joueur p,JournalQuete j,Inventaire inv,Graphics g,Dialogue d) throws SlickException{
		interactionBis(j,inv,p,g,d);
		if(j.getDerniereQuete().getetat()==0){
			if(j.getDerniereQuete().gettype()==1){
				j.getDerniereQuete().ValiderQuete(idPersonne,inv,j);
			}
		}
	}
}
