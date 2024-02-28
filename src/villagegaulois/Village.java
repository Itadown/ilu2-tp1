package villagegaulois;

import personnages.Chef;
import personnages.Gaulois;

public class Village {
	private String nom;
	private Chef chef;
	private Gaulois[] villageois;
	private int nbVillageois = 0;
	private Marche marche;

	public Village(String nom, int nbVillageoisMaximum, int nbEtal) {
		this.nom = nom;
		villageois = new Gaulois[nbVillageoisMaximum];
		this.marche = new Marche(nbEtal);
	}

	public String getNom() {
		return nom;
	}

	public void setChef(Chef chef) {
		this.chef = chef;
	}

	public void ajouterHabitant(Gaulois gaulois) {
		if (nbVillageois < villageois.length) {
			villageois[nbVillageois] = gaulois;
			nbVillageois++;
		}
	}

	public Gaulois trouverHabitant(String nomGaulois) {
		if (nomGaulois.equals(chef.getNom())) {
			return chef;
		}
		for (int i = 0; i < nbVillageois; i++) {
			Gaulois gaulois = villageois[i];
			if (gaulois.getNom().equals(nomGaulois)) {
				return gaulois;
			}
		}
		return null;
	}

	public String afficherVillageois() {
		StringBuilder chaine = new StringBuilder();
		if (nbVillageois < 1) {
			chaine.append("Il n'y a encore aucun habitant au village du chef "
					+ chef.getNom() + ".\n");
		} else {
			chaine.append("Au village du chef " + chef.getNom()
					+ " vivent les légendaires gaulois :\n");
			for (int i = 0; i < nbVillageois; i++) {
				chaine.append("- " + villageois[i].getNom() + "\n");
			}
		}
		return chaine.toString();
	}

	public String installerVendeur(Gaulois vendeur, String produit, int nbProduit) {
		StringBuilder texte = new StringBuilder();
		int nbEtal = marche.trouverEtalLibre();
		if (nbEtal == -1) {
			texte.append("Tous les étals sont occupé, le vendeur " + vendeur.getNom() + " devra revenir demain.\n");
		} else {
			marche.utiliserEtal(nbEtal, vendeur, produit, nbProduit);
			texte.append("Le vendeur " + vendeur.getNom() + " vend des " + produit + " à l'étal n°" + nbEtal + "\n");
		}
		return texte.toString();
	}

	public String rechercherVendeursProduit(String produit) {
		StringBuilder texte = new StringBuilder();
		Etal[] etalsProduit = marche.trouverEtals(produit);
		if (etalsProduit.length == 0) {
			texte.append("Aucun vendeur ne vend de " + produit + " dans le marché.\n");
		} else if (etalsProduit.length == 1) {
			texte.append("Seul le vendeur " + (etalsProduit[0].getVendeur()).getNom() + " propose des " + produit + " au marché.\n");
		} else {
			texte.append("Les vendeurs qui proposent des fleurs sont :\n");
			for (int i = 0; i < etalsProduit.length; i++) {
				texte.append("- " + (etalsProduit[i].getVendeur()).getNom() + "\n");
			}
		}
		return texte.toString();
	}

	public Etal rechercherEtal(Gaulois vendeur) {
		return marche.trouverVendeur(vendeur);
	}

	public String partirVendeur(Gaulois vendeur) {
		Etal etalVendeur = rechercherEtal(vendeur);
		return etalVendeur.libererEtal();
	}

	public String afficherMarche() {
		return marche.afficherMarche();
	}

	private static class Marche {

		private Etal[] etals;

		private Marche(int nbEtal) {
			etals = new Etal[nbEtal];
		}

		private void utiliserEtal(int indiceEtal, Gaulois vendeur, String produit, int nbProduit) {
			etals[indiceEtal].occuperEtal(vendeur, produit, nbProduit);
		}

		private int trouverEtalLibre() {
			for (int i = 0; i < etals.length; i++) {

				if (!(etals[i].isEtalOccupe())) {
					return i;
				}
			}
			return -1;
		}

		private Etal[] trouverEtals(String produit) {
			Etal[] produitEtal;
			int nbEtal = 0;
			for (int i = 0; i < etals.length; i++) {
				if (etals[i].isEtalOccupe() && etals[i].contientProduit(produit)) {
					nbEtal++;
				}
			}
			produitEtal = new Etal[nbEtal];
			for (int i = 0, j = 0; i < etals.length; i++) {
				if (etals[i].isEtalOccupe() && etals[i].contientProduit(produit)) {
					produitEtal[j] = etals[i];
					j++;
				}
			}
			return produitEtal;
		}

		private Etal trouverVendeur(Gaulois gaulois) {
			for (int i = 0; i < etals.length; i++) {
				if (etals[i].getVendeur() == gaulois) {
					return etals[i];
				}
			}
			return null;
		}

		private String afficherMarche() {
			int nbEtalLibre = 0;
			StringBuilder texte = new StringBuilder();
			for (int i = 0; i < etals.length; i++) {
				if (etals[i].isEtalOccupe()) {
					texte.append(etals[i].afficherEtal());
				} else {
					nbEtalLibre++;
				}
			}
			if (nbEtalLibre != 0) {
				texte.append("Il reste " + nbEtalLibre + " étals non utilisés dans le marché.\n");
			}
			return texte.toString();

		}
	}
}