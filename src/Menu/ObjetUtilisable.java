package Menu;

public class ObjetUtilisable extends Objet {

	private int montantVie;
	private int montantMana;
	private int montantAttaque;
	private int montantDefense;
	public ObjetUtilisable(String s, int i, int v, boolean l, int m, int ma, int a, int d) 
	{
		super(s, i, v, l);
		montantVie=m;
		montantMana=ma;
		montantAttaque=a;
		montantDefense=d;
	}
	
	public int getmontantVie(){
		return montantVie;
	}
	public int getmontantMana(){
		return montantMana;
	}
	public int getmontantAttaque(){
		return montantAttaque;
	}
	public int getmontantDefense(){
		return montantDefense;
	}

}
