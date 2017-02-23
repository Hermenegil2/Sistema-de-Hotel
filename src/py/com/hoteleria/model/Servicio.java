package py.com.hoteleria.model;

public class Servicio {
	private int codigo;
	private String descripcionServicio;
	private double monto;
	private String observacion;
	
	public Servicio() {
		super();
		codigo=0;
		descripcionServicio="";
		monto=0.0;
		observacion="";
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescripcionServicio() {
		return descripcionServicio;
	}

	public void setDescripcionServicio(String descripcionServicio) {
		this.descripcionServicio = descripcionServicio;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

}
