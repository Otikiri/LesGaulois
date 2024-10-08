package personnage;

public class Romain {
	private String nom;
	private int force;
	private int nbEquipement = 0;
	private boolean vainqueur;
	private Equipement[] equipements = new Equipement[2];
	public static final String SOLDAT = "Le soldat";

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

	public void sEquiper(Equipement equipementAraj) {
		if (nbEquipement == equipements.length) {
			System.out.println(SOLDAT + nom + " est deja bien protege !");
		} else if (nbEquipement > 0 && equipements[nbEquipement - 1] == equipementAraj) {
			System.out.println(SOLDAT + nom + " possede deja un " + equipementAraj + "!");
		} else {
			System.out.println(SOLDAT + nom + " s'equipe avec un " + equipementAraj + "!");
			equipements[nbEquipement] = equipementAraj;
			nbEquipement++;
		}
	}

	private boolean isForceSup(int oldForce) {
		if (force > oldForce) {
			return false;
		}
		return true;
	}

	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		// pr�condition
		assert isForcePosSatisfied();
		int oldForce = force;

		forceCoup = calculResistanceEquipement(forceCoup);
		if (forceCoup > 0) {
			force -= forceCoup;
		} else {
			force = 0;
		}

		// if (force > 0) {
		// parler("A�e");
		// } else { // equipementEjecte = ejecterEquipement();
		// parler("J'abandonne...");
		//

		if (force > 0) {
			if (force < oldForce) {
				vainqueur = false; 
			}
			else {
				vainqueur = true;
			}
			parler("A�e");
		} else {
			equipementEjecte = ejecterEquipement();
			parler("J'abandonne...");
		}

		// post condition la force a diminu�e
//		assert force < oldForce;
		assert isForceSup(oldForce);

		return equipementEjecte;

	}

//	public void recevoirCoup(int forceCoup) {
//		assert isForcePosSatisfied();
//		int forceTemp = force;
//		force -= forceCoup;
//		if (force > 0) {
//			parler("Aie");
//		} else {
//			parler("J'abandonne...");
//		}
//		assert forceTemp > force;
//
//	}

	private int calculResistanceEquipement(int forceCoup) {
		String texte;
		texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
		int resistanceEquipement = 0;
		if (nbEquipement != 0) {
			texte += "\nMais heureusement, grace � mon �quipement sa force est diminu� de ";
			for (int i = 0; i < nbEquipement; i++) {
				if ((equipements[i] != null && equipements[i].equals(Equipement.BOUCLIER))) {
					resistanceEquipement += 8;
				} else {
					System.out.println("Equipement casque");
					resistanceEquipement += 5;
				}
			}
			texte += resistanceEquipement + "!";
		}
		parler(texte);
		forceCoup -= resistanceEquipement;
		return forceCoup;
	}

	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'equipement de " + nom.toString() + " s'envole sous la force du coup.");
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
			if (equipements[i] != null) {
				equipementEjecte[nbEquipementEjecte] = equipements[i];
				nbEquipementEjecte++;
				equipements[i] = null;
			}
		}
		return equipementEjecte;
	}

	public static void main(String[] args) {
		Romain minus = new Romain("Minus", 6);
		minus.sEquiper(minus, Equipement.CASQUE);
		minus.sEquiper(minus, Equipement.CASQUE);
		minus.sEquiper(minus, Equipement.BOUCLIER);
		minus.sEquiper(minus, Equipement.BOUCLIER);

	}

}
