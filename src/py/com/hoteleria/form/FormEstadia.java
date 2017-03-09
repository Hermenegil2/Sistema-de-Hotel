package py.com.hoteleria.form;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.UIManager;

import py.com.hoteleria.controller.EstadiaController;
import py.com.hoteleria.controller.FechaController;
import py.com.hoteleria.controller.resta_fechas;

import java.awt.SystemColor;

import com.toedter.calendar.JDateChooser;

import java.awt.Color;

import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Date;
import java.util.Calendar;

@SuppressWarnings("serial")
public class FormEstadia extends JDialog {
	private JTextField Ecodigo;
	public static JTextField ECodCliente;
	public static JTextField ECodHab;
	private JTextField Emonto;
	private JTextField EmontoDescue;
	private JTextField Eobservacion;
	private JTable tableEstadia;
	private JTextField textField;
	private JButton btnNuevo;
	private JButton btnGuardar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnCerrar;
	private JButton btnBuscar_2;
	private JButton btnBuscarCliente;
	private JButton btnBuscarHabita;
	private JDateChooser EfechaEntrada;
	private JDateChooser EfechaSalida;
	public static JTextField Enombre;
	private JTextField Ecosto;
	private JButton btnDetalle;
	private JTable tableDetalle;
	private JTextField EtotalServicio;
	private JTextField Etotal;
	private JTextField Eservicio;
	private JButton btnCierre_1;
	private JButton btnAtras;
	private JButton btnActivo;
	private JButton btnInactivo;
	private JButton btnTodos;
	private JButton btnCierre;
	private JButton btnCancelar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormEstadia dialog = new FormEstadia();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setLocationRelativeTo(null);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public FormEstadia() {
		setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
		setTitle("Formulario de Estadia");
		setBounds(100, 100,800, 600);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(6, 0, 0, 0));
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(0, 43, 784, 514);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(10, 264, 247, 30);
		panel.add(textField);
		textField.setColumns(10);
		
		btnBuscar_2 = new JButton("Buscar");
		btnBuscar_2.setBounds(264, 263, 100, 33);
		panel.add(btnBuscar_2);
		btnBuscar_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setEnabled(false);
		scrollPane.setBounds(6, 6, 358, 220);
		panel.add(scrollPane);
		
		tableEstadia = new JTable();
		tableEstadia.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nro. Estadia", "Clientes", "Habitacion", "F. Entrada", "Monto"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tableEstadia.getColumnModel().getColumn(0).setResizable(false);
		tableEstadia.getColumnModel().getColumn(1).setResizable(false);
		tableEstadia.getColumnModel().getColumn(2).setResizable(false);
		tableEstadia.getColumnModel().getColumn(3).setResizable(false);
		tableEstadia.getColumnModel().getColumn(4).setResizable(false);
		scrollPane.setViewportView(tableEstadia);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_2.setBounds(487, 5, 291, 211);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setBounds(6, 20, 100, 14);
		panel_2.add(lblCodigo);
		lblCodigo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		
		JLabel lblObservacionDeLa = new JLabel("Obs. :");
		lblObservacionDeLa.setBounds(6, 180, 100, 14);
		panel_2.add(lblObservacionDeLa);
		lblObservacionDeLa.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		
		JLabel lblNombre = new JLabel("F. Entrada:");
		lblNombre.setBounds(6, 52, 100, 14);
		panel_2.add(lblNombre);
		lblNombre.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		
		JLabel lblNewLabel = new JLabel("Cliente:");
		lblNewLabel.setBounds(6, 84, 100, 14);
		panel_2.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		
		JLabel lblRuc = new JLabel("Habitacion:");
		lblRuc.setBounds(6, 116, 100, 14);
		panel_2.add(lblRuc);
		lblRuc.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		
		JLabel lblCostoXHab = new JLabel("Monto:");
		lblCostoXHab.setBounds(6, 148, 100, 14);
		panel_2.add(lblCostoXHab);
		lblCostoXHab.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		
		Ecodigo = new JTextField();
		Ecodigo.setBounds(109, 6, 176, 30);
		panel_2.add(Ecodigo);
		Ecodigo.setEditable(false);
		Ecodigo.setColumns(10);
		
		EfechaEntrada = new JDateChooser();
		EfechaEntrada.getCalendarButton().setEnabled(false);
		EfechaEntrada.setBounds(109, 40, 176, 30);
		panel_2.add(EfechaEntrada);
		
