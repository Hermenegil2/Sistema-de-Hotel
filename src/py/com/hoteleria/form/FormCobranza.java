package py.com.hoteleria.form;

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

import javax.swing.UIManager;

import py.com.hoteleria.controller.CobranzaController;

import java.awt.SystemColor;

import com.toedter.calendar.JDateChooser;

@SuppressWarnings("serial")
public class FormCobranza extends JDialog {
	private JTextField Ccodigo;
	private JTextField CnroDeuda;
	private JTextField CcodCliente;
	private JTextField CmontoPagado;
	private JTextField textField;
	private JTable CtablaCobranza;
	private JButton btnBuscarDuedas;
	private JButton btnBuscarClientes;
	private JButton btnNuevo;
	private JButton btnGuardar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnSalir;
	private JDateChooser Cfecha;
	private JPanel panel_1;

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
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(0, 43, 784, 418);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblCodigo = new JLabel("Nro. Cobranza:");
		lblCodigo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblCodigo.setBounds(10, 31, 122, 28);
		panel.add(lblCodigo);
		
		Ccodigo = new JTextField();
		Ccodigo.setEnabled(false);
		Ccodigo.setBounds(142, 29, 178, 30);
		panel.add(Ccodigo);
		Ccodigo.setColumns(10);
		
		JLabel lblNombre = new JLabel("Fecha:");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblNombre.setBounds(10, 80, 144, 14);
		panel.add(lblNombre);
		
		JLabel lblNewLabel = new JLabel("Nro. Deuda:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel.setBounds(343, 49, 108, 14);
		panel.add(lblNewLabel);
		
		CnroDeuda = new JTextField();
		CnroDeuda.setBounds(481, 39, 86, 30);
		panel.add(CnroDeuda);
		CnroDeuda.setColumns(10);
		
		JLabel lblRuc = new JLabel("Codigo del Cliente:");
		lblRuc.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblRuc.setBounds(343, 94, 144, 14);
		panel.add(lblRuc);
		
		CcodCliente = new JTextField();
		CcodCliente.setBounds(481, 89, 86, 30);
		panel.add(CcodCliente);
		CcodCliente.setColumns(10);
		
		JLabel lblDireccion = new JLabel("Monto Pagado:");
		lblDireccion.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblDireccion.setBounds(10, 130, 122, 14);
		panel.add(lblDireccion);
		
		CmontoPagado = new JTextField();
		CmontoPagado.setBounds(142, 120, 178, 30);
		panel.add(CmontoPagado);
		CmontoPagado.setColumns(10);
		
		btnBuscarDuedas = new JButton("Buscar");
		btnBuscarDuedas.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		btnBuscarDuedas.setBounds(570, 41, 89, 28);
		panel.add(btnBuscarDuedas);
		
		btnBuscarClientes = new JButton("Buscar");
		btnBuscarClientes.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		btnBuscarClientes.setBounds(570, 88, 89, 31);
		panel.add(btnBuscarClientes);
		
		btnNuevo = new JButton("Nuevo");
		btnNuevo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		btnNuevo.setBounds(10, 167, 144, 47);
		panel.add(btnNuevo);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		btnGuardar.setBounds(164, 167, 144, 47);
		panel.add(btnGuardar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		btnModificar.setBounds(318, 167, 144, 47);
		panel.add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		btnEliminar.setBounds(472, 167, 144, 47);
		panel.add(btnEliminar);
		
		btnSalir = new JButton("Salir");
		btnSalir.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		btnSalir.setBounds(626, 167, 144, 47);
		panel.add(btnSalir);
		
		textField = new JTextField();
		textField.setBounds(142, 225, 178, 47);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnBuscar_1 = new JButton("Buscar");
		btnBuscar_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		btnBuscar_1.setBounds(328, 225, 144, 47);
		panel.add(btnBuscar_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 283, 764, 104);
		panel.add(scrollPane);
		
		CtablaCobranza = new JTable();
		CtablaCobranza.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Codigo", "Fecha", "Monto Pagado", "Deuda", "Cliente"
			}
		));
		scrollPane.setViewportView(CtablaCobranza);
		
		Cfecha = new JDateChooser();
		Cfecha.setBounds(142, 70, 178, 30);
		panel.add(Cfecha);
		
		panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.inactiveCaption);
		panel_1.setBounds(10, 10, 764, 211);
		panel.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.activeCaption);
		panel_2.setBorder(UIManager.getBorder("CheckBox.border"));
		panel_2.setBounds(0, 0, 784, 43);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblCobranza = new JLabel("Cobranza");
		lblCobranza.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		lblCobranza.setBounds(304, 11, 146, 32);
		panel_2.add(lblCobranza);
		CobranzaController controller=new CobranzaController(this);
		controller.listarCobranza();

	}

	public JTextField getCcodigo() {
		return Ccodigo;
	}

	public void setCcodigo(JTextField ccodigo) {
		Ccodigo = ccodigo;
	}


	public JDateChooser getCfecha() {
		return Cfecha;
	}

	public void setCfecha(JDateChooser cfecha) {
		Cfecha = cfecha;
	}

	public JTextField getCnroDeuda() {
		return CnroDeuda;
	}

	public void setCnroDeuda(JTextField cnroDeuda) {
		CnroDeuda = cnroDeuda;
	}

	public JTextField getCcodCliente() {
		return CcodCliente;
	}

	public void setCcodCliente(JTextField ccodCliente) {
		CcodCliente = ccodCliente;
	}

	public JTextField getCmontoPagado() {
		return CmontoPagado;
	}

	public void setCmontoPagado(JTextField cmontoPagado) {
		CmontoPagado = cmontoPagado;
	}

	public JTable getCtablaCobranza() {
		return CtablaCobranza;
	}

	public void setCtablaCobranza(JTable ctablaCobranza) {
		CtablaCobranza = ctablaCobranza;
	}

	public JButton getBtnBuscarDueda() {
		return btnBuscarDuedas;
	}

	public void setBtnBuscarDueda(JButton btnBuscarDueda) {
		this.btnBuscarDuedas = btnBuscarDueda;
	}

	public JButton getBtnBuscarCliente() {
		return btnBuscarClientes;
	}

	public void setBtnBuscarCliente(JButton btnBuscarCliente) {
		this.btnBuscarClientes = btnBuscarCliente;
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
}
