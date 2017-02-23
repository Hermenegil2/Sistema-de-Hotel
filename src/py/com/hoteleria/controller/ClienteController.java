package py.com.hoteleria.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import py.com.hoteleria.abm.FormCliente;
import py.com.hoteleria.dao.ClienteDAO;
import py.com.hoteleria.model.Cliente;

public class ClienteController implements ActionListener,KeyListener{
	private ClienteDAO dao;
	private FormCliente ventana;
	private Cliente cliente;
	private boolean modificar;

	
	public ClienteController(FormCliente v){
		this.ventana=v;
		ventana.getBtnNuevo().addActionListener(this);
		ventana.getBtnGuardar().addActionListener(this);
		ventana.getBtnModificar().addActionListener(this);
		ventana.getTableCliente().addKeyListener(this);
		ventana.getBtnSalir().addActionListener(this);
		ventana.getCli_cedula().addKeyListener(this);
		ventana.getCli_nombre().addKeyListener(this);
		ventana.getClie_buscar().addActionListener(this);
		ventana.getBtnCanselar().addActionListener(this);
		ventana.getBtnEliminar().addActionListener(this);
	}
	@SuppressWarnings("static-access")
	private void registrarCliente() {
		if (ventana.getCli_nombre().getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Debes Completar el Nombre");
			ventana.getCli_nombre().requestFocus();
		}else if (ventana.getCli_cedula().getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Debe Ingresar el Numero de Cedula");
			ventana.getCli_cedula().requestFocus();
		} else{
		cliente=new Cliente();
		cliente.setCodigo(Integer.parseInt(ventana.getCli_codigo().getText()));
		cliente.setNombre(ventana.getCli_nombre().getText());
		cliente.setCedula(Integer.parseInt(ventana.getCli_cedula().getText()));
		cliente.setRuc(ventana.getCli_ruc().getText());
		cliente.setDireccion(ventana.getCli_direccion().getText());
		cliente.setTelefono(Integer.parseInt(ventana.getCli_telefono().getText()));
		dao=new ClienteDAO();
        if(modificar==false){
        	dao.guardar(cliente);
        	this.ventana.getBtnGuardar().setEnabled(false);
		}else{
			cliente.setCodigo(Integer.parseInt(ventana.getCli_codigo().getText()));
			dao.modificarCliente(cliente);
			this.ventana.getBtnGuardar().setEnabled(false);
		}
        
		}
	}

	@SuppressWarnings("static-access")
	public void eliminar(){
		cliente=new Cliente();
		cliente.setCodigo(Integer.parseInt(ventana.getCli_codigo().getText()));
		dao.eliminar(cliente);
		
	}
	public void listarClientes(){
		DefaultTableModel modelo=(DefaultTableModel) ventana.getTableCliente().getModel();
		ArrayList<Cliente>lista=ClienteDAO.listarCliente();
		Object[] fila=new Object[modelo.getColumnCount()];
	    for (int i = 0; i < lista.size(); i++) {
	    	fila[0]=lista.get(i).getCodigo();
	    	fila[1]=lista.get(i).getNombre();
	    	fila[2]=lista.get(i).getCedula();
	    	modelo.addRow(fila);
	    }
		}
	@SuppressWarnings("static-access")
	public void cargar(int id){
		dao=new ClienteDAO();
		cliente=dao.clienteId(id);
			ventana.getCli_codigo().setText(Integer.toString(cliente.getCodigo()));
			ventana.getCli_nombre().setText(cliente.getNombre());
			ventana.getCli_cedula().setText(Integer.toString(cliente.getCedula()));
			ventana.getCli_ruc().setText(cliente.getRuc());
			ventana.getCli_direccion().setText(cliente.getDireccion());
			ventana.getCli_telefono().setText(Integer.toString(cliente.getTelefono()));
		}
	private void seleccionarFila() {
		int row =ventana.getTableCliente().getSelectedRow();
		Integer id=Integer.parseInt(ventana.getTableCliente().getValueAt(row, 0).toString().trim());
		cargar(id);
		
	}
	
	private void obtenerUltimoId() {
		cliente=ClienteDAO.obtenerUltimoId();
		ventana.getCli_codigo().setText(Integer.toString(cliente.getCodigo()));

	}
	
