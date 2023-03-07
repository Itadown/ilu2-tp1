package personnages;

public class Village 
{
	private String nom;
	private int nbVillageoisMaximum;
	
	private Chef chef;
	private int nbVillageois = 0;
	private Gaulois [] villageois;
	
	public Village(String nom, int nbVillageoisMaximum) 
	{
		this.nom = nom;
		this.villageois = new Gaulois[nbVillageoisMaximum];
		this.nbVillageoisMaximum = nbVillageoisMaximum;
	}
	
	public void setChef(Chef chef) 
	{
	this.chef = chef;
	}
	
	public String getNom() 
	{
	return nom;
	}
	
	public void ajouterHabitant(Gaulois hab)
	{
		if (nbVillageoisMaximum >= nbVillageois)
		{
			villageois[nbVillageois] = hab;
			nbVillageois++;	
		}
		
		else
		{
			System.out.println("Le village a deja atteint le maximum d'habitants.");
		}
	}
	
	public Gaulois trouverHabitant(int numero)
	{
		return villageois[numero];
	}
	
	public void afficherVillageois()
	{
		System.out.println("Le chef du village : '" + getNom() + "' est : '" + chef.getNom() + "' et ses villageois sont :\n");
		
		for (int i = 0; i < nbVillageois; i++)
		{
			System.out.println("- " + villageois[i].getNom() + "\n");
		}
		
	}
	
	public static void main(String[] args)
	{
		Village village = new Village("Village des Irréductibles", 30);
		
		// Gaulois gaulois = village.trouverHabitant(30);
		
		// Index 30 out of bounds for length 30 at personnages.Village.trouverHabitant(Village.java:45)
		// Car le 30 eme villageois est en position 29 et aussi qu'il n'y a pas 30 villageois actuellement
		
		Chef abraracourcix = new Chef("Abraracourcix", 6, village);
		village.setChef(abraracourcix);
		
		Gaulois asterix = new Gaulois("Asterix", 8);
		village.ajouterHabitant(asterix);
		
		// Gaulois gaulois = village.trouverHabitant(1);
		// System.out.println(gaulois);
		
		// null
		// Asterix est à la position 0 et non à la 1 donc ça n'affiche rien
		
		Gaulois obelix = new Gaulois("Obélix", 25);
		village.ajouterHabitant(obelix);
		
		village.afficherVillageois();
	}
}
