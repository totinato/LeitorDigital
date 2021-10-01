package Controller;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DAO {
	
	Connection con;  // Conexao ao Banco de Dados
	PreparedStatement stmt; // Acessa a Tabela ( insert, update, delete , select)
	ResultSet rs; // Consulta a Tabela( select )
	CallableStatement call; // Procedures e Function
	
	public void open() throws Exception{
		
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("caminho", "usuario", "senha");		
	}
	
	public void close() throws Exception{		
		con.close();
		
	}
}
