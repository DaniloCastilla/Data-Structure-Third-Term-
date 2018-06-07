package Grafos;
/**
 * @author Danilo Castilla
 */
public class Grafo {
	
	//Metodo para determinar todos los caminos
	
	public String MinimunWay(long[][] MP) {
		
		int vertices = MP.length;
		
		long matrizAdyacente[][] = MP;
		String ways[][] = new String [vertices][vertices];
		String Tempways[][] = new String [vertices][vertices];
		
		String goWays = "", cadena = "", extraWay = "";
		int i , j , k;
		float temp1 , temp2, temp3 , temp4 , minimo;
		
		//inicializando matrices Ways
		
		for(i = 0; i<vertices;i++) {
			for(j = 0; j< vertices;j++) {
				
				ways[i][j] = "";
				Tempways[i][j]="";
			}
		}
		
		for(k = 0 ; k < vertices ; k++) {
			for(i = 0 ; i < vertices ; i++) {
				for(j = 0 ; j < vertices ; j++) {
					
					temp1 = matrizAdyacente[i][j];
					temp2 = matrizAdyacente[i][k];
					temp3 = matrizAdyacente[k][j];
					temp4 = temp2 + temp3;
					//Encontrar camino minimo
					minimo = Math.min(temp1, temp4);
					
					if(temp1 != temp4) {
						if(minimo == temp4) {
							goWays = "";
							Tempways[i][j] = k + "";
							ways[i][j] = WayR(i,k,Tempways,goWays) + (k+1);
						}	
					}
					
					matrizAdyacente[i][j] = (long) minimo;
				}
			}
		}
		
		//Agregar Camino a Cadena
		
		for(i = 0; i<vertices;i++) {
			for(j = 0; j< vertices;j++) {
				
				cadena += "[" + matrizAdyacente[i][j] + "]";
				
			}
			
			cadena += "\n"; 
		}
		
		//////
		for(i = 0; i<vertices;i++) {
			for(j = 0; j< vertices;j++) {
				
				if(matrizAdyacente[i][j] != -1) {
					
					if(i!=j) {
						
						if(ways[i][j].equals("")) {
							
							extraWay += "De (" + (i+1) + "--->" + (j+1) + ") irse por... (" + 
							(i+1) + ", " + (j+1) + ")\n";   
							
						}else {
							extraWay += "De (" + (i+1) + "--->" + (j+1) + ") irse por... (" + 
							(i+1) + ", " + ways[i][j] + ", " + (j+1) + ")\n";
						}
						
					}
					
				}
				
			}
		}
		
		return "La Matriz de Caminos mas cortos entre los diferentes vertices es:\n" + cadena + 
				"\nLos Diferentes caminos mas cortos entre los vertices son:\n" + extraWay;
		
	}
	
	public String WayR(int i , int k, String tempArray[][], String goArray ) {
		
		if(tempArray[i][k].equals("")) {
			
			return "";
			
		}else {
			//Recursividad
			goArray += WayR(i, Integer.parseInt(tempArray[i][k].toString()), tempArray, goArray) +
					(Integer.parseInt(tempArray[i][k].toString())+1) + ", ";
			
			return goArray;
			
		}
	}
}