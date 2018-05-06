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

import Non_Combattant.Marchand;
import package1.Equipable;
import package1.Jeu;
import package1.Joueur;

public class AchatGameState extends BasicGameState {

	  public static int ID=11;
	  private Image background;
	  private StateBasedGame game;
	  private int quantite = 0;
	  private int pointeur = 0;
	  private int onglet = 0;
	  
	  private int choixq = 0;
	  private Jeu jeu;
	  private Inventaire inv;
	  private JournalQuete jq;
	  private Marchand marchand;
	  private Sound beep;
	 
	  
	public AchatGameState(Jeu j,Inventaire inven,JournalQuete jourq, Marchand march){
		 jeu=j;
		 inv=inven;
		 jq=jourq;
		 marchand = march;
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
	    g.setColor(new Color(0,0,0,100));
	    g.fillRect(75, 70, 250, 510);
	    g.setColor(Color.black);
	    g.drawString("Achat", 100, 25);
	    g.drawString("Votre argent : " + inv.getquantiteArgent(), 500, 75);
	    
	    switch (onglet){
	    
	    case 0 :
		    // onglet utilisable 
		    
	    	g.setColor(Color.white);
	    	g.drawString("<- Objets Utilisables ->", 100, 75);
	    
	    		
	    	    int jm = 0;
	    	    	while(jm<pointeur && jm< marchand.getind()){
	    	    			if (marchand.getObjet(jm).getidObjet()<20){
	    	    		if (jm<pointeur-15){} else{
	    	    			g.drawString(marchand.getObjet(jm).getnomObjet(), 100, (jm+5-Math.max(0, pointeur-15))*25);}
	    	    			
	    	    		}jm++;}
	    	    	
	    	    	g.setColor(new Color(0,0,255,100));
	    	    	g.fillRect(100,(jm+5-Math.max(0, pointeur-15))*25, 200, 20);
	    	    	
	    	    	g.setColor(Color.black);
	    	    	int idm = marchand.getObjet(jm).getidObjet();
	    	    	g.drawString(marchand.getObjet(jm).getnomObjet(), 500, 150);
	    	    	g.drawString("Quantite possedee : " + inv.getquantiteObjet(idm), 500, 175);
	    	    	g.drawString("Valeur : " + marchand.getObjet(jm).getvaleur(), 500, 200);
	    	    	if (0<=idm && idm<20)
	    	    		{
	    	    			g.drawString("Objet utilisable en combat", 500, 250);
	    	    			if (idm<5) g.drawString("Montant vie : " + ((ObjetUtilisable) marchand.getObjet(jm)).getmontantVie() , 500, 275);
	    	    			if (idm>=5 && idm<10) g.drawString("Montant mana : " + ((ObjetUtilisable) marchand.getObjet(jm)).getmontantMana() , 500, 275);
	    	    			if (idm>=10 && idm<15) g.drawString("Montant attaque : " + ((ObjetUtilisable) marchand.getObjet(jm)).getmontantAttaque() , 500, 275);
	    	    			if (idm>=15 && idm<20) g.drawString("Montant defense : " + ((ObjetUtilisable) marchand.getObjet(jm)).getmontantDefense() , 500, 275);
	    	    		}
	    	    	
	    	    	g.setColor(Color.white);
	    	    	while( jm < marchand.getind()){
	    	    			if (marchand.getObjet(jm).getidObjet()<20){
	    	    				if (jm>Math.max(pointeur,15)){} else{
	    	    			g.drawString(marchand.getObjet(jm).getnomObjet(), 100, (jm+5-Math.max(0, pointeur-15))*25);	}
	    	    		}jm++;}
	    	  
	    	    	break;
	    case 1 :
	    	// onglet Equipable
		    
	    	g.setColor(Color.white);
	    	g.drawString("<- Objets Equipables ->", 100, 75);
	    	jm = 20;
	    	while(jm<pointeur+20 && jm< marchand.getind()){
	    			if (marchand.getObjet(jm).getidObjet()>=20 && marchand.getObjet(jm).getidObjet()<40){
	    		if (jm<pointeur+5){} else{
	    			g.drawString(marchand.getObjet(jm).getnomObjet(), 100, (jm-20+5-Math.max(0, pointeur-15))*25);}
	    			
	    		}jm++;}
	    	
	    	g.setColor(new Color(0,0,255,100));
	    	g.fillRect(100,(jm-20+5-Math.max(0, pointeur-15))*25, 200, 20);
	    	
	    	g.setColor(Color.black);
	    	idm = marchand.getObjet(jm).getidObjet();
	    	g.drawString(marchand.getObjet(jm).getnomObjet(), 500, 150);
	    	g.drawString("Quantite possedee : " + inv.getquantiteObjet(idm), 500, 175);
	    	g.drawString("Valeur : " + marchand.getObjet(jm).getvaleur(), 500, 200);
	    	if (20<=idm && idm<40)
	    		{
	    			g.drawString("Objet pouvant etre equipe", 500, 250);
	    			g.drawString("Niveau de l'equipement : " + ((Equipable) marchand.getObjet(jm)).getniveauEquipable() , 500, 275);
	    			g.drawString("Vie apportee : " + ((Equipable) marchand.getObjet(jm)).getvieEquipable() , 500, 300);
	    			g.drawString("Attaque apportee : " + ((Equipable) marchand.getObjet(jm)).getattaqueEquipable() , 500, 325);
	    			g.drawString("Defense apportee : " + ((Equipable) marchand.getObjet(jm)).getdefenseEquipable() , 500, 350);
	    		}
	    	g.setColor(Color.white);
	    	
	    	while( jm < marchand.getind()){
	    			if (marchand.getObjet(jm).getidObjet()>=20 && marchand.getObjet(jm).getidObjet()<40 ){
	    				if (jm>Math.max(pointeur+20,35)){} else{
	    			g.drawString(marchand.getObjet(jm).getnomObjet(), 100, (jm-20+5-Math.max(0, pointeur-15))*25);}
	    			
	    		}jm++;}
	  
	    	break;
	    case 2 :
	    	// onglet Autre
		    
	    	g.setColor(Color.white);
	    	g.drawString("<- Autre ->", 100, 75);
	    	jm = 39;
	    	while(jm<pointeur+39 && jm< marchand.getind()){
	    			if (marchand.getObjet(jm).getidObjet()>=40 && marchand.getObjet(jm).getidObjet()<70){
	    		if (jm<pointeur+24){} else{
	    			g.drawString(marchand.getObjet(jm).getnomObjet(), 100, (jm-39+5-Math.max(0, pointeur-15))*25);}
	    			
	    		}jm++;}
	    	
	    	g.setColor(new Color(0,0,255,100));
	    	g.fillRect(100,(jm-39+5-Math.max(0, pointeur-15))*25, 200, 20);
	    	
	    	g.setColor(Color.black);
	    	idm = marchand.getObjet(jm).getidObjet();
	    	g.drawString(marchand.getObjet(jm).getnomObjet(), 500, 150);
	    	g.drawString("Quantite possedee : " + inv.getquantiteObjet(idm), 500, 175);
	    	g.drawString("Valeur : " + marchand.getObjet(jm).getvaleur(), 500, 200);
	    	g.setColor(Color.white);
	    	
	    	
	    	while( jm < marchand.getind()){
	    			if (marchand.getObjet(jm).getidObjet()>=40 && marchand.getObjet(jm).getidObjet()<70 ){
	    				if (jm>Math.max(pointeur+39,54)){} else{
	    			g.drawString(marchand.getObjet(jm).getnomObjet(), 100, (jm-39+5-Math.max(0, pointeur-15))*25);}
	    			
	    		}jm++;}
	  
	    	break;
	    }
	    		
	    		
	    g.setColor(Color.black);
	   if (choixq == 1){
		   g.drawString("Quantite ?", 500, 475);
		   g.drawString(Integer.toString(quantite), 500, 500);
	   }
	   
	   
	  }

	 
	  @Override
	  public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
	  }

	 
	  public void keyPressed(int key, char c) {
		  switch (key) {
		  case Input.KEY_UP:
			  
			 if(choixq==0){
				 if(pointeur == 0){
				 		switch (onglet){
				 		case 0 :
				 		pointeur = 19;
				 		break;
				 		case 1 :
				 		pointeur = 18;
				 		break;
				 		case 2 :
				 		pointeur = 5;
				 		break;
				 		}}
					  else { pointeur = pointeur - 1;}
					  beep.play();
			 }	 
				  
				 
		    break;
		  case Input.KEY_LEFT:

			  if (choixq == 0){
				  beep.play();
				  pointeur = 0;
				  if (onglet==0){onglet = 2;}
				  else {onglet--;}
			  }
			  if (choixq == 1){
				  int qmaxa = 0;
				  	switch (onglet){
				  	case 0 :
					   qmaxa = inv.getquantiteArgent() / marchand.getObjet(pointeur).getvaleur();
					  break;
				  	case 1 :
				  		 qmaxa = inv.getquantiteArgent() / marchand.getObjet(pointeur+20).getvaleur();
						  break;
				  	case 2 :
				  		qmaxa = inv.getquantiteArgent() / marchand.getObjet(pointeur+39).getvaleur(); 
				  		break;
				  	}
					  if (quantite == 0){quantite = qmaxa;} else {quantite = quantite - 1;}
					  beep.play();
				  
				  }
			  
			  
			  break;
		    
		    
		  case Input.KEY_DOWN:
			
			  
			  if(choixq==0){
				  
				  switch (onglet){
				  case 0 :
					  if (pointeur==19) { pointeur = 0;}
					  else { pointeur = pointeur + 1;}
					  break;
				  case 1 :
					  if (pointeur==18) { pointeur = 0;}
					  else { pointeur = pointeur + 1;}
					  break;
				  case 2 :
					  if (pointeur==5) { pointeur = 0;}
					  else { pointeur = pointeur + 1;}
					  break;
				  }
					  beep.play();
					 
			  }  
				  
			 
			  
		   
		    break;
		    
		  case Input.KEY_RIGHT:
			  

			  if (choixq == 0){
				  beep.play();
				  pointeur = 0;
				  if (onglet==2){onglet = 0;}
				  else {onglet++;}
			  }
			  
			  if (choixq == 1){
				  int qmaxa = 0;
				  	switch (onglet){
				  	case 0 :
					   qmaxa = inv.getquantiteArgent() / marchand.getObjet(pointeur).getvaleur();
					  break;
				  	case 1 :
				  		 qmaxa = inv.getquantiteArgent() / marchand.getObjet(pointeur+20).getvaleur();
						  break;
				  	case 2 :
				  		qmaxa = inv.getquantiteArgent() / marchand.getObjet(pointeur+39).getvaleur(); 
				  		break;
				  	}
					  if (quantite == qmaxa){quantite = 0;} else {quantite = quantite + 1;}
					  beep.play();
				  
				  }
			 
			  
			  
			  break;
		  
		  case Input.KEY_ENTER:
		  
		  			
			  beep.play();
		  			
		  			switch (choixq){
		  			case 0 :
		  				choixq = 1;
			  			break;
		  			case 1 :
		  				switch(onglet){
		  				case 0 :
		  					inv.acheter(marchand.getObjet(pointeur),quantite,jq);
		  					break;
		  				case 1 :
		  					inv.acheter(marchand.getObjet(pointeur+20),quantite,jq);
		  					break;
		  				case 2 :
		  					inv.acheter(marchand.getObjet(pointeur+39),quantite,jq);
		  					break;
		  				}
		  					choixq = 0;
		  					quantite = 0;
		  					
		  				
		  				break;
		  				}
		  			
		  		break;
		  			
		  	
		  
		  case Input.KEY_ESCAPE:
			  
			     beep.play();
				  switch (choixq){
				  case 0 :
					  pointeur = 0;
					  game.enterState(Jeu.ID);
					  break;
				  case 1 :
					  choixq = 0;
					  quantite = 0;
					  break;
				  }
				
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
