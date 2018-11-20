import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class ClientGUI {

	private JFrame frame;
	private JTextField ipCliente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientGUI window = new ClientGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws UnknownHostException 
	 */
	public ClientGUI() throws UnknownHostException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws UnknownHostException 
	 */
	private void initialize() throws UnknownHostException {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblIpCliente = new JLabel("Ip Cliente");
		lblIpCliente.setBounds(10, 69, 46, 14);
		frame.getContentPane().add(lblIpCliente);
		
		JLabel lblCliente = new JLabel("Cliente");
		lblCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblCliente.setFont(new Font("Bradley Hand ITC", Font.BOLD, 30));
		lblCliente.setBounds(10, 11, 424, 44);
		frame.getContentPane().add(lblCliente);
		
		ipCliente = new JTextField();
		ipCliente.setBounds(66, 66, 116, 20);
		frame.getContentPane().add(ipCliente);
		ipCliente.setColumns(10);
		ipCliente.setText(InetAddress.getLocalHost().getHostAddress());
	}
}
