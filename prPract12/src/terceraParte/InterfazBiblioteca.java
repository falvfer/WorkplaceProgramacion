package terceraParte;

import java.util.Set;
import java.util.SortedSet;

public interface InterfazBiblioteca {
	boolean altaUsuario(Usuario usu);
	boolean altaLibro(Libro lib);
	Libro sacarLibro(String tit) throws BibliotecaException;
	Usuario buscarUsuario(String nom) throws BibliotecaException;
	boolean prestarLibro(String titulo, String nombre) throws BibliotecaException;
	boolean devolverLibro(String titulo, String nombre) throws BibliotecaException;
	String librosDisponibles() throws BibliotecaException;
	String librosPrestadosUsuario(String nombre) throws BibliotecaException;
	SortedSet<Libro> copias(String titulo) throws BibliotecaException;
	Set<Libro> getLibrosUsuario(String nomCli) throws BibliotecaException;
}
