package Exercise;

/**
 * @author Danilo Castilla
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Choosing_a_Place {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int Suma_Total = 0;
		int C = 0;
		int P = Integer.parseInt(br.readLine());
		int Promedio;
		
		int G_Fila = 0;
		int G_Columna = 0;
		int Parametter = 0;
		
		int Matriz [][] = new int [13][13];//Creacion de la matriz
		
		for (int i = 0; i < 13; i++) {
			
			String line = br.readLine();
			String [] Final = line.split(" ");
						
				for (int j = 0; j < 13; j++) {		
					Matriz[i][j] = Integer.parseInt(Final[j]);	
				}				
		}
		
		for (int i = 0; i < 13; i++) {
			
			for (int j = 0; j < 13; j++) {
				
				if(Matriz[i][j] == 0) {
					
					if((Matriz[i-1][j-1] != 88) && (Matriz[i-1][j-1] != 99) && 
							(Matriz[i-1][j-1] != 11)) {
						Suma_Total += Matriz[i-1][j-1];
						C++;
					}
					
					if((Matriz[i-1][j] != 88) && (Matriz[i-1][j] != 99) && 
							(Matriz[i-1][j] != 11)) {
						Suma_Total += Matriz[i-1][j];
						C++;
					}
					
					if((Matriz[i-1][j+1] != 88) && (Matriz[i-1][j+1] != 99) && 
							(Matriz[i-1][j+1] != 11)) {
						Suma_Total += Matriz[i-1][j+1];
						C++;
					}
					if ((Matriz[i][j-1] != 88) && (Matriz[i][j-1] != 99) && 
							(Matriz[i][j-1] != 11)) {
						Suma_Total += Matriz[i][j-1];
						C++;
					}
					
					if((Matriz[i][j+1] != 88) && (Matriz[i][j+1] != 99) && 
							(Matriz[i][j+1] != 11)) {
						Suma_Total += Matriz[i][j+1];
						C++;
					}
					
					if((Matriz[i+1][j-1] != 88) && (Matriz[i+1][j-1] != 99) && 
							(Matriz[i+1][j-1] != 11)) {
						Suma_Total += Matriz[i+1][j-1];
						C++;
					}
					
					if((Matriz[i+1][j] != 88) && (Matriz[i+1][j] != 99) && 
							(Matriz[i+1][j] != 11)) {
						Suma_Total += Matriz[i+1][j];
						C++;
					}
					
					if((Matriz[i+1][j+1] != 88) && (Matriz[i+1][j+1] != 99) && 
							(Matriz[i+1][j+1] != 11)) {
						Suma_Total += Matriz[i+1][j+1];
						C++;
					}
					
					Promedio = Suma_Total/C;
					
					if(P >= Promedio) {
						
						G_Fila = i + 1;
						G_Columna = j + 1;
						Parametter = 1;
						break;
						
					}else {
						
						Suma_Total = 0;
						C=0;
						
						break;
						
					}
					
				}
			}
			
			if(Parametter == 1) {
				break;
			}
			
		}	
		
		System.out.println("linha > " + G_Fila +  " coluna > " + G_Columna);
		
	}	
}
