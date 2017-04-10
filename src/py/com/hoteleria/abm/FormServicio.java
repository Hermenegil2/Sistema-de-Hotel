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
import java.awt.Font;
import java.awt.SystemColor;
import py.com.hoteleria.controller.ServicioController;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

@SuppressWarnings("serial")
public class FormServicio extends JDialog {
	private JTable tableServicio;
	private JTextField ser_buscar;
	private JTextField ser_codigo;
	private JTextField ser_descri;
	private JTextField ser_monto;
	private JTextField ser_observacion;
	private JButton btnGuardar;
	private JButton btnSalir;
	private JButton btnEliminar;
	private JButton btnModificar;
	private JButton btnNuevo;
	private JButton btnBuscar;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormServicio dialog = new FormServicio();
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
	public FormServicio() {
		setModal(true);
		setTitle("Formulario de Servicio");
		getContentPane().setBackground(SystemColor.activeCaption);
		setBounds(100, 100,712, 550);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Servicio", TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.window));
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(10, 11, 678, 489);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.activeCaption);
		panel_1.setBorder(new TitledBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), "Formulario", TitledBorder.CENTER, TitledBorder.TOP, null, SystemColor.window));
		panel_1.setBounds(10, 21, 654, 118);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(142, 59, 174, 46);
		panel_1.add(scrollPane_1);
		
		ser_descri = new JTextField();
		ser_descri.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					ser_monto.requestFocus();
				}
			}
		});
		ser_descri.setEditable(false);
		ser_descri.setFont(new Font("Tahoma", Font.BOLD, 13));
		scrollPane_1.setViewportView(ser_descri);
		ser_descri.setColumns(10);
		
		ser_codigo = new JTextField();
		ser_codigo.setBounds(142, 18, 174, 30);
		panel_1.add(ser_codigo);
		ser_codigo.setEditable(false);
		ser_codigo.setFont(new Font("Tahoma", Font.BOLD, 20));
		ser_codigo.setColumns(10);
		
		JLabel lblNombre = new JLabel("Descripcion del");
		lblNombre.setBounds(10, 59, 144, 14);
		panel_1.add(lblNombre);
		lblNombre.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		
		JLabel lblServicio = new JLabel("Servicio:");
		lblServicio.setBounds(10, 72, 144, 14);
		panel_1.add(lblServicio);
		lblServicio.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		
		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setBounds(10, 17, 67, 28);
		panel_1.add(lblCodigo);
		lblCodigo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		
		ser_observacion = new JTextField();
		ser_observacion.setBounds(444, 67, 191, 44);
		panel_1.add(ser_observacion);
		ser_observacion.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					btnGuardar.requestFocus();
				}
			}
		});
		ser_observacion.setEditable(false);
		ser_observacion.setFont(new Font("Tahoma", Font.BOLD, 13));
		ser_observacion.setColumns(10);
		
		JLabel lblRuc = new JLabel("Observacion:");
		lblRuc.setBounds(340, 80, 108, 14);
		panel_1.add(lblRuc);
		lblRuc.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		
		ser_monto = new JTextField();
		ser_monto.setBounds(444, 18, 191, 30);
		panel_1.add(ser_monto);
		ser_monto.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					ser_observacion.requestFocus();
				}
			}
		});
		ser_monto.setEditable(false);
		ser_monto.setFont(new Font("Tahoma", Font.BOLD, 13));
		ser_monto.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Monto:");
		lblNewLabel.setBounds(340, 23, 108, 14);
		panel_1.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		
		panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Area de Botones", TitledBorder.CENTER, TitledBorder.TOP, null, SystemColor.window));
		panel_2.setBackground(SystemColor.activeCaption);
		panel_2.setBounds(10, 150, 654, 65);
		panel.add(panel_2);
		
		btnNuevo = new JButton("Nuevo");
		panel_2.add(btnNuevo);
		btnNuevo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		
		btnGuardar = new JButton("Guardar");
		panel_2.add(btnGuardar);
		btnGuardar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		
		btnModificar = new JButton("Modificar");
		panel_2.add(btnModificar);
		btnModificar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		
		btnEliminar = new JButton("Eliminar");
		panel_2.add(btnEliminar);
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		
		btnSalir = new JButton("Salir");
		panel_2.add(btnSalir);
		btnSalir.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		
		panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Area de Busqueda", TitledBorder.CENTER, TitledBorder.TOP, null, SystemColor.window));
		panel_3.setBackground(SystemColor.activeCaption);
		panel_3.setBounds(10, 228, 654, 250);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 61, 634, 178);
		panel_3.add(scrollPane);
		
		tableServicio = new JTable();
		tableServicio.setToolTipText("Preciona Enter para modificar o para eliminar.");
		tableServicio.setBackground(Color.WHITE);
		tableServicio.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Codigo", "Descripcion del Servicio", "Monto"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tableServicio.getColumnModel().getColumn(0).setResizable(false);
		tableServicio.getColumnModel().getColumn(1).setResizable(false);
		tableServicio.getColumnModel().getColumn(1).setPreferredWidth(230);
		tableServicio.getColumnModel().getColumn(2).setResizable(false);
		scrollPane.setViewportView(tableServicio);
		
		ser_buscar = new JTextField();
		ser_buscar.setBounds(193, 21, 197, 29);
		panel_3.add(ser_buscar);
		ser_buscar.setFont(new Font("Tahoma", Font.BOLD, 13));
		ser_buscar.setColumns(10);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(401, 20, 95, 28);
		panel_3.add(btnBuscar);
		btnBuscar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		
		ServicioController controlador=new ServicioController(this);
		controlador.listarServicios();
		controlador.ocultarBoton();
	}

	public JTextField getSer_buscar() {
		return ser_buscar;
	}

	public void setSer_buscar(JTextField ser_buscar) {
		this.ser_buscar = ser_buscar;
	}

	public JButton getBtnGuardar() {
		return btnGuardar;
	}

	public void setBtnGuardar(JButton btnGuardar) {
		this.btnGuardar = btnGuardar;
	}

	public JButton getBtnSalir() {
		return btnSalir;
	}

	public void setBtnSalir(JButton btnSalir) {
		this.btnSalir = btnSalir;
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

	public JTable getTableServicio() {
		return tableServicio;
	}

	public void setTableServicio(JTable tableServicio) {
		this.tableServicio = tableServicio;
	}

	public JTextField getSer_codigo() {
		return ser_codigo;
	}

	public void setSer_codigo(JTextField ser_codigo) {
		this.ser_codigo = ser_codigo;
	}

	public JTextField getSer_descri() {
		return ser_descri;
	}

	public void setSer_descri(JTextField ser_descri) {
		this.ser_descri = ser_descri;
	}

	public JTextField getSer_monto() {
		return ser_monto;
	}

	public void setSer_monto(JTextField ser_monto) {
		this.ser_monto = ser_monto;
	}

	public JTextField getSer_observacion() {
		return ser_observacion;
	}

	public void setSer_observacion(JTextField ser_observacion) {
		this.ser_observacion = ser_observacion;
	}

	public JButton getBtnBuscar() {
		return btnBuscar;
	}

	public void setBtnBuscar(JButton btnBuscar) {
		this.btnBuscar = btnBuscar;
	}
	
}
