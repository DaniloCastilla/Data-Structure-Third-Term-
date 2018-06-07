package Exercise;

/**
 * @author Danilo Castilla
 */

import java.util.Scanner;

public class Mancunian_And_Colored_Tree {

	static int parent[];
	static int colour[];
 
	public static void main(String[] args) {
 
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int c = scan.nextInt();
		parent = new int[n - 1];
		for (int i = 0; i < n - 1; i++) {
			parent[i] = scan.nextInt();
		}
		colour = new int[n];
		for (int i = 0; i < n; i++) {
			colour[i] = scan.nextInt();
		}
		System.out.print(-1 + " ");
		for (int i = 1; i < n; i++) {
 
			int vColour = colour[i];
			int p = i - 1;
			int ans = findAncestor(p, vColour);
			System.out.print(ans + " ");
		}
	}
 
	public static int findAncestor(int p, int vColour) {
 
		if (p != -1) {
			int ps = parent[p];
			if (colour[ps - 1] == vColour) {
				return ps;
			} else {
				return findAncestor( ps - 2, vColour);
			}
 
		} else {
 
			return -1;
		}
 
	}
	
}
