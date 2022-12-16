package section10;

public class NulPoEx {

	public static void main(String[] args) {
		try {
			String data = null;
			System.out.println(data.toString());
		}catch(NullPointerException e) {
			
		}

	}

}
