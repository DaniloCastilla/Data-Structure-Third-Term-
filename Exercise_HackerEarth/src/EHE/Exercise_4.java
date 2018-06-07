package EHE;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Exercise_4 {
	
	static String cadena = "";
	
	public Node_Q2 head = null; //Empty list
	
	public boolean isEmpty() {//Check if is empty
		
		return head == null ? true : false;
		
	}//end method
	
	public void enqueue(Node_Q2 newNode){//Insert at begin of the Queue

		if(isEmpty()) {
			
			head = newNode;	
			
		}else{
			
		Node_Q2 temp = head;
		
		while(temp.next != null) {
			
			temp = temp.next;
		}
		temp.next = newNode;	
	}
		
}//end method
	
	public void printList() throws IOException {//Method that prints the contents of the list
		
		BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));
		
		Node_Q2 temp = head;
		while(temp != null) {
			
			bw.write(temp.toString());
			temp = temp.next;
		}
		
		bw.write("\n");
		bw.flush();
		
	}//end method
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		Exercise_4 E_4 = new Exercise_4();
		
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));
		
		int acciones = Integer.parseInt(br.readLine());
		
		
		for (int i = 0; i < acciones; i++) {

			String Cadena = br.readLine();
			String C_Final[] = Cadena.split(" ");
			
		if(C_Final[0].equals("E")) {
			
			if(E_4.isEmpty()) {
				
				E_4.enqueue(new Node_Q2(Integer.parseInt(C_Final[1]) , Integer.parseInt(C_Final[2])));
				
			}else{
				
				Node_Q2 temp = E_4.head;
				Node_Q2 pre = E_4.head;
				
				while(temp!=null) {
					
					if(Integer.parseInt(C_Final[1])<temp.escuela) {
						
						break;
						
					}else
						
						pre = temp;
						temp = temp.next;
					
				}
				
				pre.next = new Node_Q2(Integer.parseInt(C_Final[1]) , Integer.parseInt(C_Final[2]));
				pre.next.next = temp;
				
				
				
			}
		
		}else if(C_Final[0].equals("D")){
			
			Node_Q2 temp = E_4.head;
			E_4.head = E_4.head.next;
			cadena = temp.toString();
			System.out.println(cadena);
			System.gc();
			
		}
		
	}		
}
}
