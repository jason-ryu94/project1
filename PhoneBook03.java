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

class PhoneBookManager {
	final int MAX_CNT = 100;
	PhoneInfo[] infostorage = new PhoneInfo[MAX_CNT];
	int curcnt = 0;
	public void intputData() {
		System.out.println("데이터 입력을 시작합니다..");
		
		System.out.println("이름 : ");
		String name = MenuViewer.sc.nextLine();
		System.out.println("전화번호 : ");
		String phone = MenuViewer.sc.nextLine();
		System.out.println("생년월일 : ");
		String birth = MenuViewer.sc.nextLine();
		
		infostorage[curcnt++] = new PhoneInfo(name, phone, birth);
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



public class PhoneBook03 {	
	

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
