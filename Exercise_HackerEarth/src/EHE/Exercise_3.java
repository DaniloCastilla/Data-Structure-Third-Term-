package EHE;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Exercise_3 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));
		
		int X = 0;
		int Y = 0;
		
		String Cantidad = br.readLine();
		
		String Num = br.readLine();
		
		String Nums[] = Num.split(" ");
		
		int array_p[] = new int[Integer.parseInt(Cantidad)];
		
		for (int i = 0; i < Integer.parseInt(Cantidad); i++) {
			
			array_p[i] = Integer.parseInt(Nums[i]);
			
		}
			
			for (int n = 0; n < Integer.parseInt(Cantidad); n++) {
				
				for (int i = n; i < Integer.parseInt(Cantidad); i++) {
					
					if(i+1 == Integer.parseInt(Cantidad)) {
						X = -1;
						break;
					}
					
					if(array_p[i+1] > array_p[n]) {
						
						X = (i);
						break;
						
					}else {
						
						X = -1;
						
					}
					
				}
	
				for (int j = n; j>=0; j--) {
					
					if(j-1 == -1) {
						Y = -1;
						break;
					}
					
					if(array_p[j-1] > array_p[n]) {
						
						Y = (j);
						break;
						
					}else {
						
						Y = -1;
						
					}
					
				}
				
				int Total = (X)+(Y);
				System.out.println(Total);
				
				X=0;
				Y=0;
				
			}
	}
	
}
