package py.com.hoteleria.abm;
/**
 * @author Hermenegildo
 */
import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JLabel;
import py.com.hoteleria.controller.HabitacionController;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.UIManager;

@SuppressWarnings("serial")
public class FormHabitacion extends JDialog {
	private JTextField hab_codigo;
	private JTextField hab_descripcion;
	private JTextField hab_monto;
	private JButton btnSalir;
	private JButton btnGuardar;
	private JButton btnEliminar;
	private JButton btnModificar;
	private JButton btnNuevo;
	private JTextField hab_buscar;
	private JTable tableHabitacion;
	private JTextField hab_observacion;
	private JButton btnBuscar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormHabitacion dialog = new FormHabitacion();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
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
	public FormHabitacion() {
		setTitle("Formulario Habitacion");
		setBounds(100, 100,822, 500);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(0, 44, 806, 417);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblCodigo.setBounds(99, 24, 67, 28);
		panel.add(lblCodigo);
		
		hab_codigo = new JTextField();
		hab_codigo.setEditable(false);
		hab_codigo.setFont(new Font("Tahoma", Font.BOLD, 20));
		hab_codigo.setBounds(221, 25, 181, 30);
		panel.add(hab_codigo);
		hab_codigo.setColumns(10);
		
		JLabel lblNombre = new JLabel("Descripcion de la \r\n\r");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblNombre.setBounds(99, 63, 119, 28);
		panel.add(lblNombre);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(221, 66, 181, 46);
		panel.add(scrollPane_1);
		
		hab_descripcion = new JTextField();
		hab_descripcion.setEditable(false);
		hab_descripcion.setFont(new Font("Tahoma", Font.BOLD, 13));
		scrollPane_1.setViewportView(hab_descripcion);
		hab_descripcion.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Monto por Dia:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel.setBounds(412, 30, 108, 14);
		panel.add(lblNewLabel);
		
		hab_monto = new JTextField();
		hab_monto.setEditable(false);
		hab_monto.setFont(new Font("Tahoma", Font.BOLD, 13));
		hab_monto.setBounds(544, 24, 183, 30);
		panel.add(hab_monto);
		hab_monto.setColumns(10);
		
		JLabel lblRuc = new JLabel("Observacion:");
		lblRuc.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblRuc.setBounds(417, 77, 119, 14);
		panel.add(lblRuc);
		
		JLabel lblHabitacion = new JLabel("Habitacion:");
		lblHabitacion.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblHabitacion.setBounds(99, 81, 119, 28);
		panel.add(lblHabitacion);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(235, 123, 107, 29);
		panel.add(btnGuardar);
		btnGuardar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		
		btnSalir = new JButton("Salir");
		btnSalir.setBounds(643, 123, 79, 29);
		panel.add(btnSalir);
		btnSalir.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		
		btnNuevo = new JButton("Nuevo");
		btnNuevo.setBounds(109, 123, 97, 29);
		panel.add(btnNuevo);
		btnNuevo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(75, 223, 652, 183);
		panel.add(scrollPane);
		
		tableHabitacion = new JTable();
		tableHabitacion.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Codigo", "Descripcion", "Monto"
			}
		));
		tableHabitacion.getColumnModel().getColumn(0).setPreferredWidth(46);
		tableHabitacion.getColumnModel().getColumn(1).setPreferredWidth(340);
		scrollPane.setViewportView(tableHabitacion);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(371, 123, 109, 29);
		panel.add(btnModificar);
		btnModificar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(509, 123, 105, 29);
		panel.add(btnEliminar);
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		
		hab_buscar = new JTextField();
		hab_buscar.setFont(new Font("Tahoma", Font.BOLD, 13));
		hab_buscar.setBounds(235, 180, 194, 32);
		panel.add(hab_buscar);
		hab_buscar.setColumns(10);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		btnBuscar.setBounds(439, 180, 97, 32);
		panel.add(btnBuscar);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(544, 69, 185, 39);
		panel.add(scrollPane_2);
		
		hab_observacion = new JTextField();
		hab_observacion.setEditable(false);
		hab_observacion.setFont(new Font("Tahoma", Font.BOLD, 13));
		scrollPane_2.setViewportView(hab_observacion);
		hab_observacion.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(UIManager.getBorder("CheckBox.border"));
		panel_1.setBackground(SystemColor.activeCaption);
		panel_1.setBounds(0, 0, 806, 43);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Habitacion");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel_1.setBounds(331, 11, 144, 32);
		panel_1.add(lblNewLabel_1);
		
		HabitacionController controlador=new HabitacionController(this);
		controlador.listarHabitacion();
        controlador.ocultarBoton();
	}

	public JButton getBtnBuscar() {
		return btnBuscar;
	}

	public void setBtnBuscar(JButton btnBuscar) {
		this.btnBuscar = btnBuscar;
	}

	public JTextField getHab_buscar() {
		return hab_buscar;
	}

	public void setHab_buscar(JTextField hab_buscar) {
		this.hab_buscar = hab_buscar;
	}

	public JTable getTableHabitacion() {
		return tableHabitacion;
	}

	public void setTableHabitacion(JTable tableHabitacion) {
		this.tableHabitacion = tableHabitacion;
	}

	public JTextField getHabi_buscar() {
		return hab_buscar;
	}

	public void setHabi_buscar(JTextField habi_buscar) {
		this.hab_buscar = habi_buscar;
	}

	public JTextField getHab_codigo() {
		return hab_codigo;
	}

	public void setHab_codigo(JTextField hab_codigo) {
		this.hab_codigo = hab_codigo;
	}

	public JTextField getHab_descripcion() {
		return hab_descripcion;
	}

	public void setHab_descripcion(JTextField hab_descripcion) {
		this.hab_descripcion = hab_descripcion;
	}

	public JTextField getHab_monto() {
		return hab_monto;
	}

	public void setHab_monto(JTextField hab_monto) {
		this.hab_monto = hab_monto;
	}

	public JTextField getHab_observacion() {
		return hab_observacion;
	}

	public void setHab_observacion(JTextField hab_observacion) {
		this.hab_observacion = hab_observacion;
	}

	public JButton getBtnSalir() {
		return btnSalir;
	}

	public void setBtnSalir(JButton btnSalir) {
		this.btnSalir = btnSalir;
	}

	public JButton getBtnGuardar() {
		return btnGuardar;
	}

	public void setBtnGuardar(JButton btnGuardar) {
		this.btnGuardar = btnGuardar;
	}

	public JButton getBtnEliminar() {
		return btnEliminar;
	}

	public void setBtnEliminar(JButton btnEliminar) {
		this.btnEliminar = btnEliminar;
	}

	public JButton getBtnModificar() {
		return btnModificar;
	}

	public void setBtnModificar(JButton btnModificar) {
		this.btnModificar = btnModificar;
	}

	public JButton getBtnNuevo() {
		return btnNuevo;
	}

	public void setBtnNuevo(JButton btnNuevo) {
		this.btnNuevo = btnNuevo;
	}
	
}
