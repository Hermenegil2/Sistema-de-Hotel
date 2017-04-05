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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.border.BevelBorder;
import java.awt.Color;

@SuppressWarnings("serial")
public class FormCobranza extends JDialog {
	private JTextField Ccodigo;
	public static JTextField CnroDeuda;
	public static JTextField CcodCliente;
	public static JTextField CmontoPagado;
	private JTextField textField;
	private JTable CtablaCobranza;
	private JButton btnBuscarDuedas;
	private JButton btnNuevo;
	private JButton btnGuardar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnSalir;
	public static JTextField Cfecha;

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
		setBounds(100, 100,967, 500);
		getContentPane().setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.activeCaption);
		panel_2.setBorder(UIManager.getBorder("CheckBox.border"));
		panel_2.setBounds(0, 0, 951, 43);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblCobranza = new JLabel("Cobranza");
		lblCobranza.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		lblCobranza.setBounds(304, 11, 146, 32);
		panel_2.add(lblCobranza);
		
		btnBuscarDuedas = new JButton("Buscar");
		btnBuscarDuedas.setBounds(535, 410, 89, 28);
		getContentPane().add(btnBuscarDuedas);
		btnBuscarDuedas.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		
		btnSalir = new JButton("Salir");
		btnSalir.setBounds(833, 315, 75, 47);
		getContentPane().add(btnSalir);
		btnSalir.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(472, 170, 131, 47);
		getContentPane().add(btnEliminar);
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		
		btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNuevo.setBounds(472, 54, 131, 47);
		getContentPane().add(btnNuevo);
		btnNuevo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(690, 315, 109, 47);
		getContentPane().add(btnGuardar);
		btnGuardar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		
		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(472, 112, 131, 47);
		getContentPane().add(btnModificar);
		btnModificar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		
		textField = new JTextField();
		textField.setBounds(10, 403, 178, 30);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnBuscar_1 = new JButton("Buscar");
		btnBuscar_1.setBounds(318, 401, 144, 30);
		getContentPane().add(btnBuscar_1);
		btnBuscar_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 54, 452, 287);
		getContentPane().add(scrollPane);
		
		CtablaCobranza = new JTable();
		CtablaCobranza.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Cod Deuda", "Cliente", "Monto Pagado", "Deuda"
			}
		));
		scrollPane.setViewportView(CtablaCobranza);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, new Color(255, 255, 255), new Color(255, 255, 255), new Color(255, 255, 255), new Color(255, 255, 255)), "Area de Trabajo", TitledBorder.CENTER, TitledBorder.TOP, null, SystemColor.windowText));
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(613, 54, 330, 253);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblCodigo = new JLabel("Nro. Cobranza:");
		lblCodigo.setBounds(10, 28, 122, 28);
		panel.add(lblCodigo);
		lblCodigo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		
		JLabel lblNombre = new JLabel("Fecha:");
		lblNombre.setBounds(10, 84, 144, 14);
		panel.add(lblNombre);
		lblNombre.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		
		JLabel lblDireccion = new JLabel("Monto A Pagar:");
		lblDireccion.setBounds(10, 126, 122, 14);
		panel.add(lblDireccion);
		lblDireccion.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		
		JLabel lblNewLabel = new JLabel("Nro. Deuda:");
		lblNewLabel.setBounds(10, 168, 108, 14);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		
		JLabel lblRuc = new JLabel("Codigo del Cliente:");
		lblRuc.setBounds(10, 210, 144, 14);
		panel.add(lblRuc);
		lblRuc.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		
		Ccodigo = new JTextField();
		Ccodigo.setBounds(142, 18, 178, 28);
		panel.add(Ccodigo);
		Ccodigo.setEnabled(false);
		Ccodigo.setColumns(10);
		
		Cfecha = new JTextField();
		Cfecha.setEditable(false);
		Cfecha.setColumns(10);
		Cfecha.setBounds(142, 64, 178, 28);
		panel.add(Cfecha);
		
		CmontoPagado = new JTextField();
		CmontoPagado.setEditable(false);
		CmontoPagado.setBounds(142, 110, 178, 28);
		panel.add(CmontoPagado);
		CmontoPagado.setColumns(10);
		
		CnroDeuda = new JTextField();
		CnroDeuda.setEditable(false);
		CnroDeuda.setBounds(142, 156, 178, 28);
		panel.add(CnroDeuda);
		CnroDeuda.setColumns(10);
		
		CcodCliente = new JTextField();
		CcodCliente.setBounds(142, 202, 178, 28);
		panel.add(CcodCliente);
		CcodCliente.setEditable(false);
		CcodCliente.setColumns(10);
		CobranzaController controller=new CobranzaController(this);
		controller.listarCobranza();
		controller.obtenerUltimoId();

	}

	public JTextField getCcodigo() {
		return Ccodigo;
	}

	public void setCcodigo(JTextField ccodigo) {
		Ccodigo = ccodigo;
	}


	

	public JTextField getCfecha() {
		return Cfecha;
	}

	public void setCfecha(JTextField cfecha) {
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
