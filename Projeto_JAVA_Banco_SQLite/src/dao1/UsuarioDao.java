package dao1;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import Conexao1.ConnectionFactory1;
import Projeto.AreaProfessor;
import modelo1.Arquivo;
import modelo1.Usuario;
import Projeto.EditarDados;
//import conexao.ConnectionFactory;

public class UsuarioDao {
	private static final String Elseif = null;

	///////////////// a conexao com o banco de dados////////////////////////////////////

	private PreparedStatement stmt;
	private String id;

	public UsuarioDao() {
		//		try{
		//			this.connection = ConnectionFactory1.getConnection();
		//		}
		//		catch(Exception e)
		//		{
		//			System.out.println("Erro na abertura do banco de dados: " + e.getMessage());
		//		}
	}

	public List<Usuario> getListar(){
		try(Connection connection = ConnectionFactory1.getConnection()){
			PreparedStatement stmt = connection.prepareStatement("select * from usuario");
			ResultSet rs = stmt.executeQuery();

			List<Usuario> usuarios = new ArrayList<Usuario>();

			while (rs.next()) {
				// criando o objeto Contato
				Usuario usuario = new Usuario();
				usuario.setEmail(rs.getString("email"));
				usuario.setSenha(rs.getString("senha"));	

				// adicionando o objeto a lista
				usuarios.add(usuario);
			}

			rs.close();
			stmt.close();
			return usuarios;
		} catch (Exception e) {
			throw new RuntimeException(e);

		}
	}

	///////Adcionar usuario novo usuario///////////////////////////

