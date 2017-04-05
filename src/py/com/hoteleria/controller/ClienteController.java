package py.com.hoteleria.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import py.com.hoteleria.abm.FormCliente;
import py.com.hoteleria.dao.ClienteDAO;
import py.com.hoteleria.model.Cliente;

public class ClienteController implements ActionListener,KeyListener,WindowListener{
	private ClienteDAO dao;
	private FormCliente ventana;
	private Cliente cliente;
	private boolean modificar;
	DecimalFormat formatea = new DecimalFormat("###,###.##");
	
	public ClienteController(FormCliente v){
		this.ventana=v;
		ventana.getBtnNuevo().addActionListener(this);
		ventana.getBtnGuardar().addActionListener(this);
		ventana.getBtnModificar().addActionListener(this);
		ventana.getTableCliente().addKeyListener(this);
		ventana.getBtnSalir().addActionListener(this);
		ventana.getCli_cedula().addKeyListener(this);
		ventana.getCli_nombre().addKeyListener(this);
		ventana.getBtnBuscar().addActionListener(this);
		ventana.getBtnEliminar().addActionListener(this);
		ventana.getCli_telefono().addKeyListener(this);
		ventana.getBtnGuardar().addKeyListener(this);
		
		
	}
	
	public boolean verificar(){
		boolean estado = false;
		boolean veri = false;
		  dao = new ClienteDAO();
		  if (ventana.getCli_cedula().getText().isEmpty()) {
			
		} else {
		  veri=dao.verificarCI(Integer.parseInt(ventana.getCli_cedula().getText()));
		if (veri== true) {
			estado = true;
		}else {
			estado = false;
		}
	}
		  return estado;
	}
	@SuppressWarnings("static-access")
	private void registrarCliente() {
		if (ventana.getCli_nombre().getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Debes Completar el Nombre");
			ventana.getCli_nombre().requestFocus();
		}else if (ventana.getCli_cedula().getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Debe Ingresar el Numero de Cedula");
			ventana.getCli_cedula().requestFocus();
			
		} else if (ventana.getCli_direccion().getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Debes Ingresar la Direccion");
			ventana.getCli_direccion().requestFocus();
			
		} else {
			if (cliente !=null) {
				cliente=new Cliente();
				cliente.setCodigo(Integer.parseInt(ventana.getCli_codigo().getText()));
				cliente.setNombre(ventana.getCli_nombre().getText());
				cliente.setCedula(Integer.parseInt(ventana.getCli_cedula().getText()));
				cliente.setRuc(ventana.getCli_ruc().getText());
				cliente.setDireccion(ventana.getCli_direccion().getText());
				cliente.setTelefono(ventana.getCli_telefono().getText());
				dao=new ClienteDAO();
		        if(modificar==false){
		        	if (verificar() == true) {
						
					}else {
						dao.guardar(cliente);
						limpiarCampo();
						limpiarTabla();
						listarClientes();
								
				}
				}else{
					cliente.setCodigo(Integer.parseInt(ventana.getCli_codigo().getText()));
					dao.modificarCliente(cliente);
				    limpiarCampo();
				    limpiarTabla();
				    listarClientes();
				}
	        
			} else {
				JOptionPane.showMessageDialog(null, "El Cliente no fue Guardado");
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
	    	fila[2]=formatea.format(lista.get(i).getCedula());
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
			ventana.getCli_telefono().setText(cliente.getTelefono());
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
		this.ventana.getCli_nombre().setEditable(true);
		this.ventana.getCli_cedula().setEditable(true);
		this.ventana.getCli_ruc().setEditable(true);
		this.ventana.getCli_direccion().setEditable(true);
		this.ventana.getCli_telefono().setEditable(true);

	}
	private void desabilitarGuardar() {
		this.ventana.getCli_nombre().setEditable(false);
		this.ventana.getCli_cedula().setEditable(false);
		this.ventana.getCli_ruc().setEditable(false);
		this.ventana.getCli_direccion().setEditable(false);
		this.ventana.getCli_telefono().setEditable(false);

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
	public void ocultarGuardar() {
		ventana.getBtnGuardar().setVisible(false);
		ventana.getBtnModificar().setVisible(false);
		ventana.getBtnEliminar().setVisible(false);

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
	/** Empieza el
	 * 
	 *  actionPerformed
	 *  **/
	
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource().equals(ventana.getBtnGuardar())) {	
			
			if (ventana.getCli_nombre().getText().isEmpty()) {
				ventana.getBtnModificar().setVisible(true);
				
			} else{
		
				ventana.getBtnModificar().setVisible(false);
			}
				registrarCliente();
				desabilitarGuardar();
			    modificar=false;
			
		
		}
		
		if (e.getSource().equals(ventana.getBtnNuevo())) {
			limpiarCampo();
			habilitarGuardar();
			ventana.getBtnGuardar().setVisible(true);
			ventana.getBtnModificar().setVisible(false);
			this.ventana.getBtnEliminar().setVisible(false);
			ventana.getBtnGuardar().setEnabled(true);
			obtenerUltimoId();
		}
		if (e.getSource().equals(ventana.getBtnModificar())) {
			modificar=true;
			limpiarTabla();
			listarClientes();
			habilitarGuardar();
			ventana.getBtnGuardar().setVisible(true);
			ventana.getBtnModificar().setVisible(false);
			ventana.getBtnEliminar().setVisible(false);
		}
		if (e.getSource().equals(ventana.getBtnSalir())) {
			if (JOptionPane.showConfirmDialog(new JDialog(),
					"¿Seguro que Quieres Salir?","Salir",2,
					JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
				salir();
				
			}
			
		}
		if (e.getSource().equals(ventana.getBtnBuscar())) {
				limpiarTabla();
				listarNombre();
					
		}
		
		if (e.getSource().equals(ventana.getBtnEliminar())) {
			if (JOptionPane.showConfirmDialog(new JDialog(),
					"¿Seguro que Quieres Eliminar","Salir",2,
					JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
				eliminar();
				limpiarTabla();
				listarClientes();
				limpiarCampo();
				
			}

		}
		
		
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getSource().equals(ventana.getTableCliente())){
			if(e.getKeyCode()==KeyEvent.VK_ENTER){
				seleccionarFila();
				ventana.getBtnGuardar().setVisible(false);
				ventana.getBtnModificar().setVisible(true);
				ventana.getBtnEliminar().setVisible(true);
				desabilitarGuardar();
		
			
			}
			
		
		}
		if (e.getSource().equals(ventana.getBtnGuardar())) {
			if(e.getKeyCode()==KeyEvent.VK_ENTER){
			if (verificar() == true) {
				
			}else {
							
				registrarCliente();				
			}
			modificar=false;
		
		}
		
		}
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		if (e.getSource().equals(ventana.getCli_cedula())) {
			char car=e.getKeyChar();
			if(  ventana.getCli_cedula().getText().length()>=7)e.consume();
			if((car<'0' || car>'9') ) e.consume();
		}
		if (e.getSource().equals(ventana.getCli_telefono())) {
			char car=e.getKeyChar();
			if(  ventana.getCli_telefono().getText().length()>=10)e.consume();
			if((car<'0' || car>'9') ) e.consume();
		}
		if (e.getSource().equals(ventana.getCli_nombre())) {
			char car=e.getKeyChar();
		       if((car<'a' || car>'z') && (car<'A' || car>'Z')&&(car<' '||car>' ')) e.consume();
		}
	
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
	
	

