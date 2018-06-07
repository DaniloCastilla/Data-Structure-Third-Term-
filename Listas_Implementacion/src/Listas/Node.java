/**
 * 
 * @author Danilo Castilla
 * @date 10/03/1018
 * @version 1.0
 * @description: Creating TDA called  "Node"
 * 
 */


package Listas; //main package

public class Node{//class Node

	//Student
	public String name;
	public int age;
	public int id;
	
	// C & C++: int* pointer = &a;
	
	public Node next; //pointer
	
	public Node() {}//Constructor
	
	public Node(String name, int age, int id)
	{//beginning constructor
		
		this.name = name;
		this.age = age;
		this.id = id;
		
		
	}//end Initialization
	
	public String toString() {//method print list
		
		return "Name: " + this.name + "\tAge: " + this.age + "\tId: " + this.id + "\n";
		
	}
	
	public Node clone() {//List Clone
		
		Node clone = new Node(this.name, this.age,this.id);
			return clone;
			
		}//end method
		
	}//end class