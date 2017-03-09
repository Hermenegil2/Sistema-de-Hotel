package py.com.hoteleria.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import py.com.hoteleria.abm.FormCliente;
import py.com.hoteleria.dao.DeudaDAO;
import py.com.hoteleria.form.FormDeuda;
import py.com.hoteleria.form.FormEstadia;
import py.com.hoteleria.model.Deuda;

public class DeudaController implements ActionListener{
	private FormDeuda ventana;
	private Deuda deuda;
	private DeudaDAO dao;
	private boolean modificar;
	
	public DeudaController(FormDeuda v){
		this.ventana=v;
		ventana.getBtnBuscarCliente().addActionListener(this);
		ventana.getBtnBuscarEstadia().addActionListener(this);
		ventana.getBtnGuardar().addActionListener(this);
	}
	
	@SuppressWarnings("static-access")
	private void registrarDeuda() {
		if (ventana.getDcodEstadia().getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Debes Ingresar el Codigo de la Estadia");
			ventana.getDcodEstadia().requestFocus();
		}else if (ventana.getDeudaCodCliente().getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Debes Ingresar el Codigo del cliente");
			ventana.getDeudaCodCliente().requestFocus();
		} else{
	
		 deuda=new Deuda();
		 deuda.getEstadia().setCodigo(Integer.parseInt(ventana.getDcodEstadia().getText()));
		 deuda.getCliente().setCodigo(Integer.parseInt(ventana.getDeudaCodCliente().getText()));
		 deuda.setMontoDeuda(Double.parseDouble(ventana.getDmontoDeuda().getText()));
		 deuda.setMontoPagado(Double.parseDouble(ventana.getDmontoPagado().getText()));
		 dao=new DeudaDAO();
		
        if(modificar==false){
        	dao.guardar(deuda);
   
		}else{
			deuda.setCodigo(Integer.parseInt(ventana.getDcodigo().getText()));
			dao.modificarDeuda(deuda);
		}
        
		}
	}
	
	public void listarDeuda(){
		DefaultTableModel modelo=(DefaultTableModel) ventana.getTableDeuda().getModel();
		ArrayList<Deuda>lista=DeudaDAO.listarDeuda();
		Object[] fila=new Object[modelo.getColumnCount()];
	    for (int i = 0; i < lista.size(); i++) {
	    	fila[0]=lista.get(i).getCodigo();
	    	fila[1]=lista.get(i).getEstadia().getMonto();
	    	fila[2]=lista.get(i).getCliente().getNombre();
	    	fila[3]=lista.get(i).getMontoDeuda();
	    	fila[4]=lista.get(i).getMontoPagado();
	    	modelo.addRow(fila);
	    }
		}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(ventana.getBtnBuscarCliente())) {
			FormCliente f=new FormCliente();
			f.setVisible(true);
		}
		if (e.getSource().equals(ventana.getBtnBuscarEstadia())) {
			FormEstadia f=new FormEstadia();
			f.setVisible(true);
		}
		if (e.getSource().equals(ventana.getBtnGuardar())) {
			registrarDeuda();
		}
	}

}
