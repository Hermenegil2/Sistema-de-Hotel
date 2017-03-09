package py.com.hoteleria.lista;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import py.com.hoteleria.dao.HabitacionDAO;
import py.com.hoteleria.form.FormEstadia;
import py.com.hoteleria.model.Habitacion;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

@SuppressWarnings("serial")
public class ListaHabitacion extends JDialog {

	private JTable table;
	private JTextField campoBuscar;
	private JLabel lblNewLabel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListaHabitacion dialog = new ListaHabitacion();
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
	public ListaHabitacion() {
		setBounds(100, 100, 350, 300);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 331, 219);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (e.getClickCount()==2) {
					for (@SuppressWarnings("unused") int i : getTable().getSelectedRows()) {
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
				"Codigo", "Descripcion", "Monto"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(51);
		table.getColumnModel().getColumn(1).setPreferredWidth(122);
		table.getColumnModel().getColumn(2).setPreferredWidth(60);
		scrollPane.setViewportView(table);
		
		campoBuscar = new JTextField();
		campoBuscar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if ((e.getKeyChar()<'0' || e.getKeyChar()>'9')&&(e.getKeyChar()
						!= KeyEvent.VK_BACK_SPACE)&&(e.getKeyChar() != KeyEvent.VK_ENTER)){ 
					e.consume();
					limpiarTabla();
					listarDescripcionLista();
				}
			}
		});
		campoBuscar.setBounds(88, 230, 243, 24);
		getContentPane().add(campoBuscar);
		campoBuscar.setColumns(10);
		
		lblNewLabel = new JLabel("Buscar");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setBounds(10, 224, 83, 30);
		getContentPane().add(lblNewLabel);
        
	listarDescripcionLi();
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
	public void listarDescripcionLista(){
		ArrayList<Habitacion>habitacion=new ArrayList<Habitacion>();
        String descripcion=getCampoBuscar().getText();
		habitacion=HabitacionDAO.listarHabitacionDes(descripcion);
		DefaultTableModel modelo=(DefaultTableModel) getTable().getModel();
		Object[] fila=new Object[modelo.getColumnCount()];
		for (int i = 0; i <habitacion.size(); i++) {					
			fila[0]=habitacion.get(i).getCodigo();
			fila[1]=habitacion.get(i).getDescripcionHabitacion();
			fila[2]=habitacion.get(i).getMontoDia();
			modelo.addRow(fila);
		}
	}
	public void listarDescripcionLi(){
		ArrayList<Habitacion>habitacion=new ArrayList<Habitacion>();
		habitacion=HabitacionDAO.listarHabitacion();
		DefaultTableModel modelo=(DefaultTableModel) getTable().getModel();
		Object[] fila=new Object[modelo.getColumnCount()];
		for (int i = 0; i <habitacion.size(); i++) {					
			fila[0]=habitacion.get(i).getCodigo();
			fila[1]=habitacion.get(i).getDescripcionHabitacion();
			fila[2]=habitacion.get(i).getMontoDia();
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
        FormEstadia.ECodHab.setText(dato);
	}
}
