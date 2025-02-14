package carlitosGenerator;

import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class BucketList<E extends Comparable<E>> {
	
	Random rdn = new Random();
	private Set<BucketOb<E>> objetos;
	private Integer total;
	
	public BucketList(Set<BucketOb<E>> objetos) {
		this.objetos = new TreeSet<>();
		this.objetos.addAll(objetos);
		this.total = 0;
		for (BucketOb<E> ob: objetos) {
			this.total += ob.getProbabilidad();
		}
	}
	
	public BucketList() {
		this(new TreeSet<BucketOb<E>>());
	}

	public E elige() {
		if (this.total == 0) return null;
		int probar = total;
		int eleccion = rdn.nextInt(1,this.total);
		boolean terminar = false;
		BucketOb<E> ob = null;
		
		for (Iterator<BucketOb<E>> it = this.objetos.iterator(); it.hasNext() && !terminar;) {
			ob = it.next();
			probar-=ob.getProbabilidad();
			if (eleccion >= probar)
				terminar = true;
		}
		
		if (!terminar)
			return null;
		if (ob == null)
			return null;
		
		return ob.getOb();
	}
	
	public boolean añadir(E ob, Integer probabilidad) {
		total += probabilidad;
		return this.objetos.add(new BucketOb<>(ob, probabilidad));
	}
	
	public boolean eliminar(BucketOb<E> ob) {
		return this.objetos.remove(ob);
	}
	
	
	
	
	
	
}
