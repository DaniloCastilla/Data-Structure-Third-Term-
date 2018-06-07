package EHE;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Exercise_5 {
	
	public Node_Q3 head = null;
	public Node_Q3 H = null;
	
	public boolean isEmpty() {//Check if is empty
		
		return head == null ? true : false;
		
	}//end method
	
	public void enqueue(Node_Q3 newNodeQ3){//Insert at begin of the Queue

		if(isEmpty()) {
			
			head = newNodeQ3;	
			
		}else{
			
		Node_Q3 temp = head;
		
		while(temp.next != null) {
			
			temp = temp.next;
		}
		temp.next = newNodeQ3;	
	}
		
}//end method
	
	public void enqueue2(Node_Q3 newNodeQ3){//Insert at begin of the Queue

		if(isEmpty()) {
			
			H = newNodeQ3;	
			
		}else{
			
		Node_Q3 temp = H;
		
		while(temp.next != null) {
			
			temp = temp.next;
		}
		temp.next = newNodeQ3;	
	}
		
}//end method
	
	public void printList() throws IOException {//Method that prints the contents of the list
		
		BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));
		
		Node_Q3 temp = H;
		while(temp != null){
			
			bw.write(temp.toString());
			temp = temp.next;
		}
		
		bw.write("\n");
		bw.flush();
		
	}//end method
	
	public int listSize() {//gets List size
		
		int counter = 0;
		Node_Q3 temp = H;
		
		while(temp != null)
		{
			
			counter +=1;
			temp = temp.next;
			
		}
		
		return counter;
		
	}//end method
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		Exercise_5 E_5 = new Exercise_5();
		
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));
		
		int Num = Integer.parseInt(br.readLine());
		
		
		for (int i = 0; i < Num; i++) {
			
			String Luchadores = br.readLine();
			String Fila[] = Luchadores.split(" ");
			
			for (int j = 0; j < Integer.parseInt(Fila[0]); j++) {
				
				E_5.enqueue2(new Node_Q3(Integer.parseInt(Fila[j+1])));
				
			}
		}
		
		E_5.printList();
		System.out.println(E_5.listSize());
		
		int action = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < action; i++) {
			
			String comando = br.readLine();
			String C[] = comando.split(" ");
			
			if(Integer.parseInt(C[0]) == 0) {
				
				if(Integer.parseInt(C[1])==1) {
					
					Node_Q3 temp;
					Node_Q3 Pre = E_5.head;
					
					while(Pre.next.next != null) {
						Pre = Pre.next;
					}
					
					temp = Pre.next;
					Pre.next = null;
					temp = null;
					System.gc();
					
					E_5.printList();
				}else {
					
				Node_Q3 temp;
				Node_Q3 Pre = E_5.H;
				
				while(Pre.next.next != null) {
					Pre = Pre.next;
				}
				
				temp = Pre.next;
				Pre.next = null;
				temp = null;
				System.gc();
				
				E_5.printList();
				
		}	
				
	}else if(Integer.parseInt(C[0]) == 1) {
				
				if(Integer.parseInt(C[1]) == 1) {
					E_5.enqueue(new Node_Q3(Integer.parseInt(C[2])));
					E_5.printList();
				}else
					E_5.enqueue2(new Node_Q3(Integer.parseInt(C[2])));
					
			}else if(Integer.parseInt(C[0]) == 2){
				
				int poder=0;
				
				Node_Q3 temp1 = E_5.H;
				
				for (int j = 0; j < E_5.listSize() ; j++) {
					
					while(temp1!=null) {
						
						if(temp1.FilaL < temp1.next.FilaL) {
							
							poder = 1;
							
							break;
							
						}
						poder = 0;
						temp1 = temp1.next;
						
					}
					
					if(poder == 1) {
						break;
						
					}else {
						
						temp1 = temp1.next;
						temp1 = E_5.H;
						
					}	
					
				}
				
				if(poder == 1) {
					
					System.out.println("Si");
					
				}else {
					
					System.out.println("No");
			}
		}	
	}	
}
}
