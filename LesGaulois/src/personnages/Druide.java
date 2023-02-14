package personnages;

import java.util.Random;

public class Druide {
	private String nom;
	private int effetPotionMin;
	private int effetPotionMax;
	private int forcePotion = 1;
	
	public Druide(String nom, int effetPotionMin, int effetPotionMax) 
	{
		this.nom = nom;
		this.effetPotionMin = effetPotionMin;
		this.effetPotionMax = effetPotionMax;
		
		parler("Bonjour, je suis le druide " + nom + " et ma potion peut aller d'une force " + effetPotionMin + " à "
		+ effetPotionMax + ".");
	}
	
	public String getNom() 
	{
		return nom;
	}
	
	public void parler(String texte) 
	{
		System.out.println(prendreParole() + "« " + texte + "»");
	}
	
	public int preparerPotion(int min, int max)
	{
		Random objet = new Random();
		int nb = objet.nextInt(min, max);
		
		return nb;
	}
	
	private String prendreParole() 
	{
		return "Le druide " + nom + " : ";
	}
	
	public void main(String[] args) {
		
		Druide druide = new Druide("Druide", 5, 10);
		
		if (preparerPotion(druide.effetPotionMin, druide.effetPotionMax) > 7)
		{
			druide.parler("J'ai préparé une super potion de force");
		}
		else
		{
			druide.parler("Je n'ai pas trouvé tous les ingrédients, ma potion est seulement de force");
		}
		
	}
}
