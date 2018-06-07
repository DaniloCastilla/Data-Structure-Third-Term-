package EHE;

public class Node_Q{//class Node

	//Student
	public int valor;
	
	public Node_Q next; //pointer
	
	public Node_Q() {}//Constructor
	
	public Node_Q(int value)
	{//beginning constructor
		
		this.valor = value;
		
		
	}//end Initialization
	
	public String toString() {//method print list
		
		return this.valor + "";
		
	}
	
	public Node_Q clone() {//List Clone
		
		Node_Q clone = new Node_Q(this.valor);
			return clone;
			
		}//end method
}