package TDAGrafo;

public class Arco<V,E>{
	private V anterior;
	private E siguiente;

	public Arco(V anterior,E siguiente) {
		this.anterior=anterior;
		this.siguiente=siguiente;
	}

	public V getAnterior() {
		return anterior;
	}

	public E getSiguiente() {
		return siguiente;
	}

	public void setAnterior(V anterior) {
		this.anterior=anterior;
	}

	public void setSiguiente(E siguiente) {
		this.siguiente=siguiente;
	}
}
