package personnages;

public class Romain {
	private String nom;
	private int force;
	
	public Romain(String nom, int force) 
	{
		assert force > 0; 
		this.nom = nom;
		this.force = force;
	}
	
	public String getNom() 
	{
		return nom;
	}
	
	public void parler(String texte) 
	{
		System.out.println(prendreParole() + "« " + texte + "»");
	}
	
	private String prendreParole() 
	{
		return "Le romain " + nom + " : ";
	}
	
	public void recevoirCoup(int forceCoup) 
	{
		assert force > 0 : "force < 0";
		int force_debut = force;
		force -= forceCoup;
		if (force > 0) 
		{
			parler("Aïe");
		} 
		else 
		{
			parler("J'abandonne...");
		}
		assert force <= force_debut : "force >= force_debut";
	}
	
	public static void main(String[] args) 
	{
		Romain cesar = new Romain("César", 2);
		cesar.parler("Oh non !");
		cesar.recevoirCoup(8);
		
		Romain minus = new Romain("Minus", 6);
		
		
	}
}
