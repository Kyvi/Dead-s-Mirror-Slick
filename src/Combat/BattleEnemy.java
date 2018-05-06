package Combat;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.Font;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.geom.Vector2f;

import shionn.slick.animation.BezierPath;
import shionn.slick.animation.PathAnimation;



public class BattleEnemy {

	private Image ennemy;
	private int idmonstre;
	protected String nom;
	private int niveau;
	private int attaque;
	private int viemax;
	private int tableauObjet[];
	private int nombreObjet;
	private int exp;
	private int argent;
	private int vie;
	private PathAnimation animation;
	private Animation[] explode = new Animation[5];
	private Animation[] thunder = new Animation [5];
	private Animation[] flamme = new Animation [4];
	private Animation[] tsunami = new Animation [4];
	private Animation[] deflagration = new Animation [4];
	private Animation[] blizzard = new Animation [7];
	private Animation[] pluie = new Animation [3];
	private Animation[] brise = new Animation [5];
	private Animation[] tornado = new Animation [3];

	public BattleEnemy(int id,int niv,String n,int tabObj[],int nombre,int e,int arg){
		int i;
		nom=n;
		niveau=niv;
		viemax=niv*5;
		vie=viemax;
		attaque=niv*2;
		nombreObjet=nombre;
		exp=e;
		argent=arg;
		idmonstre=id;
		tableauObjet=new int[nombre];
		for(i=0;i<nombre;i++)tableauObjet[i]=tabObj[i];
	}
	public PathAnimation getanimation(){
		return animation;
	}
	
	
	public Animation getexplode(int i){
		return explode[i];
	}
	
	public Animation getthunder(int i){
		return thunder[i];
	}
	
	public Animation getflamme(int i){
		return flamme[i];
	}
	
	public Animation gettsunami(int i){
		return tsunami[i];
	}
	
	public Animation getdeflagration(int i){
		return deflagration[i];
	}
	
	public Animation getblizzard(int i){
		return blizzard[i];
	}
	
	public Animation getpluie(int i){
		return pluie[i];
	}
	
	public Animation getbrise(int i){
		return brise[i];
	}
	
	public Animation gettornado(int i){
		return tornado[i];
	}
	
	public int getniveau(){
		return niveau;
	}
	
	public String getnom(){
		return nom;
	}
	public int getnombreObj(){
		return nombreObjet;
	}
	public int getvie(){
		return vie;
	}
	public int getObjet(int i){
		return tableauObjet[i];
	}
	public int getargent(){
		return argent;
	}
	public int getexp(){
		return exp;
	}
	public int getattaque(){
		return attaque;
	}
	public int getId(){
		return idmonstre;
	}
	private Animation loadAnimation(SpriteSheet spriteSheet, int startX, int endX, int y) {
		 Animation animation = new Animation();
		 for (int x = startX; x < endX; x++) {
		      animation.addFrame(spriteSheet.getSprite(x, y), 100);
		 }
		 return animation;
	 }
	
