package modelo;

import java.util.Objects;
import java.util.SortedSet;
import java.util.TreeSet;

public class Expediente implements Comparable<Expediente>{
	
// Variables
	private short numExpediente, anno;
	private int numCaja;
	private SeccionExpediente seccion;
	private SubseccionExpediente subseccion;
	private String descripcion;
	private SortedSet<Persona> personas;
	
// Getters y Setters
	public short getNumExpediente() {return numExpediente;}
	public int getNumCaja() {return numCaja;}
	public short getAnno() {return anno;}
	public SeccionExpediente getSeccion() {return seccion;}
	public SubseccionExpediente getSubseccion() {return subseccion;}
	public String getDescripcion() {return descripcion;}
	public SortedSet<Persona> getPersonas() {return personas;}
	public String getNombres() {
		StringBuilder str = new StringBuilder();
		for (Persona p: personas)
			str.append(p.getNombre()+", ");
		
		return str.substring(0, str.length()<=1?str.length():str.length()-2);
	}
	
	public void setNumExpediente(short numExpediente) {this.numExpediente = numExpediente;}
	public void setNumCaja(int numCaja) {this.numCaja = numCaja;}
	public void setAnno(short anno) {this.anno = anno;}
	public void setSeccion(SeccionExpediente seccion) {this.seccion = seccion;}
	public void setSubseccion(SubseccionExpediente subseccion) {this.subseccion = subseccion;}
	public void setDescripcion(String descripcion) {this.descripcion = descripcion;}
	public void setPersonas(SortedSet<Persona> personas) {this.personas = personas;}
	
// Constructor
	public Expediente(int numCaja, short numExpediente, short anno, SubseccionExpediente subseccion,
						String descripcion, SortedSet<Persona> personas) {
		this.numCaja = numCaja;
		this.numExpediente = numExpediente;
		this.anno = anno;
		this.seccion = subseccion.getSeccion();
		this.subseccion = subseccion;
		this.descripcion = descripcion;
		this.personas = personas;
	}
	
	public Expediente(int numCaja, short numExpediente, short anno,	SubseccionExpediente subseccion,
						String descripcion, Persona p) {
		this(numCaja, numExpediente, anno, subseccion, descripcion);
		this.personas.add(p);
	}
	
	public Expediente(int numCaja, short numExpediente, short anno,	SubseccionExpediente subseccion,
						String descripcion, Persona p, Persona p2) {
		this(numCaja, numExpediente, anno, subseccion, descripcion);
		this.personas.add(p);
		this.personas.add(p2);
	}
	
	public Expediente(int numCaja, short numExpediente, short anno,	SubseccionExpediente subseccion,
						String descripcion) {
		this(numCaja, numExpediente, anno, subseccion, descripcion, new TreeSet<Persona>());
	}
	
// toString
	@Override
	public String toString() {
		return this.getNumExpediente()+"/"+this.getAnno();
	}

// hashCode, equals, compareTo
	@Override
	public int hashCode() {
		return Objects.hash(anno, numExpediente);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Expediente other = (Expediente) obj;
		return anno == other.anno && numExpediente == other.numExpediente;
	}
	@Override
	public int compareTo(Expediente o) {
		int comparacion = Short.compare(this.anno, o.anno);
		if (comparacion == 0)
			comparacion = Short.compare(this.numExpediente, o.numExpediente);
		return comparacion;
	}
	
	

}
