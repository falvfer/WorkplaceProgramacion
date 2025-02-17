package terceraParte;

public interface InterfazUsuario {
	boolean sacaLibro(Libro lib);
	int cantidadLibrosSacados();
	boolean puedeSacarMasLibros();
	Libro devuelveLibro(String tit);
}