	private void habilitarGuardar() {
		this.ventana.getCli_nombre().setEnabled(true);
		this.ventana.getCli_cedula().setEnabled(true);
		this.ventana.getCli_ruc().setEnabled(true);
		this.ventana.getCli_direccion().setEnabled(true);
		this.ventana.getCli_telefono().setEnabled(true);

	}
	private void desabilitarGuardar() {
		this.ventana.getCli_nombre().setEnabled(false);
		this.ventana.getCli_cedula().setEnabled(false);
		this.ventana.getCli_ruc().setEnabled(false);
		this.ventana.getCli_direccion().setEnabled(false);
		this.ventana.getCli_telefono().setEnabled(false);

	}
	private void limpiarCampo() {
		ventana.getCli_codigo().setText("");
		ventana.getCli_nombre().setText("");
		ventana.getCli_cedula().setText("");
		ventana.getCli_ruc().setText("");
		ventana.getCli_direccion().setText("");
		ventana.getCli_telefono().setText("");
	}
	
	
	public void limpiarTabla() {
		DefaultTableModel modelo=(DefaultTableModel) ventana.getTableCliente().getModel();
		for (int i = 0; i < ventana.getTableCliente().getRowCount(); i++) {
			modelo.removeRow(i);
			i-=1;
		}
		
	}
	private void salir() {
		this.ventana.dispose();
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(ventana.getBtnGuardar())) {
			registrarCliente();
			limpiarTabla();
			listarClientes();
			limpiarCampo();
			desabilitarGuardar();
			
		}
		if (e.getSource().equals(ventana.getBtnNuevo())) {
			habilitarGuardar();
			limpiarCampo();
			ventana.getBtnGuardar().setEnabled(true);
			ventana.getBtnModificar().setEnabled(false);
			this.ventana.getBtnEliminar().setEnabled(false);
			obtenerUltimoId();
		}
		if (e.getSource().equals(ventana.getBtnModificar())) {
			limpiarTabla();
			listarClientes();
			habilitarGuardar();
			this.ventana.getBtnGuardar().setEnabled(true);
			this.ventana.getBtnEliminar().setEnabled(false);
			this.ventana.getBtnModificar().setEnabled(false);
			modificar=true;
		}
		if (e.getSource().equals(ventana.getBtnSalir())) {
			salir();
			
		}
		if (e.getSource().equals(ventana.getClie_buscar())) {
				limpiarTabla();
				listarNombre();
					
		}
		if (e.getSource().equals(ventana.getBtnCanselar())) {
			limpiarCampo();
		}
		if (e.getSource().equals(ventana.getBtnEliminar())) {
			if (JOptionPane.showConfirmDialog(new JDialog(),
					"¿Seguro que Quieres Eliminar","Salir",
					JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
				eliminar();
				limpiarTabla();
				listarClientes();
				
			}

		}
		
	}
	private void listarNombre(){
			ArrayList<Cliente> cliente=new ArrayList<Cliente>();
			String nombre=ventana.getClie_buscar().getText();
			cliente=ClienteDAO.listasCliente(nombre);
			DefaultTableModel modelo=(DefaultTableModel) ventana.getTableCliente().getModel();
				Object[] fila=new Object[modelo.getColumnCount()];
				for (int i = 0; i <cliente.size(); i++) {					
					fila[0]=cliente.get(i).getCodigo();
					fila[1]=cliente.get(i).getNombre();
					fila[2]=cliente.get(i).getCedula();
					modelo.addRow(fila);
				}
	}
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getSource().equals(ventana.getTableCliente())){
			if(e.getKeyCode()==KeyEvent.VK_ENTER){
				seleccionarFila();
				this.ventana.getBtnGuardar().setEnabled(false);
				this.ventana.getBtnModificar().setEnabled(true);
				this.ventana.getBtnEliminar().setEnabled(true);
				desabilitarGuardar();
			
			}
			
		
		}
		
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		if (e.getSource().equals(ventana.getCli_cedula())) {
			char car=e.getKeyChar();
			if(  ventana.getCli_cedula().getText().length()>=8)e.consume();
			if((car<'0' || car>'9') ) e.consume();
		}
		if (e.getSource().equals(ventana.getCli_nombre())) {
			char car=e.getKeyChar();
		       if((car<'a' || car>'z') && (car<'A' || car>'Z')&&(car<' '||car>' ')) e.consume();
		}
		}
		
	}
	
	

