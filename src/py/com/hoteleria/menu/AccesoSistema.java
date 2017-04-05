package py.com.hoteleria.menu;


import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.SystemColor;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import java.awt.Color;

@SuppressWarnings("serial")
public class AccesoSistema extends JDialog {
	private JTextField textField;
	private JPasswordField contra;
	private JButton btnIngresar;
	private final JPanel panel_1 = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AccesoSistema dialog = new AccesoSistema();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setLocationRelativeTo(null);
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
	public AccesoSistema() {
		setUndecorated(true);
		getContentPane().setBackground(SystemColor.activeCaption);
		setBounds(100, 100, 437, 259);
		getContentPane().setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("TimesHeavy", Font.BOLD, 15));
		lblUsuario.setBounds(78, 56, 77, 14);
		getContentPane().add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setFont(new Font("TimesHeavy", Font.BOLD, 15));
		lblContrasea.setBounds(78, 122, 100, 14);
		getContentPane().add(lblContrasea);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					contra.requestFocus();
					
				}
			}
		});
		textField.setBounds(176, 48, 183, 30);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		contra = new JPasswordField();
		contra.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					btnIngresar.requestFocus();
				}
			}
		});
		contra.setBounds(174, 114, 185, 30);
		getContentPane().add(contra);
		
		btnIngresar = new JButton("Ingresar");
		btnIngresar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyCode()==KeyEvent.VK_ENTER) {
					accesoSistema();
					dispose();
				}
			}
		});
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				accesoSistema();
				this.dispose();
			   
			}

			private void dispose() {
				
				
			}
		});
		btnIngresar.setFont(new Font("TimesHeavy", Font.BOLD, 15));
		btnIngresar.setBounds(78, 183, 118, 35);
		getContentPane().add(btnIngresar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnSalir.setFont(new Font("TimesHeavy", Font.BOLD, 15));
		btnSalir.setBounds(247, 183, 118, 35);
		getContentPane().add(btnSalir);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setBorder(new TitledBorder(null, "Sesion", TitledBorder.CENTER, TitledBorder.TOP, null, Color.WHITE));
		panel.setBounds(17, 18, 399, 219);
		getContentPane().add(panel);
		panel_1.setBackground(SystemColor.activeCaption);
		panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.window));
		panel_1.setBounds(6, 6, 425, 247);
		getContentPane().add(panel_1);


	}
	private void accesoSistema() {
		String Usuario="hotel";
		String Contraseña="1234";
		String passw=new String(contra.getPassword());
		if(textField.getText().equals(Usuario) &&  passw.equals(Contraseña) ){
			MenuPrincipal gasto=new MenuPrincipal();
			gasto.setVisible(true);
		    
		} else {
			JOptionPane.showMessageDialog(null, "Usuario o Contraseña No es Valido");
		    AccesoSistema ac=new AccesoSistema();
		    ac.setLocationRelativeTo(null);
		    ac.setVisible(true);
		
		}
		Limpiar();
		}
		
  
	
	private void Limpiar() {
		textField.setText("");
		contra.setText("");

	}
}