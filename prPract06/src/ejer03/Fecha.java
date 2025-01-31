package ejer03;

/* Hacer un método para comprobar si una determinada fecha es correcta o no. Hay que tener en cuenta
 * los años bisiestos, un año es bisiesto si es múltiplo de 4 (p.e. 1988), excepto los múltiplos de 100 que no
 * son bisiestos (p. e. 1800), salvo los múltiplos de 400 que si lo son (p. e. 2000).
 * 
 * CLASE:
 *  - Variables:
 *    - Anno
 *    - Mes
 *    - Dia
 *  - Métodos públicos:
 *    - isCorrecta
 *  - Métodos privados:
 *    - isBisiesto
 *  - toString: "DD/MM/AAAA"
 */

public class Fecha {

// Variables de instancia
	private short anno;
	private byte mes, dia;
	
// Getters y Setters
	public short getAnno() {return anno;}
	public byte getMes() {return mes;}
	public byte getDia() {return dia;}
	
	public void setAnno(short anno) {this.anno = anno;}
	public void setMes(byte mes) {this.mes = mes;}
	public void setDia(byte dia) {this.dia = dia;}
	
// Constructores
	public Fecha(short anno, byte mes, byte dia) {
		this.anno = anno;
		this.mes = mes;
		this.dia = dia;
	}
	
// Métodos públicos
	public boolean isCorrecta() {
		boolean respuesta = false;
		if (this.anno > 999 && this.anno <= 4000)
			if (this.dia >= 1) {
				switch (mes) {
					case 1,3,5,7,8,10,12 -> {if (this.dia <= 31) respuesta = true;}
					case 4,6,9,11 -> {if (this.dia <= 30) respuesta = true;}
					case 2 -> {
						if (this.isBisiesto()) {
							if (this.dia <= 29) respuesta = true;
						} else if (this.dia <= 28) respuesta = true;
					}
				}
			}
		return respuesta;
	}
	
// Métodos privado
	private boolean isBisiesto() {
		return (isDivisor(this.anno,4) && !isDivisor(this.anno,100)) || isDivisor(this.anno,400);
	}
	
	private static boolean isDivisor(int num, int div) {
		return (num % div == 0);
	}
	
// toString, equals, hashCode
	@Override
	public String toString() {
		return this.dia + "/" + this.mes + "/" + this.anno;
	}
	
	
	
	
// MAIN
	public static void main(String[] args) {
		
		Fecha f01 = new Fecha((short)2024, (byte)12, (byte)1); // Correcta
		Fecha f02 = new Fecha((short)2000, (byte)2, (byte)29); // Correcta
		Fecha f03 = new Fecha((short)2024, (byte)2, (byte)29); // Correcta
		Fecha f04 = new Fecha((short)1900, (byte)2, (byte)29);
		Fecha f05 = new Fecha((short)1990, (byte)13, (byte)24);
		Fecha f06 = new Fecha((short)2001, (byte)4, (byte)45);
		Fecha f07 = new Fecha((short)2002, (byte)-4, (byte)45);
		Fecha f08 = new Fecha((short)2023, (byte)4, (byte)-5);
		Fecha f09 = new Fecha((short)998, (byte)4, (byte)5);
		Fecha f10 = new Fecha((short)6000, (byte)4, (byte)5);
		
		if (f01.isCorrecta()) System.out.println(f01 + " está bien"); else System.out.println(f01 + " está mal");
		if (f02.isCorrecta()) System.out.println(f02 + " está bien"); else System.out.println(f02 + " está mal");
		if (f03.isCorrecta()) System.out.println(f03 + " está bien"); else System.out.println(f03 + " está mal");
		if (f04.isCorrecta()) System.out.println(f04 + " está bien"); else System.out.println(f04 + " está mal");
		if (f05.isCorrecta()) System.out.println(f05 + " está bien"); else System.out.println(f05 + " está mal");
		if (f06.isCorrecta()) System.out.println(f06 + " está bien"); else System.out.println(f06 + " está mal");
		if (f07.isCorrecta()) System.out.println(f07 + " está bien"); else System.out.println(f07 + " está mal");
		if (f08.isCorrecta()) System.out.println(f08 + " está bien"); else System.out.println(f08 + " está mal");
		if (f09.isCorrecta()) System.out.println(f09 + " está bien"); else System.out.println(f09 + " está mal");
		if (f10.isCorrecta()) System.out.println(f10 + " está bien"); else System.out.println(f10 + " está mal");
		
		
		
	}
	
}
