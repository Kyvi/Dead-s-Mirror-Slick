package Principal;

import java.util.Random;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

import Combat.Attaque;
import Combat.BattleEnemy;
import Combat.BattlePlayer;
import Combat.Boss;
import Menu.Inventaire;
import Menu.JournalQuete;
import Menu.ObjetUtilisable;
import package1.Jeu;
import shionn.slick.animation.AnimationListener;


public class BattleGameState extends BasicGameState {

	 
	public  int ID;
  	private Image dialogue;
  	 private static final int P_BAR_X = 70; //absisse
  	 private static final int P_BAR_Y = 473; //ordonnée
 
  	 
  	 private int ok=0;
  	private int etatcombat=0;
  	private boolean changetat = false;
  	private int pointeur=0;
  	private int choixp;
  	private int degat;
  	private int montpotion;
  	private int compteuratt = 0;
  	private int compteurdef = 0;
  	private boolean coupcritique = false;
  	private int enattaque = 0;
  	private int recevoir = 0;
  	private int myturn;
  	private int elapsedtime;
  	private int degatrestant;
  	private int degatrestantaux;
  	private int montantpotionrestant;
  	private int montantpotionaux;
  	private int manarestant;
  	private int manaprestant;
  	private int tour=0;
  	private int tourmana = 0;
  	private int tourvie=0;
  	
  	
  	
  	 private Random random = new Random();
	private StateBasedGame game;
	private Jeu jeu;
	private Image background;
	private Image backgroundlave;
	private Image backgroundzone3;
	private Splash splash;
	
	private Sound explode;
	private Sound beep;
	private Music music;
	private int tabobj1[]={0,5,10};
	private int tabobj2[]={1,5,10};
	private int tabobj3[]={0,6,10};
	private int tabobj4[]={0,5,11};
	private int tabobj5[]={0,11,15};
	private int tabobj6[]={1,7,11};
	private int tabobj7[]={2,6,11};
	private int tabobj8[]={2,7,16};
	private int tabobj9[]={36,12,16};
	private int tabobj10[]={6,12,17};
	private int tabobj11[]={2,7,13};
	private int tabobj12[]={3,7,12};
	private int tabobj13[]={2,8,12};
	private int tabobj14[]={17,8,13};
	private int tabobj15[]={18,17,30};
	private int tabobj16[]={3,8,14};
	private int tabobj17[]={4,8,13};
	private int tabobj18[]={4,9,14};
	private int tabobj19[]={19,18,26};
	private int tabobj20[]={31,37,38};
	private int tabObjBoss1[]={45};
	private int tabObjBoss2 []={44};
	private int tabObjBoss3 []={48};
	private int tabObjBoss4 []={47};
	private BattleEnemy ennemy1 = new BattleEnemy(1,7,"Gaston",tabobj1,3,500,75);
	private BattleEnemy ennemy2 = new BattleEnemy(2,6,"Gargouille",tabobj2,3,250,50);
	private BattleEnemy ennemy3 = new BattleEnemy(3,8,"Demonis",tabobj3,3,750,100);
	private BattleEnemy ennemy4 = new BattleEnemy(4,9,"Genie",tabobj4,3,1000,125);
	private BattleEnemy ennemy5 = new BattleEnemy(5,10,"Grull",tabobj5,3,1250,150);
	private BattleEnemy ennemy6 = new BattleEnemy(6,14,"Bionic",tabobj6,3,1500,175);
	private BattleEnemy ennemy7 = new BattleEnemy(7,15,"Détritus",tabobj7,3,1750,200);
	private BattleEnemy ennemy8 = new BattleEnemy(8,16,"Rex",tabobj8,3,2000,225);
	private BattleEnemy ennemy9 = new BattleEnemy(9,17,"Dinocorne",tabobj9,3,2250,250);
	private BattleEnemy ennemy10 = new BattleEnemy(10,18,"Crochet",tabobj10,3,2500,275);
	private BattleEnemy ennemy11 = new BattleEnemy(11,23,"Dumbo",tabobj11,3,2750,300);
	private BattleEnemy ennemy12 = new BattleEnemy(12,24,"Torche",tabobj12,3,3000,325);
	private BattleEnemy ennemy13 = new BattleEnemy(13,26,"Morvax",tabobj13,3,3250,350);
	private BattleEnemy ennemy14 = new BattleEnemy(14,28,"Toutenpapier",tabobj14,3,3500,375);
	private BattleEnemy ennemy15 = new BattleEnemy(15,22,"Loup",tabobj15,3,3750,400);
	private BattleEnemy ennemy16 = new BattleEnemy(16,32,"Pegase",tabobj16,3,4000,425);
	private BattleEnemy ennemy17 = new BattleEnemy(17,33,"Ursula",tabobj17,3,4250,450);
	private BattleEnemy ennemy18 = new BattleEnemy(18,34,"Dracula",tabobj18,3,4500,475);
	private BattleEnemy ennemy19 = new BattleEnemy(19,36,"Timon",tabobj19,3,5000,500);
	private BattleEnemy ennemy20 = new BattleEnemy(20,38,"Maléfique",tabobj20,3,7500,600);
	 private BattleEnemy b1= new BattleEnemy(21,12,"Cesar",tabObjBoss1,1,5000,200);
	 private BattleEnemy b2= new BattleEnemy(22,20,"DNAngel",tabObjBoss2,1,10000,2000);
	 private BattleEnemy b3= new BattleEnemy(23,30,"Ezio",tabObjBoss3,1,12500,2500);
	 private BattleEnemy b4= new BattleEnemy(24,40,"M & K",tabObjBoss4,1,25000,5000);
	 

