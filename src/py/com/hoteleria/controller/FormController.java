package py.com.hoteleria.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import py.com.hoteleria.abm.FormCliente;
import py.com.hoteleria.abm.FormHabitacion;
import py.com.hoteleria.abm.FormServicio;
import py.com.hoteleria.form.FormCobranza;
import py.com.hoteleria.form.FormEstadia;
import py.com.hoteleria.menu.MenuPrincipal;

public class FormController implements ActionListener {
	private MenuPrincipal ventana;
	
	public FormController (MenuPrincipal v){
		this.ventana=v;
		ventana.getItemCliente().addActionListener(this);
		ventana.getItemServicio().addActionListener(this);
		ventana.getItemHabitacion().addActionListener(this);
		ventana.getBtnCliente().addActionListener(this);
		ventana.getBtnConbranza().addActionListener(this);
		ventana.getBtnSalir().addActionListener(this);
		ventana.getBtnHospedaje().addActionListener(this);
	}
	
	private void cliente() {
		FormCliente form=new FormCliente();
		form.setVisible(true);

	}
	private void cobranza() {
		FormCobranza form=new FormCobranza();
		form.setVisible(true);

	}
	private void salir() {
		System.exit(0);

	}
	private void hospedaje() {
		FormEstadia form=new FormEstadia();
		form.setVisible(true);

	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(ventana.getItemCliente())) {
			cliente();
		}
	
		if (e.getSource().equals(ventana.getBtnCliente())) {
			cliente();
		}
		if (e.getSource().equals(ventana.getBtnSalir())) {
			salir();
			
		}
		if (e.getSource().equals(ventana.getBtnConbranza())) {
			cobranza();
		}
		if (e.getSource().equals(ventana.getBtnHospedaje())) {
			hospedaje();
		}
		if (e.getSource().equals(ventana.getItemServicio())) {
			FormServicio form=new FormServicio();
			form.setVisible(true);
		}
		if (e.getSource().equals(ventana.getItemHabitacion())) {
			FormHabitacion form=new FormHabitacion();
			form.setVisible(true);
			
		}
		
	}

}
