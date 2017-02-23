package py.com.hoteleria.model;

public class Habitacion {
	private int codigo;
	private String descripcionHabitacion;
	private double montoDia;
	private String observacion;
	
	public Habitacion() {
		super();
		codigo=0;
		descripcionHabitacion="";
		montoDia=0.0;
		observacion="";
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescripcionHabitacion() {
		return descripcionHabitacion;
	}

	public void setDescripcionHabitacion(String descripcionHabitacion) {
		this.descripcionHabitacion = descripcionHabitacion;
	}

	public double getMontoDia() {
		return montoDia;
	}

	public void setMontoDia(double montoDia) {
		this.montoDia = montoDia;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	
	
}
