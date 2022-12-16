package section14;

public class MyInterfEx {


	public static void main(String[] args) {
	
		MyInterf fi2 = new MyInterf() {

			@Override
			public void method(String str) {
				System.out.println(str);
				
			}
			
		};
		
		
		fi2.method("test");
		
		
		MyInterf fi;
		fi = (str) ->{
			System.out.println("람다식");
		};
		
		
		fi.method("test2");
	}

}
