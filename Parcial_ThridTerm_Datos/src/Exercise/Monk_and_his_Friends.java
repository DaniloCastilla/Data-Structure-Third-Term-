package Exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Danilo Castilla
 */

public class Monk_and_his_Friends {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			String Cases = br.readLine();
			
			for (int Z = 0; Z < Integer.parseInt(Cases); Z++) {
				
			String Students1 = br.readLine();
			String Students_F1[] = Students1.split(" ");
			
			int A [] = new int [Integer.parseInt(Students_F1[0])];
			int B [] = new int [Integer.parseInt(Students_F1[1])];
			
			String Students2 = br.readLine();
			String Students_F2[] = Students2.split(" ");
			
			int Counter_A = 0;
			int Counter_B = 0;
			int C=0;
			
			
			for (int i = 0; i < A.length; i++) {
				
				A[i] = Integer.parseInt(Students_F2[i]);
				
			}
			
			for (int i = A.length; i < (A.length + B.length); i++) {
				
				B[C] = Integer.parseInt(Students_F2[i]);
				C++;
			}
			
			for	(int i = A.length ; i < (A.length + B.length); i++) {
				
				for (int j = 0; j < A.length; j++) {
					
					if(Integer.parseInt(Students_F2[i]) == A[j]) {
						Counter_A += 1;
					}else {
						Counter_B += 1;
					}		
				}
				
				if(Counter_A != 0)
					System.out.println("YES");
				else
					System.out.println("NO");
				
				Counter_A = 0;
				Counter_B = 0;
			}
			
			}
	}
}