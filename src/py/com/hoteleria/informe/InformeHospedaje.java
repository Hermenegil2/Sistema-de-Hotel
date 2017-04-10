package py.com.hoteleria.informe;


import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.border.BevelBorder;

import py.com.hoteleria.informeControlador.InformeHospedajeControlador;

import com.toedter.calendar.JDateChooser;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

@SuppressWarnings("serial")
public class InformeHospedaje extends JDialog {
	private JTable tableHospedaje;
	private JTextField Cdesde;
	private JTextField Chasta;
	private JTextField Ndesde;
	private JTextField Nhasta;
	private JButton btnProcesarN;
	private JButton btnProcesarC;
	private JButton btnImprimir;
	private JButton btnSalir;
	private JDateChooser Fdesde;
	private JDateChooser Fhasta;
	private JButton btnProcesarF;
	private JTextField infoMontoTotal;
	private JTextField infoDescuento;
	private JTextField InfoMonto;
	private JButton btnTodoN;
	private JButton btnActivoN;
	private JButton btnTodoF;
	private JButton btnActivoF;
	private JButton btnTodoC;
	private JButton btnActivoC;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InformeHospedaje dialog = new InformeHospedaje();
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

	public InformeHospedaje() {
		setTitle("Informe de Hospedaje");
		getContentPane().setBackground(new Color(0, 191, 255));
		setBounds(100, 100, 1200, 543);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 125, 1164, 330);
		getContentPane().add(scrollPane);
		
