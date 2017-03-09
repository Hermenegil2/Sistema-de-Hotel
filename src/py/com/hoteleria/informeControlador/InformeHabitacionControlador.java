package py.com.hoteleria.informeControlador;

import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import py.com.hoteleria.dao.HabitacionDAO;
import py.com.hoteleria.informe.InformeHabitacion;
import py.com.hoteleria.model.Habitacion;

public class InformeHabitacionControlador {
	DecimalFormat formatea = new DecimalFormat("###,###.##"+" Gs");
	private InformeHabitacion ventana;
	
	public InformeHabitacionControlador(InformeHabitacion v){
		this.ventana=v;
	}
	
	public void listarHabitacion(){
		DefaultTableModel modelo=(DefaultTableModel) ventana.getTableHabitacion().getModel();
		ArrayList<Habitacion>lista=HabitacionDAO.listarHabitacion();
		Object[] fila=new Object[modelo.getColumnCount()];
	    for (int i = 0; i < lista.size(); i++) {
	    	fila[0]=lista.get(i).getCodigo();
	    	fila[1]=lista.get(i).getDescripcionHabitacion();
	    	fila[2]=formatea.format(lista.get(i).getMontoDia());
	    	fila[3]=lista.get(i).getObservacion();
	    	modelo.addRow(fila);
	    }
		}

}
