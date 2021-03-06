package py.com.hoteleria.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import py.com.hoteleria.abm.FormCliente;
import py.com.hoteleria.abm.FormConfig;
import py.com.hoteleria.abm.FormHabitacion;
import py.com.hoteleria.abm.FormServicio;
import py.com.hoteleria.form.FormCobranza;
import py.com.hoteleria.form.FormEstadia;
import py.com.hoteleria.informe.ListadoClientes;
import py.com.hoteleria.menu.MenuPrincipal;

public class FormController implements ActionListener {
	private MenuPrincipal ventana;
	
	public FormController (MenuPrincipal v){
		this.ventana=v;
		ventana.getItemCliente().addActionListener(this);
		ventana.getItemServicio().addActionListener(this);
		ventana.getItemHabitacion().addActionListener(this);
		ventana.getBtnConbranza().addActionListener(this);
		ventana.getBtnSalir().addActionListener(this);
		ventana.getBtnHospedaje().addActionListener(this);
		ventana.getItemConfiguraciones().addActionListener(this);
		ventana.getBtnClientes().addActionListener(this);
		ventana.getItemListadoDeClientes().addActionListener(this);
		ventana.getItemHospedaje().addActionListener(this);
		ventana.getItemCobranza().addActionListener(this);
	}
	
	private void cliente() {
		FormCliente form=new FormCliente();
		form.setLocationRelativeTo(null);
		form.setVisible(true);

	}
	private void cobranza() {
		FormCobranza form=new FormCobranza();
		form.setLocationRelativeTo(null);
		form.setVisible(true);

	}
	private void salir() {
		System.exit(0);

	}
	private void hospedaje() {
		FormEstadia form=new FormEstadia();
		form.setLocationRelativeTo(null);
		form.setVisible(true);

	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(ventana.getItemCliente())) {
			cliente();
		}
	
		if (e.getSource().equals(ventana.getBtnSalir())) {
			if (JOptionPane.showConfirmDialog(new JDialog(),
					"�Seguro que Quieres Salir","Salir",
					JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
				salir();
				
			}

			
		}
		if (e.getSource().equals(ventana.getBtnConbranza())) {
			cobranza();
		}
		if (e.getSource().equals(ventana.getBtnHospedaje())) {
			hospedaje();
		}
		if (e.getSource().equals(ventana.getItemServicio())) {
			FormServicio form=new FormServicio();
			form.setLocationRelativeTo(null);
			form.setVisible(true);
		}
		if (e.getSource().equals(ventana.getItemHabitacion())) {
			FormHabitacion form=new FormHabitacion();
			form.setLocationRelativeTo(null);
			form.setVisible(true);
			
		}
		if (e.getSource().equals(ventana.getItemConfiguraciones())) {
			FormConfig f=new FormConfig();
			f.setLocationRelativeTo(null);
			f.setVisible(true);
		}
		if (e.getSource().equals(ventana.getBtnClientes())) {
			cliente();
		}
		if (e.getSource().equals(ventana.getItemListadoDeClientes())) {
			ListadoClientes l=new ListadoClientes();
			l.setLocationRelativeTo(null);
			l.setVisible(true);
		}
		if (e.getSource().equals(ventana.getItemCobranza())) {
			FormCobranza form=new FormCobranza();
			form.setLocationRelativeTo(null);
			form.setVisible(true);
		}
		if (e.getSource().equals(ventana.getItemHospedaje())) {
			FormEstadia form=new FormEstadia();
			form.setLocationRelativeTo(null);
			form.setVisible(true);
		}
	}

}
