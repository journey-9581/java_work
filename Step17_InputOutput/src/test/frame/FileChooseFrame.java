package test.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileChooseFrame extends JFrame implements ActionListener{
	//필요한 필드 정의하기 (모든 메소드에서 접근 가능한 자원)
	JButton selectBtn, selectBtn2;
	JTextArea area;
	
	//생성자
	public FileChooseFrame(String title) {
		super(title);
		setLayout(new BorderLayout());
		//버튼의 참조값을 필드에 저장해놓는다 (다른 메소드에서 참조해서 사용하려고)
		selectBtn=new JButton("파일 선택하기");
		add(selectBtn, BorderLayout.NORTH);
		selectBtn.addActionListener(this);

		selectBtn2=new JButton(".txt 파일 선택하기");
		add(selectBtn2,BorderLayout.SOUTH);
		selectBtn2.addActionListener(this);
		
		//JTextArea 객체 생성
		area=new JTextArea();
		add(area, BorderLayout.CENTER);
		area.setBackground(Color.YELLOW);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//액션이 일어난 UI(JButton)의 참조값 얻어오기
		Object obj=e.getSource();
		if(obj == selectBtn) { //파일 선택 버튼을 눌렀을 때
			this.selectGeneral(); //this 생략 가능
		}else if(obj == selectBtn2) {//.txt 파일 선택 버튼을 눌렀을 때
			this.selectText();//this 생략 가능
		}
		System.out.println("actionPerformed() 메소드가 종료됩니다");
	}
	
	//일반 파일을 선택하는 메소드
	public void selectGeneral() {
		//c:/myFolder에서 시작되는 JFileChooser 객체 생성
		JFileChooser fc=new JFileChooser("c:/myFolder");
		//파일을 선택해서 열 수 있는 다이얼로그 띄우고 어떤 작업을 했는지 결과를 int로 받기
		int result=fc.showOpenDialog(this); //public class FileChooseFrame extends JFrame ...
		
		if(result == JFileChooser.APPROVE_OPTION) { //파일을 선택하고 확인을 눌렀을 때
			//선택한 파일을 Access 할 수 있는 File 객체의 참조값 얻어오기
			File selectedFile=fc.getSelectedFile();
			//선택한 파일의 이름 얻어오기
			String fileName=selectedFile.getName();
			//메세지 다이얼로그 띄우기
			JOptionPane.showMessageDialog(this, fileName+" 파일을 선택했나요?");
		}else if(result == JFileChooser.CANCEL_OPTION) { //취소 버튼을 눌렀을 때
			JOptionPane.showMessageDialog(this, "취소 버튼을 눌렀네요?");
		}else if(result == JFileChooser.ERROR_OPTION) {
			JOptionPane.showMessageDialog(this, "에러");
		}
	}
	//텍스트 파일을 선택하는 메소드
	public void selectText() {
		JFileChooser fc=new JFileChooser("c:/myFolder");
		//파일확장자가 .txt인 파일만 선택할 수 있도록 필터 설정
		FileNameExtensionFilter filter=
				new FileNameExtensionFilter("텍스트파일", "txt");
		fc.setFileFilter(filter);
		//선택된 텍스트 문서에 저장된 문자열을 읽어서 콘솔창에 모두 출력하기
		int result=fc.showOpenDialog(this);
		if(result == JFileChooser.APPROVE_OPTION) {
			File selectedFile=fc.getSelectedFile();
			try {
				//선택된 파일을 Access 할 수 있는 File 객체를 이용해서
				//문자열을 읽어들일 수 있는 FileReader 객체 생성하기
				FileReader fr=new FileReader(selectedFile);
				BufferedReader br=new BufferedReader(fr);
				while(true) { //반복문 돌면서
					//문자열을 한줄씩 읽어들인다
					String line=br.readLine();
					//만일 더이상 읽어들일게 없다면
					if(line==null) {
						break; //반복문 탈출
					}
					//읽어들인 문자열 콘솔창에 출력
					//System.out.println(line);
					//읽어들인 문자열 JTextArea에 출력
					area.append(line+"\r\n");
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
	
	//메인 메소드
	public static void main(String[] args) {
		 FileChooseFrame f=new FileChooseFrame("파일을 선택하는 프레임");
		 f.setBounds(100, 100, 500, 500);
		 f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 f.setVisible(true);
	}
}