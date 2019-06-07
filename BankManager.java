package money;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class BankManager extends JFrame{
	private JTextField t1;
	private JTextField t2;
	private JTextField t3;
	private JTextField t4;

	public BankManager() {
		
		ImageIcon icon = new ImageIcon("1.jpg");
		
		setSize(600, 600);
		setTitle("은행 고객 관리 프로그램");
		Scanner sc = new Scanner(System.in);
		
		getContentPane().setLayout(null);
		
		t1 = new JTextField();
		t1.setBounds(205, 231, 252, 30);
		getContentPane().add(t1);
		t1.setColumns(10);
		
		t2 = new JTextField();
		t2.setColumns(10);
		t2.setBounds(205, 291, 252, 30);
		getContentPane().add(t2);
		
		t3 = new JTextField();
		t3.setColumns(10);
		t3.setBounds(205, 350, 252, 30);
		getContentPane().add(t3);
		
		t4 = new JTextField();
		t4.setColumns(10);
		t4.setBounds(205, 401, 252, 30);
		getContentPane().add(t4);
		
		
		JLabel lblNewLabel = new JLabel("은행 고객 관리");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 25));
		lblNewLabel.setBounds(0, 0, 584, 62);
		getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("삽입");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BankDTO dto = new BankDTO();
				BankDAO dao = new BankDAO();
				
				String id = t1.getText();
				String name = t2.getText();
				String age = t3.getText();
				String tel = t4.getText();
				
				int age1 = Integer.parseInt(age);
				int tel1 = Integer.parseInt(tel);
				
				dto.setId(id);
				dto.setName(name);
				dto.setAge(age1);
				dto.setTel(tel1);
				
				dao.insert(dto);
			}
		});
		btnNewButton.setFont(new Font("굴림", Font.BOLD, 15));
		btnNewButton.setBounds(114, 465, 97, 23);
		getContentPane().add(btnNewButton);
		
		JButton button = new JButton("수정");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BankDTO dto = new BankDTO();
				BankDAO dao = new BankDAO();
				
				String id = t1.getText();
				String tel = t4.getText();
				int tel1 = Integer.parseInt(tel);
				
				dto.setTel(tel1);
				dto.setId(id);
				
				dao.update(dto);
			}
		});
		button.setFont(new Font("굴림", Font.BOLD, 15));
		button.setBounds(237, 465, 97, 23);
		getContentPane().add(button);
		
		JButton button_1 = new JButton("삭제");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				BankDTO dto = new BankDTO();
				BankDAO dao = new BankDAO();
				
				String id = t1.getText();
				
				dto.setId(id);
				
				dao.delete(dto);
				
			}
		});
		button_1.setFont(new Font("굴림", Font.BOLD, 15));
		button_1.setBounds(360, 465, 97, 23);
		getContentPane().add(button_1);
		
		JButton button_2 = new JButton("아이디검색");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BankDTO dto = new BankDTO();
				BankDAO dao = new BankDAO();
				
				String inputid = t1.getText();
				
				ArrayList list = dao.select(inputid);
				
				for (int i = 0; i < list.size(); i++) {
					dto = (BankDTO)list.get(i);
					JOptionPane.showMessageDialog(null, "아이디 : " + dto.getId());
					JOptionPane.showMessageDialog(null, "이름 : " + dto.getName());
					JOptionPane.showMessageDialog(null, "나이 : " + dto.getAge());
					JOptionPane.showMessageDialog(null, "전화번호 : " + dto.getTel());
				}
			}
		});
		button_2.setFont(new Font("굴림", Font.BOLD, 15));
		button_2.setBounds(154, 528, 124, 23);
		getContentPane().add(button_2);
		
		JLabel lb1 = new JLabel("");
		lb1.setBounds(46, 54, 506, 167);
		getContentPane().add(lb1);
		lb1.setIcon(icon);
		
		JLabel lblNewLabel_1 = new JLabel("아이디");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 15));
		lblNewLabel_1.setBounds(114, 234, 79, 22);
		getContentPane().add(lblNewLabel_1);
		
		JLabel label = new JLabel("이름");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("굴림", Font.BOLD, 15));
		label.setBounds(114, 298, 79, 22);
		getContentPane().add(label);
		
		JLabel label_1 = new JLabel("나이");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("굴림", Font.BOLD, 15));
		label_1.setBounds(114, 357, 79, 22);
		getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("전화번호");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("굴림", Font.BOLD, 15));
		label_2.setBounds(114, 408, 79, 22);
		getContentPane().add(label_2);
		
		JButton button_3 = new JButton("전체검색");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BankDTO dto = new BankDTO();
				BankDAO dao = new BankDAO();
				
				ArrayList list = dao.selectAll(dto);
				
				for (int i = 0; i < list.size(); i++) {
					dto = (BankDTO)list.get(i);
					System.out.println(dto);
				}
			}
		});
		button_3.setFont(new Font("굴림", Font.BOLD, 15));
		button_3.setBounds(311, 528, 107, 23);
		getContentPane().add(button_3);
		
		
		setVisible(true);
		
	}
	public static void main(String[] args) {
		BankManager manager = new BankManager();
	}
}
