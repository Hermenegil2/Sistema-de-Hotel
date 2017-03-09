package py.com.hoteleria.informe;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import py.com.hoteleria.informeControlador.ListadoClienteControlador;

import java.awt.SystemColor;

import javax.swing.JButton;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

@SuppressWarnings("serial")
public class ListadoClientes extends JDialog {
	private JTable tableClientes;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListadoClientes dialog = new ListadoClientes();
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
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ListadoClientes() {
		setTitle("Listado de Clientes");
		getContentPane().setBackground(SystemColor.activeCaption);
		setBounds(100, 100, 800, 500);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 119, 764, 271);
		getContentPane().add(scrollPane);
		
		tableClientes = new JTable();
		tableClientes.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Codigo", "Nombre", "Cedula", "RUC", "Direccion", "Telefono"
			}
		));
		tableClientes.getColumnModel().getColumn(0).setPreferredWidth(50);
		tableClientes.getColumnModel().getColumn(1).setPreferredWidth(124);
		tableClientes.getColumnModel().getColumn(2).setPreferredWidth(57);
		tableClientes.getColumnModel().getColumn(4).setPreferredWidth(121);
		tableClientes.getColumnModel().getColumn(5).setPreferredWidth(64);
		scrollPane.setViewportView(tableClientes);
		
		JButton btnImprimir = new JButton("Imprimir");
		btnImprimir.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		btnImprimir.setBounds(10, 401, 135, 49);
		getContentPane().add(btnImprimir);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		btnSalir.setBounds(639, 401, 135, 49);
		getContentPane().add(btnSalir);
		
		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblCodigo.setBounds(66, 11, 84, 26);
		getContentPane().add(lblCodigo);
		
		JLabel lblDesde = new JLabel("Desde");
		lblDesde.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblDesde.setBounds(66, 48, 61, 26);
		getContentPane().add(lblDesde);
		
		textField = new JTextField();
		textField.setBounds(134, 53, 150, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblHasta = new JLabel("Hasta");
		lblHasta.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblHasta.setBounds(66, 74, 84, 26);
		getContentPane().add(lblHasta);
		
		textField_1 = new JTextField();
		textField_1.setBounds(134, 79, 150, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Codigo", "Nombre"}));
		comboBox.setBounds(603, 25, 126, 31);
		getContentPane().add(comboBox);
		
		JButton btnEnter = new JButton("Procesar");
		btnEnter.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		btnEnter.setBounds(603, 66, 126, 34);
		getContentPane().add(btnEnter);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblNombre.setBounds(312, 11, 84, 26);
		getContentPane().add(lblNombre);
		
		JLabel label_1 = new JLabel("Desde");
		label_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		label_1.setBounds(312, 48, 61, 26);
		getContentPane().add(label_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(380, 53, 150, 20);
		getContentPane().add(textField_2);
		
		JLabel label_2 = new JLabel("Hasta");
		label_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		label_2.setBounds(312, 74, 84, 26);
		getContentPane().add(label_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(380, 79, 150, 20);
		getContentPane().add(textField_3);
		
		JPanel panel = new JPanel();
		panel.setBounds(46, 11, 238, 100);
		getContentPane().add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(294, 11, 238, 100);
		getContentPane().add(panel_1);
		
		ListadoClienteControlador controlador=new ListadoClienteControlador(this);
		controlador.listarClientes();

	}

	public JTable getTableClientes() {
		return tableClientes;
	}

	public void setTableClientes(JTable tableClientes) {
		this.tableClientes = tableClientes;
	}
}
