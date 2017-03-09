package py.com.hoteleria.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import py.com.hoteleria.model.Habitacion;
import py.com.hoteleria.util.Conexion;

public class HabitacionDAO {
	public void guardar(Habitacion habita){
		String sql="INSERT INTO habita(hab_descri, hab_mondia, hab_obse) VALUES ('"+habita.getDescripcionHabitacion()+"',"+habita.getMontoDia()+",'"+habita.getObservacion()+"');";
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
	public static ArrayList<Habitacion> listarHabitacion(){
		 ArrayList<Habitacion> lista=new ArrayList<>();
		 Habitacion habita=null;
	  	   String sql="SELECT * FROM habita WHERE hab_estado=false ";
	  	   
	  	  Conexion.abrirConexion();
	  	  try {
				ResultSet rs=Conexion.sentencia.executeQuery(sql);
				while(rs.next()){
					habita=new Habitacion();
					habita.setCodigo(rs.getInt("hab_codigo"));
					habita.setDescripcionHabitacion(rs.getString("hab_descri"));
					habita.setMontoDia(rs.getDouble("hab_mondia"));
					habita.setObservacion(rs.getString("hab_obse"));
					lista.add(habita);
				}
				
			} catch (SQLException e) {
			
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Error al traer la lista de Habitacion"+e.getMessage());
			}
	  	  Conexion.cerrarConexion();
	  	  return lista;
	  	  
	  	  
	     }
	public static void modificarHabitacion(Habitacion habita){
 	   String sql="UPDATE habita SET hab_descri='"+habita.getDescripcionHabitacion()+"', hab_mondia="+habita.getMontoDia()+", hab_obse='"+habita.getObservacion()+"' WHERE hab_codigo="+habita.getCodigo()+" ;";
 	   Conexion.abrirConexion();
 	   try {
			Conexion.sentencia.executeUpdate(sql);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "La sentecia no fue ejecutada"+e.getMessage());
			e.printStackTrace();
		}
 	   Conexion.cerrarConexion();
 }
	public static void actualizarHabitacion(Habitacion habita){
	 	   String sql="UPDATE habita SET hab_estado="+true+" WHERE hab_codigo="+habita.getCodigo()+" ;";
	 	   Conexion.abrirConexion();
	 	   try {
				Conexion.sentencia.executeUpdate(sql);
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "La sentecia no fue ejecutada"+e.getMessage());
				e.printStackTrace();
			}
	 	   Conexion.cerrarConexion();
	 }
	public static void actualizarHabitacionFalse(Habitacion habita){
	 	   String sql="UPDATE habita SET hab_estado="+false+" WHERE hab_codigo="+habita.getCodigo()+" ;";
	 	   Conexion.abrirConexion();
	 	   try {
				Conexion.sentencia.executeUpdate(sql);
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "La sentecia no fue ejecutada"+e.getMessage());
				e.printStackTrace();
			}
	 	   Conexion.cerrarConexion();
	 }
	public static void eliminar(Habitacion habita){
		String sql="DELETE FROM habita WHERE hab_codigo="+habita.getCodigo()+"";
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
	
	public static Habitacion habitacionId(int codigo){
	  	   String sql="SELECT hab_codigo, hab_descri, hab_mondia, hab_obse FROM habita WHERE hab_codigo="+codigo+";";
	  	   Conexion.abrirConexion();
	  	   Habitacion habita=null;
	  	  try {
				ResultSet rs=Conexion.sentencia.executeQuery(sql);
				
				if(rs.next()){
					habita=new Habitacion();
					habita.setCodigo(rs.getInt("hab_codigo"));
					habita.setDescripcionHabitacion(rs.getString("hab_descri"));
					habita.setMontoDia(rs.getDouble("hab_mondia"));
					habita.setObservacion(rs.getString("hab_obse"));
					
				}
				
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
	  	  Conexion.cerrarConexion();
	  	  return habita;
	  	  
	  	  
	     }
	public static  ArrayList<Habitacion> listarHabitacionDes(String descripcion){
		ArrayList<Habitacion> lista=new ArrayList<Habitacion>();
		Habitacion habita=null;
		String sql="SELECT hab_codigo, hab_descri, hab_mondia FROM habita WHERE hab_descri IlIKE '%"+descripcion+"%' ;";
		System.out.println(sql);
		Conexion.abrirConexion();
		try {
			ResultSet rs=Conexion.sentencia.executeQuery(sql);
			  while(rs.next()){
				    habita=new Habitacion();
				    habita.setCodigo(rs.getInt("hab_codigo"));
					habita.setDescripcionHabitacion(rs.getString("hab_descri"));
					habita.setMontoDia(rs.getDouble("hab_mondia"));
				  lista.add(habita);
				  
			  }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Conexion.cerrarConexion();
		return lista;
	}
	public static Habitacion obtenerUltimoId(){
		String sql="SELECT MAX(hab_codigo)+1 AS hab_codigo FROM habita;";
		System.out.println(sql);
		Conexion.abrirConexion();
		Habitacion habita=null;
		try {
			ResultSet rs=Conexion.sentencia.executeQuery(sql);
			if(rs.next()){
				habita=new Habitacion();
				habita.setCodigo(rs.getInt("hab_codigo"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Conexion.cerrarConexion();
		return habita;
	}
}
