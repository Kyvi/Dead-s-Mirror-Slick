package Combat;

import org.newdawn.slick.Color;
import org.newdawn.slick.Font;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

import package1.Joueur;
import shionn.slick.animation.BezierPath;
import shionn.slick.animation.PathAnimation;



public class BattlePlayer {

	
	protected int indice;
	private Joueur player;
	private int pv;
	private int vie;
	private int type=0; // Pour savoir si c'est mag ou guer
	private int attaque;
	private int defense;
	private Image hero;
	private String nom;
	private int manamax;
	private int niveau;
	private int mana;
	private int experience;
	private int experienceMax;
	private PathAnimation animation;
	private PathAnimation fictive;
	private Attaque tabattmag[];
	private Attaque tabattguer[];

	public BattlePlayer(Joueur j,Attaque tabm[],Attaque tabg[]){
		int i;
		player=j;
		experience=player.getexperience();
		experienceMax=player.getexperienceMax();
		attaque=player.getattaque();
		defense=player.getdefense();
		nom= player.getnom();
		manamax=player.getmanaMax();
		niveau=player.getniveau();
		vie=niveau*5;
		pv = vie;
		mana=manamax;
		tabattmag=new Attaque[8];
		tabattguer=new Attaque[8];
		for(i=0;i<8;i++){
			tabattmag[i]=tabm[i];
			tabattguer[i]=tabg[i];
		}
		indice=1;
	}
	  public void init() throws SlickException {
		  this.fictive = new PathAnimation(new BezierPath(0, 0, 0, 0, 0, 0, 0, 0), 2000);
		  this.animation = new PathAnimation(new BezierPath(0, 0, 700, 1, -50, 20, 0, 0), 2000);
	    
	  }
	  public PathAnimation getanimation(){
			return animation;
		}
		
	  public PathAnimation getfictive(){
			return fictive;
		}
	  
	  public void setniveau(int i){
		  niveau=i;
	  }
	  public void setattaque(int i){
		  attaque=i;
	  }
	  public void setdefense(int i){
		  defense=i;
	  }
	  public int getattaque(){
		  return attaque;
	  }
	  public void setmanaMax(int i){
		  manamax=i;
	  }
	  public int getmanaMax(){
		  return manamax;
	  }
	  public int getniveau(){
		  return niveau;
	  }
	  public void setvie(int i){
		  vie=i;
	  }
	  public int getvie(){
		  return vie;
	  }
	  public int getmana(){
		  return mana;
	  }
	  public int getexperience(){
		  return experience;
	  }
	  public int getexperienceMax(){
		  return experienceMax;
	  }
	  public void setexperience(int i){
		  experience=i;
	  }
	  public void setexperienceMax(int i){
		  experienceMax=i;
	  }
	  public void setmana(int i){
		  mana=i;
	  }
	  public void reset() {
		  this.pv = vie;
		  this.mana=manamax;
		}
	  public int gettype(){
		  return type;
	  }
	  public void settype(int i){
		  type=i;
	  }
	  public int getdefense(){
		  return defense;
	  }
	  public Attaque getAttaque(int i){
		  if(type==0) return tabattmag[i];
		  else return tabattguer[i];
	  }
	  public int getindice(){
		  return indice;
	  }
	  public void setindice(int i){
		  indice = i;
	  }
	  
	  public void render(GameContainer container,Graphics g) {
		  Vector2f p = animation.currentLocation();
		  hero.drawCentered(p.x + container.getWidth() * 1 / 4, p.y + container.getHeight() / 2);
	  }
	  
	  public void setPv(int pv) { this.pv = pv; }
	  public int getPv() { return pv; } 
	  public void setimage(Image i){
		  hero = i;
	  }
	  
	  public void update(int delta) {
		  this.fictive.update(delta);
		  this.animation.update(delta);
		}

	  public void animebarre(){
		  this.fictive.start();
	  }
		
		public void startAttack() {
		  this.animation.start();
		}
}
