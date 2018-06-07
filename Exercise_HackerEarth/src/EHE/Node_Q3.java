package EHE;

public class Node_Q3{//class Node
	
	public int FilaL;
	
	public Node_Q3 next; //pointer
	
	public Node_Q3() {}//Constructor
	
	public Node_Q3(int valor)
	{//beginning constructor
		
		this.FilaL = valor;
		
		
	}//end Initialization
	
	public String toString() {//method print list
		
		return this.FilaL + "";
		
	}
	
	public Node_Q3 clone() {//List Clone
		
		Node_Q3 clone = new Node_Q3(this.FilaL);
			return clone;
			
		}//end method
}