package section06;

public class Account {

	private String ano;
	private String awner;
	private int balance;
	
	
	public Account() {
		
	}
	
	public Account(String ano, String awner, int balance) {
		this.ano = ano;
		this.awner = awner;
		this.balance = balance;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getAwner() {
		return awner;
	}

	public void setAwner(String awner) {
		this.awner = awner;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Account [ano=" + ano + ", awner=" + awner + ", balance=" + balance + "]";
	}
	

	

	
	
	
	

}
