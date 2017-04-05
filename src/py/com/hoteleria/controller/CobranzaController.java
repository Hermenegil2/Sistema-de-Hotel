package py.com.hoteleria.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import py.com.hoteleria.dao.CobranzaDAO;
import py.com.hoteleria.form.FormCobranza;
import py.com.hoteleria.model.Cobranza;


public class CobranzaController implements ActionListener,KeyListener {
	private FormCobranza ventana;
	private Cobranza cobranza;
	private CobranzaDAO dao;
	private boolean modificar;
	DecimalFormat formatea = new DecimalFormat("###,###.##"+" Gs");
	
	public CobranzaController(FormCobranza v){
		this.ventana=v;
		ventana.getBtnBuscarDueda().addActionListener(this);
		ventana.getBtnGuardar().addActionListener(this);
		ventana.getBtnSalir().addActionListener(this);
		
	}
	@SuppressWarnings({ "static-access", "deprecation" })
	private void registrarCobranza() {
		if (ventana.getCnroDeuda().getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Debes Ingresar el Codigo de la deuda");
			ventana.getCnroDeuda().requestFocus();
		}else if (ventana.getCcodCliente().getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Debes Ingresar el Codigo del cliente");
			ventana.getCcodCliente().requestFocus();
		} else{
		 cobranza=new Cobranza();
		 cobranza.setFecha(new Date(ventana.getCfecha().getText()));
		 cobranza.setMontoPagado(Double.parseDouble(ventana.getCmontoPagado().getText()));
		 cobranza.getDeuda().setCodigo(Integer.parseInt(ventana.getCnroDeuda().getText()));
		 cobranza.getCliente().setCodigo(Integer.parseInt(ventana.getCcodCliente().getText()));
		 dao=new CobranzaDAO();
		
        if(modificar==false){
        	dao.guardar(cobranza);
   
		}else{
			cobranza.setCodigo(Integer.parseInt(ventana.getCcodigo().getText()));
			dao.modificarCobranza(cobranza);
		}
        
		}
	}
	public void obtenerUltimoId() {
		cobranza=CobranzaDAO.obtenerUltimoId();
		ventana.getCcodigo().setText(Integer.toString(cobranza.getCodigo()));

	}
	
	public void listarCobranza(){
		DefaultTableModel modelo=(DefaultTableModel) ventana.getCtablaCobranza().getModel();
		ArrayList<Cobranza>lista=CobranzaDAO.listarCobranza();
		Object[] fila=new Object[modelo.getColumnCount()];
	    for (int i = 0; i < lista.size(); i++) {
	    	fila[0]=lista.get(i).getCodigo();
	    	fila[1]=lista.get(i).getCliente().getNombre();
	    	fila[2]=formatea.format(lista.get(i).getDeuda().getMontoDeuda());
	    	fila[3]=formatea.format(lista.get(i).getMontoPagado());
	    	modelo.addRow(fila);
	    }
		}
	public void limpiarTabla() {
		DefaultTableModel modelo=(DefaultTableModel) ventana.getCtablaCobranza().getModel();
		for (int i = 0; i < ventana.getCtablaCobranza().getRowCount(); i++) {
			modelo.removeRow(i);
			i-=1;
		}
		
	}
	@SuppressWarnings("static-access")
	public void cargar(int id){
		dao=new CobranzaDAO();
		cobranza=dao.CobranzaId(id);
			ventana.getCcodigo().setText(Integer.toString(cobranza.getCodigo()));
			
			ventana.getCmontoPagado().setText(Double.toString(cobranza.getMontoPagado()));
			ventana.getCnroDeuda().setText(Integer.toString(cobranza.getDeuda().getCodigo()));
			ventana.getCcodCliente().setText(Integer.toString(cobranza.getCliente().getCodigo()));
		}
	private void seleccionarFila() {
		int row =ventana.getCtablaCobranza().getSelectedRow();
		Integer id=Integer.parseInt(ventana.getCtablaCobranza().getValueAt(row, 0).toString().trim());
		cargar(id);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(ventana.getBtnSalir())) {
		ventana.dispose();
		}
		
		if (e.getSource().equals(ventana.getBtnGuardar())) {
			registrarCobranza();
			limpiarTabla();
			listarCobranza();
		}
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getSource().equals(ventana.getCtablaCobranza())){
			if(e.getKeyCode()==KeyEvent.VK_ENTER){
				seleccionarFila();
				this.ventana.getBtnGuardar().setEnabled(false);
				this.ventana.getBtnModificar().setEnabled(true);
				this.ventana.getBtnEliminar().setEnabled(true);
				
			
			}
			
		
		}
		
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
