package py.com.hoteleria.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import py.com.hoteleria.model.Deuda;
import py.com.hoteleria.util.Conexion;

public class DeudaDAO {
	public void guardar(Deuda deuda){
		String sql="INSERT INTO deuda(deu_nroest, deu_codcli, deu_monto, deu_pagado)  VALUES ("+deuda.getEstadia().getCodigo()+","+deuda.getCliente().getCodigo()+","+deuda.getMontoDeuda()+","+deuda.getMontoPagado()+");";
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
	public static ArrayList<Deuda> listarDeuda(){
		 ArrayList<Deuda> lista=new ArrayList<>();
		 Deuda deuda=null;
	  	   String sql="SELECT deu_numero,estadia.est_monto,cliente.cli_nombre, deu_monto, deu_pagado FROM deuda INNER JOIN estadia ON deuda.deu_nroest=estadia.est_numero INNER JOIN cliente ON deuda.deu_codcli=cliente.cli_codigo;";
	  	   
	  	  Conexion.abrirConexion();
	  	  try {
				ResultSet rs=Conexion.sentencia.executeQuery(sql);
				while(rs.next()){
					deuda=new Deuda();
					deuda.setCodigo(rs.getInt("deu_numero"));
					deuda.getEstadia().setMonto(rs.getDouble("est_monto"));
					deuda.getCliente().setNombre(rs.getString("cli_nombre"));
					deuda.setMontoDeuda(rs.getDouble("deu_monto"));
					deuda.setMontoPagado(rs.getDouble("deu_pagado"));
					lista.add(deuda);
				}
				
			} catch (SQLException e) {
			
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Error al traer la lista de Deuda"+e.getMessage());
			}
	  	  Conexion.cerrarConexion();
	  	  return lista;
	  	  
	  	  
	     }
	public static void modificarDeuda(Deuda deuda){
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
