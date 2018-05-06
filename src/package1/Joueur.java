package package1;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;

import metier.ForgeGameState;
import metier.Metier;
import Graphisme.Dialogue;
import Graphisme.Map;
import Menu.BattreMonstre;
import Menu.Inventaire;
import Menu.JournalQuete;
import Menu.Objet;
import Menu.ObjetUtilisable;
import Menu.ParlerAQq;
import Menu.Quete;
import Menu.RamenerObjet;
import Non_Combattant.Personne;

public class Joueur {

	private float x = 2000, y = 2000;
	 //private float x=400 ,y=300;
	 private int direction = 0;
	 private boolean moving = false;
	 private boolean interact=false;
	 private Animation[] animations = new Animation[8];
	 private boolean onStair = false;
	 private Map map;
	 private String nom;
	 private int sexe;
	 private Jeu jeu;
	 private JournalQuete jq;
	 private Inventaire inv;
	 private int indice;
	 private int var;
	 private Dialogue dial;
	 private Metier metier;
	 protected Equipement equipement;
	 protected int niveauMax;
	 protected int experience;
	 protected int experienceMax;
	 protected int mana;
	 protected static int manaMax;
	 protected int vie;
	 protected int vieMax;
	 protected int attaque;
	 protected int defense;
	 protected int niveau;
	 private int type=0;
	 private int arretcaillou=0;
	 private int arretforge=0;
	 private int arretrec=0;
	 private int pointeur=0;
	 private int choixapp=0;
	 private int choixoubl=0;
	 private int metiers=0;
	 private int findial=0;
	 private int tour=0;
	 private int choix=0;
	 private int menu = 0;
	 private StateBasedGame game;
	 private float vitesse=0.1f;
	 private int zone=5;
	 
	 
	 

	  public Joueur(Map map,Jeu je,JournalQuete jourq,Inventaire inven,Metier m,Equipement eq) {
	    int i,j;
		this.map = map;
	    jeu=je;
		inv=inven;
		metier=m;
		equipement=eq;
		jq=jourq;
	    var=0;
	    niveauMax=50;
	    experience=0;
	    experienceMax=1000;
	    mana=100;
	    manaMax=100;
	    niveau=7;
	    vieMax=niveau*5;
	    vie=vieMax;
	    attaque=niveau*2;
	    defense=niveau*2;
	    
	   
	  }
	  
	  public void setMenu(int m){
		  menu = m;
	  }
	  
	  public int getMenu(){
		  return menu;
	  }
	  
	  public void setsexe(int s){
		  sexe = s;
	  }
	  
	  public int getsexe(){
		 return sexe;
	  }
	  
	  public void setexperienceMax(int i){
		  experienceMax=i;
	  }
	  public void setnom(String s){
		  nom=s;
	  }
	  public int getzone(){
		  return zone;
	  }
	  
	  public void setmanaMax(int i){
		  manaMax=i;
	  }
	  public void setvitesse(float f){
		  vitesse=f;
	  }
	  public int gettour(){
		  return tour;
	  }
	  public int getchoix(){
		  return choix;
	  }
	  public void setchoix(int i){
		  choix=i;
	  }
	  public void setarretrec(int i){
		  arretrec=i;
	  }
	  public void settour(int i){
		  tour=i;
	  }
	  public void setpointeur(int i){
			pointeur=i;
		}
	  public void setfindial(int i){
			findial=i;
		}
	  public void setmetier(int i){
			metiers=i;
		}
	  public void setchoixapp(int i){
			choixapp=i;
		}
	  public void setchoixoubl(int i){
			choixoubl=i;
		}
		public int getpointeur(){
			return pointeur;
		}
		public int getfindial(){
			return findial;
		}
		public int getmetier(){
			return metiers;
		}
		public int getchoixapp(){
			return choixapp;
		}
		public int getchoixoubl(){
			return choixoubl;
		}
		public int getvie(){
			return vie;
		}
		
		public void setvie(int v){
			vie=v;
		}
		
		public int getvieMax(){
			return vieMax;
		}
		
		public void setvieMax(int v){
			vieMax = v;
		}
		
		public int getattaque(){
			return attaque;
		}
		public int getexperience(){
			return experience;
		}
		
