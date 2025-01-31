package ejer06;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

/*
 * Hacer un programa para calcular la nómina de un trabajador, sabiendo que:
 * - El sueldo base, que se introducirá desde teclado, hay que incrementarlo en 30 euros por trienio.
 * - Si es jefe de departamento tiene un plus de 42 euros.
 * - Si está casado tiene un plus de 60 euros.
 * - Si tiene hijos, el sueldo se incrementa en 18 euros por hijo.
 */
public class Trabajador {
	
// Variables de instancia
	private float sueldoBase;
	private short trienios;
	private byte hijos;
	private boolean isJefe, isCasado;
	
// Variables de clase
	final private static short plusTrienio = 30, plusJefe = 60, plusCasado = 60, plusHijo = 18;
	
// Getters y Setters
	public float getSueldoBase() {return sueldoBase;}
	public short getTrienios() {return trienios;}
	public byte getHijos() {return hijos;}
	public boolean isJefe() {return isJefe;}
	public boolean isCasado() {return isCasado;}

	public void setSueldoBase(float sueldoBase) {this.sueldoBase = sueldoBase;}
	public void setTrienios(short trienios) {this.trienios = trienios;}
	public void setHijos(byte hijos) {this.hijos = hijos;}
	public void setJefe(boolean isJefe) {this.isJefe = isJefe;}
	public void setCasado(boolean isCasado) {this.isCasado = isCasado;}
	
// Constructores
	public Trabajador(float sueldoBase, short trienios, byte hijos, boolean isJefe, boolean isCasado) {
		this.sueldoBase = sueldoBase;
		this.trienios = trienios;
		this.hijos = hijos;
		this.isJefe = isJefe;
		this.isCasado = isCasado;
	}

// Métodos públicos
	public float calcularNomina() {
		return this.sueldoBase + this.trienios * plusTrienio + (this.isJefe?plusJefe:0) + (this.isCasado?plusCasado:0) + this.hijos * plusHijo;
	}

	
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in).useLocale(Locale.US);
	float sueldoBase;
	short trienios;
	byte hijos;
	boolean isJefe, isCasado;
	
	System.out.println("Bienvenido, se va a registrar un nuevo trabajador para calcular su nómina.");
	
	try {
		
		// Pedir sueldo base
		System.out.print("Especifique el suelo base: ");	
		sueldoBase = sc.nextFloat();
		
		// Pedir los trienios
		System.out.print("Especifique los trienios del trabajador, si no tiene ponga 0: ");
		trienios = sc.nextShort();
		
		// Pedir los hijos
		System.out.print("Especifique los hijos que tiene el trabajador, si no tiene ponga 0: ");
		hijos = sc.nextByte();
		
		// Pedir si es Jefe de algún departamento
		System.out.print("¿Es jefe de algún departamento? [S/N]: ");
		sc.nextLine();
		isJefe = (Character.toLowerCase(sc.nextLine().charAt(0)) == 's');
		
		// Pedir si está casado el trabajador
		System.out.print("¿Está casado? [S/N]: ");
		isCasado = (Character.toLowerCase(sc.nextLine().charAt(0)) == 's');
		
		// Crear el nuevo trabajador
		Trabajador tr = new Trabajador(sueldoBase, trienios, hijos, isJefe, isCasado);
		
		// Calcularle la nómina y mostrarla por pantalla
		System.out.println("La nómina de este trabajador es de: " + tr.calcularNomina() + "€");
		
	} catch (InputMismatchException e) {
		System.out.println("Error: Formato de número no válido.");
	}
	
	sc.close();
	
	}
	
}
