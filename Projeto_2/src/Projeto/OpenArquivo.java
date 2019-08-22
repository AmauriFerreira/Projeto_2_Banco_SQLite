package Projeto;

import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import dao1.UsuarioDao;
import modelo1.Usuario;


public class OpenArquivo {
	private UsuarioDao dao1;
	JFrame frame;
	protected String cod;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OpenArquivo window = new OpenArquivo(null);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @param string 
	 */
	public OpenArquivo(String string) {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 846, 482);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		UsuarioDao dao1 = new UsuarioDao();
		JButton btnNewButton = new JButton("Open PDF");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
				Runtime.getRuntime().exec("rundll32.exe url.dll,FileProtocolHandler" + "C:\\Users\\Amauri\\Desktop\\ingles\\AEF_1_Quicktest_4.pdf");
					//new File("C:\\Users\\Amauri\\Desktop\\ingles\\AEF_1_Quicktest_4.pdf");
					
				
					//Desktop.getDesktop().open(dao1.getFile(4));
					
				}
				catch(Exception e1){
					JOptionPane.showMessageDialog(null, "Não foi possivel abrir PDF");
				}
			}

		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 45));
		btnNewButton.setBounds(27, 25, 793, 408);
		frame.getContentPane().add(btnNewButton);
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}

	}

