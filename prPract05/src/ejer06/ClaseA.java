package ejer06;

public class ClaseA {

	private int varClaseA;

	public int getVarClaseA() {return varClaseA;}
	public void setVarClaseA(int varClaseA) {this.varClaseA = varClaseA;}
	
	public ClaseA(int a) {
		this.varClaseA = a;
	}
	
	@Override
	public String toString() {
		return this.getClass().getSimpleName().toUpperCase()
				+ "\n\tA: " + this.varClaseA;
	}
	
}
