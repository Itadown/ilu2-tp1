package personnages;

public class Musee {
	private Trophee [] tab = new Trophee[200];
	private int nbTrophee = 0;
	
	public void donnerTrophees(Gaulois gaulois, Trophee equipement)
	{
		tab[nbTrophee] = equipement;
		nbTrophee += 1;
	}
	
	public String extraireInstructionsCaml()
	{
		String chaine = "";
		for (int i = 0; i < nbTrophee; i++)
		{
			chaine += tab[i];
		}
		return chaine;
	}
}
