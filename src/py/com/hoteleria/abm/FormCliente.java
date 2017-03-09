package py.com.hoteleria.abm;

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
import javax.swing.UIManager;


public class FormCliente extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable tableCliente;
	private JTextField clie_buscar;
	private JTextField cli_codigo;
	private JTextField cli_nombre;
	private JTextField cli_cedula;
	private JTextField cli_ruc;
	private JTextField cli_direccion;
	private JTextField cli_telefono;
	private JButton btnSalir;
	private JButton btnGuardar;
	private JButton btnEliminar;
	private JButton btnModificar;
	private JButton btnNuevo;
	private JPanel panel_1;
	private JButton btnBuscar;
	private JLabel lblCliente;
	private JPanel panel_2;
	

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
		setBounds(100, 100,870, 519);
		getContentPane().setLayout(null);
		
		panel_1 = new JPanel();
		panel_1.setBorder(UIManager.getBorder("CheckBox.border"));
		panel_1.setBackground(SystemColor.activeCaption);
		panel_1.setBounds(0, 0, 854, 42);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		lblCliente = new JLabel("Cliente");
		lblCliente.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		lblCliente.setBounds(378, 11, 97, 31);
		panel_1.add(lblCliente);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, SystemColor.activeCaption, SystemColor.activeCaption, SystemColor.activeCaption, SystemColor.activeCaption));
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(0, 42, 854, 438);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(95, 266, 664, 161);
		panel.add(scrollPane);
		
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
		
		clie_buscar = new JTextField();
		clie_buscar.setFont(new Font("Tahoma", Font.BOLD, 13));
		clie_buscar.setBounds(242, 217, 190, 29);
		panel.add(clie_buscar);
		clie_buscar.setColumns(10);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		btnBuscar.setBounds(442, 215, 113, 29);
		panel.add(btnBuscar);
		
		panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.activeCaption);
		panel_2.setBounds(95, 12, 664, 192);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setBounds(0, 11, 67, 28);
		panel_2.add(lblCodigo);
		lblCodigo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		
		JLabel lblNombre = new JLabel("Nombre y Apellido:");
		lblNombre.setBounds(0, 50, 144, 24);
		panel_2.add(lblNombre);
		lblNombre.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		
		JLabel lblNewLabel = new JLabel("Nro. Cedula:");
		lblNewLabel.setBounds(0, 95, 108, 14);
		panel_2.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		
		btnNuevo = new JButton("Nuevo");
		btnNuevo.setBounds(27, 146, 95, 29);
		panel_2.add(btnNuevo);
		btnNuevo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		
		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(289, 146, 110, 29);
		panel_2.add(btnModificar);
		btnModificar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(426, 146, 105, 29);
		panel_2.add(btnEliminar);
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(149, 146, 113, 29);
		panel_2.add(btnGuardar);
		btnGuardar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		
		btnSalir = new JButton("Salir");
		btnSalir.setBounds(558, 146, 75, 29);
		panel_2.add(btnSalir);
		btnSalir.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		
		cli_telefono = new JTextField();
		cli_telefono.setEditable(false);
		cli_telefono.setFont(new Font("Tahoma", Font.BOLD, 13));
		cli_telefono.setBounds(426, 89, 228, 30);
		panel_2.add(cli_telefono);
		cli_telefono.addKeyListener(new KeyAdapter() {
			
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					btnGuardar.requestFocus();
				}
			}
		});
		cli_telefono.setColumns(10);
		
		cli_direccion = new JTextField();
		cli_direccion.setEditable(false);
		cli_direccion.setFont(new Font("Tahoma", Font.BOLD, 13));
		cli_direccion.setBounds(426, 49, 228, 30);
		panel_2.add(cli_direccion);
		cli_direccion.addKeyListener(new KeyAdapter() {
			
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					cli_telefono.requestFocus();
				}
			}
		});
		cli_direccion.setColumns(10);
		
		cli_ruc = new JTextField();
		cli_ruc.setEditable(false);
		cli_ruc.setFont(new Font("Tahoma", Font.BOLD, 13));
		cli_ruc.setBounds(426, 12, 228, 30);
		panel_2.add(cli_ruc);
		cli_ruc.addKeyListener(new KeyAdapter() {
			
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					cli_direccion.requestFocus();
				}
			}
		});
		cli_ruc.setColumns(10);
		
		cli_codigo = new JTextField();
		cli_codigo.setEnabled(false);
		cli_codigo.setFont(new Font("Tahoma", Font.BOLD, 20));
		cli_codigo.setBounds(144, 12, 181, 30);
		panel_2.add(cli_codigo);
		cli_codigo.setColumns(10);
		
		cli_nombre = new JTextField();
		cli_nombre.setEditable(false);
		cli_nombre.setFont(new Font("Tahoma", Font.BOLD, 13));
		cli_nombre.setBounds(142, 53, 183, 30);
		panel_2.add(cli_nombre);
		cli_nombre.addKeyListener(new KeyAdapter() {
			
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					cli_cedula.requestFocus();
				}
			}
		});
		cli_nombre.setColumns(10);
		
		cli_cedula = new JTextField();
		cli_cedula.setEditable(false);
		cli_cedula.setFont(new Font("Tahoma", Font.BOLD, 13));
		cli_cedula.setBounds(142, 94, 183, 30);
		panel_2.add(cli_cedula);
		cli_cedula.addKeyListener(new KeyAdapter() {
			
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					cli_ruc.requestFocus();
				}
			}
		});
		cli_cedula.setColumns(10);
		
		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setBounds(349, 95, 86, 14);
		panel_2.add(lblTelefono);
		lblTelefono.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		
		JLabel lblDireccion = new JLabel("Direccion:");
		lblDireccion.setBounds(349, 55, 67, 14);
		panel_2.add(lblDireccion);
		lblDireccion.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		
		JLabel lblRuc = new JLabel("RUC:");
		lblRuc.setBounds(349, 17, 46, 14);
		panel_2.add(lblRuc);
		lblRuc.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));

		
		ClienteController controlador=new ClienteController(this);
		controlador.listarClientes();
		controlador.ocultarGuardar();
//		controlador.pasarCampoTabla();
		
	}

	
	public JButton getBtnBuscar() {
		return btnBuscar;
	}

	public void setBtnBuscar(JButton btnBuscar) {
		this.btnBuscar = btnBuscar;
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
