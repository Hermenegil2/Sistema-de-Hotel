package py.com.hoteleria.model;

public class Config {
	private int codigo;
	private String nombre;
	private String telefono;
	
	public Config() {
		super();
		codigo=0;
		nombre="";
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

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	
}
