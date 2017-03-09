package py.com.hoteleria.lista;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import py.com.hoteleria.dao.ServicioDAO;
import py.com.hoteleria.form.FormDetalle;
import py.com.hoteleria.model.Servicio;

@SuppressWarnings("serial")
public class ListaServicio extends JDialog {
	private JTable table;
	private JTextField campoBuscar;
	private JLabel lblNewLabel;
	DecimalFormat formatea = new DecimalFormat("###,###.##"+" Gs");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListaServicio dialog = new ListaServicio();
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
	public ListaServicio() {
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
					listarServicio();
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
        
		listarServicio();
	
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
	
	private void listarServicio(){
		ArrayList<Servicio> servicio=new ArrayList<Servicio>();
		String ser=getTextField().getText();
		servicio=ServicioDAO.listarServicioDes(ser);
		DefaultTableModel modelo=(DefaultTableModel) getTable().getModel();
			Object[] fila=new Object[modelo.getColumnCount()];
			for (int i = 0; i <servicio.size(); i++) {					
				fila[0]=servicio.get(i).getCodigo();
				fila[1]=servicio.get(i).getDescripcionServicio();
				fila[2]=formatea.format(servicio.get(i).getMonto());
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
		String dato1=String.valueOf(this.getTable().getValueAt(fila, 2));
		FormDetalle.DtCodServicio.setText(dato);
		FormDetalle.DtMonto.setText(dato1);
	}
}
