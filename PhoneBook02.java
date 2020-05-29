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
		System.out.println("�����ϼ���...");
		System.out.println("1. ������ �Է�");
		System.out.println("2. ���α׷� ����");
		System.out.println("���� : ");
	}
	
	public static void readData() {
		System.out.print("�̸� : ");
		String name = sc.nextLine();
		System.out.print("��ȭ��ȣ : ");
		String phone = sc.nextLine();
		System.out.print("������� : ");;
		String birth = sc.nextLine();
		
		PhoneInfo info = new PhoneInfo(name, phone, birth);
		System.out.println("\n�Էµ� ���� ���...");
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
				System.out.println("���α׷��� �����մϴ�.");
				return;
			}
		}

	}

}
