package py.com.hoteleria.menu;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;

import java.awt.Color;

import javax.swing.JMenuItem;

import java.awt.Font;

import javax.swing.JMenu;
import javax.swing.JButton;

import py.com.hoteleria.controller.ConfigController;
import py.com.hoteleria.controller.FormController;

import javax.swing.JTextField;
import javax.swing.JPanel;
import java.awt.SystemColor;
import javax.swing.UIManager;

@SuppressWarnings("serial")
public class MenuPrincipal extends JFrame {
	private JMenuItem itemCliente;
	private JButton btnClientes;
	private JButton btnSalir;
	private JButton btnConbranza;
	private JButton btnHospedaje;
	private JMenuItem itemServicio;
	private JMenuItem itemHabitacion;
	private JTextField nombre;
	private JTextField telefono;
	private JMenuItem itemConfiguraciones;
	private JMenuItem itemListadoDeClientes;
	private JMenuItem itemListadoDeHabitacion;
	private JMenuItem itemListadoDeServicio;
	private JMenuItem itemInformeDeHospedaje;
	private JMenuItem itemInformeDePago;
	private JMenuItem ItemHospedaje;
	private JMenuItem ItemCobranza;
	private JPanel panel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal frame = new MenuPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MenuPrincipal() {
		getContentPane().setBackground(SystemColor.activeCaption);
		setExtendedState(MAXIMIZED_BOTH);
		setBounds(100, 100, 800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnProceso_1 = new JMenu("");
		mnProceso_1.setIcon(new ImageIcon("C:\\Users\\Hermenegil2\\Desktop\\Sistema de Hotel\\img\\proceso.png"));
		mnProceso_1.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 20));
		menuBar.add(mnProceso_1);
		
		ItemHospedaje = new JMenuItem("Hospedaje");
		mnProceso_1.add(ItemHospedaje);
		
		ItemCobranza = new JMenuItem("Cobranza");
		mnProceso_1.add(ItemCobranza);
		
