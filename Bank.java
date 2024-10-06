package bank1;

public class Bank {

	protected String usrname;
	private String usrpwd;
	protected String accType;
	static double amount;

	public Bank(String usrname, String usrpwd, double amount, String accType) {

		this.usrname = usrname;
		this.usrpwd = usrpwd;
		Bank.amount = amount;
		this.accType = accType;

	}
//	public Bank() {
//		
//	}

}
