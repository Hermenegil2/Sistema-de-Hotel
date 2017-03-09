package py.com.hoteleria.abm;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JPanel;

import java.awt.SystemColor;

import javax.swing.UIManager;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class FormConfig extends JDialog {
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormConfig dialog = new FormConfig();
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
	public FormConfig() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(UIManager.getBorder("CheckBox.border"));
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(0, 0, 434, 42);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblConfiguracion = new JLabel("Configuracion");
		lblConfiguracion.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		lblConfiguracion.setBounds(125, 11, 208, 31);
		panel.add(lblConfiguracion);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.activeCaption);
		panel_1.setBounds(0, 34, 434, 227);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre del Hotel:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel.setBounds(10, 23, 145, 22);
		panel_1.add(lblNewLabel);
		
		JLabel lblTelefonoDelHotel = new JLabel("Telefono del Hotel:");
		lblTelefonoDelHotel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblTelefonoDelHotel.setBounds(10, 56, 145, 22);
		panel_1.add(lblTelefonoDelHotel);
		
		textField = new JTextField();
		textField.setBounds(152, 26, 272, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(152, 59, 272, 20);
		panel_1.add(textField_1);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		btnGuardar.setBounds(93, 134, 106, 36);
		panel_1.add(btnGuardar);
		
		JButton btnModifiar = new JButton("Modificar");
		btnModifiar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		btnModifiar.setBounds(207, 134, 131, 36);
		panel_1.add(btnModifiar);

	}
}
