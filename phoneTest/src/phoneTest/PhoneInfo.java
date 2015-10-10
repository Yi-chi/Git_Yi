package phoneTest;

import java.io.Serializable;

public class PhoneInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String name;
	String phoneNumber;
	
	PhoneInfo(String name, String phoneNumber){
		this.name = name;
		this.phoneNumber = phoneNumber;
	}
	public void infoView() {
		System.out.print("  �̸�==" + name);
		System.out.print("  ��ȣ==" + phoneNumber);
	}
	@Override
	public boolean equals(Object obj) {
	
		PhoneInfo info = (PhoneInfo)obj;
		//System.out.println("@@@@this.name==" + this.name + "@@@@this.phone==" + this.phoneNumber);
		//System.out.println("@@@@info.name==" + info.name + "@@@@info.phone==" + info.phoneNumber);
		
		//System.out.println("this.name == info.name ��� ===" + this.name == info.name);
		//System.out.println("this.name ==11" + Integer.parseInt(this.name));
		//System.out.println("info.name ==11" + Integer.parseInt(info.name));
		if(name.compareTo(info.name)==0){
			System.out.println("�̸��� �ߺ��Դϴ�. ���� ����"); 
			return true;
			 
		 }else{
			 return false;
		 }
	}
	
	@Override
	public int hashCode() {
		//System.out.println("***name.hashcode()**===" + name.hashCode());
		return name.hashCode();
	}
	
	public String toString()
	{
		return "name: "+name+'\n'+"phone: "+phoneNumber+'\n';
	}
}