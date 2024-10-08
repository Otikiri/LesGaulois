package personnage;

public class Village {
	private static final int NB_MAX_VILLAGEOIS = 30;
	private String nom;
	private int nbVillageois = 0;
	private Gaulois[] villageois;
	private Chef chef; 

	public Village(String nom) {
		this.nom = nom;
		villageois = new Gaulois[NB_MAX_VILLAGEOIS];
	}
	

	public void setChef(Chef chef) {
		this.chef = chef;
	}


	public String getNom() {
		return nom;
	}

	public void ajouterHabitant(Gaulois gaulois) {
		if (nbVillageois < NB_MAX_VILLAGEOIS) {
			villageois[nbVillageois] = gaulois;
			nbVillageois++;
		}

	}

	public String trouverHabitant(int numGaulois) {
		return villageois[numGaulois].getNom();
	}
	
	public void afficherVillageois() {
		System.out.println("Dans le village du chef "+chef.getNom()+" vivent les legendaires gaulois :");
		for (int i = 0; i < nbVillageois; i++) {
			System.out.println("- "+villageois[i].getNom());
		}	
	}
	
	public static void main(String[] args){
		Village vdi = new Village("VDI");
		Gaulois aste = new Gaulois("Asterix",8);
		Gaulois obe = new Gaulois("Obe",25);
		Chef abra = new Chef("Abraham",3,vdi);
		vdi.setChef(abra);
		vdi.ajouterHabitant(obe);
		vdi.ajouterHabitant(aste);
		vdi.trouverHabitant(0);
		vdi.afficherVillageois();
	}
}