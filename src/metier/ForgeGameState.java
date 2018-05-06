package metier;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import package1.Jeu;

import Menu.Inventaire;
import Menu.JournalQuete;
import Menu.Objet;
import Menu.ObjetUtilisable;
import metier.Forge;

public class ForgeGameState extends BasicGameState {

	  public static int ID=12;
	  private Image background;
	  private StateBasedGame game;
	  
	  private int pointeur = 0;
	  
	  private Jeu jeu;
	  private Forge forge;
	 
	  
	  
	  
	public ForgeGameState(Jeu j, Forge fo){
		 jeu=j;	
		 forge = fo;
	 }
	
	public int getPointeur(){
		return pointeur;
	}

	  @Override
	  public void init(GameContainer container, StateBasedGame game) throws SlickException {
	    this.game = game;
	    this.background = new Image("/src/package1/ressources/background/menu.png");
	  }

	  
	  @Override
	  public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
	    background.draw(0, 0, container.getWidth(), container.getHeight());
	    g.setColor(Color.black);
	    
	    g.drawString("Forge", 100, 25);
	    g.drawString("Niveau requis " + forge.getnivreq(pointeur), 500, 75);
	    g.drawString("Objets requis :", 500, 125);
	    g.drawString(forge.gettabcreation(pointeur, 0).getnomObjet(), 500, 150);
	    g.drawString(forge.gettabcreation(pointeur, 1).getnomObjet(), 500, 175);
	    g.drawString("Experience acquise : " + forge.getExp(pointeur), 500, 250);
	    
	    		
	    	    int j = 0;
	    	    	while(j<pointeur && j< forge.getnc()){ 	    	
	    	    			g.drawString(forge.getObjetcree(j).getnomObjet(), 100, (j+3-Math.max(0, pointeur-18))*25);
	    	    			j++;
	    	    		}
	    	    		
	    	    	
	    	    	
	    	    	g.setColor(new Color(0,0,255,100));
	    	    	g.fillRect(100,(j+3-Math.max(0, pointeur-18))*25, 200, 20);
	    	    	g.setColor(Color.black);
	    	    	
	    	    	
	    	    	
	    	    	
	    	    	while(j< forge.getnc()){
	    	    		g.drawString(forge.getObjetcree(j).getnomObjet(), 100, (j+3-Math.max(0, pointeur-18))*25);
    	    			j++;
	    	    	}
 
	   
	   
	  }

	 
	  @Override
	  public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
	  }

	 
	  public void keyPressed(int key, char c) {
		  switch (key) {
		  case Input.KEY_UP:
			  
	  
					  if(pointeur == 0){ pointeur = forge.getnc()-1;}
					  else { pointeur = pointeur - 1;}
					  

		    break;
		  case Input.KEY_LEFT:

			  
			
			  
			  
			  break;
		    
		    
		  case Input.KEY_DOWN:

					  if(pointeur == forge.getnc()-1){ pointeur = 0;}
					  else { pointeur = pointeur + 1;}
					 
			 
			  
		   
		    break;
		    
		  case Input.KEY_RIGHT:
		  
			  break;
		  
		  case Input.KEY_ENTER:
			  	forge.seti(pointeur);
		  		game.enterState(Jeu.ID);

			  
		  break;
		  
		  case Input.KEY_ESCAPE:
			 
			  forge.seti(-1);
			  game.enterState(Jeu.ID);
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
