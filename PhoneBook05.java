// version 0.4 각 전화번호부를 직업별로 나눠서 저장 상속


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
		System.out.print("이름 : ");
		String name = MenuViewer.sc.nextLine();
		System.out.print("전화번호 : ");
		String phone = MenuViewer.sc.nextLine();
		return new PhoneInfo(name, phone);
	}
	private PhoneInfo readUnivFriendInfo() {
		System.out.print("이름 : ");
		String name = MenuViewer.sc.nextLine();
		System.out.print("전화번호 : ");
		String phone = MenuViewer.sc.nextLine();		
		System.out.print("전공 : ");
		String major = MenuViewer.sc.nextLine();
		System.out.print("학년 : ");
		int year = MenuViewer.sc.nextInt();
		MenuViewer.sc.nextLine();
		return new PhoneUnivInfo(name, phone, major, year);
	}
	
	private PhoneInfo readCompanyFriendInfo() {
		System.out.print("이름 : ");
		String name = MenuViewer.sc.nextLine();
		System.out.print("전화번호 : ");
		String phone = MenuViewer.sc.nextLine();		
		System.out.print("회사 : ");
		String company = MenuViewer.sc.nextLine();

		MenuViewer.sc.nextLine();
		return new PhoneCompanyInfo(name, phone, company);
	}
	
	public void intputData() {
		System.out.println("데이터 입력을 시작합니다..");
		
		System.out.println("1. 일반, 2. 대학, 3. 회사");
		System.out.print("선택 >> ");
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
		System.out.println("데이터입력이 완료되었습니다. \n");
		
	}
	
	public void searchData() {
		System.out.println("데이터 검색을 시작합니다..");
		
		System.out.println("이름 : ");
		String name = MenuViewer.sc.nextLine();
		int dataIdx = search(name);
		if(dataIdx < 0) {
			System.out.println("해당하는 데이터가 존재하지 않습니다. \n");
		}
		else {
			infostorage[dataIdx].showPhoneInfo();
			System.out.println("데이터 검색이 완료되었습니다. \n");
		}
	}
	
	public void deleteData() {
		System.out.println("데이터 삭제를 시작합니다..");
		
		System.out.println("이름 : ");
		String name = MenuViewer.sc.nextLine();
		int dataIdx = search(name);
		if(dataIdx < 0) {
			System.out.println("해당하는 데이터가 존재하지 않습니다. \n");
		}
		else {
			infostorage[dataIdx].showPhoneInfo();
			for(int i = dataIdx; i < (curcnt-1); i++) {
				infostorage[i] = infostorage[i+1];
			}
			curcnt--;
			System.out.println("데이터 삭제가 완료되었습니다. \n");
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
		System.out.println("선택하세요...");
		System.out.println("1. 데이터 입력");
		System.out.println("2. 데이터 검색");
		System.out.println("3. 데이터 삭제");
		System.out.println("4. 프로그램 종료");
		System.out.println("선택 : ");
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
				System.out.println("프로그램을 종료합니다.");
				return;
			}
		}

	}

}
