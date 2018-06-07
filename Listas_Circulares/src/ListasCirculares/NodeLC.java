package ListasCirculares;
/**
 * @author Danilo Castilla
 */
public class NodeLC {

	public int dato;
	
	public NodeLC next;
	
	public NodeLC(int valor) {
		this.dato = valor;
		next = this;
	}
	
	public String toString() {
		return this.dato + "";
	}
}
