package Projeto;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao1.UsuarioDao;
import modelo1.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class EditarDados extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private UsuarioDao dao1;
	private ResultSet rs;
	public static String id;
	private String id2;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditarDados frame = new EditarDados(id);
					frame.setVisible(true);
				} catch (Exception e) {
					throw new RuntimeException(e);
					//e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws Exception 
	 */
	public EditarDados(String id2) throws Exception {
		id=id2;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 541, 364);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 525, 57);
		contentPane.add(panel);

		JLabel lblNewLabel = new JLabel("\u00C1re do Professor");
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 30));
		lblNewLabel.setForeground(Color.ORANGE);
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		panel.add(lblNewLabel);


		////////////////////////////////
		List<String> ListaDados = new ArrayList<String>();	
		dao1 = new UsuarioDao();
		System.out.println(dao1);
		////////////////////////////////
		
		try {
			ListaDados = dao1.GetDados(new Usuario(null,null,id,null));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			throw new RuntimeException(e);
		}
		////////////////////////////

		JLabel lblEscolhaOQue = new JLabel("Endere\u00E7o:");
		lblEscolhaOQue.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEscolhaOQue.setBounds(10, 153, 65, 17);
		contentPane.add(lblEscolhaOQue);

		textField = new JTextField(ListaDados.get(1));
		textField.setBounds(78, 149, 364, 28);
		contentPane.add(textField);
		textField.setColumns(10);

		JButton btnNewButton = new JButton("Salvar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


				validar();

			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Tahoma", Font.ITALIC, 20));
		btnNewButton.setBackground(Color.RED);
		btnNewButton.setBounds(10, 282, 150, 36);
		contentPane.add(btnNewButton);


		JButton btnSair = new JButton("Voltar");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					new AreaProfessor(id).setVisible(true);
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dispose();
			}
		});
		btnSair.setForeground(Color.WHITE);
		btnSair.setFont(new Font("Tahoma", Font.ITALIC, 20));
		btnSair.setBackground(Color.RED);
		btnSair.setBounds(365, 282, 150, 36);
		contentPane.add(btnSair);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEmail.setBounds(10, 192, 56, 17);
		contentPane.add(lblEmail);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSenha.setBounds(10, 234, 56, 17);
		contentPane.add(lblSenha);


		textField_1 = new JTextField(id);
		textField_1.setColumns(10);
		textField_1.setBounds(78, 188, 364, 28);
		contentPane.add(textField_1);

		//

		textField_2 = new JTextField(ListaDados.get(2));
		textField_2.setColumns(10);
		textField_2.setBounds(78, 230, 364, 28);
		contentPane.add(textField_2);

		JButton btnExcluirConta = new JButton("Excluir Conta");
		btnExcluirConta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					dao1.remove(new Usuario(null,null,id,null));

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "Exclusão realizada com sucesso!");
				new TelaInicial().setVisible(true);
				dispose();

			}
		});
		btnExcluirConta.setForeground(Color.WHITE);
		btnExcluirConta.setFont(new Font("Tahoma", Font.ITALIC, 20));
		btnExcluirConta.setBackground(Color.RED);
		btnExcluirConta.setBounds(195, 282, 150, 36);
		contentPane.add(btnExcluirConta);

		JLabel lblEditarDados = new JLabel("Editar Dados Pessoais");
		lblEditarDados.setVerticalAlignment(SwingConstants.BOTTOM);
		lblEditarDados.setForeground(Color.DARK_GRAY);
		lblEditarDados.setFont(new Font("Tahoma", Font.ITALIC, 30));
		lblEditarDados.setBounds(102, 55, 340, 37);
		contentPane.add(lblEditarDados);
		
		textField_3 = new JTextField(ListaDados.get(0));
		textField_3.setColumns(10);
		textField_3.setBounds(78, 114, 364, 28);
		contentPane.add(textField_3);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNome.setBounds(10, 121, 65, 17);
		contentPane.add(lblNome);
	}


	public boolean validar(){
		// A@A.CO
		// indexOf - traz a posição de um caracter em uma string se nao achar traz -1
		if( textField_1.getText().length() < 6 || textField_1.getText().indexOf("@") < 1 ||
				textField_1.getText().indexOf(".") < 1 )

		{
			JOptionPane.showMessageDialog(null, "email invalido, verifique !");
			return false;
		}

		if(textField_2.getText().length() < 6)

		{
			JOptionPane.showMessageDialog(null, "Digite uma senha com ao menos 6 caracteres!");
			return false;
		}

		try {
			this.dao1.altera(new Usuario(textField_3.getText(),textField.getText(),null,textField_2.getText()),id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JOptionPane.showMessageDialog(null, "Alteração realizada com sucesso!");

		return false;

	}
}





