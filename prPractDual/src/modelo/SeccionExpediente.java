package prPractDual;

public enum SeccionExpediente {
	GOBIERNO("Gobierno",(byte)0,(byte)4),
	ADMINISTRACION("Administración",(byte)4,(byte)11),
	SERVICIOS("Servicios",(byte)11,(byte)24),
	HACIENDA("Hacienda",(byte)24,(byte)27);
	
	private String nombre;
	private byte iniSub, finSub;
	
	public byte getIniSub() {return iniSub;}
	public byte getFinSub() {return finSub;}
	
	private SeccionExpediente(String nombre, byte iniSub, byte finSub) {
		this.nombre = nombre;
		this.iniSub = iniSub;
		this.finSub = finSub;
	}
	
	@Override
	public String toString() {
		return nombre;
	}
}
