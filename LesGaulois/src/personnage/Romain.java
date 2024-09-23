package personnage;

public class Romain {
	private String nom;
	private int force;

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

		minus.parler("UN GAU...UN GAUGAU...");
		minus.recevoirCoup(8 / 3);

	}

}
