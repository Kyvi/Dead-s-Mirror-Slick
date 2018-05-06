package package1;

import java.awt.Font;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.ComponentListener;
import org.newdawn.slick.gui.MouseOverArea;
import org.newdawn.slick.gui.TextField;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

import Graphisme.Dialogue;
import Menu.Inventaire;
import Menu.JournalQuete;
import Menu.ObjetUtilisable;
import Non_Combattant.Marchand;

public class PseudoGameState extends BasicGameState implements ComponentListener {

	  public static int ID=13;
	  private Image background;
	  private StateBasedGame game;
	  
	  
	  private Jeu jeu;
	  private Joueur player;
	  
	  private MouseOverArea femme;
	  private MouseOverArea homme;
	  private MouseOverArea magicien;
	  private MouseOverArea guerrier;
	  private TextField pseudotf;
	  private MouseOverArea monde;
	  private TrueTypeFont font;
	  private boolean antiAlias = true;
	  private int sexe = 0;
	  private int type = 0;
	  private Animation[] animationsh = new Animation[8];
	  private Animation[] animationsf = new Animation[8];
	  private Sound enter;
	  private Sound beep;
	  
	 
	  
	public PseudoGameState(Jeu j,Joueur jou){
		 jeu=j;
		 player = jou;
	 }

	  @Override
	  public void init(GameContainer container, StateBasedGame game) throws SlickException {
		  SpriteSheet shomme = new SpriteSheet("src/package1/ressources/personnages/spritehomme.png", 32, 48);
		    SpriteSheet sfemme = new SpriteSheet("src/package1/ressources/personnages/spritefille.png", 32, 48);
		    this.animationsh[0] = loadAnimation(shomme, 0, 1, 3);
		    this.animationsh[1] = loadAnimation(shomme, 0, 1, 1);
		    this.animationsh[2] = loadAnimation(shomme, 0, 1, 0);
		    this.animationsh[3] = loadAnimation(shomme, 0, 1, 2);
		    this.animationsh[4] = loadAnimation(shomme, 1, 4, 3);
		    this.animationsh[5] = loadAnimation(shomme, 1, 4, 1);
		    this.animationsh[6] = loadAnimation(shomme, 1, 4, 0);
		    this.animationsh[7] = loadAnimation(shomme, 1, 4, 2);
		    this.animationsf[0] = loadAnimation(sfemme, 0, 1, 3);
		    this.animationsf[1] = loadAnimation(sfemme, 0, 1, 1);
		    this.animationsf[2] = loadAnimation(sfemme, 0, 1, 0);
		    this.animationsf[3] = loadAnimation(sfemme, 0, 1, 2);
		    this.animationsf[4] = loadAnimation(sfemme, 1, 4, 3);
		    this.animationsf[5] = loadAnimation(sfemme, 1, 4, 1);
		    this.animationsf[6] = loadAnimation(sfemme, 1, 4, 0);
		    this.animationsf[7] = loadAnimation(sfemme, 1, 4, 2);
	    this.game = game;
	    this.background = new Image("/src/package1/ressources/background/menu.png");
	    Image buttonImage = new Image("/src/package1/ressources/hud/newgame.png").getScaledCopy(100, 50);
	    homme = new MouseOverArea(container, buttonImage, 225, 100, this);
	    femme = new MouseOverArea(container, buttonImage, 425, 100, this);
	    magicien = new MouseOverArea(container, buttonImage, 225, 250, this);
	    guerrier = new MouseOverArea(container, buttonImage, 425, 250, this);
	    Font awtFont = new Font("Times New Roman", Font.PLAIN, 16);
        font = new TrueTypeFont(awtFont, antiAlias);
	    pseudotf = new TextField(container, font, 225, 400, 100, 30, this);
	    pseudotf.setBackgroundColor(new Color(81,5,5,210));
	    monde = new MouseOverArea(container, buttonImage, 300, 500, this);
	     
	    enter=new Sound("/src/package1/ressources/music/enter.ogg");
	    beep=new Sound("/src/package1/ressources/music/beep.wav");
	    
	  }

	  
	  @Override
	  public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
	    background.draw(0, 0, container.getWidth(), container.getHeight());
	    
	    
	    g.setColor(new Color(0,0,0,100));
	    g.fillRect(200, 50, 350, 125);
	    g.fillRect(200, 200, 350, 125);
	    g.fillRect(200, 350, 350, 125);
	    g.setColor(Color.white);
	    g.drawString("Etes vous un homme ou une femme ?", 220, 75);
	    g.drawString("Magicien ou guerrier ?", 220, 225);
	    g.drawString("Quel est votre nom ?", 220, 375);
	   
