package py.com.hoteleria.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import py.com.hoteleria.model.Habitacion;
import py.com.hoteleria.util.Conexion;

public class HabitacionDAO {
	public void guardar(Habitacion habita){
		String sql="INSERT INTO habita(hab_descri, hab_mondia, hab_obse, hab_activo) VALUES ('"+habita.getDescripcionHabitacion()+"',"+habita.getMontoDia()+",'"+habita.getObservacion()+"',"+habita.isEstado()+");";
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
	 	   String sql="UPDATE habita SET hab_activo="+true+" WHERE hab_codigo="+habita.getCodigo()+" ;";
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
	 	   String sql="UPDATE habita SET hab_activo="+false+" WHERE hab_codigo="+habita.getCodigo()+" ;";
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
		String sql="SELECT * FROM habita WHERE hab_descri IlIKE '%"+descripcion+"%' ORDER BY hab_codigo ASC ;";
		System.out.println(sql);
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Conexion.cerrarConexion();
		return lista;
	}
	
	public static  ArrayList<Habitacion> listarHabitacionLista(String descripcion){
		ArrayList<Habitacion> lista=new ArrayList<Habitacion>();
		Habitacion habita=null;
		String sql="SELECT hab_codigo, hab_descri, hab_mondia FROM habita WHERE hab_descri IlIKE '%"+descripcion+"%' AND hab_activo=false ORDER BY hab_codigo DESC ;";
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
	public static  ArrayList<Habitacion> listadoHabitacionCodigo(int desde, int hasta){
		ArrayList<Habitacion> lista=new ArrayList<Habitacion>();
		Habitacion habita=null;
		String sql="Select * from habita where hab_codigo  BETWEEN "+desde+" AND "+hasta+"";
		System.out.println(sql);
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Conexion.cerrarConexion();
		return lista;
	}
	public static  ArrayList<Habitacion> listadoHabitacionNombre(String desde, String hasta){
		ArrayList<Habitacion> lista=new ArrayList<Habitacion>();
		Habitacion habita=null;
		String sql="Select * from habita where hab_descri  BETWEEN '"+desde+"' AND '"+hasta+"'";
		System.out.println(sql);
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Conexion.cerrarConexion();
		return lista;
	}
}
