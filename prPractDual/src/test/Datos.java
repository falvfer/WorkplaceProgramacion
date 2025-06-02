package test;

public enum Datos {
	
	URL_BBDD("jdbc:mysql://localhost:3306/expedientes"),
	USUARIO("francisco"),
	CONTRASEÑA("1234");
	
	private String str;
	
	public String getInfo() {return this.str;}
	
	private Datos(String str) {
		this.str = str;
	}

}
