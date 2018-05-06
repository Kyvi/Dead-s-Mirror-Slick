package Menu;

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

public class CaracteristiqueGameState extends BasicGameState {

	  public static final int ID = 8;
	  private Image background;
	  private StateBasedGame game;
	  private Jeu jeu;
	  private Joueur player;
	  private Sound beep;
	  
	  
	  public CaracteristiqueGameState(Jeu j,Joueur jo){
			 jeu=j;
			 player=jo;
		 }

	  @Override
	  public void init(GameContainer container, StateBasedGame game) throws SlickException {
	    this.game = game;
	    this.background = new Image("/src/package1/ressources/background/menu.png");
	    beep=new Sound("/src/package1/ressources/music/beep.wav");
	  }

	  
	  @Override
	  public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
	    background.draw(0, 0, container.getWidth(), container.getHeight());
	  
	    g.setColor(Color.black);
	    g.drawString("Caracteristiques", 100, 25);
	    g.drawString(player.getnom(),200,75);
	    if(jeu.getbp().gettype()==0){ g.drawString("Magicien",400 , 75);}
	    else{g.drawString("Guerrier",400 , 75);}
	    g.drawString("Niveau : " + Integer.toString(player.getniveau()),200,125);
	    g.drawString("Experience : " + Integer.toString(player.getexperience()) + "/" + Integer.toString(player.getexperienceMax()),200,150);
	    g.drawString("Vie : " + Integer.toString(player.getvieMax()),200,175);
	    g.drawString("Mana : " + Integer.toString(player.getmanaMax()),200,200);
	    g.drawString("Attaque : " + Integer.toString(player.getattaque()),200,225);
	    g.drawString("Defense : " + Integer.toString(player.getdefense()),200,250);
	    
	    g.drawString(player.getMetier().getnom(), 200, 300);
	    g.drawString("Niveau : " + Integer.toString(player.getMetier().getniveauMetier()),200,325);
	    g.drawString("Experience : " + Integer.toString(player.getMetier().getexperienceMetier()) + "/" + Integer.toString(player.getMetier().getexperienceMaxMetier()),200,350);
	    
	    	
	  }

	 
	  public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
	  }

	 
	  public void keyPressed(int key, char c) {
		  switch (key) {
		  case Input.KEY_UP:
		    
		    break;
		  case Input.KEY_LEFT:
		    
		    break;
		  case Input.KEY_DOWN:
			
		    break;
		  case Input.KEY_RIGHT:
		   
		    break;
		  case Input.KEY_ENTER:
	
		  break;
		  
		  case Input.KEY_ESCAPE:
			  		beep.play();
				  game.enterState(MenuGameState.ID);
			  break;
		  
		  }
	  }
	  
	  public void keyReleased(int key, char c) {
	   
	  }

	  
	  @Override
	  public int getID() {
	    return ID;
	  }

	

 

}
