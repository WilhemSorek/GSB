/*
 * Cr�� le 23 f�vr. 2015
 *
 * TODO Pour changer le mod�le de ce fichier g�n�r�, allez � :
 * Fen�tre - Pr�f�rences - Java - Style de code - Mod�les de code
 */
package gsb.service;

import java.util.ArrayList;
import java.util.HashMap;
import gsb.modele.Medecin;
import gsb.modele.dao.MedecinDao;

/**
 * @author Isabelle
 * 23 f�vr. 2015
 * TODO Pour changer le mod�le de ce commentaire de type g�n�r�, allez � :
 * Fen�tre - Pr�f�rences - Java - Style de code - Mod�les de code
 */
public class MedecinService {
	
	public static Medecin rechercherMedecin(String unCodeMedecin){
		Medecin unMedecin = null;
		try{
		if (unCodeMedecin==null) {
            throw new Exception("Code Medecin non renseign�");
        }
		unMedecin = MedecinDao.rechercher(unCodeMedecin);
		}
		catch(Exception e){
			System.out.println( e.getMessage());
		}
		return unMedecin;
	}
	
	public static ArrayList<Medecin> retournerCollectionDesMedecins()
	{
		ArrayList<Medecin> colMedecin = new ArrayList<Medecin>();
		colMedecin = MedecinDao.retournerCollectionDesMedecins();
		return colMedecin;
	}
	
	public static HashMap<String,Medecin> retournerDictionnaireDesMedecins()
	{
		HashMap<String,Medecin> dicMedecin = new HashMap<String,Medecin>();
		dicMedecin = MedecinDao.retournerDictionnaireDesMedecins();
		return dicMedecin;
	}
}
