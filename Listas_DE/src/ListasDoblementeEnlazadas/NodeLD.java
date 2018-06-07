package ListasDoblementeEnlazadas;

/**
 * @author Danilo Castilla
 */

public class NodeLD {
	
	public int dato;
	
	public NodeLD next,pre;
	
	public NodeLD(int elemento) {
		
		this(elemento,null,null);
		
	}
	
	public NodeLD(int valor,NodeLD s, NodeLD a) {
		
		this.dato = valor;
		this.next = s;
		this.pre = a;
		
	}
	
	
}
