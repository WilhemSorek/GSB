package gsb.modele;

public class Offrir {
	protected Medicament unMedicament1;
	protected Medicament unMedicament2;
	protected Visite uneVisite;
	protected int qteOfferte1;
	protected int qteOfferte2;
	
	public Offrir(Medicament unMedicament1, Medicament unMedicament2, Visite uneVisite, int qteOfferte1, int qteOfferte2) {
		this.unMedicament1 = unMedicament1;
		this.unMedicament2 = unMedicament2;
		this.uneVisite = uneVisite;
		this.qteOfferte1 = qteOfferte1;
		this.qteOfferte2 = qteOfferte2;
	}
	public Medicament getUnMedicament1() {
		return unMedicament1;
	}
	public void setUnMedicament1(Medicament unMedicament) {
		this.unMedicament1 = unMedicament;
	}
	public Medicament getUnMedicament2() {
		return unMedicament2;
	}
	public void setUnMedicament2(Medicament unMedicament2) {
		this.unMedicament2 = unMedicament2;
	}
	public Visite getUneVisite() {
		return uneVisite;
	}
	public void setUneVisite(Visite uneVisite) {
		this.uneVisite = uneVisite;
	}
	public int getQteOfferte1() {
		return qteOfferte1;
	}
	public void setQteOfferte1(int qteOfferte) {
		this.qteOfferte1 = qteOfferte;
	}
	public int getQteOfferte2() {
		return qteOfferte2;
	}
	public void setQteOfferte2(int qteOfferte2) {
		this.qteOfferte2 = qteOfferte2;
	}
}