		public int getmanaMax(){
			return manaMax;
		}
		
		public void setmana(int m){
			mana=m;
		}
		
		public int getexperienceMax(){
			return experienceMax;
		}
		
		public void setexperience( int exp){
			experience = exp;
		}
		public int getmana(){
			return mana;
		}
		public int getniveau(){
			return niveau;
		}
		
		public void setniveau(int i){
			niveau=i;
		}
		
		public int getdefense(){
			return defense;
		}
		
		public void setattaque(int i){
			attaque=i;
		}
		
		public void setdefense(int i){
			defense=i;
		}
		
	  public Metier getMetier(){
			return metier;
		}
	  public Equipement getEquipement(){
			return equipement;
		}
	  
	  public String getnom(){
		  return nom;
	  }
	  public void setvar(int v){
		  var=v;
	  }
	  public int getvar(){
		  return var;
	  }
	 public void setarretcaillou(int i){
		 arretcaillou=i;
	 }
	 public void setarretforge(int i){
		 arretforge=i;
	 }
	 public Jeu getjeu(){
		 return jeu;
	 }
	 public int getarretforge(){
		 return arretforge;
	 }
	 public void setAnimation(SpriteSheet ss){
		 this.animations[0] = loadAnimation(ss, 0, 1, 3);
		    this.animations[1] = loadAnimation(ss, 0, 1, 1);
		    this.animations[2] = loadAnimation(ss, 0, 1, 0);
		    this.animations[3] = loadAnimation(ss, 0, 1, 2);
		    this.animations[4] = loadAnimation(ss, 1, 4, 3);
		    this.animations[5] = loadAnimation(ss, 1, 4, 1);
		    this.animations[6] = loadAnimation(ss, 1, 4, 0);
		    this.animations[7] = loadAnimation(ss, 1, 4, 2);
	 }
	  private Animation loadAnimation(SpriteSheet spriteSheet, int startX, int endX, int y) {
		 Animation animation = new Animation();
		 for (int x = startX; x < endX; x++) {
		      animation.addFrame(spriteSheet.getSprite(x, y), 100);
		 }
		 return animation;
	 }
	  
	  public void init(StateBasedGame game) throws SlickException {
		    this.game=game;
		    
	    	
	 }
	  
	  public void render(Graphics g,Dialogue d) throws SlickException {
		    g.setColor(new Color(0, 0, 0, .5f));
		    g.fillOval(x - 32, y - 24, 32, 16);
		    g.drawAnimation(animations[direction + (moving ? 4 : 0)], x-32, y-60);
		    if(var==1){
		    	if(type==1){
		    		if(jeu.getperso(indice).getidPersonne()>=10 && jeu.getperso(indice).getidPersonne()<=11){
		    			findial=1;
			    		jeu.getperso(indice).interaction(this,jq,inv,g,d);
		    		}else {
		    			if(arretrec==0){
		    				findial=1;
		    				jeu.getperso(indice).interaction(this,jq,inv,g,d);
		    				arretrec=1;
		    			}
		    		}
		    	}
		    	if(type==2){
		    		if(arretcaillou==0){
		    		jeu.getrocher(indice).interaction(this,inv,jq);
		    		arretcaillou=1;
		    		}
		    	}
		    	if(type==3){
		    		jeu.getforge(indice).interaction(this, inv, jq);
		    		
		    	}
		    	if(type==4 && jeu.getboss().getcombat()==1){
		    		if(jeu.getboss().getbattu()==0){
		    			jeu.setnumboss(indice);
		    			jeu.getboss().interaction(indice);
		    		}
		    		
		    	}
		    }
		    
	}
	  public int gettype(){
		  return type;
	  }
	  
	  private float getFuturX(int delta) {
		  float futurX = this.x;
		  switch (this.direction) {
		  case 1: futurX = this.x - vitesse * delta; break;
		  case 3: futurX = this.x + vitesse * delta; break;
		  }
		  return futurX;
		}

		private float getFuturY(int delta) {
		  float futurY = this.y;
		  switch (this.direction) {
		  case 0: futurY = this.y - vitesse * delta; break;
		  case 2: futurY = this.y + vitesse * delta; break;
		  case 1: if (this.onStair) {
		            futurY = this.y + vitesse * delta;
		          } break;
		  case 3: if (this.onStair) {
		            futurY = this.y - vitesse * delta;
		          } break;
		  }
		  return futurY;
		}
		
