package EHE;

public class Node_Q2{//class Node

	//Student
	public int escuela;
	public int pergamino;
	
	
	public Node_Q2 next; //pointer
	
	public Node_Q2() {}//Constructor
	
	public Node_Q2(int School, int pergamino)
	{//beginning constructor
		
		this.escuela = School;
		this.pergamino = pergamino;
		
		
	}//end Initialization
	
	public String toString() {//method print list
		
		return this.escuela + "" + this.pergamino + " ";
		
	}
}