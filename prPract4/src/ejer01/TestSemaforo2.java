package ejer01;

public class TestSemaforo2 {

	public static void main(String[] args) {

		Semaforo2 miSemaforo = new Semaforo2("Verde");
		Semaforo2 semaforoDeMiCalle = new Semaforo2();
		Semaforo2 otroSemaforo = new Semaforo2("Amarillo");
		
		miSemaforo.setColor("Rojo");
		otroSemaforo.setColor("Verde");
		
		System.out.println(otroSemaforo.getColor());
		System.out.println(semaforoDeMiCalle.getColor());
		
		if (miSemaforo.getColor().equals("Rojo"))
			System.out.println("No pasar");
		
		if (miSemaforo.puedoPasar())
			System.out.println("Puedes pasar");
		else
			System.out.println("No puedes pasar");
		
		System.out.println("\n" + miSemaforo.toString());
		System.out.println("\n" + otroSemaforo.toString());
		System.out.println("\n" + semaforoDeMiCalle.toString());

		if (miSemaforo.equals(semaforoDeMiCalle))
			System.out.println("Tienen el mismo color");
		else
			System.out.println("Tienen diferente color");
		
	}

}
