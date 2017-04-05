package py.com.hoteleria.informeControlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.print.PrinterException;
import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.util.ArrayList;

import javax.swing.JTable.PrintMode;
import javax.swing.table.DefaultTableModel;

import py.com.hoteleria.dao.HabitacionDAO;
import py.com.hoteleria.informe.ListadoHabitacion;
import py.com.hoteleria.model.Habitacion;


public class ListadoHabitacionControlador implements ActionListener,KeyListener{
	DecimalFormat formatea = new DecimalFormat("###,###.##"+" Gs");
	private ListadoHabitacion ventana;
	
	public ListadoHabitacionControlador(ListadoHabitacion v){
		this.ventana=v;
		ventana.getBtnProcesarC().addActionListener(this);
		ventana.getBtnProcesarN().addActionListener(this);
		ventana.getBtnImprimir().addActionListener(this);
		ventana.getBtnSalir().addActionListener(this);
		ventana.getCdesde().addKeyListener(this);
		ventana.getChasta().addKeyListener(this);
		ventana.getNdesde().addKeyListener(this);
		ventana.getNhasta().addKeyListener(this);
	}
	
	private void imprimir() {
		try {
		MessageFormat headerFormat = null;
		MessageFormat footerFormat = null;
		ventana.getTableHabitacion().print(PrintMode.FIT_WIDTH,headerFormat, footerFormat);
		} catch (PrinterException e) {
		
			e.printStackTrace();
		}
		

}
	
	public void listarDescrip(){
		ArrayList<Habitacion>habitacion=new ArrayList<Habitacion>();
        String descripcion="";
		habitacion=HabitacionDAO.listarHabitacionDes(descripcion);
		DefaultTableModel modelo=(DefaultTableModel) ventana.getTableHabitacion().getModel();
		Object[] fila=new Object[modelo.getColumnCount()];
		for (int i = 0; i <habitacion.size(); i++) {					
			fila[0]=habitacion.get(i).getCodigo();
			fila[1]=habitacion.get(i).getDescripcionHabitacion();
			fila[2]=habitacion.get(i).getMontoDia();
			fila[3]=habitacion.get(i).getObservacion();
			modelo.addRow(fila);
		}
	}
	
	public void listarCodigo(){
		ArrayList<Habitacion> habita=new ArrayList<Habitacion>();
		Integer desde=Integer.parseInt(ventana.getCdesde().getText());
		Integer hasta=Integer.parseInt(ventana.getChasta().getText());
		habita=HabitacionDAO.listadoHabitacionCodigo(desde, hasta);
		DefaultTableModel modelo=(DefaultTableModel) ventana.getTableHabitacion().getModel();
			Object[] fila=new Object[modelo.getColumnCount()];
			for (int i = 0; i <habita.size(); i++) {					
				fila[0]=habita.get(i).getCodigo();
				fila[1]=habita.get(i).getDescripcionHabitacion();
				fila[2]=habita.get(i).getMontoDia();
				fila[3]=habita.get(i).getObservacion();
				modelo.addRow(fila);
			}
}
	private void listarNombre(){
		ArrayList<Habitacion> habita=new ArrayList<Habitacion>();
		String desde=ventana.getNdesde().getText();
		String hasta=ventana.getNhasta().getText();
		habita=HabitacionDAO.listadoHabitacionNombre(desde, hasta);
		DefaultTableModel modelo=(DefaultTableModel) ventana.getTableHabitacion().getModel();
			Object[] fila=new Object[modelo.getColumnCount()];
			for (int i = 0; i <habita.size(); i++) {					
				fila[0]=habita.get(i).getCodigo();
				fila[1]=habita.get(i).getDescripcionHabitacion();
				fila[2]=habita.get(i).getMontoDia();
				fila[3]=habita.get(i).getObservacion();
				modelo.addRow(fila);
			}
			
}

	public void limpiarTabla() {
		DefaultTableModel modelo=(DefaultTableModel) ventana.getTableHabitacion().getModel();
		for (int i = 0; i < ventana.getTableHabitacion().getRowCount(); i++) {
			modelo.removeRow(i);
			i-=1;
		}
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e ) {
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
			ventana.dispose();
		}
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		if (e.getSource().equals(ventana.getCdesde())) {
			char car=e.getKeyChar();
			if(  ventana.getCdesde().getText().length()>=8)e.consume();
			if((car<'0' || car>'9') ) e.consume();
		}
		if (e.getSource().equals(ventana.getChasta())) {
			char car=e.getKeyChar();
			if(  ventana.getChasta().getText().length()>=8)e.consume();
			if((car<'0' || car>'9') ) e.consume();
		}
		if (e.getSource().equals(ventana.getNdesde())) {
			char car=e.getKeyChar();
			if(  ventana.getNdesde().getText().length()>=1)e.consume();
			if((car<'a' || car>'z') && (car<'A' || car>'Z') ) e.consume();
		}
		if (e.getSource().equals(ventana.getNhasta())) {
			char car=e.getKeyChar();
			if(  ventana.getNhasta().getText().length()>=1)e.consume();
			if((car<'a' || car>'z') && (car<'A' || car>'Z') ) e.consume();
		}
	}

}
