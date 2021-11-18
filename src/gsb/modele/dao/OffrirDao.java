package gsb.modele.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import gsb.modele.Medicament;
import gsb.modele.Visite;

public class OffrirDao {
	
	//retourne une collection contenant les visites concernants le m�dicament donn� en param�tre
	public static ArrayList<Visite> retournerListeOffre(String unCodeMedicament)
	{
		ArrayList<Visite> collectionVisite = new ArrayList<Visite>();
		ResultSet reqSelection = ConnexionMySql.execReqSelection("select REFERENCE from OFFRIR where MED_DEPOTLEGAL = '"+unCodeMedicament+"'");
		try {
			while (reqSelection.next())
			{
				collectionVisite.add(VisiteDao.rechercher(reqSelection.getString(1)));
			}
		}
		catch (Exception e) {
			System.out.println("erreur de la requ�te de selection");
			e.printStackTrace();
		}
		return collectionVisite;
	}
	
	//retourne une collection contenant les m�dicaments offert lors d'une visite en param�tre
	public static ArrayList<Medicament> retournerListeMedicament(String unCodeVisite)
	{
		ArrayList<Medicament> collectionMedicament = new ArrayList<Medicament>();
		ResultSet reqSelection = ConnexionMySql.execReqSelection("select * from OFFRIR where REFERENCE = '"+unCodeVisite+"'");
		try {
			while (reqSelection.next())
			{
				collectionMedicament.add(MedicamentDao.rechercher(reqSelection.getString(1)));
			}
		}
		catch (Exception e) {
			System.out.println("erreur de la requ�te de selection");
			e.printStackTrace();
		}
	return collectionMedicament;
	}

}
