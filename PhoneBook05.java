// version 0.4 �� ��ȭ��ȣ�θ� �������� ������ ���� ���


import java.util.Scanner;

class PhoneInfo {
	String name;
	String phoneNumber;
	
	public PhoneInfo (String name, String phoneNumber) {
		this.name = name;
		this.phoneNumber = phoneNumber;
	}

	public void showPhoneInfo() {
		System.out.println("name : " + name);
		System.out.println("phone : " + phoneNumber);		
	}
}

class PhoneUnivInfo extends PhoneInfo {
	String major;
	int year;
	public PhoneUnivInfo(String name, String phoneNumber, String major, int year) {
		super(name, phoneNumber);
		this.major = major;
		this.year = year;
	}
	public void showPhoneInfo() {
		super.showPhoneInfo();
		System.out.println("major : " + major);
		System.out.println("year : " + year);
	}
}

class PhoneCompanyInfo extends PhoneInfo {
	String company;

	public PhoneCompanyInfo(String name, String phoneNumber, String company) {
		super(name, phoneNumber);
		this.company = company;
	}
	public void showPhoneInfo() {
		super.showPhoneInfo();
		System.out.println("company : " + company);
	}
}


class PhoneBookManager {
	final int MAX_CNT = 100;
	PhoneInfo[] infostorage = new PhoneInfo[MAX_CNT];
	int curcnt = 0;
	
	private PhoneInfo readFriendInfo() {
		System.out.print("�̸� : ");
		String name = MenuViewer.sc.nextLine();
		System.out.print("��ȭ��ȣ : ");
		String phone = MenuViewer.sc.nextLine();
		return new PhoneInfo(name, phone);
	}
	private PhoneInfo readUnivFriendInfo() {
		System.out.print("�̸� : ");
		String name = MenuViewer.sc.nextLine();
		System.out.print("��ȭ��ȣ : ");
		String phone = MenuViewer.sc.nextLine();		
		System.out.print("���� : ");
		String major = MenuViewer.sc.nextLine();
		System.out.print("�г� : ");
		int year = MenuViewer.sc.nextInt();
		MenuViewer.sc.nextLine();
		return new PhoneUnivInfo(name, phone, major, year);
	}
	
	private PhoneInfo readCompanyFriendInfo() {
		System.out.print("�̸� : ");
		String name = MenuViewer.sc.nextLine();
		System.out.print("��ȭ��ȣ : ");
		String phone = MenuViewer.sc.nextLine();		
		System.out.print("ȸ�� : ");
		String company = MenuViewer.sc.nextLine();

		MenuViewer.sc.nextLine();
		return new PhoneCompanyInfo(name, phone, company);
	}
	
	public void intputData() {
		System.out.println("������ �Է��� �����մϴ�..");
		
		System.out.println("1. �Ϲ�, 2. ����, 3. ȸ��");
		System.out.print("���� >> ");
		int choice = MenuViewer.sc.nextInt();
		MenuViewer.sc.hasNextLine();
		PhoneInfo info = null;
		
		switch(choice) {
		case 1 :
			info = readFriendInfo();
			break;
		case 2 :
			info = readUnivFriendInfo();
			break;
		case 3 :
			info = readCompanyFriendInfo();
			break;
		}
		
		infostorage[curcnt++] = info
		System.out.println("�������Է��� �Ϸ�Ǿ����ϴ�. \n");
		
	}
	
	public void searchData() {
		System.out.println("������ �˻��� �����մϴ�..");
		
		System.out.println("�̸� : ");
		String name = MenuViewer.sc.nextLine();
		int dataIdx = search(name);
		if(dataIdx < 0) {
			System.out.println("�ش��ϴ� �����Ͱ� �������� �ʽ��ϴ�. \n");
		}
		else {
			infostorage[dataIdx].showPhoneInfo();
			System.out.println("������ �˻��� �Ϸ�Ǿ����ϴ�. \n");
		}
	}
	
	public void deleteData() {
		System.out.println("������ ������ �����մϴ�..");
		
		System.out.println("�̸� : ");
		String name = MenuViewer.sc.nextLine();
		int dataIdx = search(name);
		if(dataIdx < 0) {
			System.out.println("�ش��ϴ� �����Ͱ� �������� �ʽ��ϴ�. \n");
		}
		else {
			infostorage[dataIdx].showPhoneInfo();
			for(int i = dataIdx; i < (curcnt-1); i++) {
				infostorage[i] = infostorage[i+1];
			}
			curcnt--;
			System.out.println("������ ������ �Ϸ�Ǿ����ϴ�. \n");
		}
	}
	private int search(String name) {
		for(int i = 0; i < curcnt; i++) {
			PhoneInfo curInfo = infostorage[i];
			if(name.compareTo(curInfo.name) == 0) {
				return i;
			}
		}
		return -1;
	}
}

class MenuViewer {
	public static Scanner sc = new Scanner(System.in);
	
	public static void show() {
		System.out.println("�����ϼ���...");
		System.out.println("1. ������ �Է�");
		System.out.println("2. ������ �˻�");
		System.out.println("3. ������ ����");
		System.out.println("4. ���α׷� ����");
		System.out.println("���� : ");
	}
}



public class PhoneBook05 {	
	

	public static void main(String[] args) {
		int ch;
		PhoneBookManager manager = new PhoneBookManager();
		while(true) {
			MenuViewer.show();
			ch = MenuViewer.sc.nextInt();
			MenuViewer.sc.nextLine();
			
			switch(ch) {
			case 1:
				manager.intputData();
				break;
			case 2:
				manager.searchData();
				break;
			case 3:
				manager.deleteData();
				break;
			case 4:
				System.out.println("���α׷��� �����մϴ�.");
				return;
			}
		}

	}

}
