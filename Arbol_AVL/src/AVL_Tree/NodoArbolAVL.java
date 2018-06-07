package AVL_Tree;
/**
 * @author Danilo Castilla
 */
public class NodoArbolAVL {

	int valor , fe;
	NodoArbolAVL left,right;
	
	public NodoArbolAVL(int d) {
	
		this.valor = d;
		this.fe = 0;
		this.left = null;
		this.right = null;
		
	}
	
	public String toString() {
		return "Valor: " + valor;
	}
	
}
