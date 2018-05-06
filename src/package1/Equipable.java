package package1;

import java.util.Scanner;

import Combat.BattlePlayer;
import Menu.Inventaire;
import Menu.JournalQuete;
import Menu.Objet;

public class Equipable extends Objet {

	
	private int niveauEquipable;
	private int vieEquipable;
	private int attaqueEquipable;
	private int defenseEquipable;
	private int type;
	
	public Equipable(String s, int i, int v, boolean l, int ne,int ve,int ae,int de,int t) {
		super(s, i, v, l);
		niveauEquipable=ne;
		vieEquipable=ve;
		attaqueEquipable=ae;
		defenseEquipable=de;
		type=t;
	}
	
	public int getniveauEquipable(){
		return niveauEquipable;
	}
	
	public int gettypeEqu(){
		return type;
	}
	
	public int getvieEquipable(){
		return vieEquipable;
	}
	
	public int getattaqueEquipable(){
		return attaqueEquipable;
	}
	
	public int getdefenseEquipable(){
		return defenseEquipable;
	}
	
	public void desequiper(Inventaire inv,Joueur p,Equipement e,JournalQuete jq, BattlePlayer bp){
		inv.PlacerObjet(getidObjet(), 1, jq);
		e.setEquipement(type, null);
		p.setvieMax(p.getvieMax() -(getvieEquipable()));
		bp.setvie(bp.getvie()-(getvieEquipable()));
		p.setvie(p.getvie()-(getvieEquipable()));
		bp.setPv(bp.getPv()-(getvieEquipable()));
		p.setattaque(p.getattaque()-getattaqueEquipable());
		bp.setattaque(bp.getattaque()-getattaqueEquipable());
		p.setdefense(p.getdefense()-getdefenseEquipable());
		bp.setdefense(bp.getdefense()-getdefenseEquipable());
	}
	
	public void equiper(Inventaire inv,Joueur p,Equipement e,JournalQuete jq, BattlePlayer bp){
		inv.RetirerObjet(getidObjet(), 1, jq);
		e.setEquipement(type,this);
		p.setvieMax(p.getvieMax() +(getvieEquipable()));
		bp.setvie(bp.getvie()+(getvieEquipable()));
		p.setvie(p.getvie()+(getvieEquipable()));
		bp.setPv(bp.getPv()+(getvieEquipable()));
		p.setattaque(p.getattaque()+getattaqueEquipable());
		bp.setattaque(bp.getattaque()+getattaqueEquipable());
		p.setdefense(p.getdefense()+getdefenseEquipable());
		bp.setdefense(bp.getdefense()+getdefenseEquipable());
	}
		
	public void equiperGeneral(Inventaire inv,Joueur p,Equipement e,JournalQuete jq, BattlePlayer bp){
		Equipable eq;
		if(niveauEquipable<=p.getniveau()){
			eq=e.getEquipable(type);
			if (eq !=null){
			eq.desequiper(inv,p,e,jq,bp);
			this.equiper(inv,p,e,jq, bp);
			}else {
				this.equiper(inv,p,e,jq, bp);
			}
		}
	}
	
	
}
