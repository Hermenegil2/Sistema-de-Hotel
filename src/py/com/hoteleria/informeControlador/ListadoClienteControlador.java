package py.com.hoteleria.informeControlador;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import py.com.hoteleria.dao.ClienteDAO;
import py.com.hoteleria.informe.ListadoClientes;
import py.com.hoteleria.model.Cliente;

public class ListadoClienteControlador {
	private ListadoClientes ventana;
	
	public ListadoClienteControlador(ListadoClientes v){
		this.ventana=v;
	}
	public void listarClientes(){
		DefaultTableModel modelo=(DefaultTableModel) ventana.getTableClientes().getModel();
		ArrayList<Cliente>lista=ClienteDAO.listarCliente();
		Object[] fila=new Object[modelo.getColumnCount()];
	    for (int i = 0; i < lista.size(); i++) {
	    	fila[0]=lista.get(i).getCodigo();
	    	fila[1]=lista.get(i).getNombre();
	    	fila[2]=lista.get(i).getCedula();
	    	fila[3]=lista.get(i).getRuc();
	    	fila[4]=lista.get(i).getDireccion();
	    	fila[5]=lista.get(i).getTelefono();
	    	modelo.addRow(fila);
	    }
		}
}
