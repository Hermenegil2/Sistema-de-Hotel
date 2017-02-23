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

@SuppressWarnings("serial")
public class FormDetalle extends JDialog {
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormDetalle dialog = new FormDetalle();
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
	public FormDetalle() {
		setBounds(100, 100,800, 500);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 298, 377);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setBackground(Color.WHITE);
		table.setModel(new DefaultTableModel(
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
		scrollPane.setViewportView(table);
		
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
		
		JLabel lblNombre = new JLabel("Nro. Estadia:");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblNombre.setBounds(10, 90, 144, 14);
		panel.add(lblNombre);
		
		textField_2 = new JTextField();
		textField_2.setEnabled(false);
		textField_2.setBounds(142, 84, 163, 30);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Codigo de Servicio:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel.setBounds(10, 147, 132, 24);
		panel.add(lblNewLabel);
		
		textField_3 = new JTextField();
		textField_3.setEnabled(false);
		textField_3.setBounds(142, 141, 163, 30);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblRuc = new JLabel("Monto:");
		lblRuc.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblRuc.setBounds(10, 204, 67, 14);
		panel.add(lblRuc);
		
		textField_4 = new JTextField();
		textField_4.setEnabled(false);
		textField_4.setBounds(142, 198, 163, 30);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
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

	}
}
