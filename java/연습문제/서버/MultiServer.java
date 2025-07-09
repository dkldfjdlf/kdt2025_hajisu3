package hajisu;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiServer {
	final static int nPort = 8000;

	public static void main(String[] args) {
		MultiServer multiServer = new MultiServer();
		multiServer.start();
	}

	public void start() {
		ServerSocket serverSocket = null;
		Socket socket = null;
		try {
			serverSocket = new ServerSocket(nPort);
			while (true) {
				System.out.println("[클라이언트 연결대기중]");
				socket = serverSocket.accept();
				ReceiveThread receiveThread = new ReceiveThread(socket);
				receiveThread.start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (serverSocket != null) {
				try {
					serverSocket.close();
					System.out.println("[서버종료]");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}