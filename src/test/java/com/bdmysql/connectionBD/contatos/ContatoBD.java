package com.bdmysql.connectionBD.contatos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContatoBD {

  // a conexão com o banco de dados
  private Connection connection;
  final String DRIVER = "com.mysql.jdbc.Driver";

  public ContatoBD() {
    this.connection = getConnection();
  }
  
  public Connection getConnection() {
      try {
    	  
    	  Class.forName(DRIVER);
          return DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/contatos", "root", "");
      } catch (SQLException | ClassNotFoundException e) {
          throw new RuntimeException(e);
      }
  }
  
  public void adiciona(Contato contato) {
	    String sql = "insert into contatos " +
	            "(nome,email,endereco,telefone)" +
	            " values (?,?,?,?)";

	    try {
	        // prepared statement para inserção
	        PreparedStatement stmt = connection.prepareStatement(sql);

	        // seta os valores

	        stmt.setString(1,contato.getNome());
	        stmt.setString(2,contato.getEmail());
	        stmt.setString(3,contato.getEndereco());
	        stmt.setString(4, contato.getTelefone());

	        // executa
	        stmt.execute();
	        stmt.close();
	    } catch (SQLException e) {
	        throw new RuntimeException(e);
	    }
	}
  
  public List<Contato> getLista() {
	     try {
	         List<Contato> contatos = new ArrayList<Contato>();
	         PreparedStatement stmt = this.connection.
	                 prepareStatement("select * from contatos");
	         ResultSet rs = stmt.executeQuery();
	 
	         while (rs.next()) {
	             // criando o objeto contatos.Contato
	             Contato contato = new Contato();
	             contato.setId(rs.getLong("idcontatos"));
	             contato.setNome(rs.getString("nome"));
	             contato.setEmail(rs.getString("email"));
	             contato.setEndereco(rs.getString("endereco"));
	             contato.setTelefone(rs.getString("telefone"));
	          
	             // adicionando o objeto à lista
	             contatos.add(contato);
	         }
	         rs.close();
	         stmt.close();
	         return contatos;
	     } catch (SQLException e) {
	         throw new RuntimeException(e);
	     }
	 }
  
  public void altera(Contato contato) {
	     String sql = "update contatos set nome=?, email=?,"+
	             "endereco=?, dataNascimento=? where idcontatos=?";
	 
	     try {
	         PreparedStatement stmt = connection
	                 .prepareStatement(sql);
	         stmt.setString(1, contato.getNome());
	         stmt.setString(2, contato.getEmail());
	         stmt.setString(3, contato.getEndereco());
	         stmt.setString(4, contato.getTelefone());
	         stmt.setLong(5, contato.getId());
	         stmt.execute();
	         stmt.close();
	     } catch (SQLException e) {
	         throw new RuntimeException(e);
	     }
	 }
  
 	  public void remove(long id) {
		     try {
		         PreparedStatement stmt = connection
		                 .prepareStatement("delete from contatos where id=?");
		         stmt.setLong(1, id);
		         stmt.execute();
		         stmt.close();
		     } catch (SQLException e) {
		         throw new RuntimeException(e);
		     }
		 }
  
  
  
  
}
