package Combat;


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

import package1.Jeu;
import package1.Joueur;

import Menu.Inventaire;
import Menu.JournalQuete;

public class Boss extends BattleEnemy{

	
	private int x;
	private int y;
	private StateBasedGame game;
	private Jeu jeu;
	private Animation[] animations = new Animation[4];
	private Image im;
	private Sound launch;
	private Music battleboss;
	private Sound musiclave;
	private FadeOutTransition fot;
	private FadeInTransition fit;
	 private int combat=0;
	 private int battu=0;
	 private boolean dern;
	
	public Boss(int id, int niv, String n, int[] tabObj, int nombre, int e,int arg,int abs,int ord,Jeu j,boolean dernier) {
		super(id, niv, n, tabObj, nombre, e, arg);
		x=abs;
		y=ord;
		jeu=j;
		dern=dernier;
	}
	private Animation loadAnimation(SpriteSheet spriteSheet, int startX, int endX, int y) {
		 Animation animation = new Animation();
		 for (int x = startX; x < endX; x++) {
		      animation.addFrame(spriteSheet.getSprite(x, y), 100);
		 }
		 return animation;
	 }
	public void render(Graphics g, int ani) throws SlickException {
		switch(this.getId()){
		case 21 : 
			g.setColor(new Color(0, 0, 0, .5f));
			g.fillOval(x+20 , y + 50, 32, 16);
			g.drawAnimation(animations[ani],(int) x,(int) y);
			break;
		case 22 :
			g.setColor(new Color(0, 0, 0, .5f));
			g.fillOval(x+8 , y + 40, 32, 16);
			g.drawAnimation(animations[ani],(int) x,(int) y);
			break;
		case 23 :
			g.setColor(new Color(0, 0, 0, .5f));
			g.fillOval(x , y + 35, 32, 16);
			g.drawAnimation(animations[ani],(int) x,(int) y);
			break;
		case 24 :
			g.setColor(new Color(0, 0, 0, .5f));
			g.fillOval(x+50 , y + 105, 32, 16);
			g.drawAnimation(animations[ani],(int) x,(int) y);
			break;
		case 25 :
			g.setColor(new Color(0, 0, 0, .5f));
			g.fillOval(4658 , 4587, 32, 16);
			g.drawAnimation(animations[ani],4610,4475);
			break;
			
		}
		
	    
	}

	  public int getcombat(){
		  return combat;
	  }
	  public void setcombat(int i){
		  combat=i;
	  }
	  public int getbattu(){
		  return battu;
	  }
	  public void setbattu(int i){
		  battu=i;
	  }
	public void init(StateBasedGame game,SpriteSheet t, Music m) throws SlickException {
		SpriteSheet spriteSheet = t;
		if (this.getId()!=24){
	    this.animations[0] = loadAnimation(spriteSheet, 0, 1, 0);
	    this.animations[1] = loadAnimation(spriteSheet, 0, 1, 1);
	    this.animations[2] = loadAnimation(spriteSheet, 0, 1, 2);
	    this.animations[3] = loadAnimation(spriteSheet, 0, 1, 3);}
		else{this.animations[0] = loadAnimation(spriteSheet,7,8,2);}
		
	    
	    this.game=game;
	    launch=new Sound("/src/package1/ressources/music/launch.wav");
		 battleboss = m;

		 
		 fot=new FadeOutTransition(Color.black, 2000);
		 fit=new FadeInTransition(Color.black);
	  }
	public void interaction(int num){
		
		  //launch.play();
		  battleboss.loop();
		  battleboss.setVolume(0f);
		  battleboss.fade(5000,0.8f,false);
			game.enterState(num+41,fot, fit);
	}
	public boolean getdernier(){
		return dern;
	}
	public void afficherDialogueBoss(Graphics g,int x,int y,Joueur player){
		int k=15;
	    g.setColor(new Color(255,255,255));
		g.drawString("Salut Je suis "+nom+", tu ne passeras pas sans m'affronter!!!",x,y+k);
		k+=20;
		g.drawString("Pret ?",x,y+k);
		k+=20;
		g.setColor(new Color(0,255,255,100));
	    g.fillRect(x,y+k+player.getpointeur(), 50, 20);
	    g.setColor(Color.white);
		g.drawString("Oui", x, y+k);
	    k+=20;
	    g.drawString("Non", x, y+k);
		k+=20;
	}
	public void afficherDialogueBossFinG(Graphics g,int x,int y,Joueur player){
		int k=15;
	    g.setColor(new Color(255,255,255));
		g.drawString("Sale mioche tu m'as battu, elle va me tuer....",x,y+k);
		k+=20;
	}
	public void afficherDialogueBossFinP(Graphics g,int x,int y,Joueur player){
		int k=15;
	    g.setColor(new Color(255,255,255));
		g.drawString("Reviens quand tu auras grandi va!",x,y+k);
		k+=20;
	}
	public void afficherDialogueBossAttente(Graphics g,int x,int y,Joueur player){
		int k=15;
	    g.setColor(new Color(255,255,255));
		g.drawString("Tu as raison va te preparer sale mioche",x,y+k);
		k+=20;
	}
	public void afficherDialogueBossF(Graphics g,int x,int y,Joueur player){
		int k=15;
	    g.setColor(new Color(255,255,255));
		g.drawString("Mirrathia : Tu arrives trop tard sale mioche!",x,y+k);
		k+=15;
		g.drawString("Keldranor : Et tu vas payer!!",x,y+k);
		k+=15;
		g.drawString("Ensemble :Pret Gamin ?",x,y+k);
		k+=15;
		g.setColor(new Color(0,255,255,100));
	    g.fillRect(x,y+k+player.getpointeur(), 50, 20);
	    g.setColor(Color.white);
		g.drawString("Oui", x, y+k);
	    k+=20;
	    g.drawString("Non", x, y+k);
		k+=20;
	}
	public void afficherDialogueBossFinGF(Graphics g,int x,int y,Joueur player){
		int k=15;
	    g.setColor(new Color(255,255,255));
		g.drawString("Mirrathia : Non !!!",x,y+k);
		k+=20;
		g.drawString("Keldranor : Nous serons ensemble au moins chérie.",x,y+k);
		k+=20;
		g.drawString("Mirrathia : Nous reviendrons sale mioche!!!",x,y+k);
		k+=20;
	}
	public void afficherDialogueBossFinPF(Graphics g,int x,int y,Joueur player){
		int k=15;
	    g.setColor(new Color(255,255,255));
		g.drawString("Mirrathia : Tu pensais pouvoir nous battre ?",x,y+k);
		k+=20;
		g.drawString("Keldranor : Nous sommes invincibles !!!!",x,y+k);
		k+=20;
	}
	public void afficherDialogueBossAttenteF(Graphics g,int x,int y,Joueur player){
		int k=15;
	    g.setColor(new Color(255,255,255));
		g.drawString("Mirrathia : Dégage, tu nous fais perdre notre temps!",x,y+k);
		k+=20;
		g.drawString("Keldranor : Allons détruire des villages chérie.",x,y+k);
		k+=20;
	}

	
	
}
