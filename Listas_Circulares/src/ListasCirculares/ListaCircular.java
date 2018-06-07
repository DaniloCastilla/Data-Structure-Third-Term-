package ListasCirculares;
/**
 * @author Danilo Castilla
 */
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class ListaCircular {

	public NodeLC ultimo = null;
	
	public boolean isEmpty() {//Method Check if empty
		
			return ultimo == null ? true : false;
			
		}//end method
	
	public ListaCircular insertar(int element) {
		
		NodeLC LCN = new NodeLC(element);
		
		if(!isEmpty()) {
			
			LCN.next = ultimo.next;
			ultimo.next = LCN;
		}
		
		ultimo = LCN;
		return this;
		
	}
	
	public void Printlist() throws IOException {
		
		BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));
		
		NodeLC temp = ultimo.next;
		
		String Cadena = "";
		
		do {
			
			Cadena = "[" + temp.dato + "]";
			System.out.println(Cadena);
			temp = temp.next;		
			
		}while(temp!=ultimo.next);
		
	}
	
	public boolean delete(int elemento) {
		
		NodeLC temp = ultimo;
		
		boolean found = false;
		
		while(temp.next!=ultimo && !found) {
			
			found = (temp.next.dato==elemento);
			if(!found) {
				temp = temp.next;
			}
			
		}
		
		found = (temp.next.dato==elemento);
		
		if(found) {
			
			NodeLC aux = temp.next;
			
			if(ultimo == ultimo.next) {
				ultimo = null;
			}else {
				
				if(aux==ultimo) {
					ultimo = temp;
				}
				
				temp.next = aux.next;
				
			}
			
			aux = null;
			
		}
		
		return found == true;
		
	}
	
	public static void main(String[] args) throws IOException {
		
		ListaCircular lc = new ListaCircular();
		
		lc.insertar(10);
		lc.insertar(12);
		lc.insertar(5);
		lc.insertar(15);
		lc.insertar(45);
		
		lc.delete(50);
		lc.Printlist();
		
	}	
}
