package section14;

public class TestInterChild {

	public static void main(String[] args) {
		
		TestInter t = new TestInter() {

			@Override
			public void aa() {
				System.out.println("Sss");
			}
				
			
		};
		
		t.aa();
		
		t = ()->{
			System.out.println();
		};
		
		

	}

}
