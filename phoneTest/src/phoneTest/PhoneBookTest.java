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
						case INIT_MENU.INPUT:      //�Է� 
							phoneBM.input();
							break;
						case INIT_MENU.DELETE:		//����
							phoneBM.delete();
							break;
						case INIT_MENU.ALLA:		//��� �迭
							phoneBM.allv();
							break;
						case INIT_MENU.SEARCH:		//�˻�
							PhoneInfo inf1 = phoneBM.search();
							if(inf1 == null){
								break;
							}
							inf1.infoView();
							break;
						case INIT_MENU.EXIT:		//����
							phoneBM.storeToFile();
							System.out.println("���α׷� ����");
							switchh = false;
							//return;
							break;
						default:
							System.out.println("�߸��� �Է��Դϴ�.");
							break;
									}
			} catch(NumberException e){}
		}
	}
}

