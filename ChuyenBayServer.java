import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.awt.event.ActionEvent;

public class ChuyenBayServer {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChuyenBayServer window = new ChuyenBayServer();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ChuyenBayServer() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnStart = new JButton("Start \u0111\u00EA");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					ChuyenBay ChuyenMH370 = new ChuyenBay("MH370","8/3/2014",69,96);
					ChuyenBay ChuyenVJ690 = new ChuyenBay("VJ690","6/3/2015",54,56);
					LocateRegistry.createRegistry(1009);
					try {
						Naming.rebind("MH370Remote",ChuyenMH370);
						Naming.rebind("VJ690Remote",ChuyenVJ690);
					} catch (MalformedURLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					JOptionPane.showMessageDialog(null," Đã đăng ký MH370 OBJ");
			
					JOptionPane.showMessageDialog(null," Đã đăng ký VJ690 OBJ");
					}
				 catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnStart.setBounds(161, 35, 85, 21);
		frame.getContentPane().add(btnStart);
	}
}
