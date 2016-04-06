package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.imageio.ImageIO;

public class GetScreenCaptureStreamThread implements Runnable {
	public static final int PORT = 7789;
	public static final String IP_ADDR = "localhost";
	
	boolean IsRun;
	
	ClientScreen clientScreen;
	
	public GetScreenCaptureStreamThread(ClientScreen clientScreen) {
		this.clientScreen = clientScreen;
		this.IsRun = true;
	}

	@Override
	public void run() {
		System.out.println("传输线程运行开始");
		Socket socket = null;
		try {
			while (this.IsRun){
				socket = new Socket(IP_ADDR,PORT);
				System.out.println("发送服务器请求");
				this.clientScreen.bufferedImage = ImageIO.read(socket.getInputStream());
				this.clientScreen.repaint();
				socket.close();
				//this.IsRun = false;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
