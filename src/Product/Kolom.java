package Product;
public class Kolom {
	private String kolomNaam;
	private int positie;
	public Tabel behoort_tot;

	public Kolom(String string, int i) {
		kolomNaam = string;
		positie = i;
	}

	public Kolom(String string) {
		kolomNaam = string;
	}

	public String getkolomNaam() {
		return kolomNaam;
	}

	public int getPositie() {
		return positie;
	}

	public String getKolomNaam() {
		return kolomNaam;
	}

	public void setKolomNaam(String kolomNaam) {
		this.kolomNaam = kolomNaam;
	}

	public Tabel getBehoort_tot() {
		return behoort_tot;
	}

	public void setBehoort_tot(Tabel behoort_tot) {
		
	}

	public void setPositie(int positie) {
		this.positie = positie;
	}
}