package MyListener;

public class Window4{
	
	class MyActionListener implements MyListener{

		@Override
		public void action() {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	
	MyButton mybutton;
	
	
	Window4(){
		System.out.println("윈도우 만들다");
		MyButton mb = new MyButton();
		this.add(mb);
		mb.addListener(new Window4.MyActionListener());
		
	}
	void add(MyButton mybutton) {
		this.mybutton = mybutton;
		System.out.println("버튼 붙였다");
	}

	public static void main(String[] args) {
		new Window();
	}

}
