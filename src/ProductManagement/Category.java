package ProductManagement;


import javax.persistence.*;
//@Entity
//@Table(name="CATEGORY")
public class Category {
//	@Column(name="CATEGORYNAAM")
	private String categoryNaam;
//	@Id
//	@Column(name="CATEGORY_ID")
	private int categoryID;

	public int getCategoryID() {
		return categoryID;
	}
	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}
	public Category(){}
	public Category(String nm) {
		categoryNaam = nm;
	}

	public String getCategoryNaam() {
		return this.categoryNaam;
	}


	public void setCategoryNaam(String categoryNaam) {
		this.categoryNaam = categoryNaam;
	}
}