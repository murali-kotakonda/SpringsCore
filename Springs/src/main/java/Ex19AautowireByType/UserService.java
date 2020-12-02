package Ex19AautowireByType;

public class UserService {

	private DaoImpl d;

	private LoanService ls;

	private CustomerService cs;

	public void process() {
		System.out.println("userservice process");
		ls.provideLoan();
		cs.getCustomer();
	}

	public DaoImpl getD() {
		return d;
	}

	public void setD(DaoImpl d) {
		this.d = d;
	}

	public LoanService getLs() {
		return ls;
	}

	public void setLs(LoanService ls) {
		this.ls = ls;
	}

	public CustomerService getCs() {
		return cs;
	}

	public void setCs(CustomerService cs) {
		this.cs = cs;
	}

	@Override
	public String toString() {
		return "UserService [dao1=" + d + "]";
	}

}
