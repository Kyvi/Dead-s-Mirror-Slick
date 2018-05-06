package package1;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.ComponentListener;
import org.newdawn.slick.gui.MouseOverArea;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.util.ResourceLoader;

import Principal.Splash;

public class MainScreenGameState extends BasicGameState implements ComponentListener{

	 public static final int ID = 1;
	  private Image background;
	  private StateBasedGame game;
	  private TrueTypeFont font;
	  private TrueTypeFont font2;
	  private TrueTypeFont font3;
	  private boolean antiAlias = true;
	  private MouseOverArea newgame;
	  private Music music;
	  private Sound button;
	  private int musiccompteur=0;
	  private Splash splash;
	 
	  public MainScreenGameState(Splash s){
		  splash = s;
	  }
	  

	public void init(GameContainer container, StateBasedGame game)throws SlickException {
		System.out.println("Initialisation mainscreen");
		this.game = game;
		
		Image buttonImage = new Image("/src/package1/ressources/hud/newgame.png").getScaledCopy(260, 50);
		newgame = new MouseOverArea(container, buttonImage, 265, 450, this);
		 Font awtFont = new Font("Times New Roman", Font.BOLD, 16);
	        font = new TrueTypeFont(awtFont, antiAlias);
	        Font awtFont3 = new Font("Times New Roman", Font.PLAIN, 24);
	        font3 = new TrueTypeFont(awtFont3, antiAlias);
	        
	        try {
				InputStream inputStream	= ResourceLoader.getResourceAsStream("/src/package1/ressources/Font/immortal/IMMORTAL.ttf");
				Font awtFont2 = Font.createFont(Font.TRUETYPE_FONT, inputStream);
	            awtFont2 = awtFont2.deriveFont(52f); // set font size
	            font2 = new TrueTypeFont(awtFont2, antiAlias);
				 
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (FontFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    this.background = new Image("/src/package1/ressources/background/mainscreen.png");
	    music = new Music("/src/package1/ressources/music/creation.ogg");
	    
	    button = new Sound("/src/package1/ressources/music/Decline.ogg");
	    System.out.println("Mainscreen init");
	    splash.getsp().setmain();
	    splash.getsp().repaint();
	}

	public void render(GameContainer container, StateBasedGame game, Graphics g)throws SlickException {
		background.draw(0, 0, container.getWidth(), container.getHeight());
		newgame.render(container, g);
		g.setColor(new Color(81,5,5,210));
		g.fillRect(270, 460, 250, 30);
		  font3.drawString(newgame.getX() + 60, newgame.getY() +10, "Nouvelle partie");
	    font2.drawString(255, 40, "Dead's Mirror");
	    g.setColor(new Color(255,255,255,150));
	    g.fillRoundRect(25, 540, 750, 35, 10);
	    font.drawString(50, 550, "Created by Joanna Sassano and Vincent Leclerc", new Color(81,5,5,210));
	    font.drawString(700, 550, "2016", new Color(81,5,5,210));
	    g.setColor(Color.white);
	   	}
	public int getID() {
		
		return ID;
	}
	
	public void keyReleased(int key, char c) {
	    
	  }
	
	public void componentActivated(AbstractComponent source) {
		  if (source == newgame) {
			  button.play();
			  music.setVolume(0.2f);
			  game.enterState(PseudoGameState.ID);
		  } 
	  }

	public void update(GameContainer arg0, StateBasedGame arg1, int arg2)throws SlickException {
		if (musiccompteur==0){music.loop(); musiccompteur=1;}
	}
	
	

	

}
