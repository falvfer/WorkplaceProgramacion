package ejer02;

public class CuentaJoven extends Cuenta {

// Variables de instancia
	private byte edad;

// Getters y Setters
	public byte getEdad() {return edad;}
	public void setEdad(byte edad) {this.edad = edad;}
	
// Constructores
	public CuentaJoven(String numCuenta, String nombreTitular, double saldo, short numSecreto, byte edad) {
		super(numCuenta, nombreTitular, saldo, numSecreto);
	}

// Metodos públicos
	@Override
	public void reintegro(double cantidad) throws Exception {
		if (cantidad <= this.getSaldo())
			super.reintegro(cantidad);
		else
			throw new Exception("Error: La cuenta no puede estar en números rojos.");
	}


}
