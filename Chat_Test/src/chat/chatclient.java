package chat;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;

import javax.naming.StringRefAddr;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URI;
import java.net.URL;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.LayoutManager;
import java.awt.Toolkit;

import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.JTextArea;
import javax.swing.JList;

import java.util.Scanner;
import java.util.Vector;
import javax.swing.border.EtchedBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Desktop;
import javax.swing.JComboBox;

public class chatclient  extends JFrame implements ActionListener,Runnable,WindowListener {
	//이미지 패널
	ImagePanel loginPanel = new ImagePanel(new ImageIcon("D:\\java123\\test12\\bin\\Chat_Test\\img/code-coding_FSPLFPQBCZ.jpg").getImage());
	ImagePanel chatpanel = new ImagePanel(new ImageIcon("D:\\java123\\test12\\bin\\Chat_Test\\img/StockSnap_ADUQHNEED1.jpg").getImage());
	//맴버 변수들
	private JFrame frame;
	private JTextField id;
	private JTextField pw;
	private JTextField nickname_tf;
	private JTextField talk_tf;
	private JLabel inwon_lb = new JLabel("명");	
	private JTextField inwon_tf = new JTextField("0", 3);
	private final JList inwon_li_1 = new JList((Vector) null);
	JScrollPane view_jsp = new JScrollPane((Component) null);
	private Vector inwon_vc = new Vector();
	private JList inwon_li = new JList(inwon_vc);
	private JScrollPane inwon_jsp = new JScrollPane(inwon_li);
	JTextArea view_ta = new JTextArea();
	JButton set_bt = new JButton("대화시작");
	JButton send_bt = new JButton("전송");
	JButton end_bt = new JButton("로그아웃");
	JButton loginbtu = new JButton("");
	JButton homepagemove = new JButton("  맞춤법 검사기로 이동  ");
	private final JLabel lblNewLabel_4 = new JLabel("New label");
	private final JLabel lblNewLabel_3_1 = new JLabel("");
	private final JLabel lblNewLabel_3_2 = new JLabel("");
	private final JLabel lblNewLabel_3_3 = new JLabel("");
	private final JLabel lblNewLabel_3_4 = new JLabel("");
	private final JLabel lblNewLabel_3_5 = new JLabel("");
	private final JLabel lblNewLabel_3_6 = new JLabel("");
	private final JLabel lblNewLabel_3_7 = new JLabel("");
	private final JLabel lblNewLabel_3_7_1 = new JLabel("");
	private final JLabel lblNewLabel_3_7_2 = new JLabel("");
	private final JLabel lblNewLabel_3_7_2_1 = new JLabel("");
	private final JLabel lblNewLabel_3_7_2_2 = new JLabel("");
	private final JLabel lblNewLabel_3_7_2_3 = new JLabel("");
	
	
	//2.네트워크 부분
	private Socket soc;
	private PrintWriter out;
	private BufferedReader in;
	private Thread currentThread;
	

