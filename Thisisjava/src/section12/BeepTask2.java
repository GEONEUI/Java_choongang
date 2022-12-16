package section12;

public class BeepTask2 implements Runnable{

	@Override
	public void run() {
		for(int i=0; i<5; i++) {
			System.out.println("이름" + Thread.currentThread().getName());
		}
		
	}

}
