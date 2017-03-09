package py.com.hoteleria.model;

import java.util.Date;

public class Cobranza {
	private int codigo;
	private Date fecha;
	private double montoPagado;
	private Deuda deuda;
	private Cliente cliente;
	
	public Cobranza() {
		super();
		codigo=0;
		fecha=new Date();
		montoPagado=0.0;
		deuda=new Deuda();
		cliente=new Cliente();
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public double getMontoPagado() {
		return montoPagado;
	}

	public void setMontoPagado(double montoPagado) {
		this.montoPagado = montoPagado;
	}

	public Deuda getDeuda() {
		return deuda;
	}

	public void setDeuda(Deuda deuda) {
		this.deuda = deuda;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	

}
