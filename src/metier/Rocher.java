package metier;


import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

import package1.Joueur;
import Menu.Inventaire;
import Menu.JournalQuete;

public class Rocher{

	private int niveauRocher;
	private int quantitecaillou;
	private int composition;
	private int experienceRocher;
	
	public Rocher(int nr,int qc,int c,int er){
		niveauRocher=nr;
		quantitecaillou=qc;
		composition=c;
		experienceRocher=er;
		
	}

	public void interaction(Joueur p,Inventaire inv,JournalQuete jq) {
		Metier m = p.getMetier();
		if( m.getidMetier() == 1) {
			if (m.getniveauMetier()>=niveauRocher) {
				if(p.getEquipement().getEquipable(2)!=null){
					if
					((20<=p.getEquipement().getEquipable(2).getidObjet()) &&
							(p.getEquipement().getEquipable(2).getidObjet()<=22) &&
							(p.getEquipement().getEquipable(2).getniveauEquipable() >= niveauRocher)
							){
						inv.PlacerObjet(composition,quantitecaillou,jq);
						System.out.println(inv.getquantiteObjet(composition));
						m.setexperienceMetier(m.getexperienceMetier() + experienceRocher);
						if (m.getexperienceMetier() >= m.getexperienceMaxMetier()){
							m.monterNiveauMetier();
						}	
					}
				}
			}
		}
	}
	
	public void afficherDialogueRoch(Graphics g,int x,int y,Joueur player,Inventaire inv){
		int k=15;
		g.setColor(new Color(255,255,255));
		Metier m = player.getMetier();
		if( m.getidMetier() == 1){
			if (m.getniveauMetier()>=niveauRocher) {
				if(player.getEquipement().getEquipable(2)!=null){
					if((20<=player.getEquipement().getEquipable(2).getidObjet()) &&
							(player.getEquipement().getEquipable(2).getidObjet()<=22) &&
							(player.getEquipement().getEquipable(2).getniveauEquipable() >= niveauRocher)){
						g.drawString("Felicitation !!!",x,y+k);
						k+=20;
						g.drawString("Vous avez gagne x"+quantitecaillou+" "+inv.getObjet(composition).getnomObjet(),x,y+k);
						k+=20;
						g.drawString("Votre niveau metier est de : "+m.getniveauMetier(),x,y+k);
			
					}else {
						g.drawString("Vous n'avez pas reussi a casser le rocher ...",x,y+k);
						k+=20;
						g.drawString("Vérifier votre pioche et votre niveau de pioche ...",x,y+k);
					}
				}else{
					g.drawString("Vous n'avez pas de pioche équipée...",x,y+k);
				}
			}else{
				g.drawString("Vous n'avez pas le niveau requis pour casser ce rocher",x,y+k);
			}
		}else{
			g.drawString("Vous n'etes pas mineur...",x,y+k);
		}
	}
}
