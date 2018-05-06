package Menu;

public class ParlerAQq extends Quete{

	private int idPersonne;
	
	public ParlerAQq(int i, String in, String d, int t,Objet t1[], int m,int a,int id, int id1) {
		super(i, in, d, t,t1,m,a,id);
		idPersonne=id1;
	}
	public int getidPersonne(){
		return idPersonne;
	}

	public void ValiderQuete(int i,Inventaire inv,JournalQuete jq) {
		int k;
		if(i==idPersonne && getetat()==0){
			setetat(1);
		}
		if(i==idPersonne && getetat()==2){
			inv.AjoutArgent(getarg());
			for(k=0;k<getn();k++){
				inv.PlacerObjet(recompense[k].getidObjet(), 1, jq);
				System.out.println("Objet ajoute!");
			}
		}
	}
	
	
}
