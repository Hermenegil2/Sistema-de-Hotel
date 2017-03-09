package py.com.hoteleria.model;

import java.util.Date;

public class Fecha {
	private Integer datos;
    private Date fechaInicio;
    private Date fechaActual;
	public Fecha() {
		super();
		datos=0;
		fechaActual=new Date();
		fechaInicio=new Date();
		
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaActual() {
		return fechaActual;
	}

	public void setFechaActual(Date fechaActual) {
		this.fechaActual = fechaActual;
	}

	public Integer getDatos() {
		return datos;
	}

	public void setDatos(Integer datos) {
		this.datos = datos;
	}
	
	
}
