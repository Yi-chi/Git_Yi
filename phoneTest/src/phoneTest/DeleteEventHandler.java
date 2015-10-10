package phoneTest;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;
import javax.swing.JTextField;

public class DeleteEventHandler implements ActionListener {
	JTextField delField;
	JTextArea textArea;
	
	public DeleteEventHandler(JTextField field, JTextArea area)
	{
		delField=field;
		textArea=area;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		String name=delField.getText();
		PhoneBookManager manager=PhoneBookManager.createManagerInst();
		boolean isDeleted=manager.deleteData(name);
		if(isDeleted)
			textArea.append("������ ������ �Ϸ��Ͽ����ϴ�. \n");
		else
			textArea.append("�ش��ϴ� �����Ͱ� �������� �ʽ��ϴ�. \n");
	}

}