	public void adiciona(Usuario usuario) {
		String sql = "insert into usuario (nome,endereco,email,senha) values (?,?,?,?)";
		try (Connection connection = ConnectionFactory1.getConnection()){

			// prepared statement para insercao
			stmt = connection.prepareStatement(sql);
			stmt.setString(1,usuario.getNome());
			stmt.setString(2,usuario.getEndereco());
			stmt.setString(3,usuario.getEmail());
			stmt.setString(4,usuario.getSenha());

			// executa
			stmt.execute();
			stmt.close();

		} 	catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	///////////////Ver no banco se o usuario tem registro////////////

	public boolean Select(Usuario usuario) throws Exception {

		String sql = "Select email, senha FROM Usuario Where email= ? and senha= ? ";

		try (Connection connection = ConnectionFactory1.getConnection()){

			// prepared statement para insercao
			stmt = connection.prepareStatement(sql);

			stmt.setString(1,usuario.getEmail());
			stmt.setString(2,usuario.getSenha());

			ResultSet rs  = stmt.executeQuery();


			///////Fazer busca no banco por email e senha e ver se já existe///////////

			if ((usuario.getEmail().equals(rs.getString("email"))) && (usuario.getSenha().equals(rs.getString("senha"))))
			{
				return false;
			}

		} 	catch (Exception e) {

		}

		return true;
	}

	/////Conferir no cadastro se o usuario não esta utilizando senha e email ja existente  /////////

	public boolean Conferi(Usuario usuario) throws Exception {

		String sql = "Select email, senha FROM Usuario Where email= ? or senha= ? ;";

		try (Connection connection = ConnectionFactory1.getConnection()){

			// prepared statement para insercao
			stmt = connection.prepareStatement(sql);

			stmt.setString(1,usuario.getEmail());
			stmt.setString(2,usuario.getSenha());

			ResultSet rs  = stmt.executeQuery();

			////Email e senha ja sendo utilizado/////////////
			if ((usuario.getEmail().equals(rs.getString("email"))) && (usuario.getSenha().equals(rs.getString("senha"))))
			{	
				return false;
			}
			/////Email ou senha já sendo utilizado/////////////
			if((usuario.getEmail().equals(rs.getString("email"))) || (usuario.getSenha().equals(rs.getString("senha"))))
			{  
				return false;  
			}

		} 	catch (Exception e) {

		}

		return true;
	}

	////////////Busca dados do usuario no BD para o EditarUsuario/////////////////////

	public List<String> GetDados(Usuario usuario) throws Exception {
		String sql = "Select nome, endereco,senha FROM Usuario Where email= ? ";

		try (Connection connection = ConnectionFactory1.getConnection()){

			List<String> ListaDados = new ArrayList<String>();	

			// prepared statement para insercao
			stmt = connection.prepareStatement(sql);
			stmt.setString(1,usuario.getEmail());
			ResultSet rs  = stmt.executeQuery();

			// adicionando o objeto a lista
			ListaDados.add(rs.getString("nome"));
			ListaDados.add(rs.getString("endereco"));
			ListaDados.add(rs.getString("senha"));

			rs.close();  
			stmt.close();  

			//Nome; Endereço, senha;
			return  ListaDados;

		} 	catch (Exception e) {
			throw new RuntimeException(e);
		}

	}


	///////////Fazer atualização de dados do usuario///////////////////

	public void altera(Usuario usuario,String id) throws Exception {
		String sql = "update usuario set nome=?, endereco=?, senha=? where email=?";

		try (Connection connection = ConnectionFactory1.getConnection()){

			stmt = connection.prepareStatement(sql);

			stmt.setString(1, usuario.getNome());
			stmt.setString(2, usuario.getEndereco());
			stmt.setString(3, usuario.getSenha());
			stmt.setString(4,id);

			stmt.executeUpdate();
			stmt.close();


		} catch (Exception e) {
			throw new RuntimeException(e); 
		}
	}
	////////////Excluir dados////////////////////////////////////

	public void remove(Usuario usuario)throws Exception   {
		String sql = "delete from usuario where email=?";
		try (Connection connection = ConnectionFactory1.getConnection()){

			stmt =connection.prepareStatement(sql);

			stmt.setString(1,usuario.getEmail());

			stmt.execute();
			stmt.close();

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	
	/////////////////////////////////////////////////////////////////
    /////////////////////CRUD DO ARQUIVO///////////////////////////
	///////////////////////////////////////////////////////////////
	
	////////////Incluir Arquivos//////////////////////////////////

	public void IncluirAquivo(File f,String materia,String assunto,String email) throws Exception {

		String sql="INSERT INTO ARQUIVOS( nome,arquivo,materia,assunto,email) VALUES ( ?,?,?,?,? )";
		try (Connection connection = ConnectionFactory1.getConnection()){

			//converte o objeto file em array de bytes
			InputStream is = new FileInputStream( f );
			byte[] bytes = new byte[(int)f.length() ];
			int offset = 0;
			int numRead = 0;
			while (offset < bytes.length
					&& (numRead=is.read(bytes, offset, bytes.length-offset)) >= 0) {
				offset += numRead;
			}
		
			stmt = connection.prepareStatement(sql);
			JOptionPane.showInputDialog(null,id);
			stmt.setString(1, f.getName() );
			stmt.setBytes(2, bytes );
			stmt.setString(3, materia);
			stmt.setString(4, assunto);
			stmt.setString(5,email);
			
			stmt.execute();
			stmt.close();
			//return true;

		} catch (Exception e) {
			throw new RuntimeException(e); 
		}
	}

	
	////////////Pegar arquivo////////////////////////////////////
	public File getFile( int id ){
		File f = null;
		String sql=("SELECT id, nome, arquivo FROM ARQUIVOS WHERE id = ?");
		try (Connection connection = ConnectionFactory1.getConnection()){
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			if ( rs.next() ){
				byte [] bytes = rs.getBytes("arquivo");
				String nome = rs.getString("nome");

				//converte o array de bytes em file
				
				f = new File( "C:\\Users\\Amauri\\Desktop\\DB Browser for SQLite\\"+nome);
				FileOutputStream fos = new FileOutputStream( f);
				fos.write( bytes );
				fos.close();
			}

			stmt.close();
			stmt.close();
			stmt.close();

			return f;
		} catch (Exception e) {
			throw new RuntimeException(e); 
		}
	}

	////////////Busca dados do arquivo no BD para preencher tabela/////////////////////

	public List<Arquivo> getListarArquivo(){
		try(Connection connection = ConnectionFactory1.getConnection()){
			PreparedStatement stmt = connection.prepareStatement("select materia,assunto,id from ARQUIVOS");
			ResultSet rs = stmt.executeQuery();

			List<Arquivo> arquivos = new ArrayList<Arquivo>();

			while (rs.next()) {
				// criando o objeto Contato
				Arquivo arquivo = new Arquivo();
				arquivo.setMateria(rs.getString("materia"));
				arquivo.setAssunto(rs.getString("assunto"));
				arquivo.setId(rs.getInt("id"));

				// adicionando o objeto a lista
				arquivos.add(arquivo);
			}
			
			rs.close();
			stmt.close();
			return arquivos;
		} catch (Exception e) {
			throw new RuntimeException(e);

		}
	}
	
	////////////Busca dados dos meus arquivos no BD para preencher tabela/////////////////////

	public List<Arquivo> getListarMeuArquivo(String EmailId){
		
		try(Connection connection = ConnectionFactory1.getConnection()){
			PreparedStatement stmt = connection.prepareStatement("select materia,assunto,id from ARQUIVOS where email=?");
			stmt.setString(1, EmailId);
			
			ResultSet rs = stmt.executeQuery();
		
			List<Arquivo> arquivos = new ArrayList<Arquivo>();
			JOptionPane.showMessageDialog(null, EmailId);
			
			
			while (rs.next()) {
				// criando o objeto Contato
				Arquivo arquivo = new Arquivo();
				arquivo.setMateria(rs.getString("materia"));
				arquivo.setAssunto(rs.getString("assunto"));
				arquivo.setId(rs.getInt("id"));

				// adicionando o objeto a lista
				arquivos.add(arquivo);
			}
			
			rs.close();
			stmt.close();
			return arquivos;
		} catch (Exception e) {
			throw new RuntimeException(e);

		}
	}
	
       ////////////Editar dados do arquivo no BD ////////////////////
	
	public void getUpdateDadosFile( int id ) throws Exception {
		String sql = "update ARQUIVOS set materia=?, assunto=? where id=?";

		try (Connection connection = ConnectionFactory1.getConnection()){

			stmt = connection.prepareStatement(sql);
			Arquivo arquivo = new Arquivo();
			stmt.setInt(1,id);
			stmt.setString(2, arquivo.getMateria());
			stmt.setString(3, arquivo.getAssunto());
			

			stmt.executeUpdate();
			stmt.close();


		} catch (Exception e) {
			throw new RuntimeException(e); 
		}
	}
	////////////Excluir Arquivo////////////////////////////////////

	public void RemoveArquivo( Arquivo x,String EmailId)throws Exception   {
		String sql = "delete from ARQUIVOS where id=? and email=?";
		try (Connection connection = ConnectionFactory1.getConnection()){

			stmt =connection.prepareStatement(sql);
			
			
			stmt.setInt(1,x.getId());
			stmt.setString(2, EmailId);

			stmt.execute();
			stmt.close();

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}


}
