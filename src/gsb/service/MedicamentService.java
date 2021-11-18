package gsb.service;

import gsb.modele.Medicament;
import gsb.modele.dao.MedicamentDao;

public class MedicamentService 
{
	public static Medicament rechercherMedicament(String codeMedicament)
	{
		Medicament unMedicament = null;
		try{
			if (codeMedicament == null)
			{
				throw new Exception("Code Medicament non renseign�");
			}
			unMedicament = MedicamentDao.rechercher(codeMedicament);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return unMedicament;
	}
	
	public static int ajouterMedicament(Medicament unMedicament)
	{
		int resultat = 0;
		try {
			if (unMedicament == null)
			{
				throw new Exception("Medicament � ajouter non renseign�");
			}
			resultat = MedicamentDao.ajouter(unMedicament);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return resultat;
	}
}
