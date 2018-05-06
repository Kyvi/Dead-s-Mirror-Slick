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
import org.newdawn.slick.Color;

import package1.Equipable;
import package1.Equipement;
import package1.Jeu;
import package1.Joueur;

import Menu.Inventaire;
import Menu.Objet;

public class InventaireGameState extends BasicGameState {

	  public static final int ID = 5;
	  private Image background;
	  private StateBasedGame game;
	  private int jeter = 0;
	  private int quantite = 1;
	  private int pointeur = 0;
	  private int varoption = 0;
	  private int decision;
	  private int impossible = 0;
	  private boolean lier;
	  private Jeu jeu;
	  private Inventaire inv;
	  private JournalQuete jq;
	  private Joueur player;
	  private Equipement equipement;
	  private Sound beep;
	  private int onglet = 0;
	  
	public InventaireGameState(Jeu j,Inventaire inven,JournalQuete jourq,Joueur jo,Equipement eq){
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
	    g.setColor(new Color(0,0,0,100));
	    g.fillRect(75, 70, 250, 510);
	    g.setColor(Color.black);
	    
	    g.drawString("Inventaire", 100, 25);
	    g.drawString(player.getnom(), 500, 50);
	    g.drawString("Argent : " + inv.getquantiteArgent(), 500, 75);
	    
	    
	    switch (onglet){
	    
	    case 0 :
		    // onglet utilisable 
		    
	    	g.setColor(Color.white);
	    	g.drawString("<- Objets Utilisables ->", 100, 75);
		    int i = 0;
		    int j = 0;
		    if(inv.NombreUtilisablePresent()>0){
		    	while(j<pointeur && j< inv.NombreUtilisablePresent()){
		    		if (inv.getObjet(i)!=null)
		    		{if(inv.getquantiteObjet(inv.getObjet(i).getidObjet())>0 && inv.getObjet(i).getidObjet()<20){
		    			if (j<pointeur-15){} else{
		    			g.drawString(inv.getObjet(i).getnomObjet(), 100,(j+5-Math.max(0, pointeur-15))*25);}
		    			j++;
		    		}}
		    		i++;
		    	}
		    	
		    	g.setColor(new Color(0,0,255,100));
		    	g.fillRect(100,(j+5-Math.max(0, pointeur-15))*25, 200, 20);
		    	
		    	g.setColor(Color.black);
		    	
		    	Objet ob = inv.getUtilisablePresent(pointeur);
		    	int id = ob.getidObjet();
		    	g.drawString(ob.getnomObjet(), 500, 150);
		    	g.drawString("Quantite possedee : " + inv.getquantiteObjet(id), 500, 175);
		    	g.drawString("Valeur : " + ob.getvaleur(), 500, 200);
		    	if (0<=id && id<20)
		    		{	
		    			g.drawString("Objet utilisable en combat", 500, 250);
		    			if (id<5) g.drawString("Montant vie : " + ((ObjetUtilisable) ob).getmontantVie() , 500, 275);
		    			if (id>=5 && id<10) g.drawString("Montant mana : " + ((ObjetUtilisable) ob).getmontantMana() , 500, 275);
		    			if (id>=10 && id<15) g.drawString("Montant attaque : " + ((ObjetUtilisable) ob).getmontantAttaque() , 500, 275);
		    			if (id>=15 && id<20) g.drawString("Montant defense : " + ((ObjetUtilisable) ob).getmontantDefense() , 500, 275);
		    		}
		    	g.setColor(Color.white);
		    	while(j< inv.NombreUtilisablePresent()){
		    		if (inv.getObjet(i)!=null)
		    		{if(inv.getquantiteObjet(inv.getObjet(i).getidObjet())>0 && inv.getObjet(i).getidObjet()<20){
		    			if (j>Math.max(pointeur,15)){} else
		    			{g.drawString(inv.getObjet(i).getnomObjet(), 100, (j+5-Math.max(0, pointeur-15))*25);}
		    			j++;
		    		}}
		    		i++;
			  
		    	}
		    }else{
		    	g.drawString("<- Objets Utilisables ->", 100, 75);
		    	g.drawString("Aucun objet", 100, 125);
		    }
		    break;
	    
	    case 1 :
	    	// Onglet Equipable
	    	
	    	g.setColor(Color.white);
	    	g.drawString("<- Objets Equipables ->", 100, 75);
		    int i2 = 20;
		    int j2 = 0;
		    if(inv.NombreEquipablePresent()>0){
		    	while(j2<pointeur && j2< inv.NombreEquipablePresent()){
		    		if (inv.getObjet(i2)!=null)
		    		{if(inv.getquantiteObjet(inv.getObjet(i2).getidObjet())>0 && inv.getObjet(i2).getidObjet()>=20 && inv.getObjet(i2).getidObjet()<40 ){
		    			if (j2<pointeur-15){} else{
		    			g.drawString(inv.getObjet(i2).getnomObjet(), 100,(j2+5-Math.max(0, pointeur-15))*25);}
		    			j2++;
		    		}}
		    		i2++;
		    	}
		    	
		    	g.setColor(new Color(0,0,255,100));
		    	g.fillRect(100,(j2+5-Math.max(0, pointeur-15))*25, 200, 20);
		    	
		    	g.setColor(Color.black);
		    	
		    	
		    	Objet ob = inv.getEquipablePresent(pointeur);
		    	
		    	// Dessin des armures
		 	   
		 	   g.drawOval(350, 50, 30, 30); // tete
		 	   g.drawRect(335, 80, 60, 60); // corps
		 	   g.drawRect(415,50,10,50); // epee
		 	   g.drawRect(400, 100, 40, 10); // poignet epee
		 	   g.drawRect(415, 110, 10, 20); // manche epee
		 	   
		 	   g.setColor(Color.red);
		 	   switch(((Equipable) ob).gettypeEqu()){
		 	   case 0 : // tete
		 		   g.fillOval(350, 50, 30, 30);
		 		   break;
		 	   case 1 : // corps
		 		   g.fillRect(335, 80, 60, 60); 
		 		   break;
		 	   case 2 : // epee
		 		   g.fillRect(415,50,10,50);
		 		   g.fillRect(400, 100, 40, 10);
		 		   g.fillRect(415, 110, 10, 20);
		 		   break;
		 	   }
		 	   g.setColor(Color.black);
		    	int id = ob.getidObjet();
		    	g.drawString(ob.getnomObjet(), 500, 150);
		    	g.drawString("Quantite possedee : " + inv.getquantiteObjet(id), 500, 175);
		    	g.drawString("Valeur : " + ob.getvaleur(), 500, 200);
		    	if (20<=id && id<40)
				{
					g.drawString("Objet pouvant etre equipe", 500, 250);
					g.drawString("Niveau de l'equipement : " + ((Equipable) ob).getniveauEquipable() , 500, 275);
					g.drawString("Vie apportee : " + ((Equipable) ob).getvieEquipable() , 500, 300);
					g.drawString("Attaque apportee : " + ((Equipable) ob).getattaqueEquipable() , 500, 325);
					g.drawString("Defense apportee : " + ((Equipable) ob).getdefenseEquipable() , 500, 350);
				}
		    	g.setColor(Color.white);
	
		    	while(j2< inv.NombreEquipablePresent()){
		    		if (inv.getObjet(i2)!=null)
		    		{if(inv.getquantiteObjet(inv.getObjet(i2).getidObjet())>0 && inv.getObjet(i2).getidObjet()>=20 && inv.getObjet(i2).getidObjet()<40){
		    			if (j2>Math.max(pointeur,15)){} else
		    			{g.drawString(inv.getObjet(i2).getnomObjet(), 100, (j2+5-Math.max(0, pointeur-15))*25);}
		    			j2++;
		    		}}
		    		i2++;
			  
		    	}
		    }else{
		    	g.drawString("<- Objets Equipables ->", 100, 75);
		    	g.drawString("Aucun objet", 100, 125);
		        
		    }
		    
		    break;
	    
	    case 2 :
	    	
	    	// Autres
	    	g.setColor(Color.white);
	    	g.drawString("<- Autres ->", 100, 75);
	    	int i3 = 40;
		    int j3 = 0;
		    if(inv.NombreAutrePresent()>0){
		    	while(j3<pointeur && j3< inv.NombreAutrePresent()){
		    		if (inv.getObjet(i3)!=null)
		    		{if(inv.getquantiteObjet(inv.getObjet(i3).getidObjet())>0 && inv.getObjet(i3).getidObjet()>39){
		    			if (j3<pointeur-15){} else{
		    			g.drawString(inv.getObjet(i3).getnomObjet(), 100,(j3+5-Math.max(0, pointeur-15))*25);}
		    			j3++;
		    		}}
		    		i3++;
		    	}
		    	
		    	g.setColor(new Color(0,0,255,100));
		    	g.fillRect(100,(j3+5-Math.max(0, pointeur-15))*25, 200, 20);
		    	
		    	g.setColor(Color.black);
		    	
		    	Objet ob = inv.getAutrePresent(pointeur);
		    	int id = ob.getidObjet();
		    	g.drawString(ob.getnomObjet(), 500, 150);
		    	g.drawString("Quantite possedee : " + inv.getquantiteObjet(id), 500, 175);
		    	g.drawString("Valeur : " + ob.getvaleur(), 500, 200);
		    	g.setColor(Color.white);
		    	
	
		    	while(j3< inv.NombreAutrePresent()){
		    		if (inv.getObjet(i3)!=null)
		    		{if(inv.getquantiteObjet(inv.getObjet(i3).getidObjet())>0 && inv.getObjet(i3).getidObjet()>39){
		    			if (j3>Math.max(pointeur,15)){} else{
		    			g.drawString(inv.getObjet(i3).getnomObjet(), 100, (j3+5-Math.max(0, pointeur-15))*25);}
		    			j3++;
		    		}}
		    		i3++;
			  
		    	}
		    }else{
		    	g.drawString("<- Autres ->", 100, 75);
		    	g.drawString("Aucun objet", 100, 125);
		       
		    }
		    
		    break;
	    }
	    
	    g.setColor(Color.black);
	    
	   
	   if (varoption == 1){
		   g.setColor(new Color(0,0,255,100));
		   g.fillRect(500, 400, 150, 20);
		   g.setColor(Color.black);
		   g.drawString("Jeter Objet", 500, 400);
	   }
	   else{
		   if (varoption == 2){
			   if (decision == 0){
				   g.setColor(new Color(0,0,255,100));
				   g.fillRect(500, 400, 150, 20);
				   g.setColor(Color.black);
				   g.drawString("Equiper Objet", 500, 400);
				   g.drawString("Jeter Objet", 500, 425);
			   }
			   else {
				   g.setColor(Color.black);
				   g.drawString("Equiper Objet", 500, 400);
				   g.setColor(new Color(0,0,255,100));
				   g.fillRect(500, 425, 150, 20);
				   g.setColor(Color.black);
				   g.drawString("Jeter Objet", 500, 425);
				   
			   }
		   }
	   }
	   
	   if (impossible == 1){
		   g.drawString("Vous n'avez pas le niveau requis", 500, 550);
	   }
	   
	   if (jeter == 1) {
		   g.drawString("Quantite ?", 500, 475);
		   g.drawString(Integer.toString(quantite), 500, 500);
	   }
	   
	   if (lier){
		   g.drawString("Vous ne pouvez pas faire ça !", 500, 475);
	   }
	   
	   if (varoption==2 && decision==0){
		  Equipable eq = (Equipable) inv.getEquipablePresent(pointeur);
		  Equipable eqbis = equipement.getEquipable( eq.gettypeEqu());
		  if(eqbis==null)
		  	{
			  g.drawString("Vie :", 500, 475);
			  g.drawString(player.getvieMax() + " -> " , 600,475);
			  g.drawString("Attaque :", 500, 500);
			  g.drawString(player.getattaque() + " -> " , 600,500);
			  g.drawString("Defense :", 500, 525);
			  g.drawString(player.getdefense() + " -> ", 600,525);
			  g.setColor(new Color(24,158,28));
			  g.drawString(Integer.toString(player.getvieMax()+eq.getvieEquipable()), 660, 475);
			  g.drawString(Integer.toString(player.getattaque()+eq.getattaqueEquipable()), 660, 500);
			  g.drawString(Integer.toString(player.getdefense()+eq.getdefenseEquipable()), 660, 525);
		  	}
		  else
		  {
			  g.drawString("Vie :", 500, 475);
			  g.drawString(player.getvieMax() + " -> ", 600,475);
			  g.drawString("Attaque :", 500, 500);
			  g.drawString(player.getattaque() + " -> ", 600,500);
			  g.drawString("Defense :", 500, 525);
			  g.drawString(player.getdefense() + " -> ", 600,525);
			  if (eqbis.getvieEquipable()<eq.getvieEquipable())
			  { g.setColor(new Color(24,158,28));} else {if (eqbis.getvieEquipable()>eq.getvieEquipable()) {g.setColor(Color.red);}}
			g.drawString(Integer.toString(player.getvieMax() - eqbis.getvieEquipable() + eq.getvieEquipable()), 660,475);
			  if (eqbis.getattaqueEquipable()<eq.getattaqueEquipable())
			  { g.setColor(new Color(24,158,28));} else {if (eqbis.getvieEquipable()>eq.getvieEquipable()) {g.setColor(Color.red);}}
			g.drawString(Integer.toString(player.getattaque() - eqbis.getattaqueEquipable() + eq.getattaqueEquipable()), 660,500);
			  if (eqbis.getvieEquipable()<eq.getvieEquipable())
			  { g.setColor(new Color(24,158,28));} else {if (eqbis.getvieEquipable()>eq.getvieEquipable()) {g.setColor(Color.red);}}
			g.drawString(Integer.toString(player.getdefense() - eqbis.getdefenseEquipable() + eq.getdefenseEquipable()), 660,525);
			g.setColor(Color.black);
			  
		  }
	   
	   
	   }
	}

	 
	  @Override
	  public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
	  }

	 
	  public void keyPressed(int key, char c) {
		  switch (key) {
		  case Input.KEY_UP:
			  
			  if (varoption == 0){ beep.play();
				  if (pointeur==0) { 
					  switch (onglet){
					  case 0 :
						  pointeur = inv.NombreUtilisablePresent()-1;
						  break;
					  case 1 :
						  pointeur = inv.NombreEquipablePresent()-1;
						  break;
					  case 2 :
						  pointeur = inv.NombreAutrePresent()-1;
						  break;
					  }
					  }
				  else { pointeur = pointeur - 1;}}
			  else { if (jeter == 0)
				  	{ beep.play();
				  if(varoption == 1){decision = 0;}
			  		else{decision = (1-decision);}}
			  		}
			  impossible = 0;
			 
		    
		    break;
		  case Input.KEY_LEFT:
			  
			  if (varoption == 0){
				  beep.play();
				  pointeur = 0;
				  if (onglet == 0) { onglet = 2;}
				  else {onglet--;}
			  }
			  if (jeter == 1){ beep.play();
				  int qmax = inv.getquantiteObjet(inv.getObjetPresent(pointeur).getidObjet());
				  if (quantite == 1){quantite=qmax;} else {quantite = quantite - 1;}
			  }
			  
			  break;
		    
		    
		  case Input.KEY_DOWN:
			
			  
			  if (varoption == 0){ beep.play();
			  switch (onglet){
			  case 0 :
				  if (pointeur==inv.NombreUtilisablePresent()-1) { pointeur = 0;}
				  else { pointeur = pointeur + 1;}
				  break;
			  case 1 :
				  if (pointeur==inv.NombreEquipablePresent()-1) { pointeur = 0;}
				  else { pointeur = pointeur + 1;}
				  break;
			  case 2 :
				  if (pointeur==inv.NombreAutrePresent()-1) { pointeur = 0;}
				  else { pointeur = pointeur + 1;}
				  break;
			  }
			  }
				  
			  else {if (jeter == 0)
				  {beep.play(); if(varoption == 1){decision = 0;}
		  		else{decision = (1-decision);}}
		  		}
			  impossible = 0;
			 
			  
		   
		    break;
		    
		  case Input.KEY_RIGHT:
			  
			  if (varoption == 0){
				  beep.play();
				  pointeur = 0;
				  if (onglet == 2) { onglet = 0;}
				  else {onglet++;}
			  }
			  if (jeter == 1){ beep.play();
				  int qmax2 = inv.getquantiteObjet(inv.getObjetPresent(pointeur).getidObjet());
				  if (quantite == qmax2){quantite=1;} else {quantite = quantite + 1;}
			  }
			  
			  break;
		  
		  case Input.KEY_ENTER:
			  
			  switch (onglet){
				  
			  case 0 :
				  if (inv.NombreUtilisablePresent()>0){
					  beep.play();
					  switch (varoption){
					  
					  case 0 :
						  System.out.println("varoption change ?");
					  varoption = 1;
					  break;
					  
					  case 1 :
						  
						  switch (jeter){
						  
						  case 0 :
							  
							  if (!inv.getUtilisablePresent(pointeur).islier()) 
						  	{jeter = 1;} else{lier = true;}
						  	break;
						  	
						  case 1 :
							  
							  int idobj = inv.getUtilisablePresent(pointeur).getidObjet();
							  inv.RetirerObjet(idobj,quantite,jq);
							 		if (inv.getquantiteObjet(idobj)==0) 
							 			{ if (inv.NombreUtilisablePresent()>0 && pointeur!=0) pointeur = pointeur -1;
							 						else {pointeur = 0;}
							 				varoption = 0;
							 			}
							  jeter = 0;
							  quantite = 1;
							  
							 break;
							  
						  	}
						  
						 break;

					  
				  }}
				  break;
				  
			  case 1 :
				  if (inv.NombreEquipablePresent()>0){
					  beep.play();
					  switch (varoption){
					  
					  case 0 :
						  
					  varoption = 2;
					  break;
					  
					  case 2 :
						  
						  int idobj2 = inv.getEquipablePresent(pointeur).getidObjet();
						  switch (decision){
						  
						  case 1 :
							  
							  switch (jeter){
							  
							  case 0 :
								  if (!inv.getEquipablePresent(pointeur).islier()) 
								  	{jeter = 1;}
								  else {lier = true;}
								  	break;
								  	
							  case 1 :
								  
								  inv.RetirerObjet(idobj2,quantite,jq);
								  
							 		if (inv.getquantiteObjet(idobj2)==0) 
							 			{ if (inv.NombreEquipablePresent()>0 && pointeur!=0) pointeur = pointeur -1;
							 						else {pointeur = 0;}
							 				varoption = 0;
							 			} 
							 		jeter = 0;
									quantite = 1;
							 		
							 		break;
							  
							  }
							  
							 break;
							  
						  case 0 :
							  
							  Equipable eq=(Equipable) inv.getEquipablePresent(pointeur);
							  if (eq.getniveauEquipable()>player.getniveau())
							  { impossible = 1;}
							  else
							  {eq.equiperGeneral(inv,player,equipement,jq, jeu.getbp());
							  if(inv.getquantiteObjet(eq.getidObjet())==0)
							  	{ if (inv.NombreEquipablePresent()>0 && pointeur!=0) pointeur = pointeur -1;
							  		else {pointeur = 0;}
							  		varoption = 0; decision = 0;
							  	} 
							  }
							  break;
							  
						  }
						  
						  
						 
				  }}
				  
				  break;
			  case 2 :
				  if (inv.NombreAutrePresent()>0){
					  beep.play();
					  switch (varoption){
					  
					  case 0 :
						  
					  varoption = 1;
					  break;
					  
					  case 1 :
						  
						  switch (jeter){
						  
						  case 0 :
							  
							  if (!inv.getAutrePresent(pointeur).islier()) 
						  	{jeter = 1;} else{lier = true;}
						  	break;
						  	
						  case 1 :
							  
							  int idobj = inv.getAutrePresent(pointeur).getidObjet();
							  inv.RetirerObjet(idobj,quantite,jq);
							 		if (inv.getquantiteObjet(idobj)==0) 
							 			{ if (inv.NombreAutrePresent()>0 && pointeur!=0) pointeur = pointeur -1;
							 						else {pointeur = 0;}
							 				varoption = 0;
							 			}
							  jeter = 0;
							  quantite = 1;
							  
							 break;
							  
						  	}
						  
						 break;

				  }}
			  
			  
		  break;
			  }
			  break;
		  case Input.KEY_ESCAPE:
			  beep.play();
			  if(varoption == 0){
				  pointeur = 0;
				  impossible = 0;
				  game.enterState(MenuGameState.ID);
			  }
			  else{ if(jeter == 0) {varoption = 0; impossible = 0; lier=false;}
			  		else {jeter = 0; quantite = 1;}}
			  
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