	//생성자
	public chatclient() {	
		this.initialize();
		this.start();
	}

	
	private void initialize() {
			frame = new JFrame();
			frame.getContentPane().setLayout(null);
						
						chatpanel.setBounds(0, 0, 960, 640);
						frame.getContentPane().add(chatpanel);
						chatpanel.setLayout(null);
						
						
						lblNewLabel_3_7_2_3.setIcon(new ImageIcon("D:\\이미지전용\\12312313-removebg-preview.png"));
						lblNewLabel_3_7_2_3.setBounds(0, 407, 192, 266);
						
						chatpanel.add(lblNewLabel_3_7_2_3);
						lblNewLabel_3_7_2_2.setIcon(new ImageIcon("D:\\이미지전용\\12312313-removebg-preview.png"));
						lblNewLabel_3_7_2_2.setBounds(100, 407, 192, 266);
						
						chatpanel.add(lblNewLabel_3_7_2_2);
						lblNewLabel_3_7_2_1.setIcon(new ImageIcon("D:\\이미지전용\\12312313-removebg-preview.png"));
						lblNewLabel_3_7_2_1.setBounds(195, 407, 192, 266);
						
						chatpanel.add(lblNewLabel_3_7_2_1);
						lblNewLabel_3_7_2.setIcon(new ImageIcon("D:\\이미지전용\\12312313-removebg-preview.png"));
						lblNewLabel_3_7_2.setBounds(285, 407, 192, 266);
						
						chatpanel.add(lblNewLabel_3_7_2);
						lblNewLabel_3_7_1.setIcon(new ImageIcon("D:\\이미지전용\\12312313-removebg-preview.png"));
						lblNewLabel_3_7_1.setBounds(375, 407, 192, 266);
						
						chatpanel.add(lblNewLabel_3_7_1);
						lblNewLabel_3_5.setIcon(new ImageIcon("D:\\이미지전용\\12312313-removebg-preview.png"));
						lblNewLabel_3_5.setBounds(639, 407, 192, 266);
						
						chatpanel.add(lblNewLabel_3_5);
						lblNewLabel_3_7.setIcon(new ImageIcon("D:\\이미지전용\\12312313-removebg-preview.png"));
						lblNewLabel_3_7.setBounds(465, 407, 192, 266);
						
						chatpanel.add(lblNewLabel_3_7);
						lblNewLabel_3_6.setIcon(new ImageIcon("D:\\이미지전용\\12312313-removebg-preview.png"));
						lblNewLabel_3_6.setBounds(553, 407, 192, 266);
						
						chatpanel.add(lblNewLabel_3_6);
						lblNewLabel_3_3.setIcon(new ImageIcon("D:\\이미지전용\\12312313-removebg-preview.png"));
						lblNewLabel_3_3.setBounds(730, -60, 192, 266);
						
						chatpanel.add(lblNewLabel_3_3);
						lblNewLabel_3_2.setIcon(new ImageIcon("D:\\이미지전용\\12312313-removebg-preview.png"));
						lblNewLabel_3_2.setBounds(730, 59, 192, 266);
						
						chatpanel.add(lblNewLabel_3_2);
						lblNewLabel_3_1.setIcon(new ImageIcon("D:\\이미지전용\\12312313-removebg-preview.png"));
						lblNewLabel_3_1.setBounds(730, 176, 192, 266);
						
						chatpanel.add(lblNewLabel_3_1);
						
						JLabel lblNewLabel_3 = new JLabel("");
						lblNewLabel_3.setIcon(new ImageIcon("D:\\이미지전용\\12312313-removebg-preview.png"));
						lblNewLabel_3.setBounds(730, 299, 192, 266);
						chatpanel.add(lblNewLabel_3);
						
						JPanel jp5 = new JPanel((LayoutManager) null);
						jp5.setBackground(Color.WHITE);
						jp5.setBounds(0, 0, 419, 60);
						jp5.setBorder(new TitledBorder("NICK NAME"));
						chatpanel.add(jp5);
						jp5.setLayout(null);
						
						nickname_tf = new JTextField();
						nickname_tf.setBounds(6, 19, 277, 21);
						jp5.add(nickname_tf);
						
						set_bt.setBounds(283, 18, 124, 23);
						jp5.add(set_bt);	
						
						view_jsp.setBorder(new TitledBorder("VIEW PANE"));
						view_jsp.setBounds(0, 59, 419, 364);
						chatpanel.add(view_jsp);
						
						view_ta.setForeground(Color.RED);
						view_ta.setFont(new Font("Dialog", Font.BOLD, 15));
						view_ta.setDisabledTextColor(Color.RED);
						view_ta.setBackground(Color.WHITE);
						view_jsp.setViewportView(view_ta);
						
						JPanel jp6 = new JPanel((LayoutManager) null);
						jp6.setBackground(Color.WHITE);
						jp6.setBorder(new TitledBorder("TALK DATA"));
						jp6.setBounds(0, 422, 419, 60);
						chatpanel.add(jp6);
						jp6.setLayout(null);
						
						talk_tf = new JTextField();
						talk_tf.setBounds(6, 17, 262, 35);
						jp6.add(talk_tf);
						send_bt.setBounds(268, 17, 139, 35);		
						jp6.add(send_bt);
						
						
						JPanel jp8 = new JPanel((LayoutManager) null);
						jp8.setBackground(Color.WHITE);
						jp8.setBorder(new TitledBorder("인원표시"));
						jp8.setBounds(418, 0, 327, 313);
						chatpanel.add(jp8);
						jp8.setLayout(new BorderLayout(0, 0));
						
						JPanel jp9 = new JPanel(new GridBagLayout());
						jp9.setBackground(Color.WHITE);
						inwon_tf.setHorizontalAlignment(SwingConstants.CENTER);
						inwon_tf.setBorder(new BevelBorder(BevelBorder.LOWERED));
						inwon_tf.setEditable(false);
						jp9.add(inwon_tf);
						jp9.add(inwon_lb);
						jp9.setBorder(new TitledBorder("총인원"));
						jp8.add("North", jp9);
						jp8.add("Center", inwon_jsp);
						
						JPanel jp10 = new JPanel((LayoutManager) null);
						jp10.setBackground(Color.WHITE);
						jp10.setBorder(new TitledBorder("OPTION"));
						jp10.setBounds(418, 312, 327, 170);
						chatpanel.add(jp10);
						jp10.setLayout(null);
						
								end_bt.setBounds(46, 21, 231, 50);
								jp10.add(end_bt);
								
		homepagemove.setBounds(46, 85, 231, 50);
		jp10.add(homepagemove);
		
		lblNewLabel_3_4.setBounds(730, 407, 192, 266);
		chatpanel.add(lblNewLabel_3_4);
		lblNewLabel_3_4.setIcon(new ImageIcon("D:\\이미지전용\\12312313-removebg-preview.png"));
		chatpanel.setVisible(false);
				
						loginPanel.setBounds(0, 0, 960, 640);
						frame.getContentPane().add(loginPanel);
						
						JLabel lblNewLabel = new JLabel("LOGIN");
						lblNewLabel.setForeground(Color.ORANGE);
						lblNewLabel.setFont(new Font("함초롬바탕", Font.PLAIN, 40));
						lblNewLabel.setBounds(137, 164, 347, 67);
						loginPanel.add(lblNewLabel);
						
						id = new JTextField();
						id.setBackground(Color.getColor("#EAEAEA"));
						id.setToolTipText("\r\n");
						id.setBounds(137, 235, 181, 38);
						loginPanel.add(id);
						id.setColumns(10);
						
						
						pw = new JPasswordField();
						
						pw.setBackground(Color.getColor("#EAEAEA"));
						pw.setToolTipText("");
						pw.setColumns(10);
						pw.setBounds(137, 270, 181, 38);
						pw.selectAll();
						((JPasswordField) pw).setEchoChar('*');
						loginPanel.add(pw);
						
						
						JLabel lblNewLabel_1 = new JLabel("ID");
						lblNewLabel_1.setForeground(Color.BLACK);
						lblNewLabel_1.setFont(new Font("굴림", Font.PLAIN, 30));
						lblNewLabel_1.setBounds(85, 235, 50, 38);
						loginPanel.add(lblNewLabel_1);
						
						JLabel lblNewLabel_1_1 = new JLabel("PW");
						lblNewLabel_1_1.setForeground(Color.BLACK);
						lblNewLabel_1_1.setFont(new Font("굴림", Font.PLAIN, 30));
						lblNewLabel_1_1.setBounds(85, 270, 50, 38);
						loginPanel.add(lblNewLabel_1_1);
						
						
						
						loginbtu.setIcon(new ImageIcon("C:\\Users\\AAAA\\Pictures\\Saved Pictures\\abc.PNG"));
						loginbtu.setBounds(77, 315, 241, 52);
						loginPanel.add(loginbtu);
						lblNewLabel_4.setIcon(new ImageIcon("D:\\이미지전용\\다운로드__1_-removebg-preview (2).png"));
						lblNewLabel_4.setBounds(253, 160, 504, 393);
						
						loginPanel.add(lblNewLabel_4);
				
		GridBagLayout gbl_jp9 = new GridBagLayout();
		gbl_jp9.rowWeights = new double[]{};
		gbl_jp9.columnWeights = new double[]{};
	
		frame.setSize(895,584);
		frame.setBounds(100, 100, 849, 573);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	//이벤트 리스너 실행
	public void start() {

		loginbtu.addActionListener(this);
		end_bt.addActionListener(this);
		nickname_tf.addActionListener(this);
		homepagemove.addActionListener(this);
		set_bt.addActionListener(this);
		talk_tf.addActionListener(this);
		send_bt.addActionListener(this);
		this.addWindowListener(this);
		end_bt.addActionListener(this);
	}
	//이벤트 리스너 기능들
	public void actionPerformed(ActionEvent e) {
		
		
		if (e.getSource() == talk_tf || e.getSource() == send_bt) { 
			String str = talk_tf.getText();
			if (str == null || str.trim().length() == 0)
				
				return;
			
			out.println(str);
			
			out.flush();
			talk_tf.setText("");
			talk_tf.requestFocus();
		} else if (e.getSource() == nickname_tf || e.getSource() == set_bt) {
			String nick = nickname_tf.getText();
			if (nick == null || nick.trim().length() == 0) {
			JOptionPane.showMessageDialog(nickname_tf, "닉네임을 입력하세요!!!");
				return;
			}
			nick = nick.trim();
			try {
				soc = new Socket("localhost", 486);
				
				out = new PrintWriter(new BufferedWriter(
						new OutputStreamWriter(soc.getOutputStream())));
				
				in = new BufferedReader(new InputStreamReader(soc
						.getInputStream()));
				//계속 듣기.. 감시자 붙이기.
				currentThread = new Thread(this);
				currentThread.start();
				out.println(nick);
				out.flush();
				nickname_tf.setEnabled(false);
				set_bt.setEnabled(false);
				talk_tf.requestFocus();
			} catch (IOException ee) {
				System.err.println("접속에러!");
				return;
			}
		} 
		else if (e.getSource() == end_bt) {
			id.setText("");
			out.println("/q");
			out.flush();
			currentThread.interrupt();
			currentThread = null;
			soc = null;
			out = null;
			in = null;
			nickname_tf.setEnabled(true);
			set_bt.setEnabled(true);
			nickname_tf.setText("");
			inwon_vc.clear();
			inwon_vc.add("== Room Member ==");
			inwon_li.setListData(inwon_vc);
			inwon_tf.setText("0");
			view_ta.setText("");
			chatpanel.setVisible(false);
			loginPanel.setVisible(true);
		
			
		}
		else if(e.getSource() == loginbtu)
		{

			String id_tf = id.getText().trim();
			String pw_tf = pw.getText();
			

			if(id_tf.length()==0 || pw_tf.length()==0 ) {

			JOptionPane.showMessageDialog(null, "    ★아이디 또는 비밀번호를 입력하세요★", "★로그인 실패★", JOptionPane.DEFAULT_OPTION);
			return;
			}

			if(id_tf.length()!=0 && pw_tf.length()!=0) {

			JOptionPane.showMessageDialog(null, "로그인 성공", "로그인 확인!", JOptionPane.DEFAULT_OPTION);
			loginPanel.setVisible(false);
			chatpanel.setVisible(true);
			
			return;
			}
			JOptionPane.showMessageDialog(null, "로그인 실패", "로그인 확인!", JOptionPane.DEFAULT_OPTION);

			}
		else if(e.getSource() == homepagemove)
		{
			try {
			    Desktop.getDesktop().browse(new URL("https://search.naver.com/search.naver?"
			    									+"where=nexearch&sm=top_hty&fbm=1&ie=utf8&query=%EB%A7%9E%EC%B6%A4%EB%B2%95%EA%B2%80%EC%82%AC%EA%B8%B0").toURI());
			} 
			catch (Exception e1) {}
		}
		
		
		}
	
	



	public void run() { //감시자...
		view_ta.setEnabled(false);
		view_ta.setText("### 대화방에 입장 하셨습니다. ###\n\n");
		while (true) {
			try {
				String str = in.readLine();
				
				if (str.charAt(0) == '/') {
					if (str.charAt(1) == 'q') {
						String name = str.substring(2).trim();
						view_ta.append("%%% " + name + "님께서 퇴장하셨습니다.%%%\n");
						for (int i = 0; i < inwon_vc.size(); i++) {
							String imsi = (String) inwon_vc.elementAt(i);
							if (imsi.equals(name)) {
								int pos = inwon_li.getSelectedIndex();
								inwon_vc.removeElementAt(i);
								inwon_li.setListData(inwon_vc);
								inwon_li.setSelectedIndex(pos);
								break;
							}
						}
						int xx = Integer.parseInt(inwon_tf.getText());
						inwon_tf.setText(String.valueOf(--xx));
					} else if (str.charAt(1) == 'p') {
						int pos = inwon_li.getSelectedIndex();
						String user = str.substring(2).trim();
						inwon_vc.add(user);
						inwon_li.setListData(inwon_vc);
						inwon_li.setSelectedIndex(pos);
						view_ta.append("*** " + user + "님께서 입장하셨습니다.***\n");
						int xx = Integer.parseInt(inwon_tf.getText().trim());
						inwon_tf.setText(String.valueOf(++xx));
					} else if (str.charAt(1) == 'o') {
						String user = str.substring(2).trim();
						inwon_vc.add(user);
						inwon_li.setListData(inwon_vc);
						int xx = Integer.parseInt(inwon_tf.getText().trim());
						inwon_tf.setText(String.valueOf(++xx));
					}
				} else {
					view_ta.append(str + "\n");
					view_ta.setCaretPosition(view_ta.getText().trim().length()
							- str.trim().length() + 1);
				}
			} catch (IOException ee) {
				System.err.println("read error = " + ee.toString());
			}
		}
		}
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {

		if (out != null) {
			out.println("/q");
			out.flush();
			currentThread.interrupt();
		}
		System.exit(0);
	}
		// TODO Auto-generated method stub
		
	

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	

	


	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run()
			{
								
				try {
					chatclient window = new chatclient();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}



	
class ImagePanel extends JPanel{
	private Image img;
	
	public ImagePanel(Image img){
		this.img = img;
		
		setSize(new Dimension(img.getWidth(null),img.getHeight(null)));
		setPreferredSize(new Dimension(img.getWidth(null), img.getHeight(null)));
		setLayout(null);
	}
	public int getWidth()
	{
		return img.getWidth(null);
		
	}
	public int getight()
	{
		return img.getHeight(null);
	}
	
	
	public void paintComponent(Graphics g){
		g.drawImage(img, 0, 0, null);
	}
	
}
























