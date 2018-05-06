package Menu;

public class JournalQuete {

	private Quete tableauquete[];
	private int i;
	
	public JournalQuete(Quete t[],int n){
		tableauquete = new Quete[n];
		int j;
		for(j=0;j<n;j++) tableauquete[j]=t[j];
		i=0;
	}
	
	public int geti(){
		return i;
	}
	public int getboni(){
		if(tableauquete[i].getetat()==-1)return i-1;
		else return i;
	}
	public void incrementei(){
		i++;
	}
	public Quete getDerniereQuete(){
		return tableauquete[i];
	}
	public Quete getQuete(int k){
		return tableauquete[k];
	}
	public void afficherJournalQuete(){
		int j;
		String s;
		for(j=0;j<=i;j++){
			if(tableauquete[j].getetat()==0)s="En cours";
			else if(tableauquete[j].getetat()==1)s="En attente de validation";
			else if(tableauquete[j].getetat()==2)s="Validee";
			else s="Pas encore donné";
			if(tableauquete[j].getetat()>-1){
				System.out.println("Intitule :"+tableauquete[j].getintitule());
				System.out.println("Description :"+tableauquete[j].getDescription());
				System.out.println("Etat :"+s+"\n");
			}
		}
	}
}
