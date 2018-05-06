package metier;

public class Metier {

	protected int idMetier;
	protected String nomMetier;
	protected int niveauMetier;
	protected int experienceMetier;
	protected int experienceMaxMetier;
	
	public int getidMetier(){
		return idMetier;
	}
	public void setnomMetier(String s){
		nomMetier=s;
	}
	
	public void setniveauMetier(int i){
		niveauMetier=i;
	}
	
	public void setidMetier(int i){
		idMetier=i;
	}
	
	public int getniveauMetier(){
		return niveauMetier;
	}
	
	public int getexperienceMetier(){
		return experienceMetier;
	}
	
	public void setexperienceMetier(int em){
		experienceMetier = em;
	}
	
	public void setexperienceMetierMax(int em){
		experienceMaxMetier = em;
	}
	
	public int getexperienceMaxMetier(){
		return experienceMaxMetier;
	}
	
	public String getnom(){
		return nomMetier;
	}
	
	public Metier(int idm, String nm, int nivm, int em, int emm){
		idMetier = idm;
		nomMetier = nm;
		niveauMetier = nivm;
		experienceMetier = em;
		experienceMaxMetier = emm;
	}
	
	public void monterNiveauMetier(){
		
		experienceMetier = experienceMetier - experienceMaxMetier;
		experienceMaxMetier = experienceMaxMetier+200;
		niveauMetier = niveauMetier + 1;
		System.out.println("Felicitations, vous avez atteint le niveau : " + niveauMetier);
	}
}
