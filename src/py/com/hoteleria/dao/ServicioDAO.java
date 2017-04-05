package py.com.hoteleria.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import py.com.hoteleria.model.Servicio;
import py.com.hoteleria.util.Conexion;

public class ServicioDAO {
	public void guardar(Servicio servicio){
		String sql="INSERT INTO servicio(ser_descri, ser_monto, ser_obse) VALUES ('"+servicio.getDescripcionServicio()+"',"+servicio.getMonto()+",'"+servicio.getObservacion()+"');";
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
	public static void modificarServicio(Servicio servicio){
 	   String sql="UPDATE servicio  SET  ser_descri='"+servicio.getDescripcionServicio()+"', ser_monto="+servicio.getMonto()+", ser_obse='"+servicio.getObservacion()+"' WHERE ser_codigo="+servicio.getCodigo()+";";
 	   Conexion.abrirConexion();
 	   try {
			Conexion.sentencia.executeUpdate(sql);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "La sentecia no fue ejecutada"+e.getMessage());
			e.printStackTrace();
		}
 	   Conexion.cerrarConexion();
 }
	public static void eliminarServicio(Servicio servicio){
		String sql="DELETE FROM servicio WHERE ser_codigo="+servicio.getCodigo()+"";
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
	public static ArrayList<Servicio> listarServicio(){
		 ArrayList<Servicio> lista=new ArrayList<>();
		 Servicio servicio=null;
	  	   String sql="SELECT ser_codigo, ser_descri, ser_monto FROM servicio;";
	  	  Conexion.abrirConexion();
	  	  try {
				ResultSet rs=Conexion.sentencia.executeQuery(sql);
				while(rs.next()){
					servicio=new Servicio();
					servicio.setCodigo(rs.getInt("ser_codigo"));
					servicio.setDescripcionServicio(rs.getString("ser_descri"));
					servicio.setMonto(rs.getDouble("ser_monto"));
					lista.add(servicio);
				}
				
			} catch (SQLException e) {
			
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Error al traer la lista de Servicio"+e.getMessage());
			}
	  	  Conexion.cerrarConexion();
	  	  return lista;
	  	  
	  	  
	     }
	public static Servicio servicioId(int codigo){
	  	   String sql="SELECT ser_codigo, ser_descri, ser_monto, ser_obse FROM servicio WHERE ser_codigo="+codigo+";";
	  	   Conexion.abrirConexion();
	  	   Servicio servicio=null;
	  	  try {
				ResultSet rs=Conexion.sentencia.executeQuery(sql);
				
				if(rs.next()){
					servicio=new Servicio();
					servicio.setCodigo(rs.getInt("ser_codigo"));
					servicio.setDescripcionServicio(rs.getString("ser_descri"));
					servicio.setMonto(rs.getDouble("ser_monto"));
					servicio.setObservacion(rs.getString("ser_obse"));
					
				}
				
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
	  	  Conexion.cerrarConexion();
	  	  return servicio;
	  	  
	  	  
	     }
	public static  ArrayList<Servicio> listarServicioDes(String descripcion){
		ArrayList<Servicio> lista=new ArrayList<Servicio>();
		Servicio servicio=null;
		String sql="SELECT ser_codigo, ser_descri, ser_monto, ser_obse FROM servicio WHERE ser_descri IlIKE '%"+descripcion+"%' ;";
		System.out.println(sql);
		Conexion.abrirConexion();
		try {
			ResultSet rs=Conexion.sentencia.executeQuery(sql);
			  while(rs.next()){
				  servicio=new Servicio();
					servicio.setCodigo(rs.getInt("ser_codigo"));
					servicio.setDescripcionServicio(rs.getString("ser_descri"));
					servicio.setMonto(rs.getDouble("ser_monto"));
				  lista.add(servicio);
				  
			  }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Conexion.cerrarConexion();
		return lista;
	}
	public static Servicio obtenerUltimoId(){
		String sql="SELECT MAX(ser_codigo)+1 AS ser_codigo FROM servicio;";
		System.out.println(sql);
		Conexion.abrirConexion();
		Servicio servicio=null;
		try {
			ResultSet rs=Conexion.sentencia.executeQuery(sql);
			if(rs.next()){
				servicio=new Servicio();
				servicio.setCodigo(rs.getInt("ser_codigo"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Conexion.cerrarConexion();
		return servicio;
	}
	
	public static  ArrayList<Servicio> listadoServicioCodigo(int desde, int hasta){
		ArrayList<Servicio> lista=new ArrayList<Servicio>();
		Servicio servicio=null;
		String sql="Select * from servicio where ser_codigo  BETWEEN "+desde+" AND "+hasta+"";
		System.out.println(sql);
		Conexion.abrirConexion();
		try {
			ResultSet rs=Conexion.sentencia.executeQuery(sql);
			  while(rs.next()){
				 servicio=new Servicio();
				 servicio.setCodigo(rs.getInt("ser_codigo"));
				 servicio.setDescripcionServicio(rs.getString("ser_descri"));
				 servicio.setMonto(rs.getDouble("ser_monto"));
				 servicio.setObservacion(rs.getString("ser_obse"));
				  lista.add(servicio);
				  
			  }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Conexion.cerrarConexion();
		return lista;
	}
	public static  ArrayList<Servicio> listadoServicio(String desde, String hasta){
		ArrayList<Servicio> lista=new ArrayList<Servicio>();
		Servicio servicio=null;
		String sql="Select * from servicio where ser_descri  BETWEEN '"+desde+"' AND '"+hasta+"'";
		System.out.println(sql);
		Conexion.abrirConexion();
		try {
			ResultSet rs=Conexion.sentencia.executeQuery(sql);
			  while(rs.next()){
				 servicio=new Servicio();
				 servicio.setCodigo(rs.getInt("ser_codigo"));
				 servicio.setDescripcionServicio(rs.getString("ser_descri"));
				 servicio.setMonto(rs.getDouble("ser_monto"));
				 servicio.setObservacion(rs.getString("ser_obse"));
				  lista.add(servicio);
				  
			  }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Conexion.cerrarConexion();
		return lista;
	}
}
