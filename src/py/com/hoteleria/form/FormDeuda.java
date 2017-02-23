package py.com.hoteleria.form;
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

import py.com.hoteleria.controller.DeudaController;

import java.awt.Font;

@SuppressWarnings("serial")
public class FormDeuda extends JDialog {
	private JTable tableDeuda;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JButton btnBuscarCliente;
	private JButton btnBuscarEstadia;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormDeuda dialog = new FormDeuda();
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
	public FormDeuda() {
		setTitle("Formulario de Deuda");
		setBounds(100, 100,800, 500);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 298, 377);
		getContentPane().add(scrollPane);
		
		tableDeuda = new JTable();
		tableDeuda.setBackground(Color.WHITE);
		tableDeuda.setModel(new DefaultTableModel(
			new Object[][] {
				{},
				{},
				{},
				{},
				{},
				{},
				{},
				{},
				{},
				{},
				{},
				{},
				{},
				{},
				{},
				{},
				{},
				{},
				{},
				{},
				{},
				{},
				{},
				{},
				{},
				{},
				{},
				{},
				{},
				{},
			},
			new String[] {
			}
		));
		scrollPane.setViewportView(tableDeuda);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.CYAN);
		panel.setBounds(459, 11, 315, 370);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblCodigo.setBounds(10, 26, 67, 28);
		panel.add(lblCodigo);
		
		textField_1 = new JTextField();
		textField_1.setEnabled(false);
		textField_1.setBounds(142, 27, 86, 30);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nro. de Estadia:");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblNombre.setBounds(10, 90, 144, 14);
		panel.add(lblNombre);
		
		textField_2 = new JTextField();
		textField_2.setEnabled(false);
		textField_2.setBounds(142, 84, 77, 30);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Codigo del Cliente:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel.setBounds(10, 147, 144, 14);
		panel.add(lblNewLabel);
		
		textField_3 = new JTextField();
		textField_3.setEnabled(false);
		textField_3.setBounds(142, 141, 77, 30);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblRuc = new JLabel("Monto de Deuda:");
		lblRuc.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblRuc.setBounds(10, 204, 144, 14);
		panel.add(lblRuc);
		
		textField_4 = new JTextField();
		textField_4.setEnabled(false);
		textField_4.setBounds(142, 198, 163, 30);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblDireccion = new JLabel("Monto Pagado:");
		lblDireccion.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblDireccion.setBounds(10, 261, 122, 24);
		panel.add(lblDireccion);
		
		textField_5 = new JTextField();
		textField_5.setEnabled(false);
		textField_5.setBounds(142, 255, 163, 30);
		panel.add(textField_5);
		textField_5.setColumns(10);
		
		btnBuscarCliente = new JButton("Buscar");
		btnBuscarCliente.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		btnBuscarCliente.setBounds(211, 141, 94, 31);
		panel.add(btnBuscarCliente);
		
		btnBuscarEstadia = new JButton("Buscar");
		btnBuscarEstadia.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		btnBuscarEstadia.setBounds(211, 82, 94, 32);
		panel.add(btnBuscarEstadia);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.CYAN);
		panel_1.setBounds(459, 396, 315, 52);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton = new JButton("Guardar");
		btnNewButton.setBounds(24, 11, 99, 29);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Canselar");
		btnNewButton_1.setBounds(128, 11, 103, 29);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		panel_1.add(btnNewButton_1);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(236, 11, 69, 29);
		btnSalir.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		panel_1.add(btnSalir);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.CYAN);
		panel_2.setBounds(318, 11, 130, 312);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.setBounds(22, 29, 83, 29);
		btnNuevo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		panel_2.add(btnNuevo);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setBounds(10, 85, 107, 29);
		btnModificar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		panel_2.add(btnModificar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(14, 141, 99, 29);
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		panel_2.add(btnEliminar);
		
		JButton btnDetalle = new JButton("Detalle");
		btnDetalle.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		btnDetalle.setBounds(14, 197, 99, 29);
		panel_2.add(btnDetalle);
		
		JButton btnCierre = new JButton("Cierre");
		btnCierre.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		btnCierre.setBounds(14, 253, 99, 29);
		panel_2.add(btnCierre);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.CYAN);
		panel_3.setBounds(5, 399, 303, 49);
		getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(10, 11, 87, 29);
		panel_3.add(btnBuscar);
		btnBuscar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		
		textField = new JTextField();
		textField.setBounds(96, 11, 197, 29);
		panel_3.add(textField);
		textField.setColumns(10);
		DeudaController controlador=new DeudaController(this);

	}

	public JButton getBtnBuscarCliente() {
		return btnBuscarCliente;
	}

	public void setBtnBuscarCliente(JButton btnBuscarCliente) {
		this.btnBuscarCliente = btnBuscarCliente;
	}

	public JButton getBtnBuscarEstadia() {
		return btnBuscarEstadia;
	}

	public void setBtnBuscarEstadia(JButton btnBuscarEstadia) {
		this.btnBuscarEstadia = btnBuscarEstadia;
	}
}
