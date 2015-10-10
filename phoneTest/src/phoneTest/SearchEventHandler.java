package phoneTest;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class SearchEventHandler implements ActionListener {
	JTextField searchField;
	JTextArea textArea;
	
	public SearchEventHandler(JTextField field, JTextArea area)
	{
		searchField=field;
		textArea=area;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		String name=searchField.getText();
		PhoneBookManager manager=PhoneBookManager.createManagerInst();
		System.out.println("name Ȯ�� " + name);
		String srchResult=manager.searchData(name);     
		
		if(srchResult==null)
		{
			textArea.append("�ش��ϴ� �����Ͱ� �������� �ʽ��ϴ�.\n");
		}
		else
		{
			textArea.append("ã���ô� ������ �˷��帳�ϴ�. \n");
			textArea.append(srchResult);
			textArea.append("\n");
		}
	}
}
