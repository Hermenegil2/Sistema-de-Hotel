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
import java.awt.Font;
import javax.swing.JRadioButton;

@SuppressWarnings("serial")
public class FormEstadia extends JDialog {
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormEstadia dialog = new FormEstadia();
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
	public FormEstadia() {
		setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
		setTitle("Formulario de Estadia");
		setBounds(100, 100,800, 500);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 298, 377);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setBackground(Color.WHITE);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		scrollPane.setViewportView(table);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.CYAN);
		panel.setBounds(459, 11, 315, 370);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblCodigo.setBounds(10, 21, 122, 28);
		panel.add(lblCodigo);
		
		textField_1 = new JTextField();
		textField_1.setEnabled(false);
		textField_1.setBounds(143, 22, 86, 30);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNombre = new JLabel("Fecha de Entrada:");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblNombre.setBounds(10, 70, 144, 14);
		panel.add(lblNombre);
		
		textField_2 = new JTextField();
		textField_2.setEnabled(false);
		textField_2.setBounds(143, 63, 163, 30);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Codigo del Cliente:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel.setBounds(10, 105, 144, 24);
		panel.add(lblNewLabel);
		
		textField_3 = new JTextField();
		textField_3.setEnabled(false);
		textField_3.setBounds(143, 104, 163, 30);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblRuc = new JLabel("Codigo de Habitacion:");
		lblRuc.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblRuc.setBounds(10, 150, 144, 14);
		panel.add(lblRuc);
		
		textField_4 = new JTextField();
		textField_4.setEnabled(false);
		textField_4.setBounds(143, 144, 163, 30);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblDireccion = new JLabel("Fecha de Salida:");
		lblDireccion.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblDireccion.setBounds(10, 185, 122, 14);
		panel.add(lblDireccion);
		
		textField_5 = new JTextField();
		textField_5.setEnabled(false);
		textField_5.setBounds(143, 185, 163, 30);
		panel.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblMontoTotal = new JLabel("Monto Total:");
		lblMontoTotal.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblMontoTotal.setBounds(10, 220, 122, 14);
		panel.add(lblMontoTotal);
		
		JLabel lblMontoDeDescuento = new JLabel("Monto de descuento:");
		lblMontoDeDescuento.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblMontoDeDescuento.setBounds(10, 255, 154, 14);
		panel.add(lblMontoDeDescuento);
		
		JLabel lblObservacionDeLa = new JLabel("Observacion de la Estadia:");
		lblObservacionDeLa.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblObservacionDeLa.setBounds(10, 290, 199, 14);
		panel.add(lblObservacionDeLa);
		
		textField_6 = new JTextField();
		textField_6.setEnabled(false);
		textField_6.setColumns(10);
		textField_6.setBounds(143, 219, 163, 30);
		panel.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setEnabled(false);
		textField_7.setColumns(10);
		textField_7.setBounds(143, 254, 163, 30);
		panel.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setEnabled(false);
		textField_8.setColumns(10);
		textField_8.setBounds(143, 289, 163, 30);
		panel.add(textField_8);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblEstado.setBounds(10, 330, 86, 14);
		panel.add(lblEstado);
		
		JRadioButton rdbtnActivo = new JRadioButton("Activo");
		rdbtnActivo.setBounds(69, 326, 109, 23);
		panel.add(rdbtnActivo);
		
		JRadioButton rdbtnInactivo = new JRadioButton("Inactivo");
		rdbtnInactivo.setBounds(180, 326, 109, 23);
		panel.add(rdbtnInactivo);
		
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
		panel_2.setBounds(318, 11, 130, 223);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.setBounds(23, 34, 83, 29);
		btnNuevo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		panel_2.add(btnNuevo);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setBounds(11, 97, 107, 29);
		btnModificar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		panel_2.add(btnModificar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(15, 160, 99, 29);
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		panel_2.add(btnEliminar);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.CYAN);
		panel_3.setBounds(10, 399, 303, 49);
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

	}
}
