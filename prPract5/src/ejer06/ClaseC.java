package ejer06;

public class ClaseC extends ClaseB implements InterfazD {

	private int varClaseC;

	public int getVarClaseC() {return varClaseC;}
	public void setVarClaseC(int varClaseC) {this.varClaseC = varClaseC;}
	
	public ClaseC(int a, int b, int c) {
		super(a,b);
		this.varClaseC = c;
	}
	
	@Override
	public int metodoIntB() {
		return (int)Math.pow(this.varClaseC, 2);
	}
	
	@Override
	public double metodoIntC() {
		return Math.sqrt(this.varClaseC);
	}
	
	@Override
	public int metodoIntD() {
		return this.getVarClaseA() * this.getVarClaseB() * this.varClaseC;
	}
	
	@Override
	public String toString() {
		return super.toString()
				+ "\n\tC: " + this.varClaseC;
	}
	
}
