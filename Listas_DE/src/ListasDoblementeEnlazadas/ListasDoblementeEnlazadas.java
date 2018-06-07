
package ListasDoblementeEnlazadas;

/**
 * @author Danilo Castilla
 */

public class ListasDoblementeEnlazadas {

	private NodeLD inicio,fin;
	
	public ListasDoblementeEnlazadas() {
		
	inicio=fin=null;	
		
	}
	
	public boolean isEmpty() {
		return inicio==null;
	}
	
	public void insertAtEnd(int valor) {
	
		if(isEmpty()) {
			inicio = fin = new NodeLD(valor);
		}else {	
			fin = new NodeLD(valor,null,fin);
			inicio.pre.next = fin;
		}
		
	}
	
	public void insertAtBegin(int valor) {
		
		if(isEmpty()) {
			inicio = fin = new NodeLD(valor);
		}else {	
			inicio = new NodeLD(valor,inicio,null);
			inicio.next.pre = inicio;
		}
		
	}
	
	public void deleteAtBegin() {
		
		if(inicio == fin) {
			inicio=fin=null;
		}else {
			inicio = inicio.next;
			inicio.pre = null;
		}
		
	}
	
	public void deleteAtEnd() {
		
		if(inicio==fin) {
			inicio=fin=null;
		}else {
			fin = fin.pre;
			fin.next = null;
		}
		
	}
	
	public void deleteAtValor(int valor) {
		
		NodeLD temp = inicio;
		NodeLD tempA = temp;
		NodeLD tempS;
		
		while(temp.dato != valor) {
			
			tempA = temp;
			temp = temp.next;
			
		}
		
		tempA.next = null;
		tempA.next = temp.next;
		
		temp.next.pre = null;
		temp.next.pre = temp.pre;
	}
	
	public void PrintListItoF() {
		
		if(!isEmpty()) {
			String cadena = "<=>";
			NodeLD aux = inicio;
			while(aux!=null) {
				
				System.out.print(aux.dato + cadena);
				aux = aux.next;
			}
			
		}
		
	}
	
	public void PrintListFtoI() {
		
		if(!isEmpty()) {
			String cadena = "<=>";
			NodeLD aux = fin;
			while(aux!=null) {
				
				System.out.print(aux.dato + cadena);
				aux = aux.pre;
			}
			
		}
		
	}
	
	public static void main(String[] args) {
		
		ListasDoblementeEnlazadas LDE = new ListasDoblementeEnlazadas();
		
		LDE.insertAtBegin(12);
		LDE.insertAtBegin(32);
		LDE.insertAtBegin(45);
		LDE.insertAtBegin(4);
		LDE.insertAtBegin(72);
		LDE.deleteAtValor(45);
		
		LDE.PrintListItoF();
		
	}
	
}
