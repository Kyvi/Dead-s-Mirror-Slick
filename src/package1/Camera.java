package package1;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class Camera {

	private Joueur player;
	private float xCamera, yCamera;
	
	public Camera(Joueur player) {
		this.player = player;
		this.xCamera = player.getX();
		this.yCamera = player.getY();
	}
	public void place(GameContainer container, Graphics g) {
		  g.translate(container.getWidth() / 2 - (int) this.xCamera ,container.getHeight() / 2 - (int) this.yCamera);
	}
	public void update(GameContainer container) {
		  int w = container.getWidth() / 4;
		  if (this.player.getX() > this.xCamera + w) {
		    this.xCamera = this.player.getX() - w;
		  } else if (this.player.getX() < this.xCamera - w) {
		    this.xCamera = this.player.getX() + w;
		  }
		  int h = container.getHeight() / 4;
		  if (this.player.getY() > this.yCamera + h) {
		    this.yCamera = this.player.getY() - h;
		  } else if (this.player.getY() < this.yCamera - h) {
		    this.yCamera = this.player.getY() + h;
		  }
	}
	public void render(Graphics g)throws SlickException{
		g.setColor(new Color(255,255,255));
        
	}
	public float getXCamera(){
		return xCamera;
	}
	public float getYCamera(){
		return yCamera;
	}
}
