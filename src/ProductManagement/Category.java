package ProductManagement;

import java.util.Vector;
import ProductManagement.BusinessRule_Type;

public class Category {
	private String _categoryNaam;
	public Vector<BusinessRule_Type> _heeft = new Vector<BusinessRule_Type>();
	public ProductManagement _unnamed_ProductManagement_;

	public String getCategoryNaam() {
		return this._categoryNaam;
	}
}