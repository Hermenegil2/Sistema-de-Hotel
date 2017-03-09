package py.com.hoteleria.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import py.com.hoteleria.model.Estadia;
import py.com.hoteleria.util.Conexion;

public class EstadiaDAO {
	
		public void guardar(Estadia estadia){
			String sql="INSERT INTO estadia(est_fecha, est_codcli, est_codhab, est_fecsal, est_monto,est_desc, est_obse, est_estado) VALUES ('"+estadia.getFechaEntrada()+"',"+estadia.getCliente().getCodigo()+","+estadia.getHabitacion().getCodigo()+",'"+estadia.getFechaSalida()+"',"+estadia.getMonto()+","+estadia.getDescuento()+",'"+estadia.getObservacion()+"',"+estadia.isEstado()+");";
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
		
		public static ArrayList<Estadia> listarEstadias(){
			 ArrayList<Estadia> lista=new ArrayList<>();
			 Estadia estadia=null;
		  	   String sql="SELECT * FROM estadia INNER JOIN cliente ON estadia.est_codcli=cliente.cli_codigo INNER JOIN habita ON estadia.est_codhab=habita.hab_codigo 	WHERE est_estado=true ORDER BY est_numero DESC";
		  	   
		  	  Conexion.abrirConexion();
		  	  try {
					ResultSet rs=Conexion.sentencia.executeQuery(sql);
					while(rs.next()){
						estadia=new Estadia();
						estadia.setCodigo(rs.getInt("est_numero"));
						estadia.setFechaEntrada(rs.getDate("est_fecha"));
						estadia.getCliente().setNombre(rs.getString("cli_nombre"));
						estadia.getHabitacion().setCodigo(rs.getInt("hab_codigo"));
						estadia.getHabitacion().setMontoDia(rs.getDouble("hab_mondia"));
						lista.add(estadia);
					}
					
				} catch (SQLException e) {
				
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, "Error al traer la lista de Cliente"+e.getMessage());
				}
		  	  Conexion.cerrarConexion();
		  	  return lista;
		  	  
		  	  
		     }
		public static ArrayList<Estadia> listarEstadiasInactivo(){
			 ArrayList<Estadia> lista=new ArrayList<>();
			 Estadia estadia=null;
		  	   String sql="SELECT * FROM estadia INNER JOIN cliente ON estadia.est_codcli=cliente.cli_codigo INNER JOIN habita ON estadia.est_codhab=habita.hab_codigo 	WHERE est_estado=false ORDER BY est_numero DESC";
		  	   
		  	  Conexion.abrirConexion();
		  	  try {
					ResultSet rs=Conexion.sentencia.executeQuery(sql);
					while(rs.next()){
						estadia=new Estadia();
						estadia.setCodigo(rs.getInt("est_numero"));
						estadia.setFechaEntrada(rs.getDate("est_fecha"));
						estadia.getCliente().setNombre(rs.getString("cli_nombre"));
						estadia.getHabitacion().setCodigo(rs.getInt("hab_codigo"));
						estadia.getHabitacion().setMontoDia(rs.getDouble("hab_mondia"));
						lista.add(estadia);
					}
					
				} catch (SQLException e) {
				
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, "Error al traer la lista de Cliente"+e.getMessage());
				}
		  	  Conexion.cerrarConexion();
		  	  return lista;
		  	  
		  	  
		     }
		public static ArrayList<Estadia> listarEstadiasTodo(){
			 ArrayList<Estadia> lista=new ArrayList<>();
			 Estadia estadia=null;
		  	   String sql="SELECT * FROM estadia INNER JOIN cliente ON estadia.est_codcli=cliente.cli_codigo INNER JOIN habita ON estadia.est_codhab=habita.hab_codigo ORDER BY est_numero DESC";
		  	   
		  	  Conexion.abrirConexion();
		  	  try {
					ResultSet rs=Conexion.sentencia.executeQuery(sql);
					while(rs.next()){
						estadia=new Estadia();
						estadia.setCodigo(rs.getInt("est_numero"));
						estadia.setFechaEntrada(rs.getDate("est_fecha"));
						estadia.getCliente().setNombre(rs.getString("cli_nombre"));
						estadia.getHabitacion().setCodigo(rs.getInt("hab_codigo"));
						estadia.getHabitacion().setMontoDia(rs.getDouble("hab_mondia"));
						lista.add(estadia);
					}
					
				} catch (SQLException e) {
				
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, "Error al traer la lista de Cliente"+e.getMessage());
				}
		  	  Conexion.cerrarConexion();
		  	  return lista;
		  	  
		  	  
		     }
		   
		public static void modificarEstadia(Estadia estadia){
		 	   String sql="UPDATE estadia  SET est_fecha='"+estadia.getFechaEntrada()+"', est_codcli="+estadia.getCliente().getCodigo()+", est_codhab="+estadia.getHabitacion().getCodigo()+", est_fecsal='"+estadia.getFechaSalida()+"',est_monto="+estadia.getMonto()+", est_desc="+estadia.getDescuento()+", est_obse='"+estadia.getObservacion()+"', est_estado="+estadia.isEstado()+"  WHERE est_numero="+estadia.getCodigo()+";";
		 	   Conexion.abrirConexion();
		 	   try {
					Conexion.sentencia.executeUpdate(sql);
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, "La sentecia no fue ejecutada"+e.getMessage());
					e.printStackTrace();
				}
		 	   Conexion.cerrarConexion();
		 }
		public static void actualizarEstadia(Estadia estadia){
		 	   String sql="UPDATE estadia  SET  est_fecsal='"+estadia.getFechaSalida()+"',est_monto="+estadia.getMonto()+", est_desc="+estadia.getDescuento()+", est_estado="+false+"  WHERE est_numero="+estadia.getCodigo()+";";
		 	   System.out.println(sql);
		 	   Conexion.abrirConexion();
		 	   try {
					Conexion.sentencia.executeUpdate(sql);
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, "La sentecia no fue ejecutada"+e.getMessage());
					e.printStackTrace();
				}
		 	   Conexion.cerrarConexion();
		 }
		
		public static Estadia estadiaId(int codigo){
		  	   String sql="SELECT est_numero, est_fecha, est_codcli, est_codhab, est_fecsal, est_monto,est_desc, est_obse, est_estado  FROM estadia WHERE est_numero="+codigo+" AND est_estado=true ORDER BY est_numero DESC;";
		  	   Conexion.abrirConexion();
		  	   Estadia estadia=null;
		  	  try {
					ResultSet rs=Conexion.sentencia.executeQuery(sql);
					
					if(rs.next()){
						estadia=new Estadia();
						estadia.setCodigo(rs.getInt("est_numero"));
						estadia.setFechaEntrada(rs.getDate("est_fecha"));
						estadia.getCliente().setCodigo(rs.getInt("est_codcli"));
						estadia.getHabitacion().setCodigo(rs.getInt("est_codhab"));
						estadia.setFechaSalida(rs.getDate("est_fecsal"));
						estadia.setMonto(rs.getDouble("est_monto"));
						estadia.setDescuento(rs.getDouble("est_desc"));
						estadia.setObservacion(rs.getString("est_obse"));
						estadia.setEstado(rs.getBoolean("est_estado"));
						
						
						
					}
					
				} catch (SQLException e) {
				
					e.printStackTrace();
				}
		  	  Conexion.cerrarConexion();
		  	  return estadia;
		  	  
		  	  
		     }
		public static void eliminar(Estadia estadia){
			String sql="DELETE FROM estadia WHERE est_numero="+estadia.getCodigo()+"";
		    System.out.println(sql);
		    Conexion.abrirConexion();
		    try {
				Conexion.sentencia.executeUpdate(sql);
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "La sentecia no fue ejecutada"+e.getMessage());
				e.printStackTrace();
			}
		    Conexion.cerrarConexion();
		}
}
