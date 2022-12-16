package section12;

public class BeepTask extends Thread{

	@Override
	public void run() {
		for(int i = 0; i<5; i++) {
			System.out.println("이름" + Thread.currentThread().getName());								
		}
	}
	
	
	
	public static void main(String[] args) {
		Thread th = new BeepTask();
		th.start();
	}
	
}
