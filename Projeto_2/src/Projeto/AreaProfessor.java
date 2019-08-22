package Projeto;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao1.UsuarioDao;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class AreaProfessor extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	public static String id;
	private String id1;
	private String materia;
	private String assunto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JOptionPane.showMessageDialog(null,id);
					AreaProfessor frame = new AreaProfessor(id);
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
	public AreaProfessor(String id1) {
		id=id1;
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


		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Postar Material", "Encontrar Material", "Material que Postei"}));
		comboBox.setToolTipText("");
		comboBox.setBounds(210, 76, 140, 31);
		contentPane.add(comboBox);

		JLabel lblEscolhaOQue = new JLabel("Escolha o que voc\u00EA precisa:");
		lblEscolhaOQue.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEscolhaOQue.setBounds(7, 82, 193, 14);
		contentPane.add(lblEscolhaOQue);

		JLabel lblEscolhaAMatria = new JLabel("Escolha a mat\u00E9ria:");
		lblEscolhaAMatria.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEscolhaAMatria.setBounds(7, 141, 193, 14);
		contentPane.add(lblEscolhaAMatria);

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.addItem(null);
		comboBox_1.addItem("Matemática");
		comboBox_1.addItem("Física");
		comboBox_1.addItem("Química");
		comboBox_1.addItem("Hitória");
		comboBox_1.addItem("Geografia");
		comboBox_1.addItem("Biologia");
		comboBox_1.addItem("Português");
		comboBox_1.setBounds(210, 135, 140, 31);
		contentPane.add(comboBox_1);
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				materia=(String)comboBox_1.getSelectedItem();

			}
		});




		JLabel lblInformeOTema = new JLabel("Informe o Tema:");
		lblInformeOTema.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblInformeOTema.setBounds(0, 249, 122, 14);
		contentPane.add(lblInformeOTema);

		textField = new JTextField();
		textField.setBounds(123, 245, 392, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		JButton btnNewButton = new JButton("Próximo");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					assunto=textField.getText();
					validar();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Tahoma", Font.ITALIC, 20));
		btnNewButton.setBackground(Color.RED);
		btnNewButton.setBounds(10, 282, 150, 36);
		contentPane.add(btnNewButton);

		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSair.setForeground(Color.WHITE);
		btnSair.setFont(new Font("Tahoma", Font.ITALIC, 20));
		btnSair.setBackground(Color.RED);
		btnSair.setBounds(365, 282, 150, 36);
		contentPane.add(btnSair);

		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(AreaProfessor.class.getResource("/imagem/transferir.png")));
		lblNewLabel_1.setBounds(273, 59, 242, 183);
		contentPane.add(lblNewLabel_1);

		JButton btnDadosPessoais = new JButton("Conta");
		btnDadosPessoais.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null,AreaProfessor.id);

				try {
					new EditarDados(id).setVisible(true);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				dispose();
			}
		});
		btnDadosPessoais.setForeground(Color.WHITE);
		btnDadosPessoais.setFont(new Font("Tahoma", Font.ITALIC, 20));
		btnDadosPessoais.setBackground(Color.RED);
		btnDadosPessoais.setBounds(190, 282, 150, 36);
		contentPane.add(btnDadosPessoais);


	}


	public boolean validar() throws Exception {
		UsuarioDao dao1 = new UsuarioDao();
		if(comboBox.getSelectedItem().equals("Postar Material")){

			if(materia==(null))
			{
				JOptionPane.showMessageDialog(null, "Informe a Matéria!");

				return false;
			}
			if(textField.getText().trim().equals(""))
			{
				JOptionPane.showMessageDialog(null, "Informe o Tema!");
				return false;
			}
			new Upload(materia,assunto,id).setVisible(true);//abrir verMaterial
			comboBox_1=(null);
			textField.setText("");

		}




		if(comboBox.getSelectedItem().equals("Encontrar Material")){
			new VerMaterial(id).setVisible(true);//abrir verMaterial
			dispose();
			return false;
		}
		if(comboBox.getSelectedItem().equals("Material que Postei")){
			new VerMeuMaterial(id).setVisible(true);//abrir verMeuMaterial
			dispose();
			return false;
		}
		
		return false;

	}
}








