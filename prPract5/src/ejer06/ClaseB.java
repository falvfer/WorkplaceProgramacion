package ejer06;

public class ClaseB extends ClaseA implements InterfazA {

	private int varClaseB;

	public int getVarClaseB() {return varClaseB;}
	public void setVarClaseB(int varClaseB) {this.varClaseB = varClaseB;}
	
	public ClaseB(int a, int b) {
		super(a);
		this.varClaseB = b;
	}
	
	@Override
	public int metodoIntA() {
		return this.getVarClaseA()*this.varClaseB;
	}
	
	@Override
	public String toString() {
		return super.toString()
				+ "\n\tB: " + this.varClaseB;
	}
	
}
