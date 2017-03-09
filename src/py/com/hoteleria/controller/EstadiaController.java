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

import py.com.hoteleria.dao.DetalleDAO;
import py.com.hoteleria.dao.EstadiaDAO;
import py.com.hoteleria.dao.HabitacionDAO;
import py.com.hoteleria.form.FormDetalle;
import py.com.hoteleria.form.FormEstadia;
import py.com.hoteleria.lista.ListaCliente;
import py.com.hoteleria.lista.ListaHabitacion;
import py.com.hoteleria.model.Detalle;
import py.com.hoteleria.model.Estadia;
import py.com.hoteleria.model.Habitacion;

public class EstadiaController implements ActionListener,KeyListener,MouseListener{
	private EstadiaDAO dao;
	private FormEstadia ventana;
	private Estadia estadia;
	private boolean modificar;
	Double total=0.0;
	DecimalFormat formatea = new DecimalFormat("###,###.##"+" Gs");
	public EstadiaController(FormEstadia v){
		this.ventana=v;
		ventana.getBtnGuardar().addActionListener(this);
		ventana.getBtnBuscarCliente().addActionListener(this);
		ventana.getBtnBuscarHabitacion().addActionListener(this);
		ventana.getTableEstadia().addKeyListener(this);
		ventana.getBtnModificar().addActionListener(this);
		ventana.getBtnEliminar().addActionListener(this);
		ventana.getBtnCerrar().addActionListener(this);
		ventana.getTableEstadia().addMouseListener(this);
		ventana.getBtnDetalle().addActionListener(this);
		ventana.getBtnCierre_1().addActionListener(this);
		ventana.getBtnActivo().addActionListener(this);
		ventana.getBtnInactivo().addActionListener(this);
		ventana.getBtnTodos().addActionListener(this);
		ventana.getBtnAtras().addActionListener(this);
		ventana.getBtnNuevo().addActionListener(this);
		ventana.getBtnCierre().addActionListener(this);
		
	}
	
	@SuppressWarnings("static-access")
	private void registrarEstadia() {
		if (ventana.getECodCliente().getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Debes Ingresar el Codigo del Cliente");
			ventana.getECodCliente().requestFocus();
		}else if (ventana.getECodHab().getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Debes Ingresar el Codigo del Habitacion");
			ventana.getECodHab().requestFocus();
		} else{
		estadia=new Estadia();
		 estadia.setFechaEntrada(ventana.getEfechaEntrada().getDate());
		 estadia.getCliente().setCodigo(Integer.parseInt(ventana.getECodCliente().getText()));
		 estadia.getHabitacion().setCodigo(Integer.parseInt(ventana.getECodHab().getText()));
		 estadia.setMonto(Double.parseDouble(ventana.getEmonto().getText()));
		 estadia.setObservacion(ventana.getEobservacion().getText());
		dao=new EstadiaDAO();
        if(modificar==false){
        	dao.guardar(estadia);
   
		}else{
			estadia.setCodigo(Integer.parseInt(ventana.getEcodigo().getText()));
			dao.modificarEstadia(estadia);
		}
        
		}
	}
	@SuppressWarnings("static-access")
	private void actualizar() {
		estadia=new Estadia();
		estadia.setCodigo(Integer.parseInt(ventana.getEcodigo().getText()));
		estadia.setFechaSalida(ventana.getEfechaSalida().getDate());
		estadia.setDescuento(Double.parseDouble(ventana.getEmontoDescue().getText()));
		estadia.setEstado(false);
		dao=new EstadiaDAO();
		dao.actualizarEstadia(estadia);

	}

