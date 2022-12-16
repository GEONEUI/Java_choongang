package section12;

public class ThreadEx {

	public static void main(String[] args) {
//		for(;;) {
//			
//		}
		Thread th = new WorkThread();
		th.start();
		
		Thread th2 = new Thread(new WorkThread2());
		th2.start();

		
		Thread th3 = new Thread() {
			
			@Override
			public void run() {
				
			}
		};
		
		th3.start();
		
		Thread th4 = new Thread(()-> {

			for(;;) {
				System.out.println("th4");
				try {
					Thread.sleep(200);
				} catch (Exception e) {
					e.fillInStackTrace();
				}
			}
		}); 
		
		th4.start();
	}

}
