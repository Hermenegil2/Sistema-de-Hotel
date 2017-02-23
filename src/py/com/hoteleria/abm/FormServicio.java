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
	private JButton btnCancelar;
	private JButton btnSalir;
	private JButton btnEliminar;
	private JButton btnModificar;
	private JButton btnNuevo;

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
		setBounds(100, 100,800, 500);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 298, 377);
		getContentPane().add(scrollPane);
		
		tableServicio = new JTable();
		tableServicio.setBackground(Color.WHITE);
		tableServicio.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Codigo", "Descripcion del Servicio", "Monto"
			}
		));
		tableServicio.getColumnModel().getColumn(1).setPreferredWidth(230);
		scrollPane.setViewportView(tableServicio);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, SystemColor.activeCaption, SystemColor.activeCaption, SystemColor.activeCaption, SystemColor.activeCaption));
		panel.setBackground(SystemColor.text);
		panel.setBounds(459, 11, 315, 370);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblCodigo.setBounds(10, 26, 67, 28);
		panel.add(lblCodigo);
		
		ser_codigo = new JTextField();
		ser_codigo.setEnabled(false);
		ser_codigo.setBounds(142, 27, 86, 30);
		panel.add(ser_codigo);
		ser_codigo.setColumns(10);
		
		JLabel lblNombre = new JLabel("Descripcion del");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblNombre.setBounds(10, 90, 144, 14);
		panel.add(lblNombre);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(142, 84, 163, 46);
		panel.add(scrollPane_1);
		
		ser_descri = new JTextField();
		scrollPane_1.setViewportView(ser_descri);
		ser_descri.setEnabled(false);
		ser_descri.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Monto:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel.setBounds(10, 147, 108, 14);
		panel.add(lblNewLabel);
		
		ser_monto = new JTextField();
		ser_monto.setEnabled(false);
		ser_monto.setBounds(142, 141, 163, 30);
		panel.add(ser_monto);
		ser_monto.setColumns(10);
		
		JLabel lblRuc = new JLabel("Observacion:");
		lblRuc.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblRuc.setBounds(10, 204, 108, 14);
		panel.add(lblRuc);
		
		ser_observacion = new JTextField();
		ser_observacion.setEnabled(false);
		ser_observacion.setBounds(142, 198, 163, 44);
		panel.add(ser_observacion);
		ser_observacion.setColumns(10);
		
		JLabel lblServicio = new JLabel("Servicio:");
		lblServicio.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblServicio.setBounds(10, 103, 144, 14);
		panel.add(lblServicio);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.RAISED, SystemColor.activeCaption, SystemColor.activeCaption, SystemColor.activeCaption, SystemColor.activeCaption));
		panel_1.setBackground(SystemColor.textHighlightText);
		panel_1.setBounds(459, 396, 315, 52);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setEnabled(false);
		btnGuardar.setBounds(10, 11, 103, 29);
		btnGuardar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		panel_1.add(btnGuardar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(118, 11, 108, 29);
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		panel_1.add(btnCancelar);
		
		btnSalir = new JButton("Salir");
		btnSalir.setBounds(229, 11, 76, 29);
		btnSalir.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		panel_1.add(btnSalir);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new BevelBorder(BevelBorder.RAISED, SystemColor.activeCaption, SystemColor.activeCaption, SystemColor.activeCaption, SystemColor.activeCaption));
		panel_2.setBackground(SystemColor.text);
		panel_2.setBounds(318, 11, 135, 223);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		btnNuevo = new JButton("Nuevo");
		btnNuevo.setBounds(23, 34, 95, 29);
		btnNuevo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		panel_2.add(btnNuevo);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setEnabled(false);
		btnModificar.setBounds(11, 97, 119, 29);
		btnModificar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		panel_2.add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setEnabled(false);
		btnEliminar.setBounds(13, 160, 115, 29);
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		panel_2.add(btnEliminar);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new BevelBorder(BevelBorder.RAISED, SystemColor.activeCaption, SystemColor.activeCaption, SystemColor.activeCaption, SystemColor.activeCaption));
		panel_3.setBackground(SystemColor.text);
		panel_3.setBounds(5, 399, 303, 49);
		getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		ser_buscar = new JTextField();
		ser_buscar.setBounds(96, 11, 197, 29);
		panel_3.add(ser_buscar);
		ser_buscar.setColumns(10);
		
		JLabel label = new JLabel("Buscar");
		label.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		label.setBounds(13, 11, 73, 29);
		panel_3.add(label);
		
		ServicioController controlador=new ServicioController(this);
		controlador.listarServicios();
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

	public JButton getBtnCancelar() {
		return btnCancelar;
	}

	public void setBtnCancelar(JButton btnCancelar) {
		this.btnCancelar = btnCancelar;
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
}
