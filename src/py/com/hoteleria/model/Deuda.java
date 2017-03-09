package py.com.hoteleria.model;

public class Deuda {
	private int codigo;
	private Estadia estadia;
	private Cliente cliente;
	private double montoDeuda;
	private double montoPagado;
	
	public Deuda() {
		super();
		codigo=0;
		estadia=new Estadia();
		cliente=new Cliente();
		montoDeuda=0.0;
		montoPagado=0.0;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Estadia getEstadia() {
		return estadia;
	}

	public void setEstadia(Estadia estadia) {
		this.estadia = estadia;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public double getMontoDeuda() {
		return montoDeuda;
	}

	public void setMontoDeuda(double montoDeuda) {
		this.montoDeuda = montoDeuda;
	}

	public double getMontoPagado() {
		return montoPagado;
	}

	public void setMontoPagado(double montoPagado) {
		this.montoPagado = montoPagado;
	}
	
	
	
	

}
