package villagegaulois;

import personnage.Equipement;
import personnage.Gaulois;
import personnage.Trophee;

public class Musee {
	private static final int NB_MAX_TROPHEE = 200; 
	private Trophee[] tabTrophee;
	private int nbTrophee = 0 ;
	private String nom; 
	
	
	public Musee(String nom) {
		this.nom=nom;
		tabTrophee = new Trophee[NB_MAX_TROPHEE];
	} 
	
	public void donnerTrophee(Gaulois gaulois,Equipement equipement) {
		Trophee troph = new Trophee(gaulois, equipement);
		if (nbTrophee<NB_MAX_TROPHEE) {
			tabTrophee[nbTrophee]=troph;
			nbTrophee++;
		}
		else {
		System.out.println("Le musee est plein desole! ");}
	}
	
	
	
}
