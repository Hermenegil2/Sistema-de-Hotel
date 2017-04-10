package py.com.hoteleria.controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import py.com.hoteleria.abm.FormHabitacion;
import py.com.hoteleria.dao.HabitacionDAO;
import py.com.hoteleria.model.Habitacion;


public class HabitacionController implements ActionListener,KeyListener,MouseListener{
	private HabitacionDAO dao;
	private FormHabitacion ventana;
	private Habitacion habita;
	private boolean modificar;
	DecimalFormat formatea = new DecimalFormat("###,###.##"+" Gs");
    
	
	public HabitacionController(FormHabitacion v){
		this.ventana=v;
		ventana.getBtnNuevo().addActionListener(this);
		ventana.getBtnGuardar().addActionListener(this);
		ventana.getBtnModificar().addActionListener(this);
		ventana.getTableHabitacion().addKeyListener(this);
		ventana.getBtnSalir().addActionListener(this);
		ventana.getBtnEliminar().addActionListener(this);
		ventana.getBtnBuscar().addActionListener(this);
		ventana.getHab_monto().addKeyListener(this);
		ventana.getBtnGuardar().addKeyListener(this);
	}
	private void obtenerUltimoId() {
		habita=HabitacionDAO.obtenerUltimoId();
		ventana.getHab_codigo().setText(Integer.toString(habita.getCodigo()));

	}
	private void habilitarCampo() {
		this.ventana.getHab_descripcion().setEditable(true);
		this.ventana.getHab_monto().setEditable(true);
		this.ventana.getHab_observacion().setEditable(true);

	}
	private void desabilitarCampo() {
		this.ventana.getHab_descripcion().setEditable(false);
		this.ventana.getHab_monto().setEditable(false);
		this.ventana.getHab_observacion().setEditable(false);

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
		if (habita !=null) {
			habita=new Habitacion();
			habita.setDescripcionHabitacion(ventana.getHab_descripcion().getText());
			habita.setMontoDia(Double.parseDouble(ventana.getHab_monto().getText()));
			habita.setObservacion(ventana.getHab_observacion().getText());
			dao=new HabitacionDAO();
	        if(modificar==false){
	        	dao.guardar(habita);
	        	limpiarTabla();
				listarDescrip();
				limpiarCampo();
			}else{
				habita.setCodigo(Integer.parseInt(ventana.getHab_codigo().getText()));
				dao.modificarHabitacion(habita);
				limpiarTabla();
				listarDescrip();
				limpiarCampo();
				
			}
			} else {
				JOptionPane.showMessageDialog(null, "La habitacion no fue carga");
			}
		}
		
	}

	@SuppressWarnings("static-access")
	public void eliminar(){
		habita=new Habitacion();
		habita.setCodigo(Integer.parseInt(ventana.getHab_codigo().getText()));
		dao.eliminar(habita);
		
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
		int row =ventana.getTableHabitacion().getSelectedRow();
		Integer id=Integer.parseInt(ventana.getTableHabitacion().getValueAt(row, 0).toString().trim());
		cargar(id);

	}
	
	
	public void limpiarTabla() {
		DefaultTableModel modelo=(DefaultTableModel) ventana.getTableHabitacion().getModel();
		for (int i = 0; i < ventana.getTableHabitacion().getRowCount(); i++) {
			modelo.removeRow(i);
			i-=1;
		}
		
	}
	private void salir() {
		this.ventana.dispose();
		
	}
	public void listarDescrip(){
		ArrayList<Habitacion>habitacion=new ArrayList<Habitacion>();
        String descripcion=ventana.getHab_buscar().getText();
		habitacion=HabitacionDAO.listarHabitacionDes(descripcion);
		DefaultTableModel modelo=(DefaultTableModel) ventana.getTableHabitacion().getModel();
		Object[] fila=new Object[modelo.getColumnCount()];
		for (int i = 0; i <habitacion.size(); i++) {					
			fila[0]=habitacion.get(i).getCodigo();
			fila[1]=habitacion.get(i).getDescripcionHabitacion();
			fila[2]=habitacion.get(i).getMontoDia();
			modelo.addRow(fila);
		}
	}
	
	public void ocultarBoton() {
		ventana.getBtnGuardar().setVisible(false);
		ventana.getBtnModificar().setVisible(false);
		ventana.getBtnEliminar().setVisible(false);

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(ventana.getBtnBuscar())) {
			limpiarTabla();
			listarDescrip();
		}

		if (e.getSource().equals(ventana.getBtnGuardar())) {
			registrarCliente();
			modificar=false;
			ventana.getBtnGuardar().setVisible(true);
		}
		if (e.getSource().equals(ventana.getBtnNuevo())) {
			habilitarCampo();
			limpiarCampo();
			obtenerUltimoId();
			ventana.getBtnGuardar().setVisible(true);
			ventana.getBtnModificar().setVisible(false);
			ventana.getBtnEliminar().setVisible(false);
		}
		if (e.getSource().equals(ventana.getBtnModificar())) {
			limpiarTabla();
			listarDescrip();
			modificar=true;
			habilitarCampo();
			ventana.getBtnGuardar().setVisible(true);
			ventana.getBtnEliminar().setVisible(false);
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
				limpiarCampo();
				listarDescrip();
				
				
				
			}
			
			

		}
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getSource().equals(ventana.getTableHabitacion())){
			if(e.getKeyCode()==KeyEvent.VK_ENTER){
				seleccionarFila();
			    desabilitarCampo();
			    ventana.getBtnGuardar().setVisible(false);
			    ventana.getBtnModificar().setVisible(true);
			    ventana.getBtnEliminar().setVisible(true);
			
			}
			
		
		}
		if (e.getSource().equals(ventana.getBtnGuardar())) {
			if(e.getKeyCode()==KeyEvent.VK_ENTER){
			registrarCliente();
			modificar=false;
			ventana.getBtnGuardar().setVisible(true);
		}
		}
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		if (e.getSource().equals(ventana.getHab_monto())) {
			char car=e.getKeyChar();
			if(  ventana.getHab_monto().getText().length()>=9)e.consume();
			if((car<'0' || car>'9') ) e.consume();
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		
		
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
