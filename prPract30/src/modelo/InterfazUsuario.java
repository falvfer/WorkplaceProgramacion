package modelo;

public interface InterfazUsuario {
	boolean sacaLibro(Libro lib);
	int cantidadLibrosSacados();
	boolean puedeSacarMasLibros();
	Libro devuelveLibro(String tit);
}
