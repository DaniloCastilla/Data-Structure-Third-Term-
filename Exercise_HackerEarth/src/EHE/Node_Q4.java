package EHE;

public class Node_Q4 {

	int valor;
	int index;
	
	public Node_Q4 next;
	
	public Node_Q4() {}
	
	public Node_Q4(int v , int i) {
	
		this.valor = v;
		this.index = i;
		
	}
	
	public String toString() {
		
		return "Valor: " + this.valor + " Indice: " + this.index + "\n";
		
	}
}
