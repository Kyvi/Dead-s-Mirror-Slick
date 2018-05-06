package package1;

import java.awt.Container;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.ComponentListener;
import org.newdawn.slick.gui.MouseOverArea;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

public class Chargement extends BasicGameState implements ComponentListener{

	public static final int ID = 50;
	private StateBasedGame game;
	private Image background1;
	private Image background2;
	private Image background3;
	private Image background4;
	private Image background5;
	private Image background6;
	private Image background7;
	private MouseOverArea newgame;
	private int barre = 0 ;
	private int etat = 0;
	private int etatbis = 0;
	 private Sound enter;
	 private Sound beep;
	 private Jeu jeu;
	 private Music music;
	 private Music musicnaissance;
	
	 
	 public Chargement(Jeu j){
		 jeu=j;
	 }
	 
	 
	 
	 
	 
	
	public void init(GameContainer gc, StateBasedGame s) throws SlickException {
		this.game = s;
		this.background1 = new Image("/src/package1/ressources/background/chargement1.png");
		this.background2 = new Image("/src/package1/ressources/background/filledort.jpg");
		this.background3 = new Image("/src/package1/ressources/background/filleetonne.png");
		this.background4 = new Image("/src/package1/ressources/background/filleaventure.png");
		this.background5 = new Image("/src/package1/ressources/background/hommedort.jpg");
		this.background6 = new Image("/src/package1/ressources/background/hommeetonne.jpg");
		this.background7 = new Image("/src/package1/ressources/background/hommeaventure.png");
		Image buttonImage = new Image("/src/package1/ressources/hud/newgame.png").getScaledCopy(100, 50);
		enter=new Sound("/src/package1/ressources/music/enter.ogg");
		beep=new Sound("/src/package1/ressources/music/beep.wav");
		music = new Music("/src/package1/ressources/music/creation.ogg");
		musicnaissance = new Music("/src/package1/ressources/music/naissance.ogg");
		newgame = new MouseOverArea (gc, buttonImage, 350, 500, this);
		
				
		
	}
	

	@Override
	public void render(GameContainer gc, StateBasedGame s, Graphics g) throws SlickException {
		
	String textef1[]= {"Il était une fois, une jeune fille de forgeron qui possédait "
								,"le pouvoir de faire apparaitre les personnes de "
								,"l'autre monde à travers un miroir magique appartenant "
								,"à Mésomorphe, son petit village d'origine. Elle a "
								,"hérité ce don de sa mère qui l'avait elle-même hérité "
								,"de sa mère et ainsi de suite. Depuis des années, des "
								,"personnes du monde entier s'arrêtent dans ce village "
								,"pour parler quelques minutes avec ceux qui les ont jadis "
								,"quitté. Cela fait seulement quelques semaines qu'elle "
								,"est la nouvelle gardienne de ce bien ancestral, sa mère "
								,"venant tout juste de mourir et la jeune " + jeu.getplayer().getnom() + " ne savait "
								,"pas encore ce qui l'attendait."};
	String texteh1[]= { "Il était une fois, un jeune fils de forgeron qui possèdait "
			,"le pouvoir de faire apparaitre les personnes de "
			,"l'autre monde à travers un miroir magique appartenant "
			,"à Mésomorphe, son petit village d'origine. Il a "
			,"hérité ce don de sa mère qui l'avait elle-même hérité "
			,"de sa mère et ainsi de suite. Depuis des années, des "
			,"personnes du monde entier s'arrêtent dans ce village "
			,"pour parler quelques minutes avec ceux qui les ont jadis "
			,"quitté. Cela fait seulement quelques semaines qu'il "
			,"est le nouveau gardien de ce bien ancestral, sa mère "
			,"venant tout juste de mourir et le jeune " + jeu.getplayer().getnom() + " ne savait "
			,"pas encore ce qui l'attendait."};

	String texte2[] = {"C'était un matin comme les autres, les oiseaux chantaient",
						"On pouvait entendre rire les enfants par la fenêtre.",
						"Comme tous les matins, "+ jeu.getplayer().getnom()+" ne voulait",
						"pas se lever pour assumer la tâche qui lui incombait.",
						"Son père, lui, était parti très tôt à la pêche et avait",
						"laissé dormir le gros bébé qui ressemblait à un ange."};
	String textef3[]= {"Mais une fois arrivée sur son lieu de travail, "+ jeu.getplayer().getnom()+" ",
						"se rendit compte que le miroir avait été volé avec pour seul",
						"message un vulgaire papier sur lequel il était écrit : ",
						"Ma vengence sera terrible!!"};
	String texteh3[]= {"Mais une fois arrivé sur son lieu de travail, "+ jeu.getplayer().getnom()+" ",
						"se rendit compte que le miroir avait été volé avec pour seul",
						"message un vulgaire papier sur lequel il était écrit : ",
						"Ma vengence sera terrible!!"};
	 String textef4[]= { "Bien determinée à retrouver ce bien qui lui est si cher", 
			 			"à elle ainsi qu'à son petit village, "+ jeu.getplayer().getnom()+" décida de partir ",
			 			"à la recherche du voleur, quitte à y laisser sa vie.", 
			 			"Elle songea ainsi à aller prévenir son père avant"
			 			,"ce fulgurant voyage..."};
	 String texteh4[]= { "Bien determiné à retrouver ce bien qui lui est si cher", 
	 				"à lui ainsi qu'à son petit village, "+ jeu.getplayer().getnom()+" décida de partir ",
	 				"à la recherche du voleur, quitte à y laisser sa vie.", 
	 				"Il songea ainsi à aller prévenir son père avant"
	 				,"ce fulgurant voyage..."};
		
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
					for (int i=0;i<12;i++){
						g.drawString(textef1[i].substring(0, Math.max(0,Math.min((int)((barre-(2000*i))/40),textef1[i].length()))),
						150, Math.max(150+(25*i),((int)400-((barre-(2000*i))/80))));}
					break;
				case 0 :
					for (int i=0;i<12;i++){
							g.drawString(texteh1[i].substring(0, Math.max(0,Math.min((int)((barre-(2000*i))/40),texteh1[i].length()))),
							150, Math.max(150+(25*i),((int)400-((barre-(2000*i))/80))));}
					break;
				}
				if (barre > 23500) { newgame.render(gc, g); g.drawString("Suivant",360,515);}
			break;
		case 1 :
				
