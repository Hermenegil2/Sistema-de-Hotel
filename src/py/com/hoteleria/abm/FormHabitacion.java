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

import java.awt.Color;
import javax.swing.JLabel;
import py.com.hoteleria.controller.HabitacionController;

import java.awt.Font;
import java.awt.SystemColor;

@SuppressWarnings("serial")
public class FormHabitacion extends JDialog {
	private JTable table_habitacion;
	private JTextField hab_codigo;
	private JTextField hab_descripcion;
	private JTextField hab_monto;
	private JTextField hab_observacion;
	private JButton btnSalir;
	private JButton btnCancelar;
	private JButton btnGuardar;
	private JButton btnEliminar;
	private JButton btnModificar;
	private JButton btnNuevo;
	private JTextField hab_buscar;

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
		setBounds(100, 100,800, 500);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 298, 377);
		getContentPane().add(scrollPane);
		
		table_habitacion = new JTable();
		table_habitacion.setBackground(Color.WHITE);
		table_habitacion.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Codigo", "Descripcion de la Habitacion", "Monto Por Dia"
			}
		));
		table_habitacion.getColumnModel().getColumn(0).setPreferredWidth(51);
		table_habitacion.getColumnModel().getColumn(1).setPreferredWidth(143);
		scrollPane.setViewportView(table_habitacion);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.text);
		panel.setBounds(459, 11, 315, 370);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblCodigo.setBounds(10, 26, 67, 28);
		panel.add(lblCodigo);
		
		hab_codigo = new JTextField();
		hab_codigo.setEnabled(false);
		hab_codigo.setBounds(142, 27, 86, 30);
		panel.add(hab_codigo);
		hab_codigo.setColumns(10);
		
		JLabel lblNombre = new JLabel("Descripcion de la \r\n\r");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblNombre.setBounds(10, 84, 119, 28);
		panel.add(lblNombre);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(142, 84, 163, 46);
		panel.add(scrollPane_1);
		
		hab_descripcion = new JTextField();
		scrollPane_1.setViewportView(hab_descripcion);
		hab_descripcion.setEnabled(false);
		hab_descripcion.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Monto por Dia:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel.setBounds(10, 147, 108, 14);
		panel.add(lblNewLabel);
		
		hab_monto = new JTextField();
		hab_monto.setEnabled(false);
		hab_monto.setBounds(142, 141, 163, 30);
		panel.add(hab_monto);
		hab_monto.setColumns(10);
		
		JLabel lblRuc = new JLabel("Observacion:");
		lblRuc.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblRuc.setBounds(10, 204, 119, 14);
		panel.add(lblRuc);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(142, 198, 163, 46);
		panel.add(scrollPane_2);
		
		hab_observacion = new JTextField();
		scrollPane_2.setViewportView(hab_observacion);
		hab_observacion.setEnabled(false);
		hab_observacion.setColumns(10);
		
		JLabel lblHabitacion = new JLabel("Habitacion:");
		lblHabitacion.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblHabitacion.setBounds(10, 102, 119, 28);
		panel.add(lblHabitacion);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.text);
		panel_1.setBounds(459, 396, 315, 52);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setEnabled(false);
		btnGuardar.setBounds(9, 11, 107, 29);
		btnGuardar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		panel_1.add(btnGuardar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(117, 11, 109, 29);
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		panel_1.add(btnCancelar);
		
		btnSalir = new JButton("Salir");
		btnSalir.setBounds(231, 11, 79, 29);
		btnSalir.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		panel_1.add(btnSalir);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.text);
		panel_2.setBounds(318, 11, 130, 223);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		btnNuevo = new JButton("Nuevo");
		btnNuevo.setBounds(11, 34, 97, 29);
		btnNuevo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		panel_2.add(btnNuevo);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setEnabled(false);
		btnModificar.setBounds(11, 97, 109, 29);
		btnModificar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		panel_2.add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setEnabled(false);
		btnEliminar.setBounds(15, 160, 105, 29);
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		panel_2.add(btnEliminar);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(SystemColor.text);
		panel_3.setBounds(5, 399, 303, 49);
		getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		hab_buscar = new JTextField();
		hab_buscar.setBounds(99, 11, 194, 29);
		panel_3.add(hab_buscar);
		hab_buscar.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Buscar");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_1.setBounds(11, 9, 78, 29);
		panel_3.add(lblNewLabel_1);
		HabitacionController controlador=new HabitacionController(this);
		controlador.listarHabitacion();

	}

	public JTable getTable_habitacion() {
		return table_habitacion;
	}

	public void setTable_habitacion(JTable table_habitacion) {
		this.table_habitacion = table_habitacion;
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

	public JButton getBtnCancelar() {
		return btnCancelar;
	}

	public void setBtnCancelar(JButton btnCancelar) {
		this.btnCancelar = btnCancelar;
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
