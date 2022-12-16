package section10;

public class ExcepEx {

	public static void main(String[] args) {
		try {
			test();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void test() throws CustomException{
		throw new CustomException("예외 테스트 입니다.");
	}

}
