package client;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ClientWindow extends JFrame {
	
	public ClientScreen clientScreen;

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientWindow frame = new ClientWindow();
					frame.setVisible(true);

					new Thread(new GetScreenCaptureStreamThread(frame.clientScreen)).start();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	/**
	 * Create the frame.
	 */
	public ClientWindow() {
		setResizable(false);
		setTitle("ÆÁÄ»·ÖÏí¿Í»§¶Ë");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		
		clientScreen = new ClientScreen();
		clientScreen.setBounds(0, 0, 800, 600);
		contentPane.add(clientScreen);
		
		setContentPane(contentPane);
	}

}
