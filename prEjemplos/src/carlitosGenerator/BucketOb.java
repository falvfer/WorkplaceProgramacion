package carlitosGenerator;

import java.util.Objects;

public class BucketOb<E extends Comparable<E>> implements Comparable<BucketOb<E>>{

// Variables
	private E ob;
	private int probabilidad;
	
// Getters y Setters
	public E getOb() {return ob;}
	public int getProbabilidad() {return probabilidad;}
	
	public void setOb(E ob) {this.ob = ob;}
	public void setProbabilidad(int probabilidad) {this.probabilidad = probabilidad;}
	
// Constructor
	public BucketOb(E ob, int probabilidad) {
		this.ob = ob;
		this.probabilidad = probabilidad;
	}
	
// equals, hashCode, Comparable
	@Override
	public int hashCode() {
		return Objects.hash(ob);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BucketOb<?> other = (BucketOb<?>) obj;
		return Objects.equals(ob, other.ob);
	}

	@Override
	public int compareTo(BucketOb<E> o) {
		return this.ob.compareTo(o.ob);
	}
	
}
