package gsb.tests;

import java.util.ArrayList;

import gsb.modele.Medicament;
import gsb.modele.Visiteur;
import gsb.modele.dao.StockerDao;

public class StockerDaoTest {
	
	public static void main(String[] arg) {
	
	ArrayList<Medicament> uneCollecMedicament = new ArrayList<Medicament>();
	uneCollecMedicament = StockerDao.retournerListeStock("");
	for (Medicament unMedicament: uneCollecMedicament) {
		System.out.println();
	}
	}
	ArrayList<Visiteur> uneCollecVisiteur = new ArrayList<Visiteur>();
	uneCollecVisiteur = StockerDao.retournerListeVisiteur("");
	for (Visiteur unVisteur : uneCollecVisiteur) {
		System.out.println();
	}
}
}
