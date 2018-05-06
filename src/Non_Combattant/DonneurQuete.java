package Non_Combattant;

import Graphisme.Dialogue;
import package1.Joueur;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import Menu.Inventaire;
import Menu.JournalQuete;
import Menu.ParlerAQq;
import Menu.Quete;

public class DonneurQuete extends Personne{

	private String tableauDQDialogue1[];
	private String tableauDQDialogue2[];
	private String tableauDQDialogue3[];
	private String tableauDQDialogue4[];
	private int compteur;
	private int d;
	private DonneurQuete DQ;
	private Quete q;
	private int numero;
	
	public DonneurQuete(int i,String n,String t[],int k,int p,int x,int y,String t1[],String t2[],String t3[],String t4[],int c,int a,DonneurQuete dq,Quete quete,int num){
		super(i,n,t,k,p,x,y);
		int j;
		compteur=0;
		d=a;
		DQ=dq;
		q=quete;
		numero=num;
		tableauDQDialogue1=new String[a];
		tableauDQDialogue2=new String[a];
		tableauDQDialogue3=new String[a];
		tableauDQDialogue4=new String[a];
		for(j=0;j<a;j++){
			tableauDQDialogue1[j]=t1[j];
			tableauDQDialogue2[j]=t2[j];
			tableauDQDialogue3[j]=t3[j];
			tableauDQDialogue4[j]=t4[j];
		}
	}
	public int getnumero(){
		return numero;
	}
	public int ecrire(Graphics g,String s,int l,int x,int y){
		int psize=0;
		int compteur=0;
		while(psize+l<s.length()){
			int pexact=psize+l-10;
			while(s.charAt(pexact)!=' ')pexact++;
			g.drawString(s.substring(psize,pexact+1), x, y+(20*compteur));
			psize=pexact+1;
			compteur++;
		}
		g.drawString(s.substring(psize), x, y+(20*compteur));
		return compteur;
	}
	public void afficherDialogueDQ(Graphics g,String t[],Joueur p,int x,int y){
		int j,compt;
		int k=15;
	    g.setColor(new Color(255,255,255));
		for(j=0;j<3;j++){
			compt=ecrire(g,t[j],67,x,y+k);
			k=k+20*(compt+1);
		}
	}
	
	public String gettableauDQ(int i,int k){
		if(k==1)return tableauDQDialogue1[i];
		else if(k==2) return tableauDQDialogue2[i];
		else if(k==3) return tableauDQDialogue3[i];
		else return tableauDQDialogue4[i];
	}
	public int getd(){
		return d;
	}
	public void setcompteur(int i){
		compteur=i;
	}
	public int getcompteur(){
		return compteur;
	}
	
	public Quete getQuete(){
		return q;
	}
	public DonneurQuete donneursuivant(){
		return DQ;
	}
	public void interactionBis(JournalQuete j,Inventaire inv,Joueur p,Graphics g,Dialogue d) {
		if(q.getetat()==1){
			compteur++;
			d.setchangcompteur(3);
		}
		switch(compteur){
		case 0:
			break;
		case 1:
			q.setetat(0);
			q.ValiderQuete(0, inv, j); //dans le cas de la quete ramener objet
			break;
		case 2:
			break;
		case 3:
			q.setetat(2);
			q.ValiderQuete(q.getidvalid(), inv, j);
			break;
		case 4:
			break;
		}
	}
	
	
}
