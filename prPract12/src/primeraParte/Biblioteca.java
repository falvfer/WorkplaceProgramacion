package primeraParte;

import java.util.Iterator;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class Biblioteca implements InterfazBiblioteca {

// Variables
	private Set<Usuario> usuarios;
	private SortedSet<Libro> libros;
	
// Getters y Setters
	public Set<Usuario> getUsuarios() {return usuarios;}
	public SortedSet<Libro> getLibros() {return libros;}

	public void setUsuarios(Set<Usuario> usuarios) {this.usuarios = usuarios;}
	public void setLibros(SortedSet<Libro> libros) {this.libros = libros;}
	
// Constructores
	public Biblioteca() {
	this.usuarios = new TreeSet<>();
	this.libros = new TreeSet<>();
}
	
// Métodos
	public String librosToString() {
		StringBuilder cadena = new StringBuilder("----------------LIBROS EN LA LIBRERÍA----------------");
		boolean hayLibros = false;
		for (Libro lib: this.libros) {
			cadena.append("\n" + lib);
			hayLibros = true;
		}
		
		if (!hayLibros)
			cadena.append("\nNo hay libros en la librería disponibles");
		
		cadena.append("\n\n----------------LIBROS SACADOS----------------");
		hayLibros = false;
		for (Usuario usu: this.usuarios)
			for (Libro lib: usu.getLibrosSacados()) {
				cadena.append("\n" + lib);
				hayLibros = true;
			}
		
		if (!hayLibros)
			cadena.append("\nNo hay ningún libro en poseción de los usuarios");
		
		return cadena.toString();
	}
	
	public String usuariosToString() {
		StringBuilder cadena = new StringBuilder("Usuarios: ");
		for (Usuario usu: this.usuarios)
			cadena.append(usu.getNombre() + ", ");
		
		return cadena.delete(cadena.length()-2, cadena.length()-1).toString();
	}

// Métodos de interfaz
	@Override
	public boolean altaUsuario(Usuario usu) {
		return usuarios.add(usu);
	}


	@Override
	public boolean altaLibro(Libro lib) {
		return libros.add(lib);
	}

	@Override
	public Libro sacarLibro(String tit) {
		Libro lib = null;
		boolean terminar = false;
		
		for (Iterator<Libro> it = this.libros.iterator(); it.hasNext() && !terminar;) {
			lib = it.next();
			if (lib.getTitulo() == tit) {
				it.remove();
				terminar = true;
			}
		}
		
		if (!terminar) lib = null;
		return lib;
	}

	@Override
	public Usuario buscarUsuario(String nom) {
		Usuario usu = null;
		boolean terminar = false;
		
		for (Iterator<Usuario> it = this.usuarios.iterator(); it.hasNext() && !terminar;) {
			usu = it.next();
			if (usu.getNombre() == nom) {
				terminar = true;
			}
		}
		
		if (!terminar) usu = null;
		return usu;
	}

	@Override
	public boolean prestarLibro(String titulo, String nombre) {
		Libro lib = sacarLibro(titulo);
		Usuario usu = buscarUsuario(nombre);
		
		if (lib == null)
			return false;
		
		if (usu == null) {
			altaLibro(lib);
			return false;
		}
		
		if (usu.sacaLibro(lib))
			return true;
			
		altaLibro(lib);
		return false;
	}

	@Override
	public boolean devolverLibro(String titulo, String nombre) {
		Usuario usu = buscarUsuario(nombre);
		if (usu == null) return false;
		
		Libro lib = usu.devuelveLibro(titulo);
		if (lib == null) return false;
		
		return altaLibro(lib);
	}

	@Override
	public String librosDisponibles() {
		StringBuilder cadLibros = new StringBuilder("LIBROS DISPONIBLES:");
		
		for (Libro lib: this.libros)
			cadLibros.append("\n" + lib);
		
		return cadLibros.toString();
	}

	@Override
	public String librosPrestadosUsuario(String nombre) {
		StringBuilder cadLibros = new StringBuilder("LIBROS SACADOS:");
		SortedSet<Libro> librosSacados = new TreeSet<>();
		
		for (Usuario usu: this.usuarios)
			for (Libro lib: usu.getLibrosSacados())
				librosSacados.add(lib);
		
		for (Libro lib: librosSacados)
			cadLibros.append("\n" + lib);
				
		return cadLibros.toString();
	}

	@Override
	public SortedSet<Libro> copias(String titulo) {
		Libro lib = null;
		SortedSet<Libro> copiasLib = new TreeSet<>();
		
		for (Iterator<Libro> it = this.libros.iterator(); it.hasNext();) {
			lib = it.next();
			if (lib.getTitulo() == titulo)
				copiasLib.add(lib);
		}
		
		return copiasLib;
	}

	@Override
	public Set<Libro> getLibrosUsuario(String nomCli) {
		Usuario usu = buscarUsuario(nomCli);
		if (usu == null) return null;
		
		return usu.getLibrosSacados();
	}
	
}
