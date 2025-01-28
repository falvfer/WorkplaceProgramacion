package aclaracion;

public class Test1 {

	/**
	 * Testeo de los métodos equals de Profesor y Persona
	 * @param args
	 */
	public static void main(String[] args) {

        Profesor profesor1 = new Profesor ("Juan", "Hernández García", 33, "Prof 22-387-11" );
        Profesor profesor2 = new Profesor ("Juan", "Hernández García", 33, "Prof 22-387-11");
        Profesor profesor3 = new Profesor ("Juan", "Hernández García", 33, "Prof 11-285-22");
        
        Persona persona1 = new Persona ("José", "Hernández López", 28);
        Persona persona2 = new Persona ("José", "Hernández López", 28);
        Persona persona3 = new Persona ("Ramiro", "Suárez Rodríguez", 19);
        
        System.out.println("¿Son iguales la persona1 y la persona2? " + 
                               persona1.equals(persona2) );
        System.out.println("¿Son el mismo objeto la persona1 y la persona2? " 
                            + (persona1 == persona2) ); 
        System.out.println("¿Son iguales la persona1 y la persona3? " + 
                               persona1.equals(persona3) );  
        System.out.println ("¿Son iguales el profesor1 y el profesor2? " + 
                               profesor1.equals(profesor2) );
        System.out.println ("¿Son iguales el profesor1 y el profesor3? " +  
                               profesor1.equals(profesor3) );
	}

}
