package chat;

import java.io.*;
import java.net.*;
import java.util.*;

class ChatServer extends Thread



{
	private ServerSocket ss;
	private Vector vc = new Vector();
	
	public ChatServer() 
	{
		try
		{
			ss = new ServerSocket(486); 
			this.start();
			System.out.println("서버를 시작!..클라이언트 접속 대기중...");
		} 
		catch (IOException ee) 
		{
			System.err.println("이미 사용중입니다.");
			System.exit(0);
		}
	}

	public void run() 
	{
		while (true) 
		{
			try 
			{
				Socket socket = ss.accept();
				System.out.println("접속자 : " + socket.toString());
				UserInfo ui = new UserInfo(socket);
				for (int i = 0; i < vc.size(); i++) 
				{
					UserInfo uiui = (UserInfo) vc.elementAt(i);
					uiui.getOut().println("/p" + ui.getNickName());
					uiui.getOut().flush();
				}
				vc.add(ui); 
				for (int i = 0; i < vc.size(); i++) 
				{
					UserInfo uiui = (UserInfo) vc.elementAt(i);
					ui.getOut().println("/o" + uiui.getNickName());
					ui.getOut().flush();
				}
			} catch (IOException ee) {
			}
		}
	}

	class UserInfo extends Thread 
	{ 
		private Socket soc;
		private String nickname;
		private PrintWriter out;
		private BufferedReader in;

		public UserInfo(Socket s) 
		{
			this.soc = s;
			try 
			{
				out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(soc.getOutputStream())));// 송신(출력) - 파일,콘솔이 아닌 네트워크 스트림! 
				in = new BufferedReader(new InputStreamReader(soc.getInputStream())); // 수신(입력) - 파일,콘솔이 아닌 네트워크 스트림!
				nickname = in.readLine();
				this.start();
			} 
			catch (IOException ee) 
			{
				System.err.println("UserInfo Error.");
			}
		}

		public String getNickName() 
		{
			return nickname;
		}

		public PrintWriter getOut()
		{
			return out;
		}

		public void run() {
			while (true) 
			{
				try 
				{
					String str = in.readLine();
					if (str.charAt(0) == '/') 
					{
						if (str.charAt(1) == 'q') 
						{
							for (int i = 0; i < vc.size(); i++) 
							{
								UserInfo ui = (UserInfo) vc.elementAt(i);
								if (ui.nickname.equals(nickname)) 
								{
									vc.removeElementAt(i);
									break;
								}
							}
							for (int i = 0; i < vc.size(); i++) 
							{
								UserInfo ui = (UserInfo) vc.elementAt(i);
								ui.out.println("/q" + nickname);
								ui.out.flush();
							}
							break; 
						} 
					}
					else 
					{
						for (int i = 0; i < vc.size(); i++) 
						{
							UserInfo ui = (UserInfo) vc.elementAt(i);
							String data = nickname + " > " + str;
							ui.out.println(data);
							ui.out.flush();
						}
					}
				} 
				catch (IOException ee) 
				{
				}
			}
		}
	}
}



public class ChattingServer {
	public static void main(String[] args)
	{
		ChatServer cs = new ChatServer();
	}
}
