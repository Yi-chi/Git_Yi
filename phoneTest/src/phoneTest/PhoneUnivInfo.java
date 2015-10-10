package phoneTest;

public class PhoneUnivInfo extends PhoneInfo {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String major;
	String degree;
	
	PhoneUnivInfo(String name, String phoneNumber, String major, String degree) {
		super(name, phoneNumber);
		this.major = major;
		this.degree = degree;
	}

	@Override
	public void infoView() {
		super.infoView();
		System.out.print("   ����==" + major);
		System.out.print("   �з�==" + degree);

	}
}
