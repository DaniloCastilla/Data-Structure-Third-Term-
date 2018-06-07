package Exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Danilo Castilla
 */

public class Maesters_Map {
	
	public static void Way(int alto, int ancho, char array[][])
	{
		boolean end = false;
		int F = 0;
		int C = 0;
		int memory = 0;
		char path = array[0][0];

		int i = 0;
		while (!end)
		{
			
			if(array[0][0]=='.') {
				System.out.println("no encontrado");
				break;
			}	
			
			switch (path)
			{
				case '>':
					C += 1;
					memory = 0;
					break;
				case 'v':
					F += 1;
					memory = 1;
					break;
				case '<':
					C -= 1;
					memory = 2;
					break;
				case '^':
					F -= 1;
					memory = 3;
					break;
			}

			if (path == '.')
			{
				if (memory == 0) C += 1;
				if (memory == 1) F += 1;
				if (memory == 2) C -= 1;
				if (memory == 3) F -= 1;
			}

			i += 1;
			if ((C >= ancho || C < 0) || (F >= alto || F < 0))
			{
				System.out.println("no encontrado");
				break;
			}
			else if (i > ancho * alto)
			{
				System.out.println("no encontrado");
				break;
			}

			char item = array[F][C];
			
			if (item == '*')
			{
				System.out.println("encontrado: " + F + "," + C);
				end = true;
			}
			path = item;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int C = Integer.parseInt(br.readLine());
		int F = Integer.parseInt(br.readLine());
		
		char Matriz[][] = new char[F][C];
		
		for (int i = 0; i < F; i++) {
					
			String line = br.readLine();
			char[] Final = line.toCharArray();
						
				for (int j = 0; j < C; j++) {		
					Matriz[i][j] = Final[j];	
				}				
		}
		Way(F, C, Matriz);
	}	
}