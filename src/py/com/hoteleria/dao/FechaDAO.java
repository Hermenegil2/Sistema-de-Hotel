package py.com.hoteleria.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import py.com.hoteleria.model.Estadia;
import py.com.hoteleria.model.Fecha;
import py.com.hoteleria.util.Conexion;

public class FechaDAO {
	public static Fecha fechaId(int codigo){
	  	   String sql="select (est_fecsal-est_fecha)*hab_mondia as dato from estadia INNER JOIN habita ON estadia.est_codhab=habita.hab_codigo WHERE est_numero="+codigo+"";
	  	   System.out.println(sql);
	  	   Conexion.abrirConexion();
	  	   Fecha fecha=null;
	  	  try {
				ResultSet rs=Conexion.sentencia.executeQuery(sql);
				
				if(rs.next()){
					fecha=new Fecha();
					fecha.setDatos(rs.getInt("dato"));					
					
				}
				
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
	  	  Conexion.cerrarConexion();
	  	  return fecha;
	  	  
	  	  
	     }
	public void guardar(Estadia estadia){
		String sql="UPDATE estadia  SET est_fecsal='"+estadia.getFechaSalida()+"' WHERE est_codigo="+estadia.getCodigo()+"";
		System.out.println(sql);
		Conexion.abrirConexion();
		try {
			Conexion.sentencia.executeUpdate(sql);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "La Sentencia no Fue Ejecutada."+e.getMessage());
			e.printStackTrace();
		}
		Conexion.cerrarConexion();
}
	

}
