import java.awt.EventQueue;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class ChuyenBayClient {
	ChuyenBayInterface obj;
	private JFrame frame;
	private JTextField tfMH;
	private JTextField tfTGB;
	private JTextField tfGT;
	private JTextField tfDB;
	String[] chuyen= {"Chuyến 1", "chuyến 2"};

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChuyenBayClient window = new ChuyenBayClient();
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
	public ChuyenBayClient() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
	
		String x= JOptionPane.showInputDialog("Nhập chuyến bay 1 hoặc 2");
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		try {
			if(x=="1")
			obj= (ChuyenBayInterface)Naming.lookup("rmi://192.168.1.82/VJ690Remote");
			else obj= (ChuyenBayInterface)Naming.lookup("rmi://192.168.1.82/MH370Remote");
		} catch (MalformedURLException | RemoteException | NotBoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		JButton btnThngTinChuyn = new JButton("Th\u00F4ng tin chuy\u1EBFn bay");
		btnThngTinChuyn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setTT();
			}
		});
		btnThngTinChuyn.setBounds(10, 28, 140, 21);
		frame.getContentPane().add(btnThngTinChuyn);
		
		JLabel lblMHiu = new JLabel("M\u00E3 hi\u1EC7u");
		lblMHiu.setBounds(20, 59, 67, 13);
		frame.getContentPane().add(lblMHiu);
		
		JLabel lblThiGianBay = new JLabel("Th\u1EDDi gian bay");
		lblThiGianBay.setBounds(20, 105, 67, 13);
		frame.getContentPane().add(lblThiGianBay);
		
		JLabel lblGhTrng = new JLabel("Gh\u1EBF tr\u1ED1ng");
		lblGhTrng.setBounds(20, 141, 67, 13);
		frame.getContentPane().add(lblGhTrng);
		
		JLabel lblGhBn = new JLabel("Gh\u1EBF \u0111\u00E3 b\u00E1n");
		lblGhBn.setBounds(20, 180, 67, 13);
		frame.getContentPane().add(lblGhBn);
		
		tfMH = new JTextField();
		tfMH.setEditable(false);
		tfMH.setBounds(109, 59, 96, 19);
		frame.getContentPane().add(tfMH);
		tfMH.setColumns(10);
		
		tfTGB = new JTextField();
		tfTGB.setEditable(false);
		tfTGB.setBounds(109, 102, 96, 19);
		frame.getContentPane().add(tfTGB);
		tfTGB.setColumns(10);
		
		tfGT = new JTextField();
		tfGT.setEditable(false);
		tfGT.setColumns(10);
		tfGT.setBounds(109, 138, 96, 19);
		frame.getContentPane().add(tfGT);
		
		tfDB = new JTextField();
		tfDB.setEditable(false);
		tfDB.setColumns(10);
		tfDB.setBounds(109, 177, 96, 19);
		frame.getContentPane().add(tfDB);
		
		JButton btntV = new JButton("\u0110\u1EB7t v\u00E9");
		btntV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(obj.getGT()<=0) {
						JOptionPane.showMessageDialog(null, "Hết vé rồi em","Hết vé -_-", 3);
					}
					else obj.datve();
					setTT();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btntV.setBounds(20, 219, 85, 21);
		frame.getContentPane().add(btntV);
		
		JButton btnTrV = new JButton("Tr\u1EA3 v\u00E9");
		btnTrV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
				obj.trave();
				setTT();
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			}
		});
		setTT();
		btnTrV.setBounds(164, 219, 85, 21);
		frame.getContentPane().add(btnTrV);
		
		JComboBox comboBox = new JComboBox(chuyen);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
				if(comboBox.getSelectedItem()=="Chuyến 1")
					obj= (ChuyenBayInterface)Naming.lookup("rmi://192.168.1.82/VJ690Remote");
				else obj= (ChuyenBayInterface)Naming.lookup("rmi://192.168.1.82/MH370Remote");
				setTT();
			} catch (MalformedURLException | RemoteException | NotBoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}		
			}
		});
		comboBox.setBounds(177, 28, 96, 21);
		frame.getContentPane().add(comboBox);
	}
	public void setTT() {
		try {
			tfMH.setText(obj.getMH());
			tfDB.setText(String.valueOf(obj.getGDB()));
			tfGT.setText(String.valueOf(obj.getGT()));
			tfTGB.setText(obj.getTGB());
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
