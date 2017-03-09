package py.com.hoteleria.informe;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import py.com.hoteleria.informeControlador.InformeHabitacionControlador;

import java.awt.SystemColor;

import javax.swing.JButton;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

@SuppressWarnings("serial")
public class InformeHabitacion extends JDialog {
	private JTable tableHabitacion;
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
					InformeHabitacion dialog = new InformeHabitacion();
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public InformeHabitacion() {
		setTitle("Informe Habitacion");
		getContentPane().setBackground(SystemColor.activeCaption);
		setBounds(100, 100, 800, 500);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 119, 764, 271);
		getContentPane().add(scrollPane);
		
		tableHabitacion = new JTable();
		tableHabitacion.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Codigo", "Descripcion", "Monto Por Dia", "Observacion"
			}
		));
		tableHabitacion.getColumnModel().getColumn(0).setPreferredWidth(43);
		tableHabitacion.getColumnModel().getColumn(1).setPreferredWidth(256);
		tableHabitacion.getColumnModel().getColumn(2).setPreferredWidth(50);
		tableHabitacion.getColumnModel().getColumn(3).setPreferredWidth(239);
		scrollPane.setViewportView(tableHabitacion);
		
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
		
		
		InformeHabitacionControlador controlador=new InformeHabitacionControlador(this);
		controlador.listarHabitacion();

	}

	public JTable getTableHabitacion() {
		return tableHabitacion;
	}

	public void setTableHabitacion(JTable tableHabitacion) {
		this.tableHabitacion = tableHabitacion;
	}

}