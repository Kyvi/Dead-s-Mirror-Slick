package Menu;

public class BattreMonstre extends Quete {

	private int idMonstre;
	private int quantiteMax;
	private int quantiteEnCours;
	
	public BattreMonstre(int i, String in, String d, int t,Objet t1[], int m,int a,int id, int id1, int qmax) {
		super(i, in, d, t,t1,m,a,id);
		idMonstre=id1;
		quantiteMax=qmax;
		quantiteEnCours=0;	
	}
	
	public int getquantiteEnCours(){
		return quantiteEnCours;
	}
	
	public int getquantiteMax(){
		return quantiteMax;
	}

	public void ValiderQuete(int i,Inventaire inv,JournalQuete jq) {
		int k;
		if(i==idMonstre)quantiteEnCours++;
		System.out.println(quantiteEnCours);
		if(i==idMonstre && quantiteMax==quantiteEnCours && jq.getDerniereQuete().getetat()==0){
			setetat(1);
			System.out.println("bouh");
		}
		if(i==idMonstre && quantiteMax==quantiteEnCours && jq.getDerniereQuete().getetat()==2){
			System.out.println("Je suis au bout");
			inv.AjoutArgent(getarg());
			System.out.println("Vous avez gagne : "+ getarg()+" po");
			for(k=0;k<getn();k++){
				inv.PlacerObjet(recompense[k].getidObjet(), 1, jq);
				System.out.println("Vous avez gagne : x1"+recompense[k].getnomObjet());
			}
		}
	}
	
}
