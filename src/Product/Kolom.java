package Product;

import java.util.List;
import java.util.ArrayList;

import javax.persistence.*;


@Entity
@Table(name = "KOLOM")
public class Kolom {
	@Id
	@Column(name = "KOLOM_ID")
	private int kolomID;
	@Column(name = "KOLOMNAAM")
	private String kolomNaam;
	@Column(name = "VOLGNUMMER")
	private int positie;
	@OneToMany
	@JoinColumn(name="KOLOM_KOLOM_ID")
	private List<Tabel> tabellen = new ArrayList<Tabel>();
	
	
	public List<Tabel> getTabellen() {
		return tabellen;
	}

	public void setTabellen(List<Tabel> tabellen) {
		this.tabellen = tabellen;
	}

	public Kolom(){}
	
	public int getKolomID() {
		return kolomID;
	}

	public void setKolomID(int kolomID) {
		this.kolomID = kolomID;
	}

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
	
	public void setPositie(int positie) {
		this.positie = positie;
	}
}