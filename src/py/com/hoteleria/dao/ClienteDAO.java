package py.com.hoteleria.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import py.com.hoteleria.model.Cliente;
import py.com.hoteleria.util.Conexion;

public class ClienteDAO {
	public void guardar(Cliente cliente){
		String sql="INSERT INTO cliente(cli_codigo,cli_nombre, cli_cedula, cli_ruc, cli_direcc, cli_telefo) VALUES ("+cliente.getCodigo()+",'"+cliente.getNombre()+"',"+cliente.getCedula()+",'"+cliente.getRuc()+"','"+cliente.getDireccion()+"',"+cliente.getTelefono()+");";
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
	public static void modificarCliente(Cliente cliente){
 	   String sql="UPDATE cliente SET cli_nombre='"+cliente.getNombre()+"', cli_cedula="+cliente.getCedula()+", cli_ruc='"+cliente.getRuc()+"', cli_direcc='"+cliente.getDireccion()+"', cli_telefo="+cliente.getTelefono()+" WHERE cli_codigo="+cliente.getCodigo()+";";
 	   Conexion.abrirConexion();
 	   try {
			Conexion.sentencia.executeUpdate(sql);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "La sentecia no fue ejecutada"+e.getMessage());
			e.printStackTrace();
		}
 	   Conexion.cerrarConexion();
 }
	public static void eliminar(Cliente cliente){
		String sql="DELETE FROM cliente WHERE cli_codigo="+cliente.getCodigo()+"";
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
	public static ArrayList<Cliente> listarCliente(){
		 ArrayList<Cliente> lista=new ArrayList<>();
		 Cliente cliente=null;
	  	   String sql="SELECT cli_codigo, cli_nombre, cli_cedula FROM cliente ORDER BY cli_codigo ASC;";
	  	   
	  	  Conexion.abrirConexion();
	  	  try {
				ResultSet rs=Conexion.sentencia.executeQuery(sql);
				while(rs.next()){
					cliente=new Cliente();
					cliente.setCodigo(rs.getInt("cli_codigo"));
					cliente.setNombre(rs.getString("cli_nombre"));
					cliente.setCedula(rs.getInt("cli_cedula"));
					lista.add(cliente);
				}
				
			} catch (SQLException e) {
			
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Error al traer la lista de Cliente"+e.getMessage());
			}
	  	  Conexion.cerrarConexion();
	  	  return lista;
	  	  
	  	  
	     }
	public static Cliente clienteId(int codigo){
	  	   String sql="SELECT cli_codigo,cli_nombre, cli_cedula, cli_ruc, cli_direcc, cli_telefo  FROM cliente WHERE cli_codigo="+codigo+" ORDER BY cli_codigo ASC;";
	  	   Conexion.abrirConexion();
	  	 Cliente cliente=null;
	  	  try {
				ResultSet rs=Conexion.sentencia.executeQuery(sql);
				
				if(rs.next()){
					cliente=new Cliente();
					cliente.setCodigo(rs.getInt("cli_codigo"));
					cliente.setNombre(rs.getString("cli_nombre"));
					cliente.setCedula(rs.getInt("cli_cedula"));
					cliente.setRuc(rs.getString("cli_ruc"));
					cliente.setDireccion(rs.getString("cli_direcc"));
					cliente.setTelefono(rs.getInt("cli_telefo"));
					
					
					
				}
				
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
	  	  Conexion.cerrarConexion();
	  	  return cliente;
	  	  
	  	  
	     }
	public static  ArrayList<Cliente> listasCliente(String nombre){
		ArrayList<Cliente> lista=new ArrayList<Cliente>();
		Cliente cliente=null;
		String sql="SELECT cli_codigo, cli_nombre, cli_cedula FROM cliente WHERE cli_nombre IlIKE '%"+nombre+"%' ORDER BY cli_codigo ASC";
		System.out.println(sql);
		Conexion.abrirConexion();
		try {
			ResultSet rs=Conexion.sentencia.executeQuery(sql);
			  while(rs.next()){
				  cliente=new Cliente();
				  cliente.setCodigo(rs.getInt("cli_codigo"));
				  cliente.setNombre(rs.getString("cli_nombre"));
				  cliente.setCedula(rs.getInt("cli_cedula"));
				  lista.add(cliente);
				  
			  }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Conexion.cerrarConexion();
		return lista;
	}
	public static Cliente obtenerUltimoId(){
		String sql="SELECT MAX(cli_codigo)+1 AS cli_codigo FROM cliente;";
		System.out.println(sql);
		Conexion.abrirConexion();
		Cliente cliente=null;
		try {
			ResultSet rs=Conexion.sentencia.executeQuery(sql);
			if(rs.next()){
				cliente=new Cliente();
				cliente.setCodigo(rs.getInt("cli_codigo"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Conexion.cerrarConexion();
		return cliente;
	}
	
}
