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
		
		etal.acheterProduit(2, null);
		System.out.println("acheterProduit acheteur null fini\n");
		
		
		
		etal.acheterProduit(0, acheteur);
		System.out.println("acheterProduit etal occupe fini\n");
		
		
		System.out.println("Fin du test");
	}
}
