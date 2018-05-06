package Principal;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Splash extends JFrame{

	private Splashpanel p;
	
	public Splash(String titre, int x, int y, int l, int h){
		setTitle(titre);
		this.setBackground(Color.BLACK);
		setBounds(x,y,l,h);
		 p = new Splashpanel();
		add(p);
		}
	
	public void setnot(){
		this.setVisible(false);
	}
	
	public Splashpanel getsp(){
		return p;
	}
	
	
	
	
}
