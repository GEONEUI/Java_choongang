package section06;

import java.util.Scanner;

public class BankApplication {

	private static Account[] accountArr = new Account[100];
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		boolean run = true;

		while (run) {
			System.out.println("-------------------------------------------");
			System.out.println("1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.종료");
			System.out.println("-------------------------------------------");

			System.out.print("선택>");

			int selectNo = scanner.nextInt();

			if (selectNo == 1) {
				createAccout();
			}
			if (selectNo == 2) {
				accountLIst();
			}
			if (selectNo == 3) {
				//deposit();
			}
			if (selectNo == 4) {
				//withdraw();
			}
			if (selectNo == 5) {
				run = false;
			}
		}
		System.out.println("프로그램 종료");
	};
	
	
	//계좌생성하기
	private static void createAccout() {
		
		System.out.println("-------------------------------------------");
		System.out.println("1. 계좌생성하기");
		System.out.println("-------------------------------------------");
		
		System.out.print("계좌번호를 입력해주세요.");
		String userID = scanner.next();
		
		System.out.print("이름을 입력해주세요.");
		String userNAME = scanner.next();
		
		System.out.print("초기 입금액을 입력해주세요.");
		int userMONEY = scanner.nextInt();
		
		for(int i=0; i<accountArr.length;i++) {
			if(accountArr[i] == null) {
				accountArr[i] = new Account(userID, userNAME, userMONEY);
				break;
			}
		}
		
		System.out.print("계좌생성이 완료되었습니다.");
		
	};
	
	private static void accountLIst() {
		
		System.out.println("-------------------------------------------");
		System.out.println("2. 계좌목록");
		System.out.println("-------------------------------------------");
		
		for(int i=0; i<accountArr.length;i++) {
			Account userList = accountArr[i];
			if(accountArr[i] != null) {
				System.out.println(userList.toString());
			}
		}
		
	}

}
