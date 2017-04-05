package py.com.hoteleria.form;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import py.com.hoteleria.controller.DetalleController;
import py.com.hoteleria.lista.ListaServicio;

import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

@SuppressWarnings("serial")
public class FormDetalle extends JDialog {
	public static JTextField DtNroEstadia;
	public static JTextField DtCodServicio;
	public static JTextField DtMonto;
	private JButton btnGuardar;
	private JButton button;
	private JButton btnSalir;
	private final JPanel panel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormDetalle dialog = new FormDetalle();
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
	public FormDetalle() {
		setUndecorated(true);
		getContentPane().setBackground(SystemColor.activeCaption);
		setBounds(100, 100, 361, 218);
		getContentPane().setLayout(null);
		panel.setBackground(SystemColor.activeCaption);
		panel.setBorder(new TitledBorder(null, "Detalle", TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.window));
		panel.setBounds(10, 13, 341, 195);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNroEstadia = new JLabel("Nro. Estadia:");
		lblNroEstadia.setBounds(10, 32, 89, 16);
		panel.add(lblNroEstadia);
		lblNroEstadia.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		DtNroEstadia = new JTextField();
		DtNroEstadia.setBounds(123, 28, 203, 28);
		panel.add(DtNroEstadia);
		DtNroEstadia.setEditable(false);
		DtNroEstadia.setFont(new Font("SansSerif", Font.BOLD, 14));
		DtNroEstadia.setColumns(10);
		
		JLabel lblCodigoServicio = new JLabel("Servicio:");
		lblCodigoServicio.setBounds(10, 64, 89, 16);
		panel.add(lblCodigoServicio);
		lblCodigoServicio.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		DtCodServicio = new JTextField();
		DtCodServicio.setBounds(123, 59, 179, 28);
		panel.add(DtCodServicio);
		DtCodServicio.setFont(new Font("SansSerif", Font.BOLD, 14));
		DtCodServicio.setEditable(false);
		DtCodServicio.setColumns(10);
		
		JLabel lblMonto = new JLabel("Monto:");
		lblMonto.setBounds(10, 98, 89, 16);
		panel.add(lblMonto);
		lblMonto.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		DtMonto = new JTextField();
		DtMonto.setBounds(123, 93, 203, 28);
		panel.add(DtMonto);
		DtMonto.setFont(new Font("SansSerif", Font.BOLD, 14));
		DtMonto.setEditable(false);
		DtMonto.setColumns(10);
		
		button = new JButton("Guardar");
		button.setBounds(303, 59, 23, 28);
		panel.add(button);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(21, 142, 123, 28);
		panel.add(btnGuardar);
		btnGuardar.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		btnSalir = new JButton("Salir");
		btnSalir.setBounds(179, 142, 133, 28);
		panel.add(btnSalir);
		btnSalir.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.activeCaption);
		panel_1.setBorder(UIManager.getBorder("TitledBorder.border"));
		panel_1.setBounds(0, 0, 361, 218);
		getContentPane().add(panel_1);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ListaServicio l=new ListaServicio();
				l.setLocationRelativeTo(null);
				l.setVisible(true);
			}
		});
		
		@SuppressWarnings("unused")
		DetalleController controlador=new DetalleController(this);


	}

	public JButton getBtnSalir() {
		return btnSalir;
	}

	public void setBtnSalir(JButton btnSalir) {
		this.btnSalir = btnSalir;
	}


	public static JTextField getDtNroEstadia() {
		return DtNroEstadia;
	}

	public static void setDtNroEstadia(JTextField dtNroEstadia) {
		DtNroEstadia = dtNroEstadia;
	}

	public static JTextField getDtCodServicio() {
		return DtCodServicio;
	}

	public static void setDtCodServicio(JTextField dtCodServicio) {
		DtCodServicio = dtCodServicio;
	}

	public static JTextField getDtMonto() {
		return DtMonto;
	}

	public static void setDtMonto(JTextField dtMonto) {
		DtMonto = dtMonto;
	}

	public JButton getBtnGuardar() {
		return btnGuardar;
	}

	public void setBtnGuardar(JButton btnGuardar) {
		this.btnGuardar = btnGuardar;
	}
}
