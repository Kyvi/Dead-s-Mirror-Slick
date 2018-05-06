package Menu;

import package1.Equipable;

public class Inventaire {

	public int quantiteObjet[];
	private int quantiteArgent;
	private int nombreObjet;
	private Objet tableauObjet[];
	
	public Inventaire(int n, Objet t[]){
		nombreObjet = n;
		quantiteObjet = new int[n];
		tableauObjet = new Objet[n];
		int i;
		quantiteArgent=200;
		for(i=0;i<n;i++)tableauObjet[i]=t[i];
	}
	
	public int getquantiteObjet(int n){
		return quantiteObjet[n];
	}
	public int getargent(){
		return quantiteArgent;
	}
	public void setargent(int i){
		quantiteArgent=i;
	}
	
	
	public void setquantiteObjet(int i,int q){
	
		quantiteObjet[i]=quantiteObjet[i]+q;
	}
	public void settableauObjet(int i,Objet o){
		tableauObjet[i]=o;
	}
	public Objet getObjetPresent(int i){
		int j=0,k=0;
		while(j<nombreObjet && k<=i){
			if(quantiteObjet[j]!=0)k++;
			j++;
		}
		return tableauObjet[j-1];
	}
	
	public ObjetUtilisable getUtilisablePresent(int i){
		int j=0,k=0;
		while(j<20 && k<=i){
			if(quantiteObjet[j]!=0)k++;
			j++;
		}
		return (ObjetUtilisable) tableauObjet[j-1];
	}
	
	public Equipable getEquipablePresent(int i){
		int j=20,k=0;
		while(j<40 && k<=i){
			if(quantiteObjet[j]!=0)k++;
			j++;
		}
		return (Equipable) tableauObjet[j-1];
	}
	
	public Objet getAutrePresent(int i){
		int j=40,k=0;
		while(j<70 && k<=i){
			if(quantiteObjet[j]!=0)k++;
			j++;
		}
		return tableauObjet[j-1];
	}
	
	public Objet getObjet(int i){
		return tableauObjet[i];
	}
	public int getquantiteArgent(){
		return quantiteArgent;
	}
	public int getnombreobjet(){
		return nombreObjet;
	}
	
	public void PlacerObjet(int i,int q,JournalQuete j){ // Il faudra recuperer l'id de l'objet
		quantiteObjet[i]=quantiteObjet[i]+q;
		if(j.getDerniereQuete().gettype()==0){
			j.getDerniereQuete().ValiderQuete(0,this,j);
		}
	}
	
	public void RetirerObjet(int i,int q,JournalQuete j){ // Il faudra recuperer l'id de l'objet
		if(quantiteObjet[i]>=q) quantiteObjet[i]=quantiteObjet[i]-q;
		if(j.getDerniereQuete().gettype()==0){
			j.getDerniereQuete().ValiderQuete(0,this,j);
		}
	}
	public void AjoutArgent(int q){
		quantiteArgent=quantiteArgent+q;
	}
	
	public void RetirerArgent(int q){
		quantiteArgent=quantiteArgent-q;
	}
	
	public void acheter(Objet Objet,int q,JournalQuete j){
		if(quantiteArgent>=q*Objet.getvaleur()){
			PlacerObjet(Objet.getidObjet(),q,j);
			RetirerArgent(q*Objet.getvaleur());
			System.out.println("Vous avez achete : x"+q+" "+Objet.getnomObjet());
		}
		else System.out.println("Pas assez d'argent.\n");
	}
	
	public void vendre(Objet Objet,int q,JournalQuete j){
		if(quantiteObjet[Objet.getidObjet()]>=q){
			RetirerObjet(Objet.getidObjet(),q,j);
			AjoutArgent(q*Objet.getvaleur());
			System.out.println("Vous avez vendu : x"+q+" "+Objet.getnomObjet());
		}
		else System.out.println("Pas assez de fois l'objet selectionne");
	}
	public int NombreObjetPresent(){
		int i,s;
		s=0;
		for(i=0;i<nombreObjet;i++){
			if(quantiteObjet[i]>0)s++;
		}
		return s;
	}
	
	public int NombreUtilisablePresent(){
		int i,s;
		s=0;
		for(i=0;i<20;i++){
			if(quantiteObjet[i]>0)s++;
		}
		return s;
	}
	
	public int NombreEquipablePresent(){
		int i,s;
		s=0;
		for(i=20;i<40;i++){
			if(quantiteObjet[i]>0)s++;
		}
		return s;
	}
	
	public int NombreAutrePresent(){
		int i,s;
		s=0;
		for(i=40;i<70;i++){
			if(quantiteObjet[i]>0)s++;
		}
		return s;
	}
	
	public void AfficherInventaire(){
		int i;
		for(i=0;i<nombreObjet;i++){
			if(tableauObjet[i]!=null){
				if(quantiteObjet[i]>0)System.out.println(i+" : "+tableauObjet[i].getnomObjet()+" x"+quantiteObjet[i]+" prix : "+tableauObjet[i].getvaleur());
			}
		}
	}
	
	public void AfficherInventaireCombat(){
		System.out.println("-1 : Retour");
		int i;
		for(i=0;i<20;i++){
			if(tableauObjet[i]!=null){
				if(quantiteObjet[i]>0) System.out.println(i+ " : "+tableauObjet[i].getnomObjet()+"  x"+quantiteObjet[i]);
			}
		}
	}
	public void AfficherInventaireEquipable(){
		System.out.println("-1 : Quitter");
		int i;
		for(i=20;i<39;i++){
			if(tableauObjet[i]!=null){
				if(quantiteObjet[i]>0) System.out.println(i+ " : "+tableauObjet[i].getnomObjet()+"  x"+quantiteObjet[i]);
			}
		}
	}
	
}
