package Product;
public class Value {
	private String valueWaarde;
	private int positie;
	
	public Value(String string, int i) {
		valueWaarde = string;
		positie = i;
	}
	public String getValueWaarde() {
		return valueWaarde;
	}
	public void setValueWaarde(String valueWaarde) {
		this.valueWaarde = valueWaarde;
	}
	public int getPositie() {
		return positie;
	}
	public void setPositie(int positie) {
		this.positie = positie;
	}
	
}