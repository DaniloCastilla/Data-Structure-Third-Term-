package Graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
 
/**
@author Danilo Castilla
*/
public class Graphs {
 
private static int matrizA[][];
private static int maxV;
private static int maxA;
private static int aristas;
private static int visitado[];

 
/**
* Creacion
*/
	public void crearGrafo(int nVertices, int nAristas) {

		maxV = nVertices;
		maxA = nAristas;
		aristas = 0;
		matrizA = new int[maxV][maxV];
	}
 
/**
* Insertar aristas

*/
	
	public void insertaArista(int v1, int v2, int dist) {
	
		if (v1 >= maxV || v2 >= maxV) {
	
			throw new ArrayIndexOutOfBoundsException(
	
					"Vertices inválidos, fuera de rango" + "nRango de vertices: 0 - " + (maxV - 1));
	
		} else
			if (aristas == maxA) {
	
				throw new UnsupportedOperationException("No se puede añadir más aristas");
	
			} else {
	
				matrizA[v1][v2] = dist;
	
				matrizA[v2][v1] = dist;
	
			}	
	}
	
	//funcion existe conexion
    public boolean Conection(int from, int to){
        return matrizA[from][to] != 0;
    }
    
	//
    public int countSpecies(int count, int vertice){
        visitado[vertice] = 1;
        for (int i = 0; i < maxV; i++) {
            if(Conection(vertice, i) && visitado[i] == 0){
                count = countSpecies(++count,i);
            }
        }
        return count;
    }
	 
	/**
	* Calcula la distancia mas corta.
	*/
	
	public static int[] dijkstra(int inicio) {
	
		int[] distancia = new int[maxV];
	
		int[] padre = new int[maxV];
	
		boolean[] visto = new boolean[maxV];
	
		for (int i = 0; i < maxV; i++) {
			distancia[i] = 999999999;
			padre[i] = -1;
			visto[i] = false;
		}
		distancia[inicio]=0;
		
		PriorityQueue<Integer> pila = new PriorityQueue<>();
		pila.add(distancia[inicio]);
		
		while (!pila.isEmpty()) {
			int u = pila.poll();
			visto[u] = true;
			
			for (int i = 0; i < maxV; i++) {
				
				if (matrizA[u][i] != 0) {
//Editar para que nos incluya el parametro gas que es un arreglo de strings.					
					if (distancia[i] > distancia[u] + matrizA[u][i]) {
						distancia[i] = distancia[u] + matrizA[u][i];
						padre[i] = u;
						pila.add(i);
					}
				}
			}
		}
		return distancia;
	}	
}