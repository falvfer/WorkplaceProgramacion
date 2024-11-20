package ejer04;

public class Fraccion {

// Variables de instancia
	int num, den;
	
// Constructores
	public Fraccion(int num, int den) {
		this.num = num;
		this.den = den;
	}
	
	public Fraccion(int num) {
		this(num, 1);
	}
	
	public Fraccion(Fraccion f) {
		this(f.num, f.den);
	}
	
	public Fraccion() {
		this(1,1);
	}
	
// Metodos públicos
	public void invierte() {
		int reserva = this.num;
		this.num = this.den;
		this.den = reserva;
	}
	
	public void simplifica() {
		int mcd = mcd(this.num,this.den);
		
		if (mcd!=1) {
			this.num /= mcd;
			this.den /= mcd;
		}
	}
	
	public Fraccion simplificacion() {
		Fraccion f = new Fraccion(this);
		f.simplifica();
		return f;
		
	}
	
	public Fraccion multiplica(Fraccion otro) {
		Fraccion f = new Fraccion(this.num * otro.num, this.den * otro.den);
		return f;
	}
	
	public Fraccion divide(Fraccion otro) {
		Fraccion f = new Fraccion(this.num * otro.den, this.den * otro.num);
		return f;
	}
	
// Metodos privados
	/**
	 * Calcula el MCD de dos números (con un bucle) usado para la funcion de "simplifica"
	 * @param num1 (Primer número)
	 * @param num2 (Segundo número)
	 * @return int --> El MCD de susodichos números
	 */
	private static int mcd(int num1, int num2) {
		while (num1!=num2) {
			if (num1>num2)
				num1-=num2;
			else
				num2-=num1;
		}
		return num1;
	}

// Overrides
	public String toString() {
		return this.num + "/" + this.den;
	}
	
	public boolean equals(Object ob) {
		Fraccion otro = (Fraccion)ob;
		return (float)this.num/this.den == (float)otro.num/otro.den;
	}
	
// Getters
	public int getNum() {
		return num;
	}
	
	public int getDen() {
		return den;
	}

// Setters
	public void setNum(int num) {
		this.num = num;
	}
	
	public void setDen(int den) {
		this.den = den;
	}
}
