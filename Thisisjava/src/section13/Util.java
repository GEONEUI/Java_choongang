package section13;

public class Util {
	public static <T> Box<T> boxing(T t){
		Box<T> box = new Box<T>();
		box.setT(t);
		return box;
		
	}

	public static Box<Integer> boxing(int t) {
		// TODO Auto-generated method stub
		return null;
	}
}
