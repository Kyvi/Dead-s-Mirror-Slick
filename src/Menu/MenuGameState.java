package Menu;

import java.text.SimpleDateFormat;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import package1.Equipement;
import package1.Jeu;
import package1.Joueur;

public class MenuGameState  extends BasicGameState {

	  public static final int ID = 4;
	  private Image background;
	  private Image carte;
	  private StateBasedGame game;
	  private String menu[] = {"Carte","Inventaire","Journal de quête","Equipement","Caractéristiques","Quitter le jeu"};
	  private int pointeur;
	  private boolean affichercarte=false;
	  private int up=0;
	  private Jeu jeu;
	  private Long seconde;
	  private Long minute;
	  private Long heure;
	  private String afseconde;
	  private String afminute;
	  private String afheure;
	  private Sound beep;
	  
	  
	  
	  public MenuGameState(Jeu j){
			 jeu=j;
		 }

	 
	  public void init(GameContainer container, StateBasedGame game) throws SlickException {
	    this.game = game;
	    this.background = new Image("/src/package1/ressources/background/menu.png");
	    this.carte = new Image("/src/package1/ressources/map/carte_jeu.png");
	    beep=new Sound("/src/package1/ressources/music/beep.wav");
	    pointeur = 1-jeu.getinventaire().getquantiteObjet(43);
	  }

	  
	  public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		 g.setColor(Color.red);
		 if (affichercarte) {carte.draw(0,0, container.getWidth(), container.getHeight());
		 int abs = (int)((((float)container.getWidth())*(jeu.getplayer().getX()-1001))/4750f);
		 int ord = (int)((((float)container.getHeight())*(jeu.getplayer().getY()-940))/4470f);
		 	if (up<600){
		 		g.fillOval(abs, ord, 10, 10);
		 		
		 	}
		 }
		 else { g.setColor(Color.black);
			 background.draw(0, 0, container.getWidth(), container.getHeight());
		 
		 Long mili = java.lang.System.currentTimeMillis()-jeu.getdebut();
		 heure = mili/3600000;
		 minute = (mili - heure*3600000)/60000;
		 seconde = (mili - heure*3600000 - minute*60000)/1000;
		 
		 if (heure < 10) {afheure = "0"+Long.toString(heure);} else {afheure = Long.toString(heure);}
		 if (minute < 10) {afminute = "0"+Long.toString(minute);} else {afminute = Long.toString(minute);}
		 if (seconde < 10) {afseconde = "0"+Long.toString(seconde);} else {afseconde = Long.toString(seconde);}
		 g.drawString("Duree de jeu : " + afheure +":" + afminute + ":" + afseconde , 500, 100);
		 
		    g.drawString("Menu", 100, 25);
		    
		    
		   for(int i=(1-jeu.getinventaire().getquantiteObjet(43));i<pointeur;i++){
				   g.drawString(menu[i],100,100+(i*50));
		   }
		   
		   g.setColor(new Color(0,0,255,100));
	   		g.fillRect(100,100+(pointeur*50), 200, 20);
	   		
	   		g.setColor(Color.black);
	   		for(int i=pointeur;i<6;i++){
	   				g.drawString(menu[i],100,100+(i*50));  
	 	   }}
	   		
	    
	  }

	 
	  public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
		  if (up<600){
			  up = up + delta;
		  } else { 
			  if (up<1200){
				  up = up+delta;
			  }
			  else up = 0;
				  
		  }
	  }

	 
	  public void keyPressed(int key, char c) {
		  switch (key) {
		  case Input.KEY_UP:
			  if (!affichercarte)
			  { beep.play();
			  switch (jeu.getinventaire().getquantiteObjet(43)){
			  case 0 :
				  if (pointeur==1) { pointeur = 5;}
				  else { pointeur = pointeur - 1;}
				  break;
			  case 1 :
				  if (pointeur==0) { pointeur = 5;}
				  else { pointeur = pointeur - 1;}
			  break;
		  }
			  }
			  
			 
		    
		    break;
		  case Input.KEY_LEFT:
		    
		    break;
		  case Input.KEY_DOWN:
			  if (!affichercarte)
			  { beep.play();
			  switch (jeu.getinventaire().getquantiteObjet(43)){
			  case 0 :
				  if (pointeur==5) { pointeur = 1;}
				  else { pointeur = pointeur + 1;}
				  break;
			  case 1 :
				  if (pointeur==5) { pointeur = 0;}
				  else { pointeur = pointeur + 1;}
			  break;
		  }
			  }
			  
		   
		    break;
		  case Input.KEY_RIGHT:
		   
		    break;
		  case Input.KEY_ENTER:
			  if (!affichercarte){
			  beep.play();}
			 switch (pointeur){
			 case 0 :
				 affichercarte=true;
				 break;
			 
			 case 1 : 
				 game.enterState(InventaireGameState.ID);
				break;
				
			 case 2 : 
				 game.enterState(JournalGameState.ID);
					break;
					
			 case 3 : 
				 game.enterState(EquipementGameState.ID);
					break;
			
			 case 4 : 
				 game.enterState(CaracteristiqueGameState.ID);
				 break;
				 
			 case 5 : 
				 System.exit(0);
				 break;
				 
				 
			 }
			 
			 break;
			 case Input.KEY_ESCAPE:
				 if (!affichercarte)
				 { beep.play();
				 game.enterState(Jeu.ID);
				 break;}
				 else {affichercarte = false;}
			 
		  }
	  }
	  
	  public void keyReleased(int key, char c) {
	   
	  }

	  public int getID() {
	    return ID;
	  }

	
}
