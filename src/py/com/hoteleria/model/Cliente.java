package py.com.hoteleria.model;

public class Cliente {
	private int codigo;
	private String nombre;
	private int cedula;
	private String ruc;
	private String direccion;
	private String telefono;
	
	public Cliente() {
		super();
		codigo=0;
		nombre="";
		cedula=0;
		ruc="";
		direccion="";
		telefono="";
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCedula() {
		return cedula;
	}

	public void setCedula(int cedula) {
		this.cedula = cedula;
	}

	public String getRuc() {
		return ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return "Cliente [codigo=" + codigo + ", nombre=" + nombre + ", cedula="
				+ cedula + ", ruc=" + ruc + ", direccion=" + direccion
				+ ", telefono=" + telefono + "]";
	}


	
	
}