		Enombre = new JTextField();
		Enombre.setEditable(false);
		Enombre.setBounds(109, 74, 140, 30);
		panel_2.add(Enombre);
		Enombre.setColumns(10);
		
		btnBuscarCliente = new JButton("Buscar");
		btnBuscarCliente.setEnabled(false);
		btnBuscarCliente.setBounds(251, 74, 34, 30);
		panel_2.add(btnBuscarCliente);
		btnBuscarCliente.setBackground(Color.LIGHT_GRAY);
		btnBuscarCliente.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		ECodHab = new JTextField();
		ECodHab.setEditable(false);
		ECodHab.setBounds(109, 108, 140, 30);
		panel_2.add(ECodHab);
		ECodHab.setColumns(10);
		
		btnBuscarHabita = new JButton("Buscar");
		btnBuscarHabita.setEnabled(false);
		btnBuscarHabita.setBounds(251, 108, 34, 30);
		panel_2.add(btnBuscarHabita);
		btnBuscarHabita.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(109, 176, 176, 30);
		panel_2.add(scrollPane_1);
		
		Eobservacion = new JTextField();
		Eobservacion.setEditable(false);
		scrollPane_1.setViewportView(Eobservacion);
		Eobservacion.setColumns(10);
		
		ECodCliente = new JTextField();
		ECodCliente.setBounds(234, 77, 20, 21);
		panel_2.add(ECodCliente);
		ECodCliente.setColumns(10);
		
		ECodCliente.setVisible(false);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(SystemColor.activeCaption);
		panel_3.setBounds(361, 6, 128, 267);
		panel.add(panel_3);
		
		btnNuevo = new JButton("Nuevo");
		panel_3.add(btnNuevo);
		btnNuevo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		
		btnGuardar = new JButton("Guardar");
		panel_3.add(btnGuardar);
		btnGuardar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		
		btnModificar = new JButton("Modificar");
		panel_3.add(btnModificar);
		btnModificar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		
		btnEliminar = new JButton("Eliminar");
		panel_3.add(btnEliminar);
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		
		btnCancelar = new JButton("Cancelar");
		panel_3.add(btnCancelar);
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		
		btnCerrar = new JButton("Salir");
		panel_3.add(btnCerrar);
		btnCerrar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		
		btnCierre = new JButton("Cierre");
		panel_3.add(btnCierre);
		btnCierre.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		
		btnDetalle = new JButton("Detalle");
		btnDetalle.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		btnDetalle.setBounds(487, 228, 291, 32);
		panel.add(btnDetalle);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(393, 272, 385, 193);
		panel.add(scrollPane_2);
		
