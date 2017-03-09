package py.com.hoteleria.controller;


import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import py.com.hoteleria.dao.ConfigDAO;
import py.com.hoteleria.menu.MenuPrincipal;
import py.com.hoteleria.model.Config;

public class ConfigController implements WindowListener {
	private MenuPrincipal ventana;
	@SuppressWarnings("unused")
	private ConfigDAO dao;
	private Config config;
	
	public ConfigController(MenuPrincipal v){
		this.ventana=v;
	}
	
	
	public void cargar() {
		config=ConfigDAO.retornar(config);
		ventana.getNombre().setText(config.getNombre());
		ventana.getTelefono().setText(config.getTelefono());


	}

	@Override
	public void windowActivated(WindowEvent arg0) {
		
		
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
