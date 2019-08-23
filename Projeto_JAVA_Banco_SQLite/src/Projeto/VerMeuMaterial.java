package Projeto;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao1.UsuarioDao;
import modelo1.Arquivo;
import modelo1.Usuario;

import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

public class VerMeuMaterial extends JFrame {


	private JPanel contentPane;
	public static String id;
	private  String cod;
	private  String EmailId;
	private JTable table;
	private UsuarioDao dao1;
	private JTextField textField;
	private ResultSet rs;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VerMeuMaterial frame = new VerMeuMaterial(id);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param id2 
	 */
	public VerMeuMaterial(String id) {
		EmailId=id;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 541, 364);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);


		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 525, 57);
		panel.setBackground(Color.DARK_GRAY);
		contentPane.add(panel);

		JLabel lblNewLabel = new JLabel("Visualizar Minhas Postagens");
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 30));
		lblNewLabel.setForeground(Color.ORANGE);
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);

		JLabel lblEscolhaOQue = new JLabel("Escolha o que voc\u00EA precisa:");
		lblEscolhaOQue.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblEscolhaOQue.setBounds(10, 68, 302, 25);
		contentPane.add(lblEscolhaOQue);

		JButton btnNewButton = new JButton("Visualizar");
		btnNewButton.setBounds(10, 282, 92, 36);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					if(table.getSelectedRow()!=-1){
						Arquivo x= new Arquivo();
						x.setId((int)table.getValueAt(table.getSelectedRow(),2));
						Desktop.getDesktop().open(dao1.getFile(x.getId()));}
						else
						JOptionPane.showMessageDialog(null, "Selecione um arquivo clicando sobre a linha desejada!");

				} catch (IOException e) {
					// TODO Auto-generated catch block
					
					e.printStackTrace();
				}
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Tahoma", Font.ITALIC, 15));
		btnNewButton.setBackground(Color.RED);
		contentPane.add(btnNewButton);

		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnSair.setBounds(434, 282, 81, 36);
		btnSair.setForeground(Color.WHITE);
		btnSair.setFont(new Font("Tahoma", Font.ITALIC, 15));
		btnSair.setBackground(Color.RED);
		contentPane.add(btnSair);

		JButton btnSalvar = new JButton("Upload");
		btnSalvar.setBounds(224, 282, 95, 36);
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSalvar.setForeground(Color.WHITE);
		btnSalvar.setFont(new Font("Tahoma", Font.ITALIC, 15));
		btnSalvar.setBackground(Color.RED);
		contentPane.add(btnSalvar);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(329, 282, 95, 36);
		btnVoltar.addActionListener(new ActionListener() {
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
		btnVoltar.setForeground(Color.WHITE);
		btnVoltar.setFont(new Font("Tahoma", Font.ITALIC, 15));
		btnVoltar.setBackground(Color.RED);
		contentPane.add(btnVoltar);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 163, 505, 82);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		table.setBackground(Color.WHITE);
		table.setToolTipText("");
		table.setModel(new DefaultTableModel(
				new Object[][] {
					{null, null, null},
					{null, null, null},
					{null, null, null},
					{null, null, null},
				},
				new String[] {
						"Materia", "Assunto", "id"
				}
				) {
			boolean[] columnEditables = new boolean[] {
					false, true, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}


		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setMinWidth(0);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(2).setPreferredWidth(30);

		JButton btnEscluir = new JButton("Escluir");
		btnEscluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				int opcao_escolhida=JOptionPane.showConfirmDialog
						(null,"Exclusão","Confirma Exclusão",JOptionPane.YES_NO_OPTION);

				if (opcao_escolhida==JOptionPane.YES_NO_OPTION){

					try {
						escluirJTable() ;
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});

		btnEscluir.setForeground(Color.WHITE);
		btnEscluir.setFont(new Font("Tahoma", Font.ITALIC, 15));
		btnEscluir.setBackground(Color.RED);
		btnEscluir.setBounds(112, 282, 102, 36);
		contentPane.add(btnEscluir);

		JLabel lblMaterial = new JLabel("Materia:");
		lblMaterial.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMaterial.setBounds(36, 104, 66, 25);
		contentPane.add(lblMaterial);

		JLabel lblAssunto = new JLabel("Assunto:");
		lblAssunto.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAssunto.setBounds(264, 104, 66, 25);
		contentPane.add(lblAssunto);

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Matem\u00E1tica", "F\u00EDsica", "Hist\u00F3ria", "Portugu\u00EAs", "Geografia", "Biologia"}));
		comboBox.setToolTipText("");
		comboBox.setBounds(36, 128, 140, 24);
		contentPane.add(comboBox);

		textField = new JTextField();
		textField.setBounds(264, 128, 206, 24);
		contentPane.add(textField);
		textField.setColumns(10);

		JButton btnDoawload = new JButton("Download");
		btnDoawload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					new Dowloard().setVisible(true);
					//BufferedWriter grava = new BufferedWriter(new FileWriter());
                    //grava.write(texto.getText());
                    //grava.close();
                    //if(table.getSelectedRow()!=-1){
						//Arquivo x= new Arquivo();
						//x.setId((int)table.getValueAt(table.getSelectedRow(),2));
						//Desktop.getDesktop().open(dao1.getFile(x.getId()));}
						//else
						//JOptionPane.showMessageDialog(null, "Selecione um arquivo clicando sobre a linha desejada!");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		btnDoawload.setForeground(Color.WHITE);
		btnDoawload.setFont(new Font("Tahoma", Font.ITALIC, 15));
		btnDoawload.setBackground(Color.RED);
		btnDoawload.setBounds(405, 79, 110, 25);
		contentPane.add(btnDoawload);
		readJTable();

	}


	public void readJTable(){

		//dao1.getListarArquivo();

		DefaultTableModel val=(DefaultTableModel) table.getModel();
		val.setNumRows(0);
		dao1 = new UsuarioDao();
		for(Arquivo x:dao1.getListarMeuArquivo(EmailId)) {
			val.addRow(new Object[] {
					x.getMateria(),
					x.getAssunto(),
					x.getId()
			});

		}
	
		
	}

	public void escluirJTable() throws Exception{
		if(table.getSelectedRow()!=-1){
			Arquivo x= new Arquivo();
			x.setId((int)table.getValueAt(table.getSelectedRow(),2));
			dao1 = new UsuarioDao();
			dao1.RemoveArquivo(x,EmailId);
			readJTable();

		}


	}
}
