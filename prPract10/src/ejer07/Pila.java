package ejer07;

import java.util.*;

public class Pila<E> implements InterfazPila<E>{

	private List<E> pila;
	
	public Pila() {
		this.pila = new ArrayList<E>();
	}

	@Override
	public E pop() {
		return this.pila.removeLast();
	}

	@Override
	public void push(E ob) {
		this.pila.addLast(ob);
	}

	@Override
	public boolean isVacia() {
		return this.pila.size() == 0;
	}

	@Override
	public E cima() {
		return this.pila.getLast();
	}

	
}
