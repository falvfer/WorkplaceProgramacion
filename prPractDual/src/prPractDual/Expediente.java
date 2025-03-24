package prPractDual;

import java.util.Objects;

public class Expediente {
	
// Variables
	private short numExpediente, anno;
	private int numCaja;
	private SeccionExpediente seccion;
	private SubseccionExpediente subseccion;
	private String descripcion, nombres;
	
// Getters y Setters
	public short getNumExpediente() {return numExpediente;}
	public int getNumCaja() {return numCaja;}
	public short getAnno() {return anno;}
	public SeccionExpediente getSeccion() {return seccion;}
	public SubseccionExpediente getSubseccion() {return subseccion;}
	public String getDescripcion() {return descripcion;}
	public String getNombres() {return nombres;}
	
	public void setNumExpediente(short numExpediente) {this.numExpediente = numExpediente;}
	public void setNumCaja(int numCaja) {this.numCaja = numCaja;}
	public void setAnno(short anno) {this.anno = anno;}
	public void setSeccion(SeccionExpediente seccion) {this.seccion = seccion;}
	public void setSubseccion(SubseccionExpediente subseccion) {this.subseccion = subseccion;}
	public void setDescripcion(String descripcion) {this.descripcion = descripcion;}
	public void setNombres(String nombres) {this.nombres = nombres;}
	
// Constructor
	public Expediente(int numCaja, short numExpediente, short anno, SeccionExpediente seccion,
						SubseccionExpediente subseccion, String descripcion, String nombres) {
		this.numCaja = numCaja;
		this.numExpediente = numExpediente;
		this.anno = anno;
		this.seccion = seccion;
		this.subseccion = subseccion;
		this.descripcion = descripcion;
		this.nombres = nombres;
	}

// hashCode, equals
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
	
	

}
