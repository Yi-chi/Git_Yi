package phoneTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class PhoneBookManager implements INIT_MENU, INPUT_SELECT{
	
/*  					HashSet 으로 저장공간을 바꿔줘서 필용가 없다.
 	static PhoneInfo pi;
	static int count = 0;
	final static int maxmember = 100;
	static PhoneInfo[] phoneinfoA = new PhoneInfo[maxmember];
*/
	private final File dataFile = new File("PhoneBook.dat");
	static HashSet<PhoneInfo> hash = new HashSet<PhoneInfo>();
	
	//static Scanner kyb = new Scanner(System.in);
	static PhoneBookManager inst=null;

	public static PhoneBookManager createManagerInst()
	{
		if(inst==null)
			inst=new PhoneBookManager();
		return inst;
	}
	
	public PhoneBookManager() {
		readFromFile();
		System.out.println("프로 그램 실행 시작");
	}
	
	public void input() throws NumberException{
		System.out.println("데이터 입력을 시작합니다.");
		System.out.println("1. 일반, 2. 대학, 3. 회사");
		
		String operNumTemp = PrintClass.sc.nextLine();
		int operNum = Integer.parseInt(operNumTemp);
		
		if(operNum < INPUT_SELECT.NORMAL || operNum > INPUT_SELECT.COMPANY)
			throw new NumberException(operNum);
		input3(operNum);
	}
	
	public void input3(int operNum){

		String name;
		String phoneNumber;
		String major;
		String degree;
		String companyName;
		
		switch (operNum) {
			case INPUT_SELECT.NORMAL:
				System.out.println("1번 정보들을 입력 시작합니다.");
				System.out.println("이름 입력:");
				name = PrintClass.sc.nextLine();
				System.out.println("전화번호:");
				phoneNumber = PrintClass.sc.nextLine();
				boolean addhash = hash.add(new PhoneInfo(name, phoneNumber));
				if(addhash==false){
					break;
				}
				//phoneinfoA[count++] = new PhoneInfo(name, phoneNumber);
				System.out.println("1번 형식 입력완료");
				break;
				
			case INPUT_SELECT.UNIV:
				System.out.println("2번 정보들을 입력 시작합니다.");
				System.out.println("이름 입력: ");
				name = PrintClass.sc.nextLine();
				System.out.println("전화번호: ");
				phoneNumber = PrintClass.sc.nextLine();
				System.out.println("전공: ");
				major = PrintClass.sc.nextLine();
				System.out.println("학년: ");
				degree = PrintClass.sc.nextLine();
				addhash = hash.add(new PhoneUnivInfo(name, phoneNumber, major, degree));
				if(addhash==false){
					break;
				}
				//phoneinfoA[count++] = new PhoneUnivInfo(name, phoneNumber, major, degree);
				System.out.println("2번 형식 입력완료");
				break;
				
			case INPUT_SELECT.COMPANY:
				System.out.println("3번 정보들을 입력 시작합니다.");
				System.out.println("이름 입력: ");
				name = PrintClass.sc.nextLine();
				System.out.println("전화번호: ");
				phoneNumber = PrintClass.sc.nextLine();
				System.out.println("회사 이름: ");
				companyName = PrintClass.sc.nextLine();
				addhash = hash.add(new PhoneCompanyInfo(name, phoneNumber, companyName));
				if(addhash==false){
					break;
				}
				//phoneinfoA[count++] = new PhoneCompanyInfo(name, phoneNumber, companyName);
				System.out.println("3번 형식 입력완료");
				break;
				
			default:
				break;
			}
	}
	
	public void delete(){
		System.out.println("삭제를 시작합니다. 삭제할 이름을 입력해주세요.");
		String name1 = PrintClass.sc.nextLine();

		Iterator<PhoneInfo> itr = hash.iterator();
		while (itr.hasNext()) {
			 PhoneInfo infe = itr.next();
			 if(infe.name.equals(name1)){
				 itr.remove();
				 System.out.println("삭제가 완료 되었습니다.");
				 return;
			 }
		}
		System.out.println("찾는 이름이 없습니다.");
		
		
		/*	for(int a=0; a<count; a++){
			PhoneInfo pi = phoneinfoA[a];
			if(name1.equals(pi.name)){
				for(int b = a; b<count; b++){
					phoneinfoA[b]=phoneinfoA[b+1];
				}
				count--;
				System.out.println("이름 " + name1 + " 삭제 되었습니다.");
				return;
			}
		}*/
	 
	}
	
	public void allv(){
		
		Iterator<PhoneInfo> itr = hash.iterator();
		
		while (itr.hasNext()) {
			 PhoneInfo infe = itr.next();
			infe.infoView();
			System.out.println(" ");
			if(!itr.hasNext()){
				System.out.println("더 이상 값이 없습니다.");
				return;
			}
		}
		System.out.println("저장 된 값이 없습니다.");
		
		/*
		for(int a=0; a<count; a++){
			phoneinfoA[a].infoView();
		}*/
	}
	
	public PhoneInfo search(){
		System.out.println("검색을 시작합니다.");
		System.out.println("찾고자 하는 이름을 입려해주세요.");
		System.out.println("이름 입력:");
		String name = PrintClass.sc.nextLine();
		
		Iterator<PhoneInfo> itr = hash.iterator();
		while (itr.hasNext()) {
			 PhoneInfo infe = itr.next();
			 if(infe.name.equals(name)){
				 return infe;
			 }
		}
		return null;
	}
	
	private PhoneInfo search(String name)
	{
		Iterator<PhoneInfo> itr=hash.iterator();      
		while(itr.hasNext())
		{
			PhoneInfo curInfo=itr.next();
			if(name.compareTo(curInfo.name)==0)
				return curInfo;
		}
		return null;
	}

	public String searchData(String name)
	{
		PhoneInfo info=search(name);
		if(info==null)
			return null;
		else
			return info.toString();
	}
	
	public static void ReadView(){
		System.out.println("값을 선택해주세요.");
		System.out.println("전화번호 정보입력:1");
		System.out.println("삭제는 :2");
		System.out.println("배열 모두 검색 :3");
		System.out.println("검색은 :4");
		System.out.println("프로그램 종료:5");
	}

	public boolean deleteData(String name)
	{	
		Iterator<PhoneInfo> itr=hash.iterator();
		while(itr.hasNext())
		{
			PhoneInfo curInfo=itr.next();
			if(name.compareTo(curInfo.name)==0)
			{
				itr.remove();
				return true;
			}
		}
		return false;
	}
	
	public void storeToFile()
	{
		try
		{
			FileOutputStream file=new FileOutputStream(dataFile);		
			ObjectOutputStream out=new ObjectOutputStream(file);
			Iterator<PhoneInfo> itr = hash.iterator();
			while(itr.hasNext())
				out.writeObject(itr.next());
			System.out.println("저장중");
			out.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public void readFromFile()
	{
		if(dataFile.exists()==false)
			return;
		try
		{
			FileInputStream file=new FileInputStream(dataFile);		
			ObjectInputStream in=new ObjectInputStream(file);
			
			while(true)
			{
				PhoneInfo info=(PhoneInfo)in.readObject();
				if(info==null)
					break;
				hash.add(info);
			}
			in.close();
		}
		catch(IOException e)
		{
			return;
		}
		catch(ClassNotFoundException e)
		{
			return;
		}
	}
}
