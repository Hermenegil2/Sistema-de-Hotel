package py.com.hoteleria.model;

public class Detalle {
		private int codigo;
		private Estadia estadia;
		private Servicio servicio;
		private double monto;
		
		public Detalle() {
			super();
			codigo=0;
			estadia=new Estadia();
			servicio=new Servicio();
			monto=0.0;
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

		public Servicio getServicio() {
			return servicio;
		}

		public void setServicio(Servicio servicio) {
			this.servicio = servicio;
		}

		public double getMonto() {
			return monto;
		}

		public void setMonto(double monto) {
			this.monto = monto;
		}
		
		
}
