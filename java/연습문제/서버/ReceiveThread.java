package hajisu;

import java.io.*;
import java.net.Socket;
import java.util.*;

public class ReceiveThread extends Thread {

	static List<PrintWriter> list = Collections.synchronizedList(new ArrayList<PrintWriter>());

	Socket socket = null;
	BufferedReader in = null;
	PrintWriter out = null;

	public ReceiveThread(Socket socket) {
		this.socket = socket;
		try {
			in = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);
			list.add(out);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		String name = "";
		try {
			name = in.readLine(); // 이름 받기
			System.out.println("[" + name + " 새연결생성]");
			sendAll("[" + name + "]님이 들어오셨습니다.");

			while (in != null) {
				String inputMsg = in.readLine();
				if ("quit".equals(inputMsg)) break;
				sendAll(name + " >> " + inputMsg);
			}
		} catch (IOException e) {
			System.out.println("[" + name + " 접속끊김]");
		} finally {
			sendAll("[" + name + "]님이 나가셨습니다");
			list.remove(out);
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("[" + name + " 연결종료]");
		}
	}

	private void sendAll(String s) {
		for (PrintWriter out : list) {
			out.println(s);
		}
	}
}