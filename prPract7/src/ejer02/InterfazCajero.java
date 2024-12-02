package ejer02;

public interface InterfazCajero {
	public int disponible();
	public String sacar(Cuenta ob, int numeroSecreto, int cantidad) throws Exception;
}
