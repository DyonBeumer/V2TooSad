package ProductManagement;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "OPERATOR")
public class Operator {
	@Id
	@Column(name = "OPERATOR_ID")
	private int operatorID;
	@Column(name = "OPERATORNAAM")
	private String operatorNaam;
	
	public Operator(){
		
	}
	
	public Operator(String string, int i) {
		operatorNaam = string;
		operatorID = i;
	}

	public String getOperatorNaam() {
		return operatorNaam;
	}

	public void setOperatorNaam(String operatorNaam) {
		this.operatorNaam = operatorNaam;
	}

	public int getOperatorID() {
		return operatorID;
	}

	public void setOperatorID(int operatorID) {
		this.operatorID = operatorID;
	}


}