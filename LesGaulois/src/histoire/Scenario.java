package histoire;

import java.util.Random;

import personnage.Druide;
import personnage.Gaulois;
import personnage.Romain;

public class Scenario {

	public static void main(String[] args) {
		int valPotMax = 10; 
		int valPotMin = 5;
		
		
		Gaulois asterix = new Gaulois("Asterix", 8);
		Gaulois obe = new Gaulois("Obelisk",25);
		Romain minus = new Romain("Minus", 6);
		
		asterix.parler("Bonjour a tous");
		Druide pano = new Druide("Panoramix",valPotMin,valPotMax);
		int valpot = pano.preparerPotion(valPotMax, valPotMin);
		minus.parler("UN GAU... UN GAUGAU");
		pano.booster(obe,valpot);
		obe.parler("Par Belenos, ce n'est pas juste");
		pano.booster(asterix, valpot);
		asterix.frapper(minus);

	}

}
