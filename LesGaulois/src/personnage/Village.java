package personnage;

public class Village {
	private static final int NB_MAX_VILLAGEOIS = 30;
	private String nom;
	private Gaulois[] lesVillageois;
	private int nbVillageois = 0;

	public Village(String nom) {
		this.nom = nom;
		lesVillageois = new Gaulois[NB_MAX_VILLAGEOIS];
	}

	public String getNom() {
		return nom;
	}

	public void ajouterHabitant(Gaulois gaulois) {
		if (nbVillageois < NB_MAX_VILLAGEOIS) {
			lesVillageois[nbVillageois] = gaulois;
			nbVillageois++;
		}

	}
		
	public String trouverHabitant(int numGaulois) {
		return lesVillageois[numGaulois].getNom();
	}
	
	public void afficherHabitant(Chef chef) {
		System.out.println("Dans le village du chef "+chef.getNom()+" vivent les legendaires gaulois: ");
		for (int i = 0; i < nbVillageois;i++ )
		{
			System.out.println("- "+lesVillageois[i].getNom());
		}
	}
	
	public static void main(String[] args) {
		Village vdi = new Village("Villageois des irreductibles"); 
		Gaulois asterix = new Gaulois("Asterix",8);
		Gaulois obe = new Gaulois("Obelisk",25);
		Chef abra = new Chef("Abraracourcix",6,vdi); 
		vdi.ajouterHabitant(asterix);
		vdi.ajouterHabitant(obe);
		vdi.afficherHabitant(abra);
		
		
	}
}
