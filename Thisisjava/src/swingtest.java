import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class swingtest {
	Users[] userList;

	Connection conn;
	Statement stmt;
	ResultSet rs;
	PreparedStatement psmt;

	int login_users;

	private JFrame frame;
	private JPanel bus_main;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel;
	private JTextField login_id;
	private JLabel lblNewLabel_1;
	private JTextField login_pass;
	private JPanel bus_sub1;
	private JPanel bus_login;
	private JPanel busMyinfo;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JTextField pass;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JTextField birth;
	private JButton btnNewButton;
	private JButton Btn_login;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JTextField name;
	private JTextField id;
	boolean isJoin = false;
	private JButton backicon;
	private JLabel username;
	private JTextField Chargemoney;
	private JLabel lblNewLabel_9;
	private JPanel bus_charge;
	private JButton backicon_1;
	private JButton ChargeBtn;
	private JLabel usermoney;
	private JPanel busPay;
	private JTable table;
	private JPanel panel;
	private JLabel Buschoice;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					swingtest window = new swingtest();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * 
	 * @throws SQLException
	 */
	public swingtest() throws SQLException {

		userList = new Users[100];

		for (int i = 0; i < userList.length; i++) {
			userList[i] = new Users();
		}

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("드라이버연결");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "java", "mysql");
			System.out.println("디비연결");

			initialize();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\_yhj\\bus\\bin\\image\\login_bus.png"));
		frame.setTitle("BusApp");
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setLayout(null);

		bus_main = new JPanel();
		bus_main.setBounds(0, 0, 354, 591);
		frame.getContentPane().add(bus_main);
		bus_main.setLayout(null);

		lblNewLabel = new JLabel("아이디");
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(58, 368, 74, 36);
		bus_main.add(lblNewLabel);

		login_id = new JTextField();
		login_id.setBounds(133, 368, 167, 36);
		bus_main.add(login_id);
		login_id.setColumns(10);

		lblNewLabel_1 = new JLabel("비밀번호");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		lblNewLabel_1.setBounds(58, 414, 74, 36);
		bus_main.add(lblNewLabel_1);

		login_pass = new JTextField();
		login_pass.setColumns(10);
		login_pass.setBounds(133, 414, 167, 36);
		bus_main.add(login_pass);

		btnNewButton = new JButton("");
		btnNewButton.setBorderPainted(false);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setFocusPainted(false);

		btnNewButton.setBounds(125, 492, 97, 23);
		bus_main.add(btnNewButton);

		Btn_login = new JButton("");

		Btn_login.setFocusPainted(false);
		Btn_login.setContentAreaFilled(false);
		Btn_login.setBorderPainted(false);
		Btn_login.setBounds(61, 525, 246, 43);
		bus_main.add(Btn_login);

		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(-9, -10, 370, 630);
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\admin\\Desktop\\bus-image\\busTitle.png"));
		bus_main.add(lblNewLabel_3);

		// 로그인버튼
		Btn_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					login();

				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.fillInStackTrace();
				}
			}
		});

		// 회원가입버튼
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bus_main.setVisible(false);
				bus_login.setVisible(false);
				busMyinfo.setVisible(false);
				bus_charge.setVisible(false);
				busPay.setVisible(false);
				Buschoice.setVisible(false);
				bus_sub1.setVisible(true);
			}
		});

		panel = new JPanel();
		panel.setBounds(0, 0, 354, 591);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		Buschoice = new JLabel("");
		Buschoice.setIcon(new ImageIcon("C:\\Users\\admin\\Desktop\\bus-image\\busBuy.png"));
		Buschoice.setBounds(-9, -10, 370, 630);
		panel.add(Buschoice);

		bus_charge = new JPanel();
		bus_charge.setBounds(0, 0, 354, 591);
		frame.getContentPane().add(bus_charge);
		bus_charge.setLayout(null);

		backicon_1 = new JButton("");
		backicon_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bus_main.setVisible(false);
				bus_login.setVisible(false);
				busMyinfo.setVisible(true);
				bus_sub1.setVisible(false);
				bus_charge.setVisible(false);
				busPay.setVisible(false);
				Buschoice.setVisible(false);
			}
		});

		ChargeBtn = new JButton(""); //
		ChargeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// System.out.println(userList[login_users].money + getText);
			}
		});
		ChargeBtn.setFocusPainted(false);
		ChargeBtn.setContentAreaFilled(false);
		ChargeBtn.setBorderPainted(false);
		ChargeBtn.setBounds(59, 523, 246, 43);
		bus_charge.add(ChargeBtn);
		backicon_1.setFocusPainted(false);
		backicon_1.setContentAreaFilled(false);
		backicon_1.setBorderPainted(false);
		backicon_1.setBounds(12, 10, 63, 32);
		bus_charge.add(backicon_1);

		Chargemoney = new JTextField();
		Chargemoney.setFont(new Font("나눔고딕", Font.PLAIN, 18));
		Chargemoney.setColumns(10);
		Chargemoney.setBounds(62, 428, 237, 58);
		bus_charge.add(Chargemoney);

		lblNewLabel_9 = new JLabel("New label");
		lblNewLabel_9.setIcon(new ImageIcon("C:\\Users\\admin\\Desktop\\bus-image\\busCharge3.png"));
		lblNewLabel_9.setBounds(-9, -10, 370, 630);
		bus_charge.add(lblNewLabel_9);

		ChargeBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String id = login_id.getText();

				if (Chargemoney.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "충전 금액을 입력하셔야합니다");
				} else {
					// int money = userList[login_users].money +
					// Integer.parseInt(Chargemoney.getText());
					int money = userList[login_users].money + Integer.parseInt(Chargemoney.getText());
					try {
						charge(id, money);

						stmt = conn.createStatement();
						rs = stmt.executeQuery("select * from users");
						int index = 0;
						while (rs.next()) {

							userList[index] = new Users(rs.getString("userid"), rs.getString("password"),
									rs.getString("name"), rs.getString("birth"), rs.getInt("money"));

							index++;

						}

					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					JOptionPane.showMessageDialog(null, "충전 완료");
					bus_main.setVisible(false);
					bus_login.setVisible(false);
					busMyinfo.setVisible(true);
					bus_sub1.setVisible(false);
					bus_charge.setVisible(false);
					busPay.setVisible(false);
					Buschoice.setVisible(false);
					System.out.println(userList[login_users].money);
					usermoney.setText(userList[login_users].money + "");
					Chargemoney.setText("");
				}

			}

		});

		bus_sub1 = new JPanel();
		bus_sub1.setBounds(0, 0, 354, 591);
		frame.getContentPane().add(bus_sub1);
		bus_sub1.setLayout(null);

		btnNewButton_3 = new JButton("");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					if (isJoin) {
						insert();
						JOptionPane.showMessageDialog(null, "회원가입 완료!");
						bus_main.setVisible(true);
						bus_login.setVisible(false);
						busMyinfo.setVisible(false);
						bus_sub1.setVisible(false);
						bus_charge.setVisible(false);
						busPay.setVisible(false);
						Buschoice.setVisible(false);
						frame.revalidate();
						frame.repaint();
						isJoin = true;
					} else {
						JOptionPane.showMessageDialog(null, "중복체크를 완료해주세요.");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		name = new JTextField();
		name.setFont(new Font("나눔고딕", Font.PLAIN, 16));
		name.setColumns(10);
		name.setBounds(58, 337, 243, 35);
		bus_sub1.add(name);

		id = new JTextField();
		id.setFont(new Font("나눔고딕", Font.PLAIN, 16));
		id.setColumns(10);
		id.setBounds(58, 183, 154, 35);
		bus_sub1.add(id);
		btnNewButton_3.setFocusPainted(false);
		btnNewButton_3.setContentAreaFilled(false);
		btnNewButton_3.setBorderPainted(false);
		btnNewButton_3.setBounds(58, 525, 243, 42);
		bus_sub1.add(btnNewButton_3);

		btnNewButton_2 = new JButton("");

		btnNewButton_2.setFocusPainted(false);
		btnNewButton_2.setContentAreaFilled(false);
		btnNewButton_2.setBorderPainted(false);
		btnNewButton_2.setBounds(143, 486, 69, 27);
		bus_sub1.add(btnNewButton_2);

		lblNewLabel_6 = new JLabel("이름");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		lblNewLabel_6.setBounds(82, 305, 188, 22);
		bus_sub1.add(lblNewLabel_6);

		lblNewLabel_5 = new JLabel("비밀번호");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		lblNewLabel_5.setBounds(82, 228, 188, 22);
		bus_sub1.add(lblNewLabel_5);

		pass = new JTextField();
		pass.setFont(new Font("나눔고딕", Font.PLAIN, 16));
		pass.setColumns(10);
		pass.setBounds(58, 260, 243, 35);
		bus_sub1.add(pass);

		lblNewLabel_4 = new JLabel("아이디");
		lblNewLabel_4.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(82, 151, 188, 22);
		bus_sub1.add(lblNewLabel_4);

		birth = new JTextField();
		birth.setFont(new Font("나눔고딕", Font.PLAIN, 16));
		birth.setColumns(10);
		birth.setBounds(58, 414, 243, 35);
		bus_sub1.add(birth);

		lblNewLabel_7 = new JLabel("생년월일");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		lblNewLabel_7.setBounds(82, 382, 188, 22);
		bus_sub1.add(lblNewLabel_7);

		JButton nametest = new JButton("중복확인");
		nametest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					selectAll();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		nametest.setBackground(SystemColor.window);
		nametest.setHorizontalAlignment(SwingConstants.LEFT);
		nametest.setFont(new Font("맑은 고딕", Font.PLAIN, 11));
		nametest.setBounds(221, 183, 81, 35);
		bus_sub1.add(nametest);

		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\admin\\Desktop\\bus-image\\busJoin.png"));
		lblNewLabel_2.setBounds(-9, -10, 370, 630);
		bus_sub1.add(lblNewLabel_2);

		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bus_main.setVisible(true);
				bus_login.setVisible(false);
				busMyinfo.setVisible(false);
				bus_sub1.setVisible(false);
				bus_charge.setVisible(false);
				busPay.setVisible(false);
				Buschoice.setVisible(false);
			}
		});

		busPay = new JPanel();
		busPay.setBounds(0, 0, 354, 591);
		frame.getContentPane().add(busPay);
		busPay.setLayout(null);

		table = new JTable();
		table.setBounds(0, 0, 1, 1);
		busPay.add(table);

		JLabel butPaybg = new JLabel("New label");
		butPaybg.setIcon(new ImageIcon("C:\\Users\\admin\\Desktop\\bus-image\\busMain3.png"));
		butPaybg.setBounds(-9, -10, 370, 630);
		busPay.add(butPaybg);

		busPay.setVisible(false);

		busMyinfo = new JPanel();
		busMyinfo.setBounds(0, 0, 354, 591);
		frame.getContentPane().add(busMyinfo);
		busMyinfo.setLayout(null);

		backicon = new JButton("");
		backicon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bus_main.setVisible(false);
				bus_login.setVisible(true);
				busMyinfo.setVisible(false);
				bus_sub1.setVisible(false);
				bus_charge.setVisible(false);
				busPay.setVisible(false);
				Buschoice.setVisible(false);
			}
		});

		JButton Buscharge = new JButton("");
		Buscharge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bus_main.setVisible(false);
				bus_login.setVisible(false);
				busMyinfo.setVisible(false);
				bus_sub1.setVisible(false);
				bus_charge.setVisible(true);
				busPay.setVisible(false);
				Buschoice.setVisible(false);
			}
		});
		Buscharge.setFocusPainted(false);
		Buscharge.setContentAreaFilled(false);
		Buscharge.setBorderPainted(false);
		Buscharge.setBounds(30, 404, 128, 25);

		busMyinfo.add(Buscharge);
		JButton Busbuy = new JButton("");
		Busbuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bus_main.setVisible(false);
				bus_login.setVisible(false);
				busMyinfo.setVisible(false);
				bus_sub1.setVisible(false);
				bus_charge.setVisible(false);
				busPay.setVisible(true);
				Buschoice.setVisible(false);
			}
		});
		Busbuy.setFocusPainted(false);
		Busbuy.setContentAreaFilled(false);
		Busbuy.setBorderPainted(false);
		Busbuy.setBounds(30, 281, 128, 32);
		busMyinfo.add(Busbuy);

		username = new JLabel("");
		username.setHorizontalAlignment(SwingConstants.CENTER);
		username.setForeground(Color.BLACK);
		username.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		username.setBounds(30, 49, 60, 22);
		busMyinfo.add(username);

		usermoney = new JLabel("");
		usermoney.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		usermoney.setForeground(new Color(0, 0, 0));
		usermoney.setHorizontalAlignment(SwingConstants.CENTER);
		usermoney.setBounds(136, 169, 63, 54);
		busMyinfo.add(usermoney);
		backicon.setFocusPainted(false);
		backicon.setContentAreaFilled(false);
		backicon.setBorderPainted(false);
		backicon.setBounds(12, 10, 63, 32);
		busMyinfo.add(backicon);

		JLabel lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.setIcon(new ImageIcon("C:\\Users\\admin\\Desktop\\bus-image\\busMyInfo5.png"));
		lblNewLabel_2_1.setBounds(-9, -10, 370, 630);
		busMyinfo.add(lblNewLabel_2_1);

		bus_login = new JPanel();
		bus_login.setBounds(0, 0, 354, 591);
		frame.getContentPane().add(bus_login);
		bus_login.setLayout(null);

		JButton BtnMyinfo_1 = new JButton("");
		BtnMyinfo_1.setFocusPainted(false);
		BtnMyinfo_1.setContentAreaFilled(false);
		BtnMyinfo_1.setBorderPainted(false);
		BtnMyinfo_1.setBounds(293, 13, 38, 31);
		bus_login.add(BtnMyinfo_1);

		JButton BtnMyinfo = new JButton("");
		BtnMyinfo.setBounds(13, 20, 45, 24);
		BtnMyinfo.setFocusPainted(false);
		BtnMyinfo.setContentAreaFilled(false);
		BtnMyinfo.setBorderPainted(false);
		bus_login.add(BtnMyinfo);

		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setBounds(-9, 0, 370, 630);
		lblNewLabel_8.setIcon(new ImageIcon("C:\\Users\\admin\\Desktop\\bus-image\\busMain3.png"));
		bus_login.add(lblNewLabel_8);
		
		bus_main.setVisible(true);
		bus_login.setVisible(false);
		busMyinfo.setVisible(false);
		bus_sub1.setVisible(false);
		bus_charge.setVisible(false);
		busPay.setVisible(false);
		Buschoice.setVisible(false);
		

		// // 햄버거 메뉴 클릭 ( 충전하기 )
		BtnMyinfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// int charge = Integer.parseInt(Chargemoney.getText().toString());

				bus_main.setVisible(false);
				bus_login.setVisible(false);
				busMyinfo.setVisible(true);
				bus_sub1.setVisible(false);
				bus_charge.setVisible(false);
				busPay.setVisible(false);
				Buschoice.setVisible(false);
				username.setText(userList[login_users].name);
				usermoney.setText(userList[login_users].money + "");
				// usermoney.setText(user + "");

			}
		});

		frame.setBounds(100, 100, 370, 630);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		busDb();
	}

	// 회원가입
	public void insert() throws SQLException {
		stmt = conn.createStatement();
		int resulte = stmt.executeUpdate("insert into users(userid, password, name, birth) values('" + id.getText()
				+ "','" + pass.getText() + "','" + name.getText() + "','" + birth.getText() + "')");
		System.out.println(resulte + "전송완료");

	}

	// 중복체크
	public void selectAll() throws SQLException {

		stmt = conn.createStatement();
		rs = stmt.executeQuery("select * from users");

		int index = 0;
		while (rs.next()) {

			userList[index] = new Users(rs.getString("userid"), rs.getString("password"), rs.getString("name"),
					rs.getString("birth"), rs.getInt("money"));

			index++;

		}

		for (int i = 0; i < userList.length; i++) {
			if (userList[i].userid == null) {
				JOptionPane.showMessageDialog(null, "사용 가능한 아이디입니다.");
				isJoin = true;
				break;
			}
			if (userList[i].userid != null) {
				if (userList[i].userid.equals(id.getText())) {
					JOptionPane.showMessageDialog(null, "다른 아이디를 입력해주세요.");
					break;
				}
			}

		}

	}

	// 로그인
	public void login() throws SQLException {

		stmt = conn.createStatement();
		rs = stmt.executeQuery("select * from users");
		int index = 0;
		while (rs.next()) {

			userList[index] = new Users(rs.getString("userid"), rs.getString("password"), rs.getString("name"),
					rs.getString("birth"), rs.getInt("money"));

			index++;

		}

		for (int i = 0; i < userList.length; i++) {
			if (userList[i].userid == null) {
				JOptionPane.showMessageDialog(null, "존재하지 않는 아이디입니다. 회원가입을 해주세요.");
				break;
			}
			if (userList[i].userid != null) {
				if (userList[i].userid.equals(login_id.getText())
						&& userList[i].password.equals(login_pass.getText())) {
					JOptionPane.showMessageDialog(null, "로그인 성공!");
					login_users = i;

					bus_main.setVisible(false);
					bus_login.setVisible(true);
					busMyinfo.setVisible(false);
					bus_sub1.setVisible(false);
					bus_charge.setVisible(false);
					busPay.setVisible(false);
					Buschoice.setVisible(false);

					break;
				}
			}

		}
	}

	public void check() throws SQLException {
		stmt = conn.createStatement();
		rs = stmt.executeQuery("select * from users");
		int index = 0;
		while (rs.next()) {

			userList[index] = new Users(rs.getString("userid"), rs.getString("password"), rs.getString("name"),
					rs.getString("birth"), rs.getInt("money"));

			index++;

		}
	}

// 충전 하기 이벤트
	public int charge(String id, int money) throws SQLException {
//      String sql = "UPDATE users set money = ? where id =?";
		String sql = "update users set money=" + money + " where userid='" + id + "'";
		psmt = conn.prepareStatement(sql);
		int result = psmt.executeUpdate();
		return result;
	}

	public void busDb() {
		String sql = "Select * from buslist";
		ArrayList list = new ArrayList();
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

			while (rs.next()) {
				list.add(new BusList(rs.getString("start"), rs.getString("end"), rs.getString("start"),
						rs.getString("class"), rs.getInt("seats"), rs.getInt("price"), rs.getString("date")));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}