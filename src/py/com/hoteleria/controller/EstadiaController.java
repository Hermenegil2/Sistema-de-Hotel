package py.com.hoteleria.controller;
/**
 * @author Hermenegil2
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import py.com.hoteleria.dao.DetalleDAO;
import py.com.hoteleria.dao.EstadiaDAO;
import py.com.hoteleria.dao.HabitacionDAO;
import py.com.hoteleria.form.FormDetalle;
import py.com.hoteleria.form.FormEstadia;
import py.com.hoteleria.lista.ListaCliente;
import py.com.hoteleria.lista.ListaHabitacion;
import py.com.hoteleria.model.Detalle;
import py.com.hoteleria.model.Deuda;
import py.com.hoteleria.model.Estadia;
import py.com.hoteleria.model.Habitacion;



public class EstadiaController implements ActionListener,KeyListener,MouseListener{
	private EstadiaDAO dao;
	private FormEstadia ventana;
	private Estadia estadia;
	private boolean modificar;
	Double total=0.0;
	
//	DecimalFormat formatea = new DecimalFormat("###,###.##"+" Gs");
	
	
	public EstadiaController(FormEstadia v){
		this.ventana=v;
		ventana.getBtnGuardar().addActionListener(this);
		ventana.getBtnBuscarCliente().addActionListener(this);
		ventana.getBtnBuscarHabitacion().addActionListener(this);
		ventana.getTableEstadia().addKeyListener(this);
		ventana.getBtnModificar().addActionListener(this);
		ventana.getBtnEliminar().addActionListener(this);
		ventana.getBtnSalir().addActionListener(this);
		ventana.getTableEstadia().addMouseListener(this);
		ventana.getBtnDetalle().addActionListener(this);
		ventana.getBtnCierre_C().addActionListener(this);
		ventana.getBtnActivo().addActionListener(this);
		ventana.getBtnInactivo().addActionListener(this);
		ventana.getBtnTodos().addActionListener(this);
		ventana.getBtnNuevo().addActionListener(this);
		ventana.getBtnCierre().addActionListener(this);
		ventana.getBtnCancelar().addActionListener(this);
		ventana.getEmontoDescue().addKeyListener(this);
		ventana.getEmontoTotal().addKeyListener(this);
		ventana.getEBuscarEstadia().addKeyListener(this);
		ventana.getBtnGuardar().addKeyListener(this);
		ventana.getBtnCierre_C().addKeyListener(this);
		ventana.getTableDetalle().addKeyListener(this);
		ventana.getEfechaSalida().addKeyListener(this);
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
			if (estadia !=null) {
				estadia=new Estadia();
				 estadia.setFecha(ventana.getEfecha().getText());
				 estadia.getCliente().setCodigo(Integer.parseInt(ventana.getECodCliente().getText()));
				 estadia.getHabitacion().setCodigo(Integer.parseInt(ventana.getECodHab().getText()));
				 estadia.setObservacion(ventana.getEobservacion().getText());
				dao=new EstadiaDAO();
		        if(modificar==false){
		        	dao.guardar(estadia);
		        	actualizarHabitacionTrue();
					limpiarCampo();
					limpiarTabla();
					listarEstadia();
					limpiarCampo();
					ventana.getEcodigo().setText("");
					ventana.getEfecha().setText("");
					ventana.getBtnGuardar().setVisible(false);
					ventana.getBtnDetalle().setVisible(false);
		   
				}else {
					estadia.setCodigo(Integer.parseInt(ventana.getEcodigo().getText()));
					dao.modificarEstadia(estadia);
					limpiarCampo();
					limpiarTabla();
					listarEstadia();
					limpiarCampo();
					ventana.getEcodigo().setText("");
					ventana.getEfecha().setText("");
					ventana.getBtnGuardar().setVisible(false);
					ventana.getBtnModificar().setVisible(false);
					ventana.getBtnDetalle().setVisible(false); 
				}
					
		        		
				} else {
					JOptionPane.showMessageDialog(null, "La Estadia no fue Guardada");
				}
			}
		
	}
	@SuppressWarnings({ "static-access", "deprecation" })
	private void actualizar() {
		if (ventana.getEfechaSalida().getText().isEmpty()) {
	        JOptionPane.showMessageDialog(null, "La fecha de Salida no debe quedar Vacio");
		} else if(ventana.getEmonto().getText().isEmpty()){
			JOptionPane.showMessageDialog(null, "El monto no debe quedar Vacio");
		} else if (ventana.getEmontoTotal().getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "El  Monto Total no debe quedar Vacio");
		} else{
		estadia=new Estadia();
		Deuda deuda=new Deuda();
		estadia.setCodigo(Integer.parseInt(ventana.getEcodigo().getText()));
		estadia.setMonto(Double.parseDouble(ventana.getEmonto().getText()));
		if(ventana.getEmontoDescue().getText().isEmpty()){
            estadia.setDescuento(0.0);
		} else {
			estadia.setDescuento(Double.parseDouble(ventana.getEmontoDescue().getText()));
			
		}
		estadia.setFechaSalida(new Date(ventana.getEfechaSalida().getText()));
		estadia.setEstado(false);
		deuda.getEstadia().setCodigo(Integer.parseInt(ventana.getEcodigo().getText()));
		deuda.getCliente().setCodigo(Integer.parseInt(ventana.getECodCliente().getText()));
		deuda.setMontoDeuda(Double.parseDouble(ventana.getEmontoTotal().getText()));
		dao=new EstadiaDAO();
		dao.actualizarEstadia(estadia,deuda);
		actualizarHabitacionFalse();
		limpiarTabla();
		listarEstadia();
		limpiarCampoEstadia();
		limpiarDetalle();
		actualizar();
		limpiarCampoEstadia();
		limpiarDetalle();
		ventana.getEmontoDescue().setEditable(false);
		ventana.getEfechaSalida().setEditable(false);
		ventana.getBtnDetalle().setVisible(false);
	}
		}
	
	
	
	
	@SuppressWarnings("static-access")
	private void actualizarHabitacionTrue() {
		Habitacion habita=new Habitacion();
		habita.setCodigo(Integer.parseInt(ventana.getECodHab().getText()));
		HabitacionDAO hab=new HabitacionDAO();
		hab.actualizarHabitacion(habita);

	}
	@SuppressWarnings("static-access")
	private void actualizarHabitacionFalse() {
		Habitacion habita=new Habitacion();
		habita.setCodigo(Integer.parseInt(ventana.getECodHab().getText()));
		HabitacionDAO hab=new HabitacionDAO();
		hab.actualizarHabitacionFalse(habita);

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
	    	fila[4]=lista.get(i).getHabitacion().getMontoDia();
	    	fila[5]=lista.get(i).isEstado();

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
	    	fila[4]=lista.get(i).getHabitacion().getMontoDia();
	    	fila[5]=lista.get(i).isEstado();

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
	    	fila[4]=lista.get(i).getHabitacion().getMontoDia();
	    	fila[5]=lista.get(i).isEstado();
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
	    	fila[3]=lista.get(i).getServicio().getDescripcionServicio();
	    	fila[4]=lista.get(i).getMonto();
	    	modelo.addRow(fila);
	    }
		}
	
	@SuppressWarnings("static-access")
	public void eliminar(){
		if (estadia !=null) {
			estadia=new Estadia();
			estadia.setCodigo(Integer.parseInt(ventana.getEcodigo().getText()));
			dao.eliminar(estadia);
			actualizarHabitacionFalse();
		}
	}
	public void limpiarTabla() {
		DefaultTableModel modelo=(DefaultTableModel) ventana.getTableEstadia().getModel();
		for (int i = 0; i < ventana.getTableEstadia().getRowCount(); i++) {
			modelo.removeRow(i);
			i-=1;
		}
		
	}
	public void limpiarDetalle() {
		DefaultTableModel modelo=(DefaultTableModel) ventana.getTableDetalle().getModel();
		for (int i = 0; i < ventana.getTableDetalle().getRowCount(); i++) {
			modelo.removeRow(i);
			i-=1;
		}
		
	}
	private void limpiarTablaDetalle() {
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
			ventana.getECodCliente().setText(Integer.toString(estadia.getCliente().getCodigo()));
			ventana.getECodHab().setText(Integer.toString(estadia.getHabitacion().getCodigo()));
			ventana.getEfecha().setText(estadia.getFecha());
			ventana.getEobservacion().setText(estadia.getObservacion());
			
			
			
		}

	
	private void pasarCampoTablaDetalleServicio() {
		Integer fila = this.ventana.getTableEstadia().getSelectedRow();
		String dato = String.valueOf(this.ventana.getTableEstadia().getValueAt( fila,0));
        FormDetalle.DtNroEstadia.setText(dato);
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
		ventana.getBtnGuardar().setVisible(false);
		ventana.getBtnCierre_C().setVisible(false);
		ventana.getBtnDetalle().setVisible(true);
		ventana.getEfechaSalida().setText("");
		ventana.getEmonto().setText("");
		ventana.getEmontoDescue().setText("");
		ventana.getEmontoTotal().setText("");
	
		
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
		FormEstadia.Enombre.setEditable(false);
		this.ventana.getECodHab().setEditable(false);
		this.ventana.getEmonto().setEditable(false);
		this.ventana.getEobservacion().setEditable(false);
		this.ventana.getBtnBuscarCliente().setVisible(false);
		this.ventana.getBtnBuscarHabitacion().setVisible(false);
		this.ventana.getEfechaSalida().setEnabled(false);

	}

	
	
	private void habilitarCampo() {
		this.ventana.getECodCliente().setEnabled(true);
		this.ventana.getECodHab().setEnabled(true);
		this.ventana.getEmontoDescue().setEnabled(true);
		this.ventana.getEobservacion().setEditable(true);
		

	}
	private void limpiarCampo() {
		FormEstadia.ECodCliente.setText("");
		FormEstadia.Enombre.setText("");
		this.ventana.getECodHab().setText("");
		this.ventana.getEobservacion().setText("");
		this.ventana.getEmonto().setText("");
		this.ventana.getEmontoDescue().setText("");
		this.ventana.getBtnBuscarCliente().setVisible(true);
		this.ventana.getBtnBuscarHabitacion().setVisible(true);
		

	}
	private void habilitarCampoCierre() {
		this.ventana.getBtnCierre_C().setVisible(true);
		this.ventana.getEfechaSalida().setEnabled(true);
		this.ventana.getEmontoDescue().setEditable(true);

	}
	
	private void fecha() {  
		Date ahora = new Date();
        SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println(formateador.format(ahora));
		 ventana.getEfechaSalida().setText(formateador.format(ahora)); 
 }
 
	private void fechaEstadia() {  
		Date ahora = new Date();
        SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println(formateador.format(ahora));
		 ventana.getEfecha().setText(formateador.format(ahora)); 
 }
	private void obtenerUltimoId() {
		estadia=EstadiaDAO.obtenerUltimoId();
		ventana.getEcodigo().setText(Integer.toString(estadia.getCodigo()));
	}
	
	private void diferenciaDia(){
		
		final long MILLSECS_PER_DAY = 24 * 60 * 60 * 1000; //Milisegundos al día 
		java.util.Date hoy = new Date(); //Fecha de hoy 
		String fechaInicio=ventana.getEfecha().getText();
		String[] aFechaIng = fechaInicio.split("/");
        Integer dia = Integer.parseInt(aFechaIng[0]);
        Integer mes = Integer.parseInt(aFechaIng[1]);
        Integer año = Integer.parseInt(aFechaIng[2]);
		Calendar calendar = new GregorianCalendar(año,mes-1,dia); 
		java.sql.Date fecha = new java.sql.Date(calendar.getTimeInMillis());

		long diferencia = ( hoy.getTime() - fecha.getTime() )/MILLSECS_PER_DAY; 
		
		Integer fila = this.ventana.getTableEstadia().getSelectedRow();
		String dato =String.valueOf(this.ventana.getTableEstadia().getValueAt( fila,4));
		Double datos=Double.parseDouble(dato);
	    Double servicio=Double.parseDouble(ventana.getEtotalServicio().getText());
		total=((diferencia+1)*datos)+servicio;
        ventana.getEmonto().setText(total.toString());
	}
	
private void diferenciaDiaModificable(){
	
	String fechaActual=ventana.getEfechaSalida().getText();
	String[] aFechaActu = fechaActual.split("/");
    Integer diaA = Integer.parseInt(aFechaActu[0]);
    Integer mesA = Integer.parseInt(aFechaActu[1]);
    Integer añoA = Integer.parseInt(aFechaActu[2]);
	Calendar calendarA = new GregorianCalendar(añoA,mesA-1,diaA); 
	java.sql.Date fechaA = new java.sql.Date(calendarA.getTimeInMillis());
	
		
		final long MILLSECS_PER_DAY = 24 * 60 * 60 * 1000; //Milisegundos al día 
		String fechaInicio=ventana.getEfecha().getText();
		String[] aFechaIng = fechaInicio.split("/");
        Integer dia = Integer.parseInt(aFechaIng[0]);
        Integer mes = Integer.parseInt(aFechaIng[1]);
        Integer año = Integer.parseInt(aFechaIng[2]);
		Calendar calendar = new GregorianCalendar(año,mes-1,dia); 
		java.sql.Date fecha = new java.sql.Date(calendar.getTimeInMillis());

		long diferencia = (fechaA.getTime() - fecha.getTime() )/MILLSECS_PER_DAY; 
		if (fecha.getTime() > fechaA.getTime()) {
			JOptionPane.showMessageDialog(null, "La fecha de Entrada NO debe ser Mayor de la Fecha Salida");
		} else {
		Integer fila = this.ventana.getTableEstadia().getSelectedRow();
		String dato =String.valueOf(this.ventana.getTableEstadia().getValueAt( fila,4));
		Double datos=Double.parseDouble(dato);
	    Double servicio=Double.parseDouble(ventana.getEtotalServicio().getText());
		total=((diferencia+1)*datos)+servicio;
        ventana.getEmonto().setText(total.toString());
	}
}
	public void ocultarBoton() {
		this.ventana.getBtnGuardar().setVisible(false);
		this.ventana.getBtnModificar().setVisible(false);
		this.ventana.getBtnEliminar().setVisible(false);
		this.ventana.getBtnCierre().setVisible(false);
		this.ventana.getBtnCierre_C().setVisible(false);
		this.ventana.getBtnBuscarCliente().setVisible(false);
		this.ventana.getBtnBuscarHabitacion().setVisible(false);
		this.ventana.getBtnDetalle().setVisible(false);
	}
	
	
	
	private void restaMontoDescuentos() {
		Double monto=Double.parseDouble(ventana.getEmonto().getText());
		
		if (ventana.getEmontoDescue().getText().isEmpty()) {
			 Double descuento=0.0;
			 total=monto-descuento;
			 ventana.getEmontoTotal().setText(total.toString());
		} else {
			
        Double descuento=Double.parseDouble(ventana.getEmontoDescue().getText());
        total=monto-descuento;
        ventana.getEmontoTotal().setText(total.toString());
	}
	}
	

	private void listarNombre(){
		ArrayList<Estadia> estadia=new ArrayList<Estadia>();
		String nombre=ventana.getEBuscarEstadia().getText();
		estadia=EstadiaDAO.buscarEstadia(nombre);
		DefaultTableModel modelo=(DefaultTableModel) ventana.getTableEstadia().getModel();
			Object[] fila=new Object[modelo.getColumnCount()];
			for (int i = 0; i <estadia.size(); i++) {					
				fila[0]=estadia.get(i).getCodigo();
				fila[1]=estadia.get(i).getCliente().getNombre();
				fila[2]=estadia.get(i).getHabitacion().getCodigo();
				fila[3]=estadia.get(i).getFechaEntrada();
				fila[4]=estadia.get(i).getHabitacion().getMontoDia();
				modelo.addRow(fila);
			}
			
}
	private void diferenciarDescuento() {
		double monto=0.0,desc=0.0;
		if (ventana.getEmontoDescue().getText().isEmpty()) {
			monto=Double.parseDouble(ventana.getEmonto().getText());
			desc=0.0;
			
			if (desc >= monto) {
				JOptionPane.showMessageDialog(null, "El descuento no debe ser Mayor al Monto.");
				ventana.getEmontoDescue().requestFocus();
				ventana.getEmontoTotal().setText("");
			} else {
				ventana.getBtnCierre_C().requestFocus();
		
			}
		} else {
			monto=Double.parseDouble(ventana.getEmonto().getText());
			desc=Double.parseDouble(ventana.getEmontoDescue().getText());
			if (desc >= monto) {
				JOptionPane.showMessageDialog(null, "El descuento no debe ser Mayor al Monto.");
				ventana.getEmontoDescue().requestFocus();
				ventana.getEmontoTotal().setText("");
			} else {
				ventana.getBtnCierre_C().requestFocus();
		
			}
		}
		

	}
	
	private void eliminarDetalleServicio() {
		Detalle detalle=new Detalle();	
		Integer fila =ventana.getTableDetalle().getSelectedRow();
		detalle.setCodigo(Integer.parseInt(ventana.getTableDetalle().getValueAt(fila,0).toString()));
        DetalleDAO.eliminarServicio(detalle);
	}
	public void centrarEstadia() {
		DefaultTableCellRenderer modelo=new DefaultTableCellRenderer();
		modelo.setHorizontalAlignment(SwingConstants.CENTER);
		ventana.getTableEstadia().getColumnModel().getColumn(0).setCellRenderer(modelo);
		ventana.getTableEstadia().getColumnModel().getColumn(2).setCellRenderer(modelo);
		ventana.getTableEstadia().getColumnModel().getColumn(3).setCellRenderer(modelo);
		ventana.getTableEstadia().getColumnModel().getColumn(4).setCellRenderer(modelo);
		ventana.getTableDetalle().getColumnModel().getColumn(0).setCellRenderer(modelo);
		ventana.getTableDetalle().getColumnModel().getColumn(1).setCellRenderer(modelo);
		ventana.getTableDetalle().getColumnModel().getColumn(2).setCellRenderer(modelo);
		ventana.getTableDetalle().getColumnModel().getColumn(4).setCellRenderer(modelo);

	}
	
	private void limpiarCampoEstadia() {
		ventana.getEcodigo().setText("");
		ventana.getEfecha().setText("");
		ventana.getECodCliente().setText("");
		FormEstadia.Enombre.setText("");
		ventana.getECodHab().setText("");
		ventana.getEobservacion().setText("");
		ventana.getEfechaSalida().setText("");
		ventana.getEmonto().setText("");
		ventana.getEmontoDescue().setText("");
		ventana.getEmontoTotal().setText("");
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(ventana.getBtnCancelar())) {
			limpiarCampo();
			limpiarTablaDetalle();
			ventana.getEcodigo().setText("");
			ventana.getEfecha().setText("");
			ventana.getEfechaSalida().setText("");
			ventana.getEmontoTotal().setText("");
			ventana.getBtnGuardar().setVisible(false);
		}
		
		if (e.getSource().equals(ventana.getBtnDetalle())) {
			int row =ventana.getTableEstadia().getSelectedRow();
			Boolean estado=Boolean.parseBoolean(ventana.getTableEstadia().getValueAt(row, 5).toString().trim());
			if (estado==false) {
				JOptionPane.showMessageDialog(null, "La estadia Cerrada Ya no puede Cargar Detalle");
			} else{
				FormDetalle f=new FormDetalle();
				f.setLocationRelativeTo(null);
				f.setVisible(true);
				pasarCampoTablaDetalleServicio();
			}
			
		}
		
		if (e.getSource().equals(ventana.getBtnCierre())) {
			int row =ventana.getTableEstadia().getSelectedRow();
			Boolean estado=Boolean.parseBoolean(ventana.getTableEstadia().getValueAt(row, 5).toString().trim());
			if (estado==false) {
				limpiarTablaDetalle();
				JOptionPane.showMessageDialog(null, "La estadia Cerrada No se puede Cerrar");
			} else{
				if (ventana.getEcodigo().getText().isEmpty() && ventana.getEfecha().getText().isEmpty() && ventana.getECodCliente().getText().isEmpty() && ventana.getECodHab().getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "El Campo no debe quedar Vacio");
				} else {
					habilitarCampoCierre();
					fecha();
					diferenciaDia();
					ventana.getEmontoDescue().requestFocus();
					ventana.getEfechaSalida().setEditable(true);
				}
			
			
			
		}

		}
		if (e.getSource().equals(ventana.getBtnNuevo())) {
			limpiarCampo();
			habilitarCampo();
			limpiarDetalle();
			obtenerUltimoId();
			this.ventana.getBtnGuardar().setVisible(true);
			this.ventana.getBtnBuscarCliente().setEnabled(true);
			this.ventana.getBtnBuscarHabitacion().setEnabled(true);
			this.ventana.getEfechaSalida().setEditable(false);
			this.ventana.getBtnEliminar().setVisible(false);
			this.ventana.getBtnModificar().setVisible(false);
			this.ventana.getEtotalServicio().setText("");
			this.ventana.getEfechaSalida().setText("");
			this.ventana.getBtnCierre().setVisible(false);
			fechaEstadia();
		
		}
		
		if (e.getSource().equals(ventana.getBtnInactivo())) {
			limpiarTabla();
			listarEstadiaInactivo();
			ventana.getBtnEliminar().setVisible(false);
			ventana.getBtnModificar().setVisible(false);
		}
		if (e.getSource().equals(ventana.getBtnTodos())) {
			limpiarTabla();
			listarEstadiaTodos();
		}
		if (e.getSource().equals(ventana.getBtnActivo())) {
			limpiarTabla();
			listarEstadia();
		}
		if (e.getSource().equals(ventana.getBtnCierre_C())) {
			if (JOptionPane.showConfirmDialog(new JDialog(),
					"¿Seguro que Quieres Cerrar","Salir",
					JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
				actualizar();
				
				}
			
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
			registrarEstadia();
			modificar=false;
		}
		if (e.getSource().equals(ventana.getBtnModificar())) {
			int row =ventana.getTableEstadia().getSelectedRow();
			Boolean estado=Boolean.parseBoolean(ventana.getTableEstadia().getValueAt(row, 5).toString().trim());
			if (estado==false) {
				JOptionPane.showMessageDialog(null, "La estadia Cerrada no se puede Modificar");
			} else{
			
			modificar=true;
			habilitarCampo();
			this.ventana.getBtnGuardar().setVisible(true);
			this.ventana.getBtnBuscarCliente().setVisible(true);
			this.ventana.getBtnBuscarHabitacion().setVisible(true);
			this.ventana.getBtnBuscarCliente().setEnabled(true);
			this.ventana.getBtnBuscarHabitacion().setEnabled(true);
			
		}
			}
		
		if (e.getSource().equals(ventana.getBtnEliminar())) {
			int row =ventana.getTableEstadia().getSelectedRow();
			Boolean estado=Boolean.parseBoolean(ventana.getTableEstadia().getValueAt(row, 5).toString().trim());
			if (estado==false) {
				JOptionPane.showMessageDialog(null, "La estadia Cerrada no se puede eliminar");
			} else{
			
			if (ventana.getEtotalServicio().getText().equals("0.0")) {
				if (JOptionPane.showConfirmDialog(new JDialog(),
						"¿Seguro que Quieres Eliminar","Salir",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
					eliminar();
					limpiarTabla();
					listarEstadia();
				}
			} else {
				JOptionPane.showMessageDialog(null, "No se puede Eliminar. Elimina primero Detalle.");
			}
			
		}
		}
		if (e.getSource().equals(ventana.getBtnSalir())) {
			if (JOptionPane.showConfirmDialog(new JDialog(),
					"¿Seguro que Quieres SALIR","Salir",
					JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
				this.ventana.dispose();
			}
		}
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getSource().equals(ventana.getEfechaSalida())) {
			if (e.getKeyCode()==KeyEvent.VK_ENTER) {
				diferenciaDiaModificable();
				
			}
		}
		
		if (e.getSource().equals(ventana.getTableDetalle())) {
			int row =ventana.getTableEstadia().getSelectedRow();
			Boolean estado=Boolean.parseBoolean(ventana.getTableEstadia().getValueAt(row, 5).toString().trim());
			if (estado==false) {
				JOptionPane.showMessageDialog(null, "La estadia Cerrada no se puede eliminar");
			} else{
			
			if(e.getKeyCode()==KeyEvent.VK_ENTER){
			if (JOptionPane.showConfirmDialog(new JDialog(),
					"¿Seguro que Quieres Eliminar","Salir",
					JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
				
					eliminarDetalleServicio();
					seleccionarFila();
				}
			}
			}
		}
		if (e.getSource().equals(ventana.getBtnCierre_C())) {
			if(e.getKeyCode()==KeyEvent.VK_ENTER){
				if (JOptionPane.showConfirmDialog(new JDialog(),
						"¿Seguro que Quieres Cerrar","Salir",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
					actualizar();
					
					}
				}
		}
		
		
		if(e.getSource().equals(ventana.getEBuscarEstadia())){
			limpiarTabla();
			listarNombre();
			
		
		}
		if(e.getSource().equals(ventana.getEmontoDescue())){
			if(e.getKeyCode()==KeyEvent.VK_ENTER){
				restaMontoDescuentos();
				diferenciarDescuento();
			}
		
		}
		
		if (e.getSource().equals(ventana.getBtnGuardar())) {
			if(e.getKeyCode()==KeyEvent.VK_ENTER){
			registrarEstadia();
			modificar=false;
		}
	}}

	@Override
	public void keyReleased(KeyEvent arg0) {
		
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		if (e.getSource().equals(ventana.getEmontoDescue())) {
			char car=e.getKeyChar();
			if(  ventana.getEmontoDescue().getText().length()>=10)e.consume();
			if((car<'0' || car>'9') ) e.consume();
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getClickCount()==1) {
			for (@SuppressWarnings("unused") int i : ventana.getTableEstadia().getSelectedRows()) {
		     seleccionarFila();
		     this.ventana.getBtnCierre().setVisible(true);
		     this.ventana.getBtnModificar().setVisible(true);
		     this.ventana.getBtnEliminar().setVisible(true);
		     ventana.getBtnCierre().requestFocus();
			}
	            
			
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getClickCount()==1) {
			for (@SuppressWarnings("unused") int i : ventana.getTableEstadia().getSelectedRows()) {
		     seleccionarFila();
		     this.ventana.getBtnCierre().setVisible(true);
		     this.ventana.getBtnModificar().setVisible(true);
		     this.ventana.getBtnEliminar().setVisible(true);
		     ventana.getBtnCierre().requestFocus();
			}
	            
			

		}
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		
	}

}