	  public void init(Image im) throws SlickException {
		  SpriteSheet thunder = new SpriteSheet("src/package1/ressources/Sprites/attaques/thunder.png", 192,192);
		  SpriteSheet explosion = new SpriteSheet("src/package1/ressources/Sprites/attaques/explosion.png", 64,64);
		  SpriteSheet flamme = new SpriteSheet("src/package1/ressources/Sprites/attaques/deflagration.png", 96,96);
		  SpriteSheet tsunami = new SpriteSheet("src/package1/ressources/Sprites/attaques/tsunami.png", 192,192);
		  SpriteSheet deflagration = new SpriteSheet("src/package1/ressources/Sprites/attaques/deflagration2.png", 192,192);
		  SpriteSheet blizzard = new SpriteSheet("src/package1/ressources/Sprites/attaques/blizzard.png", 170,170);
		  SpriteSheet pluie = new SpriteSheet("src/package1/ressources/Sprites/attaques/pluie.png", 192,192);
		  SpriteSheet brise = new SpriteSheet("src/package1/ressources/Sprites/attaques/brise.png", 192,192);
		  SpriteSheet tornado = new SpriteSheet("src/package1/ressources/Sprites/attaques/tornado.png", 192,192);
		  this.explode[0] = loadAnimation(explosion,0,5,0);
		  this.explode[1] = loadAnimation(explosion,0,5,1);
		  this.explode[2] = loadAnimation(explosion,0,5,2);
		  this.explode[3] = loadAnimation(explosion,0,5,3);
		  this.explode[4] = loadAnimation(explosion,0,5,4);
		  this.thunder[0] = loadAnimation(thunder,0,5,0);
		  this.thunder[1] = loadAnimation(thunder,0,5,1);
		  this.thunder[2] = loadAnimation(thunder,0,5,2);
		  this.thunder[3] = loadAnimation(thunder,0,5,3);
		  this.thunder[4] = loadAnimation(thunder,0,5,4);
		  this.flamme[0] = loadAnimation(flamme,0,5,0);
		  this.flamme[1] = loadAnimation(flamme,0,5,1);
		  this.flamme[2] = loadAnimation(flamme,0,5,2);
		  this.flamme[3] = loadAnimation(flamme,0,5,3);
		  this.tsunami[0] = loadAnimation(tsunami,0,5,0);
		  this.tsunami[1] = loadAnimation(tsunami,0,5,1);
		  this.tsunami[2] = loadAnimation(tsunami,0,5,2);
		  this.tsunami[3] = loadAnimation(tsunami,0,5,3);
		  this.deflagration[0] = loadAnimation(deflagration,0,5,0);
		  this.deflagration[1] = loadAnimation(deflagration,0,5,1);
		  this.deflagration[2] = loadAnimation(deflagration,0,5,2);
		  this.deflagration[3] = loadAnimation(deflagration,0,5,3);
		  this.blizzard[0] = loadAnimation(blizzard,0,5,0);
		  this.blizzard[1] = loadAnimation(blizzard,0,5,1);
		  this.blizzard[2] = loadAnimation(blizzard,0,5,2);
		  this.blizzard[3] = loadAnimation(blizzard,0,5,3);
		  this.blizzard[4] = loadAnimation(blizzard,0,5,4);
		  this.blizzard[5] = loadAnimation(blizzard,0,5,5);
		  this.pluie[0] = loadAnimation(pluie,0,5,0);
		  this.pluie[1] = loadAnimation(pluie,0,5,1);
		  this.pluie[2] = loadAnimation(pluie,0,5,2);
		  this.brise[0] = loadAnimation(brise,0,5,0);
		  this.brise[1] = loadAnimation(brise,0,5,1);
		  this.brise[2] = loadAnimation(brise,0,5,2);
		  this.brise[3] = loadAnimation(brise,0,5,3);
		  this.brise[4] = loadAnimation(brise,0,5,4);
		  
		  this.tornado[0] = loadAnimation(tornado,0,5,2);
		  this.tornado[1] = loadAnimation(tornado,0,5,3);
		  this.tornado[2] = loadAnimation(tornado,0,5,4);
		  
		  
		  
		  
		  this.animation = new PathAnimation(new BezierPath(0, 0, -700, 1, -50, 20, 0, 0), 2000);
	    this.ennemy = im;
	    
	  }

	  public void render(GameContainer container,Graphics g) {
		  Vector2f p = animation.currentLocation();
		    this.ennemy.drawCentered(p.x + container.getWidth() * 3 / 4, p.y + container.getHeight() / 2);
	  }
	  public void setPv(int pv) { this.vie = pv; }
	  public int getPv() { return vie; }
	  public int getviemax(){ return viemax;}
	  
	  public void update(int delta) {
		  this.animation.update(delta);
		}

		
		public void startAttack() {
			
		  this.animation.start();
		}
}
