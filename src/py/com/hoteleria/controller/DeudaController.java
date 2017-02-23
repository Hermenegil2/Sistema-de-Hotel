package py.com.hoteleria.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import py.com.hoteleria.abm.FormCliente;
import py.com.hoteleria.form.FormDeuda;
import py.com.hoteleria.form.FormEstadia;

public class DeudaController implements ActionListener{
	private FormDeuda ventana; 
	
	public DeudaController(FormDeuda v){
		this.ventana=v;
		ventana.getBtnBuscarCliente().addActionListener(this);
		ventana.getBtnBuscarEstadia().addActionListener(this);
	}
	private void abrirCliente() {
		FormCliente form=new FormCliente();
		form.setVisible(true);

	}
	private void abrirEstadia() {
		FormEstadia form=new FormEstadia();
		form.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(ventana.getBtnBuscarCliente())) {
			abrirCliente();
		}
		if (e.getSource().equals(ventana.getBtnBuscarEstadia())) {
			abrirEstadia();
		}
	}

}
