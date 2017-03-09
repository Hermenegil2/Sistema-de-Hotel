package py.com.hoteleria.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import py.com.hoteleria.dao.FechaDAO;
import py.com.hoteleria.form.FormEstadia;
import py.com.hoteleria.model.Estadia;
import py.com.hoteleria.model.Fecha;

public class FechaController implements ActionListener,KeyListener,MouseListener {
	private FormEstadia ventana;
	private FechaDAO dao;
	private Fecha fecha;
	
	public FechaController(FormEstadia v){
		this.ventana=v;
		this.ventana.getEfechaSalida().addKeyListener(this);
		this.ventana.getEcosto().addActionListener(this);
		this.ventana.getEfechaSalida().addMouseListener(this);
	}
		public void cargar(){
			     int datoId=Integer.parseInt(ventana.getEcodigo().getText());
			     fecha=FechaDAO.fechaId(datoId);
				 ventana.getEservicio().setText(Integer.toString(fecha.getDatos()));
			
			}
		private void guardarFech() {
			Estadia estadia=new Estadia();
			estadia.setCodigo(Integer.parseInt(ventana.getEcodigo().getText()));
			estadia.setFechaSalida(ventana.getEfechaSalida().getDate());
			dao=new FechaDAO();
			dao.guardar(estadia);

		}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(ventana.getEcosto())) {
			cargar();
		}
		if (e.getSource().equals(ventana.getEfechaSalida())) {
			cargar();
		}
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getSource().equals(ventana.getEfechaSalida())){
			if(e.getKeyCode()==KeyEvent.VK_ENTER){
				cargar();
			    
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
	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getClickCount()==1) {
		 ventana.getEfechaSalida();
		     cargar();
			}
	            
		
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent  e) {
		if ((e.getClickCount()==1)) {
			 ventana.getEfechaSalida();
			     cargar();
				}
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
