package Product;

import javax.persistence.*;

@Entity
@Table(name="VALUE")
public class Value implements Comparable<Value> {
	@Id
	@Column(name="VALUE_ID")
	private int valueID;
	@Column(name="WAARDE")
	private String valueWaarde;
	@Column(name="VOLGNUMMER")
	private Integer volgnummer;
	
	
	public int getVolgnummer() {
		return volgnummer;
	}
	public void setVolgnummer(int volgnummer) {
		this.volgnummer = volgnummer;
	}
	public Value(){}
	public Value(String string, int i) {
		valueWaarde = string;
		volgnummer = i;
	}
	public String getValueWaarde() {
		return valueWaarde;
	}
	public void setValueWaarde(String valueWaarde) {
		this.valueWaarde = valueWaarde;
	}
	public int getPositie() {
		return volgnummer;
	}
	public void setPositie(int positie) {
		this.volgnummer = positie;
	}
	public int getValueID() {
		return valueID;
	}
	public void setValueID(int valueID) {
		this.valueID = valueID;
	}
	public int compareTo(Value o) {
		return volgnummer.compareTo(o.getVolgnummer());
	}
}