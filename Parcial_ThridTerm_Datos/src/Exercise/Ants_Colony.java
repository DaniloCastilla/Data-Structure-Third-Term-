package Exercise;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;
import Graphs.*;

/**
 * @author Danilo Castilla
 */

public class Ants_Colony {

    public static void main(String[] args) throws IOException{
       
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());//Numero de entrada (Colonias)
       
        do { 
	        int Ai; //Conexion
	        int Li ; // Peso
	        
	        Graphs g = new Graphs(); //Creacion del objeto clase Grafo
	        g.crearGrafo(N, N-1); //Vertices
	        for (int i = 1; i < N; i++) { 
	        	 String cases[] = br.readLine().split(" ");
	        	 g.insertaArista(i, Ai= Integer.parseInt(cases[0]), Li= Integer.parseInt(cases[1])); //read the cases 
				
			}
	              
	       int Q= Integer.parseInt(br.readLine()); //Leer entrada
	       int S, T; // vertice a buscar
	       for (int i = 0; i < Q; i++) {
	    	   String cases[] = br.readLine().split(" ");
	    	   S=Integer.parseInt(cases[0]);
	    	   T=Integer.parseInt(cases[1]);
	    	  
	    	   System.out.println(g.dijkstra(S)[T]); // llamar a la funcion 
		}
        }while(N==0); // Mientras sea difernete de cero la entrada, los casos seguiran
    }
}