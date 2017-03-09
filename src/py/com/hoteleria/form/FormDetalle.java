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

@SuppressWarnings("serial")
public class FormDetalle extends JDialog {
	private JTextField Dtcodigo;
	private JTextField DtNroEstadia;
	public static JTextField DtCodServicio;
	public static JTextField DtMonto;
	private JButton btnGuardar;
	private JButton button;

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
		getContentPane().setBackground(SystemColor.activeCaption);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setBounds(6, 6, 55, 16);
		getContentPane().add(lblCodigo);
		
		JLabel lblNroEstadia = new JLabel("Nro. Estadia:");
		lblNroEstadia.setBounds(6, 34, 81, 16);
		getContentPane().add(lblNroEstadia);
		
		JLabel lblCodigoServicio = new JLabel("Codigo Servicio:");
		lblCodigoServicio.setBounds(6, 68, 95, 16);
		getContentPane().add(lblCodigoServicio);
		
		JLabel lblMonto = new JLabel("Monto:");
		lblMonto.setBounds(6, 106, 55, 16);
		getContentPane().add(lblMonto);
		
		Dtcodigo = new JTextField();
		Dtcodigo.setBounds(103, 0, 166, 28);
		getContentPane().add(Dtcodigo);
		Dtcodigo.setColumns(10);
		
		DtNroEstadia = new JTextField();
		DtNroEstadia.setColumns(10);
		DtNroEstadia.setBounds(103, 28, 166, 28);
		getContentPane().add(DtNroEstadia);
		
		DtCodServicio = new JTextField();
		DtCodServicio.setColumns(10);
		DtCodServicio.setBounds(103, 62, 144, 28);
		getContentPane().add(DtCodServicio);
		
		DtMonto = new JTextField();
		DtMonto.setColumns(10);
		DtMonto.setBounds(103, 100, 166, 28);
		getContentPane().add(DtMonto);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(103, 153, 90, 28);
		getContentPane().add(btnGuardar);
		
		button = new JButton("Guardar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ListaServicio l=new ListaServicio();
				l.setLocationRelativeTo(null);
				l.setVisible(true);
			}
		});
		button.setBounds(247, 62, 23, 28);
		getContentPane().add(button);
		
		@SuppressWarnings("unused")
		DetalleController controlador=new DetalleController(this);


	}

	public JTextField getDtcodigo() {
		return Dtcodigo;
	}

	public void setDtcodigo(JTextField dtcodigo) {
		Dtcodigo = dtcodigo;
	}

	public JTextField getDtNroEstadia() {
		return DtNroEstadia;
	}

	public void setDtNroEstadia(JTextField dtNroEstadia) {
		DtNroEstadia = dtNroEstadia;
	}

	public JTextField getDtCodServicio() {
		return DtCodServicio;
	}

	public void setDtCodServicio(JTextField dtCodServicio) {
		DtCodServicio = dtCodServicio;
	}

	public JTextField getDtMonto() {
		return DtMonto;
	}

	public void setDtMonto(JTextField dtMonto) {
		DtMonto = dtMonto;
	}

	public JButton getBtnGuardar() {
		return btnGuardar;
	}

	public void setBtnGuardar(JButton btnGuardar) {
		this.btnGuardar = btnGuardar;
	}

}
