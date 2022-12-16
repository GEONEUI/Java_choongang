package section14;

public class MyFunctionalInterfaceExample {

	public static void main(String[] args) {
		
		MyFunctionalInterface fi;
		
		fi = (x, y) ->{
			int result = x + y;
			return result;
		};
		
		System.out.println(fi.method(2, 5));
		
		fi= (x, y) -> {
			return x + y;
		};
	}

}
