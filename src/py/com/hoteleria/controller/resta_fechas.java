package py.com.hoteleria.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import com.sun.xml.internal.ws.wsdl.writer.document.http.Address;

import py.com.hoteleria.form.FormEstadia;
import py.com.hoteleria.model.Estadia;

public class resta_fechas implements ActionListener{
	private FormEstadia ventana;
	private Estadia estadia;
	private static SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
	 private static Integer MILLSECS_PER_DAY = 24 * 60 * 60 * 1000;
       public resta_fechas(FormEstadia v){
    	   this.ventana=v;
       }
       
       public static String getFechaActual() {
    	      Date ahora = new Date();
    	      return formato.format(ahora);
    	  }
       
       public static String calculaMontoHabitacion(String fecha1, String fecha2, Estadia estadia){
 		  String monto = String.valueOf(estadia.getHabitacion().getMontoDia());		
 		  System.out.println(monto);
 		 String fechaHoy = getFechaActual();
		 if(fecha2.equals("__/__/____")){
			  fecha2 = fechaHoy;
		//	  System.out.println(fecha2+" fecha2");
		  }
			  Date fechaEntrada = retornarFecha(fecha1);
		  	Date fechaSalida = retornarFecha(fecha2);
		  	int diferencia = (int) ((fechaSalida.getTime()-fechaEntrada.getTime())/MILLSECS_PER_DAY)+1;
		  	
		  	if(diferencia>=0){
			  	monto = String.valueOf(estadia.getHabitacion().getMontoDia()*diferencia);
			 }
		  
 			  
 			return monto;
 	    }
       public static Date retornarFecha(Object object) {
			String text = (String) object;
			if (text == null) {
				return null;
			}
			GregorianCalendar gc = new GregorianCalendar();
			gc.setLenient(false);
			int i1 = text.indexOf('/');
			int i2 = text.indexOf('/', i1 + 1);
			String sdia = text.substring(0, i1);
			String smes = text.substring(i1 + 1, i2);
			String sanho = text.substring(i2 + 1, text.length());
			if (sdia.trim().equals("") || smes.equals("") || sanho.equals("")) {
				return null;
			} else {
				int dia = Integer.valueOf(sdia.replaceAll(" ", ""));
				int mes = Integer.valueOf(smes.replaceAll(" ", ""));
				int anho = Integer.valueOf(sanho.replaceAll(" ", ""));
				//if (anho < 80) {
				//	anho = 2000 + anho;
				//}
				if (anho >= 1 && anho < 100) {
					//Dos digitos
					//anho = 1900 + anho;
					anho = 2000 + anho;
				}
				gc.set(Calendar.DAY_OF_MONTH, dia);
				gc.set(Calendar.MONTH, mes - 1);
				gc.set(Calendar.YEAR, anho);
				//gc.set(Calendar.HOUR_OF_DAY, 0);
				//gc.set(Calendar.MINUTE, 0);
				//gc.set(Calendar.SECOND, 0);
				//gc.set(Calendar.MILLISECOND, 0);
				Date date = new Date(gc.getTimeInMillis());			
				return date;
			}
			
		}
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
	


