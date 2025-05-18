package modelo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import librerias.LibFechas;

public class GestorAlojamientos {

// Variables
	private List<Alojamiento> alojamientos;
	private SortedSet<Reserva> reservas;

// Getters y Setters
	public List<Alojamiento> getAlojamientos() {return alojamientos;}
	public SortedSet<Reserva> getReservas() {return reservas;}
	
	public void setAlojamientos(List<Alojamiento> alojamientos) {this.alojamientos = alojamientos;}
	public void setReservas(SortedSet<Reserva> reservas) {this.reservas = reservas;}
	
// Constructores
	public GestorAlojamientos(List<Alojamiento> alojamientos, SortedSet<Reserva> reservas) {
		this.alojamientos = alojamientos;
		this.reservas = reservas;
	}
	
	public GestorAlojamientos() {
		this(new ArrayList<Alojamiento>(), new TreeSet<Reserva>());
	}
	
	public GestorAlojamientos(File rutaAlojamientos) throws MiExcepcion {
		this(cargarAlojamientos(rutaAlojamientos), new TreeSet<Reserva>());
	}
	
	@SuppressWarnings("unchecked") // Pongo esto para suprimir el warning del casteo, ya que sé que va a funcionar
	private static List<Alojamiento> cargarAlojamientos(File rutaAlojamientos) throws MiExcepcion {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(rutaAlojamientos))) {
			
			return (List<Alojamiento>)ois.readObject();
			
		} catch (FileNotFoundException e) {
			throw new MiExcepcion("Archivo no encontrado");
		} catch (IOException e) {
			throw new MiExcepcion("No se ha podido cargar el archivo");
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		throw new MiExcepcion("Error al cargar el archivo, mire la consola");
	}
	
// Métodos
	public void addAlojamiento(Alojamiento a) throws MiExcepcion {
		if (!alojamientos.add(a))
			throw new MiExcepcion("No se ha podido añadir el alojamiento");
	}
	
	public void addReserva(Reserva r) throws MiExcepcion {

		if (r.getInicio().isBefore(LocalDate.now()))
			throw new MiExcepcion("La fecha de inicio no puede ser anterior al día de hoy");
		
		LocalDate ini = r.getInicio(),
				  fin = r.getFin();
		
		for (Reserva o: reservas) // He hecho que una reserva pueda terminar el mismo día que empieza otra
			if (o.getAlojamiento().getNombre() == r.getAlojamiento().getNombre())
				if (ini.isBefore(o.getFin()) 
				   && ini.isAfter(LibFechas.sumaDias(o.getInicio(),-1))
				   || fin.isBefore(LibFechas.sumaDias(o.getFin(),1))
				   && fin.isAfter(o.getInicio()))
					throw new MiExcepcion("La reserva indicada se superpone con otra reserva existente");
		
		reservas.add(r);
	}
	
	public List<String> getAlojamientosEnUbicacion(UbicacionesEnum ubicacion) {
		List<String> listaAlojamientos = new ArrayList<>();
		
		if (ubicacion == UbicacionesEnum.Todas)
			for (Alojamiento a: alojamientos)
					listaAlojamientos.add(a.getNombre());
		
		else
			for (Alojamiento a: alojamientos)
				if (a.getUbicacion()==ubicacion)
					listaAlojamientos.add(a.getNombre());
		
		return listaAlojamientos;
	}
	
	public List<String> getAlojamientosEnUbicacion() {
		return getAlojamientosEnUbicacion(UbicacionesEnum.Todas);
	}
	
	public Alojamiento buscarAlojamiento(String nombreBuscar) {
		boolean encontrado = false;
		Alojamiento a = null;
		
		for (Iterator<Alojamiento> it = alojamientos.iterator(); it.hasNext() && !encontrado;) {
			a = it.next();
			if (a.getNombre().equals(nombreBuscar))
				encontrado = true;
		}
		
		return a;
	}
	

	
	
	
}