	private BattleEnemy en []={ennemy1,ennemy2,ennemy3,ennemy4,ennemy5,ennemy6,ennemy7,ennemy8,ennemy9,ennemy10,ennemy11,ennemy12,ennemy13,ennemy14,ennemy15,ennemy16,ennemy17,ennemy18,ennemy19,ennemy20,ennemy17,b1,b2,b3,b4};
	
	

	  public BattleGameState (Jeu j, int id, Splash s){
		  jeu=j;
		  ID=id;
		  splash = s;
	  }
	  
	  public void init(GameContainer container, StateBasedGame game) throws SlickException {
	    this.game = game;
	    this.background = new Image("/src/package1/ressources/background/forest.png");
	    this.backgroundzone3 = new Image("/src/package1/ressources/background/combatzone3.png");
	    this.backgroundlave = new Image("/src/package1/ressources/background/combatlave.png");
	    this.dialogue = new Image("/src/package1/ressources/hud/dialogue.png").getScaledCopy(2);
	    
	    this.ennemy1.init(new Image("/src/package1/ressources/combat/gaston.gif"));
	    this.ennemy2.init(new Image("/src/package1/ressources/combat/gargouille.gif"));
	    this.ennemy3.init(new Image("/src/package1/ressources/combat/demon.gif"));
	    this.ennemy4.init(new Image("/src/package1/ressources/combat/genie.gif"));
	    this.ennemy5.init(new Image("/src/package1/ressources/combat/2tetes.gif").getScaledCopy(196,200));
	    this.ennemy6.init(new Image("/src/package1/ressources/combat/bionique.gif").getScaledCopy(196,200));
	    this.ennemy7.init(new Image("/src/package1/ressources/combat/cadavre.gif"));
	    this.ennemy8.init(new Image("/src/package1/ressources/combat/chien.png"));
	    this.ennemy9.init(new Image("/src/package1/ressources/combat/corne.gif").getScaledCopy(196,200));
	    this.ennemy10.init(new Image("/src/package1/ressources/combat/crochet.gif").getScaledCopy(196,200));
	    this.ennemy11.init(new Image("/src/package1/ressources/combat/elephant.png"));
	    this.ennemy12.init(new Image("/src/package1/ressources/combat/feu.gif"));
	    this.ennemy13.init(new Image("/src/package1/ressources/combat/larve.gif"));
	    this.ennemy14.init(new Image("/src/package1/ressources/combat/mommie.gif"));
	    this.ennemy15.init(new Image("/src/package1/ressources/combat/loup.gif"));
	    this.ennemy16.init(new Image("/src/package1/ressources/combat/pinguoin.gif"));
	    this.ennemy17.init(new Image("/src/package1/ressources/combat/ursula.gif").getScaledCopy(196,200));
	    this.ennemy18.init(new Image("/src/package1/ressources/combat/dracula.gif").getScaledCopy(196,200));
	    this.ennemy19.init(new Image("/src/package1/ressources/combat/timon.gif").getScaledCopy(196,200));
	    this.ennemy20.init(new Image("/src/package1/ressources/combat/malefique.gif").getScaledCopy(196,200));
	    this.b1.init(new Image("/src/package1/ressources/combat/james.gif").getScaledCopy(196,200));
	    this.b2.init(new Image("/src/package1/ressources/combat/ange.png").getScaledCopy(280,340));
	    this.b3.init(new Image("/src/package1/ressources/combat/assassin.png").getScaledCopy(196,240));
	    this.b4.init(new Image("/src/package1/ressources/combat/fairy.png").getScaledCopy(320,320));
	    if ((this.ID)==20){splash.getsp().setattaques(); splash.repaint();}
	    
	    if ((this.ID)==44){splash.setnot();}
	    explode=new Sound("/src/package1/ressources/music/explosion.wav");
	    music=new Music("/src/package1/ressources/music/battle.ogg"); 
	    beep=new Sound("/src/package1/ressources/music/beep.wav");
	    
	    
 
	  }
	  
	
	  
	  public void setetatcombat(int i){
		  etatcombat=i;
	  }
	  
	  
	  
	  public void monterniveau(int e){
		  jeu.getbp().setniveau(jeu.getbp().getniveau()+1);
		  jeu.getbp().setvie(jeu.getbp().getvie()+7);
		  jeu.getbp().setmanaMax(jeu.getbp().getmanaMax()+20);
		  jeu.getbp().setexperienceMax(jeu.getbp().getexperienceMax()+200);
		  jeu.getbp().setexperience(e);
		  jeu.getbp().setattaque(jeu.getbp().getattaque()+2);
		  jeu.getbp().setdefense(jeu.getbp().getdefense()+2);
		  if ((jeu.getbp().getniveau()%5)==0 && jeu.getbp().getindice()<8) jeu.getbp().setindice(jeu.getbp().getindice()+1);
	  }
	  
