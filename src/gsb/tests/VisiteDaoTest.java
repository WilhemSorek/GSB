package gsb.tests;

import gsb.modele.Medicament;
import gsb.modele.Visite;
import gsb.modele.dao.MedicamentDao;
import gsb.modele.dao.VisiteDao;

public class VisiteDaoTest {

public static void main(String[] args) {
		
		Visite uneVisite = VisiteDao.rechercher("f21");
		System.out.println(uneVisite.getReference());
		System.out.println(uneVisite.getDate());
		System.out.println(uneVisite.getCommentaire());
		System.out.println(uneVisite.getUnVisiteur().getMatricule());
		System.out.println(uneVisite.getUnMedecin().getCodeMed());
		
		Visite uneVisite1= new Visite("v0024", "2002-03-21","Nice","f21", "m012");
	    System.out.println(VisiteDao.ajouter(uneVisite1));
		
}
}
