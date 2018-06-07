package Exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Scanner;

/**
 * @author Danilo Castilla
 */

public class Mirror_Image {

	Mirror_Image left;
	Mirror_Image right;
	int Value;
	static Mirror_Image root = null;
	Mirror_Image temp = root;
	static Mirror_Image parent = null;
	
	public Mirror_Image() {};
	
	public Mirror_Image(int valor) {
		this.Value = valor;
	}
	
	public void preOrder(Mirror_Image root) {
		
		if(root != null) {
			
			System.out.println(root.toString() + " ");
			preOrder(root.left);
			preOrder(root.right);
			
		}
	}
	
	public String toString() {
		return "Valor: " + Value;
	}
	
	public boolean isEmpty() {//Method Check if empty
		
		return root == null ? true : false;
		
	}//end method
	
	public static void insert(Mirror_Image root, int search , int value , String P) {
		
		if(root != null) {
			
			parent = root;
			
			if(root.Value != search) {
				
				insert(root.left , search , value , P);
				
				insert(root.right , search , value , P);
				
			}else {
				
				Mirror_Image newNode = new Mirror_Image(value);
				
				if(P.equals("R")) {
					parent.right = newNode;
				}else if (P.equals("L")){
					parent.left = newNode;
				}
			}
		}	
	}
	
	public void printTree(Mirror_Image root) {
		
		if(root != null) {
			
			System.out.println(root.toString() + " ");
			preOrder(root.left);
			preOrder(root.right);
			
		}
		
	}
	
	public static int findMirror(Mirror_Image root, int target) {
		if(root == null) {
            return -1;
        }
        if(root.Value == target){
            return root.Value;
        }
        return findMirrorRecur(target, root.left, root.right);
    }
    
    public static int findMirrorRecur(int target, Mirror_Image left, Mirror_Image right) {
        if(left == null || right == null)
            return -1;
        if(left.Value == target)
            return right.Value;
        if(right.Value == target)
            return left.Value;
        int mirror_val = findMirrorRecur(target, left.left, right.right);
        if(mirror_val != -1)
            return mirror_val;
        return findMirrorRecur(target, left.right, right.left);
    }
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner s = new Scanner(System.in);
		Mirror_Image MI = new Mirror_Image();
		
		Mirror_Image newNode = new Mirror_Image(1);
		MI.root = newNode;
		
		String input = br.readLine();
		String cases[] = input.split(" ");
		
		int N = Integer.parseInt(cases[0]);
		int Q = Integer.parseInt(cases[1]);
		
		for (int i = 0; i < N-1; i++) {
			
			String Line = br.readLine();
			String Action[] = Line.split(" ");
			
			insert(MI.root , Integer.parseInt(Action[0]), Integer.parseInt(Action[1]) , Action[2]);
			
		}
		
		//MI.printTree(MI.root);
		
		int[] Final = new int[Q];
		
		for (int i = 0; i < Q; i++) {
			String Line = br.readLine();
            Final[i] = (findMirror(root, Integer.parseInt(Line)));
		}
		
		for (int i = 0; i < Final.length; i++) {
			System.out.println(Final[i]);
		}	
	}
}