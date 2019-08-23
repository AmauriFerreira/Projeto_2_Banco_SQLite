package Projeto;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import javax.swing.JSpinner;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.UIManager;

public class TelaInicial extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicial frame = new TelaInicial();
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
	public TelaInicial() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 672, 426);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.setBackground(new Color(255, 215, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(245, 245, 220));
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 49, 656, 339);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(TelaInicial.class.getResource("/imagem/saiba-quais-sao-as-principais-metodologias-de-ensino-atuais-no-brasil.jpg")));
		lblNewLabel_1.setBounds(10, 0, 633, 197);
		panel.add(lblNewLabel_1);
		
		JTextPane txtpnCompartilheSuaExperincia = new JTextPane();
		txtpnCompartilheSuaExperincia.setFont(new Font("Tahoma", Font.ITALIC, 12));
		txtpnCompartilheSuaExperincia.setForeground(new Color(0, 0, 0));
		txtpnCompartilheSuaExperincia.setBackground(Color.WHITE);
		txtpnCompartilheSuaExperincia.setText("Compartilhe sua experi\u00EAncia  de sala de aula ou use uma experi\u00EAncia de um colega.\r\n\r\nAqui voc\u00EA pode postar ou pegar materias das seguintes diciplinas:\r\n\r\n.Matem\u00E1tica                                    .F\u00EDsica\r\n\r\n.Portugu\u00EAs                                      .Hist\u00F3ria\r\n\r\n.Geografia                                        .Biologia\r\n");
		txtpnCompartilheSuaExperincia.setBounds(10, 200, 383, 156);
		panel.add(txtpnCompartilheSuaExperincia);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(TelaInicial.class.getResource("/imagem/42112210-vector-books-pencil-box-calendar-on-shelf.jpg")));
		lblNewLabel_2.setBounds(393, 188, 253, 151);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("Sistema de Ensino");
		lblNewLabel.setBackground(new Color(0, 0, 0));
		lblNewLabel.setBounds(138, 3, 335, 52);
		contentPane.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 40));
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setFont(new Font("Tahoma", Font.ITALIC, 35));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				new LoginUsuario().setVisible(true);//abrir CadastroProduto
				 dispose();
			}
		});
		btnNewButton.setBounds(535, 3, 121, 41);
		contentPane.add(btnNewButton);
		btnNewButton.setBackground(new Color(255, 215, 0));
		btnNewButton.setForeground(new Color(255, 255, 255));
	}
	
	
	}

