package br.com.gestaofarmacia.core.dao.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConexaoMySQL {	
	
	private static final String urlDb = "jdbc:mysql://localhost:3306/gestao_farmacia_db";
	private static final String userDb = "root";
	private static final String passDb = "root";
	
	private static Connection conn;
	
	public static Connection getConexao() {
		
		try {
		if(conn==null) {
				conn = DriverManager.getConnection(urlDb, userDb, passDb);
				return conn;
		}else {
			return conn;
			}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
	}
	
}
}
	
	
	//TESTES
//	public static void main (String [] args){
//
//		try {
//			Connection con = DriverManager.getConnection(urlDb, userDb, passDb);
//			Statement stmt = con.createStatement();
//			ResultSet rs = stmt.executeQuery("SELECT NM_USUARIO FROM USUARIO");
//			while(rs.next()) {
//				System.out.println(rs.getString("NM_USUARIO"));
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		
//		}
//		}
	