	  public void gagnercombat(){
		  int i;
		  jeu.getinventaire().AjoutArgent(en[ID-20].getargent());
	      jeu.getbp().setexperience(jeu.getbp().getexperience()+en[ID-20].getexp());
	      while(jeu.getbp().getexperience()>=jeu.getbp().getexperienceMax()&&jeu.getbp().getniveau()<50){
	    	  int exp=jeu.getbp().getexperience()-jeu.getbp().getexperienceMax();
	    	  monterniveau(exp);
	      }
	      if (jeu.getbp().getniveau()==50){jeu.getbp().setexperience(0);}
	      jeu.getplayer().setexperience(jeu.getbp().getexperience());
	      jeu.getplayer().setexperienceMax(jeu.getbp().getexperienceMax());
	     
	      jeu.getplayer().setniveau(jeu.getbp().getniveau());
		  jeu.getplayer().setvieMax(jeu.getbp().getvie());
		  jeu.getplayer().setmanaMax(jeu.getbp().getmanaMax());
		  jeu.getplayer().setattaque(jeu.getbp().getattaque());
		  jeu.getplayer().setdefense(jeu.getbp().getdefense());
		  playerreset();
	      for(i=0;i<en[ID-20].getnombreObj();i++)jeu.getinventaire().PlacerObjet(en[ID-20].getObjet(i), 1, jeu.getjq());
	      if(jeu.getjq().getDerniereQuete().gettype()==2){
	    	  jeu.getjq().getDerniereQuete().ValiderQuete(en[ID-20].getId(),jeu.getinventaire(),jeu.getjq());
	      }
	      if(en[ID-20].getId()>20){
		      jeu.getboss().setbattu(1);
		      if(en[ID-20].getId()==21) {jeu.getMap().setcalque(3);}
		      if(en[ID-20].getId()==22) jeu.getMap().setcalque(2);
		      if(en[ID-20].getId()==23) jeu.getMap().setcalque(1);
	      }
	  }
	  
	  public void perdrecombat(){  
		  playerreset();
		  ennemyreset();
		  if(jeu.getinventaire().getargent()-en[ID-20].getargent()*2>=0)
		  jeu.getinventaire().RetirerArgent(en[ID-20].getargent()*2);
		  else jeu.getinventaire().setargent(0);
	  }
	  
	  public void playerreset(){
		 jeu.getplayer().setvie(jeu.getplayer().getvieMax());
		 jeu.getplayer().setmana(jeu.getplayer().getmanaMax());
		 jeu.getplayer().setattaque(jeu.getplayer().getattaque()-compteuratt);
		 jeu.getplayer().setdefense(jeu.getplayer().getattaque()-compteurdef);
		 jeu.getbp().setPv(jeu.getplayer().getvie());
		 jeu.getbp().setmana(jeu.getplayer().getmana());
		 jeu.getbp().setattaque(jeu.getplayer().getattaque());
		 jeu.getbp().setdefense(jeu.getplayer().getdefense());
	  }
	  
	  public void ennemyreset(){
		  en[ID-20].setPv(en[ID-20].getviemax());
	  }
	  
	  public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		  
		  // Initialisation du background
		  
		  switch(jeu.getplayer().getzone()){
		  case 1 :
			  background.draw(0, 0, container.getWidth(), container.getHeight());
			  break;
		  case 2 :
			  background.draw(0, 0, container.getWidth(), container.getHeight());
			  break;
		  case 3 :
			  backgroundzone3.draw(0, 0, container.getWidth(), container.getHeight());
			  break;
			  
		  case 4 :
			  backgroundlave.draw(0, 0, container.getWidth(), container.getHeight());
			  break;
		  }
		  
		  if(jeu.getbp().getPv()>0 ) {this.jeu.getbp().render(container,g);}
  		  if(en[ID-20].getPv()>0 ) this.en[ID-20].render(container,g);
  		  g.drawImage(this.dialogue, P_BAR_X, P_BAR_Y);
  		
  		  // Animationscombat
  		  
