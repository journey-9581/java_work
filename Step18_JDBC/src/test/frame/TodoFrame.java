package test.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import test.todo.dao.TodoDao;
import test.todo.dto.TodoDto;

public class TodoFrame extends JFrame 
				implements ActionListener,PropertyChangeListener{
	
	JTextField text_content;
	JTextField text_regdate;
	DefaultTableModel model;
	JTable table;

	public TodoFrame(String title) {
		super(title);
		setLayout(new BorderLayout());
		JPanel topPanel=new JPanel();
		topPanel.setBackground(Color.WHITE);
		add(topPanel, BorderLayout.NORTH);
		
		JLabel label_content=new JLabel("할 일");
		
		text_content=new JTextField(30);
		
		JButton btn_add=new JButton("추가");
		JButton btn_delete=new JButton("삭제");
		
		topPanel.add(label_content);
		topPanel.add(text_content);
		topPanel.add(btn_add);
		topPanel.add(btn_delete);
		
		btn_add.addActionListener(this);
		btn_delete.addActionListener(this);
		
		btn_add.setActionCommand("add");
		btn_delete.setActionCommand("delete");
		
		table=new JTable();
		String[] colNames= {"번호", "할 일", "등록일자"};
		model=new DefaultTableModel(colNames, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				System.out.println(row+"|"+column);
				if(column==0) {
					return false;
				}else {
					return true;
				}
			}
		};
		table.setModel(model);
		JScrollPane scPane=new JScrollPane(table);
		add(scPane, BorderLayout.CENTER);
		printTodo();
		table.addPropertyChangeListener(this);
	}
	
	public static void main(String[] args) {
		TodoFrame f=new TodoFrame("할 일 관리");
		f.setBounds(100, 100, 800, 500);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command=e.getActionCommand();
		if(command.equals("add")) {
			addTodo();
		}else if(command.equals("delete")) {
			deleteTodo();
		}
	}
	
	public void deleteTodo() {
		int selectedIndex=table.getSelectedRow();
		if(selectedIndex==-1) {
			JOptionPane.showMessageDialog(this, "삭제할 내용을 선택하세요");
			return;
		}
		int num=(int)table.getValueAt(selectedIndex,0);
		int result=JOptionPane.showConfirmDialog(this, num+"번 할 일을 정말로 삭제하시겠어요?");
		if(result==JOptionPane.YES_OPTION) {
			new TodoDao().delete(num);
			printTodo();
		}
	}
	
	public void printTodo() {
			TodoDao dao=new TodoDao();
			List<TodoDto> list=dao.selectAll();
			model.setRowCount(0);
			for(TodoDto dto:list) {
				Vector<Object> row=new Vector<>();
				row.add(dto.getNum());
				row.add(dto.getContent());
				row.add(dto.getRegdate());
				model.addRow(row);
			}
	}
	
	public void addTodo() {
		String content=text_content.getText();
		TodoDto dto=new TodoDto();
		dto.setContent(content);
		TodoDao dao=new TodoDao();
		boolean isSuccess=dao.insert(dto);
		if(isSuccess) {
			JOptionPane.showMessageDialog(this, content+"을 추가하는 작업(INSERT) 성공");
			printTodo();
		}else {
			JOptionPane.showMessageDialog(this, "작업(INSERT) 실패");
		}
	}
	class UpdateThread extends Thread{
		@Override
		public void run() {
			while(true) {
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				printTodo();
			}
		}
	}
	
	boolean isEditing=false;
	
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		if(evt.getPropertyName().equals("tableCellEditor")) {
			if(isEditing) {
				int selectedIndex=table.getSelectedRow();
				int num=(int)model.getValueAt(selectedIndex, 0);
				String content=(String)model.getValueAt(selectedIndex, 1);
				String regdate=(String)model.getValueAt(selectedIndex, 2);
				TodoDto dto=new TodoDto(num, content, regdate);
				new TodoDao().update(dto);
			}
			isEditing=!isEditing;
		}
	}
}