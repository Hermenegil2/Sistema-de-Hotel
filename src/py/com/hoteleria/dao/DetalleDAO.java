package py.com.hoteleria.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import py.com.hoteleria.model.Detalle;
import py.com.hoteleria.util.Conexion;

public class DetalleDAO {
	public void guardar(Detalle detalle){
		String sql="INSERT INTO detalle(det_nroest, det_codser, det_monto) VALUES ("+detalle.getEstadia().getCodigo()+","+detalle.getServicio().getCodigo()+","+detalle.getMonto()+");";
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
	public static ArrayList<Detalle> listarDetalle(int codigo){
		 ArrayList<Detalle> lista=new ArrayList<Detalle>();
		 Detalle detalle=null;
	  	   String sql="SELECT * FROM detalle WHERE det_nroest="+codigo+";";
	  	   
	  	  Conexion.abrirConexion();
	  	  try {
				ResultSet rs=Conexion.sentencia.executeQuery(sql);
				while(rs.next()){
					detalle=new Detalle();
					detalle.setCodigo(rs.getInt("det_numero"));
					detalle.getEstadia().setCodigo(rs.getInt("det_nroest"));
					detalle.getServicio().setCodigo(rs.getInt("det_codser"));
					//detalle.getServicio().setDescripcionServicio(rs.getString("ser_descri"));
					detalle.setMonto(rs.getInt("det_monto"));
					lista.add(detalle);
				}
				
			} catch (SQLException e) {
			
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Error al traer la lista de detalle"+e.getMessage());
			}
	  	  Conexion.cerrarConexion();
	  	  return lista;
	  	  
	  	  
	     }
	public static void modificarDetalle(Detalle detalle){
	 	   String sql="";
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
