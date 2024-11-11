package ejemploCirculo;

//Fichero Circulo.java

public class Circulo {
	
// VARIABLES MIEMBRRO
	
	// Variable de clase
	private static int numCirculos = 0;
	
	// Variable de clase constante
	public static final double PI = 3.14159265358979323846;
	
	// Variables de instancia u objeto
	private double x, y, radio;

	
	
	
// CONSTRUCTORES
	
	public Circulo(double x, double y, double r) {
		this.x = x;
		this.y = y;
		this.radio = r;
		numCirculos++;
	}

	public Circulo(double r) {
		this(0.0, 0.0, r); // Esto vuelve a llamar a un constructor,
						   // en este caso el primero por los parametros indicados
	}

	public Circulo(Circulo c) {
		this(c.x, c.y, c.radio);
	}

	public Circulo() {
		this(0.0, 0.0, 1.0);
	}

	
	
	
// METODOS DE OBJETO o INSTANCIA O FUNCIONES MIEMBRO
	
	// Método que calcula el perímetro de un círculo
	public double perimetro() {
		return 2.0 * PI * radio;
	}

	// Método que calcula el área de un círculo
	public double area() {
		return PI * radio * radio;
	}

	// Método de objeto para comparar círculos
	public Circulo elMayor(Circulo c) {
		if (this.radio >= c.radio)
			return this;
		else
			return c;
	}
	
	// Métodos getter's and setter's
	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getRadio() {
		return radio;
	}

	public void setX(double x) {
		this.x = x;
	}

	public void setY(double y) {
		this.y = y;
	}

	public void setRadio(double radio) {
		this.radio = radio;
	}

	
	
	
// METODOS DE CLASE
	
	// Método de clase para comparar círculos
	public static Circulo elMayor(Circulo c, Circulo d) {
		if (c.radio >= d.radio)
			return c;
		else
			return d;
	}

	// Métodos get y set de numCirculos
	public static int getNumCirculos() {
		return numCirculos;
	}

	public static void setNumCirculos(int numCirculos) {
		Circulo.numCirculos = numCirculos;
	}
} // fin de la clase Circulo