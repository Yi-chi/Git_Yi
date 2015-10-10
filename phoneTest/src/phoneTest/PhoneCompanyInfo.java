package phoneTest;

public class PhoneCompanyInfo extends PhoneInfo{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String companyName;
	
	PhoneCompanyInfo(String name, String phoneNumber, String companyName) {
		super(name, phoneNumber);
		this.companyName = companyName;
	}

	@Override
	public void infoView() {
		super.infoView();
		System.out.print("È¸»ç¸í==" + companyName);
	}
}
