package py.com.hoteleria.informeControlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.print.PrinterException;
import java.text.MessageFormat;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTable.PrintMode;
import javax.swing.table.DefaultTableModel;

import py.com.hoteleria.dao.ClienteDAO;
import py.com.hoteleria.informe.ListadoClientes;
import py.com.hoteleria.model.Cliente;

public class ListadoClienteControlador implements ActionListener,KeyListener{
	private ListadoClientes ventana;
	private MessageFormat headerFormat;
	private MessageFormat footerFormat;
	
	public ListadoClienteControlador(ListadoClientes v){
		this.ventana=v;
		ventana.getBtnImprimir().addActionListener(this);
		ventana.getBtnProcesarC().addActionListener(this);
		ventana.getBtnProcesarN().addActionListener(this);
		ventana.getBtnSalir().addActionListener(this);
		ventana.getCdesde().addKeyListener(this);
		ventana.getChasta().addKeyListener(this);
		ventana.getNdesde().addKeyListener(this);
		ventana.getNhasta().addKeyListener(this);
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
	
	
	public void listarClientes(){
		DefaultTableModel modelo=(DefaultTableModel) ventana.getTableCliente().getModel();
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

	public void listarCodigo(){
		ArrayList<Cliente> cliente=new ArrayList<Cliente>();
		Integer desde=Integer.parseInt(ventana.getCdesde().getText());
		Integer hasta=Integer.parseInt(ventana.getChasta().getText());
		cliente=ClienteDAO.informeClienteCodigo(desde, hasta);
		DefaultTableModel modelo=(DefaultTableModel) ventana.getTableCliente().getModel();
			Object[] fila=new Object[modelo.getColumnCount()];
			for (int i = 0; i <cliente.size(); i++) {					
				fila[0]=cliente.get(i).getCodigo();
				fila[1]=cliente.get(i).getNombre();
				fila[2]=cliente.get(i).getCedula();
				fila[3]=cliente.get(i).getRuc();
		    	fila[4]=cliente.get(i).getDireccion();
		    	fila[5]=cliente.get(i).getTelefono();
				modelo.addRow(fila);
			}
			
}
	private void listarNombre(){
		ArrayList<Cliente> cliente=new ArrayList<Cliente>();
		String desde=ventana.getNdesde().getText();
		String hasta=ventana.getNhasta().getText();
		cliente=ClienteDAO.informeClienteNombre(desde, hasta);
		DefaultTableModel modelo=(DefaultTableModel) ventana.getTableCliente().getModel();
			Object[] fila=new Object[modelo.getColumnCount()];
			for (int i = 0; i <cliente.size(); i++) {					
				fila[0]=cliente.get(i).getCodigo();
				fila[1]=cliente.get(i).getNombre();
				fila[2]=cliente.get(i).getCedula();
				fila[3]=cliente.get(i).getRuc();
		    	fila[4]=cliente.get(i).getDireccion();
		    	fila[5]=cliente.get(i).getTelefono();
				modelo.addRow(fila);
			}
			
}
	public void limpiarTabla() {
		DefaultTableModel modelo=(DefaultTableModel) ventana.getTableCliente().getModel();
		for (int i = 0; i < ventana.getTableCliente().getRowCount(); i++) {
			modelo.removeRow(i);
			i-=1;
		}
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(ventana.getBtnImprimir())) {
		 utilJTablePrint(ventana.getTableCliente(),"Listado de Clientes","Hotel Can",true);
		}
		if (e.getSource().equals(ventana.getBtnProcesarC())) {
			limpiarTabla();
			listarCodigo();
		}
		if (e.getSource().equals(ventana.getBtnProcesarN())) {
			limpiarTabla();
			listarNombre();
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

	

