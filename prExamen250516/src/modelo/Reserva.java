package modelo;

import java.time.LocalDate;
import java.util.Objects;

import librerias.LibFechas;

public class Reserva implements Comparable<Reserva> {

// Variables
	private Alojamiento aloj;
	private LocalDate inicio, fin;
	private byte numNoches;
	private Persona per;
	
// Getters y Setters
	public Alojamiento getAlojamiento() {return aloj;}
	public LocalDate getInicio() {return inicio;}
	public LocalDate getFin() {return fin;}
	public byte getNumNoches() {return numNoches;}
	public Persona getPersona() {return per;}
	public TemporadasEnum getTemporada() {return calculaTemporada(inicio);}
	public double getFactorTemporada() {
		TemporadasEnum temp = getTemporada();
		return temp==TemporadasEnum.ALTA?2:temp==TemporadasEnum.MEDIA?1.5:1;
	}
	public double getPrecioFinal() {return aloj.calculaPrecio(numNoches)*getFactorTemporada();}
	
	public void setAlojamiento(Alojamiento aloj) {this.aloj = aloj;}
	public void setInicio(LocalDate inicio) {this.inicio = inicio;}
	public void setFin(LocalDate fin) {this.fin = fin;}
	public void setNumNoches(byte numNoches) {this.numNoches = numNoches;}
	public void setPersona(Persona per) {this.per = per;}

// Constructor
	public Reserva(Alojamiento aloj, String inicio, byte numNoches, Persona per) throws MiExcepcion {
		if (!LibFechas.isFechaCorrecta(inicio))
			throw new MiExcepcion("La fecha de inicio no es correcta");
		
		this.aloj = aloj;
		this.inicio = LibFechas.convierteStringToLocalDate(inicio);
		this.numNoches = numNoches;
		this.fin = LibFechas.sumaDias(this.inicio, this.numNoches);
		this.per = per;
	}
	
	public Reserva(Alojamiento aloj, String inicio, byte numNoches,
			String nombre, String dni, String telefono) throws MiExcepcion {
		this(aloj, inicio, numNoches, new Persona(nombre, dni, telefono));
	}
	
	public Reserva(Alojamiento aloj, String inicio, byte numNoches,
			String nombre, String telefono) throws MiExcepcion {
		this(aloj, inicio, numNoches, new Persona(nombre, telefono));
	}
	
// Métodos
	public static TemporadasEnum calculaTemporada(LocalDate inicio) {
		return switch (inicio.getMonthValue()) {
			case 7,8 -> TemporadasEnum.ALTA;
			case 9,10,2,3,4,5,6 -> TemporadasEnum.MEDIA;
			default -> TemporadasEnum.BAJA;
		};
	}
	
// hashCode, equals, compareTo
	@Override
	public int hashCode() {
		return Objects.hash(aloj, inicio);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reserva other = (Reserva) obj;
		return Objects.equals(aloj, other.aloj) && Objects.equals(inicio, other.inicio);
	}
	@Override
	public int compareTo(Reserva o) {
		int comparacion = this.aloj.compareTo(o.aloj);
		if (comparacion == 0)
			comparacion = this.inicio.compareTo(o.inicio);
		
		return comparacion;
	}
	
// toString
	@Override
	public String toString() {
		return "Datos " + this.getClass().getSimpleName().toLowerCase() + ":"
				+"\n\t" + aloj.getClass().getSimpleName() + ": " + aloj.getNombre()
				+"\n\tFecha inicio: " + LibFechas.getFechaShort(inicio)
				+"\n\tFecha fin: " + LibFechas.getFechaShort(fin)
				+"\n\tNúmero de noches: " + this.numNoches
				+"\n\tCliente: " + this.per.getNombre()
				+(this.per.getDni()!=null?
						"\n\tDNI: " + this.per.getDni():
						"")
				+"\n\tTeléfono contacto: " + this.per.getTelefono()
				+"\n\tPrecio final: " + this.getPrecioFinal() + '€'
					+" (Temporada " +this.getTemporada()+")";
	}
	
}
