package section12;

public class WorkThread extends Thread{

	@Override
	public void run() {
		
		for(;;) {
			System.out.println("WorkThread");
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	
}
