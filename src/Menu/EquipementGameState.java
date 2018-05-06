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

import package1.Equipable;
import package1.Equipement;
import package1.Jeu;
import package1.Joueur;

public class EquipementGameState extends BasicGameState {

	  public static final int ID = 7;
	  private Image background;
	  private StateBasedGame game;
	  private int pointeur = 0;
	  private Equipement equi;
	  private Jeu jeu;
	  private int varoption = 0;
	 
	  private Inventaire inv;
	  private JournalQuete jq;
	  private Joueur player;
	  private Sound beep;
	 
	  
	  public EquipementGameState(Jeu j, Inventaire inven,JournalQuete jourq,Joueur jo, Equipement eq){
			 jeu=j;
			 inv=inven;
			 jq=jourq;
			 player=jo;
			 equi=eq;
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
	   g.drawString("Equipement", 100, 25);
	   int i = 0;
	   int j=0;
	   if(equi.getnombreEquipement()>0){
	    	while(j<pointeur && j< equi.getnombreEquipement()){
	    		if (equi.getEquipable(i)!=null)
	    		{
	    			g.drawString(equi.getEquipable(i).getnomObjet(), 100, (j+3-Math.max(0, pointeur-10))*25);
	    			j++;
	    		}
	    		i++;
	    		}
	    	
	    	
	    	g.setColor(new Color(0,0,255,100));
	    	g.fillRect(100,(j+3-Math.max(0, pointeur-10))*25, 200, 20);
	    	
	    	g.setColor(Color.black);
	    	g.drawString("Niveau de l'equipement : " + (equi.getEquipablePresent(j)).getniveauEquipable() , 500, 275);
			g.drawString("Vie apportee : " + (equi.getEquipablePresent(j)).getvieEquipable() , 500, 300);
			g.drawString("Attaque apportee : " + (equi.getEquipablePresent(j)).getattaqueEquipable() , 500, 325);
			g.drawString("Defense apportee : " + (equi.getEquipablePresent(j)).getdefenseEquipable() , 500, 350);
	    	
	    	while(j< equi.getnombreEquipement()){
	    		if (equi.getEquipable(i)!=null)
	    		{
	    			g.drawString(equi.getEquipable(i).getnomObjet(), 100, (j+3-Math.max(0, pointeur-10))*25);
	    			j++;
	    		}
	    		i++;
		  
	    	}
	    }else{
	    	g.drawString("Vous n'avez aucun équipement, pensez à vous équiper .. Sincèrement .. ", 100, 200);
	    }
	   
	   // Dessin des armures
	   
	   g.drawOval(550, 50, 30, 30); // tete
	   g.drawRect(535, 80, 60, 60); // corps
	   g.drawRect(615,50,10,50); // epee
	   g.drawRect(600, 100, 40, 10); // poignet epee
	   g.drawRect(615, 110, 10, 20); // manche epee
	   if(equi.getnombreEquipement()>0){
	   Equipable eq = equi.getEquipablePresent(pointeur);
	   g.setColor(Color.red);
	   switch(eq.gettypeEqu()){
	   case 0 : // tete
		   g.fillOval(550, 50, 30, 30);
		   break;
	   case 1 : // corps
		   g.fillRect(535, 80, 60, 60); 
		   break;
	   case 2 : // epee
		   g.fillRect(615,50,10,50);
		   g.fillRect(600, 100, 40, 10);
		   g.fillRect(615, 110, 10, 20);
		   break;
	   }}
	   g.setColor(Color.black);
	   
	   // Dessin des caractéristiques perdues
	   
	   if (varoption == 1){
		   Equipable eq = equi.getEquipablePresent(pointeur);
		   g.setColor(new Color(0,0,255,100));
		   g.fillRect(500, 400, 150, 20);
		   g.setColor(Color.black);
		   g.drawString("Desequiper", 500, 400);
			  g.drawString("Vie :", 500, 475);
			  g.drawString(player.getvieMax() + " -> ", 600,475);
			  g.drawString("Attaque :", 500, 500);
			  g.drawString(player.getattaque() + " -> ", 600,500);
			  g.drawString("Defense :", 500, 525);
			  g.drawString(player.getdefense() + " -> ", 600,525);
			 g.setColor(Color.red);
			g.drawString(Integer.toString(player.getvieMax() - eq.getvieEquipable()), 650,475);
			g.drawString(Integer.toString(player.getattaque() - eq.getattaqueEquipable()), 650,500);
			g.drawString(Integer.toString(player.getdefense() - eq.getdefenseEquipable()), 650,525);
			g.setColor(Color.black);
	   		}
	   
		   
		   
		   
	  }

	 
	  public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
	  }

	 
	  public void keyPressed(int key, char c) {
		  switch (key) {
		  case Input.KEY_UP:
			  
			  if (varoption == 0){
				  beep.play();
				  if (pointeur==0) { pointeur = equi.getnombreEquipement()-1;}
				  else { pointeur = pointeur - 1;}}
			  
		    
		    break;
		  case Input.KEY_LEFT:
		    
		    break;
		  case Input.KEY_DOWN:
			
			  if (varoption == 0){
				  beep.play();
				  if (pointeur==equi.getnombreEquipement()-1) { pointeur =0;}
				  else { pointeur = pointeur + 1;}}
			  
		   
		    break;
		  case Input.KEY_RIGHT:
		   
		    break;
		  case Input.KEY_ENTER:
			  
			  if (equi.getnombreEquipement()>0){
				  beep.play();
				  if(varoption==0) {varoption = 1;}
				  else if(varoption==1){	  
					  equi.getEquipablePresent(pointeur).desequiper(inv,player,equi,jq,jeu.getbp());
					  if (equi.getnombreEquipement()>0 && pointeur!=0) pointeur = pointeur -1;
					 						else {pointeur = 0;}
					 				varoption = 0;
						}
				  }
			  
			 
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
