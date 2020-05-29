import java.util.Scanner;

class PhoneInfo {
	String name;
	String phoneNumber;
	String birth;
	
	public PhoneInfo (String name, String phoneNumber, String birth) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.birth = birth;
	}
	public PhoneInfo(String name, String phoneNumber) {
		this.name  = name;
		this.phoneNumber = phoneNumber;
		this.birth = null;
	}
	
	public void showPhoneInfo() {
		System.out.println("name : " + name);
		System.out.println("phone : " + phoneNumber);
		if(birth != null) {
			System.out.println("birth : " + birth);
		}
		System.out.println("");
	}
}


public class PhoneBook02 {
	static Scanner sc = new Scanner(System.in);
	
	public static void show() {
		System.out.println("선택하세요...");
		System.out.println("1. 데이터 입력");
		System.out.println("2. 프로그램 종료");
		System.out.println("선택 : ");
	}
	
	public static void readData() {
		System.out.print("이름 : ");
		String name = sc.nextLine();
		System.out.print("전화번호 : ");
		String phone = sc.nextLine();
		System.out.print("생년월일 : ");;
		String birth = sc.nextLine();
		
		PhoneInfo info = new PhoneInfo(name, phone, birth);
		System.out.println("\n입력된 정보 출력...");
		info.showPhoneInfo();
	}

	public static void main(String[] args) {
		int ch;
		while(true) {
			show();
			ch = sc.nextInt();
			sc.nextLine();
			
			switch(ch) {
			case 1:
				readData();
				break;
			case 2:
				System.out.println("프로그램을 종료합니다.");
				return;
			}
		}

	}

}
