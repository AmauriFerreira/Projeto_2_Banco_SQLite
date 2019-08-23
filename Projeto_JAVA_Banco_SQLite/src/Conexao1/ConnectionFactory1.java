package Conexao1;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.*;

import javax.swing.JOptionPane;

public class ConnectionFactory1 {
	private static final java.io.File DATABASE = new java.io.File(
			System.getProperty("user.home")
			+ System.getProperty("file.separator")
			//+ "usuario"
			//+ System.getProperty("file.separator")
			+ "usuario.db");
	
	//Cria conexoes com o banco
	public static Connection getConnection() throws Exception {
		Class.forName("org.sqlite.JDBC");
		if (!DATABASE.exists()) {
			createNewDatabase();
			
		}
		Connection conn =
				DriverManager.getConnection("jdbc:sqlite:" + DATABASE.getPath());
		return conn;
	}

	//a) - Rodo na inicializacao do programa
	//Se nao existir o arquivo de banco de dados, o programa roda o metodo para criar um arquivo de banco de dados
	public static void checkDatabase() throws Exception {
		if (!DATABASE.exists()) {
			createNewDatabase();
		}
	}

	/*  b) - Cria um novo banco de dados
	     Voce deve rodar aqui todos os comandos necessarios para fazer a configuracao inicial do banco -
	     criacao de tabelas, usuarios (se o banco comportar esse recurso), insercao de registros iniciais, etc.
	 */
	public static <CREATE> void createNewDatabase() throws Exception {
		try {
			DATABASE.getParentFile().mkdirs();    //Cria os diretorios pai do arquivo (caso nao existam)
			DATABASE.createNewFile();    //Cria o arquivo do banco
			if (!DATABASE.exists()) {    //Caso o arquivo ainda nao exista, apos os comandos acima, dispara excecao
				throw new Exception("Erro ao gravar o arquivo de banco de dados.");
			}
			Connection conn = getConnection();
			Statement s = conn.createStatement();
			//Execucao dos comandos sql para configuracao inicial do banco
			s.execute("CREATE TABLE IF NOT EXISTS usuario ("
					+ "id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, " 
					+ "nome TEXT,"
					+ "endereco TEXT,"
					+ "email TEXT, "
					+ "senha TEXT"
					+ ")");
			s.execute("CREATE TABLE IF NOT EXISTS ARQUIVOS ("
					+"id integer NOT NULL,"
					+"nome character varying,"
					+"materia TEXT,"
					+"assunto TEXT,"
					+"arquivo bytea,"
					+"email TEXT, "
					+"CONSTRAINT pk_arquivo PRIMARY KEY (id),"
					+"FOREIGN KEY (email) REFERENCES usuario(email)"
					+")");
			s.execute("CREATE SEQUENCE seq_arquivo INCREMENT 1 START 1");

		} catch (Exception ex) {
			throw new Exception("Erro na criacao do banco de dados\n" + ex.getMessage());
		}
	}

}


	
