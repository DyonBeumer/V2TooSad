package ProductManagement;

import java.util.ArrayList;
import java.util.Vector;

import ProductManagement.BusinessRule_Type;

public class Category {
	private String categoryNaam;
	public ArrayList<BusinessRule_Type> _heeft = new ArrayList<BusinessRule_Type>();

	public String getCategoryNaam() {
		return this.categoryNaam;
	}
}