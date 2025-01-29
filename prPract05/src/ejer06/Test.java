package ejer06;

public class Test {
	
	public static void main(String[] args) {
		
		ClaseA a = new ClaseA(2);
		ClaseB b = new ClaseB(a.getVarClaseA(),3);
		ClaseC c = new ClaseC(a.getVarClaseA(),b.getVarClaseB(),4);
		
		System.out.println(a+"\n");
		System.out.println(b+"\n");

		System.out.println("a * b\t" + b.metodoIntA()); // a * b
		System.out.println();
		
		System.out.println(c+"\n");
		c.setVarClaseA(4);
		System.out.println(c+"\n");
		
		System.out.println("a * b\t\t" + c.metodoIntA());
		System.out.println("pow(c,2)\t" + c.metodoIntB());
		System.out.println("sqrt(c)\t\t" + c.metodoIntC());
		System.out.println("a * b * c\t" + c.metodoIntD());
		
	}

	
}
