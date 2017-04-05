package py.com.hoteleria.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import py.com.hoteleria.dao.DetalleDAO;
import py.com.hoteleria.form.FormDetalle;
import py.com.hoteleria.form.FormEstadia;
import py.com.hoteleria.model.Detalle;

public class DetalleController implements ActionListener{
	private FormDetalle ventana;
	private Detalle detalle;
	private DetalleDAO dao;
	private boolean modificar;
	
	
	public DetalleController(FormDetalle v){
		this.ventana=v;
		ventana.getBtnSalir().addActionListener(this);
		ventana.getBtnGuardar().addActionListener(this);
	}
	private void registrarDetalle() {
	if (FormDetalle.getDtNroEstadia().getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Debes Ingresar el Codigo de la Estadia");
			FormDetalle.getDtNroEstadia().requestFocus();
		}else if (FormDetalle.getDtCodServicio().getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Debes Ingresar el Codigo del Servicio");
			FormDetalle.getDtCodServicio().requestFocus();
		} else{
		 detalle=new Detalle();
	     detalle.getEstadia().setCodigo(Integer.parseInt(FormDetalle.getDtNroEstadia().getText()));
		 detalle.getServicio().setCodigo(Integer.parseInt(FormDetalle.getDtCodServicio().getText()));
		 detalle.setMonto(Double.parseDouble(FormDetalle.getDtMonto().getText()));
		 dao=new DetalleDAO();
		
        if(modificar==false){
        	dao.guardar(detalle);

		}
        
		}
	}
	public void listarDetalles(){
		ArrayList<Detalle> detalle=new ArrayList<Detalle>();
		@SuppressWarnings("static-access")
		int id=Integer.parseInt(ventana.getDtNroEstadia().getText());
		detalle=DetalleDAO.listarDetalle(id);
		DefaultTableModel modelo=(DefaultTableModel) FormEstadia.tableDetalle.getModel();
		Object[] fila=new Object[modelo.getColumnCount()];
	    for (int i = 0; i < detalle.size(); i++) {
	    	fila[0]=detalle.get(i).getCodigo();
	    	fila[1]=detalle.get(i).getEstadia().getCodigo();
	    	fila[2]=detalle.get(i).getServicio().getCodigo();
	    	fila[3]=detalle.get(i).getServicio().getDescripcionServicio();
	    	fila[4]=detalle.get(i).getMonto();
	    	modelo.addRow(fila);
	    }
		}
	private void limpiarTablaDetalle() {
		DefaultTableModel modelo=(DefaultTableModel) FormEstadia.tableDetalle.getModel();
		for (int i = 0; i < FormEstadia.tableDetalle.getRowCount(); i++) {
			modelo.removeRow(i);
			i-=1;
		}
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(ventana.getBtnSalir())) {
			ventana.dispose();
		}
		
		if (e.getSource().equals(ventana.getBtnGuardar())) {
			registrarDetalle();
			limpiarTablaDetalle();
			listarDetalles();
			FormDetalle.getDtCodServicio().setText("");
			FormDetalle.getDtMonto().setText("");
		}
		
		
	}

}