package Product;

import javax.persistence.*;

@Entity
@Table(name="TABEL")
public class Tabel {
	@Column(name="TABELNAAM")
	private String tabelNaam;
	@Column(name="VOLGNUMMER")
	private int volgnummer;
	@Id
	@Column(name="TABEL_ID")
	private int tabelID;
	@OneToOne
	@JoinColumn(name="KOLOM_KOLOM_ID", referencedColumnName="KOLOM_ID")
	private Kolom kolom;
	
	public Tabel(){}
	public Tabel(String string) {
		tabelNaam = string;
	}

	public String getTabelNaam() {
		return tabelNaam;
	}

	public void setTabelNaam(String tabelNaam) {
		this.tabelNaam = tabelNaam;
	}

	
}