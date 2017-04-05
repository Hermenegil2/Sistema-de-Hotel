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
import javax.swing.border.TitledBorder;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;


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
	private JButton btnBuscar;
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
		getContentPane().setBackground(SystemColor.activeCaption);
		setTitle("Formulario de Cliente");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Hermenegil2\\Desktop\\Sistema de Hotel\\img\\formulariocliente.png"));
		setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 16));
		setBounds(100, 100,766, 587);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Clientes", TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.inactiveCaptionText));
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(10, 11, 726, 528);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Formulario", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)));
		panel_2.setBackground(SystemColor.activeCaption);
		panel_2.setBounds(10, 22, 707, 153);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setBounds(29, 27, 67, 28);
		panel_2.add(lblCodigo);
		lblCodigo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		
		JLabel lblNombre = new JLabel("Nombre y Apellido:");
		lblNombre.setBounds(29, 66, 144, 24);
		panel_2.add(lblNombre);
		lblNombre.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		
		JLabel lblNewLabel = new JLabel("Nro. Cedula:");
		lblNewLabel.setBounds(29, 111, 108, 14);
		panel_2.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		
		cli_telefono = new JTextField();
		cli_telefono.setBounds(455, 112, 228, 30);
		cli_telefono.setEditable(false);
		cli_telefono.setFont(new Font("Tahoma", Font.BOLD, 13));
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
		cli_direccion.setBounds(455, 70, 228, 30);
		cli_direccion.setEditable(false);
		cli_direccion.setFont(new Font("Tahoma", Font.BOLD, 13));
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
		cli_ruc.setBounds(455, 28, 228, 30);
		cli_ruc.setEditable(false);
		cli_ruc.setFont(new Font("Tahoma", Font.BOLD, 13));
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
		cli_codigo.setBounds(173, 24, 181, 30);
		cli_codigo.setEnabled(false);
		cli_codigo.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_2.add(cli_codigo);
		cli_codigo.setColumns(10);
		
		cli_nombre = new JTextField();
		cli_nombre.setBounds(173, 64, 183, 30);
		cli_nombre.setEditable(false);
		cli_nombre.setFont(new Font("Tahoma", Font.BOLD, 13));
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
		cli_cedula.setBounds(173, 110, 183, 30);
		cli_cedula.setEditable(false);
		cli_cedula.setFont(new Font("Tahoma", Font.BOLD, 13));
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
		lblTelefono.setBounds(378, 111, 86, 14);
		panel_2.add(lblTelefono);
		lblTelefono.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		
		JLabel lblDireccion = new JLabel("Direccion:");
		lblDireccion.setBounds(378, 71, 67, 14);
		panel_2.add(lblDireccion);
		lblDireccion.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		
		JLabel lblRuc = new JLabel("RUC:");
		lblRuc.setBounds(378, 33, 46, 14);
		panel_2.add(lblRuc);
		lblRuc.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(SystemColor.activeCaption);
		panel_3.setBorder(new TitledBorder(null, "Area de Botones", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_3.setBounds(10, 174, 707, 73);
		panel.add(panel_3);
		
		btnNuevo = new JButton("Nuevo");
		panel_3.add(btnNuevo);
		btnNuevo.setIcon(new ImageIcon("C:\\Users\\Hermenegil2\\Desktop\\Sistema de Hotel\\icono\\Agregar_Cliente.png"));
		btnNuevo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		
		btnGuardar = new JButton("Guardar");
		panel_3.add(btnGuardar);
		btnGuardar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		
		btnModificar = new JButton("Modificar");
		btnModificar.setIcon(new ImageIcon("C:\\Users\\Hermenegil2\\Desktop\\Sistema de Hotel\\icono\\editar.png"));
		panel_3.add(btnModificar);
		btnModificar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setIcon(new ImageIcon("C:\\Users\\Hermenegil2\\Desktop\\Sistema de Hotel\\icono\\Remove-Male-User-icon.png"));
		panel_3.add(btnEliminar);
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		
		btnSalir = new JButton("Salir");
		panel_3.add(btnSalir);
		btnSalir.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(SystemColor.activeCaption);
		panel_4.setBorder(new TitledBorder(null, "Area de Busqueda", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_4.setBounds(10, 249, 707, 268);
		panel.add(panel_4);
		panel_4.setLayout(null);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(363, 23, 190, 55);
		panel_4.add(btnBuscar);
		btnBuscar.setIcon(new ImageIcon("C:\\Users\\Hermenegil2\\Desktop\\Sistema de Hotel\\icono\\Buscar-Clientes.png"));
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnBuscar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		
		clie_buscar = new JTextField();
		clie_buscar.setBounds(163, 22, 190, 56);
		panel_4.add(clie_buscar);
		clie_buscar.setHorizontalAlignment(SwingConstants.CENTER);
		clie_buscar.setFont(new Font("Tahoma", Font.BOLD, 13));
		clie_buscar.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 86, 685, 171);
		panel_4.add(scrollPane);
		
		tableCliente = new JTable();
		tableCliente.setToolTipText("Preciona Entrer para modificar o para eliminar.");
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