		tableHospedaje = new JTable();
		tableHospedaje.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(95, 158, 160), new Color(95, 158, 160), new Color(95, 158, 160), new Color(95, 158, 160)));
		tableHospedaje.setFont(new Font("SansSerif", Font.BOLD, 12));
		tableHospedaje.setBackground(Color.WHITE);
		tableHospedaje.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nro. Estadia", "Fecha Entrada", "Clientes", "Habitacion", "Fecha Salida", "Monto", "Descuento", "Observacion", "Estado"
			}
		) {
			@SuppressWarnings("rawtypes")
			Class[] columnTypes = new Class[] {
				Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Boolean.class
			};
			@SuppressWarnings({ "unchecked", "rawtypes" })
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				true, true, true, true, true, true, true, true, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tableHospedaje.getColumnModel().getColumn(0).setPreferredWidth(59);
		tableHospedaje.getColumnModel().getColumn(2).setPreferredWidth(245);
		tableHospedaje.getColumnModel().getColumn(3).setPreferredWidth(57);
		tableHospedaje.getColumnModel().getColumn(7).setPreferredWidth(173);
		tableHospedaje.getColumnModel().getColumn(8).setResizable(false);
		scrollPane.setViewportView(tableHospedaje);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(275, 11, 633, 113);
		getContentPane().add(tabbedPane);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(95, 158, 160));
		tabbedPane.addTab("Buscar Por Codigo", null, panel_2, null);
		panel_2.setLayout(null);
		
		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(141, 5, 56, 20);
		panel_2.add(lblCodigo);
		lblCodigo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		
		Cdesde = new JTextField();
		Cdesde.setBounds(78, 27, 150, 25);
		panel_2.add(Cdesde);
		Cdesde.setColumns(10);
		
		JLabel lblDesde = new JLabel("Desde");
		lblDesde.setBounds(10, 22, 61, 26);
		panel_2.add(lblDesde);
		lblDesde.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		
		JLabel lblHasta = new JLabel("Hasta");
		lblHasta.setBounds(10, 48, 84, 26);
		panel_2.add(lblHasta);
		lblHasta.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		
		Chasta = new JTextField();
		Chasta.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					btnProcesarC.requestFocus();
				}
			}
		});
		Chasta.setBounds(78, 53, 150, 25);
		panel_2.add(Chasta);
		Chasta.setColumns(10);
		
		btnProcesarC = new JButton("Inactivo");
		btnProcesarC.setBackground(new Color(0, 191, 255));
		btnProcesarC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnProcesarC.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 23));
		btnProcesarC.setBounds(356, 27, 145, 49);
		panel_2.add(btnProcesarC);
		
		btnActivoC = new JButton("Activo");
		btnActivoC.setBounds(511, 27, 109, 49);
		panel_2.add(btnActivoC);
		btnActivoC.setFont(new Font("Arial", Font.BOLD, 23));
		btnActivoC.setBackground(new Color(0, 191, 255));
		
		btnTodoC = new JButton("Todo");
		btnTodoC.setBounds(251, 27, 95, 49);
		panel_2.add(btnTodoC);
		btnTodoC.setFont(new Font("Arial", Font.BOLD, 23));
		btnTodoC.setBackground(new Color(0, 191, 255));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(95, 158, 160));
		tabbedPane.addTab("Buscar Por Nombre", null, panel_3, null);
		panel_3.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(141, 5, 64, 18);
		panel_3.add(lblNombre);
		lblNombre.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		
		JLabel label_1 = new JLabel("Desde");
		label_1.setBounds(10, 22, 61, 26);
		panel_3.add(label_1);
		label_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		
		Ndesde = new JTextField();
		Ndesde.setBounds(78, 27, 150, 25);
		panel_3.add(Ndesde);
		Ndesde.setColumns(10);
		
		JLabel label_2 = new JLabel("Hasta");
		label_2.setBounds(10, 48, 84, 26);
		panel_3.add(label_2);
		label_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		
		Nhasta = new JTextField();
		Nhasta.setBounds(78, 53, 150, 25);
		panel_3.add(Nhasta);
		Nhasta.setColumns(10);
		
		btnProcesarN = new JButton("Inactivo");
		btnProcesarN.setBackground(new Color(0, 191, 255));
		btnProcesarN.setBounds(356, 27, 145, 49);
		panel_3.add(btnProcesarN);
		btnProcesarN.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 23));
		
		btnTodoN = new JButton("Todo");
		btnTodoN.setFont(new Font("Arial", Font.BOLD, 23));
		btnTodoN.setBackground(new Color(0, 191, 255));
		btnTodoN.setBounds(251, 27, 95, 49);
		panel_3.add(btnTodoN);
		
		btnActivoN = new JButton("Activo");
		btnActivoN.setFont(new Font("Arial", Font.BOLD, 23));
		btnActivoN.setBackground(new Color(0, 191, 255));
		btnActivoN.setBounds(511, 27, 109, 49);
		panel_3.add(btnActivoN);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(95, 158, 160));
		tabbedPane.addTab("Buscar por Fecha", null, panel_4, null);
		panel_4.setLayout(null);
		
		JLabel label = new JLabel("Desde");
		label.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		label.setBounds(10, 22, 61, 26);
		panel_4.add(label);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblFecha.setBounds(141, 5, 64, 18);
		panel_4.add(lblFecha);
		
		JLabel label_4 = new JLabel("Hasta");
		label_4.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		label_4.setBounds(10, 48, 84, 26);
		panel_4.add(label_4);
		
		btnProcesarF = new JButton("Inactivo");
		btnProcesarF.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 23));
		btnProcesarF.setBackground(new Color(0, 191, 255));
		btnProcesarF.setBounds(356, 27, 145, 49);
		panel_4.add(btnProcesarF);
		
		Fdesde = new JDateChooser();
		Fdesde.setBounds(78, 27, 150, 25);
		panel_4.add(Fdesde);
		
		Fhasta = new JDateChooser();
		Fhasta.setBounds(78, 53, 150, 25);
		panel_4.add(Fhasta);
		
		btnTodoF = new JButton("Todo");
		btnTodoF.setFont(new Font("Arial", Font.BOLD, 23));
		btnTodoF.setBackground(new Color(0, 191, 255));
		btnTodoF.setBounds(251, 27, 95, 49);
		panel_4.add(btnTodoF);
		
		btnActivoF = new JButton("Activo");
		btnActivoF.setFont(new Font("Arial", Font.BOLD, 23));
		btnActivoF.setBackground(new Color(0, 191, 255));
		btnActivoF.setBounds(511, 27, 109, 49);
		panel_4.add(btnActivoF);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(95, 158, 160));
		panel.setBounds(10, 25, 171, 89);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		btnImprimir = new JButton("Imprimir");
		btnImprimir.setBounds(18, 20, 147, 49);
		panel.add(btnImprimir);
		btnImprimir.setBackground(new Color(0, 191, 255));
		btnImprimir.setFont(new Font("Ravie", Font.BOLD | Font.ITALIC, 14));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(95, 158, 160));
		panel_1.setBounds(1003, 28, 171, 86);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		btnSalir = new JButton("Salir");
		btnSalir.setBounds(16, 19, 135, 49);
		panel_1.add(btnSalir);
		btnSalir.setBackground(new Color(0, 191, 255));
		btnSalir.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		
		JLabel lblMontoTotal = new JLabel("Monto Total");
		lblMontoTotal.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMontoTotal.setBounds(847, 466, 114, 27);
		getContentPane().add(lblMontoTotal);
		
		infoMontoTotal = new JTextField();
		infoMontoTotal.setFont(new Font("Tahoma", Font.BOLD, 16));
		infoMontoTotal.setBounds(971, 466, 156, 27);
		getContentPane().add(infoMontoTotal);
		infoMontoTotal.setColumns(10);
		
		JLabel lblDescuento = new JLabel("Descuento:");
		lblDescuento.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDescuento.setBounds(574, 466, 102, 27);
		getContentPane().add(lblDescuento);
		
		infoDescuento = new JTextField();
		infoDescuento.setFont(new Font("Tahoma", Font.BOLD, 16));
		infoDescuento.setColumns(10);
		infoDescuento.setBounds(686, 466, 150, 27);
		getContentPane().add(infoDescuento);
		
		JLabel lblMonto = new JLabel("Monto:");
		lblMonto.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMonto.setBounds(296, 466, 76, 27);
		getContentPane().add(lblMonto);
		
		InfoMonto = new JTextField();
		InfoMonto.setFont(new Font("Tahoma", Font.BOLD, 16));
		InfoMonto.setColumns(10);
		InfoMonto.setBounds(382, 466, 150, 27);
		getContentPane().add(InfoMonto);
		
		
	     @SuppressWarnings("unused")
		InformeHospedajeControlador controlador=new InformeHospedajeControlador(this);

	}

	public JTable getTableHospedaje() {
		return tableHospedaje;
	}

	public void setTableHospedaje(JTable tableHospedaje) {
		this.tableHospedaje = tableHospedaje;
	}

	public JTextField getCdesde() {
		return Cdesde;
	}

	public void setCdesde(JTextField cdesde) {
		Cdesde = cdesde;
	}

	public JTextField getChasta() {
		return Chasta;
	}

	public void setChasta(JTextField chasta) {
		Chasta = chasta;
	}

	public JTextField getNdesde() {
		return Ndesde;
	}

	public void setNdesde(JTextField ndesde) {
		Ndesde = ndesde;
	}

	public JTextField getNhasta() {
		return Nhasta;
	}

	public void setNhasta(JTextField nhasta) {
		Nhasta = nhasta;
	}

	public JButton getBtnProcesarN() {
		return btnProcesarN;
	}

	public void setBtnProcesarN(JButton btnProcesarN) {
		this.btnProcesarN = btnProcesarN;
	}

	public JButton getBtnProcesarC() {
		return btnProcesarC;
	}

	public void setBtnProcesarC(JButton btnProcesarC) {
		this.btnProcesarC = btnProcesarC;
	}

	public JButton getBtnImprimir() {
		return btnImprimir;
	}

	public void setBtnImprimir(JButton btnImprimir) {
		this.btnImprimir = btnImprimir;
	}

	public JButton getBtnSalir() {
		return btnSalir;
	}

	public void setBtnSalir(JButton btnSalir) {
		this.btnSalir = btnSalir;
	}

	public JDateChooser getFdesde() {
		return Fdesde;
	}

	public void setFdesde(JDateChooser fdesde) {
		Fdesde = fdesde;
	}

	public JDateChooser getFhasta() {
		return Fhasta;
	}

	public void setFhasta(JDateChooser fhasta) {
		Fhasta = fhasta;
	}

	public JButton getBtnProcesarF() {
		return btnProcesarF;
	}

	public void setBtnProcesarF(JButton btnProcesarF) {
		this.btnProcesarF = btnProcesarF;
	}

	public JTextField getInfoMontoTotal() {
		return infoMontoTotal;
	}

	public void setInfoMontoTotal(JTextField infoMontoTotal) {
		this.infoMontoTotal = infoMontoTotal;
	}

	public JTextField getInfoDescuento() {
		return infoDescuento;
	}

	public void setInfoDescuento(JTextField infoDescuento) {
		this.infoDescuento = infoDescuento;
	}

	public JTextField getInfoMonto() {
		return InfoMonto;
	}

	public void setInfoMonto(JTextField infoMonto) {
		InfoMonto = infoMonto;
	}

	public JButton getBtnTodoN() {
		return btnTodoN;
	}

	public void setBtnTodoN(JButton btnTodoN) {
		this.btnTodoN = btnTodoN;
	}

	public JButton getBtnActivoN() {
		return btnActivoN;
	}

	public void setBtnActivoN(JButton btnActivoN) {
		this.btnActivoN = btnActivoN;
	}

	public JButton getBtnTodoF() {
		return btnTodoF;
	}

	public void setBtnTodoF(JButton btnTodoF) {
		this.btnTodoF = btnTodoF;
	}

	public JButton getBtnActivoF() {
		return btnActivoF;
	}

	public void setBtnActivoF(JButton btnActivoF) {
		this.btnActivoF = btnActivoF;
	}

	public JButton getBtnTodoC() {
		return btnTodoC;
	}

	public void setBtnTodoC(JButton btnTodoC) {
		this.btnTodoC = btnTodoC;
	}

	public JButton getBtnActivoC() {
		return btnActivoC;
	}

	public void setBtnActivoC(JButton btnActivoC) {
		this.btnActivoC = btnActivoC;
	}
}
