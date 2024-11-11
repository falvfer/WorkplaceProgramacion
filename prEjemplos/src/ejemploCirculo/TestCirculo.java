package ejemploCirculo;

public class TestCirculo {
	public static void main(String[] args) {
		
		// Creación de varios objetos tipo Circulo, con diferentes constructores
		Circulo c1 = new Circulo(4, 5, 2);
		Circulo c2 = new Circulo(10, 25, 9);
		Circulo c3 = new Circulo(30);
		Circulo c4 = new Circulo(c2);
		Circulo c5 = new Circulo();
		Circulo c6 = c2;
		
		// Mostrar por consola los objetos anteriores
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
		System.out.println(c4);
		System.out.println(c5);
		System.out.println(c6);
		
		// Llamada a algunos de los métodos desarrollados en la clase Circulo
		System.out.println("Perimetro de c1: " + c1.perimetro());
		System.out.println("Perimetro de c2: " + c2.perimetro());
		System.out.println("Area de c3: " + c3.area());
		System.out.println("Radio de c4: " + c4.getRadio());
		c4.setRadio(12);
		System.out.println("Radio de c4: " + c4.getRadio());
		System.out.println("El mayor entre c1 y c2 es (método de objeto): " + c1.elMayor(c2));
		System.out.println("El mayor entre c1 y c2 es (método de clase): " + Circulo.elMayor(c1, c2));
	}
}