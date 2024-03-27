package histoire;

import villagegaulois.Etal;
import personnages.Gaulois;

public class ScenarioCasDegrade {
	public static void main(String[] args) {
		Etal etal = new Etal();
		
		Gaulois vendeur = new Gaulois("Vendeur", 25);
		Gaulois acheteur = new Gaulois("Acheteur", 25);
		
		etal.libererEtal();
		System.out.println("libererEtal fini\n");
		
		etal.occuperEtal(vendeur, "fleur", 15);
		
		try {
			etal.acheterProduit(2, null);
			System.out.println("acheterProduit acheteur null fini\n");
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalStateException e) {
			e.printStackTrace();
		}
		
		try {	
			etal.acheterProduit(-1, acheteur);
			System.out.println("acheterProduit etal occupe fini\n");
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalStateException e) {
			e.printStackTrace();
		}
		
		try {
			etal.libererEtal();
			etal.acheterProduit(2, acheteur);
			System.out.println("acheterProduit etal occupe fini\n");
			
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalStateException e) {
			e.printStackTrace();
		}
		
		
		System.out.println("Fin du test");
	}
}
