package personnage;

public class Romain {
	private String nom;
	private int force;
	private int nbEquipement = 0; 
	private Equipement[] equipement = new Equipement[2];

	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	private boolean isForcePosSatisfied() {
		if (force > 0) {
			return true;
		}
		return false;
	}

	public String getNom() {
		return nom;
	}

	public int getForce() {
		return force;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "< " + texte + " >");
	}

	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}
	
	
	public void sEquiper(Romain romain, Equipement equipementAraj) {
		if (nbEquipement == equipement.length) {
			System.out.println("Le soldat "+romain.getNom()+" est deja bien protege !");
		} 
		else if (nbEquipement>0 && equipement[nbEquipement-1]==equipementAraj) {
			System.out.println("Le soldat "+romain.getNom()+" possede deja un "+equipementAraj+"!");
		}
		else {
			System.out.println("Le soldat "+romain.getNom()+" s'equipe avec un "+equipementAraj+"!");
			equipement[nbEquipement]=equipementAraj;
			nbEquipement++;
		}
	}

	public void recevoirCoup(int forceCoup) {
		assert isForcePosSatisfied();
		int forceTemp = force;
		force -= forceCoup;
		if (force > 0) {
			parler("Aie");
		} else {
			parler("J'abandonne...");
		}
		assert forceTemp > force;
		
	}

	public static void main(String[] args) {
		Romain minus = new Romain("Minus", 6);
		minus.sEquiper(minus, Equipement.CASQUE);
		minus.sEquiper(minus, Equipement.CASQUE);
		minus.sEquiper(minus, Equipement.BOUCLIER);
		minus.sEquiper(minus, Equipement.BOUCLIER);

	}

}
