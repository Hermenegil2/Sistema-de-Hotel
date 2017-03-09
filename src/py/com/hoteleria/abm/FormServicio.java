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

import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.border.BevelBorder;

import py.com.hoteleria.controller.ServicioController;

@SuppressWarnings("serial")
public class FormServicio extends JDialog {
	private JTable tableServicio;
	private JTextField ser_buscar;
	private JTextField ser_codigo;
	private JTextField ser_descri;
	private JTextField ser_monto;
	private JTextField ser_observacion;
	private JButton btnGuardar;
	private JButton btnSalir;
	private JButton btnEliminar;
	private JButton btnModificar;
	private JButton btnNuevo;
	private JButton btnBuscar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormServicio dialog = new FormServicio();
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
	public FormServicio() {
		setBounds(100, 100,853, 500);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, SystemColor.activeCaption, SystemColor.activeCaption, SystemColor.activeCaption, SystemColor.activeCaption));
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(0, 44, 837, 417);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblCodigo.setBounds(86, 26, 67, 28);
		panel.add(lblCodigo);
		
		ser_codigo = new JTextField();
		ser_codigo.setEditable(false);
		ser_codigo.setFont(new Font("Tahoma", Font.BOLD, 20));
		ser_codigo.setBounds(218, 27, 174, 30);
		panel.add(ser_codigo);
		ser_codigo.setColumns(10);
		
		JLabel lblNombre = new JLabel("Descripcion del");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblNombre.setBounds(86, 68, 144, 14);
		panel.add(lblNombre);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(218, 68, 174, 46);
		panel.add(scrollPane_1);
		
		ser_descri = new JTextField();
		ser_descri.setEditable(false);
		ser_descri.setFont(new Font("Tahoma", Font.BOLD, 13));
		scrollPane_1.setViewportView(ser_descri);
		ser_descri.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Monto:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel.setBounds(454, 31, 108, 14);
		panel.add(lblNewLabel);
		
		ser_monto = new JTextField();
		ser_monto.setEditable(false);
		ser_monto.setFont(new Font("Tahoma", Font.BOLD, 13));
		ser_monto.setBounds(558, 26, 191, 30);
		panel.add(ser_monto);
		ser_monto.setColumns(10);
		
		JLabel lblRuc = new JLabel("Observacion:");
		lblRuc.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblRuc.setBounds(454, 88, 108, 14);
		panel.add(lblRuc);
		
		ser_observacion = new JTextField();
		ser_observacion.setEditable(false);
		ser_observacion.setFont(new Font("Tahoma", Font.BOLD, 13));
		ser_observacion.setBounds(558, 75, 191, 44);
		panel.add(ser_observacion);
		ser_observacion.setColumns(10);
		
		JLabel lblServicio = new JLabel("Servicio:");
		lblServicio.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblServicio.setBounds(86, 81, 144, 14);
		panel.add(lblServicio);
		
		btnNuevo = new JButton("Nuevo");
		btnNuevo.setBounds(103, 132, 95, 29);
		panel.add(btnNuevo);
		btnNuevo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(229, 132, 103, 29);
		panel.add(btnGuardar);
		btnGuardar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		
		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(363, 132, 119, 29);
		panel.add(btnModificar);
		btnModificar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(513, 132, 115, 29);
		panel.add(btnEliminar);
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		
		btnSalir = new JButton("Salir");
		btnSalir.setBounds(659, 132, 76, 29);
		panel.add(btnSalir);
		btnSalir.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(71, 227, 678, 179);
		panel.add(scrollPane);
		
		tableServicio = new JTable();
		tableServicio.setBackground(Color.WHITE);
		tableServicio.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Codigo", "Descripcion del Servicio", "Monto"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tableServicio.getColumnModel().getColumn(0).setResizable(false);
		tableServicio.getColumnModel().getColumn(1).setResizable(false);
		tableServicio.getColumnModel().getColumn(1).setPreferredWidth(230);
		tableServicio.getColumnModel().getColumn(2).setResizable(false);
		scrollPane.setViewportView(tableServicio);
		
		ser_buscar = new JTextField();
		ser_buscar.setFont(new Font("Tahoma", Font.BOLD, 13));
		ser_buscar.setBounds(259, 184, 197, 29);
		panel.add(ser_buscar);
		ser_buscar.setColumns(10);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		btnBuscar.setBounds(467, 187, 95, 28);
		panel.add(btnBuscar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.activeCaption);
		panel_1.setBounds(0, 0, 837, 43);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Servicio");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel_1.setBounds(364, 11, 108, 32);
		panel_1.add(lblNewLabel_1);
		
		ServicioController controlador=new ServicioController(this);
		controlador.listarServicios();
		controlador.ocultarBoton();
	}

	public JTextField getSer_buscar() {
		return ser_buscar;
	}

	public void setSer_buscar(JTextField ser_buscar) {
		this.ser_buscar = ser_buscar;
	}

	public JButton getBtnGuardar() {
		return btnGuardar;
	}

	public void setBtnGuardar(JButton btnGuardar) {
		this.btnGuardar = btnGuardar;
	}

	public JButton getBtnSalir() {
		return btnSalir;
	}

	public void setBtnSalir(JButton btnSalir) {
		this.btnSalir = btnSalir;
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

	public JTable getTableServicio() {
		return tableServicio;
	}

	public void setTableServicio(JTable tableServicio) {
		this.tableServicio = tableServicio;
	}

	public JTextField getSer_codigo() {
		return ser_codigo;
	}

	public void setSer_codigo(JTextField ser_codigo) {
		this.ser_codigo = ser_codigo;
	}

	public JTextField getSer_descri() {
		return ser_descri;
	}

	public void setSer_descri(JTextField ser_descri) {
		this.ser_descri = ser_descri;
	}

	public JTextField getSer_monto() {
		return ser_monto;
	}

	public void setSer_monto(JTextField ser_monto) {
		this.ser_monto = ser_monto;
	}

	public JTextField getSer_observacion() {
		return ser_observacion;
	}

	public void setSer_observacion(JTextField ser_observacion) {
		this.ser_observacion = ser_observacion;
	}

	public JButton getBtnBuscar() {
		return btnBuscar;
	}

	public void setBtnBuscar(JButton btnBuscar) {
		this.btnBuscar = btnBuscar;
	}
	
}
