package py.com.hoteleria.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import py.com.hoteleria.dao.DetalleDAO;
import py.com.hoteleria.form.FormDetalle;
import py.com.hoteleria.model.Detalle;

public class DetalleController implements ActionListener{
	private FormDetalle ventana;
	private Detalle detalle;
	private DetalleDAO dao;
	private boolean modificar;
	
	public DetalleController(FormDetalle v){
		this.ventana=v;
//		ventana.getBtnBuscarEstadia().addActionListener(this);
//		ventana.getBtnBuscarServicio().addActionListener(this);
		ventana.getBtnGuardar().addActionListener(this);
	}
	@SuppressWarnings("static-access")
	private void registrarDetalle() {
	if (ventana.getDtNroEstadia().getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Debes Ingresar el Codigo de la Estadia");
			ventana.getDtNroEstadia().requestFocus();
		}else if (ventana.getDtCodServicio().getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Debes Ingresar el Codigo del Servicio");
			ventana.getDtCodServicio().requestFocus();
		} else{
		 detalle=new Detalle();
	     detalle.getEstadia().setCodigo(Integer.parseInt(ventana.getDtNroEstadia().getText()));
		 detalle.getServicio().setCodigo(Integer.parseInt(ventana.getDtCodServicio().getText()));
		 detalle.setMonto(Double.parseDouble(ventana.getDtMonto().getText()));
		 dao=new DetalleDAO();
		
        if(modificar==false){
        	dao.guardar(detalle);
   
		}else{
			detalle.setCodigo(Integer.parseInt(ventana.getDtcodigo().getText()));
			dao.modificarDetalle(detalle);
		}
        
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		/*if (e.getSource().equals(ventana.getBtnBuscarEstadia())) {
			FormEstadia f=new FormEstadia();
			f.setVisible(true);
		}
		if (e.getSource().equals(ventana.getBtnBuscarServicio())) {
			FormServicio f=new FormServicio();
			f.setVisible(true);
		}*/
		if (e.getSource().equals(ventana.getBtnGuardar())) {
			registrarDetalle();
		}
		
		
	}

}