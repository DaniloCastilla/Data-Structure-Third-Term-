import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
/**
 * @author Danilo Castilla
 */
public class Function_Hash {

	String arreglo[];
	int tamanio , contador;
	
	public Function_Hash(int tam) {
		
		this.tamanio = tam;
		this.arreglo = new String[tam];
		Arrays.fill(arreglo,"-1");
		
	}
	
	public void Hash_Function(String[] arrayC , String[] arreglo) {
		
		int i;
		for (i = 0; i < arrayC.length; i++) {
			String elemento = arrayC[i];
			int indiceArray = Integer.parseInt(elemento) % 7;
			System.out.println("El indice es " + indiceArray + " Para el elemento " + elemento);
			
			//Colisiones
			while(arreglo[indiceArray] != "-1") {
				indiceArray++;
				System.out.println("Ocurrio una colision en el indice " + (indiceArray-1) + 
						" Cambiar al indice " + indiceArray);
				
				indiceArray %= tamanio;
			}
			
			arreglo[indiceArray] = elemento;
			
		}
		
	}
	
	public void print() {
		int inc = 0 , i , j;
		for (i = 0;  i<1; i++) {
			inc += 8;
			for (j = 0; j < 71; j++) {
				System.out.print("-");
			}
			System.out.println();
			
			for (j = inc -8; j < inc; j++) {
				System.out.format("| %3s " + " " , j);
			}
			System.out.println("|");
			
			for (int n = 0; n < 71; n++) {
				System.out.print("-");
			}
			
			System.out.println();
			
			for (j = inc - 8; j < inc; j++) {
				
				if(arreglo[j].equals("-1")) {
					System.out.print("| 	    ");
				}else {
					System.out.print(String.format("| %3s " + " ", arreglo[j]));
				}
			}
			
			System.out.println("|");
			
			for (j = 0; j < 71; j++) {
				System.out.print("-");
			}
			System.out.println();
		}
	}
	//Metodo Buscar elemento
	public String Search(String elemento) {
		int indexArray = Integer.parseInt(elemento)%7;
		int C = 0;
		
		while(arreglo[indexArray] != "-1") {
			if(arreglo[indexArray] == elemento) {
				System.out.println("El elemento " + elemento + " fue encontrado en el indice "
						+ indexArray);
				
				return arreglo[indexArray];
			}
			
			indexArray++;
			indexArray%=tamanio;
			C++;
			
			if(C > 7) {
				break;
			}
			
		}
		
		return null;
	}
	
	public static void main(String[] args) throws IOException {
		
		Function_Hash hash = new Function_Hash(8);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] elementos = {"20","33","21","10","12","14","56","100"};
		hash.Hash_Function(elementos, hash.arreglo);
		hash.print();
		String input = br.readLine();
		String buscar = hash.Search(input);
		if(buscar == null) {
			System.out.println("El elemento " + input + " no se encuentra en la tabla");
		}
	}
	
}
