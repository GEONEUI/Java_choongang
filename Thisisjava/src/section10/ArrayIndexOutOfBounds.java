package section10;

public class ArrayIndexOutOfBounds {
	public static void main(String[] args) {

		if(args.length == 1) {
			String data1 = args[0];
			System.out.println(data1);
		}else {
			System.out.println("args[0]에 값업음");
		}
		
	}
}
