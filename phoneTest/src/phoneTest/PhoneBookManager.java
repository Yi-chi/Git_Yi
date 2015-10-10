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
	
/*  					HashSet ���� ��������� �ٲ��༭ �ʿ밡 ����.
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
		System.out.println("���� �׷� ���� ����");
	}
	
	public void input() throws NumberException{
		System.out.println("������ �Է��� �����մϴ�.");
		System.out.println("1. �Ϲ�, 2. ����, 3. ȸ��");
		
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
				System.out.println("1�� �������� �Է� �����մϴ�.");
				System.out.println("�̸� �Է�:");
				name = PrintClass.sc.nextLine();
				System.out.println("��ȭ��ȣ:");
				phoneNumber = PrintClass.sc.nextLine();
				boolean addhash = hash.add(new PhoneInfo(name, phoneNumber));
				if(addhash==false){
					break;
				}
				//phoneinfoA[count++] = new PhoneInfo(name, phoneNumber);
				System.out.println("1�� ���� �Է¿Ϸ�");
				break;
				
			case INPUT_SELECT.UNIV:
				System.out.println("2�� �������� �Է� �����մϴ�.");
				System.out.println("�̸� �Է�: ");
				name = PrintClass.sc.nextLine();
				System.out.println("��ȭ��ȣ: ");
				phoneNumber = PrintClass.sc.nextLine();
				System.out.println("����: ");
				major = PrintClass.sc.nextLine();
				System.out.println("�г�: ");
				degree = PrintClass.sc.nextLine();
				addhash = hash.add(new PhoneUnivInfo(name, phoneNumber, major, degree));
				if(addhash==false){
					break;
				}
				//phoneinfoA[count++] = new PhoneUnivInfo(name, phoneNumber, major, degree);
				System.out.println("2�� ���� �Է¿Ϸ�");
				break;
				
			case INPUT_SELECT.COMPANY:
				System.out.println("3�� �������� �Է� �����մϴ�.");
				System.out.println("�̸� �Է�: ");
				name = PrintClass.sc.nextLine();
				System.out.println("��ȭ��ȣ: ");
				phoneNumber = PrintClass.sc.nextLine();
				System.out.println("ȸ�� �̸�: ");
				companyName = PrintClass.sc.nextLine();
				addhash = hash.add(new PhoneCompanyInfo(name, phoneNumber, companyName));
				if(addhash==false){
					break;
				}
				//phoneinfoA[count++] = new PhoneCompanyInfo(name, phoneNumber, companyName);
				System.out.println("3�� ���� �Է¿Ϸ�");
				break;
				
			default:
				break;
			}
	}
	
	public void delete(){
		System.out.println("������ �����մϴ�. ������ �̸��� �Է����ּ���.");
		String name1 = PrintClass.sc.nextLine();

		Iterator<PhoneInfo> itr = hash.iterator();
		while (itr.hasNext()) {
			 PhoneInfo infe = itr.next();
			 if(infe.name.equals(name1)){
				 itr.remove();
				 System.out.println("������ �Ϸ� �Ǿ����ϴ�.");
				 return;
			 }
		}
		System.out.println("ã�� �̸��� �����ϴ�.");
		
		
		/*	for(int a=0; a<count; a++){
			PhoneInfo pi = phoneinfoA[a];
			if(name1.equals(pi.name)){
				for(int b = a; b<count; b++){
					phoneinfoA[b]=phoneinfoA[b+1];
				}
				count--;
				System.out.println("�̸� " + name1 + " ���� �Ǿ����ϴ�.");
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
				System.out.println("�� �̻� ���� �����ϴ�.");
				return;
			}
		}
		System.out.println("���� �� ���� �����ϴ�.");
		
		/*
		for(int a=0; a<count; a++){
			phoneinfoA[a].infoView();
		}*/
	}
	
	public PhoneInfo search(){
		System.out.println("�˻��� �����մϴ�.");
		System.out.println("ã���� �ϴ� �̸��� �Է����ּ���.");
		System.out.println("�̸� �Է�:");
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
		System.out.println("���� �������ּ���.");
		System.out.println("��ȭ��ȣ �����Է�:1");
		System.out.println("������ :2");
		System.out.println("�迭 ��� �˻� :3");
		System.out.println("�˻��� :4");
		System.out.println("���α׷� ����:5");
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
			System.out.println("������");
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
