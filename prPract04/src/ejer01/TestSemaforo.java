package ejer01;

public class TestSemaforo {

	public static void main(String[] args) {

		Semaforo miSemaforo = new Semaforo("Verde");
		Semaforo semaforoDeMiCalle = new Semaforo();
		Semaforo otroSemaforo = new Semaforo();
		
		System.out.println(miSemaforo.toString());
		miSemaforo.setColor("Rojo");
		System.out.println(miSemaforo);
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

	}

}
