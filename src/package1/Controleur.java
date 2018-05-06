package package1;

import org.newdawn.slick.Input;
import org.newdawn.slick.KeyListener;
import org.newdawn.slick.state.StateBasedGame;

import Menu.AchatGameState;
import Menu.VenteGameState;

public class Controleur implements KeyListener{

	 private Joueur player;
	 private StateBasedGame game;
	 private Jeu jeu;

	 public Controleur(Joueur player,StateBasedGame game,Jeu j) {
	    this.player = player;
	    this.game=game;
	    this.jeu=j;
	 }
	  
	public void setInput(Input input) { }

	 
	  public boolean isAcceptingInput() { return true; }
	 
	  
	  public void inputEnded() { }

	  
	  public void inputStarted() { }

	  
	  public void keyPressed(int key, char c) {
		  switch (key) {
		  case Input.KEY_UP:
			  if(this.player.getvar()==0){
				  this.player.setDirection(0);
				  this.player.setMoving(true);
			  }else{
				  if(player.getpointeur()==20)player.setpointeur(0);
			  }
		    break;
		  case Input.KEY_LEFT:
			  if(this.player.getvar()==0){
				  this.player.setDirection(1);
				  this.player.setMoving(true);
			  }
		    break;
		  case Input.KEY_DOWN:
			  if(this.player.getvar()==0){
				  this.player.setDirection(2);
				  this.player.setMoving(true);
			  }else{
				  if(player.getpointeur()==0)player.setpointeur(20);
			  }
		    break;
		  case Input.KEY_RIGHT:
			  if(this.player.getvar()==0){
				  this.player.setDirection(3);
				  this.player.setMoving(true);
			  }
		    break;
		  case Input.KEY_SPACE:
			if(this.player.isInteracting()==false && this.player.getvar()==0) {
				this.player.setMoving(false);
				this.player.setInteracting(true);
				this.player.setMenu(1);
				
			}else if(this.player.getvar()==1){
				this.player.setMoving(true);
				this.player.setInteracting(false);
				this.player.setvar(0);
				this.player.setMenu(0);
				
			}
		  case Input.KEY_ENTER:
			  if(player.getvar()==1){
				if(player.gettype()==1){
					if(player.getjeu().getperso(player.getindice()).getidPersonne()>=10 && player.getjeu().getperso(player.getindice()).getidPersonne()<=11){
						if(player.getMetier().getidMetier()==0 && player.getfindial()==1){
							if(player.getchoixapp()==0){
								if(player.getpointeur()==0){
									player.setchoixapp(1);
								}else player.setchoixapp(2);
							}else{
								if(player.getpointeur()==0){
									player.setmetier(1);
								}
								else{
									player.setmetier(2);
								}
							}
						}else if(player.getMetier().getidMetier()!=0 && player.getfindial()==1){
							if(player.getpointeur()==0)player.setchoixoubl(1);
							else player.setchoixoubl(2);
						}
					}else if(player.getjeu().getperso(player.getindice()).getidPersonne()>=12 && player.getjeu().getperso(player.getindice()).getidPersonne()<=14){
						if(player.getchoix()==0){
							if(player.getpointeur()==0){
								game.enterState(AchatGameState.ID);
								player.setchoix(1);
							}
							else {
								game.enterState(VenteGameState.ID);
								player.setchoix(1);
							}
						}
					}
				}else if(player.gettype()==4) {
					if(jeu.getboss().getcombat()==0){
						if(player.getpointeur()==0){
							jeu.getboss().setcombat(1);
						}else{
							jeu.getboss().setcombat(2);
						
						}
					}
				}
			  }else{
				  player.settour(0);
				  player.setmetier(0);
				  player.setchoixoubl(0);
				  player.setchoixapp(0);
				  player.setchoix(0);
			  }
		  }
	  }

	 
	  public void keyReleased(int key, char c) { 
		  this.player.setMoving(false);
		  this.player.setInteracting(false);
		  
	  }
}
