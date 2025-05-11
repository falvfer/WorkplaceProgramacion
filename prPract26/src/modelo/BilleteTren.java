package modelo;

public class BilleteTren {

// Variables de instancia
	private Punto origen, destino;
	private EnumDescuentos tipoDescuento;
	
// Getters y Setters
	public Punto getOrigen() {return origen;}
	public Punto getDestino() {return destino;}
	public String getTipoDescuentoString() {return tipoDescuento.getDescripcion();}
	public EnumDescuentos getTipoDescuento() {return tipoDescuento;}
	public String getDescuento() {return tipoDescuento.getPorcentaje()+"%";}
	public double getDistancia() {return origen.medirDistancia(destino);}
	
	public void setOrigen(Punto origen) {this.origen = origen;}
	public void setDestino(Punto destino) {this.destino = destino;}
	public void setTipoDescuento(EnumDescuentos tipoDescuento) {this.tipoDescuento = tipoDescuento;}

	
// Constructor
	public BilleteTren(Punto origen, Punto destino, EnumDescuentos tipoDescuento) {
		this.origen = origen;
		this.destino = destino;
		this.tipoDescuento = tipoDescuento;
	}
	
// Métodos públicos
	public double calculaPrecio() {
		double distanciaKM = Math.abs(getDistancia());
		double coste = distanciaKM * (distanciaKM<21?0.20:
										(distanciaKM<50?0.18:0.16));
		double porcentaje = 1-tipoDescuento.getPorcentaje()/100.0;
		
		return coste * porcentaje;
	}
	
	public String getPrecio() {
		double precio = this.calculaPrecio();
		return Math.round(precio) + " € y " + (int)Math.round((precio - Math.floor(precio))*100) + " centimos";
	}
	
// toString
	@Override
	public String toString() {
		return this.getClass().getSimpleName()
				+ "\n\tOrigen: " + origen
				+ "\n\tDestino: " + destino
				+ "\n\tDescuento aplicado: " + tipoDescuento.getPorcentaje() + "% (" + tipoDescuento.getDescripcion() + ")"
				+ "\n\tDistancia: " + getDistancia()
				+ "\n\tCoste del billete: " + getPrecio();
	}
	
}
