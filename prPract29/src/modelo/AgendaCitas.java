package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AgendaCitas implements Serializable{
	private static final long serialVersionUID = -735956309917461357L;
	
	// Coleccion de citas
	private List<CitaMedica> citas;
	public List<CitaMedica> getCitas() {return citas;}

// Constructores
	public AgendaCitas(List<CitaMedica> citas) {
		this.citas = citas;
	}
	
	public AgendaCitas() {
		this.citas = new ArrayList<>();
	}
	
// Métodos públicos
	public boolean addCita(CitaMedica cita) {
		return this.citas.add(cita);
	}
	
	public void ordenaCitas() {
		this.citas.sort(null);
	}
	
	public long getTotalRecaudado() {
		long total = 0;
		for (CitaMedica c: citas)
			total += c.getPrecio();
		return total;
	}
	
// toString
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder(this.getClass().getSimpleName());
		for (CitaMedica c: citas)
			str.append("\n\t"+c);
		return str.toString();
	}
	
	
}