	public void listarEstadia(){
		DefaultTableModel modelo=(DefaultTableModel) ventana.getTableEstadia().getModel();
		ArrayList<Estadia>lista=EstadiaDAO.listarEstadias();
		Object[] fila=new Object[modelo.getColumnCount()];
	    for (int i = 0; i < lista.size(); i++) {
	    	fila[0]=lista.get(i).getCodigo();
	    	fila[1]=lista.get(i).getCliente().getNombre();
	    	fila[2]=lista.get(i).getHabitacion().getCodigo();
	    	fila[3]=lista.get(i).getFechaEntrada();
	    	fila[4]=formatea.format(lista.get(i).getHabitacion().getMontoDia());

	    	modelo.addRow(fila);
	    }
		}
	public void listarEstadiaInactivo(){
		DefaultTableModel modelo=(DefaultTableModel) ventana.getTableEstadia().getModel();
		ArrayList<Estadia>lista=EstadiaDAO.listarEstadiasInactivo();
		Object[] fila=new Object[modelo.getColumnCount()];
	    for (int i = 0; i < lista.size(); i++) {
	    	fila[0]=lista.get(i).getCodigo();
	    	fila[1]=lista.get(i).getCliente().getNombre();
	    	fila[2]=lista.get(i).getHabitacion().getCodigo();
	    	fila[3]=lista.get(i).getFechaEntrada();
	    	fila[4]=formatea.format(lista.get(i).getHabitacion().getMontoDia());

	    	modelo.addRow(fila);
	    }
		}
	public void listarEstadiaTodos(){
		DefaultTableModel modelo=(DefaultTableModel) ventana.getTableEstadia().getModel();
		ArrayList<Estadia>lista=EstadiaDAO.listarEstadiasTodo();
		Object[] fila=new Object[modelo.getColumnCount()];
	    for (int i = 0; i < lista.size(); i++) {
	    	fila[0]=lista.get(i).getCodigo();
	    	fila[1]=lista.get(i).getCliente().getNombre();
	    	fila[2]=lista.get(i).getHabitacion().getCodigo();
	    	fila[3]=lista.get(i).getFechaEntrada();
	    	fila[4]=formatea.format(lista.get(i).getHabitacion().getMontoDia());

	    	modelo.addRow(fila);
	    }
		}

		
	
	public void listarDetalles(int id){
		ArrayList<Detalle>lista=DetalleDAO.listarDetalle(id);
		DefaultTableModel modelo=(DefaultTableModel) ventana.getTableDetalle().getModel();
		Object[] fila=new Object[modelo.getColumnCount()];
	    for (int i = 0; i < lista.size(); i++) {
	    	fila[0]=lista.get(i).getCodigo();
	    	fila[1]=lista.get(i).getEstadia().getCodigo();
	    	fila[2]=lista.get(i).getServicio().getCodigo();
//	    	fila[3]=lista.get(i).getServicio().getDescripcionServicio();
	    	fila[4]=lista.get(i).getMonto();
	    	modelo.addRow(fila);
	    }
		}
	
	@SuppressWarnings("static-access")
	public void eliminar(){
		estadia=new Estadia();
		estadia.setCodigo(Integer.parseInt(ventana.getEcodigo().getText()));
		dao.eliminar(estadia);
		
	}
	public void limpiarTabla() {
		DefaultTableModel modelo=(DefaultTableModel) ventana.getTableEstadia().getModel();
		for (int i = 0; i < ventana.getTableEstadia().getRowCount(); i++) {
			modelo.removeRow(i);
			i-=1;
		}
		
	}
	public void limpiarTablaDetalle() {
		DefaultTableModel modelo=(DefaultTableModel) ventana.getTableDetalle().getModel();
		for (int i = 0; i < ventana.getTableDetalle().getRowCount(); i++) {
			modelo.removeRow(i);
			i-=1;
		}
		
	}
	@SuppressWarnings("static-access")
	public void cargar(int id){
		dao=new EstadiaDAO();
		estadia=dao.estadiaId(id);
			ventana.getEcodigo().setText(Integer.toString(estadia.getCodigo()));
			ventana.getEfechaEntrada().setDate(estadia.getFechaEntrada());
			ventana.getECodCliente().setText(Integer.toString(estadia.getCliente().getCodigo()));
			ventana.getECodHab().setText(Integer.toString(estadia.getHabitacion().getCodigo()));
			ventana.getEfechaSalida().setDate(estadia.getFechaSalida());
			ventana.getEmonto().setText(Double.toString(estadia.getMonto()));
			ventana.getEmontoDescue().setText(Double.toString(estadia.getDescuento()));
			ventana.getEobservacion().setText(estadia.getObservacion());
			
			
		}
	private void seleccionarFila() {
		int row =ventana.getTableEstadia().getSelectedRow();
		Integer id=Integer.parseInt(ventana.getTableEstadia().getValueAt(row, 0).toString().trim());
		cargar(id);
		limpiarTablaDetalle();
		listarDetalles(id);
		totalServicio();
		pasarCampoTabl();
		desabilitar();
		
	}
	
