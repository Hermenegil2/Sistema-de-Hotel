package py.com.hoteleria.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import py.com.hoteleria.model.Deuda;
import py.com.hoteleria.model.Estadia;
import py.com.hoteleria.util.Conexion;

public class EstadiaDAO {
	
		public void guardar(Estadia estadia){
			String sql="INSERT INTO estadia(est_codcli, est_codhab,est_obse, est_activo) VALUES ("+estadia.getCliente().getCodigo()+","+estadia.getHabitacion().getCodigo()+",'"+estadia.getObservacion()+"',"+estadia.isEstado()+");";
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
		  	   String sql="SELECT * FROM estadia INNER JOIN cliente ON estadia.est_codcli=cliente.cli_codigo INNER JOIN habita ON estadia.est_codhab=habita.hab_codigo 	WHERE est_activo=true ORDER BY est_numero DESC";
		  	   
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
						estadia.setEstado(rs.getBoolean("est_activo"));
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
		  	   String sql="SELECT * FROM estadia INNER JOIN cliente ON estadia.est_codcli=cliente.cli_codigo INNER JOIN habita ON estadia.est_codhab=habita.hab_codigo 	WHERE est_activo=false ORDER BY est_numero DESC";
		  	   
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
						estadia.setEstado(rs.getBoolean("est_activo"));
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
						estadia.setEstado(rs.getBoolean("est_activo"));
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
		 	   String sql="UPDATE estadia  SET  est_codcli="+estadia.getCliente().getCodigo()+", est_codhab="+estadia.getHabitacion().getCodigo()+", est_obse='"+estadia.getObservacion()+"'  WHERE est_numero="+estadia.getCodigo()+";";
		 	   Conexion.abrirConexion();
		 	   try {
					Conexion.sentencia.executeUpdate(sql);
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, "La sentecia no fue ejecutada"+e.getMessage());
					e.printStackTrace();
				}
		 	   Conexion.cerrarConexion();
		 }
		
		public static void actualizarEstadia(Estadia estadia,Deuda deuda){
		 	   String sql="UPDATE estadia  SET  est_fecha='"+estadia.getFechaSalida()+"', est_monto="+estadia.getMonto()+", est_descu="+estadia.getDescuento()+", est_activo="+false+"  WHERE est_numero="+estadia.getCodigo()+";";
		 	   System.out.println(sql);
		 	  String sql1="INSERT INTO deuda(deu_nroest, deu_codcli, deu_monto)  VALUES ("+deuda.getEstadia().getCodigo()+","+deuda.getCliente().getCodigo()+","+deuda.getMontoDeuda()+");";
				System.out.println(sql1);
		 	   Conexion.abrirConexion();
		 	   try {
					Conexion.sentencia.executeUpdate(sql);
					Conexion.sentencia.executeUpdate(sql1);
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, "La sentecia no fue ejecutada"+e.getMessage());
					e.printStackTrace();
				}
		 	   Conexion.cerrarConexion();
		 }
		
		public static Estadia estadiaId(int codigo){
		  	   String sql="SELECT est_numero,TO_CHAR(est_fecha, 'dd/MM/yyyy') AS est_fecha,est_codcli,est_codhab,est_obse FROM estadia WHERE est_numero="+codigo+" ORDER BY est_numero DESC;";
		  	   Conexion.abrirConexion();
		  	   Estadia estadia=null;
		  	  try {
					ResultSet rs=Conexion.sentencia.executeQuery(sql);
					
					if(rs.next()){
						estadia=new Estadia();
						estadia.setCodigo(rs.getInt("est_numero"));
						estadia.setFecha(rs.getString("est_fecha"));
						estadia.getCliente().setCodigo(rs.getInt("est_codcli"));
						estadia.getHabitacion().setCodigo(rs.getInt("est_codhab"));
						estadia.setObservacion(rs.getString("est_obse"));
						
						
						
						
					}
					
				} catch (SQLException e) {
				
					e.printStackTrace();
				}
		  	  Conexion.cerrarConexion();
		  	  return estadia;
		  	  
		  	  
		     }
		
		public static void eliminar(Estadia estadia){
			String sql="DELETE FROM estadia WHERE est_numero="+estadia.getCodigo()+" AND est_activo=true ";
		    System.out.println(sql);
		    Conexion.abrirConexion();
		    try {
				Conexion.sentencia.executeUpdate(sql);
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "No se puede Eliminar. Elimina primero Detalle");
				e.printStackTrace();
			}
		    Conexion.cerrarConexion();
		}
		
		public static Estadia obtenerUltimoId(){
			String sql="SELECT MAX(est_numero)+1 AS est_numero FROM estadia;";
			System.out.println(sql);
			Conexion.abrirConexion();
			Estadia estadia=null;
			try {
				ResultSet rs=Conexion.sentencia.executeQuery(sql);
				if(rs.next()){
				    estadia=new Estadia();
				    estadia.setCodigo(rs.getInt("est_numero"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Conexion.cerrarConexion();
			return estadia;
		}
		public static  ArrayList<Estadia> buscarEstadia(String nombre){
			ArrayList<Estadia> lista=new ArrayList<Estadia>();
			Estadia estadia=null;
			String sql="SELECT est_numero,cli_nombre,est_codhab,est_fecha,hab_mondia FROM estadia INNER JOIN cliente ON estadia.est_codcli=cliente.cli_codigo INNER JOIN habita ON estadia.est_codhab=habita.hab_codigo WHERE cli_nombre ILIKE '%"+nombre+"%' AND est_activo=true";
			System.out.println(sql);
			Conexion.abrirConexion();
			try {
				ResultSet rs=Conexion.sentencia.executeQuery(sql);
				  while(rs.next()){
					  estadia=new Estadia();
					  estadia.setCodigo(rs.getInt("est_numero"));
					  estadia.getCliente().setNombre(rs.getString("cli_nombre"));
					  estadia.getHabitacion().setCodigo(rs.getInt("est_codhab"));
					  estadia.setFechaEntrada(rs.getDate("est_fecha"));
					  estadia.getHabitacion().setMontoDia(rs.getDouble("hab_mondia"));
					  lista.add(estadia);
					  
				  }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Conexion.cerrarConexion();
			return lista;
		}
		
		public static Deuda traerNroDeuda(int codigo){
		  	   String sql="SELECT deu_numero FROM deuda WHERE deu_nroest="+codigo+"";
		  	   Conexion.abrirConexion();
		  	   Deuda deuda=null;
		  	  try {
					ResultSet rs=Conexion.sentencia.executeQuery(sql);
					
					if(rs.next()){
						deuda=new Deuda();
						deuda.setCodigo(rs.getInt("deu_numero"));
						
						
						
					}
					
				} catch (SQLException e) {
				
					e.printStackTrace();
				}
		  	  Conexion.cerrarConexion();
		  	  return deuda;
		  	  
		  	  
		     }
}
