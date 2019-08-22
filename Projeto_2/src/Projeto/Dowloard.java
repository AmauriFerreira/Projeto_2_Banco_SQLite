package Projeto;

import java.awt.EventQueue;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileSystemView;

import dao1.UsuarioDao;
import modelo1.Arquivo;
import modelo1.Usuario;

public class Dowloard extends JFrame {

	private static final String NULL = null;
	private JPanel contentPane;
	private UsuarioDao dao1;
	private File file;
	private JLabel txtFile;
	public static String id;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dowloard frame = new Dowloard ();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}



	public Dowloard() throws Exception {

		// TODO Auto-generated constructor stub
		JLabel lbl = new JLabel();

		dao1 = new UsuarioDao();

		JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

		int returnValue = jfc.showOpenDialog(null);
		File selectedFile = jfc.getSelectedFile();
		int returnValue1 = jfc.showSaveDialog(null);
		
		if (returnValue1 == JFileChooser.APPROVE_OPTION) {
			//File selectedFile = jfc.getSelectedFile();
			System.out.println(selectedFile.getAbsolutePath());
			//dao1.IncluirAquivo(selectedFile,materia,assunto,id); 
			
		}

	}



}

