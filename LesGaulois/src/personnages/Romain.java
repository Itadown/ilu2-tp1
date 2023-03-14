package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement [] equipements = new Equipement[2];
	private int nbEquipement = 0;
	
	
	public Romain(String nom, int force) 
	{
		assert force > 0; 
		this.nom = nom;
		this.force = force;
	}
	
	public int getForce()
	{
		return force;
	}
	
	public void sEquiper(Equipement equipement)
	{	
		switch(nbEquipement)
		{
			case 2:
				System.out.println("Le soldat " + nom + " est deja bien protege !");
				break;
			case 1:
				if (equipements[0] == equipement)
				{
					System.out.println("Le soldat " + nom + " possède déjà un " + equipement + " !");
				}
				else
				{			
					equipements[nbEquipement] = equipement;
					nbEquipement++;
					System.out.println("Le soldat " + nom + " s'equipe avec un " + equipement + ".");
				}
				break;
			default:
				equipements[nbEquipement] = equipement;
				nbEquipement++;
				System.out.println("Le soldat " + nom + " s'equipe avec un " + equipement + ".");
				break;
		}
		
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
	
//	public void recevoirCoup(int forceCoup) 
//	{
//		assert force > 0 : "force < 0";
//		int force_debut = force;
//		force -= forceCoup;
//		if (force > 0) 
//		{
//			parler("Aïe");
//		} 
//		else 
//		{
//			parler("J'abandonne...");
//		}
//		assert force <= force_debut : "force >= force_debut";
//	}
	
	
	
	
	
	public Equipement[] recevoirCoup(int forceCoup) 
	{
		Equipement[] equipementEjecte = null;
		// precondition
		assert force > 0;
		int oldForce = force;
		
		forceCoup = calculResistanceEquipement(forceCoup);
		force -= forceCoup;

		if (force > 0) 
		{
			parler("Aïe");

		}
		else
		{
			equipementEjecte = ejecterEquipement();
			parler("J'abandonne...");
		}
		// post condition la force a diminuée
		assert force < oldForce;
		return equipementEjecte;
	}
	
	private int calculResistanceEquipement(int forceCoup) 
	{
		String texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
		int resistanceEquipement = 0;
		if (nbEquipement != 0) 
		{
			texte += "\nMais heureusement, grace à mon équipement sa force est diminué de ";
			for (int i = 0; i < nbEquipement; i++) 
			{
				if ((equipements[i] != null && equipements[i].equals(Equipement.BOUCLIER))) 
				{
					resistanceEquipement += 8;
				} 
				else 
				{
					System.out.println("Equipement casque");
					resistanceEquipement += 5;
				}
			}
			texte += resistanceEquipement + "!";
		}
		parler(texte);
		if (resistanceEquipement > forceCoup)
		{
			forceCoup = 0;
		}
		else
		{
			forceCoup -= resistanceEquipement;
		}
		
		return forceCoup;
	}
	
	
	private Equipement[] ejecterEquipement() 
	{
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'équipement de " + nom + "s'envole sous la force du coup.");

		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) 
		{
			if (equipements[i] != null) 
			{
				equipementEjecte[nbEquipementEjecte] = equipements[i];
				nbEquipementEjecte++;
				equipements[i] = null;
			}
		}
		return equipementEjecte;
	}
			
	
	
	
	
	public static void main(String[] args) 
	{
		Romain cesar = new Romain("César", 2);
		cesar.parler("Oh non !");
		cesar.recevoirCoup(8);
		
		Romain minus = new Romain("Minus", 6);
		
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
	}
}
