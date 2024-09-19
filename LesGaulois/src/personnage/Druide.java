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
		parler("Bonjour, je suis le druide " + nom + "et ma potion magique peut aller d'une force " + effetPotionMin
				+ " a " + effetPotionMax);

	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "< " + texte + " >");
	}

	public int preparerPotion(int effetPotionMax) {
		Random random = new Random();
		int valpot = random.nextInt(effetPotionMax);
		if (valpot >= 7) {
			System.out.println("J'ai prepare une super potion de force");
			return valpot;

		} else {
			System.out.println("Je n'ai pas trouve tous les ingredients, ma potion est seulement de force");
			return valpot;
		}

	}

	private String prendreParole() {
		return "Le druide " + nom + " : ";

	}
	
	public static void main(String[] args) {
		Druide pano = new Druide("Panoramix",5,10);
		int force = pano.preparerPotion(10);
		System.out.println(force);
		
	}
}
