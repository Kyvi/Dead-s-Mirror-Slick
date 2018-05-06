package Menu;

public class RamenerObjet extends Quete {

	private int ObjetARamener[][];
	private int nombreObjet;
	
	public RamenerObjet(int i, String in, String d, int t,Objet t1[],int m,int a,int id,int matrice[][],int n,Inventaire inv) {
		super(i, in, d, t,t1,m,a,id);
		int j;
		ObjetARamener=new int[4][n];
		for(j=0;j<n;j++){
			ObjetARamener[0][j]=matrice[0][j];
			ObjetARamener[2][j]=matrice[1][j];
			ObjetARamener[1][j]=inv.getquantiteObjet(matrice[0][j]);
			if(ObjetARamener[1][j]>=ObjetARamener[2][j]) ObjetARamener[3][j]=1;
			else ObjetARamener[3][j]=0;
		}
		nombreObjet=n;
	}
	
	public int getIdObjet(int j){
		return ObjetARamener[0][j];
	}
	
	public int getnombreObjet(){
		return nombreObjet;
	}
	
	public int getencours(int j){
		return ObjetARamener[1][j];
	}
	
	public int getmax(int j){
		return ObjetARamener[2][j];
	}

	public void ValiderQuete(int i,Inventaire inv,JournalQuete jq) { //Le mettre a 0 car ne sert a rien
		int j,k;
		for(j=0;j<nombreObjet;j++){
			ObjetARamener[1][j]=inv.getquantiteObjet(ObjetARamener[0][j]);
			System.out.println(ObjetARamener[0][j]+" "+ObjetARamener[1][j]+" "+ObjetARamener[2][j]+" "+ObjetARamener[3][j]);
			if(ObjetARamener[1][j]>=ObjetARamener[2][j]) ObjetARamener[3][j]=1;
			else ObjetARamener[3][j]=0;
		}
		j=1;
		k=0;
		while(k<nombreObjet && j==1){
			if(ObjetARamener[3][k]==0){
				j=0;
				if(getetat()>-1){setetat(0);}
			}
			k++;
		}
		System.out.println(j);
		if(j==1 && getetat()==0) setetat(1);
		if(j==1 && getetat()==2){
			inv.AjoutArgent(getarg());
			System.out.println("Vous avez gagn� : "+ getarg()+" po");
			for(k=0;k<getn();k++){
				inv.setquantiteObjet(recompense[k].getidObjet(), 1);
				//On peut pas faire appel � placerObjet sinon boucle sur le validerquete
				System.out.println("Vous avez gagn� : x1"+recompense[k].getnomObjet());
			}
			for(j=0;j<nombreObjet;j++)inv.setquantiteObjet(ObjetARamener[0][j],-(ObjetARamener[2][j]));
		}
	}

}
