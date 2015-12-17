package ProductManagement;

import java.util.ArrayList;

import ProductManagement.BusinessRule_Type;

public class Category {
	private String categoryNaam;
	public ArrayList<BusinessRule_Type> _heeft = new ArrayList<BusinessRule_Type>();

	public Category(ArrayList<BusinessRule_Type> ls, String nm) {
		_heeft = ls;
		categoryNaam = nm;
	}

	public String getCategoryNaam() {
		return this.categoryNaam;
	}

	public ArrayList<BusinessRule_Type> get_heeft() {
		return _heeft;
	}

	public void set_heeft(ArrayList<BusinessRule_Type> _heeft) {
		this._heeft = _heeft;
	}

	public void setCategoryNaam(String categoryNaam) {
		this.categoryNaam = categoryNaam;
	}
}