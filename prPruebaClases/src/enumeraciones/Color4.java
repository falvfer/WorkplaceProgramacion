package enumeraciones;

public enum Color4 {
	ROJO, VERDE, AZUL;
	
	// enum constructor llamado por separado para cada constante
	private Color4() {
		System.out.println("Constructor llamado para : " +
				this.toString());
	}
	
	// Solo m�todos concretos (no abstractos) permitidos
	public void colorInfo() {
		System.out.println("Color Universal");
	}
}
