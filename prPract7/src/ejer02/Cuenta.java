package ejer02;

/*
 * La información que maneja una sucursal bancaria sobre las cuentas de sus clientes es la siguiente:
 * número de cuenta, nombre del titular de la cuenta, saldo actual de la cuenta y número secreto de la
 * tarjeta o libreta.
 * Desarrollar la clase Cuenta, con al menos los siguientes métodos:
 * ▪ Constructor. Crea una cuenta nueva.
 * ▪ Métodos set y get.
 * ▪ imposicion(real cantidad). Ingresa cantidad en la cuenta.
 * ▪ reintegro(real cantidad). Saca cantidad de la cuenta.
 * ▪ toString( ). Devuelve toda la información disponible sobre la cuenta, excepto el nº secreto.
 * ▪ Método equals. Dos cuentas serán iguales si coincide su número.
 * ▪ validar(int clave). Devuelve true si el número secreto de la tarjeta o libreta es correcto y false en caso contrario.
 */

public class Cuenta {

// Variables de instancia
	private String numCuenta, nombreTitular;
	private double saldo;
	private int numSecreto;
	
// Getters y Setters
	public String getNumCuenta() {return numCuenta;}
	public String getNombreTitular() {return nombreTitular;}
	public double getSaldo() {return saldo;}
	public int getNumSecreto() {return numSecreto;}
	
	public void setNumCuenta(String numCuenta) {this.numCuenta = numCuenta;}
	public void setNombreTitular(String nombreTitular) {this.nombreTitular = nombreTitular;}
	public void setSaldo(double saldo) {this.saldo = saldo;}
	public void setNumSecreto(int numSecreto) {this.numSecreto = numSecreto;}
	
// Constructores
	public Cuenta(String numCuenta, String nombreTitular, double saldo, short numSecreto) {
		this.numCuenta = numCuenta;
		this.nombreTitular = nombreTitular;
		this.saldo = saldo;
		this.numSecreto = numSecreto;
	}
	
// Métodos públicos
	public void imposicion(double cantidad) {
		this.saldo += cantidad;
	}
	
	public void reintegro(double cantidad) throws Exception{
		this.saldo -= cantidad;
	}
	
	public boolean validar(int clave) {
		return (this.numSecreto == clave);
	}
	
// toString, equals, hashCode
	@Override
	public String toString() {
		return this.getClass().getSimpleName().toUpperCase()
				+ "\n\tNúmero de la cuenta: " + this.numCuenta
				+ "\n\tNombre del titular: " + this.nombreTitular
				+ "\n\tSaldo de la cuenta: " + this.saldo;
	}
	
	@Override
	public boolean equals(Object ob) {
		Cuenta other = (Cuenta)ob;
		return (this.numCuenta == other.numCuenta);
	}
	
}
