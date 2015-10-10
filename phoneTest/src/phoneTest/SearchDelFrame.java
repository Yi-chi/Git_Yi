package phoneTest;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.Border;

public class SearchDelFrame extends JFrame {
	
	private static final long serialVersionUID = 1L;
	JTextField srchField=new JTextField(15);
	JButton srchBtn=new JButton("SEARCH");
	
	JTextField delField=new JTextField(15);
	JButton delBtn=new JButton("DEL");
	
	JTextArea textArea=new JTextArea(20, 25);

	public SearchDelFrame(String title)
	{
		super(title);
		setBounds(100, 200, 330, 450);
		setLayout(new BorderLayout());
		Border border=BorderFactory.createEtchedBorder();
		
		Border srchBorder=BorderFactory.createTitledBorder(border, "Search");
		JPanel srchPanel=new JPanel();
		srchPanel.setBorder(srchBorder);
		srchPanel.setLayout(new FlowLayout());
		srchPanel.add(srchField);
		srchPanel.add(srchBtn);

		Border delBorder=BorderFactory.createTitledBorder(border, "Delete");
		JPanel delPanel=new JPanel();
		delPanel.setBorder(delBorder);
		delPanel.setLayout(new FlowLayout());
		delPanel.add(delField);
		delPanel.add(delBtn);
		
		JScrollPane scrollTextArea=new JScrollPane(textArea);	
		Border textBorder=BorderFactory.createTitledBorder(border, "Infomation Board");
		scrollTextArea.setBorder(textBorder);
		
		add(srchPanel, BorderLayout.NORTH);
		add(delPanel, BorderLayout.SOUTH);
		add(scrollTextArea, BorderLayout.CENTER);
		
		srchBtn.addActionListener(new SearchEventHandler(srchField, textArea));
		delBtn.addActionListener(new DeleteEventHandler(delField, textArea));
		
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);	
	}
}
