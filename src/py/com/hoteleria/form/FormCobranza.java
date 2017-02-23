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

import net.miginfocom.swing.MigLayout;

@SuppressWarnings("serial")
public class FormCobranza extends JDialog {
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormCobranza dialog = new FormCobranza();
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
	public FormCobranza() {
		setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
		setTitle("Formulario de Cobranza");
		setBounds(100, 100,800, 500);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 298, 318);
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
		
		JLabel lblCodigo = new JLabel("Nro. Cobranza:");
		lblCodigo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblCodigo.setBounds(10, 26, 122, 28);
		panel.add(lblCodigo);
		
		textField_1 = new JTextField();
		textField_1.setEnabled(false);
		textField_1.setBounds(142, 27, 86, 30);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNombre = new JLabel("Fecha:");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblNombre.setBounds(10, 90, 144, 14);
		panel.add(lblNombre);
		
		textField_2 = new JTextField();
		textField_2.setEnabled(false);
		textField_2.setBounds(142, 84, 163, 30);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nro. Deuda:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel.setBounds(10, 147, 108, 14);
		panel.add(lblNewLabel);
		
		textField_3 = new JTextField();
		textField_3.setEnabled(false);
		textField_3.setBounds(142, 141, 163, 30);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblRuc = new JLabel("Codigo del Cliente:");
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
		lblDireccion.setBounds(10, 261, 122, 14);
		panel.add(lblDireccion);
		
		textField_5 = new JTextField();
		textField_5.setEnabled(false);
		textField_5.setBounds(142, 255, 163, 30);
		panel.add(textField_5);
		textField_5.setColumns(10);
		
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
		panel_3.setBounds(10, 337, 303, 49);
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
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(10, 399, 303, 49);
		getContentPane().add(panel_4);
		panel_4.setBackground(Color.CYAN);
		
		JButton btnTodo = new JButton("Todo");
		btnTodo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		
		JButton btnDeuda = new JButton("Deuda");
		btnDeuda.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		
		JButton btnSinDeuda = new JButton("Sin Deuda");
		btnSinDeuda.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		panel_4.setLayout(new MigLayout("", "[87px][87px][115px]", "[29px]"));
		panel_4.add(btnTodo, "cell 0 0,growx,aligny top");
		panel_4.add(btnDeuda, "cell 1 0,growx,aligny top");
		panel_4.add(btnSinDeuda, "cell 2 0,alignx left,aligny top");

	}
}
