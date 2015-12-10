import java.util.Vector;
import ProductManagement.ProductManagement;

public class Rule {
	private String _customCode;
	public Vector<Value> _heeft = new Vector<Value>();
	public ProductManagement _unnamed_ProductManagement_;
	public Vector<Kolom> _hoort_bij = new Vector<Kolom>();

	public void setOperator() {
		throw new UnsupportedOperationException();
	}

	public void validateOperator(Object aBusinessRuleType) {
		throw new UnsupportedOperationException();
	}
}