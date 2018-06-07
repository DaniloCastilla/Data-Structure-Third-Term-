package Exercise;

/**
 * @author Danilo Castilla
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Analógimôn_Types {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//Grafo g = new Grafo();
		String input = br.readLine();
		
		int Tam = Integer.parseInt(input.split(" ")[0]);
		int Consulta = Integer.parseInt(input.split(" ")[1]);
		
		long MatrixAD[][] = new long [Tam][Tam];//Creacion d ela matriz
		
		for (int i = 0; i < Tam; i++) {//Rellenar la matriz segun conexiones
			for (int j = 0; j < Tam; j++) {
			
				if(i==j) {
					MatrixAD[i][j] = 0;
				}else {
					MatrixAD[i][j] = 999999999;
				}
			}
		}
		
		for (int i = 0; i < Consulta; i++) {//Recorrer y ubicar conexiones
			
			String Line = br.readLine();
			
			int PosI = Integer.parseInt(Line.split(" ")[0]); 
			int PosJ = Integer.parseInt(Line.split(" ")[1]);
			
			MatrixAD[PosI - 1][PosJ - 1] = 1;
			//MatrixAD[PosJ - 1][PosI - 1] = 1;
		}
		
		int M = Integer.parseInt(br.readLine());
		M = M-1;
		int C = 0;
		
		for (int i = 0; i < Tam; i++) {//Busqueda de secuencia
			for (int j = 0; j < Tam; j++) {
				
				if(MatrixAD[M][j] == 1) {
					
					C++;
					int temp_M = j;
					M = temp_M;
					
				}
				
			}
		}
		
		System.out.println("La especia se repite " + (C+1));//Imprime la secuencia mas el elemento a buscar
	}
}
