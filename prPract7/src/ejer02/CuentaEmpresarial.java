package ejer02;

import java.time.LocalDate;

public class CuentaEmpresarial extends Cuenta {

// Variables de instancia
	private String nombEmpresa, fecha;
	private int contIngresos, contReintegros;
	
// Getters y Setters
	public String getNombEmpresa() {return nombEmpresa;}
	public String getFecha() {return fecha;}
	public int getContIngresos() {return contIngresos;}
	public int getContReintegros() {return contReintegros;}
	
	public void setNombEmpresa(String nombEmpresa) {this.nombEmpresa = nombEmpresa;}
	public void setFecha(String fecha) {this.fecha = fecha;}
	public void setContIngresos(int contIngresos) {this.contIngresos = contIngresos;}
	public void setContReintegros(int contReintegros) {this.contReintegros = contReintegros;}
	
// Constructores
	public CuentaEmpresarial(String numCuenta, String nombreTitular, double saldo, short numSecreto, String nombEmpresa) {
		super(numCuenta, nombreTitular, saldo, numSecreto);
		this.nombEmpresa = nombEmpresa;
		this.fecha = getDate();
		this.contIngresos = 0;
		this.contReintegros = 0;
	}

// Métodos públicos de objeto
	@Override
	public void imposicion(double cantidad) {
		super.imposicion(cantidad);
		this.contIngresos++;
	}
	
	@Override
	public void reintegro(double cantidad) throws Exception{
		super.reintegro(cantidad);
		this.contReintegros++;
	}
	
	public void reiniciarOperaciones() {
		this.fecha = getDate();
		this.contIngresos = 0;
		this.contReintegros = 0;
	}

// Métodos públicos de clase
	public static String getDate() {
		return LocalDate.now().getYear()
				+ "/"
				+ (LocalDate.now().getMonthValue()>9?
						LocalDate.now().getMonthValue():
						"0" + LocalDate.now().getMonthValue())
				+ "/"
				+ (LocalDate.now().getDayOfMonth()>9?
						LocalDate.now().getDayOfMonth():
						"0" + LocalDate.now().getDayOfMonth());
	}
	
// toString, equals, hashCode
	@Override
	public String toString() {
		return super.toString()
				+ "\n\tNombre de empresa: " + this.nombEmpresa
				+ "\n\tFecha desde el ultimo reinicio de contador de ingresos y reintegros: " + this.fecha
				+ "\n\tContador de Ingresos: " + this.contIngresos
				+ "\n\tContador de Reintegros: " + this.contReintegros;
	}
}
