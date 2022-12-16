package section14;

public class MyInterfaceEx {

	public static void main(String[] args) {
		Myinterface mi = s -> {
			if(s.equals("OK")) {
				return 100;
			}
			
			return 0;
		};
	
		
		int num = mi.method("OK");
		int num2 = mi.method("6");
		System.out.println(num2);
		


	};
};

