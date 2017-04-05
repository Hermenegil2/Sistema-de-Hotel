package py.com.hoteleria.abm;
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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.border.TitledBorder;
import java.awt.Color;

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
	private JPanel panel_2;
	private JPanel panel_3;

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
		getContentPane().setBackground(SystemColor.activeCaption);
		setTitle("Formulario Habitacion");
		setBounds(100, 100,744, 550);
		getContentPane().setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Habitacion", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 255, 255)));
		panel_1.setBackground(SystemColor.activeCaption);
		panel_1.setBounds(10, 11, 708, 489);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Formulario", TitledBorder.CENTER, TitledBorder.TOP, null, SystemColor.window));
		panel.setBounds(10, 21, 685, 122);
		panel_1.add(panel);
		panel.setBackground(SystemColor.activeCaption);
		panel.setLayout(null);
		
		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setBounds(23, 25, 67, 28);
		lblCodigo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		panel.add(lblCodigo);
		
		hab_codigo = new JTextField();
		hab_codigo.setBounds(152, 25, 181, 30);
		hab_codigo.setEditable(false);
		hab_codigo.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel.add(hab_codigo);
		hab_codigo.setColumns(10);
		
		JLabel lblNombre = new JLabel("Descripcion de la \r\n\r");
		lblNombre.setBounds(23, 64, 119, 28);
		lblNombre.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		panel.add(lblNombre);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(152, 66, 181, 46);
		panel.add(scrollPane_1);
		
		hab_descripcion = new JTextField();
		hab_descripcion.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					hab_monto.requestFocus();
				}
			}
		});
		hab_descripcion.setEditable(false);
		hab_descripcion.setFont(new Font("Tahoma", Font.BOLD, 13));
		scrollPane_1.setViewportView(hab_descripcion);
		hab_descripcion.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Monto por Dia:");
		lblNewLabel.setBounds(343, 31, 108, 14);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		panel.add(lblNewLabel);
		
		hab_monto = new JTextField();
		hab_monto.setBounds(475, 25, 183, 30);
		hab_monto.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					hab_observacion.requestFocus();
				}
			}
		});
		hab_monto.setEditable(false);
		hab_monto.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel.add(hab_monto);
		hab_monto.setColumns(10);
		
		JLabel lblRuc = new JLabel("Observacion:");
		lblRuc.setBounds(348, 78, 119, 14);
		lblRuc.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		panel.add(lblRuc);
		
		JLabel lblHabitacion = new JLabel("Habitacion:");
		lblHabitacion.setBounds(23, 82, 119, 28);
		lblHabitacion.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		panel.add(lblHabitacion);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(475, 70, 185, 39);
		panel.add(scrollPane_2);
		
		hab_observacion = new JTextField();
		hab_observacion.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					btnGuardar.requestFocus();
				}
			}
		});
		hab_observacion.setEditable(false);
		hab_observacion.setFont(new Font("Tahoma", Font.BOLD, 13));
		scrollPane_2.setViewportView(hab_observacion);
		hab_observacion.setColumns(10);
		
		panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.activeCaption);
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Area de Botones", TitledBorder.CENTER, TitledBorder.TOP, null, SystemColor.window));
		panel_2.setBounds(10, 149, 685, 67);
		panel_1.add(panel_2);
		
		btnNuevo = new JButton("Nuevo");
		panel_2.add(btnNuevo);
		btnNuevo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		
		btnGuardar = new JButton("Guardar");
		panel_2.add(btnGuardar);
		btnGuardar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		
		btnModificar = new JButton("Modificar");
		panel_2.add(btnModificar);
		btnModificar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		
		btnEliminar = new JButton("Eliminar");
		panel_2.add(btnEliminar);
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		
		btnSalir = new JButton("Salir");
		panel_2.add(btnSalir);
		btnSalir.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		
		panel_3 = new JPanel();
		panel_3.setBackground(SystemColor.activeCaption);
		panel_3.setBorder(new TitledBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), "Area de Busqueda", TitledBorder.CENTER, TitledBorder.TOP, null, SystemColor.window));
		panel_3.setBounds(10, 225, 685, 253);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		hab_buscar = new JTextField();
		hab_buscar.setBounds(213, 26, 194, 32);
		panel_3.add(hab_buscar);
		hab_buscar.setFont(new Font("Tahoma", Font.BOLD, 13));
		hab_buscar.setColumns(10);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(423, 26, 97, 32);
		panel_3.add(btnBuscar);
		btnBuscar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 69, 665, 173);
		panel_3.add(scrollPane);
		
		tableHabitacion = new JTable();
		tableHabitacion.setToolTipText("Preciona Enter para modificar o para eliminar.");
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
		
		HabitacionController controlador=new HabitacionController(this);
		controlador.listarDescrip();
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