	private void pasarCampoTabl() {
		Integer fila = this.ventana.getTableEstadia().getSelectedRow();
		String dato = String.valueOf(this.ventana.getTableEstadia().getValueAt( fila,1));
        FormEstadia.Enombre.setText(dato);
	}
	public void totalServicio(){
		double total=0;
    	for (int i = 0; i < ventana.getTableDetalle().getRowCount(); i++) {
			double numero=0;
			
			try {
				numero=Double.valueOf(ventana.getTableDetalle().getValueAt(i, 4).toString());
			} catch (NumberFormatException e) {
				numero=0;
				ventana.getTableDetalle().setValueAt(0, i, 4);
			}
			total+=numero;
		}
    	ventana.getEtotalServicio().setText(String.valueOf(total));
   
}
	private void desabilitar() {
		this.ventana.getEfechaEntrada().setEnabled(false);
		FormEstadia.Enombre.setEditable(false);
		this.ventana.getECodHab().setEditable(false);
		this.ventana.getEmonto().setEditable(false);
		this.ventana.getEobservacion().setEditable(false);
		this.ventana.getBtnBuscarCliente().setVisible(false);
		this.ventana.getBtnBuscarHabitacion().setVisible(false);
		this.ventana.getEfechaSalida().setEnabled(false);

	}

	
	
	private void habilitarCampo() {
		this.ventana.getEfechaEntrada().setEnabled(true);
		this.ventana.getECodCliente().setEnabled(true);
		this.ventana.getECodHab().setEnabled(true);
		this.ventana.getEmonto().setEnabled(true);
		this.ventana.getEmontoDescue().setEnabled(true);
		this.ventana.getEobservacion().setEditable(true);
		this.ventana.getEmonto().setEditable(true);
		

	}
	private void limpiarCampo() {
		this.ventana.getEfechaEntrada().setDate(null);
		FormEstadia.Enombre.setText("");
		this.ventana.getECodHab().setText("");
		this.ventana.getEcosto().setText("");
		this.ventana.getEobservacion().setText("");
		this.ventana.getEfechaSalida().setDate(null);
		this.ventana.getEmonto().setText("");
		this.ventana.getEmontoDescue().setText("");
		this.ventana.getBtnBuscarCliente().setVisible(true);
		this.ventana.getBtnBuscarHabitacion().setVisible(true);
		

	}
	private void habilitarCampoCierre() {
		this.ventana.getBtnCierre_1().setVisible(true);
		this.ventana.getEfechaSalida().setEnabled(true);
		this.ventana.getEcosto().setEditable(true);
		this.ventana.getEservicio().setEditable(true);
		this.ventana.getEmontoDescue().setEditable(true);
		this.ventana.getEtotal().setEditable(true);

	}
	@SuppressWarnings("static-access")
	private void actuazilarHab(){
	Habitacion habita=new Habitacion();
    
	HabitacionDAO hab=new HabitacionDAO();
	habita.setCodigo(Integer.parseInt(ventana.getECodHab().getText()));
	hab.actualizarHabitacion(habita);
	
	}
	@SuppressWarnings("static-access")
	private void actuazilarHabi(){
	Habitacion habita=new Habitacion();
    
	HabitacionDAO hab=new HabitacionDAO();
	habita.setCodigo(Integer.parseInt(ventana.getECodHab().getText()));
	hab.actualizarHabitacionFalse(habita);
	
	}
	
