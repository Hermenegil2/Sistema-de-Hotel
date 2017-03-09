package py.com.hoteleria.controller;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

public class resta_fech extends JDialog {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField Tdia;
	private JDateChooser fechaActual;
	private JDateChooser fechaInicio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					resta_fech dialog = new resta_fech();
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
	public resta_fech() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(61, 95, 142, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(213, 95, 175, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		Tdia = new JTextField();
		Tdia.setBounds(61, 147, 162, 20);
		getContentPane().add(Tdia);
		Tdia.setColumns(10);
		
		fechaActual = new JDateChooser();
		fechaActual.setBounds(239, 28, 142, 20);
		getContentPane().add(fechaActual);
		
		fechaInicio = new JDateChooser();
		fechaInicio.setBounds(61, 28, 142, 20);
		getContentPane().add(fechaInicio);
      
	}

	public JDateChooser getFechaActual() {
		return fechaActual;
	}

	public void setFechaActual(JDateChooser fechaActual) {
		this.fechaActual = fechaActual;
	}

	public JDateChooser getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(JDateChooser fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public JTextField getTextField() {
		return textField;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}

	public JTextField getTextField_1() {
		return textField_1;
	}

	public void setTextField_1(JTextField textField_1) {
		this.textField_1 = textField_1;
	}

	public JTextField getTdia() {
		return Tdia;
	}

	public void setTdia(JTextField tdia) {
		Tdia = tdia;
	}
}