		JMenu mnProceso = new JMenu("");
		mnProceso.setIcon(new ImageIcon("C:\\Users\\Hermenegil2\\Desktop\\Sistema de Hotel\\img\\TABLAS.png"));
		mnProceso.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 20));
		menuBar.add(mnProceso);
		
		itemCliente = new JMenuItem("Clientes");
		mnProceso.add(itemCliente);
		
		itemServicio = new JMenuItem("Servicio");
		mnProceso.add(itemServicio);
		
		itemHabitacion = new JMenuItem("Habitacion");
		mnProceso.add(itemHabitacion);
		
		JMenu mnInformes = new JMenu("");
		mnInformes.setIcon(new ImageIcon("C:\\Users\\Hermenegil2\\Desktop\\Sistema de Hotel\\img\\informes.png"));
		mnInformes.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 20));
		menuBar.add(mnInformes);
		
		itemListadoDeClientes = new JMenuItem("Listado de Clientes");
		mnInformes.add(itemListadoDeClientes);
		
		itemListadoDeHabitacion = new JMenuItem("Listado de Habitacion");
		mnInformes.add(itemListadoDeHabitacion);
		
		itemListadoDeServicio = new JMenuItem("Listado de Servicio");
		mnInformes.add(itemListadoDeServicio);
		
		itemInformeDeHospedaje = new JMenuItem("Informe de Hospedaje");
		mnInformes.add(itemInformeDeHospedaje);
		
		itemInformeDePago = new JMenuItem("Informe de Pago");
		mnInformes.add(itemInformeDePago);
		
		JMenu mnConfiguraciones = new JMenu("");
		mnConfiguraciones.setIcon(new ImageIcon("C:\\Users\\Hermenegil2\\Desktop\\Sistema de Hotel\\img\\utilidades.png"));
		mnConfiguraciones.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 20));
		menuBar.add(mnConfiguraciones);
		
		JMenuItem mntmInicializacionDeDatos = new JMenuItem("Inicializacion de Datos");
		mnConfiguraciones.add(mntmInicializacionDeDatos);
		
		itemConfiguraciones = new JMenuItem("Configuraciones");
		mnConfiguraciones.add(itemConfiguraciones);
		getContentPane().setLayout(null);
		
		btnClientes = new JButton("");
		btnClientes.setForeground(new Color(30, 144, 255));
		btnClientes.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnClientes.setIcon(new ImageIcon("C:\\Users\\Hermenegil2\\Desktop\\Sistema de Hotel\\img\\clientes.png"));
		btnClientes.setBounds(1146, 99, 160, 52);
		getContentPane().add(btnClientes);
		
		btnSalir = new JButton("");
		btnSalir.setIcon(new ImageIcon("C:\\Users\\Hermenegil2\\Desktop\\Sistema de Hotel\\img\\SALIR.png"));
		btnSalir.setBounds(1168, 162, 119, 44);
		getContentPane().add(btnSalir);
		
		JLabel lblAutor = new JLabel("Autores:");
		lblAutor.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblAutor.setBounds(1146, 515, 86, 25);
		getContentPane().add(lblAutor);
		
		JLabel lblHermenegildo = new JLabel("Hermenegildo");
		lblHermenegildo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblHermenegildo.setBounds(1223, 515, 131, 25);
		getContentPane().add(lblHermenegildo);
		
		JLabel lblMyrianBarrios = new JLabel("Myrian Barrios");
		lblMyrianBarrios.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblMyrianBarrios.setBounds(1223, 537, 121, 25);
		getContentPane().add(lblMyrianBarrios);
		
		panel_1 = new JPanel();
		panel_1.setBorder(UIManager.getBorder("Table.focusCellHighlightBorder"));
		panel_1.setBackground(SystemColor.activeCaption);
		panel_1.setBounds(10, 11, 1334, 646);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		btnConbranza = new JButton("");
		btnConbranza.setBounds(31, 151, 221, 52);
		panel_1.add(btnConbranza);
		btnConbranza.setIcon(new ImageIcon("C:\\Users\\Hermenegil2\\Desktop\\Sistema de Hotel\\img\\cobranza.png"));
		
		btnHospedaje = new JButton("");
		btnHospedaje.setBounds(31, 88, 221, 52);
		panel_1.add(btnHospedaje);
		btnHospedaje.setIcon(new ImageIcon("C:\\Users\\Hermenegil2\\Desktop\\Sistema de Hotel\\img\\hospedaje.png"));
		
		JLabel lblNewLabel_1 = new JLabel("Version 1.4");
		lblNewLabel_1.setBounds(32, 583, 231, 52);
		panel_1.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		
		JLabel lblNewLabel = new JLabel("Sabado, 23 Mayo 2017");
		lblNewLabel.setBounds(10, 65, 1311, 570);
		panel_1.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Hermenegil2\\Desktop\\Sistema de Hotel\\img\\\u00EDndice.jpg"));
		lblNewLabel.setForeground(Color.ORANGE);
		lblNewLabel.setBackground(SystemColor.activeCaption);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 1314, 52);
		panel_1.add(panel);
		panel.setBorder(UIManager.getBorder("CheckBox.border"));
		panel.setBackground(SystemColor.activeCaption);
		
		nombre = new JTextField();
		panel.add(nombre);
		nombre.setEditable(false);
		nombre.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		nombre.setColumns(10);
		
		telefono = new JTextField();
		panel.add(telefono);
		telefono.setEditable(false);
		telefono.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		telefono.setColumns(10);
		
		@SuppressWarnings("unused")
		FormController controlador=new FormController(this);
		ConfigController contro=new ConfigController(this);
		contro.cargar();
	}

	public JMenuItem getItemListadoDeClientes() {
		return itemListadoDeClientes;
	}

	public void setItemListadoDeClientes(JMenuItem itemListadoDeClientes) {
		this.itemListadoDeClientes = itemListadoDeClientes;
	}

	public JMenuItem getItemListadoDeHabitacion() {
		return itemListadoDeHabitacion;
	}

	public void setItemListadoDeHabitacion(JMenuItem itemListadoDeHabitacion) {
		this.itemListadoDeHabitacion = itemListadoDeHabitacion;
	}

	public JMenuItem getItemListadoDeServicio() {
		return itemListadoDeServicio;
	}

	public void setItemListadoDeServicio(JMenuItem itemListadoDeServicio) {
		this.itemListadoDeServicio = itemListadoDeServicio;
	}

	public JMenuItem getItemInformeDeHospedaje() {
		return itemInformeDeHospedaje;
	}

	public void setItemInformeDeHospedaje(JMenuItem itemInformeDeHospedaje) {
		this.itemInformeDeHospedaje = itemInformeDeHospedaje;
	}

	public JMenuItem getItemInformeDePago() {
		return itemInformeDePago;
	}

	public void setItemInformeDePago(JMenuItem itemInformeDePago) {
		this.itemInformeDePago = itemInformeDePago;
	}

	public JTextField getNombre() {
		return nombre;
	}

	public void setNombre(JTextField nombre) {
		this.nombre = nombre;
	}

	public JTextField getTelefono() {
		return telefono;
	}

	public void setTelefono(JTextField telefono) {
		this.telefono = telefono;
	}

	public JMenuItem getItemServicio() {
		return itemServicio;
	}

	public void setItemServicio(JMenuItem itemServicio) {
		this.itemServicio = itemServicio;
	}

	public JMenuItem getItemHabitacion() {
		return itemHabitacion;
	}

	public void setItemHabitacion(JMenuItem itemHabitacion) {
		this.itemHabitacion = itemHabitacion;
	}

	public JButton getBtnSalir() {
		return btnSalir;
	}

	public void setBtnSalir(JButton btnSalir) {
		this.btnSalir = btnSalir;
	}

	public JButton getBtnConbranza() {
		return btnConbranza;
	}

	public void setBtnConbranza(JButton btnConbranza) {
		this.btnConbranza = btnConbranza;
	}

	public JButton getBtnHospedaje() {
		return btnHospedaje;
	}

	public void setBtnHospedaje(JButton btnHospedaje) {
		this.btnHospedaje = btnHospedaje;
	}

	public JMenuItem getItemCliente() {
		return itemCliente;
	}

	public void setItemCliente(JMenuItem itemCliente) {
		this.itemCliente = itemCliente;
	}

	public JMenuItem getItemConfiguraciones() {
		return itemConfiguraciones;
	}

	public void setItemConfiguraciones(JMenuItem itemConfiguraciones) {
		this.itemConfiguraciones = itemConfiguraciones;
	}

	public JButton getBtnClientes() {
		return btnClientes;
	}

	public void setBtnClientes(JButton btnClientes) {
		this.btnClientes = btnClientes;
	}

	public JMenuItem getItemHospedaje() {
		return ItemHospedaje;
	}

	public void setItemHospedaje(JMenuItem itemHospedaje) {
		ItemHospedaje = itemHospedaje;
	}

	public JMenuItem getItemCobranza() {
		return ItemCobranza;
	}

	public void setItemCobranza(JMenuItem itemCobranza) {
		ItemCobranza = itemCobranza;
	}
}
