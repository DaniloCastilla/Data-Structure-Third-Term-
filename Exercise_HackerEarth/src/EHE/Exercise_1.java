package EHE;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Exercise_1 {

	public Node_Q head = null; //Empty list
	public Node_Q head_2 = null; //Empty list

	public boolean isEmpty() {//Check if is empty
		
		return head == null ? true : false;
		
	}//end method
	
	public boolean isEmpty2() {//Check if is empty
		
		return head_2 == null ? true : false;
		
	}//end method
	
	public void enqueue(Node_Q newNode){//Insert at begin of the Queue

		if(isEmpty()) {
			
			head = newNode;	
			
		}else{
			
		Node_Q temp = head;
		
		while(temp.next != null) {
			
			temp = temp.next;
		}
		temp.next = newNode;	
	}
		
}//end method
	
	public void enqueue2(Node_Q newNode){//Insert at begin of the Queue

		if(isEmpty2()) {
			
			head_2 = newNode;	
			
		}else{
			
		Node_Q temp = head_2;
		
		while(temp.next != null) {
			
			temp = temp.next;
		}
		temp.next = newNode;	
	}
		
}//end method
	
	
	
	public int listSize() {//gets List size
		
		int counter = 0;
		Node_Q temp = head_2;
		
		while(temp != null)
		{
			
			counter +=1;
			temp = temp.next;
			
		}
		
		return counter;
		
	}//end method
	
	public void dequeue(){//Delete at end of the Queue
		
		Node_Q temp = head;
		head = head.next;
		temp = null;
		System.gc();
		
	}
	
	public void printList() throws IOException {//Method that prints the contents of the list
		
		BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));
		
		Node_Q temp = head_2;
		while(temp != null) {
			
			bw.write(temp.toString());
			temp = temp.next;
		}
		
		bw.write("\n");
		bw.flush();
		
	}//end method
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		Exercise_1 E_1 = new Exercise_1();  
		
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));
		
		int Num = Integer.parseInt(br.readLine());
		String Coins = br.readLine();
		
		String Cadena[] = Coins.split(" ");
		//System.out.println(Cadena[0]);
		
		
		for (int i = 0; i < Num; i++) {
			E_1.enqueue(new Node_Q(Integer.parseInt(Cadena[i])));
		}

		/*E_1.printList();
		int Numero_P = E_1.listSize();
		System.out.println(Numero_P);
		System.out.println(E_1.head.valor);*/
		
		String Search = br.readLine();
		
		String acciones = (Search.split(" ")[0]);
		String NumToFind = (Search.split(" ")[1]);
		
		for (int i = 0; i < Integer.parseInt(acciones); i++) {
			
			String Comando = br.readLine();
			
			if(Comando.equals("Harry")) {
				
				E_1.enqueue2(new Node_Q(E_1.head.valor));
				E_1.dequeue();
				
			}else {
				
				if(Comando.equals("Remove")){
					
					Node_Q temp;
					Node_Q Pre = E_1.head_2;
					
					while(Pre.next.next != null) {
						Pre = Pre.next;
					}
					
					temp = Pre.next;
					Pre.next = null;
					temp = null;
					System.gc();
					
			}	
		}
	}
		Node_Q temp = E_1.head_2;
		
		int sum = 0;
		
		while(temp != null) {
			
			sum += temp.valor;
			temp=temp.next;
		}
		
		//E_1.printList();
		//System.out.println(sum);
		
		if(sum == Integer.parseInt(NumToFind)) {
			
			bw.write(E_1.listSize()+"");
			bw.flush();
			
		}
			
	}	
}