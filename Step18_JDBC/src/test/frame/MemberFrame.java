package test.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import test.member.dao.MemberDao;
import test.member.dto.MemberDto;

public class MemberFrame extends JFrame implements ActionListener{
	
	JTextField text_name=null;
	JTextField text_addr=null;
	DefaultTableModel model=null;

	//생성자
	public MemberFrame(String title) {
		super(title);
		//프레임의 레이아웃 법칙 지정하기
		setLayout(new BorderLayout());
		//상단 패널
		JPanel topPanel=new JPanel();
		topPanel.setBackground(Color.YELLOW);
		//패널을 상단에 배치하기
		add(topPanel, BorderLayout.NORTH);
		//패널에 추가할 UI 객체를 생성해서
		JLabel label_name=new JLabel("이름");
		JLabel label_addr=new JLabel("주소");
		text_name=new JTextField(10);
		text_addr=new JTextField(10);
		JButton btn_add=new JButton("추가");
		//패널에 순서대로 추가하기
		topPanel.add(label_name);
		topPanel.add(text_name);
		topPanel.add(label_addr);
		topPanel.add(text_addr);
		topPanel.add(btn_add);
		//버튼에 리스너 등록
		btn_add.addActionListener(this);
		//버튼에 Action command 지정
		btn_add.setActionCommand("add");
		
		//회원 목록을 출력할 테이블
		JTable table=new JTable();
		//칼럼명을 String[]에 순서대로 준비하기
		String[] colNames= {"번호", "이름", "주소"};
		//테이블에 연결할 기본 모델 객체
		model=new DefaultTableModel(colNames, 0);
		//모델을 테이블에 연결하기
		table.setModel(model);
		//테이블의 내용이 scroll 될 수 있도록 스크롤 패널로 감싼다
		JScrollPane scPane=new JScrollPane(table);
		//스크롤 패널을 프레임의 중앙에 배치하기
		add(scPane, BorderLayout.CENTER);
		//
		printMember();
	}
	
	//메인 메소드
	public static void main(String[] args) {
		MemberFrame f=new MemberFrame("회원정보 관리");
		f.setBounds(100, 100, 800, 500);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//눌러진 버튼의 action command를 읽어온다
		String command=e.getActionCommand();
		if(command.equals("add")) {//추가 버튼을 눌렀을 때
			addMember();
		}
	}
	//회원 목록을 테이블에 출력하는 메소드
	public void printMember() {
		//모델의 메소드 확인해보기
			/*
			Object[] row1= {1, "김구라", "노량진"};
			Object[] row2= {2, "해골", "행신동"};
			model.addRow(row1);
			model.addRow(row2);
			//Vector는 약간 무거운 ArrayList라고 생각하고 쓰면 된다 (성능이 조금 추가됨)
			Vector<Object> vec1=new Vector<>();
			vec1.add(3);
			vec1.add("원숭이");
			vec1.add("상도동");
			model.addRow(vec1);
			*/
			//회원 목록 불러오기
			MemberDao dao=new MemberDao();
			List<MemberDto> list=dao.selectAll();
			for(MemberDto dto:list) {
				//Object[] row= {dto.getNum(), dto.getName(), dto.getAddr()};
				Vector<Object> row=new Vector<>();
				row.add(dto.getNum());
				row.add(dto.getName());
				row.add(dto.getAddr());
				model.addRow(row);
			}
	}
	
	//회원정보를 추가하는 메소드
	public void addMember() {
		//기존에 출력된 내용 초기화
		model.setRowCount(0);
		//입력한 이름과 주소를 읽어와서
		String name=text_name.getText();
		String addr=text_addr.getText();
		//MemberDto 객체에 담고
		MemberDto dto=new MemberDto();
		dto.setName(name);
		dto.setAddr(addr);
		MemberDao dao=new MemberDao();
		boolean isSuccess=dao.insert(dto);
		//실제 저장되었는지 확인해보세요
		if(isSuccess) {
			JOptionPane.showMessageDialog(this, name+"을 추가하는 작업(INSERT) 성공");
			//테이블에 다시 목록 불러오기
			printMember();
		}else {
			JOptionPane.showMessageDialog(this, "작업(INSERT) 실패");
		}
	}
}




/*
보통 코딩을 할때 for문을 쓰게되면 다음과 같이 쓰게 되는게 정석이다.
for ( int i = 0; i < 9 ; i++ ){
 순환문의 내용;
}
이렇게 정수형 변수 i에 대해서 초기값을 설정해주고, 
몇번을 반복할껀지의 최대값과 그리고 몇단계로 올라갈 것인지에 대한 것을 정의하는데, 
자바에서는 이런 for문의 형식을 벗어나는 것이 있다. 바로 향상된 for 문이다.
for ( String name : nameArray ) {
 순환문의 내용;
}
바로 이 형식이 향상된 for문의 형식인데, 
이 형식을 설명하자면 문자열 형의 변수 'name'에 
문자열 형의 배열변수 'nameArray'의 값을 한번 돌때마다 
'name'변수에 넣어주는것이다.
예를 들면 'nameArray'에는 nameArray = {철수, 영희, Bob} 이 대입되어 있다 가정해보면, 
위의 향상된 for문을 실행 시킬때 첫 순환에서 'name'변수에는 '철수'가, 
두번째 순환에서는 '영희'가, 세번째 순환에서는 'Bob'이 들어가는 것이다.
그리고 이 배열의 값을 다 대입하고 더 이상 대입할 값이 없을 때, for문은 순환을 종료하고 빠져나가게 된다.
*/