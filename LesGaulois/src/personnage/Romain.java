package personnage;

public class Romain {
	private String nom;
	private int force;
	private int nbEquipement = 0;
	private String texte;
	private Equipement[] equipements = new Equipement[2];

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
		if (nbEquipement == equipements.length) {
			System.out.println("Le soldat " + romain.getNom() + " est deja bien protege !");
		} else if (nbEquipement > 0 && equipements[nbEquipement - 1] == equipementAraj) {
			System.out.println("Le soldat " + romain.getNom() + " possede deja un " + equipementAraj + "!");
		} else {
			System.out.println("Le soldat " + romain.getNom() + " s'equipe avec un " + equipementAraj + "!");
			equipements[nbEquipement] = equipementAraj;
			nbEquipement++;
		}
	}

	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		// précondition assert force > 0;
		int oldForce = force;
		forceCoup = CalculResistanceEquipement(forceCoup);
		force -= forceCoup;
		// if (force > 0) {
		// parler("Aïe");
		// } else { // equipementEjecte = ejecterEquipement();
		// parler("J'abandonne...");
		// }
		switch (force) {
		case 0:
			parler("Aïe");
		default:
			equipementEjecte = ejecterEquipement();
			parler("J'abandonne...");
			break;
		}

		// post condition la force a diminuée
		assert force < oldForce;
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

	private int CalculResistanceEquipement(int forceCoup) {
		texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
		int resistanceEquipement = 0;
		if (!(nbEquipement == 0)) {
			texte += "\nMais heureusement, grace à mon équipement sa force est diminué de ";
			for (int i = 0; i < nbEquipement;) {
				if ((equipements[i] != null && equipements[i].equals(Equipement.BOUCLIER)) == true) {
					resistanceEquipement += 8;
				} else {
					System.out.println("Equipement casque");
					resistanceEquipement += 5;
				}
				i++;
			}
			texte = +resistanceEquipement + "!";
		}
		parler(texte);
		forceCoup -= resistanceEquipement;
		return forceCoup;
	}

	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'équipement de " + nom.toString() + " s'envole sous la force du coup.");
		// TODO
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
			if (equipements[i] == null) {
				continue;
			} else {
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
