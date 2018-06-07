package Exercise;

/**
 * @author Danilo Castilla
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Countries_at_War {
	
	static int matrix[][] = new int [501][501];
	static int nextv;
	static int INF = (1<<25);

	static int dijkstra(int src, int des, int n) {
		
	    int short_dis, i, j;
	    int dist[] = new int [n+1];
	    boolean corr[] = new boolean[n+1];

	    for (i = 1; i <= n; i++) {
	    	
	        dist[i] = INF;
	        corr[i] = false;
	    }

	    dist[src] = 0;

	    for (i = 1; i <= n; i++) {
	        short_dis = INF;

	        if (corr[des])
	        	break;

	        for (j = 1; j <= n; j++) {
	            if ((dist[j] < short_dis) && !corr[j]) {
	                short_dis = dist[j];
	                nextv = j;
	            }
	        }

	        if (short_dis == INF) 
	        	break;

	        corr[nextv] = true;

	        for (j = 1; j <= n; j++)
	            if ((short_dis + matrix[nextv][j]) < dist[j])
	                dist[j] = (short_dis + matrix[nextv][j]);
	    }

	    return dist[des];
	}
	
	public static void main(String[]args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
	    int i, j, n, e, x, y, h, k, o, d, r;
	    
	    String input = br.readLine();
	    n = (Integer.parseInt(input.split(" ")[0]));
	    e = (Integer.parseInt(input.split(" ")[1]));
	    
	    while(n!=0 && e!=0) {
	    	
	        for (i = 1; i <= n; i++) {
	            for (j = 1; j <= n; j++) {
	            	matrix[i][j] = INF;
	            }
	        }
	        for(int m = 0 ; m< e ; m++) {
	        	
	        	String Conexion = br.readLine();
	        	
	        	x = Integer.parseInt(Conexion.split(" ")[0]);
	        	y = Integer.parseInt(Conexion.split(" ")[1]);
	        	h = Integer.parseInt(Conexion.split(" ")[2]);
	        	
	        	matrix[x][y] = h;
	            if(matrix[y][x] != INF) {
	            	matrix[x][y] = matrix[y][x] = 0;
	            }
	        }

	        String Consultas = br.readLine();
	        k = Integer.parseInt(Consultas);

	        for (i = 0; i < k; i++) {
	        	
	        	String Message = br.readLine();
	        	o = (Integer.parseInt(Message.split(" ")[0]));
	        	d = (Integer.parseInt(Message.split(" ")[1]));
	        	
	            r = dijkstra(o, d, n);
	            if(r == INF) System.out.print("\nNao e possivel entregar a carta");
	            else System.out.print("\n" + r);
	        }

	        System.out.println("\n");
	        
	        String input2 = br.readLine();
		    n = (Integer.parseInt(input2.split(" ")[0]));
		    e = (Integer.parseInt(input2.split(" ")[1]));
		    
	    }
	}
	
}
