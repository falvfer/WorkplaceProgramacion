package prExamen241204;

public class Reserva {

// Variables de instancia
	private Cliente clienteReserva;
	private Vehiculo vehiculoReserva;
	private byte diasAlquiler;
	private boolean seguroAdicional;

// Getters y Setters
	public Cliente getClienteReserva() {return clienteReserva;}
	public Vehiculo getVehiculoReserva() {return vehiculoReserva;}
	public byte getDiasAlquiler() {return diasAlquiler;}
	public boolean isSeguroAdicional() {return seguroAdicional;}
	
	public void setClienteReserva(Cliente clienteReserva) {this.clienteReserva = clienteReserva;}
	public void setVehiculoReserva(Vehiculo vehiculoReserva) {this.vehiculoReserva = vehiculoReserva;}
	public void setDiasAlquiler(byte diasAlquiler) {this.diasAlquiler = diasAlquiler;}
	public void setSeguroAdicional(boolean seguroAdicional) {this.seguroAdicional = seguroAdicional;}

// Constructores
	public Reserva(Cliente clienteReserva, Vehiculo vehiculoReserva, byte diasAlquiler, boolean seguroAdicional) {
		this.clienteReserva = clienteReserva;
		this.vehiculoReserva = vehiculoReserva;
		this.diasAlquiler = diasAlquiler;
		this.seguroAdicional = seguroAdicional;
	}
	
// Métodos públicos
	public float precioTotal() {
		float precioBruto = this.vehiculoReserva.getPrecioAlquilerDia() * this.diasAlquiler
				+ (this.vehiculoReserva.impuestosAnuales() > 100? 10: 5);
		return (float) (precioBruto * (this.seguroAdicional?1.2:1) * (this.clienteReserva.isVip()?0.9:1));
	}
	
	public String toStringDetallado() {
		return this.getClass().getSimpleName().toUpperCase() + ": Precio final: " + this.precioTotal() + "€"
				+ "\n\t" + this.clienteReserva
				+ "\n\tVehículo: " + this.vehiculoReserva.getMatricula()+ " - " + this.vehiculoReserva.getModelo()
					+ "\n\t\tPrecio por día del alquiler: " + this.vehiculoReserva.getPrecioAlquilerDia() + "€"
					+ "\n\t\tImpuestos anuales: " + this.vehiculoReserva.impuestosAnuales() + "€"
				+ "\n\tDías del alquiler: " + this.diasAlquiler
				+ "\n\tSeguro adicional: " + (this.seguroAdicional?"SI":"NO");
	}
	
// toString, equals
	@Override
	public String toString() {
		return "Reserva: " + this.clienteReserva.getNombre() + " (DNI: " + this.clienteReserva.getDni()
		+ ") ha alquilado un " + this.vehiculoReserva.getModelo() + " por " + this.diasAlquiler
		+ " días. Precio total: " + this.precioTotal() + "€";
	}
	
	@Override
	public boolean equals(Object ob) {
		Reserva otro = (Reserva)ob;
		return this.clienteReserva.equals(otro.clienteReserva)
			&& this.vehiculoReserva.equals(otro.vehiculoReserva)
			&& this.diasAlquiler == otro.diasAlquiler;
	}
	
}
