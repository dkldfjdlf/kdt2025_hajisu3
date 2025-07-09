package hajisu;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class SendThread extends Thread {
	Socket socket = null;
	String name;

	Scanner scanner = new Scanner(System.in);

	public SendThread(Socket socket, String name) {
		this.socket = socket;
		this.name = name;
	}

	@Override
	public void run() {
		try {
			PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);
			out.println(name); // 이름 전송

			while (true) {
				String outputMsg = scanner.nextLine();
				out.println(outputMsg);
				if ("quit".equals(outputMsg)) break;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}