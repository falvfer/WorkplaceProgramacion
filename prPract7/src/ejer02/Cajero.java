package ejer02;

public class Cajero implements InterfazCajero {

// Variables de instancia
	private int num10, num20, num50, num100;
	
	public Cajero(int num100, int num50, int num20, int num10) {
		this.num100 = num100;
		this.num50 = num50;
		this.num20 = num20;
		this.num10 = num10;
	}
	
	public Cajero() {
		this(0,0,0,0);
	}

	@Override
	public int disponible() {
		return this.num100 * 100 + this.num50 * 50 + this.num20 * 20 + this.num10 * 10;
	}

	@Override
	public String sacar(Cuenta cuenta, int numeroSecreto, int cantidad) throws Exception {
		if (cuenta.validar(numeroSecreto)) {
			
			if (cantidad <= 0) throw new Exception("Error: No se puede meter cantidades negativas al cajero, o 0.");
			if (cantidad % 10 != 0) throw new Exception("Error: No se puede sacar cantidades que no se puedan subdividir en billetes de 100, 50, 20 o 10.");
			if (cantidad > this.disponible()) throw new Exception("Error: El cajero no tiene suficiente villetes para realizar esta operación.");
			
			cuenta.reintegro(cantidad);
			
			int numBill100 = toBilletes(cantidad, 100);
			cantidad -= numBill100 * 100;
			int numBill50 = toBilletes(cantidad, 50);
			cantidad -= numBill50 * 50;
			int numBill20 = toBilletes(cantidad, 20);
			cantidad -= numBill20 * 20;
			int numBill10 = toBilletes(cantidad, 10);
			
			this.actualizaCantidades(-numBill100, -numBill50, -numBill20, -numBill10);
			
			return "Se ha sacado:"
					+ (numBill100>0?"\n\t" + numBill100 + " billetes de 100":"")
					+ (numBill50>0?"\n\t" + numBill50 + " billetes de 50":"")
					+ (numBill20>0?"\n\t" + numBill20 + " billetes de 20":"")
					+ (numBill10>0?"\n\t" + numBill10 + " billetes de 10":"");
			
		} else throw new Exception("Error: El número secreto es incorrecto.");
	}
	
	public void meter(Cuenta cuenta, int numeroSecreto, int cantidad) throws Exception {
		if (cuenta.validar(numeroSecreto)) {
			
			if (cantidad <= 0) throw new Exception("Error: No se puede meter cantidades negativas al cajero, o 0.");
			if (cantidad % 10 != 0) throw new Exception("Error: No se puede meter monedas o billetes de 5 al cajero.");
			
			cuenta.imposicion(cantidad);
			
		} else throw new Exception("Error: El número secreto es incorrecto.");
	}
	
// Métodos privados
	private void actualizaCantidades(int b100, int b50, int b20, int b10) {
		this.num100 += b100;
		this.num50 += b50;
		this.num20 += b20;
		this.num10 += b10;
	}
	
	private void actualizaCantidades(int cantidad) throws Exception {
		if (cantidad % 5 != 0) throw new Exception("Error: No se puede meter monedas al cajero");
		
		// COMPLETAR ESTE MÉTODO Y DESPUÉS HACER LOS TESTS
	}
	
// Métodos privados de clase
	private static int toBilletes(int cantidad, int tipoBillete) {
		return cantidad / tipoBillete;
	}

// toString, equals, hashCode
	@Override
	public String toString() {
		return "";
	}

}