  		  if (enattaque == 1){
  			  switch(pointeur){
  			  case 0 :
  				for (int iexpl = 0; iexpl<6;iexpl++){
  		  			g.drawAnimation(en[ID-20].getblizzard(iexpl), 530, 210);}
  			  	break;
  			  case 1 :
  				for (int iexpl = 0; iexpl<4;iexpl++){
  		  			g.drawAnimation(en[ID-20].getflamme(iexpl), 540, 220);}
  		  		break;
  			case 2 :
  				for (int iexpl = 0; iexpl<5;iexpl++){
  		  			g.drawAnimation(en[ID-20].getthunder(iexpl), 540, 220);}
  			  	break;
  			  case 3 :
  				for (int iexpl = 0; iexpl<5;iexpl++){
  		  			g.drawAnimation(en[ID-20].getbrise(iexpl), 520, 220);}
  		  		break;
  			case 4 :
  				for (int iexpl = 0; iexpl<3;iexpl++){
  		  			g.drawAnimation(en[ID-20].gettornado(iexpl), 530, 220);}
  			  	break;
  			  case 5 :
  				for (int iexpl = 0; iexpl<3;iexpl++){
  		  			g.drawAnimation(en[ID-20].getpluie(iexpl), 530, 210);}
  		  		break;
  			case 6 :
  				for (int iexpl = 0; iexpl<4;iexpl++){
  		  			g.drawAnimation(en[ID-20].getdeflagration(iexpl), 530, 220);}
  			  	break;
  			  case 7 :
  				for (int iexpl = 0; iexpl<4;iexpl++){
  		  			g.drawAnimation(en[ID-20].gettsunami(iexpl), 510, 220);}
  		  		break;
  			  }}
  			  else {if (enattaque == 2){
  				for (int iexpl = 0; iexpl<5;iexpl++){
  		  			g.drawAnimation(en[ID-20].getexplode(iexpl), 180, 280);}
  			  }
  		  }
  		 
  		  
  		  // Initialisation barre joueur
  		  if (jeu.getbp().getPv()>0){
  		  g.setColor(new Color(0,0,0,100));
  		  g.fillRect(50, 25, 250, 150);
  		  
  		  g.setColor(Color.white);
  		  g.drawString(jeu.getplayer().getnom() + " : Niv " + jeu.getbp().getniveau(), 75, 40);
  		  g.setColor(new Color(77,0,0));
  		  g.fillRect(75, 70, 200, 20);
  		  g.fillRect(75, 100, 200, 20);
  		  g.fillRect(75, 130, 200, 20);
  		  
  		  float life = 0f;
  		  float lmana = 0f;
  		  float lexp = 0f;
  		  while((float)jeu.getbp().getPv()/(float)jeu.getbp().getvie() > life/200f)
  		  {
  			g.setColor(new Color(255,(int)((life/200f)*255f),(int)((life/200f)*255f)));
  			g.fillRect(75+(int) life, 70, 1, 20);
  			life++;
  		  }
  		while((float)jeu.getbp().getmana()/(float)jeu.getbp().getmanaMax() > lmana/200f)
		  {
			g.setColor(new Color((int)((lmana/200f)*255f),(int)((lmana/200f)*255f),255));
			g.fillRect(75+(int) lmana, 100, 1, 20);
			lmana++;
		  }
  		while((float)jeu.getbp().getexperience()/(float)jeu.getbp().getexperienceMax() > lexp/200f)
		  {
			g.setColor(new Color((int)((lexp/200f)*255f),255,(int)((lexp/200f)*255f)));
			g.fillRect(75+(int) lexp, 130, 1, 20);
			lexp++;
		  }
  		g.setColor(Color.white);
		  g.drawString("Vie : " + jeu.getbp().getPv() + "/" + jeu.getbp().getvie(), 80, 70);
		  g.drawString("Mana : " + jeu.getbp().getmana() + "/" + jeu.getbp().getmanaMax(), 80, 100);
		  g.drawString("Exp : " + jeu.getbp().getexperience() + "/" + jeu.getbp().getexperienceMax(), 80, 130);}
  		  
  		  // Initialisation barre en[ID-20]
		  if(en[ID-20].getPv()>0){
  		 g.setColor(new Color(0,0,0,100));
 		  g.fillRect(550, 50, 200, 100);
 		  
 		  g.setColor(Color.white);
 		  g.drawString(en[ID-20].getnom() + " : Niv " + en[ID-20].getniveau(), 575, 70);
 		  g.setColor(new Color(77,0,0));
 		  g.fillRect(575, 100, 150, 20);
 		  float elife = 0f;
 		  while((float)en[ID-20].getPv()/(float)en[ID-20].getviemax() > elife/150f)
 		  {
 			g.setColor(new Color(255,(int)((elife/150f)*255f),(int)((elife/150f)*255f)));
 			g.fillRect(575+(int) elife, 100, 1, 20);
 			elife++;
 		  }
 		  g.setColor(Color.white);
 		 g.drawString("Vie : " + en[ID-20].getPv()+ "/" + en[ID-20].getviemax(), 575,100);}
		  
  		  // Phases de combat
 		  
