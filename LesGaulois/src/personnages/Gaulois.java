package personnages;

public class Gaulois {
	private String nom;
	private int effetPotion = 1;
	
	private int force;
	private int nbTrophees;
	private Equipement [] trophees = new equipement[100];
	
	public Gaulois(String nom, int force) 
	{
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
	
//	private String prendreParole() 
//	{
//		return "Le gaulois " + nom + " : ";
//	}
	
	public void boirePotion(int effet)
	{
		effetPotion = effet;
		System.out.println("Merci druide, je sens que ma force est " + effet + " fois décuplé !");
	}
	
	
	
	private String prendreParole() 
	{
		return "Le gaulois " + nom + " : ";
	}
	
	
	public void frapper(Romain romain)
	{
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		Equipement [] trophee = romain.recevoirCoup((force / 3) * effetPotion);
		for (int i = 0; trophee != null && i < trophee.length; i++, nbTrophees++) 
		{
			this.trophees[nbTrophees] = trophee[i];
		}
	}
	
	public void faireUneDonnation(Musee musee)
	{
		Trophee troph;
		if (nbTrophees > 0)
		{
			System.out.println("Je donne tous mes trophees : ");
			for (int i = 0; i < nbTrophees; nbTrophees--)
			{
				System.out.println("- " + trophees[nbTrophees-1]);
				
				troph = new Trophee(this, trophees[nbTrophees-1]);
				
				musee.donnerTrophees(this, troph);
				nbTrophees -= 1;
			}
		}
		else
		{
			System.out.println("Je n'ai pas de trophées à donner...");
		}
	}
	
	
//	public void frapper(Romain romain) 
//	{
//		System.out.println(nom + " envoie un grand coup dans la mâchoire de "
//		+ romain.getNom());
//		romain.recevoirCoup(force / 3);
//	}
	
	@Override
	public String toString() 
	{
		return "Gaulois [nom=" + nom + ", force=" + force
		+ ", effetPotion=" + effetPotion + "]";
	}
	public static void main(String[] args) 
	{
		Gaulois asterix = new Gaulois("Astérix", 8);
		Romain jsp = new Romain("JSP", 9);
		System.out.println(asterix);
		asterix.parler("Je vais me faire frapper");
		asterix.frapper(jsp);
	}
}



