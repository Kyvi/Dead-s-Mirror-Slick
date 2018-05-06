package Menu;

public abstract class Quete {

	private int idQuete;
	private String intitule;
	private String description;
	private int etat;
	private int type;
	protected Objet recompense[];
	private int n;
	private int arg;
	private int idvalid;
	
	public Quete(int i,String in, String d, int t,Objet t1[], int m,int a,int id){
		idQuete=i;
		intitule=in;
		description=d;
		etat=-1;
		type=t;
		n=m;
		arg=a;
		recompense = new Objet[m];
		idvalid=id;
		int j;
		for(j=0;j<m;j++) recompense[j]=t1[j];
		int k;
	}
	public void afficherQuete(){
		System.out.println(intitule+ "  "+idQuete+ "  "+ etat);
	}
	
	
	
	public int getetat(){
		return etat;
	}
	public int getidvalid(){
		return idvalid;
	}
	
	public void setetat(int e){
		etat=e;
	}
	
	public int gettype(){
		return type;
	}
	
	public int getIdQuete(){
		return idQuete;
	}
	
	public String getintitule(){
		return intitule;
	}
	
	public int getn(){
		return n;
	}
	public int getarg(){
		return arg;
	}
	
	public String getDescription(){
		return description;
	}
	
	public abstract void ValiderQuete(int i,Inventaire inv,JournalQuete j);
}