  		  g.setColor(Color.white);
  		  switch(etatcombat){
  		  case 0 : // Etat initial
  			
  			  g.drawString("Attaquer", P_BAR_X+25, P_BAR_Y+25);
  			  g.drawString("Utiliser un objet", P_BAR_X+25, P_BAR_Y+50);
  			  g.drawString("Fuir", P_BAR_X+25, P_BAR_Y+75);
  			g.setColor(new Color(0,0,255,100));
  			g.fillRect(P_BAR_X+25,(P_BAR_Y+(pointeur+1-Math.max(0, pointeur-3))*25), 200, 20);
  			  
  			  
  			  break;
  			  
  		  case 1 : // Etat Attaquer
  			  	int i;
  			  for(i=0; i<pointeur; i++){
  				if (i<pointeur-3){}else
  				  {g.drawString(jeu.getbp().getAttaque(i).getnomAttaque(), P_BAR_X+25, (P_BAR_Y+(i+1-Math.max(0, pointeur-3))*25));}
  			  }
  			  g.setColor(new Color(0,0,255,100));
  		    	g.fillRect(P_BAR_X+25,(P_BAR_Y+(i+1-Math.max(0, pointeur-3))*25), 200, 20);
  		    	g.setColor(Color.white);
  		    	Attaque att = jeu.getbp().getAttaque(i);
  		    	g.drawString(att.getnomAttaque(), 400, P_BAR_Y+20);
  		    	g.drawString("Puissance : " + att.getpuissanceAttaque(), 400, P_BAR_Y+40);
  		    	g.drawString("Mana requis : " + att.getmanaRequis(), 400, P_BAR_Y+60);
  		    	
  		    	for(i=pointeur; i<jeu.getbp().getindice(); i++){
  					  g.drawString(jeu.getbp().getAttaque(i).getnomAttaque(), P_BAR_X+25, (P_BAR_Y+(i+1-Math.max(0, pointeur-3))*25));
  				  }
  		    	
  		    	break;
  			  
  		  case 2 : // Etat UtiliserObjet
  			  int i2 = 0;
  			  int j2 = 0;
  			  if(jeu.getinventaire().NombreUtilisablePresent()>0){
  			    	while(j2<pointeur && j2< jeu.getinventaire().NombreUtilisablePresent()){
  			    		if (jeu.getinventaire().getObjet(i2)!=null)
  			    		{if(jeu.getinventaire().getquantiteObjet(jeu.getinventaire().getObjet(i2).getidObjet())>0 && i2<20){
  			    			if (j2<pointeur-3){}else
  			    			{g.drawString(jeu.getinventaire().getObjet(i2).getnomObjet(), P_BAR_X+25, (P_BAR_Y+(j2+1-Math.max(0, pointeur-3))*25));}
  			    			j2++;
  			    		}}
  			    		i2++;
  			    	}
  			    	
  			    g.setColor(new Color(0,0,255,100));
  		    	g.fillRect(P_BAR_X+25,(P_BAR_Y+(j2+1-Math.max(0, pointeur-3))*25), 200, 20);
  		    	
  		    	g.setColor(Color.white);
  		    	ObjetUtilisable util = jeu.getinventaire().getUtilisablePresent(j2);
  		    	int id = util.getidObjet();
  		    	g.drawString(jeu.getinventaire().getObjetPresent(j2).getnomObjet(), 400, P_BAR_Y+20);
  		    	g.drawString("Quantite possedee : " + jeu.getinventaire().getquantiteObjet(id), 400, P_BAR_Y+40);
  		    	g.drawString("Valeur : " + util.getvaleur(), 400, P_BAR_Y+60);
      			if (id<5) g.drawString("Montant vie : " + (util).getmontantVie() , 400, P_BAR_Y+80);
      			if (id>=5 && id<10) g.drawString("Montant mana : " + (util).getmontantMana() , 400, P_BAR_Y+80);
      			if (id>=10 && id<15) g.drawString("Montant attaque : " + ( util).getmontantAttaque() , 400, P_BAR_Y+80);
      			if (id>=15 && id<20) g.drawString("Montant defense : " + ( util).getmontantDefense() , 400, P_BAR_Y+80);
  		    	
      			while(j2< jeu.getinventaire().NombreUtilisablePresent()){
      	    		if (jeu.getinventaire().getObjet(i2)!=null)
      	    		{if(jeu.getinventaire().getquantiteObjet(jeu.getinventaire().getObjet(i2).getidObjet())>0 && i2<20){
      	    			g.drawString(jeu.getinventaire().getObjet(i2).getnomObjet(), P_BAR_X+25, (P_BAR_Y+(j2+1-Math.max(0, pointeur-3))*25));
      	    			j2++;
      	    		}}
      	    		i2++;
      		  
      	    	}
      	    }else{
      	    	g.drawString("Aucun objet dans l'inventaire", P_BAR_X+25, P_BAR_Y+25);
      	    }
  			  break;
  			  
  		  case 3 : // Etat infliger
  			 
  			 if (coupcritique == false) {
  			  g.drawString("Vous infligez : "  + degat + " points de degat", P_BAR_X+25, P_BAR_Y+25);}
  			 else {
  				 g.drawString("Coup critique !!!" , P_BAR_X+25, P_BAR_Y+25);
  				 g.drawString("Vous infligez : "  + degat + " points de degat", P_BAR_X+25, P_BAR_Y+50);
  			 }
  			  break;
  		
  		  case 4 : // Etat recevoir
  			  g.setColor(Color.white);
  			if (coupcritique == false) {
    			  g.drawString("Vous recevez : "  + degat + " points de degat", P_BAR_X+25, P_BAR_Y+25);}
    			 else {
    				 g.drawString("Coup critique !!!" , P_BAR_X+25, P_BAR_Y+25);
    				 g.drawString("Vous recevez : "  + degat + " points de degat", P_BAR_X+25, P_BAR_Y+50);
    			 }
    			  break;
  			  
  		  case 5 : // Etat gagner
  			  g.drawString("Felicitation vous avez gagné !", P_BAR_X+25, P_BAR_Y+20);
  			  g.drawString("Vous gagnez : " + en[ID-20].getargent() + " pieces d'or", P_BAR_X+25, P_BAR_Y+40);
  			  g.drawString("Vous gagnez : " + en[ID-20].getexp() + " points d'experience",P_BAR_X+25, P_BAR_Y+60);
  			  int xpen = en[ID-20].getexp();
  			  int expl = jeu.getbp().getexperience();
  			  int expm = jeu.getbp().getexperienceMax();
  			  int iniv = 0;
  			  while(expm<=xpen+expl && (jeu.getbp().getniveau()+iniv<50)){
  				  xpen = xpen - (expm-expl);
  				  expl = 0;
  				  expm = expm+200;
  				  iniv++;
  			  }
  			  int montantniveau = jeu.getbp().getniveau()+iniv;
  			  if (iniv>0) g.drawString("Vous montez au niveau : " + montantniveau + " !", P_BAR_X+25, P_BAR_Y+80);
  			  iniv = 0;
  			  break;
  			  
  		case 6 : // Etat gagner objets
  			g.drawString("Vous recevez : ", P_BAR_X+25, P_BAR_Y+20);
  			for(int i6=0;i6<en[ID-20].getnombreObj();i6++){
  				g.drawString(jeu.getinventaire().getObjet(en[ID-20].getObjet(i6)).getnomObjet() + " x1 ", P_BAR_X+25, P_BAR_Y+5+(20*(i6+2)));
  			}
  			break;
  			
  		case 7 : // Etat perdre
  			 g.drawString("Vous etes mort !", P_BAR_X+25, P_BAR_Y+25);
  			 g.drawString("Vous perdez : " + Math.min(2*en[ID-20].getargent(),jeu.getinventaire().getargent()) + " pieces d'or ",P_BAR_X+25, P_BAR_Y+50);
  			 break;
  			 
  		case 8 : // Etat fuir
  			g.drawString("Vous prenez la fuite !", P_BAR_X+25, P_BAR_Y+25);
  			break;
  			
  		case 9 : // utilisation d'objet
  			switch(choixp){
  			case 0 :
  				g.drawString("Vous vous soignez de : " + montpotion + " points de vie !", P_BAR_X+25, P_BAR_Y+25);
  				break;
  			case 1 :
  				g.drawString("Vous regagnez : " + montpotion + " points de mana !", P_BAR_X+25, P_BAR_Y+25);
  				break;
  			case 2 :
  				g.drawString("Votre attaque augmente de : " + montpotion + " !", P_BAR_X+25, P_BAR_Y+25);
  				break;
  			case 3 :
  				g.drawString("Votre defense augmente de : " + montpotion + " !", P_BAR_X+25, P_BAR_Y+25);
  				break;
  			}
  			
  			break;
  	 
  		  }
  		  
  		  
  	  }
 
	  
	  public int getID() {
	    return ID;
	  }
	  
	  public void keyPressed(int key, char c) {
		  switch (key) {
		  
		  case Input.KEY_DOWN:
			  switch(etatcombat){
			  case 0 :
				  beep.play();
				  if (pointeur==2){pointeur = 0;} else {pointeur++;}
				  break;
			  case 1 :
				  beep.play();
				  if (pointeur==jeu.getbp().getindice()-1){pointeur = 0;} else {pointeur++;}
				  break;
			  case 2 :
				  beep.play();
				  if (pointeur==jeu.getinventaire().NombreUtilisablePresent()-1){pointeur = 0;} else pointeur++;
				  break;
			  }
			break;
			  
		  case Input.KEY_UP :
			  switch(etatcombat){
			  case 0 :
				  beep.play();
				  if (pointeur==0){pointeur = 2;} else {pointeur--;}
				  break;
			  case 1 :
				  beep.play();
				  if (pointeur==0){pointeur = jeu.getbp().getindice()-1;} else pointeur--;
				  break;
			  case 2 :
				  beep.play();
				  if (pointeur==0){pointeur = jeu.getinventaire().NombreUtilisablePresent()-1;} else pointeur--;
				  break;
			  }
			break;
			  
		  case Input.KEY_ESCAPE:
			  switch(etatcombat){
			  case 1 :
				  beep.play();
				  pointeur = 0;
				  etatcombat = 0;
				  break;
				  
			  case 2 :
				  beep.play();
				  pointeur = 0;
				  etatcombat = 0;
				  break;
			  }
		  break;
			  
		  case Input.KEY_ENTER:
			  switch(etatcombat){
			  case 0 :
				  beep.play();
				 recevoir = 0;
				  switch(pointeur){
				  case 0 :					  
					  etatcombat = 1;
					  break;
				  case 1 :					  
					  etatcombat = 2;
					  break;
				  case 2 :
					  if(en[ID-20].getId()<21) {etatcombat = 8;}
						  break;
					  
				  }
				  break;
			  case 1 :
				  if (ok==0){beep.play();ok=1;
				  if(jeu.getbp().getAttaque(pointeur).getmanaRequis()<=jeu.getbp().getmana()){
					  int playerAttack = (int) (0.7*(jeu.getplayer().getattaque())+ 0.3*(jeu.getbp().getAttaque(pointeur).getpuissanceAttaque()));  
					    if (random.nextDouble() < .5) { 
					      playerAttack += playerAttack / 2;
					      coupcritique = true;
					    }
					    degat = playerAttack;
					 
					    etatcombat = 10;
					    jeu.getbp().animebarre();
					    elapsedtime = 0;
					    manarestant = jeu.getbp().getAttaque(pointeur).getmanaRequis();
					    myturn = 2;
					    
					    jeu.getbp().getfictive().addListener(2000, new AnimationListener(){
					    	public void on(){
					    		if (recevoir == 0){
					    		jeu.getbp().startAttack() ;recevoir = 1;}
					    		
					    	}
					    });
					    
					    jeu.getbp().getanimation().addListener(800, new AnimationListener(){
							public void on() {	
								explode.play(1,0.2f);
								enattaque=1;
							}  
					    });
					    
					    jeu.getbp().getanimation().addListener(1500, new AnimationListener(){			
							public void on() {		
								pointeur = 0;
								enattaque=0;
							}  	
					    });
					    jeu.getbp().getanimation().addListener(2000, new AnimationListener(){
					        public void on() {
					        	if (recevoir == 1)
					        	 { jeu.getbp().animebarre();
								    elapsedtime = 0;
					  				degatrestant = degat;
					  				degatrestantaux = degat;
					  				myturn = 3;}
					        	recevoir = 2;
					        }
					    });
					    
					   
					   
					    jeu.getbp().getfictive().addListener(2000, new AnimationListener(){
					    	public void on(){
					    		if (recevoir == 2)
					    		{	
					    			etatcombat = 3; ok=0; recevoir = 3;}
					    	}
					    });
					    
			        	 }
				  
				  
				  }
				  break;
				  
			  case 2 :
				  beep.play();
				  if (jeu.getinventaire().NombreUtilisablePresent()>0){
				  ObjetUtilisable util = jeu.getinventaire().getUtilisablePresent(pointeur);
				  int idutil = util.getidObjet();
				  if(idutil<5){	 recevoir = 10;
					  			montpotion = Math.min(util.getmontantVie(),jeu.getbp().getvie()-jeu.getbp().getPv());
					  			jeu.getinventaire().RetirerObjet(idutil, 1, jeu.getjq()); choixp = 0;
				  				etatcombat = 10;
				  				jeu.getbp().animebarre();
				  				elapsedtime=0;
				  				montantpotionrestant = montpotion;
				  				montantpotionaux = montpotion;
				  				myturn=4;
				  				 jeu.getbp().getfictive().addListener(2000, new AnimationListener(){
								    	public void on(){
								    		if (recevoir == 10)
								    		{etatcombat = 9;  recevoir = 4;}
								    	}
								    });
				  				}
				  if(idutil>=5 && idutil<10){  recevoir = 11;
					  		montpotion = Math.min(util.getmontantMana(),jeu.getbp().getmanaMax()-jeu.getbp().getmana());
					  		jeu.getinventaire().RetirerObjet(idutil, 1, jeu.getjq()); choixp = 1; 
	  						etatcombat = 10;
			  				jeu.getbp().animebarre();
			  				elapsedtime=0;
			  				manaprestant = montpotion;
			  				myturn=5;
			  				jeu.getbp().getfictive().addListener(2000, new AnimationListener(){
							    	public void on(){
							    		if (recevoir == 11)
							    		{etatcombat = 9;  recevoir = 4;}
							    	}
							    });
	  						}
				  if(idutil>=10 && idutil<15){jeu.getbp().setattaque(jeu.getbp().getattaque()+util.getmontantAttaque());
				  			compteuratt = compteuratt + util.getmontantAttaque();
				  			jeu.getinventaire().RetirerObjet(idutil, 1, jeu.getjq()); choixp = 2; montpotion = util.getmontantAttaque();
	  						etatcombat = 9;}
				  if(idutil>=15 && idutil<20){jeu.getbp().setdefense(jeu.getbp().getdefense()+util.getmontantDefense());
				  			compteurdef = compteurdef + util.getmontantDefense();
				  			jeu.getinventaire().RetirerObjet(idutil, 1, jeu.getjq()); choixp = 3; montpotion = util.getmontantDefense();
	  						etatcombat = 9;}
				 
				  
			
				  }
				  else{
				  etatcombat = 0;}
				  pointeur = 0;
				  
				  break;
				  
			  case 3 :
				  if (ok==0){beep.play();ok=1;
				  	coupcritique = false;
				    if (en[ID-20].getPv() <= 0) {ok=0;
				    	etatcombat = 5;}
				    else { int ennemyAttack =(int) (en[ID-20].getattaque()-(0.1*jeu.getbp().getdefense()));
				      if (random.nextDouble() < .5) { 
					      ennemyAttack += ennemyAttack / 2; 
					      coupcritique = true;
					    }
				      degat = ennemyAttack;
				      etatcombat = 10;
		  				en[ID-20].startAttack();
		  				
		  				 en[ID-20].getanimation().addListener(800, new AnimationListener(){
								public void on() {	
									explode.play(1,0.2f);
									enattaque=2;
								}    	
						    });
						    en[ID-20].getanimation().addListener(1500, new AnimationListener(){			
								public void on() {					
									enattaque=0;
								}  	
						    });
		  				en[ID-20].getanimation().addListener(2000, new AnimationListener(){
					        public void on() {
					        	if (recevoir==3)
					        	{	jeu.getbp().animebarre();
					        	elapsedtime = 0;
				  				degatrestant = degat;
				  				degatrestantaux = degat;
				  				myturn = 1;
					        	recevoir = 4;
					        	}
					        }});
		  				
		  				jeu.getbp().getfictive().addListener(2000, new AnimationListener(){
					    	public void on(){
					    		if (recevoir ==4)
					    		{	 
					    			etatcombat = 4; ok=0; recevoir = 5;}
					    	}
					    });
		  				
		  				
		  				}}
				  break;
			  case 4 :
				  beep.play();
				  coupcritique = false;
				  degat = 0;
				  if (jeu.getbp().getPv() <= 0) { etatcombat = 7;}
				  else { etatcombat = 0; }
				  break;
				  
			  case 5 :
				  beep.play();
				  degat = 0;
				  gagnercombat();
				  etatcombat = 6;
				  break;
			  case 6 : 
				  beep.play();
				  
				  changetat = true;
				  ennemyreset();
					 pointeur = 0;
					  choixp = 0;
					  degat = 0;
					  montpotion = 0;
					  music.stop();
					  jeu.setswitchzone(0);
					  jeu.setbossencounter(false);
				  game.enterState(jeu.ID, new FadeOutTransition(Color.black,1000), new FadeInTransition(Color.black,1000));
				  break;
			  case 7 :
				  beep.play();
				 
				  changetat = true;
				  perdrecombat();
					 pointeur = 0;
					  choixp = 0;
					  degat = 0;
					  montpotion = 0;
			    	  jeu.getboss().setbattu(2);
			    	  music.stop();
			    	  jeu.setswitchzone(0);
			    	  jeu.setbossencounter(false);
			    	  game.enterState(jeu.ID, new FadeOutTransition(Color.black,1000), new FadeInTransition(Color.black,1000));
				  break;
			  case 8 :
				  beep.play();
				  pointeur = 0;
				  choixp = 0;
				  degat = 0;
				  montpotion = 0;
				  changetat = true;
				  playerreset();
				  ennemyreset();
				  music.stop();
				  jeu.setswitchzone(0);
				  game.enterState(jeu.ID, new FadeOutTransition(Color.black,1000), new FadeInTransition(Color.black,1000));
				  break;
			 
			  case 9 :
				  beep.play();
				  montpotion = 0;
				  pointeur = 0;
				  if (ok==0){ok=1;
				  	coupcritique = false;
				    if (en[ID-20].getPv() <= 0) {ok=0;
				    	etatcombat = 5;}
				    else { int ennemyAttack =(int) (en[ID-20].getattaque()-(0.1*jeu.getbp().getdefense()));
				      if (random.nextDouble() < .5) { 
					      ennemyAttack += ennemyAttack / 2; 
					      coupcritique = true;
					    }
				      degat = ennemyAttack;
		  				etatcombat = 10;
		  				en[ID-20].startAttack();
		  				en[ID-20].getanimation().addListener(800, new AnimationListener(){
							public void on() {	
								explode.play(1,0.2f);
								enattaque=2;
							}    	
					    });
					    en[ID-20].getanimation().addListener(1500, new AnimationListener(){			
							public void on() {					
								enattaque=0;
							}  	
					    });
		  				
		  				en[ID-20].getanimation().addListener(2000, new AnimationListener(){
					        public void on() {
					        	if (recevoir != 5)
					          { jeu.getbp().animebarre();
					        	elapsedtime = 0;
				  				degatrestant = degat;
				  				degatrestantaux = degat;
				  				myturn = 1;recevoir = 5;}
					        }});
		  				
		  				jeu.getbp().getfictive().addListener(2000, new AnimationListener(){
					    	public void on(){
					    		if (recevoir ==5)
					    		{	
					    			etatcombat = 4; ok=0; recevoir = 6;}
					    	}
					    });
		  				
		  				}}
				  break;
				  
			  case 10 :
				  break;
			  }
		  break;
	  		}	  
		  }  	
	  
	  public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
		  jeu.getbp().update(delta);
		  en[ID-20].update(delta);
		  
		  
		  if (changetat==true){etatcombat=0; changetat=false;}
		  
		  if (tour>(int)(500/(degatrestant+1))){tour=0;}
		  if (tourvie > (int)(500/(montantpotionrestant+1))){tourvie=0;}
		  if (tourmana == 1){tourmana=0;}
		  switch (myturn){
		  case 1 :
			  if (elapsedtime < 2000 && degatrestantaux > 0){
				  elapsedtime = elapsedtime+delta;
				  System.out.println(delta);
				  System.out.println(elapsedtime);
				  if (tour == 0)  {  System.out.println("point de vie enlevé");jeu.getbp().setPv(jeu.getbp().getPv()-1);degatrestantaux = degatrestantaux-1;}
				  tour=tour+delta;
			  } 
			  break;
			  
		  case 2:
			  if (elapsedtime < 2000 && manarestant> 0){
				  elapsedtime = elapsedtime+delta;
				  if (tourmana == 0)  {  jeu.getbp().setmana(jeu.getbp().getmana()-1);manarestant = manarestant-1;}
				  tourmana++;
			  }
			  break;
			  
		  case 3 :
			  if (elapsedtime < 2000 && degatrestantaux > 0){
				  elapsedtime = elapsedtime+delta;
				  if (tour == 0)  {  en[ID-20].setPv(en[ID-20].getPv()-1);degatrestantaux = degatrestantaux-1;}
				  tour=tour+delta;
			  }
			  break;
			  
		  case 4 :
			  if (elapsedtime < 2000 && montantpotionaux  > 0){
				  elapsedtime = elapsedtime+delta;
				  if (tourvie == 0)  { 
					  jeu.getbp().setPv(jeu.getbp().getPv()+1);montantpotionaux = montantpotionaux-1;}
				  tourvie = tourvie + delta;
			  }
			  break;
			  
		  case 5 :
			  if (elapsedtime < 2000 && manaprestant> 0){
				  elapsedtime = elapsedtime+delta;
				  if (tourmana == 0)  {  jeu.getbp().setmana(jeu.getbp().getmana()+1);manaprestant = manaprestant-1;}
				  tourmana++;
			  }
			  break;
		  }
	}
	  
		
}