	private void sumaMontoServicio() {
		double monto=0,servicio=0;
		monto=Double.parseDouble(ventana.getEmonto().getText());
		servicio=Double.parseDouble((ventana.getEtotalServicio().getText()));
		
		total=monto+servicio;
		
		ventana.getEtotal().setText(total.toString());

	}
	
	public void ocultarBoton() {
		this.ventana.getBtnGuardar().setVisible(false);
		this.ventana.getBtnModificar().setVisible(false);
		this.ventana.getBtnEliminar().setVisible(false);
		this.ventana.getBtnCierre().setVisible(false);
		this.ventana.getBtnCierre_1().setVisible(false);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(ventana.getBtnCierre())) {
			habilitarCampoCierre();
		}
		if (e.getSource().equals(ventana.getBtnNuevo())) {
			limpiarCampo();
			habilitarCampo();
			this.ventana.getBtnGuardar().setVisible(true);
			this.ventana.getBtnBuscarCliente().setEnabled(true);
			this.ventana.getBtnBuscarHabitacion().setEnabled(true);
		
		}
		
		if (e.getSource().equals(ventana.getBtnInactivo())) {
			limpiarTabla();
			listarEstadiaInactivo();
		}
		if (e.getSource().equals(ventana.getBtnTodos())) {
			limpiarTabla();
			listarEstadiaTodos();
		}
		if (e.getSource().equals(ventana.getBtnActivo())) {
			limpiarTabla();
			listarEstadia();
		}
		if (e.getSource().equals(ventana.getBtnCierre_1())) {
			actualizar();
			limpiarTabla();
			listarEstadia();
			actuazilarHabi();
			ventana.getEfechaSalida().setEnabled(false);
			ventana.getEcosto().setEditable(false);
			ventana.getEservicio().setEditable(false);
			ventana.getEtotal().setEditable(false);
			ventana.getEmontoDescue().setEditable(false);
		}
		
		if (e.getSource().equals(ventana.getBtnBuscarCliente())) {
			ListaCliente f=new ListaCliente();
			f.setLocation(550, 246);
			f.setVisible(true);
			
			
		}
		if (e.getSource().equals(ventana.getBtnBuscarHabitacion())) {
			ListaHabitacion f=new ListaHabitacion();
			f.setLocationRelativeTo(null);
			f.setVisible(true);
		}
		if (e.getSource().equals(ventana.getBtnGuardar())) {
			actuazilarHab();
			registrarEstadia();
			limpiarCampo();
			limpiarTabla();
			listarEstadia();
			modificar=false;
			
		}
		if (e.getSource().equals(ventana.getBtnModificar())) {
			modificar=true;
			habilitarCampo();
		}
		if (e.getSource().equals(ventana.getBtnEliminar())) {
			if (JOptionPane.showConfirmDialog(new JDialog(),
					"¿Seguro que Quieres Eliminar","Salir",
					JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
				eliminar();
				limpiarTabla();
				listarEstadia();
				
			}

		}
		if (e.getSource().equals(ventana.getBtnCerrar())) {
			this.ventana.dispose();
		}
		if (e.getSource().equals(ventana.getBtnDetalle())) {
			FormDetalle f=new FormDetalle();
			f.setLocationRelativeTo(null);
			f.setVisible(true);
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getSource().equals(ventana.getTableEstadia())){
			if(e.getKeyCode()==KeyEvent.VK_ENTER){
				seleccionarFila();
                this.ventana.getBtnCierre().setVisible(true);
			    
			}
			
		
		}
		
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getClickCount()==2) {
			for (@SuppressWarnings("unused") int i : ventana.getTableEstadia().getSelectedRows()) {
		     seleccionarFila();
		    sumaMontoServicio();
			}
	            
			
		}
		
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
		if (e.getClickCount()==2) {
			for (@SuppressWarnings("unused") int i : ventana.getTableEstadia().getSelectedRows()) {
		    
		     seleccionarFila();
		     sumaMontoServicio();
			}
	            
			

		}
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
