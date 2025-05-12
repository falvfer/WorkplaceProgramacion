package modelo;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
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
	
	public Biblioteca(Path usuarios, Path libros) throws BibliotecaException {
		try {
			this.usuarios = leerUsuarios(usuarios);
		} catch (IOException e) {
			throw new BibliotecaException("Error al leer el archivo de Usuarios");
		}
		try {
			this.libros = leerLibros(libros);
		} catch (IOException e) {
			throw new BibliotecaException("Error al leer el archivo de Libros");
		}
	}
	
// Métodos que usa el constructor
	private Set<Usuario> leerUsuarios(Path archivo) throws IOException {
		SortedSet<Usuario> setLibros = new TreeSet<>();
		
		try {
			for (String linea: Files.readAllLines(archivo))
				setLibros.add(new Usuario(linea));
		} finally {}
		
		return setLibros;
	}
	
	private SortedSet<Libro> leerLibros(Path archivo) throws IOException {
		SortedSet<Libro> setLibros = new TreeSet<>();
		
		try {
			for (String linea: Files.readAllLines(archivo)) {
				String[] parametros = linea.split("\\*");
				List<String> listaPersonajes = Arrays.asList(parametros[3].split(", "));
				setLibros.add(new Libro(parametros[0], parametros[1], parametros[2], listaPersonajes));
			}
		} finally {}
		
		return setLibros;
	}
	
// Métodos
	public String librosToString() throws BibliotecaException{
		byte noHayLibros = 0;
		StringBuilder cadena = new StringBuilder("----------------LIBROS EN LA LIBRERÍA----------------\n");
		
		try {
			cadena.append(this.librosDisponibles());
		} catch (BibliotecaException e) {
			noHayLibros++;
		}
		
		try {
			cadena.append("\n\n" + this.librosPrestados());
		} catch (BibliotecaException e) {
			noHayLibros++;
		}
		
		if (noHayLibros == 2)
			throw new BibliotecaException("No hay libros disponibles ni prestados");
		
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
	public Libro sacarLibro(String tit) throws BibliotecaException {
		Libro lib = null;
		boolean terminar = false;
		
		for (Iterator<Libro> it = this.libros.iterator(); it.hasNext() && !terminar;) {
			lib = it.next();
			if (lib.getTitulo() == tit) {
				it.remove();
				terminar = true;
			}
		}
		
		if (!terminar)
			throw new BibliotecaException("Error: No existe el libro.");
			
		return lib;
	}

	@Override
	public Usuario buscarUsuario(String nom) throws BibliotecaException {
		Usuario usu = null;
		boolean terminar = false;
		
		for (Iterator<Usuario> it = this.usuarios.iterator(); it.hasNext() && !terminar;) {
			usu = it.next();
			if (usu.getNombre() == nom) {
				terminar = true;
			}
		}

		if (!terminar)
			throw new BibliotecaException("Error: No existe el usuario");
		
		return usu;
	}

	@Override
	public boolean prestarLibro(String titulo, String nombre) throws BibliotecaException {
		Libro lib = sacarLibro(titulo);
		
		Usuario usu;
		try {
			usu = buscarUsuario(nombre);
		} catch (BibliotecaException e) {
			altaLibro(lib);
			throw new BibliotecaException("Error: No existe el usuario");
		}
		
		if (usu.sacaLibro(lib))
			return true;
			
		altaLibro(lib);
		throw new BibliotecaException("Error grave: El usuario ya ha sacado el libro, de alguna forma.");
	}

	@Override
	public boolean devolverLibro(String titulo, String nombre) throws BibliotecaException {
		Usuario usu = buscarUsuario(nombre);
		if (usu == null)
			throw new BibliotecaException("Error: No existe el usuario.");
		
		Libro lib = usu.devuelveLibro(titulo);
		if (lib == null)
			throw new BibliotecaException("Error: El usuario no ha sacado ese libro o no existe.");
		
		return altaLibro(lib);
	}

	@Override
	public String librosDisponibles() throws BibliotecaException {
		if (this.libros.size() == 0)
			throw new BibliotecaException("No hay libros disponibles.");
		
		StringBuilder cadLibros = new StringBuilder("LIBROS DISPONIBLES:");
		
		for (Libro lib: this.libros)
			cadLibros.append("\n" + lib);
		
		return cadLibros.toString();
	}

	public String librosPrestados() throws BibliotecaException {
		StringBuilder cadena = new StringBuilder("LIBROS PRESTADOS:");
		
		boolean hayLibros = false;
		for (Usuario usu: this.usuarios)
			for (Libro lib: usu.getLibrosSacados()) {
				cadena.append("\n" + lib);
				hayLibros = true;
			}
		
		if (!hayLibros)
			throw new BibliotecaException("No hay libros disponibles.");
		
		return cadena.toString();
	}

	@Override
	public String librosPrestadosUsuario(String nombre) throws BibliotecaException {
		StringBuilder cadLibros = new StringBuilder("LIBROS SACADOS:");
		SortedSet<Libro> librosSacados = new TreeSet<>();
		
		for (Usuario usu: this.usuarios)
			for (Libro lib: usu.getLibrosSacados())
				librosSacados.add(lib);
		
		if (librosSacados.size() == 0)
			throw new BibliotecaException("No hay libros sacados.");
		
		for (Libro lib: librosSacados)
			cadLibros.append("\n" + lib);
				
		return cadLibros.toString();
	}

	@Override
	public SortedSet<Libro> copias(String titulo) throws BibliotecaException {
		SortedSet<Libro> copiasLib = new TreeSet<>();
		
		for (Libro lib: this.libros)
			if (lib.getTitulo() == titulo)
				copiasLib.add(lib);
		
		if (copiasLib.size() == 0)
			throw new BibliotecaException("Error: No hay ninguna copia de ese libro disponible.");
		
		return copiasLib;
	}

	@Override
	public Set<Libro> getLibrosUsuario(String nomCli) throws BibliotecaException {
		Usuario usu = buscarUsuario(nomCli);
		if (usu == null)
			throw new BibliotecaException("Error: El usuario no existe");
		
		return usu.getLibrosSacados();
	}
	
}
