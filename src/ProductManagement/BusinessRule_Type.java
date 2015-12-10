package ProductManagement;

import java.awt.List;

import Product.Product;

public class BusinessRule_Type {
	private String typeNaam;
	private String failureMessage;
	public CodeStrategy codeTemplate;
	public Product productService;

	public String getTypeNaam() {
		return this.typeNaam;
	}

}