package Exercises;

import java.util.Scanner;
public class Army_Parade
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int m=sc.nextInt();
		int k=sc.nextInt();
		int arr[][]=new int[k][2];
		for(int i=0;i<k;i++)
		{
			arr[i][0]=sc.nextInt();
			arr[i][1]=sc.nextInt();
		}
		int max = n > m ? n : m;
		long modulo=(long)(2*Math.pow(10,9)+33);
		
		long Diferencia=(n*m-k)%modulo;
		long total=(max*Diferencia)%modulo;
		System.out.println(total);
	}
}