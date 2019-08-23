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

public class Upload extends JFrame {

	private static final String NULL = null;
	private JPanel contentPane;
	private UsuarioDao dao1;
	private File file;
	private JLabel txtFile;
	public static String id;
	public static String assunto;
	public static String materia;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Upload frame = new Upload ( materia,assunto,id);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}



	public Upload(String materia,String assunto,String id) throws Exception {

		// TODO Auto-generated constructor stub
		JLabel lbl = new JLabel();

		dao1 = new UsuarioDao();

		JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

		int returnValue = jfc.showOpenDialog(null);
		File selectedFile = jfc.getSelectedFile();
		String linha = selectedFile.getAbsolutePath();
		linha = linha.replaceAll("\\  ", " \\ \\  ");
		Runtime.getRuntime().exec("rundll32.exe url.dll,FileProtocolHandler"+ selectedFile.getAbsolutePath());
		int returnValue1 = jfc.showSaveDialog(null);
		
		if (returnValue1 == JFileChooser.APPROVE_OPTION) {
			System.out.println(selectedFile.getAbsolutePath());
			dao1.IncluirAquivo(selectedFile,materia,assunto,id); 
			
		}

	}

	//public void setVisible(boolean b) {
	// TODO Auto-generated method stub

}

