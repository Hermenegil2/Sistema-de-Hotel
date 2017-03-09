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
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.UIManager;

import py.com.hoteleria.controller.DeudaController;


@SuppressWarnings("serial")
public class FormDeuda extends JDialog {
	private JTextField Dcodigo;
	private JTextField DcodEstadia;
	private JTextField DeudaCodCliente;
	private JTextField DmontoDeuda;
	private JTextField DmontoPagado;
	private JButton btnBuscarCliente;
	private JButton btnBuscarEstadia;
	private JTable tableDeuda;
	private JButton btnNuevo;
	private JButton btnGuardar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnSalir;
	private JLabel lblDeuda;
	private JTextField textField;

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
		setBounds(100, 100,693, 540);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(0, 41, 677, 460);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblCodigo.setBounds(10, 25, 67, 28);
		panel.add(lblCodigo);
		
		Dcodigo = new JTextField();
		Dcodigo.setEnabled(false);
		Dcodigo.setBounds(142, 26, 174, 30);
		panel.add(Dcodigo);
		Dcodigo.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nro. de Estadia:");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblNombre.setBounds(350, 39, 144, 14);
		panel.add(lblNombre);
		
		DcodEstadia = new JTextField();
		DcodEstadia.setBounds(482, 23, 77, 30);
		panel.add(DcodEstadia);
		DcodEstadia.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Codigo del Cliente:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel.setBounds(350, 88, 144, 14);
		panel.add(lblNewLabel);
		
		DeudaCodCliente = new JTextField();
		DeudaCodCliente.setBounds(482, 79, 77, 30);
		panel.add(DeudaCodCliente);
		DeudaCodCliente.setColumns(10);
		
		JLabel lblRuc = new JLabel("Monto de Deuda:");
		lblRuc.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblRuc.setBounds(10, 76, 144, 14);
		panel.add(lblRuc);
		
		DmontoDeuda = new JTextField();
		DmontoDeuda.setBounds(142, 74, 174, 30);
		panel.add(DmontoDeuda);
		DmontoDeuda.setColumns(10);
		
		JLabel lblDireccion = new JLabel("Monto Pagado:");
		lblDireccion.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblDireccion.setBounds(10, 125, 122, 24);
		panel.add(lblDireccion);
		
		DmontoPagado = new JTextField();
		DmontoPagado.setBounds(142, 115, 174, 30);
		panel.add(DmontoPagado);
		DmontoPagado.setColumns(10);
		
		btnBuscarCliente = new JButton("Buscar");
		btnBuscarCliente.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		btnBuscarCliente.setBounds(562, 80, 94, 31);
		panel.add(btnBuscarCliente);
		
		btnBuscarEstadia = new JButton("Buscar");
		btnBuscarEstadia.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		btnBuscarEstadia.setBounds(562, 23, 94, 32);
		panel.add(btnBuscarEstadia);
		
		btnNuevo = new JButton("Nuevo");
		btnNuevo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		btnNuevo.setBounds(18, 160, 106, 37);
		panel.add(btnNuevo);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		btnGuardar.setBounds(142, 160, 106, 37);
		panel.add(btnGuardar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		btnModificar.setBounds(266, 160, 135, 37);
		panel.add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		btnEliminar.setBounds(419, 160, 122, 37);
		panel.add(btnEliminar);
		
		btnSalir = new JButton("Salir");
		btnSalir.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		btnSalir.setBounds(559, 160, 100, 37);
		panel.add(btnSalir);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 256, 657, 193);
		panel.add(scrollPane);
		
		tableDeuda = new JTable();
		tableDeuda.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Codigo", "Estadia", "Cliente", "Deuda", "Monto Pagado"
			}
		));
		scrollPane.setViewportView(tableDeuda);
		
		textField = new JTextField();
		textField.setBounds(142, 211, 174, 34);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		btnBuscar.setBounds(322, 208, 106, 37);
		panel.add(btnBuscar);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.inactiveCaption);
		panel_2.setBounds(10, 11, 657, 193);
		panel.add(panel_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(UIManager.getBorder("CheckBox.border"));
		panel_1.setBackground(SystemColor.activeCaption);
		panel_1.setBounds(0, 0, 984, 40);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		lblDeuda = new JLabel("Deuda");
		lblDeuda.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		lblDeuda.setBounds(280, 11, 125, 29);
		panel_1.add(lblDeuda);
		
		DeudaController controller=new DeudaController(this);
		controller.listarDeuda();
       
	}

	public JTable getTableDeuda() {
		return tableDeuda;
	}

	public void setTableDeuda(JTable tableDeuda) {
		this.tableDeuda = tableDeuda;
	}

	public JTextField getDcodigo() {
		return Dcodigo;
	}

	public void setDcodigo(JTextField dcodigo) {
		Dcodigo = dcodigo;
	}

	public JTextField getDcodEstadia() {
		return DcodEstadia;
	}

	public void setDcodEstadia(JTextField dcodEstadia) {
		DcodEstadia = dcodEstadia;
	}

	public JTextField getDmontoDeuda() {
		return DmontoDeuda;
	}

	public void setDmontoDeuda(JTextField dmontoDeuda) {
		DmontoDeuda = dmontoDeuda;
	}

	public JTextField getDmontoPagado() {
		return DmontoPagado;
	}

	public void setDmontoPagado(JTextField dmontoPagado) {
		DmontoPagado = dmontoPagado;
	}

	public JTextField getDeudaCodCliente() {
		return DeudaCodCliente;
	}

	public void setDeudaCodCliente(JTextField deudaCodCliente) {
		DeudaCodCliente = deudaCodCliente;
	}

	public JButton getBtnBuscarCliente() {
		return btnBuscarCliente;
	}

	public JButton getBtnNuevo() {
		return btnNuevo;
	}

	public void setBtnNuevo(JButton btnNuevo) {
		this.btnNuevo = btnNuevo;
	}

	public JButton getBtnGuardar() {
		return btnGuardar;
	}

	public void setBtnGuardar(JButton btnGuardar) {
		this.btnGuardar = btnGuardar;
	}

	public JButton getBtnModificar() {
		return btnModificar;
	}

	public void setBtnModificar(JButton btnModificar) {
		this.btnModificar = btnModificar;
	}

	public JButton getBtnEliminar() {
		return btnEliminar;
	}

	public void setBtnEliminar(JButton btnEliminar) {
		this.btnEliminar = btnEliminar;
	}

	public JButton getBtnSalir() {
		return btnSalir;
	}

	public void setBtnSalir(JButton btnSalir) {
		this.btnSalir = btnSalir;
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
