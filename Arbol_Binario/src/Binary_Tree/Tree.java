package Binary_Tree;

/**
 * 
 * @author Danilo Castilla
 * @date 10/03/1018
 * @version 1.0
 * @description: Implement the concept of linked lists
 * 
 */

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Tree {//Class List
	
	public Node_Tree root = null; //Empty list
	
	public boolean isEmpty() {//Method Check if empty
		
		return root == null ? true : false;
		
	}//end method
	
	public void insert(int value){//Method insert at begin of the list
		
		if(isEmpty()) {
			
			Node_Tree newNode = new Node_Tree(value);
			root = newNode;
			
		}else {
			
			Node_Tree temp = root;
			Node_Tree parent = root;
			
			while(temp != null) {
				
				parent = temp;
				
				if(temp.Value > value) {
					
					temp = temp.left;
					
				}else{
					
					temp = temp.right;
				}
				
			}
			
			Node_Tree newNode = new Node_Tree(value);
			
			if(parent.Value < value)
				parent.right = newNode;
			else 
				parent.left = newNode;
		}
		
	}//end method
	
	public Node_Tree Search(int Value) {//Binary search
		
		Node_Tree temp = root;
		
		while(temp != null) {
			
			if(temp.Value == Value) {
				break;
			}
			
			if(temp.Value > Value) {
				
				temp = temp.left;
				
			}else{
				
				temp = temp.right;
			}
			
		}
		
		return temp;
	}
	
	public void printTree(Node_Tree node) throws IOException {//Print the tree
		
		if(node!=null) {
			System.out.println(node.toString());
			printTree(node.left);
			System.out.println("-");
			printTree(node.right);
		}
	}
	
	public void inOrder(Node_Tree root) {
		
		if(root != null) {
			
			inOrder(root.left);
			System.out.println(root.toString() + " ");
			inOrder(root.right);
		}
	}
	
	public void postOrder(Node_Tree root) {
		
		if(root != null) {
			
			postOrder(root.left);
			postOrder(root.right);
			System.out.println(root.toString() + " ");
			
		}
		
	}
	
	public void preOrder(Node_Tree root) {
		
		if(root != null) {
			
			System.out.println(root.toString() + " ");
			preOrder(root.left);
			preOrder(root.right);
			
		}
		
	}
	
	public boolean isLeaf(Node_Tree node) {//Hoja Unica
		return (node.left == null && node.right == null) ? true : false;
	}
	
	public boolean oneChild(Node_Tree node) {//Hijo unico
		return (node.left != null && node.right != null) ? false : true;
	}
	
	public Node_Tree getNodeReplace(Node_Tree node) {//Nodo a reemplazar en la eliminacion
		
		Node_Tree replaceParent = node;
		Node_Tree replace = node;
		Node_Tree temp = node.right;
		
		while(temp!=null) {
			
			replaceParent = replace;
			replace = temp;
			temp = temp.left;
			
		}
		
		if(replace != node.right) {
			
			replaceParent.left = replace.right;
			replace.right = node.right;
			
		}
			
		System.out.println("El nodo Reemplazo es " + replace);
		return replace;
		
	}
	//delete Node
	public void delete(int value) {
		
		Node_Tree temp = root;
		Node_Tree parent = root;
		
		while(temp != null) {
			
			if(temp.Value == value) {
				break;
			}
			
			parent = temp;
			
			if(value<temp.Value) {
				
				temp = temp.left;
				
			}else{
				
				temp = temp.right;
			}
			
		}
		
		if(temp==null) {
			System.out.println("No existe el nodo");
			return;
		}
		
		if(isLeaf(temp)) {
			
			temp = null;
			if(value < parent.Value)
				parent.left = null;
			else 
				parent.right = null;
			
			}else{
				
				if(oneChild(temp)){
					
					if( temp.left != null) {
						
						if(value < parent.Value)
							parent.left = temp.left;
						else
							parent.right = temp.left;
						
					}else {
						
						if (value < parent.Value)
							parent.left = temp.right;
						else 
							parent.right = temp .right;
					}

				}else{
					
					Node_Tree Replace = getNodeReplace(temp);
					
					if(temp == root) {
						root = Replace;
					} else if(temp.Value < parent.Value){
						parent.left = Replace;
					}else {
						parent.right = Replace;
					}
					
					Replace.left = temp.left;
				}
					
			temp = null;
			
		}
		
	}
	
	public static void main(String[] args) throws IOException{//Main method
		
		Tree tree = new Tree();//creation object
		
		tree.insert(50);
		tree.insert(40);
		tree.insert(60);
		tree.insert(35);
		tree.insert(45);
		tree.insert(55);
		tree.insert(65);
		tree.insert(25);
		tree.insert(36);
		tree.insert(41);
		tree.insert(47);
		tree.insert(52);
		tree.insert(57);
		tree.insert(41);
		tree.insert(62);
		tree.insert(70);
		
		System.out.println("\ninOrder");
		tree.inOrder(tree.root);
		
		System.out.println("\npreOrder");
		tree.preOrder(tree.root);
		
		System.out.println("\nposOrder");
		tree.postOrder(tree.root);
		
		System.out.println("---------");
		
		tree.printTree(tree.root);
		
		//tree.delete(35);
		//tree.delete(45);
		//tree.inOrder(tree.root);
		
	}//end main method
	
}//end class