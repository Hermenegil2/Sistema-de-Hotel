package py.com.hoteleria.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import py.com.hoteleria.model.Cobranza;
import py.com.hoteleria.util.Conexion;

public class CobranzaDAO {
	public void guardar(Cobranza cobranza){
		String sql="INSERT INTO cobranza(cob_fecha, cob_nrodeu, cob_codcli, cob_pagado) VALUES ('"+cobranza.getFecha()+"',"+cobranza.getDeuda().getCodigo()+","+cobranza.getCliente().getCodigo()+","+cobranza.getMontoPagado()+");";
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
	public static ArrayList<Cobranza> listarCobranza(){
		 ArrayList<Cobranza> lista=new ArrayList<>();
		Cobranza cobranza=null;
	  	   String sql="SELECT cob_numero,cob_fecha,deu_monto,cli_nombre,cob_pagado FROM cobranza INNER JOIN cliente ON cobranza.cob_codcli=cliente.cli_codigo INNER JOIN deuda ON cobranza.cob_nrodeu=deuda.deu_numero";
	  	   
	  	  Conexion.abrirConexion();
	  	  try {
				ResultSet rs=Conexion.sentencia.executeQuery(sql);
				while(rs.next()){
					cobranza=new Cobranza();
					cobranza.setCodigo(rs.getInt("cob_numero"));
					cobranza.setFecha(rs.getDate("cob_fecha"));
					cobranza.getDeuda().setMontoDeuda(rs.getDouble("deu_monto"));
					cobranza.getCliente().setNombre(rs.getString("cli_nombre"));
					cobranza.setMontoPagado(rs.getDouble("cob_pagado"));
					lista.add(cobranza);
				}
				
			} catch (SQLException e) {
			
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Error al traer la lista de cobranza"+e.getMessage());
			}
	  	  Conexion.cerrarConexion();
	  	  return lista;
	  	  
	  	  
	     }
	public static void modificarCobranza(Cobranza cobranza){
	 	   String sql="UPDATE cobranza  SET cob_fecha='"+cobranza.getFecha()+"', cob_nrodeuda="+cobranza.getDeuda().getCodigo()+", cob_codcli="+cobranza.getCliente().getCodigo()+", cob_pagado="+cobranza.getMontoPagado()+"  WHERE cob_codigo="+cobranza.getCodigo()+";";
	 	   Conexion.abrirConexion();
	 	   try {
				Conexion.sentencia.executeUpdate(sql);
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "La sentecia no fue ejecutada"+e.getMessage());
				e.printStackTrace();
			}
	 	   Conexion.cerrarConexion();
	 }
	public static void eliminar(Cobranza cobranza){
		String sql="DELETE FROM cobranza WHERE cob_codigo="+cobranza.getCodigo()+"";
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
	public static Cobranza CobranzaId(int codigo){
	  	   String sql="SELECT cob_codigo, cob_fecha, cob_nrodeuda, cob_codcli, cob_pagado FROM cobranza WHERE cob_codigo="+codigo+" ORDER BY cob_codigo ASC;";
	  	   Conexion.abrirConexion();
	  	   Cobranza cobranza=null;
	  	 	  try {
				ResultSet rs=Conexion.sentencia.executeQuery(sql);
				if(rs.next()){
					cobranza=new Cobranza();
					cobranza.setCodigo(rs.getInt("cob_codigo"));
					cobranza.setFecha(rs.getDate("cob_fecha"));
					cobranza.getDeuda().setCodigo(rs.getInt("cob_nrodeuda"));
					cobranza.getCliente().setCodigo(rs.getInt("cob_codcli"));
					cobranza.setMontoPagado(rs.getDouble("cob_pagado"));
					
					
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
	  	  Conexion.cerrarConexion();
	  	  return cobranza;
	  	  
	  	  
	     }
	
	public static Cobranza obtenerUltimoId(){
		String sql="SELECT MAX(cob_numero)+1 AS cob_codigo FROM cobranza;";
		System.out.println(sql);
		Conexion.abrirConexion();
		Cobranza cobranza=null;
		try {
			ResultSet rs=Conexion.sentencia.executeQuery(sql);
			if(rs.next()){
				cobranza=new Cobranza();
				cobranza.setCodigo(rs.getInt("cob_codigo"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Conexion.cerrarConexion();
		return cobranza;
	}
}
