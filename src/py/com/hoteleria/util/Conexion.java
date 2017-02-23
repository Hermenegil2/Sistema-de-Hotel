package py.com.hoteleria.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {
		private static String Driver="org.postgresql.Driver";
		private static String RUTA="jdbc:postgresql://localhost:5432/hoteleria_bd";
		private static String USER="postgres";
		private static String PASSWORD="herme66288";
		public static Statement sentencia;
		public static Connection conexion;
		
		public static Connection abrirConexion(){
			try {
				Class.forName(Driver);
				System.out.println("Succeso en el Driver");
			} catch (ClassNotFoundException e) {
				System.out.println("Error en el Driver");
				e.printStackTrace();
			}
			try {
				conexion=DriverManager.getConnection(RUTA, USER, PASSWORD);
				sentencia=conexion.createStatement();
				System.out.println("Succeso en la Conexion");
			} catch (SQLException e) {
			 System.out.println("Error en la Conexion");
				e.printStackTrace();
			}
			return conexion;
		}
		
		public static void cerrarConexion(){
			if(conexion !=null){
				try {
					conexion.close();
					sentencia.close();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
}
