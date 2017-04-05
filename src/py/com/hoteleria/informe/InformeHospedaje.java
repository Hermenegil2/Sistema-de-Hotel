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
		setBounds(100, 100, 800, 500);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 125, 764, 330);
		getContentPane().add(scrollPane);
		
		tableHospedaje = new JTable();
		tableHospedaje.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(95, 158, 160), new Color(95, 158, 160), new Color(95, 158, 160), new Color(95, 158, 160)));
		tableHospedaje.setFont(new Font("SansSerif", Font.BOLD, 12));
		tableHospedaje.setBackground(new Color(0, 191, 255));
		tableHospedaje.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nro. Estadia", "Fecha Entrada", "Clientes", "Habitacion", "Fecha Salida", "Monto", "Descuento", "Observacion"
			}
		));
		scrollPane.setViewportView(tableHospedaje);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(196, 6, 391, 113);
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
		Chasta.setBounds(78, 53, 150, 25);
		panel_2.add(Chasta);
		Chasta.setColumns(10);
		
		btnProcesarC = new JButton("Procesar");
		btnProcesarC.setBackground(new Color(0, 191, 255));
		btnProcesarC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnProcesarC.setFont(new Font("Pirate", Font.BOLD | Font.ITALIC, 23));
		btnProcesarC.setBounds(240, 27, 145, 47);
		panel_2.add(btnProcesarC);
		
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
		
		btnProcesarN = new JButton("Procesar");
		btnProcesarN.setBackground(new Color(0, 191, 255));
		btnProcesarN.setBounds(240, 27, 145, 47);
		panel_3.add(btnProcesarN);
		btnProcesarN.setFont(new Font("Pirate", Font.BOLD | Font.ITALIC, 23));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(95, 158, 160));
		panel.setBounds(6, 30, 171, 89);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		btnImprimir = new JButton("Imprimir");
		btnImprimir.setBounds(18, 20, 147, 49);
		panel.add(btnImprimir);
		btnImprimir.setBackground(new Color(0, 191, 255));
		btnImprimir.setFont(new Font("Ravie", Font.BOLD | Font.ITALIC, 14));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(95, 158, 160));
		panel_1.setBounds(603, 33, 171, 86);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		btnSalir = new JButton("Salir");
		btnSalir.setBounds(16, 19, 135, 49);
		panel_1.add(btnSalir);
		btnSalir.setBackground(new Color(0, 191, 255));
		btnSalir.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		
		
	     

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

	public JTable getTableHabitacion() {
		return tableHospedaje;
	}

	public void setTableHabitacion(JTable tableHabitacion) {
		this.tableHospedaje = tableHabitacion;
	}
	
}
