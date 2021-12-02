package gsb.service;

import java.util.ArrayList;

import gsb.modele.Visite;
import gsb.modele.dao.VisiteDao;

public class VisiteService 
{
	public static Visite rechercherVisite(String reference)
	{
		Visite uneVisite = null;
		try {
			if (reference == null)
			{
				throw new Exception("Reference de la visite non renseign�es");
			}
			uneVisite = VisiteDao.rechercher(reference);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return uneVisite;
	}
	
	public static int ajouterVisite(Visite uneVisite)
	{
		int resultat = 0;
		try {
			if (uneVisite == null)
			{
				throw new Exception("Visite manquante");
			}
			resultat = VisiteDao.ajouter(uneVisite);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return resultat;
	}
	
	public static int modifierVisite(Visite uneVisite)
	{
		int resultat = 0;
		try {
			if (uneVisite == null)
			{
				throw new Exception("Visite � modifier non renseign�e");
			}
			resultat = VisiteDao.modifier(uneVisite);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return resultat;
	}
	
	public static ArrayList<Visite> retournerCollectionVisiteur()
	{
		ArrayList<Visite> colVisite = new ArrayList<Visite>();
		colVisite = VisiteDao.retournerCollectionDesVisites();
		return colVisite;
	}
}
