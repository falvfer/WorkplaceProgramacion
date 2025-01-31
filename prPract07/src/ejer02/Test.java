package ejer02;

public class Test {
	
	public static void main(String[] args) {
		
		Cajero caja = new Cajero(5,5,5,5);
		
		CuentaJoven cJ = new CuentaJoven("1234", "Peter", 100.0, (short)1234, (byte)17);
		Cuenta c = new Cuenta("2345", "Peter 2", 200.0, (short)2345);
		CuentaEmpresarial cE = new CuentaEmpresarial("3456", "Peter 3", 23400.0, (short)3456, "Empresa Peter");
		
		try {
			
			System.out.println(caja);
			caja.sacar(c, 2345, 50);
			System.out.println(c);
			System.out.println(caja);
			caja.meter(c, 2345, 1330);
			System.out.println(caja);
			
			System.out.println(cJ);
			caja.sacar(cJ, 1234, 100);
			System.out.println(cJ);
			
			System.out.println(cE);
			caja.sacar(cE, 3456, 2000);
			System.out.println(cE);
			caja.meter(cE, 3456, 2000);
			System.out.println(cE);
			cE.reiniciarOperaciones();
			System.out.println(cE);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
	}
}
