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


import dao1.UsuarioDao;
import modelo1.Arquivo;
import modelo1.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.ImageIcon;

public class CadastroUsuario extends JFrame {

	private JPanel contentPane;
	private JPasswordField PasswordField_1;
	private JTextField textField_2;
	private JPasswordField PasswordField;
	private UsuarioDao dao1;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroUsuario frame = new CadastroUsuario();
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
	public CadastroUsuario() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 672, 426);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.setBackground(new Color(255, 255, 255));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		PasswordField_1 = new JPasswordField();
		PasswordField_1.setColumns(10);
		PasswordField_1.setBounds(359, 223, 287, 37);
		contentPane.add(PasswordField_1);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(359, 161, 287, 37);
		contentPane.add(textField_2);

		JLabel lblNewLabel = new JLabel("Email:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(359, 136, 58, 26);
		contentPane.add(lblNewLabel);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSenha.setBounds(359, 198, 58, 26);
		contentPane.add(lblSenha);
		dao1 = new UsuarioDao();

		JButton btnFazerCadastro = new JButton("Fazer cadastro");
		btnFazerCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				validar();  
			}

		});
		btnFazerCadastro.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnFazerCadastro.setBackground(new Color(255, 0, 0));
		btnFazerCadastro.setForeground(new Color(255, 255, 255));
		btnFazerCadastro.setBounds(359, 333, 287, 44);
		contentPane.add(btnFazerCadastro);

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

		PasswordField = new JPasswordField();
		PasswordField.setColumns(10);
		PasswordField.setBounds(359, 285, 287, 37);
		contentPane.add(PasswordField);

		JLabel lblConfirmaSenha = new JLabel("Confirma senha:");
		lblConfirmaSenha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblConfirmaSenha.setBounds(359, 258, 108, 26);
		contentPane.add(lblConfirmaSenha);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(359, 100, 287, 37);
		contentPane.add(textField);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNome.setBounds(359, 6, 58, 26);
		contentPane.add(lblNome);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(359, 31, 287, 37);
		contentPane.add(textField_1);
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o:");
		lblEndereo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEndereo.setBounds(359, 74, 79, 26);
		contentPane.add(lblEndereo);
	}

	public boolean validar()  {
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


		if ((new String(PasswordField_1.getPassword()).equals(new String(PasswordField.getPassword())))==false)
		{
			JOptionPane.showMessageDialog(null,"Senha e confirmação não conferem");
			return false;
		}



		try {
			if(dao1.Conferi(new Usuario(null,null,textField_2.getText(), new String(PasswordField_1.getPassword())))==false)

			{
				JOptionPane.showMessageDialog(null,"Email ou senha já esta sendo usada por outro usuario");
				textField_2.setText("");
				PasswordField_1.setText("");
				PasswordField.setText("");
				return false;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		dao1.adiciona(new Usuario(textField_1.getText(),textField.getText(),textField_2.getText(), new String(PasswordField_1.getPassword())));
		JOptionPane.showMessageDialog(null, "Inserido com sucesso!");

		String saida = "Meus contatos:\n\n";
		ArrayList<Usuario> c = (ArrayList<Usuario>) dao1.getListar();
		for(Usuario x:c) saida = saida + x + "\n";
		JOptionPane.showMessageDialog(null, saida);
		String id = textField_2.getText();
		JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
		new AreaProfessor(id).setVisible(true);//abrir CadastroProduto
		dispose();
		//Após a validação vai para a Lista
		return false;


	}
}
