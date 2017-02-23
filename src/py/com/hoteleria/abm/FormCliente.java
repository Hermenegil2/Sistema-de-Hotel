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
import py.com.hoteleria.controller.ClienteController;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.SystemColor;
import javax.swing.border.BevelBorder;


@SuppressWarnings("serial")
public class FormCliente extends JDialog {
	private JTable tableCliente;
	private JTextField clie_buscar;
	private JTextField cli_codigo;
	private JTextField cli_nombre;
	private JTextField cli_cedula;
	private JTextField cli_ruc;
	private JTextField cli_direccion;
	private JTextField cli_telefono;
	private JButton btnSalir;
	private JButton btnCanselar;
	private JButton btnGuardar;
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
					FormCliente dialog = new FormCliente();
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
	public FormCliente() {
		setTitle("Formulario de Cliente");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Hermenegil2\\Desktop\\Sistema de Hotel\\img\\formulariocliente.png"));
		setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 16));
		setBounds(100, 100,800, 500);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 298, 377);
		getContentPane().add(scrollPane);
		
		tableCliente = new JTable();
		tableCliente.setForeground(new Color(0, 0, 0));
		tableCliente.setBackground(Color.WHITE);
		tableCliente.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Codigo", "Nombre y Apellido", "Nro. Cedula"
			}
		));
		tableCliente.getColumnModel().getColumn(1).setPreferredWidth(168);
		scrollPane.setViewportView(tableCliente);
		
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
		
		cli_codigo = new JTextField();
		cli_codigo.setEnabled(false);
		cli_codigo.setBounds(142, 27, 86, 30);
		panel.add(cli_codigo);
		cli_codigo.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre y Apellido:");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblNombre.setBounds(10, 90, 144, 14);
		panel.add(lblNombre);
		
		cli_nombre = new JTextField();
		cli_nombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					cli_cedula.requestFocus();
				}
			}
		});
		cli_nombre.setEnabled(false);
		cli_nombre.setBounds(142, 84, 163, 30);
		panel.add(cli_nombre);
		cli_nombre.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nro. Cedula:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel.setBounds(10, 147, 108, 14);
		panel.add(lblNewLabel);
		
		cli_cedula = new JTextField();
		cli_cedula.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					cli_ruc.requestFocus();
				}
			}
		});
		
		cli_cedula.setEnabled(false);
		cli_cedula.setBounds(142, 141, 163, 30);
		panel.add(cli_cedula);
		cli_cedula.setColumns(10);
		
		JLabel lblRuc = new JLabel("RUC:");
		lblRuc.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblRuc.setBounds(10, 204, 46, 14);
		panel.add(lblRuc);
		
		cli_ruc = new JTextField();
		cli_ruc.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					cli_direccion.requestFocus();
				}
			}
		});
		cli_ruc.setEnabled(false);
		cli_ruc.setBounds(142, 198, 163, 30);
		panel.add(cli_ruc);
		cli_ruc.setColumns(10);
		
		JLabel lblDireccion = new JLabel("Direccion:");
		lblDireccion.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblDireccion.setBounds(10, 261, 67, 14);
		panel.add(lblDireccion);
		
		cli_direccion = new JTextField();
		cli_direccion.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					cli_telefono.requestFocus();
				}
			}
		});
		cli_direccion.setEnabled(false);
		cli_direccion.setBounds(142, 255, 163, 30);
		panel.add(cli_direccion);
		cli_direccion.setColumns(10);
		
		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblTelefono.setBounds(10, 318, 86, 14);
		panel.add(lblTelefono);
		
		cli_telefono = new JTextField();
		cli_telefono.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					btnGuardar.requestFocus();
				}
			}
		});
		cli_telefono.setEnabled(false);
		cli_telefono.setBounds(142, 312, 163, 30);
		panel.add(cli_telefono);
		cli_telefono.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(459, 396, 315, 52);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setEnabled(false);
		btnGuardar.setBounds(0, 11, 113, 29);
		btnGuardar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		panel_1.add(btnGuardar);
		
		btnCanselar = new JButton("Canselar");
		btnCanselar.setBounds(119, 11, 113, 29);
		btnCanselar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		panel_1.add(btnCanselar);
		
		btnSalir = new JButton("Salir");
		btnSalir.setBounds(240, 11, 75, 29);
		btnSalir.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		panel_1.add(btnSalir);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.LIGHT_GRAY);
		panel_3.setBounds(5, 399, 303, 49);
		getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		clie_buscar = new JTextField();
		clie_buscar.setBounds(103, 11, 190, 29);
		panel_3.add(clie_buscar);
		clie_buscar.setColumns(10);
		
		JLabel lblBuscar = new JLabel("Buscar");
		lblBuscar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblBuscar.setBounds(20, 11, 73, 29);
		panel_3.add(lblBuscar);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, SystemColor.activeCaption, SystemColor.activeCaption, SystemColor.activeCaption, SystemColor.activeCaption));
		panel_2.setBackground(SystemColor.text);
		panel_2.setBounds(318, 11, 130, 223);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		btnNuevo = new JButton("Nuevo");
		btnNuevo.setBounds(15, 34, 95, 29);
		btnNuevo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		panel_2.add(btnNuevo);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setEnabled(false);
		btnModificar.setBounds(10, 98, 110, 29);
		btnModificar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		panel_2.add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setEnabled(false);
		btnEliminar.setBounds(15, 160, 105, 29);
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		panel_2.add(btnEliminar);

		
		ClienteController controlador=new ClienteController(this);
		controlador.listarClientes();
	}

	public JTextField getClie_buscar() {
		return clie_buscar;
	}

	public void setClie_buscar(JTextField clie_buscar) {
		this.clie_buscar = clie_buscar;
	}

	public JTextField getCli_codigo() {
		return cli_codigo;
	}

	public void setCli_codigo(JTextField cli_codigo) {
		this.cli_codigo = cli_codigo;
	}

	public JTextField getCli_nombre() {
		return cli_nombre;
	}

	public void setCli_nombre(JTextField cli_nombre) {
		this.cli_nombre = cli_nombre;
	}

	public JTextField getCli_cedula() {
		return cli_cedula;
	}

	public void setCli_cedula(JTextField cli_cedula) {
		this.cli_cedula = cli_cedula;
	}

	public JTextField getCli_ruc() {
		return cli_ruc;
	}

	public void setCli_ruc(JTextField cli_ruc) {
		this.cli_ruc = cli_ruc;
	}

	public JTextField getCli_direccion() {
		return cli_direccion;
	}

	public void setCli_direccion(JTextField cli_direccion) {
		this.cli_direccion = cli_direccion;
	}

	public JTextField getCli_telefono() {
		return cli_telefono;
	}

	public void setCli_telefono(JTextField cli_telefono) {
		this.cli_telefono = cli_telefono;
	}

	public JTable getTableCliente() {
		return tableCliente;
	}

	public void setTableCliente(JTable tableCliente) {
		this.tableCliente = tableCliente;
	}

	public JButton getBtnSalir() {
		return btnSalir;
	}

	public void setBtnSalir(JButton btnSalir) {
		this.btnSalir = btnSalir;
	}

	public JButton getBtnCanselar() {
		return btnCanselar;
	}

	public void setBtnCanselar(JButton btnCanselar) {
		this.btnCanselar = btnCanselar;
	}

	public JButton getBtnGuardar() {
		return btnGuardar;
	}

	public void setBtnGuardar(JButton btnGuardar) {
		this.btnGuardar = btnGuardar;
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
}
