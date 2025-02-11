package ejer07;

public interface InterfazPila<E> {
	public E pop();
	public void push(E ob);
	public boolean isVacia();
	public E cima();
}
