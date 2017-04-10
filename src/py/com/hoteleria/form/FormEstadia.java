package py.com.hoteleria.form;
/**
 * @author Hermenegil2
 * 
 */
import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;

import py.com.hoteleria.controller.EstadiaController;

import java.awt.SystemColor;
import java.awt.Color;

import javax.swing.JTabbedPane;
import javax.swing.border.TitledBorder;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.ParseException;



@SuppressWarnings("serial")
public class FormEstadia extends JDialog {
	private JTextField Ecodigo;
	public static JTextField ECodCliente;
	public static JTextField ECodHab;
	private JTextField Emonto;
	private JTextField EmontoDescue;
	private JTextField Eobservacion;
	private JTable tableEstadia;
	private JTextField EBuscarEstadia;
	private JButton btnNuevo;
	private JButton btnGuardar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnSalir;
	private JButton btnBuscar_2;
	private JButton btnBuscarCliente;
	private JButton btnBuscarHabita;
	public static JTextField Enombre;
	private JButton btnDetalle;
	public static JTable tableDetalle;
	private JTextField EtotalServicio;
	private JButton btnActivo;
	private JButton btnInactivo;
	private JButton btnTodos;
	private JButton btnCierre;
	private JButton btnCancelar;
	private JFormattedTextField EfechaSalida;
	private JTabbedPane tabbedPane;
	private JPanel panel_6;
	private JButton btnCierre_C;
	private JFormattedTextField Efecha;
	public static JTextField EmontoTotal;
	private MaskFormatter formatoFechaEntrada;
	private MaskFormatter formatoFechaSalida;
	

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
		setType(Type.POPUP);
		getContentPane().setBackground(SystemColor.activeCaption);
		setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
		setTitle("Formulario de Estadia");
		setBounds(100, 100,928, 731);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Estadia", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(6, 6, 895, 680);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		panel_6 = new JPanel();
		panel_6.setBackground(SystemColor.activeCaption);
		panel_6.setBorder(new TitledBorder(null, "Area de Vista", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)));
		panel_6.setBounds(15, 24, 511, 287);
		panel.add(panel_6);
		panel_6.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(14, 18, 487, 165);
		panel_6.add(scrollPane);
		scrollPane.setEnabled(false);
		
		tableEstadia = new JTable();
		tableEstadia.setToolTipText("");
		tableEstadia.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nro. Estadia", "Clientes", "Habitacion", "F. Entrada", "Monto", "Estado"
			}
		) {
			@SuppressWarnings("rawtypes")
			Class[] columnTypes = new Class[] {
				Object.class, Object.class, Object.class, Object.class, Object.class, Boolean.class
			};
			@SuppressWarnings({ "unchecked", "rawtypes" })
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tableEstadia.getColumnModel().getColumn(0).setResizable(false);
		tableEstadia.getColumnModel().getColumn(0).setPreferredWidth(44);
		tableEstadia.getColumnModel().getColumn(1).setResizable(false);
		tableEstadia.getColumnModel().getColumn(1).setPreferredWidth(145);
		tableEstadia.getColumnModel().getColumn(2).setResizable(false);
		tableEstadia.getColumnModel().getColumn(2).setPreferredWidth(41);
		tableEstadia.getColumnModel().getColumn(3).setResizable(false);
		tableEstadia.getColumnModel().getColumn(4).setResizable(false);
		tableEstadia.getColumnModel().getColumn(5).setResizable(false);
		scrollPane.setViewportView(tableEstadia);
		
		btnActivo = new JButton("Activo");
		btnActivo.setBounds(56, 192, 96, 32);
		panel_6.add(btnActivo);
		btnActivo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		
		btnInactivo = new JButton("Inactivo");
		btnInactivo.setBounds(208, 192, 110, 32);
		panel_6.add(btnInactivo);
		btnInactivo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		
		btnTodos = new JButton("Todo");
		btnTodos.setBounds(374, 192, 78, 32);
		panel_6.add(btnTodos);
		btnTodos.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		
		EBuscarEstadia = new JTextField();
		EBuscarEstadia.setBounds(163, 227, 338, 43);
		panel_6.add(EBuscarEstadia);
		EBuscarEstadia.setColumns(10);
		
		btnBuscar_2 = new JButton("Buscar");
		btnBuscar_2.setIcon(new ImageIcon("C:\\Users\\Hermenegil2\\Desktop\\Sistema de Hotel\\icono\\Icono_Buscar.png"));
		btnBuscar_2.setBounds(14, 225, 145, 45);
		panel_6.add(btnBuscar_2);
		btnBuscar_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.activeCaption);
		panel_2.setBorder(new TitledBorder(null, "Area de Trabajo", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)));
		panel_2.setBounds(538, 24, 341, 211);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setBounds(6, 23, 92, 14);
		panel_2.add(lblCodigo);
		lblCodigo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		
		JLabel lblObservacionDeLa = new JLabel("Obs. :");
		lblObservacionDeLa.setBounds(6, 171, 92, 14);
		panel_2.add(lblObservacionDeLa);
		lblObservacionDeLa.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		
		JLabel lblNewLabel = new JLabel("Cliente:");
		lblNewLabel.setBounds(6, 97, 92, 14);
		panel_2.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		
		JLabel lblRuc = new JLabel("Habitacion:");
		lblRuc.setBounds(6, 134, 84, 14);
		panel_2.add(lblRuc);
		lblRuc.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		
		Ecodigo = new JTextField();
		Ecodigo.setBounds(91, 18, 240, 30);
		panel_2.add(Ecodigo);
		Ecodigo.setEditable(false);
		Ecodigo.setColumns(10);
		
		Enombre = new JTextField();
		Enombre.setEditable(false);
		Enombre.setBounds(91, 90, 136, 30);
		panel_2.add(Enombre);
		Enombre.setColumns(10);
		
		btnBuscarCliente = new JButton("");
		btnBuscarCliente.setIcon(new ImageIcon("C:\\Users\\Hermenegil2\\Desktop\\Sistema de Hotel\\icono\\Buscar-Clientes.png"));
		btnBuscarCliente.setBounds(267, 79, 64, 44);
		panel_2.add(btnBuscarCliente);
		btnBuscarCliente.setBackground(Color.LIGHT_GRAY);
		btnBuscarCliente.setFont(new Font("Tahoma", Font.BOLD, 5));
		
		ECodHab = new JTextField();
		ECodHab.setEditable(false);
		ECodHab.setBounds(91, 130, 174, 30);
		panel_2.add(ECodHab);
		ECodHab.setColumns(10);
		
		btnBuscarHabita = new JButton("");
		btnBuscarHabita.setIcon(new ImageIcon("C:\\Users\\Hermenegil2\\Desktop\\Sistema de Hotel\\icono\\Icono_Buscar.png"));
		btnBuscarHabita.setBounds(267, 128, 64, 42);
		panel_2.add(btnBuscarHabita);
		btnBuscarHabita.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(91, 170, 240, 30);
		panel_2.add(scrollPane_1);
		
		Eobservacion = new JTextField();
		Eobservacion.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					btnGuardar.requestFocus();
				}
			}
		});
		Eobservacion.setEditable(false);
		scrollPane_1.setViewportView(Eobservacion);
		Eobservacion.setColumns(10);
		
		ECodCliente = new JTextField();
		ECodCliente.setEditable(false);
		ECodCliente.setBounds(225, 90, 40, 30);
		panel_2.add(ECodCliente);
		ECodCliente.setColumns(10);
		
		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblFecha.setBounds(6, 60, 92, 14);
		panel_2.add(lblFecha);
		
		Efecha = new JFormattedTextField(formatearFecha());
		Efecha.setFont(new Font("SansSerif", Font.BOLD, 14));
		Efecha.setColumns(10);
		Efecha.setBounds(91, 50, 240, 30);
		panel_2.add(Efecha);
		
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "Area de Botones", TitledBorder.CENTER, TitledBorder.TOP, null, SystemColor.window));
		panel_3.setBackground(SystemColor.activeCaption);
		panel_3.setBounds(15, 324, 864, 108);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setToolTipText("Modificar");
		btnModificar.setBounds(35, 17, 120, 80);
		panel_3.add(btnModificar);
		btnModificar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(190, 17, 120, 80);
		panel_3.add(btnEliminar);
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		
		btnSalir = new JButton("Salir");
		btnSalir.setToolTipText("Salir");
		btnSalir.setBounds(753, 17, 77, 80);
		panel_3.add(btnSalir);
		btnSalir.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		
		btnCierre = new JButton("Cierre de la Estadia");
		btnCierre.setBounds(345, 17, 196, 80);
		panel_3.add(btnCierre);
		btnCierre.setToolTipText("Preciona el Cierre Para Saber el Monto Total");
		btnCierre.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		btnDetalle = new JButton("Detalle");
		btnDetalle.setBounds(576, 17, 142, 80);
		panel_3.add(btnDetalle);
		btnDetalle.setIcon(new ImageIcon("C:\\Users\\Hermenegil2\\Desktop\\Sistema de Hotel\\icono\\View_Details-.png"));
		btnDetalle.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(394, 444, 472, 193);
		panel.add(tabbedPane);
		
		JPanel panel_8 = new JPanel();
		tabbedPane.addTab("Detalle del Servicio", null, panel_8, null);
		panel_8.setLayout(null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(6, 0, 460, 116);
		panel_8.add(scrollPane_2);
		
		tableDetalle = new JTable();
		tableDetalle.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Codigo", "Estadia", "CodSer", "DescriSer", "Monto"
			}
		) {
			@SuppressWarnings("rawtypes")
			Class[] columnTypes = new Class[] {
				Object.class, Object.class, Object.class, Object.class, Double.class
			};
			@SuppressWarnings({ "unchecked", "rawtypes" })
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane_2.setViewportView(tableDetalle);
		
		JLabel lblTotalServicio = new JLabel("Total Servicio:");
		lblTotalServicio.setBounds(6, 128, 166, 27);
		panel_8.add(lblTotalServicio);
		lblTotalServicio.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		
		EtotalServicio = new JTextField();
		EtotalServicio.setBounds(169, 127, 297, 30);
		panel_8.add(EtotalServicio);
		EtotalServicio.setHorizontalAlignment(SwingConstants.CENTER);
		EtotalServicio.setEditable(false);
		EtotalServicio.setFont(new Font("SansSerif", Font.BOLD, 16));
		EtotalServicio.setColumns(10);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(null, "Area de Deuda", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)));
		panel_4.setBackground(SystemColor.activeCaption);
		panel_4.setBounds(15, 434, 350, 237);
		panel.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblDireccion = new JLabel("F. Salida:");
		lblDireccion.setBounds(6, 30, 122, 14);
		panel_4.add(lblDireccion);
		lblDireccion.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		
		JLabel lblMontoDeDescuento = new JLabel("Descuento:");
		lblMontoDeDescuento.setBounds(6, 93, 86, 14);
		panel_4.add(lblMontoDeDescuento);
		lblMontoDeDescuento.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		
		EmontoDescue = new JTextField();
		EmontoDescue.setHorizontalAlignment(SwingConstants.CENTER);
		EmontoDescue.setFont(new Font("SansSerif", Font.BOLD, 14));
		EmontoDescue.setEditable(false);
		EmontoDescue.setBounds(104, 87, 229, 26);
		panel_4.add(EmontoDescue);
		EmontoDescue.setColumns(10);
		
		Emonto = new JTextField();
		Emonto.setHorizontalAlignment(SwingConstants.CENTER);
		Emonto.setFont(new Font("SansSerif", Font.BOLD, 14));
		Emonto.setBounds(104, 56, 229, 26);
		panel_4.add(Emonto);
		Emonto.setEditable(false);
		Emonto.setColumns(10);
		
		JLabel lblCostoXHab = new JLabel("Monto:");
		lblCostoXHab.setBounds(6, 56, 100, 14);
		panel_4.add(lblCostoXHab);
		lblCostoXHab.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		
		EfechaSalida = new JFormattedTextField(formatearFechaS());
		EfechaSalida.setFont(new Font("SansSerif", Font.BOLD, 14));
		EfechaSalida.setHorizontalAlignment(SwingConstants.CENTER);
		EfechaSalida.setColumns(10);
		EfechaSalida.setBounds(104, 24, 229, 26);
		panel_4.add(EfechaSalida);
		
		btnCierre_C = new JButton("Cerrar");
		btnCierre_C.setBounds(16, 160, 317, 59);
		panel_4.add(btnCierre_C);
		
		JLabel label = new JLabel("Monto Total:");
		label.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		label.setBounds(6, 125, 100, 14);
		panel_4.add(label);
		
		EmontoTotal = new JTextField();
		EmontoTotal.setHorizontalAlignment(SwingConstants.CENTER);
		EmontoTotal.setFont(new Font("SansSerif", Font.BOLD, 14));
		EmontoTotal.setEditable(false);
		EmontoTotal.setColumns(10);
		EmontoTotal.setBounds(104, 119, 229, 26);
		panel_4.add(EmontoTotal);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(SystemColor.activeCaption);
		panel_7.setBorder(new TitledBorder(null, "Area de Vista", TitledBorder.CENTER, TitledBorder.TOP, null, SystemColor.window));
		panel_7.setBounds(381, 434, 498, 237);
		panel.add(panel_7);
		panel_7.setLayout(null);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(651, 247, 112, 64);
		panel.add(btnGuardar);
		btnGuardar.setToolTipText("Guardar");
		btnGuardar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(767, 247, 112, 64);
		panel.add(btnCancelar);
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		
		btnNuevo = new JButton("Nuevo");
		btnNuevo.setBounds(548, 247, 102, 64);
		panel.add(btnNuevo);
		btnNuevo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		
		EstadiaController contro=new EstadiaController(this);
		contro.listarEstadia();
		contro.ocultarBoton();
		contro.centrarEstadia();
		
	
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

	@SuppressWarnings("static-access")
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

	public JButton getBtnSalir() {
		return btnSalir;
	}

	public void setBtnSalir(JButton btnSalir) {
		this.btnSalir = btnSalir;
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




	
	

	public JTextField getEfechaSalida() {
		return EfechaSalida;
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

	public JTextField getEtotalServicio() {
		return EtotalServicio;
	}

	public void setEtotalServicio(JTextField etotalServicio) {
		EtotalServicio = etotalServicio;
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

	

	public JButton getBtnCierre_C() {
		return btnCierre_C;
	}

	public void setBtnCierre_C(JButton btnCierre_C) {
		this.btnCierre_C = btnCierre_C;
	}

	public JTextField getEfecha() {
		return Efecha;
	}

	

	public JTextField getEmontoTotal() {
		return EmontoTotal;
	}

	public void setEmontoTotal(JTextField emontoTotal) {
		EmontoTotal = emontoTotal;
	}

	public JTextField getEBuscarEstadia() {
		return EBuscarEstadia;
	}

	public void setEBuscarEstadia(JTextField eBuscarEstadia) {
		EBuscarEstadia = eBuscarEstadia;
	}
	 private MaskFormatter formatearFecha() {
			if (formatoFechaEntrada==null) {
				try {
					formatoFechaEntrada = new MaskFormatter("##/##/####");
					formatoFechaEntrada.setPlaceholderCharacter('_');
				} catch (ParseException e) {
					
					e.printStackTrace();
				}
				
				
			}
		return formatoFechaEntrada;
		}
	 private MaskFormatter formatearFechaS() {
			if (formatoFechaSalida==null) {
				try {
					formatoFechaSalida = new MaskFormatter("##/##/####");
					formatoFechaSalida.setPlaceholderCharacter('_');
				} catch (ParseException e) {
					
					e.printStackTrace();
				}
				
				
			}
		return formatoFechaSalida;
		}
}
