package package1;

import java.util.Scanner;

import Menu.Inventaire;
import Menu.JournalQuete;

public class Equipement {
	
	private Equipable tableauEquipable[];
	
	public Equipement(){
		tableauEquipable = new Equipable[3];	
	}
	public Equipable getEquipable(int i){
		return tableauEquipable[i];
	}
	
	public void setEquipement(int i,Equipable e){
		tableauEquipable[i]=e;
	}
	public int getnombreEquipement(){
		int resultat=0;
		for(int i=0;i<3;i++){
			if(tableauEquipable[i]!=null)resultat++;
		}
		return resultat;
	}
	public Equipable getEquipablePresent(int i){
		int j=0,k=0;
		while(j<3 && k<=i){
			if(tableauEquipable[j]!=null)k++;
			j++;
		}
		return tableauEquipable[j-1];
	}
}
