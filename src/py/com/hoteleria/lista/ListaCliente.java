package py.com.hoteleria.lista;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import py.com.hoteleria.dao.ClienteDAO;
import py.com.hoteleria.form.FormEstadia;
import py.com.hoteleria.model.Cliente;

import java.awt.Font;
import java.util.ArrayList;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import java.awt.SystemColor;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class ListaCliente extends JDialog {
	private JTable table;
	private JTextField campoBuscar;
	private JLabel lblNewLabel;
	private JPanel panel;
	private JPanel panel_1;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListaCliente dialog = new ListaCliente();
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
	public ListaCliente() {
		setUndecorated(true);
		getContentPane().setBackground(SystemColor.activeCaption);
		setModal(true);
		setBounds(100, 100, 401, 310);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 33, 352, 212);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (e.getClickCount()==2) {
					for (@SuppressWarnings("unused") int i :getTable().getSelectedRows()) {
						pasarCampoTabl();
						dispose();
			            
					
				}
				
				}
				
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount()==2) {
					for (@SuppressWarnings("unused") int i : getTable().getSelectedRows()) {
					  pasarCampoTabl();
					   dispose();
					}
				}
			}
			
	
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Codigo", "Nombre y Apellido", "Cedula"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(51);
		table.getColumnModel().getColumn(1).setPreferredWidth(122);
		table.getColumnModel().getColumn(2).setPreferredWidth(60);
		scrollPane.setViewportView(table);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Busqueda de Clientes", TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.window));
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(10, 11, 377, 288);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnSalir.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSalir.setBounds(278, 254, 89, 23);
		panel.add(btnSalir);
		
		lblNewLabel = new JLabel("Buscar");
		lblNewLabel.setBounds(10, 246, 83, 30);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		
		campoBuscar = new JTextField();
		campoBuscar.setBounds(88, 253, 180, 24);
		panel.add(campoBuscar);
		campoBuscar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if ((e.getKeyChar()<'0' || e.getKeyChar()>'9')&&(e.getKeyChar()
						!= KeyEvent.VK_BACK_SPACE)&&(e.getKeyChar() != KeyEvent.VK_ENTER)){ 
					e.consume();
					limpiarTabla();
					listarNombreApellido();
				}
			}
		});
		campoBuscar.setColumns(10);
		
		panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.activeCaption);
		panel_1.setBorder(UIManager.getBorder("TitledBorder.border"));
		panel_1.setBounds(0, 0, 401, 310);
		getContentPane().add(panel_1);
        
		listarNombreApellido();
	
	}

	

	public JTable getTable() {
		return table;
	}

	public JTextField getCampoBuscar() {
		return campoBuscar;
	}

	public void setCampoBuscar(JTextField campoBuscar) {
		this.campoBuscar = campoBuscar;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public JTextField getTextField() {
		return campoBuscar;
	}

	public void setTextField(JTextField textField) {
		this.campoBuscar = textField;
	}
	
	private void listarNombreApellido(){
		ArrayList<Cliente> cliente=new ArrayList<Cliente>();
		String nombreApellido=getTextField().getText();
		cliente=ClienteDAO.listasCliente(nombreApellido);
		DefaultTableModel modelo=(DefaultTableModel) getTable().getModel();
			Object[] fila=new Object[modelo.getColumnCount()];
			for (int i = 0; i <cliente.size(); i++) {					
				fila[0]=cliente.get(i).getCodigo();
				fila[1]=cliente.get(i).getNombre();
				fila[2]=cliente.get(i).getCedula();
				modelo.addRow(fila);
			}
		
}
	public void limpiarTabla() {
		DefaultTableModel modelo=(DefaultTableModel) getTable().getModel();
		for (int i = 0; i < getTable().getRowCount(); i++) {
			modelo.removeRow(i);
			i-=1;
		}
		
	}
	private void pasarCampoTabl() {
		Integer fila = this.getTable().getSelectedRow();
		String dato = String.valueOf(this.getTable().getValueAt( fila, 0 ));
		String nombre=String.valueOf(this.getTable().getValueAt(fila, 1));
        FormEstadia.ECodCliente.setText(dato);
        FormEstadia.Enombre.setText(nombre);
        
	}
}
