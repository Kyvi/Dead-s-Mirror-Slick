package Menu;

public class Objet {

	private String nomObjet;
	private int idObjet;
	private int valeur;
	private boolean lier;
	
	public Objet(String s,int i, int v, boolean l){
		nomObjet=s;
		idObjet=i;
		valeur=v;
		lier = l;
	}
	
	public boolean islier(){
		return lier;
	}
	
	public int getidObjet(){
		return idObjet;
	}
	
	public int getvaleur(){
		return valeur;
	}
	
	public String getnomObjet(){
		return nomObjet;
	}
}
