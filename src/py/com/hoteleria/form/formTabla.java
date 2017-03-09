package py.com.hoteleria.form;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.DecimalFormat;

public class formTabla extends JDialog {
	private JTable table;
	private JTextField textField;
	DecimalFormat formatea = new DecimalFormat("###,###.##"+" Gs");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					formTabla dialog = new formTabla();
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
	public formTabla() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, "4000"},
				{null, "5000"},
				{null, "6000"},
			},
			new String[] {
				"New column", "New column"
			}
		));
		table.setBounds(81, 35, 267, 48);
		getContentPane().add(table);
		
		textField = new JTextField();
		textField.setBounds(214, 102, 134, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnSumar = new JButton("Sumar");
		btnSumar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				totalServicio();
			}
		});
		btnSumar.setBounds(115, 101, 89, 23);
		getContentPane().add(btnSumar);

	}
	public void totalServicio(){
		int total=0;
    	for (int i = 0; i < table.getRowCount(); i++) {
			int numero=0;
			
			try {
				numero=Integer.valueOf(table.getValueAt(i, 1).toString());
			} catch (NumberFormatException e) {
				numero=0;
			table.setValueAt(0, i, 1);
			}
			total+=numero;
		}
    	textField.setText(String.valueOf(formatea.format(total)));
   
}
}
