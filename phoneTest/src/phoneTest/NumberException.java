package phoneTest;

public class NumberException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NumberException(int a) {
		System.out.println(a + " 에 해당하는 메뉴 선택이 없습니다.");
		System.out.println("입력을 다시 실행합니다.");
	}
}
