package test.frame04;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainFrame extends JFrame 
				implements ActionListener, KeyListener{
	// 필드
	JTextField inputText;
	JLabel label1;
	
	// 생성자
	public MainFrame(String title) {
		super(title);
		// 레이아웃 매니저 설정
		this.setLayout(new BorderLayout());
		
		// 텍스트필드와 버튼 객체를 만들어서
		inputText=new JTextField(10); // 참조값을 필드에 저장
		JButton sendBtn=new JButton("전송");
		inputText.getText();
		
		// 패널 객체 생성한 다음
		JPanel topPanel=new JPanel();
		// 패널에 텍스트필드와 버튼을 추가하고
		topPanel.add(inputText);
		topPanel.add(sendBtn);
		sendBtn.addActionListener(this);
		// 패널의 배경 지정
		topPanel.setBackground(Color.YELLOW);
		
		// 패널째로 프레임의 북쪽에 배치하기
		add(topPanel, BorderLayout.NORTH);
		
		// 레이블을 만들어서
		label1=new JLabel();
		// 패널에 추가하기
		topPanel.add(label1);
		
		//JTextField에 키보드 리스너 등록하기
		inputText.addKeyListener(this);
	}

	// run 했을 때 실행순서가 시작되는 main 메소드
	public static void main(String[] args) {
		MainFrame f=new MainFrame("메인 프레임");
		f.setBounds(100, 100, 500, 300);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String msg=this.inputText.getText();
		label1.setText(msg);
	}
	
	// 키를 눌렀을때 호출되는 메소드
	@Override
	public void keyPressed(KeyEvent e) {
		// 눌러진 키의 코드값 읽어오기
		int code=e.getKeyCode();
		System.out.println(code);
		// 만일 엔터키를 눌렀다면
		if(code == KeyEvent.VK_ENTER) {
			String msg=this.inputText.getText();
			label1.setText(msg);
			inputText.setText("");
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		System.out.println("released");
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		System.out.println("typed");
	}
}