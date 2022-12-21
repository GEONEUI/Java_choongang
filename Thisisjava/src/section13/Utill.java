package section13;

public class Utill {
	public static <T extends String> int compare(T t1, T t2) {
		System.out.println(t1 + "," + t2);
		return t1.compareTo(t2);
		
	}
}
