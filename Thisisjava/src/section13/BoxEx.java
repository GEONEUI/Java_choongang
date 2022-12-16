package section13;

public class BoxEx {

	public static void main(String[] args) {
		Box<String> box = new Box<String>();
		
		box.setObject("홍길동");
		
		String name = (String) box.getObject();
		
		
		Box<Apple> box1 = new Box<Apple>();
		box1.setObject(new Apple());
		Apple apple = box1.getObject();
		
	}

}
