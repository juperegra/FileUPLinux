package persistencia;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import model.Fichero;
import model.Usuario;

public class GestorBD{
	private static final String URL = getPropiedad("url");
	private static final String USR = getPropiedad("user");
	private static final String PWD = getPropiedad("password");
			
	public static String getPropiedad(String clave) {
		String valor = null;
		try {
		    Properties props = new Properties();
		    InputStream prIS = GestorBD.class.getResourceAsStream("/conexion.properties");
		    props.load(prIS);
		    valor = props.getProperty(clave);
		}catch (IOException ex) { 
			ex.printStackTrace();
		}
		
		return valor;
	}
	
	public Usuario buscarUsuario(String arg0) throws Exception {
		Usuario deleted=null;
	    Connection con = null;
	    try {
	      con = DriverManager.getConnection(URL,USR,PWD);
	      con.setAutoCommit(false);
	      String sql = "SELECT * FROM Usuario WHERE ID= '" + arg0 + "'";
	      PreparedStatement stm = con.prepareStatement(sql);

	      ResultSet res = stm.executeQuery(sql);
	      
	      if(res.next()) {
	    	  
	    	  deleted= new Usuario(res.getString(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5));
	    	  
	      }

	      stm.close();
	      con.commit();	
	    } catch (SQLException e) {
	      e.printStackTrace();
	      try {
			if (con != null) con.rollback();
	      } catch (SQLException e2) {
			e2.printStackTrace();
			
			throw new Exception(e);
	      }
	      throw new Exception(e);
	    } finally {
	      if (con != null) {
	        try {
	        con.close();
	        } catch (SQLException ex) {
	          ex.printStackTrace();
	        throw new Exception(ex);
	        }
	      }
	    }
	    return deleted;
	}
	
	public Fichero BuscaFichero(String arg0) {
		
		return null;
		
	}
	
	public boolean agnadirFichero(Fichero f) {
		
		return false;
		
	}
	
	public boolean agnadirPersona(Usuario u) {
		
		return false;
		
	}
	
	public boolean eliminarFichero(Fichero f) {
		
		return false;
		
	}
	
	public boolean eliminarPersona(Usuario u) {
		
		return false;
		
	}
	
	public List<Fichero> todosFicheros(){
		
		return null;
		
	}
	
	public List<Usuario> todosUsuarios(){// esto ns si deberia estar, pero bueno, yo lo pongo
		
		return null;
		
	}
	
}
