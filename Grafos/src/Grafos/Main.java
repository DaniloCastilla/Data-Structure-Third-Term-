package Grafos;
/**
 * @author Danilo Castilla
 */
public class Main {

	public static void main(String[] args) {
		
		long MatrizA[][] = {{0,1,1,999999999,999999999},{1,0,999999999,999999999,1},{1,999999999,0,1,999999999},
				{999999999,999999999,1,0,1},{999999999,1,999999999,1,0}};
		
		Grafo ruta = new Grafo();
		System.out.println(ruta.MinimunWay(MatrizA));
		
	}
	
}
