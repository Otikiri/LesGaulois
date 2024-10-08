package personnage;

public class Gaulois {
	private String nom;
	private int effetPotion = 1;
	private int force;
	private int nbTrophees;
	private Equipement[] trophees = new Equipement[100];

	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	// returns the name
	public String getNom() {
		return nom;

	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "< " + texte + " >");
	}

//	private String prendreParole() {
//		return "Le gaulois " + nom + " : ";

	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}
	

//	public void frapper(Romain romain) {
//		System.out.println(nom + " envoir un grand coup dans la machoire de " + romain.getNom());
//		romain.recevoirCoup((force / 3) * effetPotion);
//	}

	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la m�choire de " + romain.getNom());
		Equipement[] trophees1 = romain.recevoirCoup((force / 3) * effetPotion);
		for (int i = 0; trophees1 != null && i < trophees1.length; i++, nbTrophees++) {
			this.trophees[nbTrophees] = trophees1[i];
		}
	}

	public void boirePotion(int effetPotDruide) {
		effetPotion = effetPotDruide;
		parler("Merci Druide, je sens que ma force est " + effetPotDruide + " fois decuplee");
	}

//	@Override
//	public String toString() {
//		return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";
//	}

	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Asterix", 8);
		Romain minus = new Romain("Minus", 6);
		Druide pano = new Druide("Panoramix", 5, 10);
		int valpot = pano.preparerPotion();
		asterix.parler("Bonjour a tous!");
		asterix.boirePotion(valpot);
		asterix.frapper(minus);

	}

}
