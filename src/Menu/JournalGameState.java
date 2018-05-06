

package Menu;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;

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

public class JournalGameState extends BasicGameState {

	  public static final int ID = 6;
	  private Image background;
	  private StateBasedGame game;
	  private Jeu jeu;
	  private Inventaire inv;
	  private JournalQuete jq;
	  private int pointeur=0; 
	  private Joueur player;
	  private Equipement equipement;
	  private int varoption = 0;
	  private Sound beep;
	  
	  public JournalGameState(Jeu j,Inventaire inven,JournalQuete jourq,Joueur jo,Equipement eq){
			 jeu=j;
			 inv=inven;
			 jq=jourq;
			 player=jo;
			 equipement=eq;
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
	    g.drawString("Journal de quete", 100, 25);
	    
	    if (jq.getboni()>-1){
	   for(int i=0;i<pointeur;i++){
		   if(jq.getQuete(i).getintitule().length()>20){
			   g.drawString(jq.getQuete(i).getintitule().substring(0, 18) + "...", 100, (i+3-Math.max(0, pointeur-18))*25);
		   } else
		   {g.drawString(jq.getQuete(i).getintitule(), 100, (i+3-Math.max(0, pointeur-18))*25);}
	   }
	   
	   g.setColor(new Color(0,0,255,100));
   		g.fillRect(100,(pointeur+3-Math.max(0, pointeur-18))*25, 200, 20);
   		
   		g.setColor(Color.black);
   		for(int i=pointeur;i<=jq.getboni();i++){
   			if(jq.getQuete(i).getintitule().length()>20){
 			   g.drawString(jq.getQuete(i).getintitule().substring(0, 18) + "...", 100, (i+3-Math.max(0, pointeur-18))*25);
 		   } else
 		   {g.drawString(jq.getQuete(i).getintitule(), 100, (i+3-Math.max(0, pointeur-18))*25);}
 	   }
   		
   		if (varoption==1){
   			Quete quete = jq.getQuete(pointeur);
   			g.drawString(quete.getintitule(), 400, 100);
   			
   			
   			String str = quete.getDescription();
   			ecrire(g,str,30,400,150);
   			
   			switch (quete.getetat()){
   			case 0 :
   				g.drawString("En cours", 400, 400);
   				switch(jq.getQuete(pointeur).gettype()){
   	   			case 0 : // Ramener Objet
   	   				for (int nb=0; nb<((RamenerObjet) quete).getnombreObjet(); nb++){
   	   					g.drawString(inv.getObjet(((RamenerObjet) quete).getIdObjet(nb)).getnomObjet() +
   	   							" : " + ((RamenerObjet) quete).getencours(nb) +
   	   							"/" + ((RamenerObjet) quete).getmax(nb) , 400, 420+(20*nb));
   	   				}
   	   				break;
   	   				
   	   			
   	   				
   	   			case 2 : // Battre monstre
   	   				g.drawString(((BattreMonstre) quete).getquantiteEnCours() +
   	   						"/" + ((BattreMonstre) quete).getquantiteMax(), 400, 420);
   	   				break;
   	   			}
   				break;
   			case 1 :
   				g.drawString("En attente de validation", 400, 400);
   				switch(jq.getQuete(pointeur).gettype()){
   	   			case 0 : // Ramener Objet
   	   			for (int nb=0; nb<((RamenerObjet) quete).getnombreObjet(); nb++){
	   					g.drawString(inv.getObjet(((RamenerObjet) quete).getIdObjet(nb)).getnomObjet() +
	   							" : " + ((RamenerObjet) quete).getencours(nb) +
	   							"/" + ((RamenerObjet) quete).getmax(nb) , 400, 420+(20*nb));
	   				}
	   				break;
   	   				
   	   				
   	   			case 2 : // Battre monstre
   	   			g.drawString(((BattreMonstre) quete).getquantiteEnCours() +
	   						"/" + ((BattreMonstre) quete).getquantiteMax(), 400, 420);
	   				break;
   	   			}
   				break;
   			case 2 :
   				g.drawString("Validee", 400, 400);
   				break;
   			}
   			
   			
   		}
	    	
	  }
	    else {g.drawString("Journal de quete vide", 200, 200);}
	  }

	 
	public void ecrire(Graphics g,String s,int l,int x,int y){
		int psize=0;
		int compteur=0;
		while(psize+l<s.length()){
			int pexact=psize+l-10;
			while(s.charAt(pexact)!=' ')pexact++;
			g.drawString(s.substring(psize,pexact+1), x, y+(25*compteur));
			psize=pexact+1;
			compteur++;
		}
		g.drawString(s.substring(psize), x, y+(25*compteur));
	}

	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
	  }

	 
	  public void keyPressed(int key, char c) {
		  switch (key) {
		  case Input.KEY_UP:
			  if (varoption == 0){ beep.play();
				  if (pointeur==0) { pointeur = jq.getboni();}
				  else { pointeur = pointeur - 1;}}
			  
			 
		    
		    break;
		  case Input.KEY_LEFT:
		    
		    break;
		  case Input.KEY_DOWN:
			
			  if (varoption == 0){ beep.play();
				  if (pointeur == jq.getboni()) {pointeur = 0 ;}
				  else { pointeur = pointeur + 1;}}
			  
		   
		    break;
		  case Input.KEY_RIGHT:
		   
		    break;
		  case Input.KEY_ENTER:
			  
			  if(varoption==0 && (jq.getboni()>-1))
				  	 {varoption = 1; beep.play();}
			  else
			  { varoption = 0; beep.play();}
			  
		  break;
		  
		  case Input.KEY_ESCAPE:
			  beep.play();
			  if(varoption == 0){
				  game.enterState(MenuGameState.ID);
			  }
			  else{varoption = 0;}
			  
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
