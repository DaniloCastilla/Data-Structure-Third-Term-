/**
 * 
 * @author Danilo Castilla
 * @date 10/03/1018
 * @version 1.0
 * @description: Implement the concept of Stack (LIFO)
 * 
 */

package Listas; //main package

import java.io.IOException;//importa class

public class Stack {//class Stack
	
	public Node head = null; //Empty list
	
	public boolean isEmpty() {//Check if is empty
		
		return head == null ? true : false;
	}//end method

	public Node Pop(){//Get the first of the Stack
		
		Node temp = head;
		head = head.next;
		return temp;
		
	}//end method
	
	public void Push(Node newNode){//Put at te begin
		
		newNode.next = head;
		head = newNode;
		
	}//end method
	
	public static void main(String[] args) throws IOException {//Main method
		
		Stack St = new Stack();//Create object
		
		St.Push(new Node("Danilo" , 19 , 594880));
		St.Push(new Node("Juan" , 22 , 458912));
		St.Push(new Node("Dario" , 28 , 568920));
		St.Push(new Node("Jose" , 30, 564812));
		St.Push(new Node("Ramiro", 45 , 157859));
		
		System.out.print(St.Pop().toString());
		System.out.print(St.Pop().toString());
		System.out.print(St.Pop().toString());
		System.out.print(St.Pop().toString());
		System.out.print(St.Pop().toString());
		
	}//end main class
	
}//end class
