package MyListener;

public class Window{
	MyButton mybutton;
	
	
	Window(){
		System.out.println("윈도우 만들다");
		MyButton mb = new MyButton();
		this.add(mb);
	}
	void add(MyButton mybutton) {
		this.mybutton = mybutton;
		System.out.println("버튼 붙였다");
	}

	public static void main(String[] args) {
		new Window();
	}

}
