package py.com.hoteleria.controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import py.com.hoteleria.abm.FormHabitacion;
import py.com.hoteleria.dao.HabitacionDAO;
import py.com.hoteleria.model.Habitacion;


public class HabitacionController implements ActionListener,KeyListener{
	private HabitacionDAO dao;
	private FormHabitacion ventana;
	private Habitacion habita;
	private boolean modificar;

	
	public HabitacionController(FormHabitacion v){
		this.ventana=v;
		ventana.getBtnNuevo().addActionListener(this);
		ventana.getBtnGuardar().addActionListener(this);
		ventana.getBtnModificar().addActionListener(this);
		ventana.getTable_habitacion().addKeyListener(this);
		ventana.getBtnSalir().addActionListener(this);
		ventana.getBtnEliminar().addActionListener(this);
		ventana.getBtnCancelar().addActionListener(this);
		ventana.getHabi_buscar().addActionListener(this);
	}
	private void obtenerUltimoId() {
		habita=HabitacionDAO.obtenerUltimoId();
		ventana.getHab_codigo().setText(Integer.toString(habita.getCodigo()));

	}
	private void habilitarCampo() {
		this.ventana.getHab_descripcion().setEnabled(true);
		this.ventana.getHab_monto().setEnabled(true);
		this.ventana.getHab_observacion().setEnabled(true);

	}
	private void desabilitarCampo() {
		this.ventana.getHab_descripcion().setEnabled(false);
		this.ventana.getHab_monto().setEnabled(false);
		this.ventana.getHab_observacion().setEnabled(false);

	}
	private void limpiarCampo() {
		ventana.getHab_codigo().setText("");
		ventana.getHab_descripcion().setText("");
		ventana.getHab_monto().setText("");
		ventana.getHab_observacion().setText("");

	}
	@SuppressWarnings("static-access")
	private void registrarCliente() {
		if (ventana.getHab_descripcion().getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Debes Completar la Descripcion");
			ventana.getHab_descripcion().requestFocus();
		}else if (ventana.getHab_monto().getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Debe Ingresar el Monto");
			ventana.getHab_monto().requestFocus();
		} else{
		habita=new Habitacion();
		habita.setDescripcionHabitacion(ventana.getHab_descripcion().getText());
		habita.setMontoDia(Double.parseDouble(ventana.getHab_monto().getText()));
		habita.setObservacion(ventana.getHab_observacion().getText());
		dao=new HabitacionDAO();
        if(modificar==false){
        	dao.guardar(habita);
        	this.ventana.getBtnGuardar().setEnabled(false);
		}else{
			habita.setCodigo(Integer.parseInt(ventana.getHab_codigo().getText()));
			dao.modificarHabitacion(habita);
			this.ventana.getBtnGuardar().setEnabled(false);
		}
		}
	}

	@SuppressWarnings("static-access")
	public void eliminar(){
		habita=new Habitacion();
		habita.setCodigo(Integer.parseInt(ventana.getHab_codigo().getText()));
		dao.eliminar(habita);
		
	}
	public  void listarHabitacion(){
		DefaultTableModel modelo=(DefaultTableModel) ventana.getTable_habitacion().getModel();
		ArrayList<Habitacion>lista=HabitacionDAO.listarHabitacion();
		Object[] fila=new Object[modelo.getColumnCount()];
	    for (int i = 0; i < lista.size(); i++) {
	    	fila[0]=lista.get(i).getCodigo();
	    	fila[1]=lista.get(i).getDescripcionHabitacion();
	    	fila[2]=lista.get(i).getMontoDia();
	    	modelo.addRow(fila);
	    }
		}
	@SuppressWarnings("static-access")
	public void cargar(int id){
		dao=new HabitacionDAO();
		habita=dao.habitacionId(id);
		ventana.getHab_codigo().setText(Integer.toString(habita.getCodigo()));
		ventana.getHab_descripcion().setText(habita.getDescripcionHabitacion());
		ventana.getHab_monto().setText(Double.toString(habita.getMontoDia()));
		ventana.getHab_observacion().setText(habita.getObservacion());
		}
	private void seleccionarFila() {
		int row =ventana.getTable_habitacion().getSelectedRow();
		Integer id=Integer.parseInt(ventana.getTable_habitacion().getValueAt(row, 0).toString().trim());
		cargar(id);

	}
	
	
	public void limpiarTabla() {
		DefaultTableModel modelo=(DefaultTableModel) ventana.getTable_habitacion().getModel();
		for (int i = 0; i < ventana.getTable_habitacion().getRowCount(); i++) {
			modelo.removeRow(i);
			i-=1;
		}
		
	}
	private void salir() {
		this.ventana.dispose();
		
	}
	private void listarDescrip(){
		ArrayList<Habitacion>habitacion=new ArrayList<Habitacion>();
        String descripcion=ventana.getHabi_buscar().getText();
		habitacion=HabitacionDAO.listarHabitacionDes(descripcion);
		DefaultTableModel modelo=(DefaultTableModel) ventana.getTable_habitacion().getModel();
		Object[] fila=new Object[modelo.getColumnCount()];
		for (int i = 0; i <habitacion.size(); i++) {					
			fila[0]=habitacion.get(i).getCodigo();
			fila[1]=habitacion.get(i).getDescripcionHabitacion();
			fila[2]=habitacion.get(i).getMontoDia();
			modelo.addRow(fila);
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(ventana.getHabi_buscar())) {
			limpiarTabla();
			listarDescrip();
		}

		if (e.getSource().equals(ventana.getBtnGuardar())) {
			registrarCliente();
			limpiarTabla();
			listarHabitacion();
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
			listarHabitacion();
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
				listarHabitacion();
				ventana.getBtnEliminar().setEnabled(false);
				ventana.getBtnModificar().setEnabled(true);
				
				
			}
			if (e.getSource().equals(ventana.getBtnCancelar())) {
				desabilitarCampo();
				limpiarCampo();
		
			}
			

		}
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getSource().equals(ventana.getTable_habitacion())){
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