		tableDetalle = new JTable();
		tableDetalle.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Codigo", "Estadia", "CodSer", "DescriSer", "Monto"
			}
		));
		scrollPane_2.setViewportView(tableDetalle);
		
		JLabel lblTotalServicio = new JLabel("Total Servicio:");
		lblTotalServicio.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblTotalServicio.setBounds(403, 477, 166, 27);
		panel.add(lblTotalServicio);
		
		EtotalServicio = new JTextField();
		EtotalServicio.setEditable(false);
		EtotalServicio.setFont(new Font("SansSerif", Font.BOLD, 16));
		EtotalServicio.setColumns(10);
		EtotalServicio.setBounds(554, 477, 224, 30);
		panel.add(EtotalServicio);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(10, 303, 350, 162);
		panel.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblDireccion = new JLabel("F. Salida:");
		lblDireccion.setBounds(6, 6, 122, 14);
		panel_4.add(lblDireccion);
		lblDireccion.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		
		JLabel lblHabitacion = new JLabel("Monto:");
		lblHabitacion.setBounds(6, 32, 122, 14);
		panel_4.add(lblHabitacion);
		lblHabitacion.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		
		JLabel lblServicio = new JLabel("Servicio:");
		lblServicio.setBounds(6, 58, 122, 14);
		panel_4.add(lblServicio);
		lblServicio.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		
		JLabel lblMontoDeDescuento = new JLabel("Descuento:");
		lblMontoDeDescuento.setBounds(6, 85, 86, 14);
		panel_4.add(lblMontoDeDescuento);
		lblMontoDeDescuento.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		
		JLabel lblMontoTotal = new JLabel("Total:");
		lblMontoTotal.setBounds(6, 116, 122, 14);
		panel_4.add(lblMontoTotal);
		lblMontoTotal.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		
		EmontoDescue = new JTextField();
		EmontoDescue.setEditable(false);
		EmontoDescue.setBounds(104, 84, 240, 26);
		panel_4.add(EmontoDescue);
		EmontoDescue.setColumns(10);
		
		EfechaSalida = new JDateChooser();
		EfechaSalida.getCalendarButton().setEnabled(false);
		EfechaSalida.setBounds(104, 6, 188, 26);
		panel_4.add(EfechaSalida);
		
		Etotal = new JTextField();
		Etotal.setEditable(false);
		Etotal.setColumns(10);
		Etotal.setBounds(104, 111, 240, 26);
		panel_4.add(Etotal);
		
		Eservicio = new JTextField();
		Eservicio.setEditable(false);
		Eservicio.setColumns(10);
		Eservicio.setBounds(104, 58, 240, 26);
		panel_4.add(Eservicio);
		
		btnCierre_1 = new JButton("Cierre");
		btnCierre_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
			}

			
		});
		btnCierre_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		btnCierre_1.setBounds(10, 472, 100, 32);
		panel.add(btnCierre_1);
		
		btnAtras = new JButton("Atras");
		
		
		btnAtras.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		btnAtras.setBounds(264, 472, 96, 32);
		panel.add(btnAtras);
		
		btnActivo = new JButton("Activo");
		btnActivo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		btnActivo.setBounds(30, 228, 96, 32);
		panel.add(btnActivo);
		
		btnInactivo = new JButton("Inactivo");
		btnInactivo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		btnInactivo.setBounds(144, 228, 110, 32);
		panel.add(btnInactivo);
		
		btnTodos = new JButton("Todo");
		btnTodos.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		btnTodos.setBounds(276, 228, 78, 32);
		panel.add(btnTodos);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(UIManager.getBorder("DesktopIcon.border"));
		panel_1.setBackground(SystemColor.activeCaption);
		panel_1.setBounds(0, 0, 984, 42);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblEstada = new JLabel("Estad\u00EDa");
		lblEstada.setBounds(355, 11, 104, 31);
		lblEstada.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		panel_1.add(lblEstada);
		
		
		EstadiaController contro=new EstadiaController(this);
		contro.listarEstadia();
		contro.ocultarBoton();
		
		EfechaEntrada.setEnabled(false);
		EfechaSalida.setEnabled(false);
		
		Emonto = new JTextField();
		Emonto.setBounds(109, 142, 176, 26);
		panel_2.add(Emonto);
		Emonto.setEditable(false);
		Emonto.setColumns(10);
		EfechaSalida.setEnabled(false);
		
		Ecosto = new JTextField();
		Ecosto.setBounds(104, 32, 240, 26);
		panel_4.add(Ecosto);
		Ecosto.setEditable(false);
		Ecosto.setColumns(10);
		
		FechaController controller=new FechaController(this);
		
		resta_fechas control=new resta_fechas(this);
		
	}

	
	

	public JButton getBtnDetalle() {
		return btnDetalle;
	}

	public void setBtnDetalle(JButton btnDetalle) {
		this.btnDetalle = btnDetalle;
	}

	public JTable getTableDetalle() {
		return tableDetalle;
	}

	public void setTableDetalle(JTable tableDetalle) {
		this.tableDetalle = tableDetalle;
	}

	public JButton getBtnBuscarCliente() {
		return btnBuscarCliente;
	}

	public void setBtnBuscarCliente(JButton btnBuscarCliente) {
		this.btnBuscarCliente = btnBuscarCliente;
	}

	public JButton getBtnBuscarHabitacion() {
		return btnBuscarHabita;
	}

	public void setBtnBuscarHabitacion(JButton btnBuscarHabitacion) {
		this.btnBuscarHabita = btnBuscarHabitacion;
	}

	public JTable getTableEstadia() {
		return tableEstadia;
	}

	public void setTableEstadia(JTable tableEstadia) {
		this.tableEstadia = tableEstadia;
	}

	public JButton getBtnNuevo() {
		return btnNuevo;
	}

	public void setBtnNuevo(JButton btnNuevo) {
		this.btnNuevo = btnNuevo;
	}

	public JButton getBtnGuardar() {
		return btnGuardar;
	}

	public void setBtnGuardar(JButton btnGuardar) {
		this.btnGuardar = btnGuardar;
	}

	public JButton getBtnModificar() {
		return btnModificar;
	}

	public void setBtnModificar(JButton btnModificar) {
		this.btnModificar = btnModificar;
	}

	public JButton getBtnEliminar() {
		return btnEliminar;
	}

	public void setBtnEliminar(JButton btnEliminar) {
		this.btnEliminar = btnEliminar;
	}

	public JButton getBtnCerrar() {
		return btnCerrar;
	}

	public void setBtnCerrar(JButton btnCerrar) {
		this.btnCerrar = btnCerrar;
	}

	public JButton getBtnBuscar_2() {
		return btnBuscar_2;
	}

	public void setBtnBuscar_2(JButton btnBuscar_2) {
		this.btnBuscar_2 = btnBuscar_2;
	}

	public JTextField getEcodigo() {
		return Ecodigo;
	}

	public void setEcodigo(JTextField ecodigo) {
		Ecodigo = ecodigo;
	}


	public JTextField getECodCliente() {
		return ECodCliente;
	}

	public void setECodCliente(JTextField eCodCliente) {
		ECodCliente = eCodCliente;
	}

	public JTextField getECodHab() {
		return ECodHab;
	}

	public void setECodHab(JTextField eCodHab) {
		ECodHab = eCodHab;
	}
	

	public JTextField getEmonto() {
		return Emonto;
	}

	public void setEmonto(JTextField emonto) {
		Emonto = emonto;
	}

	public JTextField getEmontoDescue() {
		return EmontoDescue;
	}

	public void setEmontoDescue(JTextField emontoDescue) {
		EmontoDescue = emontoDescue;
	}

	public JTextField getEobservacion() {
		return Eobservacion;
	}

	public void setEobservacion(JTextField eobservacion) {
		Eobservacion = eobservacion;
	}


	public JDateChooser getEfechaEntrada() {
		return EfechaEntrada;
	}

	public void setEfechaEntrada(JDateChooser efechaEntrada) {
		EfechaEntrada = efechaEntrada;
	}

	public JDateChooser getEfechaSalida() {
		return EfechaSalida;
	}

	public void setEfechaSalida(JDateChooser efechaSalida) {
		EfechaSalida = efechaSalida;
	}

	public JTextField getEcosto() {
		return Ecosto;
	}

	public JButton getBtnActivo() {
		return btnActivo;
	}

	public void setBtnActivo(JButton btnActivo) {
		this.btnActivo = btnActivo;
	}

	public JButton getBtnInactivo() {
		return btnInactivo;
	}

	public void setBtnInactivo(JButton btnInactivo) {
		this.btnInactivo = btnInactivo;
	}

	public JButton getBtnTodos() {
		return btnTodos;
	}

	public void setBtnTodos(JButton btnTodos) {
		this.btnTodos = btnTodos;
	}

	public void setEcosto(JTextField ecosto) {
		Ecosto = ecosto;
	}

	public JButton getBtnCierre_1() {
		return btnCierre_1;
	}

	public void setBtnCierre_1(JButton btnCierre_1) {
		this.btnCierre_1 = btnCierre_1;
	}

	public JTextField getEtotalServicio() {
		return EtotalServicio;
	}

	public void setEtotalServicio(JTextField etotalServicio) {
		EtotalServicio = etotalServicio;
	}

	public JButton getBtnAtras() {
		return btnAtras;
	}

	public void setBtnAtras(JButton btnAtras) {
		this.btnAtras = btnAtras;
	
}

	public JTextField getEtotal() {
		return Etotal;
	}

	public void setEtotal(JTextField etotal) {
		Etotal = etotal;
	}

	public JTextField getEservicio() {
		return Eservicio;
	}

	public void setEservicio(JTextField eservicio) {
		Eservicio = eservicio;
	}

	public JButton getBtnCierre() {
		return btnCierre;
	}

	public void setBtnCierre(JButton btnCierre) {
		this.btnCierre = btnCierre;
	}

	public JButton getBtnCancelar() {
		return btnCancelar;
	}

	public void setBtnCancelar(JButton btnCancelar) {
		this.btnCancelar = btnCancelar;
	}
	
	
	
	
}
