package py.com.hoteleria.informeControlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import py.com.hoteleria.dao.EstadiaDAO;
import py.com.hoteleria.informe.InformeHospedaje;
import py.com.hoteleria.model.Estadia;

public class InformeHospedajeControlador  implements ActionListener{

	private InformeHospedaje ventana;
	private double total=0;
	private double total1=0;
	private double total2=0;
	DecimalFormat formatea = new DecimalFormat("###,###.##"+" Gs");
	
	public InformeHospedajeControlador(InformeHospedaje v){
		this.ventana=v;
		ventana.getBtnProcesarC().addActionListener(this);
		ventana.getBtnProcesarN().addActionListener(this);
		ventana.getBtnProcesarF().addActionListener(this);
		ventana.getBtnSalir().addActionListener(this);
		ventana.getBtnImprimir().addActionListener(this);
		
		ventana.getBtnTodoC().addActionListener(this);
		ventana.getBtnTodoN().addActionListener(this);
		ventana.getBtnTodoF().addActionListener(this);
		ventana.getBtnActivoC().addActionListener(this);
	}
	
	public void listarCodigo(){
		ArrayList<Estadia> estadia=new ArrayList<Estadia>();
		if (ventana.getCdesde().getText().isEmpty() || ventana.getChasta().getText().isEmpty()) {
			Integer desde=0;
			Integer hasta=999999999;
			estadia=EstadiaDAO.informeEstadiaCodigo(desde, hasta);
			DefaultTableModel modelo=(DefaultTableModel) ventana.getTableHospedaje().getModel();
				Object[] fila=new Object[modelo.getColumnCount()];
				for (int i = 0; i <estadia.size(); i++) {					
					fila[0]=estadia.get(i).getCodigo();
					fila[1]=estadia.get(i).getFechaE();
					fila[2]=estadia.get(i).getCliente().getNombre();
					fila[3]=estadia.get(i).getHabitacion().getCodigo();
			    	fila[4]=estadia.get(i).getFechaS();
			    	fila[5]=estadia.get(i).getMonto();
			    	fila[6]=estadia.get(i).getDescuento();
			    	fila[7]=estadia.get(i).getObservacion();
			    	fila[8]=estadia.get(i).isEstado();
					modelo.addRow(fila);
				}
		} else{
		Integer desde=Integer.parseInt(ventana.getCdesde().getText());
		Integer hasta=Integer.parseInt(ventana.getChasta().getText());
		estadia=EstadiaDAO.informeEstadiaCodigo(desde, hasta);
		DefaultTableModel modelo=(DefaultTableModel) ventana.getTableHospedaje().getModel();
			Object[] fila=new Object[modelo.getColumnCount()];
			for (int i = 0; i <estadia.size(); i++) {					
				fila[0]=estadia.get(i).getCodigo();
				fila[1]=estadia.get(i).getFechaE();
				fila[2]=estadia.get(i).getCliente().getNombre();
				fila[3]=estadia.get(i).getHabitacion().getCodigo();
		    	fila[4]=estadia.get(i).getFechaS();
		    	fila[5]=estadia.get(i).getMonto();
		    	fila[6]=estadia.get(i).getDescuento();
		    	fila[7]=estadia.get(i).getObservacion();
		    	fila[8]=estadia.get(i).isEstado();
				modelo.addRow(fila);
			}
			
}}
	public void listarCodigoActivo(){
		ArrayList<Estadia> estadia=new ArrayList<Estadia>();
		if (ventana.getCdesde().getText().isEmpty() || ventana.getChasta().getText().isEmpty()) {
			Integer desde=0;
			Integer hasta=999999999;
			estadia=EstadiaDAO.informeEstadiaCodigoActivo(desde, hasta);
			DefaultTableModel modelo=(DefaultTableModel) ventana.getTableHospedaje().getModel();
				Object[] fila=new Object[modelo.getColumnCount()];
				for (int i = 0; i <estadia.size(); i++) {					
					fila[0]=estadia.get(i).getCodigo();
					fila[1]=estadia.get(i).getFechaE();
					fila[2]=estadia.get(i).getCliente().getNombre();
					fila[3]=estadia.get(i).getHabitacion().getCodigo();
			    	fila[4]=estadia.get(i).getFechaS();
			    	fila[5]=estadia.get(i).getMonto();
			    	fila[6]=estadia.get(i).getDescuento();
			    	fila[7]=estadia.get(i).getObservacion();
			    	fila[8]=estadia.get(i).isEstado();
					modelo.addRow(fila);
				}
		} else{
		Integer desde=Integer.parseInt(ventana.getCdesde().getText());
		Integer hasta=Integer.parseInt(ventana.getChasta().getText());
		estadia=EstadiaDAO.informeEstadiaCodigoActivo(desde, hasta);
		DefaultTableModel modelo=(DefaultTableModel) ventana.getTableHospedaje().getModel();
			Object[] fila=new Object[modelo.getColumnCount()];
			for (int i = 0; i <estadia.size(); i++) {					
				fila[0]=estadia.get(i).getCodigo();
				fila[1]=estadia.get(i).getFechaE();
				fila[2]=estadia.get(i).getCliente().getNombre();
				fila[3]=estadia.get(i).getHabitacion().getCodigo();
		    	fila[4]=estadia.get(i).getFechaS();
		    	fila[5]=estadia.get(i).getMonto();
		    	fila[6]=estadia.get(i).getDescuento();
		    	fila[7]=estadia.get(i).getObservacion();
		    	fila[8]=estadia.get(i).isEstado();
				modelo.addRow(fila);
			}
			
}}
	public void listarNombre(){
		ArrayList<Estadia> estadia=new ArrayList<Estadia>();
		String desde=(ventana.getNdesde().getText());
		String hasta=(ventana.getNhasta().getText());
		estadia=EstadiaDAO.informeEstadiaNombre(desde, hasta);
		DefaultTableModel modelo=(DefaultTableModel) ventana.getTableHospedaje().getModel();
			Object[] fila=new Object[modelo.getColumnCount()];
			for (int i = 0; i <estadia.size(); i++) {					
				fila[0]=estadia.get(i).getCodigo();
				fila[1]=estadia.get(i).getFechaE();
				fila[2]=estadia.get(i).getCliente().getNombre();
				fila[3]=estadia.get(i).getHabitacion().getCodigo();
		    	fila[4]=estadia.get(i).getFechaS();
		    	fila[5]=estadia.get(i).getMonto();
		    	fila[6]=estadia.get(i).getDescuento();
		    	fila[7]=estadia.get(i).getObservacion();
		    	fila[8]=estadia.get(i).isEstado();
				modelo.addRow(fila);
			}
			
}
	public void listarFecha(){
		ArrayList<Estadia> estadia=new ArrayList<Estadia>();
		Date desde=(ventana.getFdesde().getDate());
		Date hasta=ventana.getFhasta().getDate();
		estadia=EstadiaDAO.informeEstadiaFecha(desde, hasta);
		DefaultTableModel modelo=(DefaultTableModel) ventana.getTableHospedaje().getModel();
			Object[] fila=new Object[modelo.getColumnCount()];
			for (int i = 0; i <estadia.size(); i++) {					
				fila[0]=estadia.get(i).getCodigo();
				fila[1]=estadia.get(i).getFechaE();
				fila[2]=estadia.get(i).getCliente().getNombre();
				fila[3]=estadia.get(i).getHabitacion().getCodigo();
		    	fila[4]=estadia.get(i).getFechaS();
		    	fila[5]=estadia.get(i).getMonto();
		    	fila[6]=estadia.get(i).getDescuento();
		    	fila[7]=estadia.get(i).getObservacion();
		    	fila[8]=estadia.get(i).isEstado();
				modelo.addRow(fila);
			}
			
}
	public void listarTodo(){
		ArrayList<Estadia> estadia=new ArrayList<Estadia>();
		estadia=EstadiaDAO.listarEstadiasInf();
		DefaultTableModel modelo=(DefaultTableModel) ventana.getTableHospedaje().getModel();
			Object[] fila=new Object[modelo.getColumnCount()];
			for (int i = 0; i <estadia.size(); i++) {					
				fila[0]=estadia.get(i).getCodigo();
				fila[1]=estadia.get(i).getFechaE();
				fila[2]=estadia.get(i).getCliente().getNombre();
				fila[3]=estadia.get(i).getHabitacion().getCodigo();
		    	fila[4]=estadia.get(i).getFechaS();
		    	fila[5]=estadia.get(i).getMonto();
		    	fila[6]=estadia.get(i).getDescuento();
		    	fila[7]=estadia.get(i).getObservacion();
		    	fila[8]=estadia.get(i).isEstado();
				modelo.addRow(fila);
			}
			
}
	
	
	public void limpiarTabla() {
		DefaultTableModel modelo=(DefaultTableModel) ventana.getTableHospedaje().getModel();
		for (int i = 0; i < ventana.getTableHospedaje().getRowCount(); i++) {
			modelo.removeRow(i);
			i-=1;
		}
		
	}
	private void totalMonto(){
    	for (int i = 0; i < ventana.getTableHospedaje().getRowCount(); i++) {
			double numero=0;
			
			try {
				numero=Double.valueOf(ventana.getTableHospedaje().getValueAt(i, 5).toString());
			} catch (NumberFormatException e) {
				numero=0;
				ventana.getTableHospedaje().setValueAt(0, i, 5);
			}
			total1+=numero;
		}
    	ventana.getInfoMonto().setText(String.valueOf(formatea.format(total1)));
   
}
	private void totalDescuento(){
    	for (int i = 0; i < ventana.getTableHospedaje().getRowCount(); i++) {
			double numero=0;
			
			try {
				numero=Double.valueOf(ventana.getTableHospedaje().getValueAt(i, 6).toString());
			} catch (NumberFormatException e) {
				numero=0;
				ventana.getTableHospedaje().setValueAt(0, i, 6);
			}
			total+=numero;
		}
    	ventana.getInfoDescuento().setText(String.valueOf(formatea.format(total)));
   
}
	private void totalMontoTotal() {
		total2=total1-total;
		ventana.getInfoMontoTotal().setText(String.valueOf(formatea.format(total2)));

	}
	public void utilJTablePrint(JTable jTable, String header, String footer, boolean showPrintDialog){  
	    boolean fitWidth = true;        
	    boolean interactive = true;
	    // We define the print mode (Definimos el modo de impresión)
	    JTable.PrintMode mode = fitWidth ? JTable.PrintMode.FIT_WIDTH : JTable.PrintMode.NORMAL;
	    try {
	        // Print the table (Imprimo la <span id="IL_AD1" class="IL_AD">tabla</span>)             
	        boolean complete = jTable.print(mode,
	                new MessageFormat(header),
	                new MessageFormat(footer),
	                showPrintDialog,
	                null,
	                interactive);                 
	        if (complete) {
	            // Mostramos el mensaje de impresión existosa
	            JOptionPane.showMessageDialog(jTable,
	                    "Print complete (Impresión completa)",
	                    "Print result (Resultado de la impresión)",
	                    JOptionPane.INFORMATION_MESSAGE);
	        } else {
	            // Mostramos un mensaje indicando que la impresión fue cancelada                 
	            JOptionPane.showMessageDialog(jTable,
	                    "Print canceled (Impresión cancelada)",
	                    "Print result (Resultado de la impresión)",
	                    JOptionPane.WARNING_MESSAGE);
	        }
	    } catch (PrinterException pe) {
	        JOptionPane.showMessageDialog(jTable, 
	                "Print fail (Fallo de impresión): " + pe.getMessage(), 
	                "Print result (Resultado de la impresión)", 
	                JOptionPane.ERROR_MESSAGE);
	    }
		

}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(ventana.getBtnImprimir())) {
			utilJTablePrint(ventana.getTableHospedaje(),"Informe de Hospedaje","Monto: "+formatea.format(total1)+"  Descuento: "+formatea.format(total)+" Monto Total: "+formatea.format(total2)+"", true);
		}
		if (e.getSource().equals(ventana.getBtnSalir())) {
			this.ventana.dispose();
		}
		if (e.getSource().equals(ventana.getBtnProcesarC())) {
			limpiarTabla();
			listarCodigo();
			totalMonto();
			totalDescuento();
			totalMontoTotal();
		}
		if (e.getSource().equals(ventana.getBtnProcesarN())) {
			limpiarTabla();
			listarNombre();
			totalMonto();
			totalMontoTotal();
		}
		if (e.getSource().equals(ventana.getBtnProcesarF())) {
			limpiarTabla();
			listarFecha();
			totalMonto();
			totalDescuento();
			totalMontoTotal();
		}
		if (e.getSource().equals(ventana.getBtnTodoC())) {
			limpiarTabla();
			listarTodo();
		}
		if (e.getSource().equals(ventana.getBtnTodoF())) {
			limpiarTabla();
			listarTodo();
		}
		if (e.getSource().equals(ventana.getBtnTodoN())) {
			limpiarTabla();
			listarTodo();
		}
		if (e.getSource().equals(ventana.getBtnActivoC())) {
			limpiarTabla();
			listarCodigoActivo();
		}
	}
	

}
