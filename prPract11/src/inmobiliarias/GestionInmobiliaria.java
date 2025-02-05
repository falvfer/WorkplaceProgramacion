package inmobiliarias;

import propiedades.*;

public interface GestionInmobiliaria {
	
	public boolean añade(Propiedad ob);
	public Propiedad buscar(int cod) throws Exception;
	public boolean buscar(Propiedad p);
	public boolean borra(int cod);
	public boolean borra(Propiedad p);
	
}