	    homme.render(container, g);
	    femme.render(container, g);
	    magicien.render(container, g);
	    guerrier.render(container, g);
	    monde.render(container, g);
        pseudotf.render(container, g);
	    g.setColor(new Color(81,5,5,210));
	    if(sexe==0){g.fillRect(428, 109, 94, 32); g.drawAnimation(animationsh[2 + (true ? 4 : 0)], 600, 100);}
	    			else{g.fillRect(228, 109, 94, 32); g.drawAnimation(animationsf[2 + (true ? 4 : 0)], 600, 100);}
	    if(type==1){g.fillRect(228, 259, 94, 32);}else{g.fillRect(428, 259, 94, 32);}

	    font.drawString(homme.getX() + 20, homme.getY() +15, "Homme");
	    font.drawString(femme.getX() + 20, femme.getY() +15, "Femme");
	    font.drawString(magicien.getX() + 20, magicien.getY() +15, "Magicien");
	    font.drawString(guerrier.getX() + 20, guerrier.getY() +15, "Guerrier");
	    font.drawString(monde.getX() + 20, monde.getY() +15, "Valider");
	  }

	 
	  @Override
	  public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
	  }

	 
	  public void keyPressed(int key, char c) {
	  }
	  
	  public void keyReleased(int key, char c) {
	   
	  }

	  @Override
	  public int getID() {
	    return ID;
	  }
	  
	  private Animation loadAnimation(SpriteSheet spriteSheet, int startX, int endX, int y) {
			 Animation animation = new Animation();
			 for (int x = startX; x < endX; x++) {
			      animation.addFrame(spriteSheet.getSprite(x, y), 200);
			 }
			 return animation;
		 }
		  
		 
		  
		  
			    

	
	public void componentActivated(AbstractComponent source) {
		if (source == homme) {
			beep.play(); sexe=0;
		  } 
		else { if (source == femme){beep.play();  sexe=1;}
			else {if (source == magicien) {beep.play(); type=0;}
				else{if (source == guerrier) {beep.play(); type=1;}
					else{if (source == monde) 
						{ if (pseudotf.getText().length() > 0) {player.setnom(pseudotf.getText());
																jeu.getbp().settype(type);
																
																if(sexe==0)
																	{player.setsexe(0);
																	try {
																		jeu.getbp().setimage(new Image("src/package1/ressources/personnages/hommecombat.png").getScaledCopy(180, 240));
																	} catch (SlickException e1) {
																		// TODO Auto-generated catch block
																		e1.printStackTrace();
																	}
																	try {
																		player.setAnimation(new SpriteSheet("src/package1/ressources/personnages/spritehomme.png", 32, 48));
																	} catch (SlickException e) {
																		
																		e.printStackTrace();
																	}
																	} else
																	{player.setsexe(1);
																	try {
																		jeu.getbp().setimage(new Image("src/package1/ressources/personnages/fillecombat.png").getScaledCopy(180, 240));
																	} catch (SlickException e1) {
																		// TODO Auto-generated catch block
																		e1.printStackTrace();
																	}
																		try {
																		player.setAnimation(new SpriteSheet("src/package1/ressources/personnages/spritefille.png", 32, 48));
																	} catch (SlickException e) {
																		// TODO Auto-generated catch block
																		e.printStackTrace();
																	}
																	}	
																enter.play();
																 game.enterState(Chargement.ID, new FadeOutTransition(Color.black,1000), new FadeInTransition(Color.black,1000));}}
				}
			}
		}
		
	}

}
}
