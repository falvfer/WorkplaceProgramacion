package prPractDual;

import java.util.TreeSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

public class Caja implements Comparable<Caja>{

// Listas
	private int numCaja;
	private Set<Expediente> expedientes;

// Getters y Setters
	public int getNumCaja() {return numCaja;}
	public Set<Expediente> getExpedientes() {return expedientes;}
	public void setNumCaja(int numCaja) {this.numCaja = numCaja;}
	public void setExpedientes(Set<Expediente> expedientes) {this.expedientes = expedientes;}
	
// Constructor
	public Caja(int numCaja) {
		this.numCaja = numCaja;
		this.expedientes = new TreeSet<>();
	}
	
	public Caja() {
		this(0);
	}
	
// Métodos públicos
	public boolean addExpediente(Expediente exp) {
		return this.expedientes.add(exp);
	}
	
	public boolean quitaExpediente(Expediente exp) {
		return this.expedientes.remove(exp);
	}
	
	public Expediente findExpediente(short numExpediente, short anno) {
		boolean encontrado = false;
		Expediente exp = null;
		
		for (Iterator<Expediente> it = this.expedientes.iterator(); it.hasNext();) {
			exp = it.next();
			if (exp.getNumExpediente() == numExpediente && exp.getAnno() == anno)
				encontrado = true;
		}
		if (!encontrado)
			exp = null;
		
		return exp;
	}
	
	public boolean hasExpediente(short numExp, short anno) {
		boolean encontrado = false;
		Expediente exp = null;
		
		for (Iterator<Expediente> it = this.expedientes.iterator(); it.hasNext();) {
			exp = it.next();
			if (exp.getAnno() == anno && exp.getNumExpediente() == numExp)
				encontrado = true;
		}
		if (!encontrado)
			exp = null;
		
		return exp instanceof Expediente;
	}
	
// hashCode, equals
	@Override
	public int hashCode() {
		return Objects.hash(numCaja);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Caja other = (Caja) obj;
		return numCaja == other.numCaja;
	}
	
	@Override
	public int compareTo(Caja o) {
		return Integer.compare(this.numCaja, o.numCaja);
	}
}
