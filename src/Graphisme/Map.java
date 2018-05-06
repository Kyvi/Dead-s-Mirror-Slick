package Graphisme;

import org.newdawn.slick.Color;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

public class Map {

	private TiledMap tiledMap;
	private int calque;
	
	public Map(){
		
	}
	public void init() throws SlickException {
		this.tiledMap = new TiledMap("/src/package1/ressources/map/carte_jeu.tmx");
		calque=5;
	  }
	 public void renderBackground() {
		 this.tiledMap.render(0, 0, 0);
		 this.tiledMap.render(0, 0, 1);
		 this.tiledMap.render(0, 0, 2);
		this.tiledMap.render(0, 0, 3);
	 }

	public void renderForeground() {
		
	}
	public void setcalque(int i){
		calque=i;
	}
	
	public int getcalque(){
		return calque;
	}
	public boolean isCollision(float x, float y) {
	    int tileW = this.tiledMap.getTileWidth();
	    int tileH = this.tiledMap.getTileHeight();
	    int logicLayer;
	    Image tile;
	    boolean collision;
	    if(calque==0){
	    	logicLayer = this.tiledMap.getLayerIndex("logic5");
		    tile = this.tiledMap.getTileImage((int) x / tileW, (int) y / tileH, logicLayer);
		    collision = tile != null;
		    if (collision) {
		      Color color = tile.getColor((int) x % tileW, (int) y % tileH);
		      collision = color.getAlpha() > 0;
		    }
		    return collision;
	    }else if(calque==1){
	    	logicLayer = this.tiledMap.getLayerIndex("logic4");
		    tile = this.tiledMap.getTileImage((int) x / tileW, (int) y / tileH, logicLayer);
		    collision = tile != null;
		    if (collision) {
		      Color color = tile.getColor((int) x % tileW, (int) y % tileH);
		      collision = color.getAlpha() > 0;
		    }
		    return collision;
	    }else if(calque==2){
	    	logicLayer = this.tiledMap.getLayerIndex("logic3");
		    tile = this.tiledMap.getTileImage((int) x / tileW, (int) y / tileH, logicLayer);
		    collision = tile != null;
		    if (collision) {
		      Color color = tile.getColor((int) x % tileW, (int) y % tileH);
		      collision = color.getAlpha() > 0;
		    }
		    return collision;
	    }else if(calque==3){
	    	logicLayer = this.tiledMap.getLayerIndex("logic2");
		    tile = this.tiledMap.getTileImage((int) x / tileW, (int) y / tileH, logicLayer);
		    collision = tile != null;
		    if (collision) {
		      Color color = tile.getColor((int) x % tileW, (int) y % tileH);
		      collision = color.getAlpha() > 0;
		    }
		    return collision;
	    }else if(calque==4){
	    	logicLayer = this.tiledMap.getLayerIndex("logic1");
		    tile = this.tiledMap.getTileImage((int) x / tileW, (int) y / tileH, logicLayer);
		    collision = tile != null;
		    if (collision) {
		      Color color = tile.getColor((int) x % tileW, (int) y % tileH);
		      collision = color.getAlpha() > 0;
		    }
		    return collision;
	    }else{
	    	logicLayer = this.tiledMap.getLayerIndex("logic");
		    tile = this.tiledMap.getTileImage((int) x / tileW, (int) y / tileH, logicLayer);
		    collision = tile != null;
		    if (collision) {
		      Color color = tile.getColor((int) x % tileW, (int) y % tileH);
		      collision = color.getAlpha() > 0;
		    }
		    return collision;
	    
	    }
	  }
	public boolean isObstacle(float x, float y) {
	    int tileW = this.tiledMap.getTileWidth();
	    int tileH = this.tiledMap.getTileHeight();
	    int logicLayer = this.tiledMap.getLayerIndex("obstacle");
	    Image tile = this.tiledMap.getTileImage((int) x / tileW, (int) y / tileH, logicLayer);
	    boolean obstacle = tile != null;
	    if (obstacle) {
	      Color color = tile.getColor((int) x % tileW, (int) y % tileH);
	      obstacle = color.getAlpha() > 0;
	    }
	    return obstacle;
	  }
	public boolean isPersonne(float x, float y) {
	    int tileW = this.tiledMap.getTileWidth();
	    int tileH = this.tiledMap.getTileHeight();
	    int logicLayer = this.tiledMap.getLayerIndex("personne");
	    Image tile = this.tiledMap.getTileImage((int) x / tileW, (int) y / tileH, logicLayer);
	    boolean personne = tile != null;
	    if (personne) {
	      Color color = tile.getColor((int) x % tileW, (int) y % tileH);
	      personne = color.getAlpha() > 0;
	    }
	    return personne;
	  }
	public boolean isRocher(float x, float y) {
	    int tileW = this.tiledMap.getTileWidth();
	    int tileH = this.tiledMap.getTileHeight();
	    int logicLayer = this.tiledMap.getLayerIndex("rochers");
	    Image tile = this.tiledMap.getTileImage((int) x / tileW, (int) y / tileH, logicLayer);
	    boolean rocher = tile != null;
	    if (rocher) {
	      Color color = tile.getColor((int) x % tileW, (int) y % tileH);
	      rocher = color.getAlpha() > 0;
	    }
	    return rocher;
	  }
	public boolean isForge(float x, float y) {
	    int tileW = this.tiledMap.getTileWidth();
	    int tileH = this.tiledMap.getTileHeight();
	    int logicLayer = this.tiledMap.getLayerIndex("Forge");
	    Image tile = this.tiledMap.getTileImage((int) x / tileW, (int) y / tileH, logicLayer);
	    boolean forge = tile != null;
	    if (forge) {
	      Color color = tile.getColor((int) x % tileW, (int) y % tileH);
	      forge = color.getAlpha() > 0;
	    }
	    return forge;
	  }
	public boolean isZone1(float x, float y) {
	    int tileW = this.tiledMap.getTileWidth();
	    int tileH = this.tiledMap.getTileHeight();
	    int logicLayer = this.tiledMap.getLayerIndex("zone1");
	    Image tile = this.tiledMap.getTileImage((int) x / tileW, (int) y / tileH, logicLayer);
	    boolean zone1 = tile != null;
	    if (zone1) {
	      Color color = tile.getColor((int) x % tileW, (int) y % tileH);
	      zone1 = color.getAlpha() > 0;
	    }
	    return zone1;
	  }
	public boolean isZone2(float x, float y) {
	    int tileW = this.tiledMap.getTileWidth();
	    int tileH = this.tiledMap.getTileHeight();
	    int logicLayer = this.tiledMap.getLayerIndex("zone2");
	    Image tile = this.tiledMap.getTileImage((int) x / tileW, (int) y / tileH, logicLayer);
	    boolean zone2 = tile != null;
	    if (zone2) {
	      Color color = tile.getColor((int) x % tileW, (int) y % tileH);
	      zone2 = color.getAlpha() > 0;
	    }
	    return zone2;
	  }
	public boolean isZone3(float x, float y) {
	    int tileW = this.tiledMap.getTileWidth();
	    int tileH = this.tiledMap.getTileHeight();
	    int logicLayer = this.tiledMap.getLayerIndex("zone3");
	    Image tile = this.tiledMap.getTileImage((int) x / tileW, (int) y / tileH, logicLayer);
	    boolean zone3 = tile != null;
	    if (zone3) {
	      Color color = tile.getColor((int) x % tileW, (int) y % tileH);
	      zone3 = color.getAlpha() > 0;
	    }
	    return zone3;
	  }
	public boolean isZone4(float x, float y) {
	    int tileW = this.tiledMap.getTileWidth();
	    int tileH = this.tiledMap.getTileHeight();
	    int logicLayer = this.tiledMap.getLayerIndex("zone4");
	    Image tile = this.tiledMap.getTileImage((int) x / tileW, (int) y / tileH, logicLayer);
	    boolean zone4 = tile != null;
	    if (zone4) {
	      Color color = tile.getColor((int) x % tileW, (int) y % tileH);
	      zone4 = color.getAlpha() > 0;
	    }
	    return zone4;
	  }
	public boolean isBoss(float x, float y) {
	    int tileW = this.tiledMap.getTileWidth();
	    int tileH = this.tiledMap.getTileHeight();
	    int logicLayer = this.tiledMap.getLayerIndex("boss");
	    Image tile = this.tiledMap.getTileImage((int) x / tileW, (int) y / tileH, logicLayer);
	    boolean boss = tile != null;
	    if (boss) {
	      Color color = tile.getColor((int) x % tileW, (int) y % tileH);
	      boss = color.getAlpha() > 0;
	    }
	    return boss;
	  }
	public boolean isVille1(float x, float y) {
	    int tileW = this.tiledMap.getTileWidth();
	    int tileH = this.tiledMap.getTileHeight();
	    int logicLayer = this.tiledMap.getLayerIndex("ville1");
	    Image tile = this.tiledMap.getTileImage((int) x / tileW, (int) y / tileH, logicLayer);
	    boolean ville1 = tile != null;
	    if (ville1) {
	      Color color = tile.getColor((int) x % tileW, (int) y % tileH);
	      ville1 = color.getAlpha() > 0;
	    }
	    return ville1;
	  }
	public boolean isVille2(float x, float y) {
	    int tileW = this.tiledMap.getTileWidth();
	    int tileH = this.tiledMap.getTileHeight();
	    int logicLayer = this.tiledMap.getLayerIndex("ville2");
	    Image tile = this.tiledMap.getTileImage((int) x / tileW, (int) y / tileH, logicLayer);
	    boolean ville2 = tile != null;
	    if (ville2) {
	      Color color = tile.getColor((int) x % tileW, (int) y % tileH);
	      ville2 = color.getAlpha() > 0;
	    }
	    return ville2;
	  }
	public boolean isVille3(float x, float y) {
	    int tileW = this.tiledMap.getTileWidth();
	    int tileH = this.tiledMap.getTileHeight();
	    int logicLayer = this.tiledMap.getLayerIndex("ville3");
	    Image tile = this.tiledMap.getTileImage((int) x / tileW, (int) y / tileH, logicLayer);
	    boolean ville3 = tile != null;
	    if (ville3) {
	      Color color = tile.getColor((int) x % tileW, (int) y % tileH);
	      ville3 = color.getAlpha() > 0;
	    }
	    return ville3;
	  }
	
}
