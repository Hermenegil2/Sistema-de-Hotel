package py.com.hoteleria.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import py.com.hoteleria.model.Config;
import py.com.hoteleria.util.Conexion;

public class ConfigDAO {
	
	public static Config retornar(Config config){
	  	   String sql="SELECT * FROM config;";
	  	   Conexion.abrirConexion();
	  	   Config config1=null;
	  	  try {
				ResultSet rs=Conexion.sentencia.executeQuery(sql);
				
				if(rs.next()){
					config1=new Config();
					config1.setNombre(rs.getString("cfg_orga"));
					config1.setTelefono(rs.getString("cfg_telefo"));
					
					
					
				}
				
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
	  	  Conexion.cerrarConexion();
	  	  return config1;
	  	  
	  	  
	     }
}
