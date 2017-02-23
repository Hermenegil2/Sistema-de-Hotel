package py.com.hoteleria.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import py.com.hoteleria.abm.FormServicio;
import py.com.hoteleria.dao.ServicioDAO;
import py.com.hoteleria.model.Servicio;

public class ServicioController implements ActionListener,KeyListener{
	private ServicioDAO dao;
	private FormServicio ventana;
	private Servicio servicio;
	private boolean modificar;

	
	public ServicioController(FormServicio v){
		this.ventana=v;
		ventana.getBtnNuevo().addActionListener(this);
		ventana.getBtnGuardar().addActionListener(this);
		ventana.getBtnModificar().addActionListener(this);
		ventana.getTableServicio().addKeyListener(this);
		ventana.getBtnSalir().addActionListener(this);
		ventana.getBtnEliminar().addActionListener(this);
		ventana.getBtnCancelar().addActionListener(this);
		ventana.getSer_buscar().addActionListener(this);
	}
	private void habilitarCampo() {
		this.ventana.getSer_descri().setEnabled(true);
		this.ventana.getSer_monto().setEnabled(true);
		this.ventana.getSer_observacion().setEnabled(true);

	}
	private void desabilitarCampo() {
		this.ventana.getSer_descri().setEnabled(false);
		this.ventana.getSer_monto().setEnabled(false);
		this.ventana.getSer_observacion().setEnabled(false);

	}
	private void limpiarCampo() {
		ventana.getSer_codigo().setText("");
		ventana.getSer_descri().setText("");
		ventana.getSer_monto().setText("");
		ventana.getSer_observacion().setText("");

	}
	private void obtenerUltimoId() {
		servicio=ServicioDAO.obtenerUltimoId();
		ventana.getSer_codigo().setText(Integer.toString(servicio.getCodigo()));

	}
	@SuppressWarnings("static-access")
	private void registrarCliente() {
		if (ventana.getSer_descri().getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Debes Completar la Descripcion");
			ventana.getSer_descri().requestFocus();
		}else if (ventana.getSer_monto().getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Debe Ingresar el Monto");
			ventana.getSer_monto().requestFocus();
		} else{
		servicio=new Servicio();
		servicio.setDescripcionServicio(ventana.getSer_descri().getText());
		servicio.setMonto(Double.parseDouble(ventana.getSer_monto().getText()));
		servicio.setObservacion(ventana.getSer_observacion().getText());
		dao=new ServicioDAO();
        if(modificar==false){
        	dao.guardar(servicio);
        	this.ventana.getBtnGuardar().setEnabled(false);
		}else{
			servicio.setCodigo(Integer.parseInt(ventana.getSer_codigo().getText()));
			dao.modificarServicio(servicio);
			this.ventana.getBtnGuardar().setEnabled(false);
		}
		}
	}

	@SuppressWarnings("static-access")
	public void eliminar(){
		servicio=new Servicio();
		servicio.setCodigo(Integer.parseInt(ventana.getSer_codigo().getText()));
		dao.eliminar(servicio);
		
	}
	public  void listarServicios(){
		DefaultTableModel modelo=(DefaultTableModel) ventana.getTableServicio().getModel();
		ArrayList<Servicio>lista=ServicioDAO.listarServicio();
		Object[] fila=new Object[modelo.getColumnCount()];
	    for (int i = 0; i < lista.size(); i++) {
	    	fila[0]=lista.get(i).getCodigo();
	    	fila[1]=lista.get(i).getDescripcionServicio();
	    	fila[2]=lista.get(i).getMonto();
	    	modelo.addRow(fila);
	    }
		}
	@SuppressWarnings("static-access")
	public void cargar(int id){
		dao=new ServicioDAO();
		servicio=dao.servicioId(id);
			ventana.getSer_codigo().setText(Integer.toString(servicio.getCodigo()));
			ventana.getSer_descri().setText(servicio.getDescripcionServicio());
			ventana.getSer_monto().setText(Double.toString(servicio.getMonto()));
			ventana.getSer_observacion().setText(servicio.getObservacion());
		}
	private void seleccionarFila() {
		int row =ventana.getTableServicio().getSelectedRow();
		Integer id=Integer.parseInt(ventana.getTableServicio().getValueAt(row, 0).toString().trim());
		cargar(id);

	}
	
	
	public void limpiarTabla() {
		DefaultTableModel modelo=(DefaultTableModel) ventana.getTableServicio().getModel();
		for (int i = 0; i < ventana.getTableServicio().getRowCount(); i++) {
			modelo.removeRow(i);
			i-=1;
		}
		
	}
	private void salir() {
		this.ventana.dispose();
		
	}
	private void listarDescripcion(){
		ArrayList<Servicio> servicio=new ArrayList<Servicio>();
		String descripcion=ventana.getSer_buscar().getText();
		servicio=ServicioDAO.listarServicioDes(descripcion);
		DefaultTableModel modelo=(DefaultTableModel) ventana.getTableServicio().getModel();
		Object[] fila=new Object[modelo.getColumnCount()];
		for (int i = 0; i <servicio.size(); i++) {					
			fila[0]=servicio.get(i).getCodigo();
			fila[1]=servicio.get(i).getDescripcionServicio();
			fila[2]=servicio.get(i).getMonto();
			modelo.addRow(fila);
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(ventana.getSer_buscar())) {
			limpiarTabla();
			listarDescripcion();
			
		}
		if (e.getSource().equals(ventana.getBtnGuardar())) {
			registrarCliente();
			limpiarTabla();
			listarServicios();
			limpiarCampo();
		}
		if (e.getSource().equals(ventana.getBtnNuevo())) {
			habilitarCampo();
			ventana.getBtnGuardar().setEnabled(true);
			ventana.getBtnModificar().setEnabled(false);
			this.ventana.getBtnEliminar().setEnabled(false);
			limpiarCampo();
			obtenerUltimoId();
		}
		if (e.getSource().equals(ventana.getBtnModificar())) {
			limpiarTabla();
			listarServicios();
			this.ventana.getBtnGuardar().setEnabled(true);
			this.ventana.getBtnEliminar().setEnabled(false);
			this.ventana.getBtnModificar().setEnabled(false);
			modificar=true;
			habilitarCampo();
		}
		if (e.getSource().equals(ventana.getBtnSalir())) {
			salir();
			
		}
	
		if (e.getSource().equals(ventana.getBtnEliminar())) {
			if (JOptionPane.showConfirmDialog(new JDialog(),
					"¿Seguro que Quieres Eliminar","Salir",
					JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
				eliminar();
				limpiarTabla();
				listarServicios();
				ventana.getBtnEliminar().setEnabled(false);
				ventana.getBtnModificar().setEnabled(true);
				
				
			}
			
		}
			if (e.getSource().equals(ventana.getBtnCancelar())) {
				desabilitarCampo();
				limpiarCampo();
			}

		}
		

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getSource().equals(ventana.getTableServicio())){
			if(e.getKeyCode()==KeyEvent.VK_ENTER){
				seleccionarFila();
				this.ventana.getBtnGuardar().setEnabled(false);
				this.ventana.getBtnModificar().setEnabled(true);
				this.ventana.getBtnEliminar().setEnabled(true);
			    desabilitarCampo();
			
			}
			
		
		}
		
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
	}
}