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
		System.out.println("������ �Է��� �����մϴ�..");
		
		System.out.println("�̸� : ");
		String name = MenuViewer.sc.nextLine();
		System.out.println("��ȭ��ȣ : ");
		String phone = MenuViewer.sc.nextLine();
		System.out.println("������� : ");
		String birth = MenuViewer.sc.nextLine();
		
		infostorage[curcnt++] = new PhoneInfo(name, phone, birth);
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
				System.out.println("���α׷��� �����մϴ�.");
				return;
			}
		}

	}

}
