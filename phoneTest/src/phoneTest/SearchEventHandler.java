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
		System.out.println("name 확인 " + name);
		String srchResult=manager.searchData(name);     
		
		if(srchResult==null)
		{
			textArea.append("해당하는 데이터가 존재하지 않습니다.\n");
		}
		else
		{
			textArea.append("찾으시는 정보를 알려드립니다. \n");
			textArea.append(srchResult);
			textArea.append("\n");
		}
	}
}
