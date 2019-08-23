//import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.ContatoDao;
import modelo.Contato;
import modelo.Contato2;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

public class TelaAgenda extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JButton btnInserir, btnMostrarTodos;
	private ContatoDao dao;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAgenda frame = new TelaAgenda();
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
	public TelaAgenda() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(25, 30, 46, 14);
		contentPane.add(lblNome);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(25, 67, 46, 14);
		contentPane.add(lblEmail);
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o:");
		lblEndereo.setBounds(25, 108, 66, 14);
		contentPane.add(lblEndereo);
		
		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento:");
		lblDataDeNascimento.setBounds(25, 154, 115, 14);
		contentPane.add(lblDataDeNascimento);
		
		textField = new JTextField();
		textField.setBounds(141, 27, 240, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(141, 64, 240, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(141, 105, 240, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(141, 151, 240, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		btnInserir = new JButton("Inserir");
		btnInserir.setBounds(40, 212, 89, 23);
		contentPane.add(btnInserir);
		btnInserir.addActionListener(this);
		
		btnMostrarTodos = new JButton("Mostrar todos");
		btnMostrarTodos.setBounds(172, 212, 122, 23);
		contentPane.add(btnMostrarTodos);
		btnMostrarTodos.addActionListener(this);
		
		dao = new ContatoDao();
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == btnInserir)
		{
			dao.adiciona(new Contato(textField.getText(),
					textField_1.getText(), textField_2.getText(),
					textField_3.getText()));
			JOptionPane.showMessageDialog(null, "Inserido com sucesso!");
		}
		else if(e.getSource() == btnMostrarTodos)
		{	String saida = "Meus contatos:\n\n";
			ArrayList<Contato> c = (ArrayList<Contato>) dao.getListar();
			for(Contato x:c) saida = saida + x + "\n";
			JOptionPane.showMessageDialog(null, saida);
		}
	}
}
