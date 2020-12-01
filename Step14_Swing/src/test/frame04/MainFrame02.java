package test.frame04;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainFrame02 extends JFrame 
			implements ActionListener {
	
	JTextField inputText1;
	JTextField inputText2;
	JLabel answer;
	
	public MainFrame02(String title) {
		super(title);
		this.setLayout(new BorderLayout());
		
		JPanel topPanel=new JPanel();
		inputText1=new JTextField(5);
		inputText1.getText();
		topPanel.add(inputText1);
		JButton plus=new JButton("+");
		topPanel.add(plus);
		plus.addActionListener(this);
		JButton minus=new JButton("-");
		topPanel.add(minus);
		minus.addActionListener(this);
		JButton multiple=new JButton("*");
		topPanel.add(multiple);
		multiple.addActionListener(this);
		JButton division=new JButton("/");
		topPanel.add(division);
		division.addActionListener(this);
		inputText2=new JTextField(5);
		inputText2.getText();
		topPanel.add(inputText2);
		JLabel equal=new JLabel("=");
		topPanel.add(equal);
		answer=new JLabel();
		topPanel.add(answer);
		
		topPanel.setBackground(Color.YELLOW);
		add(topPanel, BorderLayout.NORTH);
	}
	
	public static void main(String[] args) {
		MainFrame02 f=new MainFrame02("메인 프레임");
		f.setBounds(100, 100, 500, 300);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		double one = Double.parseDouble(inputText1.getText());
		double two = Double.parseDouble(inputText2.getText());
		double result=0;
		String command=e.getActionCommand();
		if(command.equals("+")) {
			result = one+two;
		}else if(command.equals("-")) {
			result = one-two;
		}else if(command.equals("*")) {
			result = one*two;
		}else if(command.equals("/")) {
			result = one/two;
		}
		
		String results=Double.toString(result);
		answer.setText(results);
	}
}
