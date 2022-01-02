/**
 * 
 */
package gsb.tests.unit;

import java.util.HashMap;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import gsb.modele.Medicament;
import gsb.modele.dao.MedicamentDao;
import junit.framework.TestCase;

/**
 * @author acer
 *
 */
class MedicamentServiceTest extends TestCase {

	@BeforeEach
	protected void setUp() throws Exception {
		super.setUp();
	}

	@AfterEach
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * Test method for {@link gsb.service.MedicamentService#rechercherMedicament(java.lang.String)}.
	 */
	@Test
	void testRechercherMedicamentSucces() {
		Medicament unMedicament = new Medicament("TXISOL22","TOUXISOL Vitamine C","Tyrothricine + Acide ascorbique (Vitamine C)",
				"Ce m�dicament est utilis� pour traiter les affections de la bouche et de la gorge.",
				"Ce m�dicament est contre-indiqu� en cas d'allergie �l'un des constituants et chez l'enfant de moins de 6 ans.",
				1.01,"ALO","Antibiotique local (ORL)");
		Medicament medicamentTrouv�e = MedicamentDao.rechercher("TXISOL22");
		assertEquals(unMedicament, medicamentTrouv�e);
	}
	
	@Test
	void testRechercherMedicamentInexistant() {
		Medicament medicamentTrouv�e = MedicamentDao.rechercher("CDMD001");
		assertNull(medicamentTrouv�e);
	}

	/**
	 * Test method for {@link gsb.service.MedicamentService#ajouterMedicament(gsb.modele.Medicament)}.
	 */
	@Test
	void testAjouterMedicament() {
		Medicament unMedicament = new Medicament("DEP001","AmourdeADAM","poudre blanche",
				"secondaire","a gober",1.01,"FAM001","Les gobeurs");
		assertEquals(1, MedicamentDao.ajouter(unMedicament));
	}

	@Test
	void testAjouterMedicamentEchoueExistant() {
		Medicament unMedicament = new Medicament("TXISOL22","TOUXISOL Vitamine C","Tyrothricine + Acide ascorbique (Vitamine C)",
				"Ce m�dicament est utilis� pour traiter les affections de la bouche et de la gorge.",
				"Ce m�dicament est contre-indiqu� en cas d'allergie �l'un des constituants et chez l'enfant de moins de 6 ans.",
				1.01,"ALO","Antibiotique local (ORL)");
		assertEquals(0, MedicamentDao.ajouter(unMedicament));
	}
	
	@Test
	void testAjouterMedicamentEchoueEchec() {
		assertEquals(0, MedicamentDao.ajouter(unMedicament));
	}
	
	@Test
	void testretournerMedicament() {
		HashMap<String, Medicament> dicMed = MedicamentDao.retournerMedicament();
		assertEquals(dicMed, MedicamentDao.retournerMedicament());
	}
	
	@Test
	void testRetournerMedicamentParFamille() {
		String codeMed = "ABP";
		HashMap<String, Medicament> dicMedFam = MedicamentDao.retournerMedicamentParFamille(codeMed);
		assertEquals(dicMedFam, MedicamentDao.retournerMedicamentParFamille(codeMed));
	}
	
}
