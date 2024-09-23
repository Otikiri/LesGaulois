package personnage;

import java.util.Random;

public class Druide {
	private String nom;
	private int effetPotionMin = 1;
	private int effetPotionMax = 1;

	public Druide(String nom, int effetPotionMin, int effetPotionMax) {
		this.nom = nom;
		this.effetPotionMin = effetPotionMin;
		this.effetPotionMax = effetPotionMax;
		parler("Bonjour, je suis le druide " + nom + " et ma potion magique peut aller d'une force " + effetPotionMin
				+ " a " + effetPotionMax);

	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "< " + texte + " >");
	}

	public int preparerPotion(int effetPotionMax, int effetPotionMin) {
		Random random = new Random();
		int valpot = random.nextInt(effetPotionMax - effetPotionMin + 1) + effetPotionMin;
		if (valpot >= 7) {
			parler("J'ai prepare une super potion de force");
			return valpot;

		} else {
			parler("Je n'ai pas trouve tous les ingredients, ma potion est seulement de force " + valpot);
			return valpot;
		}

	}

	private String prendreParole() {
		return "Le druide " + nom + " : ";

	}

	public void booster(Gaulois gaulois, int efftPot) {
		if ("Obelisk".equals(gaulois.getNom())) {
			parler("Non " + gaulois.getNom() + " !... Tu n'aura pas de potion magique");
		} else {
			gaulois.boirePotion(efftPot);
		}
	}

	public static void main(String[] args) {
		int efPmin = 5;
		int efPmax = 10;
		Druide pano = new Druide("Panoramix", efPmin, efPmax);
		int valpot = pano.preparerPotion(efPmax, efPmin);

		Gaulois obe = new Gaulois("Obelisk", 25);
		Gaulois ast = new Gaulois("Asterix", 8);
		pano.booster(obe, valpot);
		pano.booster(ast, valpot);

	}
}
