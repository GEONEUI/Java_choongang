package section12.example01;

public class ThreadEx {

	public static void main(String[] args) {
		Thread mt = Thread.currentThread();
		System.out.println(mt.getName());
		
		ThreadA ta = new ThreadA();
		System.out.println(ta.getName());
		ta.start();
		
		ThreadB tb = new ThreadB();
		System.out.println(ta.getName());
		tb.start();
		
		try {
			Thread.sleep(2000);
			ta.interrupt();
			System.out.println("ta 종료" );
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
