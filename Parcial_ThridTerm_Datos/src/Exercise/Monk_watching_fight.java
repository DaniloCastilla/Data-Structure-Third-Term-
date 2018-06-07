package Exercise;

/**
 * @author Danilo Castilla
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Monk_watching_fight {

	Monk_watching_fight left;
	Monk_watching_fight right;
	int Value , fe;
	static Monk_watching_fight root = null;
	//Monk_watching_fight temp = root;
	static Monk_watching_fight parent = null;
	
	
	
	public Monk_watching_fight() {};
	
	public Monk_watching_fight(int valor) {
		this.Value = valor;
		this.fe = 0;
	}
	
	public String toString() {
		return Value + "";
	}
	
	public boolean isEmpty() {//Method Check if empty
		
		return root == null ? true : false;
		
	}//end method
	
	public void insert(int Value) {
		
		Monk_watching_fight temp = root;
		Monk_watching_fight parent = root;
		
		if(isEmpty()) {
			
			Monk_watching_fight newNode = new Monk_watching_fight(Value);
			root = newNode;
			
		}else {
			
			while(temp != null) {
				
				parent = temp;
				
				if(Value <= temp.Value) {
					
					temp = temp.left;
					
				}else {
					
					temp = temp.right;
					
				}
				
			}
			
			Monk_watching_fight newNode = new Monk_watching_fight(Value);
			if(Value <= parent.Value)
				parent.left = newNode;
			else
				parent.right = newNode;
		}
		
	}
	
	public void preOrder(Monk_watching_fight root) {
		
		if(root != null) {
			
			System.out.println(root.toString() + " ");
			preOrder(root.left);
			preOrder(root.right);
			
		}
	}
	
	public int Altura(Monk_watching_fight root) {
	
		if(root != null) {
			//parent = root;
			return 1 + (maximaAltura(Altura(root.left), Altura(root.right)));
		}else {
			return 0;
		}
	}
	public int maximaAltura(int A1 , int A2) {
		if(A1 > A2) {
			
			return A1;
			
		}else {
			
			return A2;
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Monk_watching_fight MWF = new Monk_watching_fight();
		
		String Nums = br.readLine();
		String Line = br.readLine();
		String Line_F[] = Line.split(" ");
		
		for (int i = 0; i < Integer.parseInt(Nums); i++) {
			
			int A = Integer.parseInt(Line_F[i]);
			MWF.insert(A);
			
		}
		
		int Alt = MWF.Altura(root);
		System.out.println(Alt);
		
	}
	
}