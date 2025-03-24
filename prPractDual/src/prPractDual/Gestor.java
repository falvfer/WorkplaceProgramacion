package prPractDual;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Gestor {
	
// Listas
	private Set<Caja> cajas;
	private Set<Expediente> expedientes;
	
// Getters y Setters
	public Set<Caja> getCajas() {return cajas;}
	public Set<Expediente> getExpedientes() {return expedientes;}

	public void setExpedientes(Set<Expediente> expedientes) {this.expedientes = expedientes;}
	public void setCajas(Set<Caja> cajas) {this.cajas = cajas;}

// Constructor
	public Gestor() {
		cajas = new HashSet<>();
		expedientes = new HashSet<>();
	}
	
// Métodos públicos
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
	
	public boolean hasExpediente(Expediente expEncontrar) {
		boolean encontrado = false;
		Expediente exp = null;
		
		for (Iterator<Expediente> it = this.expedientes.iterator(); it.hasNext();) {
			exp = it.next();
			if (exp.equals(expEncontrar))
				encontrado = true;
		}
		if (!encontrado)
			exp = null;
		
		return exp instanceof Expediente;
	}
	
	public Caja findCaja(int numCaja) {
		boolean encontrado = false;
		Caja caja = null;
		
		for (Iterator<Caja> it = this.cajas.iterator(); it.hasNext();) {
			caja = it.next();
			if (caja.getNumCaja() == numCaja)
				encontrado = true;
		}
		if (!encontrado)
			caja = null;
		
		return caja;
	}
	
	public Caja findCaja(short numExp, short anno) {
		boolean encontrado = false;
		Caja caja = null;
		
		for (Iterator<Caja> it = this.cajas.iterator(); it.hasNext();) {
			caja = it.next();
			if (caja.hasExpediente(numExp, anno))
				encontrado = true;
		}
		if (!encontrado)
			caja = null;
		
		return caja;
	}
	
	public Caja crearCaja() {
		Caja caj = new Caja();
		this.cajas.add(caj);
		return caj;
	}
	
	public Caja crearCaja(int numCaja) {
		Caja caj = new Caja(numCaja);
		this.cajas.add(caj);
		return caj;
	}

	public boolean addCaja(Caja caj) {
		if (this.cajas.add(caj)) {
			for (Expediente exp: caj.getExpedientes()) {
				expedientes.add(exp);
			}
			return true;
		}
		return false;
	}
	
	public Caja quitaCaja(int numCaja) {
		Caja caj = this.findCaja(numCaja);
		this.cajas.remove(caj);
		return caj;
	}
	
	public boolean mueveExpediente(short numExp, short anno, Caja destino) {
		Expediente exp = this.findExpediente(numExp, anno);
		Caja origen = this.findCaja(exp.getNumCaja());
		if (destino.addExpediente(exp)) {
			origen.quitaExpediente(exp);
			exp.setNumCaja(destino.getNumCaja());
			return true;
		}
		return false;
		
	}
	
	public Expediente crearExpediente(int numCaja, short numExpediente, short anno, SeccionExpediente seccion,
						SubseccionExpediente subseccion, String descripcion, String nombres) {
		Expediente exp = new Expediente(numCaja, numExpediente, anno, seccion, subseccion, descripcion, nombres);
		Caja caj = this.findCaja(numCaja);
		if (caj instanceof Caja)
			if (this.addExpediente(exp, caj))
				return exp;
		return null;
	}
	
	public boolean addExpediente(Expediente exp, Caja destino) {
		
		if (this.hasExpediente(exp) && destino.addExpediente(exp)) {
			this.expedientes.add(exp);
			exp.setNumCaja(destino.getNumCaja());
			return true;
		}
		return false;
	}
	
	public boolean addExpediente(Expediente exp, int numCaja) {
		Caja destino = this.findCaja(numCaja);
		
		if (destino instanceof Caja && this.hasExpediente(exp) && destino.addExpediente(exp)) {
			this.expedientes.add(exp);
			exp.setNumCaja(destino.getNumCaja());
			return true;
		}
		return false;
	}
	
	public Expediente quitaExpediente(short numExp, short anno) {
		Expediente exp = this.findExpediente(numExp, anno);
		if (exp instanceof Expediente) {
			this.expedientes.remove(exp);
			this.findCaja(exp.getNumCaja()).quitaExpediente(exp);
		}
		return exp;
	}
}
