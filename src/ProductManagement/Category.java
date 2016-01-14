package ProductManagement;

import java.util.ArrayList;

import ProductManagement.BusinessRuleType;

public class Category {
	private String categoryNaam;
	public ArrayList<BusinessRuleType> heeft = new ArrayList<BusinessRuleType>();

	public Category(ArrayList<BusinessRuleType> ls, String nm) {
		heeft = ls;
		categoryNaam = nm;
	}

	public String getCategoryNaam() {
		return this.categoryNaam;
	}

	public ArrayList<BusinessRuleType> getheeft() {
		return heeft;
	}

	public void set_heeft(ArrayList<BusinessRuleType> _heeft) {
		this.heeft = _heeft;
	}

	public void setCategoryNaam(String categoryNaam) {
		this.categoryNaam = categoryNaam;
	}
}