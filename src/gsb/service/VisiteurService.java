package gsb.service;

import gsb.modele.Visiteur;
import gsb.modele.dao.VisiteurDao;

public class VisiteurService 
{
	public static Visiteur rechercherVisiteur(String codeVisiteur)
	{
		Visiteur unVisiteur = null;
		try {
			if (codeVisiteur == null)
			{
				throw new Exception("Code visiteur non renseigné");
			}
			unVisiteur = VisiteurDao.rechercher(codeVisiteur);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return unVisiteur;
	}
}
