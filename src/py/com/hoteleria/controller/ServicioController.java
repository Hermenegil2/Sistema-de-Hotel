package py.com.hoteleria.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DecimalFormat;
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
	DecimalFormat formatea = new DecimalFormat("###,###.##"+" Gs");

	
	public ServicioController(FormServicio v){
		this.ventana=v;
		ventana.getBtnNuevo().addActionListener(this);
		ventana.getBtnGuardar().addActionListener(this);
		ventana.getBtnModificar().addActionListener(this);
		ventana.getTableServicio().addKeyListener(this);
		ventana.getBtnSalir().addActionListener(this);
		ventana.getBtnEliminar().addActionListener(this);
		ventana.getSer_buscar().addActionListener(this);
		ventana.getBtnBuscar().addActionListener(this);
		ventana.getSer_monto().addKeyListener(this);
		ventana.getBtnGuardar().addKeyListener(this);
	}
	private void habilitarCampo() {
		this.ventana.getSer_descri().setEditable(true);
		this.ventana.getSer_monto().setEditable(true);
		this.ventana.getSer_observacion().setEditable(true);

	}
	private void desabilitarCampo() {
		this.ventana.getSer_descri().setEditable(false);
		this.ventana.getSer_monto().setEditable(false);
		this.ventana.getSer_observacion().setEditable(false);

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
			if (servicio !=null ) {
				servicio=new Servicio();
				servicio.setDescripcionServicio(ventana.getSer_descri().getText());
				servicio.setMonto(Double.parseDouble(ventana.getSer_monto().getText()));
				servicio.setObservacion(ventana.getSer_observacion().getText());
				dao=new ServicioDAO();
		        if(modificar==false){
		        	dao.guardar(servicio);
		        	limpiarTabla();
					listarServicios();
					limpiarCampo();
				}else{
					servicio.setCodigo(Integer.parseInt(ventana.getSer_codigo().getText()));
					dao.modificarServicio(servicio);
				}
				} else {
					JOptionPane.showMessageDialog(null, "El Servicio no fue guardada");
				}
			}
		
	}

	@SuppressWarnings("static-access")
	public void eliminar(){
		servicio=new Servicio();
		servicio.setCodigo(Integer.parseInt(ventana.getSer_codigo().getText()));
		dao.eliminarServicio(servicio);
		
	}
	public  void listarServicios(){
		DefaultTableModel modelo=(DefaultTableModel) ventana.getTableServicio().getModel();
		ArrayList<Servicio>lista=ServicioDAO.listarServicio();
		Object[] fila=new Object[modelo.getColumnCount()];
	    for (int i = 0; i < lista.size(); i++) {
	    	fila[0]=lista.get(i).getCodigo();
	    	fila[1]=lista.get(i).getDescripcionServicio();
	    	fila[2]=formatea.format(lista.get(i).getMonto());
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
	public void ocultarBoton() {
		ventana.getBtnGuardar().setVisible(false);
		ventana.getBtnModificar().setVisible(false);
		ventana.getBtnEliminar().setVisible(false);

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
			fila[2]=formatea.format(servicio.get(i).getMonto());
			modelo.addRow(fila);
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(ventana.getBtnBuscar())) {
			limpiarTabla();
			listarDescripcion();
			
		}
		if (e.getSource().equals(ventana.getBtnGuardar())) {
			registrarCliente();
			modificar=false;
		}
		if (e.getSource().equals(ventana.getBtnNuevo())) {
			habilitarCampo();
			ventana.getBtnGuardar().setVisible(true);
			ventana.getBtnModificar().setVisible(false);
			this.ventana.getBtnEliminar().setVisible(false);
			limpiarCampo();
			obtenerUltimoId();
		}
		if (e.getSource().equals(ventana.getBtnModificar())) {
			limpiarTabla();
			listarServicios();
			this.ventana.getBtnGuardar().setVisible(true);
			this.ventana.getBtnEliminar().setVisible(false);
			this.ventana.getBtnModificar().setVisible(false);
			modificar=true;
			habilitarCampo();
			
		}
		if (e.getSource().equals(ventana.getBtnSalir())) {
			if (JOptionPane.showConfirmDialog(new JDialog(),
					"¿Seguro que Quieres Salir","Salir",
					JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
				salir();
				
				
				
			}
		}
	
		if (e.getSource().equals(ventana.getBtnEliminar())) {
			if (JOptionPane.showConfirmDialog(new JDialog(),
					"¿Seguro que Quieres Eliminar","Salir",
					JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
				eliminar();
				limpiarTabla();
				listarServicios();
				limpiarCampo();
				ventana.getBtnEliminar().setVisible(false);
				ventana.getBtnModificar().setVisible(true);
				
				
			}
			
		}

		}
		

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getSource().equals(ventana.getTableServicio())){
			if(e.getKeyCode()==KeyEvent.VK_ENTER){
				seleccionarFila();
				this.ventana.getBtnGuardar().setVisible(false);
				this.ventana.getBtnModificar().setVisible(true);
				this.ventana.getBtnEliminar().setVisible(true);
			    desabilitarCampo();
			
			}
			
		
		}
		if (e.getSource().equals(ventana.getBtnGuardar())) {
			if(e.getKeyCode()==KeyEvent.VK_ENTER){
			registrarCliente();
			modificar=false;
		}
		}
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		if (e.getSource().equals(ventana.getSer_monto())) {
			char car=e.getKeyChar();
			if(  ventana.getSer_monto().getText().length()>=9)e.consume();
			if((car<'0' || car>'9') ) e.consume();
		}
	}
}