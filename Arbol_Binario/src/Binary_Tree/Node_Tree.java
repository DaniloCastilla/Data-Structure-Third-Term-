package Binary_Tree;
/**
 * @author Danilo Castilla
 */
public class Node_Tree {

	Node_Tree left;
	Node_Tree right;
	int Value;
	
	public Node_Tree() {};
	
	public Node_Tree(int valor) {
		this.Value = valor;
	}
	
	public String toString() {
		return "Valor: " + Value;
	}
	
}
