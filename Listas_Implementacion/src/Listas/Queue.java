/**
 * 
 * @author Danilo Castilla
 * @date 10/03/1018
 * @version 1.0
 * @description: Implement the concept of queue(FIFO)
 * 
 */

package Listas; //main package

public class Queue{//class queue
	
	public Node head = null; //Empty list

	public boolean isEmpty() {//Check if is empty
		
		return head == null ? true : false;
	}//end method
	
	public void enqueue(Node newNode){//Insert at begin of the Queue
		
		newNode.next = head;
		head = newNode;
		
	}//end method
	
	public Node dequeue(){//Delete at end of the Queue
		
		Node temp;
		Node Pre = head;
		
		while(Pre.next.next != null) {
			Pre = Pre.next;
		}
		
		temp = Pre.next;
		Pre.next = null;
		return temp;
		
	}//end method

	public static void main(String[] args) {//Main method
		
		Queue Q = new Queue();
		Q.enqueue(new Node("Danilo", 19 , 594880));

	}//end main method

}//end class