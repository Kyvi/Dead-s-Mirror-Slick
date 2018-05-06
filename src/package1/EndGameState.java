package package1;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.ComponentListener;
import org.newdawn.slick.gui.MouseOverArea;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;
import org.newdawn.slick.util.ResourceLoader;

public class EndGameState extends BasicGameState implements ComponentListener{

	public static final int ID = 60;
	private StateBasedGame game;
	private Image background1;
	private Image background2;
	private Image background3;
	private Image background4;
	private Image background5;
	private TrueTypeFont font2;
	  
	  private boolean antiAlias = true;
	
	
	private MouseOverArea newgame;
	private int barre = 0 ;
	private int etat = 0;
	private int etatbis = 0;
	 private Sound enter;
	 private Sound beep;
	 private Jeu jeu;
	 private Music music;
	
	
	 
	 public EndGameState(Jeu j){
		 jeu=j;
	 }
	 
	 
	 
	 
	 
	
	public void init(GameContainer gc, StateBasedGame s) throws SlickException {
		this.game = s;
		this.background1 = new Image("/src/package1/ressources/background/miroir.jpg");
		this.background2 = new Image("/src/package1/ressources/background/filledort.jpg");
		this.background3 = new Image("/src/package1/ressources/background/hommedort.jpg");
		this.background4 = new Image("/src/package1/ressources/background/filleetonne.png");
		this.background5 = new Image("/src/package1/ressources/background/hommeetonne.jpg");
		
		Image buttonImage = new Image("/src/package1/ressources/hud/newgame.png").getScaledCopy(100, 50);
		enter=new Sound("/src/package1/ressources/music/enter.ogg");
		beep=new Sound("/src/package1/ressources/music/beep.wav");
		music = new Music("/src/package1/ressources/music/creation.ogg");
		
		newgame = new MouseOverArea (gc, buttonImage, 350, 500, this);
		
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
		
				
		
	}
	

