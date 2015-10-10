package phoneTest;

public class PhoneBookTest {
	
	public static void main(String[] args) throws NumberException {
		
		PhoneBookManager phoneBM = PhoneBookManager.createManagerInst();
		new SearchDelFrame("PhoneBook");

		boolean switchh = true;
		while (switchh) {
			try{
				
				PhoneBookManager.ReadView();

					String operNumTemp = PrintClass.sc.nextLine();
					int operNum = Integer.parseInt(operNumTemp);
					
					if(operNum < INIT_MENU.INPUT || operNum > INIT_MENU.EXIT)
						throw new NumberException(operNum);
			
				   switch (operNum) {
						case INIT_MENU.INPUT:      //입력 
							phoneBM.input();
							break;
						case INIT_MENU.DELETE:		//삭제
							phoneBM.delete();
							break;
						case INIT_MENU.ALLA:		//모든 배열
							phoneBM.allv();
							break;
						case INIT_MENU.SEARCH:		//검색
							PhoneInfo inf1 = phoneBM.search();
							if(inf1 == null){
								break;
							}
							inf1.infoView();
							break;
						case INIT_MENU.EXIT:		//종료
							phoneBM.storeToFile();
							System.out.println("프로그램 종료");
							switchh = false;
							//return;
							break;
						default:
							System.out.println("잘못된 입력입니다.");
							break;
									}
			} catch(NumberException e){}
		}
	}
}