		public void update(int delta) throws SlickException {
			  
			  float futurX = getFuturX(delta);
			    float futurY = getFuturY(delta);
			  if (this.moving) {
			    boolean collision = this.map.isCollision(futurX, futurY);
		    	boolean zone1=this.map.isZone1(futurX, futurY);
		    	boolean zone2=this.map.isZone2(futurX, futurY);
		    	boolean zone3=this.map.isZone3(futurX, futurY);
		    	boolean zone4=this.map.isZone4(futurX, futurY);
		    	boolean ville1=this.map.isVille1(futurX, futurY);
		    	boolean ville2=this.map.isVille2(futurX, futurY);
		    	boolean ville3=this.map.isVille3(futurX, futurY);
			    if (collision) {
			      this.moving = false;
			    
			    } else {
			      this.x = futurX;
			      this.y = futurY;
			    }
		    	if(zone1) zone=1;
		    	if(zone2) zone=2;
		    	if(zone3) zone=3;
		    	if(zone4) zone=4;
		    	if(ville1) zone=5;
		    	if(ville2) zone=6;
		    	if(ville3) zone=7;
		    	
			 
			  }else if(this.interact){
			    boolean obstacle = this.map.isObstacle(futurX, futurY);
			    if(obstacle){
			    	boolean personne = this.map.isPersonne(futurX, futurY);
			    	boolean rocher=this.map.isRocher(futurX,futurY);
			    	boolean forge=this.map.isForge(futurX,futurY);
			    	boolean boss=this.map.isBoss(futurX,futurY);
			    	if(personne){
			    		int i=0;
			    		 while(!((futurX>=jeu.gettabperso(i, 0)-100)&&(futurX<=jeu.gettabperso(i, 0)+100) &&( futurY>=jeu.gettabperso(i, 1)-100)&&(futurY<=jeu.gettabperso(i, 1)+100))){
			    			 i++;
			    		 }
			    		 type=1;
			    		 var=1;
			    		 indice=i;
			    	}else if(rocher){
			    		int i=0;
			    		while(!((futurX>=jeu.gettabrocher(i,0)-100) && (futurX<=jeu.gettabrocher(i, 0)+100) &&( futurY>=jeu.gettabrocher(i, 1)-100)&&(futurY<=jeu.gettabrocher(i, 1)+100))){
			    			i++;
			    		}

			    		type=2;
			    		var=1;
			    		indice=i;
			    	}else if(forge){
			    		int i=0;
			    		 while(!((futurX>=jeu.gettabforge(i, 0)-100)&&(futurX<=jeu.gettabforge(i, 0)+100) &&( futurY>=jeu.gettabforge(i, 1)-100)&&(futurY<=jeu.gettabforge(i, 1)+100))){
			    			 i++;
			    		 }
			    		 type=3;
			    		 var=1;
			    		 if(metier.getidMetier()==2) game.enterState(ForgeGameState.ID);
			    		 indice=i;
			    	}else if(boss){
			    		int i=0;
			    		while(!((futurX>=jeu.gettabboss(i, 0)-300)&&(futurX<=jeu.gettabboss(i, 0)+300) &&( futurY>=jeu.gettabboss(i, 1)-300)&&(futurY<=jeu.gettabboss(i, 1)+300))){
			    			i++;
			    		}
			    		
			    		type=4;
			    		var=1;
			    		indice=i;
			    	}
			    } else {menu =0;}
			  
			  }
		}
	public float getX() { return x; }
	public void setX(float x) { this.x = x; }
	public float getY() { return y; }
	public void setY(float y) { this.y = y; }
	public int getDirection() { return direction; }
	public void setDirection(int direction) { this.direction = direction; }
	public boolean isMoving() { return moving; }
	public void setMoving(boolean moving) { this.moving = moving; }
	public boolean isInteracting() { return interact; }
	public void setInteracting(boolean interact) { this.interact =interact; }
	public boolean isOnStair() { return onStair; }
	public void setOnStair(boolean onStair) { this.onStair = onStair; }
	public int getindice(){ return indice;}	  
		
}
