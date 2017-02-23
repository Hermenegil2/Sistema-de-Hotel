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

import py.com.hoteleria.controller.FormController;

@SuppressWarnings("serial")
public class MenuPrincipal extends JFrame {
	private JMenuItem itemCliente;
	private JButton btnCliente;
	private JButton btnSalir;
	private JButton btnConbranza;
	private JButton btnHospedaje;
	private JMenuItem itemServicio;
	private JMenuItem itemHabitacion;

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
		setExtendedState(MAXIMIZED_BOTH);
		setBounds(100, 100, 800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnProceso_1 = new JMenu("");
		mnProceso_1.setIcon(new ImageIcon("C:\\Users\\Hermenegil2\\Desktop\\Sistema de Hotel\\img\\proceso.png"));
		mnProceso_1.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 20));
		menuBar.add(mnProceso_1);
		
		JMenuItem mntmHospedaje = new JMenuItem("Hospedaje");
		mnProceso_1.add(mntmHospedaje);
		
		JMenuItem mntmCobranza = new JMenuItem("Cobranza");
		mnProceso_1.add(mntmCobranza);
		
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
		
		JMenuItem mntmListadoDeClientes = new JMenuItem("Listado de Clientes");
		mnInformes.add(mntmListadoDeClientes);
		
		JMenuItem mntmListadoDeHabitacion = new JMenuItem("Listado de Habitacion");
		mnInformes.add(mntmListadoDeHabitacion);
		
		JMenuItem mntmListadoDeServicio = new JMenuItem("Listado de Servicio");
		mnInformes.add(mntmListadoDeServicio);
		
		JMenuItem mntmInformeDeHospedaje = new JMenuItem("Informe de Hospedaje");
		mnInformes.add(mntmInformeDeHospedaje);
		
		JMenuItem mntmInformeDePago = new JMenuItem("Informe de Pago");
		mnInformes.add(mntmInformeDePago);
		
		JMenu mnConfiguraciones = new JMenu("");
		mnConfiguraciones.setIcon(new ImageIcon("C:\\Users\\Hermenegil2\\Desktop\\Sistema de Hotel\\img\\utilidades.png"));
		mnConfiguraciones.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 20));
		menuBar.add(mnConfiguraciones);
		
		JMenuItem mntmInicializacionDeDatos = new JMenuItem("Inicializacion de Datos");
		mnConfiguraciones.add(mntmInicializacionDeDatos);
		
		JMenuItem mntmConfiguraciones = new JMenuItem("Configuraciones");
		mnConfiguraciones.add(mntmConfiguraciones);
		getContentPane().setLayout(null);
		
		btnHospedaje = new JButton("");
		btnHospedaje.setIcon(new ImageIcon("C:\\Users\\Hermenegil2\\Desktop\\Sistema de Hotel\\img\\hospedaje.png"));
		btnHospedaje.setBounds(10, 99, 221, 52);
		getContentPane().add(btnHospedaje);
		
		btnConbranza = new JButton("");
		btnConbranza.setIcon(new ImageIcon("C:\\Users\\Hermenegil2\\Desktop\\Sistema de Hotel\\img\\cobranza.png"));
		btnConbranza.setBounds(10, 166, 221, 52);
		getContentPane().add(btnConbranza);
		
		btnCliente = new JButton("");
		btnCliente.setIcon(new ImageIcon("C:\\Users\\Hermenegil2\\Desktop\\Sistema de Hotel\\img\\clientes.png"));
		btnCliente.setBounds(1146, 99, 156, 52);
		getContentPane().add(btnCliente);
		
		btnSalir = new JButton("");
		btnSalir.setIcon(new ImageIcon("C:\\Users\\Hermenegil2\\Desktop\\Sistema de Hotel\\img\\SALIR.png"));
		btnSalir.setBounds(1168, 162, 119, 44);
		getContentPane().add(btnSalir);
		
		JLabel lblNewLabel_1 = new JLabel("Version 1.1");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1.setBounds(10, 581, 231, 52);
		getContentPane().add(lblNewLabel_1);
		
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
		
		JLabel lblNewLabel = new JLabel("Sabado, 23 Mayo 2017");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Hermenegil2\\Desktop\\Sistema de Hotel\\img\\\u00EDndice.jpg"));
		lblNewLabel.setForeground(Color.ORANGE);
		lblNewLabel.setBackground(new Color(0, 153, 204));
		lblNewLabel.setBounds(0, 0, 1354, 694);
		getContentPane().add(lblNewLabel);
		
		@SuppressWarnings("unused")
		FormController controlador=new FormController(this);
		
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

	public JButton getBtnCliente() {
		return btnCliente;
	}

	public void setBtnCliente(JButton btnCliente) {
		this.btnCliente = btnCliente;
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
}
