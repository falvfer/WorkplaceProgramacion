package inmobiliarias;

import propiedades.*;
import java.util.*;

public class Inmobiliaria implements GestionInmobiliaria {

// Variables
	Set<Propiedad> listaPropiedades;
	
// Getters y Setters
	public Set<Propiedad> getListaPropiedades() {return listaPropiedades;}
	public void setListaPropiedades(SortedSet<Propiedad> listaPropiedades) {this.listaPropiedades = listaPropiedades;}
	
// Constructores
	public Inmobiliaria(SortedSet<Propiedad> listaPropiedades) {
		this.listaPropiedades = listaPropiedades;
	}
	
	public Inmobiliaria() {
		this(new TreeSet<>());
	}
	
// Métodos
	public Set<Propiedad> getPropiedadesOrdenPrecio() {
		Set<Propiedad> ordenPrecio = new TreeSet<>(
				(o1, o2) -> Double.compare(o1.getPrecio(), o2.getPrecio())); 
		ordenPrecio.addAll(this.listaPropiedades);
		return ordenPrecio;
	}
	
	public String getPropiedadesOrdenPrecioString() {
		StringBuilder cadena = new StringBuilder("LISTA ORDENADA POR PRECIO");
		Set<Propiedad> lista = this.getPropiedadesOrdenPrecio();
		
		for (Propiedad p: lista)
			cadena.append("\n" + p.getCodigo() + " - " + p.getPrecio() + " - " + p.getTipoProp());
		
		return cadena.toString();
	}

// Métodos de la interfaz
	@Override
	public boolean añade(Propiedad ob) {
		return this.listaPropiedades.add(ob);
	}

	@Override
	public Propiedad buscar(int cod) throws Exception {
		boolean encontrado = false;
		Propiedad propiedadActual = null;
		
		for (Iterator<Propiedad> it = listaPropiedades.iterator(); it.hasNext() && !encontrado;) {
			propiedadActual = it.next();
			if (propiedadActual.getCodigo() == cod)
				encontrado = true;
		}
		
		if (!encontrado)
			throw new Exception("No se ha encontrado la propiedad");
		
		return propiedadActual;
	}

	@Override
	public boolean buscar(Propiedad p) {
		return listaPropiedades.contains(p);
	}

	@Override
	public boolean borra(int cod) {
		boolean borrado = false;
		Propiedad propiedadActual = null;
		
		for (Iterator<Propiedad> it = listaPropiedades.iterator(); it.hasNext() && !borrado;) {
			propiedadActual = it.next();
			if (propiedadActual.getCodigo() == cod) {
				it.remove();
				borrado = true;
			}
		}
		
		return borrado;
	}

	@Override
	public boolean borra(Propiedad p) {
		return this.listaPropiedades.remove(p);
	}
	
	// toString
	@Override
	public String toString() {
		StringBuilder cadena = new StringBuilder(this.getClass().getSimpleName().toUpperCase());
		
		for (Propiedad p: this.listaPropiedades)
			cadena.append("\n" + p.toString());
		
		return cadena.toString();
	}

}
