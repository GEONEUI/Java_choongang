
public class Users {
	String userid;
	String password;
	String name;
	String birth;
	int money;
	
	
	
	public Users() {
		
	}



	public Users(String userid, String password, String name, String birth, int money) {
		this.userid = userid;
		this.password = password;
		this.name = name;
		this.birth = birth;
		this.money = money;
	}



	@Override
	public String toString() {
		return "Users [userid=" + userid + ", password=" + password + ", name=" + name + ", birth=" + birth + ", money="
				+ money + "]";
	}
	
	






	
	



	
	
	

	
	
}
