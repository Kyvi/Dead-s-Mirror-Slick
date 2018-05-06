package Combat;

public class Attaque {

	protected String nomAttaque;
	protected int puissanceAttaque;
	protected int idAttaque;
	private int manaRequis;
	private int niveauRequis;
	
	public Attaque(String na, int pa, int ida,int mr,int nr){
		nomAttaque = na;
		puissanceAttaque = pa;
		idAttaque = ida;
		manaRequis=mr;
		niveauRequis=nr;
	}
	
	public int getpuissanceAttaque(){
		return puissanceAttaque;
	}
	public int getmanaRequis(){
		return manaRequis;
	}
	public String getnomAttaque(){
		return nomAttaque;
	}
	public int getniveauRequis(){
		return niveauRequis;
	}
}
