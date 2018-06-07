package EHE;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Exercise_2 {

	public static Node_Q4 head = null;
	public static Node_Q4 htemp = null;
	
	public boolean isEmpty() {//Check if is empty
		
		return head == null ? true : false;
		
	}//end method
	
	public boolean isEmpty2() {//Check if is empty
		
		return htemp == null ? true : false;
		
	}//end method
	
	public void enqueue2(Node_Q4 newNode_Q4){//Insert at begin of the Queue

		if(isEmpty2()) {
			
			htemp = newNode_Q4;	
			
		}else{
			
			Node_Q4 temp = htemp;
		
		while(temp.next != null) {
			
			temp = temp.next;
		}
		temp.next = newNode_Q4;	
	}
		
}//end method
	
	public void enqueue(Node_Q4 newNode_Q4){//Insert at begin of the Queue

		if(isEmpty()) {
			
			head = newNode_Q4;	
			
		}else{
			
			Node_Q4 temp = head;
		
		while(temp.next != null) {
			
			temp = temp.next;
		}
		temp.next = newNode_Q4;	
	}
		
}//end method
	
	public void printList() throws IOException {//Method that prints the contents of the list
		
		BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));
		
		Node_Q4 temp = head;
		while(temp != null) {
			
			bw.write(temp.toString());
			temp = temp.next;
		}
		
		bw.write("\n");
		bw.flush();
		
	}//end method
	
	public void printList2() throws IOException {//Method that prints the contents of the list
		
		BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));
		
		Node_Q4 temp = htemp;
		while(temp != null) {
			
			bw.write(temp.toString());
			temp = temp.next;
		}
		
		bw.write("\n");
		bw.flush();
		
	}//end method
	
	public void deleteAtIndex(int index) {//method delete at index of the list
		
		Node_Q4 temp = htemp;
		Node_Q4 pre = htemp;
		
		while(temp.index != index) {
			pre = temp;
			temp = temp.next;	
		}
		
		Node_Q4 toDelete = temp;
		pre.next = toDelete.next;
		toDelete = null;
		System.gc();//Call Garbage collector (destructor)
		
	}//end method
	
	public int listSize() {//gets List size
		
		int counter = 0;
		Node_Q4 temp = head;
		
		while(temp != null)
		{
			
			counter +=1;
			temp = temp.next;
			
		}
		
		return counter;
		
	}//end method
	
	public int listSize2() {//gets List size
		
		int counter = 0;
		Node_Q4 temp = htemp;
		
		while(temp != null)
		{
			
			counter +=1;
			temp = temp.next;
			
		}
		
		return counter;
		
	}//end method
	
	public static void main(String[] args) throws IOException {
		
		Exercise_2 E_2 = new Exercise_2();
		
		int C=1;
		
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		
		int index = 1;
		int aux=0;
		
		String input = br.readLine();
		int NumT = Integer.parseInt(input.split(" ")[0]);
		int Num = Integer.parseInt(input.split(" ")[1]);
		int Total[] = new int [Num];
		
		String str = br.readLine();
		
		for (int i = 0; i < NumT; i++) {
			
			E_2.enqueue(new Node_Q4(Integer.parseInt(str.split(" ")[i]),index));
			index++;
			
		}
		
		E_2.printList();
		
		for (int i = 0; i < Num; i++) {
			
			E_2.enqueue2(new Node_Q4(head.valor,head.index));
			
			head = head.next;
			
		}
		
		E_2.printList2();
		
		Node_Q4 Suma = htemp;
		int suma = 0;
		
		for (int i = 0; i < Num; i++) {
			
			for (int j = 0; j < E_2.listSize2(); j++) {
				 suma += Suma.valor;
				Suma = Suma.next;
			}
			
			Node_Q4 SumaC = htemp;
			
			if(suma==0) {
					
					for (int j2 = 0; j2 < Total.length; j2++) {
						
						if(Total[j2] == 0) {
							
							Total[j2] = SumaC.index;
							
							SumaC = SumaC.next;
						}
						
					}
					
				
				
				break;
				
			}
			
			Suma = htemp;
			suma = 0;
			
			Node_Q4 temp = htemp;
			
			for(int k = 0; k < E_2.listSize2() - 1 ; k++){
				
				if(temp.valor < temp.next.valor) {
					
					aux = temp.next.index;
					
				}
				
				temp = temp.next;
				
			}
			
			Total[i] = aux;
			
			E_2.deleteAtIndex(aux);
			
			System.out.println("Tamano de la lista: " + E_2.listSize2());
			
			Node_Q4 t = htemp;
			
			for (int j = 0; j < E_2.listSize2() ; j++) {
					
					if(t.valor == 0) {
						t.valor = 0;
					}else {
						t.valor -= 1;	
					}
					
					t = t.next;
			}
			
			E_2.printList2();
			
			if(C==1) {
				
				for (int j = 0; j < 1; j++) {
					
					E_2.enqueue2(head);
					
				}
				
				C -=1;
			}	
		}
		
		for (int i = 0; i < Total.length; i++) {
			System.out.println(Total[i]);
		}
		
	}
	
	
	
}
