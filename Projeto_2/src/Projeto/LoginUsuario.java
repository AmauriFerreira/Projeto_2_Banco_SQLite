package Projeto;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import modelo1.Usuario;
import dao1.UsuarioDao;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.ImageIcon;

public class LoginUsuario extends JFrame {

	private JPanel contentPane;
	private JPasswordField PasswordField_1;
	private JTextField textField_2;
	private JLabel lblNewLabel_3;
	private JButton btnNewButton;
	private JButton btnFazerCadastro;
	private UsuarioDao dao1;
	private Usuario usuario;
	public static String id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginUsuario frame = new LoginUsuario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginUsuario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 672, 426);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.setBackground(new Color(255, 255, 255));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnNewButton = new JButton("Fazer login") ;
		btnNewButton.setVisible(true); 
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnNewButton.setBackground(new Color(255, 0, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					//dao1.altera(new Usuario( textField_2.getText(),null),null);
					validar();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBounds(359, 325, 287, 51);
		contentPane.add(btnNewButton);

		PasswordField_1 = new JPasswordField();
		PasswordField_1.setColumns(10);
		PasswordField_1.setBounds(359, 177, 287, 44);
		contentPane.add(PasswordField_1);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(359, 80, 287, 44);
		contentPane.add(textField_2);

		JLabel lblNewLabel = new JLabel("Email:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(359, 43, 58, 26);
		contentPane.add(lblNewLabel);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSenha.setBounds(359, 146, 58, 26);
		contentPane.add(lblSenha);

		btnFazerCadastro = new JButton("Fazer cadastro");
		btnFazerCadastro.setVisible(false); 
		btnFazerCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CadastroUsuario().setVisible(true);//abrir Cadastro
				dispose();
			}
		});
		btnFazerCadastro.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnFazerCadastro.setBackground(new Color(255, 0, 0));
		btnFazerCadastro.setForeground(new Color(255, 255, 255));
		btnFazerCadastro.setBounds(357, 324, 287, 53);
		contentPane.add(btnFazerCadastro);

		//Chama dao1////////
		dao1 = new UsuarioDao();
		//Chama dao1////////

		JPanel panel = new JPanel();
		panel.setForeground(new Color(204, 204, 153));
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 349, 386);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("Sistema de Ensino");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.ITALIC, 22));
		lblNewLabel_2.setForeground(new Color(238, 232, 170));
		lblNewLabel_2.setBounds(64, 331, 187, 22);
		lblNewLabel_2.setVerticalAlignment(SwingConstants.BOTTOM);
		panel.add(lblNewLabel_2);

		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(0, 0, 349, 305);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setIcon(new ImageIcon(LoginUsuario.class.getResource("/imagem/teste.png")));

		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lblNewLabel_3.setBounds(359, 247, 287, 41);
		contentPane.add(lblNewLabel_3);
	}

	public boolean validar() throws Exception{
		// A@A.CO
		// indexOf - traz a posição de um caracter em uma string se nao achar traz -1
		
		if( textField_2.getText().length() < 6 || textField_2.getText().indexOf("@") < 1 ||
				textField_2.getText().indexOf(".") < 1 )

		{
			JOptionPane.showMessageDialog(null, "email invalido, verifique !");
			return false;
		}

		if(new String(PasswordField_1.getPassword()).length() < 6)

		{
			JOptionPane.showMessageDialog(null, "Digite uma senha com ao menos 6 caracteres!");
			return false;
		}

		else{


			if(dao1.Select(new Usuario(null,null,textField_2.getText(), new String(PasswordField_1.getPassword())))==false)
			{

				//lblNewLabel_3.setText("  Usuario cadastrado !");
				//return false;

			}


			else

			{ 

				lblNewLabel_3.setText("  Usuario não cadastrado !");
				btnNewButton.setVisible(false);
				btnFazerCadastro.setVisible(true);
				return false;

			}


		}
		
		id=textField_2.getText();
		JOptionPane.showMessageDialog(null, id);
		new AreaProfessor(id).setVisible(true);//abrir CadastroProduto
		dispose();
		return false;


	}
}


