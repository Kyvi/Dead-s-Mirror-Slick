package Principal;

import metier.ForgeGameState;

import javax.swing.JFrame;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import Menu.AchatGameState;
import Menu.CaracteristiqueGameState;
import Menu.EquipementGameState;
import Menu.InventaireGameState;
import Menu.JournalGameState;
import Menu.MenuGameState;
import Menu.VenteGameState;



import package1.Jeu;
import package1.MainScreenGameState;
import package1.PseudoGameState;
import package1.Chargement;
import package1.EndGameState;

public class StateGame extends StateBasedGame {

	private static Splash s = new Splash("Dead's Mirror",240,80,800,620);;
	
	 public static void main(String[] args) throws SlickException {
		 	
		 	AppGameContainer agc = new AppGameContainer(new StateGame(), 800, 600, false);
		 	agc.setShowFPS(false);
		 	
		 	s.setVisible(true);
		 	s.setAlwaysOnTop(true);
		 	agc.setAlwaysRender(false);
		 	agc.start();
		 	
	}
	public StateGame() {
		super("Dead's Mirror");
	}
	
	 
	

	public void initStatesList(GameContainer container) throws SlickException {
		
		Jeu jeu=new Jeu(s);
		addState(new MainScreenGameState(s));
	    addState(new PseudoGameState(jeu,jeu.getplayer()));
	    addState(jeu);
	    addState(new Chargement(jeu));
	    addState(new BattleGameState(jeu,20,s));
	    addState(new BattleGameState(jeu,21,s));
	    addState(new BattleGameState(jeu,22,s));
	    addState(new BattleGameState(jeu,23,s));
	    addState(new BattleGameState(jeu,24,s));
	    addState(new BattleGameState(jeu,25,s));
	    addState(new BattleGameState(jeu,26,s));
	    addState(new BattleGameState(jeu,27,s));
	    addState(new BattleGameState(jeu,28,s));
	    addState(new BattleGameState(jeu,29,s));
	    addState(new BattleGameState(jeu,30,s));
	    addState(new BattleGameState(jeu,31,s));
	    addState(new BattleGameState(jeu,32,s));
	    addState(new BattleGameState(jeu,33,s));
	    addState(new BattleGameState(jeu,34,s));
	    addState(new BattleGameState(jeu,35,s));
	    addState(new BattleGameState(jeu,36,s));
	    addState(new BattleGameState(jeu,37,s));
	    addState(new BattleGameState(jeu,38,s));
	    addState(new BattleGameState(jeu,39,s));
	    addState(new BattleGameState(jeu,40,s));
	    addState(new BattleGameState(jeu,41,s));
	    addState(new BattleGameState(jeu,42,s));
	    addState(new BattleGameState(jeu,43,s));
	    addState(new BattleGameState(jeu,44,s));
	    addState(new MenuGameState(jeu));
	    addState(new InventaireGameState(jeu,jeu.getinventaire(),jeu.getjq(),jeu.getplayer(),jeu.geteq()));
	    addState(new JournalGameState(jeu,jeu.getinventaire(),jeu.getjq(),jeu.getplayer(),jeu.geteq()));
	    addState(new EquipementGameState(jeu,jeu.getinventaire(),jeu.getjq(),jeu.getplayer(),jeu.geteq()));
	    addState(new CaracteristiqueGameState(jeu,jeu.getplayer()));
	    addState(new VenteGameState(jeu,jeu.getinventaire(),jeu.getjq()));
	    addState(new AchatGameState(jeu,jeu.getinventaire(),jeu.getjq(),jeu.getmarchand()));
	    addState(new ForgeGameState(jeu,jeu.getforge()));
	    addState(new EndGameState(jeu));
	}

	
}
