package Product;

import java.util.ArrayList;

public class ProductFacade {
	
	
	public Rule MaakRuleAan(ArrayList<Kolom> kl, ArrayList<Value>vl, String cc){
		return new Rule(vl,kl,cc);
	}
	
	//public maakKolomAan()
	
	public ArrayList<Kolom> maakKolomlijst(Kolom k){
		ArrayList<Kolom> kl = new ArrayList<Kolom>();
		kl.add(k);
		return kl;
	}
	public String getKolomnaam(Kolom k){
		return k.getkolomNaam();
	}
	
	public ArrayList<Kolom> voegKolomToe(ArrayList<Kolom> lst, Kolom k){
		if(!lst.contains(k)){
			lst.add(k);
		}
		return lst;
	}
	public ArrayList<Value> maakValuelijst(Value v){
		ArrayList<Value> kl = new ArrayList<Value>();
		kl.add(v);
		return kl;
	}
	
	public ArrayList<Value> voegValueToe(ArrayList<Value> lst, Value k){
		if(!lst.contains(k)){
			lst.add(k);
		}
		return lst;
	}
	public Kolom setTabel(Kolom k,Tabel t){
		k.setBehoort_tot(t);
		return k;
	}

	public Tabel createTabel(String string) {
		return new Tabel(string);
	}

	public Kolom createKolom(String string) {
		return new Kolom(string);
	}

	public Value createValue(String string, int i) {
		return new Value(string, i);
	}
	
}
