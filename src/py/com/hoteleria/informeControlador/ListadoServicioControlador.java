package py.com.hoteleria.informeControlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.text.MessageFormat;
import java.util.ArrayList;
import javax.swing.JTable.PrintMode;
import javax.swing.table.DefaultTableModel;
import py.com.hoteleria.dao.ServicioDAO;
import py.com.hoteleria.informe.ListadoServicio;
import py.com.hoteleria.model.Servicio;

public class ListadoServicioControlador implements ActionListener {
	private ListadoServicio ventana;
	private ArrayList<Servicio> servicio;
	
	public ListadoServicioControlador(ListadoServicio v){
		this.ventana=v;
		ventana.getBtnImprimir().addActionListener(this);
		ventana.getBtnProcesarC().addActionListener(this);
		ventana.getBtnProcesarN().addActionListener(this);
		ventana.getBtnSalir().addActionListener(this);
	}
	private void imprimir() {
		try {
		MessageFormat headerFormat = null;
		MessageFormat footerFormat = null;
		ventana.getTableServicio().print(PrintMode.FIT_WIDTH,headerFormat, footerFormat);
		} catch (PrinterException e) {
		
			e.printStackTrace();
		}
		

}
	
	public void listarDescrip(){
		servicio=new ArrayList<Servicio>();
        servicio=ServicioDAO.listarServicio();
		DefaultTableModel modelo=(DefaultTableModel) ventana.getTableServicio().getModel();
		Object[] fila=new Object[modelo.getColumnCount()];
		for (int i = 0; i <servicio.size(); i++) {					
			fila[0]=servicio.get(i).getCodigo();
			fila[1]=servicio.get(i).getDescripcionServicio();
			fila[2]=servicio.get(i).getMonto();
			fila[3]=servicio.get(i).getObservacion();
			modelo.addRow(fila);
		}
	}
	
	public void listarCodigo(){
		servicio=new ArrayList<Servicio>();
		Integer desde=Integer.parseInt(ventana.getCdesde().getText());
		Integer hasta=Integer.parseInt(ventana.getChasta().getText());
		servicio=ServicioDAO.listadoServicioCodigo(desde, hasta);
		DefaultTableModel modelo=(DefaultTableModel) ventana.getTableServicio().getModel();
			Object[] fila=new Object[modelo.getColumnCount()];
			for (int i = 0; i <servicio.size(); i++) {					
				fila[0]=servicio.get(i).getCodigo();
				fila[1]=servicio.get(i).getDescripcionServicio();
				fila[2]=servicio.get(i).getMonto();
				fila[3]=servicio.get(i).getObservacion();
				modelo.addRow(fila);
			}
}
	private void listarNombre(){
		servicio=new ArrayList<Servicio>();
		String desde=ventana.getNdesde().getText();
		String hasta=ventana.getNhasta().getText();
		servicio=ServicioDAO.listadoServicio(desde, hasta);
		DefaultTableModel modelo=(DefaultTableModel) ventana.getTableServicio().getModel();
			Object[] fila=new Object[modelo.getColumnCount()];
			for (int i = 0; i <servicio.size(); i++) {					
				fila[0]=servicio.get(i).getCodigo();
				fila[1]=servicio.get(i).getDescripcionServicio();
				fila[2]=servicio.get(i).getMonto();
				fila[3]=servicio.get(i).getObservacion();
				modelo.addRow(fila);
			}
			
}

	public void limpiarTabla() {
		DefaultTableModel modelo=(DefaultTableModel) ventana.getTableServicio().getModel();
		for (int i = 0; i < ventana.getTableServicio().getRowCount(); i++) {
			modelo.removeRow(i);
			i-=1;
		}
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(ventana.getBtnProcesarC())) {
			limpiarTabla();
			listarCodigo();
		}
		if (e.getSource().equals(ventana.getBtnProcesarN())) {
			limpiarTabla();
			listarNombre();
		}
		if (e.getSource().equals(ventana.getBtnImprimir())) {
			imprimir();
		}
		if (e.getSource().equals(ventana.getBtnSalir())) {
			this.ventana.dispose();
		}
		
	}
		
		
}