	@Override
	public void render(GameContainer gc, StateBasedGame s, Graphics g) throws SlickException {
		
	String textef1[]= {"Après tous ces périples, " + jeu.getplayer().getnom() + " a réussi "
								,"a vaincre Keldranor et Mirrathia et ainsi à ramener "
								,"le miroir des morts dans son village. Ravie de la "
								,"conclusion de cette histoire, " + jeu.getplayer().getnom() + " resta des "
								,"heures à parler avec sa défunte mère. Quand d'un coup"
								," ... "};
								
	String texteh1[]= {"Après tous ces périples, " + jeu.getplayer().getnom() + " a réussi "
			,"a vaincre Keldranor et Mirrathia et ainsi à ramener "
			,"le miroir des morts dans son village. Ravi de la "
			,"conclusion de cette histoire, " + jeu.getplayer().getnom() + " resta des "
			,"heures à parler avec sa défunte mère. Quand d'un coup"
			," ... "};

	String textef2[] = { jeu.getplayer().getnom() + " ouvrit les yeux se rendant compte que tout ceci",
						"n'était qu'un affreux cauchemar. A la fois déçue, ",
						"et contente que ce ne fut qu'un rêve, "+ jeu.getplayer().getnom()+"",
						"se rendit à son lieu de travail comme tous les jours.",
						};
	String texteh2[] = { jeu.getplayer().getnom() + " ouvrit les yeux se rendant compte que tout ceci",
			"n'était qu'un affreux cauchemar. A la fois déçu, ",
			"et content que ce ne fut qu'un rêve, "+ jeu.getplayer().getnom()+"",
			"se rendit à son lieu de travail comme tous les jours.",
			};
	String textef3[]= {"Mais une fois arrivée sur son lieu de travail, "+ jeu.getplayer().getnom()+" ",
						"se rendit compte que le miroir avait été volé avec pour seul",
						"message un vulgaire papier sur lequel il était écrit : ",
						"Ma vengence sera terrible!!"};
	String texteh3[]= {"Mais une fois arrivé sur son lieu de travail, "+ jeu.getplayer().getnom()+" ",
						"se rendit compte que le miroir avait été volé avec pour seul",
						"message un vulgaire papier sur lequel il était écrit : ",
						"Ma vengence sera terrible!!"};
	 
		
		g.setColor(new Color(0,0,0,100));
		g.fillRect(125, 125, 550, 325);
		
		// Barre de chargement
		
		/*if (barre < 5000) {
			g.setColor(new Color(255,0,0,150));
			g.fillRect(150, 500, (int)(barre/10), 20);
			g.setColor(Color.white);
			g.drawString("Chargement en cours", 175, 500);
		}*/
		
		g.setColor(Color.white);
		
		switch (etat){
		case 0 :
			
				//Important proportions à garder A augmenter pour ralentir, diminuer pour accelerer !! : 
				//-> vitesse de texte 1000/20,
				//-> vitesse de défilement 1000/40
				background1.draw(0,0,gc.getWidth(),gc.getHeight());
				g.setColor(new Color(0,0,0,100));
				g.fillRect(100,100,600,350);
				g.setColor(Color.white);
				switch(jeu.getplayer().getsexe()){
				case 1 :
					for (int i=0;i<6;i++){
						g.drawString(textef1[i].substring(0, Math.max(0,Math.min((int)((barre-(2000*i))/40),textef1[i].length()))),
						150, Math.max(150+(25*i),((int)400-((barre-(2000*i))/80))));}
					break;
				case 0 :
					for (int i=0;i<6;i++){
							g.drawString(texteh1[i].substring(0, Math.max(0,Math.min((int)((barre-(2000*i))/40),texteh1[i].length()))),
							150, Math.max(150+(25*i),((int)400-((barre-(2000*i))/80))));}
					break;
				}
				if (barre > 20000) { newgame.render(gc, g); g.drawString("Suivant",360,515);}
			break;
		case 1 :
				
				switch(jeu.getplayer().getsexe()){
				case 1 :
					background2.draw(0,0,gc.getWidth(),gc.getHeight());
					g.setColor(new Color(0,0,0,100));
					g.fillRect(100,100,600,350);
					g.setColor(Color.white);
					for (int i=0;i<4;i++){
					g.drawString(textef2[i].substring(0, Math.max(0,Math.min((int)((barre-(2000*i))/40),textef2[i].length()))),
							150, Math.max(150+(25*i),((int)400-((barre-(2000*i))/80))));}
					break;
					
				case 0 :
					background3.draw(0,0,gc.getWidth(),gc.getHeight());
					g.setColor(new Color(0,0,0,100));
					g.fillRect(100,100,600,350);
					g.setColor(Color.white);
					for (int i=0;i<4;i++){
					g.drawString(texteh2[i].substring(0, Math.max(0,Math.min((int)((barre-(2000*i))/40),texteh2[i].length()))),
							150, Math.max(150+(25*i),((int)400-((barre-(2000*i))/80))));}
					break;
				}
				
				
				if (barre > 20000) { newgame.render(gc, g); g.drawString("Suivant",360,515);}
			break;
		case 2 :
			switch(jeu.getplayer().getsexe()){
			case 1 :
				background4.draw(0,0,gc.getWidth(),gc.getHeight());
				g.setColor(new Color(0,0,0,100));
				g.fillRect(100,100,600,350);
				g.setColor(Color.white);
				for (int i=0;i<4;i++){
				g.drawString(textef3[i].substring(0, Math.max(0,Math.min((int)((barre-(2000*i))/40),textef3[i].length()))),
						150, Math.max(150+(25*i),((int)400-((barre-(2000*i))/80))));}
				break;
				
			case 0 :
				background5.draw(0,0,gc.getWidth(),gc.getHeight());
				g.setColor(new Color(0,0,0,100));
				g.fillRect(100,100,600,350);
				g.setColor(Color.white);
				for (int i=0;i<4;i++){
				g.drawString(texteh3[i].substring(0, Math.max(0,Math.min((int)((barre-(2000*i))/40),texteh3[i].length()))),
						150, Math.max(150+(25*i),((int)400-((barre-(2000*i))/80))));}
				break;
			}
				
				if (barre > 20000) { newgame.render(gc, g); g.drawString("Suivant",360,515);}
			break;
		case 3 :
			g.setColor(Color.black);
			g.fillRect(0,0,gc.getWidth(),gc.getHeight());
			g.setColor(Color.white);
			font2.drawString(200, 200, "To be continued");
			font2.drawString(300, 300, ". . .");
			break;
		}
		
		
		
	}

	@Override
	public void update(GameContainer gc, StateBasedGame s, int delta) throws SlickException {
		if (etatbis==1){barre=0;etatbis = 0;}
		barre += delta;
		if (etat == 3 && barre > 8000){music.loop();game.enterState(1,new FadeOutTransition(Color.black, 1000), new FadeInTransition(Color.black,1000));}
		
	}
	
	public void componentActivated(AbstractComponent source) {
		switch (etat){
		case 0 :
			if (source == newgame && barre > 20000) {
					beep.play();
					etat = 1;
					etatbis = 1;	
			  } 
			
			break;
			
		case 1 :
			if (source == newgame && barre > 20000) {
			beep.play();
			etat = 2;
			etatbis = 1;
		}
			break;
			
		case 2 :
			if (source == newgame && barre > 20000) {
					beep.play();
					etat = 3;
					etatbis = 1;	
			  } 
			
			break;
			
		
		}
		  
	  }
	
	public void keyPressed(int key, char c) {
		switch (key) {
		case Input.KEY_ENTER:
			barre =25000;
			break;
		}
			
	}

	@Override
	public int getID() {
		return ID;
	}

}