				switch(jeu.getplayer().getsexe()){
				case 1 :
					background2.draw(0,0,gc.getWidth(),gc.getHeight());
					g.setColor(new Color(0,0,0,100));
					g.fillRect(100,100,600,350);
					g.setColor(Color.white);
					for (int i=0;i<6;i++){
					g.drawString(texte2[i].substring(0, Math.max(0,Math.min((int)((barre-(2000*i))/40),texte2[i].length()))),
							150, Math.max(150+(25*i),((int)400-((barre-(2000*i))/80))));}
					break;
					
				case 0 :
					background5.draw(0,0,gc.getWidth(),gc.getHeight());
					g.setColor(new Color(0,0,0,100));
					g.fillRect(100,100,600,350);
					g.setColor(Color.white);
					for (int i=0;i<6;i++){
					g.drawString(texte2[i].substring(0, Math.max(0,Math.min((int)((barre-(2000*i))/40),texte2[i].length()))),
							150, Math.max(150+(25*i),((int)400-((barre-(2000*i))/80))));}
					break;
				}
				
				
				if (barre > 20000) { newgame.render(gc, g); g.drawString("Suivant",360,515);}
			break;
		case 2 :
			switch(jeu.getplayer().getsexe()){
			case 1 :
				background3.draw(0,0,gc.getWidth(),gc.getHeight());
				g.setColor(new Color(0,0,0,100));
				g.fillRect(100,100,600,350);
				g.setColor(Color.white);
				for (int i=0;i<4;i++){
				g.drawString(textef3[i].substring(0, Math.max(0,Math.min((int)((barre-(2000*i))/40),textef3[i].length()))),
						150, Math.max(150+(25*i),((int)400-((barre-(2000*i))/80))));}
				break;
				
			case 0 :
				background6.draw(0,0,gc.getWidth(),gc.getHeight());
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
			switch(jeu.getplayer().getsexe()){
			case 1 :
				background4.draw(0,0,gc.getWidth(),gc.getHeight());
				g.setColor(new Color(0,0,0,100));
				g.fillRect(100,100,600,350);
				g.setColor(Color.white);
				for (int i=0;i<5;i++){
				g.drawString(textef4[i].substring(0, Math.max(0,Math.min((int)((barre-(2000*i))/40),textef4[i].length()))),
						150, Math.max(150+(25*i),((int)400-((barre-(2000*i))/80))));}
				break;
				
			case 0 :
				background7.draw(0,0,gc.getWidth(),gc.getHeight());
				g.setColor(new Color(0,0,0,100));
				g.fillRect(100,100,600,350);
				g.setColor(Color.white);
				for (int i=0;i<5;i++){
				g.drawString(texteh4[i].substring(0, Math.max(0,Math.min((int)((barre-(2000*i))/40),texteh4[i].length()))),
						150, Math.max(150+(25*i),((int)400-((barre-(2000*i))/80))));}
				break;
			}
				
				if (barre > 20000) { newgame.render(gc, g); g.drawString("Démarrer",360,515);}
			break;
		}
		
		
	}

	@Override
	public void update(GameContainer gc, StateBasedGame s, int delta) throws SlickException {
		if (etatbis==1){barre=0;etatbis = 0;}
		barre += delta;
		
	}
	
	public void componentActivated(AbstractComponent source) {
		switch (etat){
		case 0 :
			if (source == newgame && barre > 23500) {
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
			
		case 3 :
			if (source == newgame && barre > 20000) {
				  jeu.setdebut(java.lang.System.currentTimeMillis());
					enter.play();
					musicnaissance.loop(); musicnaissance.setVolume(0f);
					   musicnaissance.fade(2000, 0.2f, false);
					 game.enterState(jeu.ID, new FadeOutTransition(Color.black,1000), new FadeInTransition(Color.black,1000));
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
