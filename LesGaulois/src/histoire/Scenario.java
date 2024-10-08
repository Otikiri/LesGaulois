package histoire;

import personnage.Druide;
import personnage.Equipement;
import personnage.Gaulois;
import personnage.Romain;
import villagegaulois.Musee;

public class Scenario {

	public static void main(String[] args) {
		Druide druide = new Druide("Panoramix", 5, 10);
		druide.parler("Je vais aller préparer une petite potion...");
		int valpot = druide.preparerPotion();
		Gaulois obelix = new Gaulois("Obélix", 25);
		Gaulois asterix = new Gaulois("Astérix", 8);
		druide.booster(obelix, valpot);
		obelix.parler("Par Bélénos, ce n'est pas juste !");
		druide.booster(asterix, valpot);
		asterix.parler("Bonjour");
		Romain minus = new Romain("Minus", 6);
		Romain milexcus = new Romain("Milexcus", 8);
		minus.sEquiper(milexcus, Equipement.BOUCLIER);
		minus.sEquiper(milexcus, Equipement.CASQUE);
		milexcus.sEquiper(milexcus, Equipement.CASQUE);
		minus.parler("UN GAU... UN GAUGAU...");
		do {
			asterix.frapper(minus);
		} while (minus.getForce() > 0);
		milexcus.parler("UN GAU... UN GAUGAU...");
		do {
			asterix.frapper(milexcus);
		} while (milexcus.getForce() > 0);

//		Partie a decommenter
//
//		Musee musee = new Musee();
//		asterix.faireUneDonnation(musee);

	}

}
