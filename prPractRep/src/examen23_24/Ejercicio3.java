package examen23_24;
/* 
 * Apuntes para el ejercicio:
 * 
 *  cadena = "";
 *  for (i=1; i<=20; i++) {
 *      si (i%3 == 0) then cadena+="Three";
 *      si (i%5 == 0) then cadena+="Five";
 *      
 *      si (cadena!="")
 *          sysout(cadena);
 *          cadena = "";
 *      sino 
 *          sysout(i);
 *  }
 */
public class Ejercicio3 {

	public static void main(String[] args) {
		
		String cadena = "";
		
		for (int i = 1; i <= 20; i++) {
			if (i%3 == 0)
				cadena += "Three";
			if (i%5 == 0)
				cadena += "Five";
			
			if (cadena!="") {
				System.out.println(cadena);
				cadena = "";
			} else {
				System.out.println(i);
			}
		}

	}

}
