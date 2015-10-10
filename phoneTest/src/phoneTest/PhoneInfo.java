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
		System.out.print("  이름==" + name);
		System.out.print("  번호==" + phoneNumber);
	}
	@Override
	public boolean equals(Object obj) {
	
		PhoneInfo info = (PhoneInfo)obj;
		//System.out.println("@@@@this.name==" + this.name + "@@@@this.phone==" + this.phoneNumber);
		//System.out.println("@@@@info.name==" + info.name + "@@@@info.phone==" + info.phoneNumber);
		
		//System.out.println("this.name == info.name 결과 ===" + this.name == info.name);
		//System.out.println("this.name ==11" + Integer.parseInt(this.name));
		//System.out.println("info.name ==11" + Integer.parseInt(info.name));
		if(name.compareTo(info.name)==0){
			System.out.println("이름이 중복입니다. 저장 실패"); 
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