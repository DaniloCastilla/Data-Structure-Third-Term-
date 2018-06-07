package AVL_Tree;
/**
 * @author Danilo Castilla
 */
public class ArbolAVL {

	private NodoArbolAVL root;
	
	public ArbolAVL() {
		root = null;
	}
	
	//Search Node
	public NodoArbolAVL Search (int dato , NodoArbolAVL r) {
		
		if(root == null) {
			return null;
		}else if(r.valor == dato) {
			return r;
		}else if(r.valor < dato) {
			return Search(dato, r.right);
		}else {
			return Search(dato, r.left);
		}
		
	}
	
	//Obtener Factor de Equilibrio
	
	public int getFE (NodoArbolAVL x) {
		
		if(x==null) {
			return -1;
		}else {
			return x.fe;
		}
		
	}
	
	//Rotacion Simple Izquierda
	
	public NodoArbolAVL leftRotation(NodoArbolAVL C) {
		
		NodoArbolAVL temp = C.left;
		C.left = temp.right;
		temp.right = C;
		
		C.fe = Math.max(getFE(C.left), getFE(C.right))+1;
		temp.fe = Math.max(getFE(temp.left), getFE(temp.right))+1;
		
		return temp;
		
	}
	
	//Rotacion Simple Derecha
	
	public NodoArbolAVL rightRotation(NodoArbolAVL C) {

		NodoArbolAVL temp = C.right;
		C.right = temp.left;
		temp.left = C;
		
		C.fe = Math.max(getFE(C.left), getFE(C.right))+1;
		temp.fe = Math.max(getFE(temp.left), getFE(temp.right))+1;
		
		return temp;
		
	}
	
	//Rotacion Doble a la Derecha
	
	public NodoArbolAVL doubleRotationLeft(NodoArbolAVL C) {
		
		NodoArbolAVL temp;
		C.left = rightRotation(C.left);
		temp = leftRotation(C);
		return temp;
		
	}
	
	//Rotacion Doble a la izqierda
	
	public NodoArbolAVL doubleRotationRight(NodoArbolAVL C) {
		
		NodoArbolAVL temp;
		C.right = leftRotation(C.right);
		temp = rightRotation(C);
		return temp;
		
	}
	
	//Metodo Insertar AVL
	
	public NodoArbolAVL insertAVL(NodoArbolAVL newAVL , NodoArbolAVL subTree) {
		
		NodoArbolAVL nuevoPadre = subTree;
		if(newAVL.valor < subTree.valor) {
			if(subTree.left == null) {
				subTree.left = newAVL;
			}else {
				subTree.left = insertAVL(newAVL, subTree.left);
				if((getFE(subTree.left) - getFE(subTree.right)) == 2) {
					
					if(newAVL.valor < subTree.left.valor) {
						nuevoPadre = leftRotation(subTree);
					}else {
						nuevoPadre = doubleRotationLeft(subTree);
					}
					
				}
			}
		}else if(newAVL.valor > subTree.valor) {
			
			if(subTree.right == null) {
				subTree.right = newAVL;
			}else {
				subTree.right = insertAVL(newAVL, subTree.right);
				if((getFE(subTree.right) - getFE(subTree.left)) == 2) {
					
					if(newAVL.valor > subTree.right.valor) {
						nuevoPadre = rightRotation(subTree);
					}else {
						nuevoPadre = doubleRotationRight(subTree);
					}
					
				}
			}
			
		}else {
			System.out.println("Nodo Duplicado");
		}
		
		//Actualizar Altura
		if((subTree.left == null) && (subTree.right != null)) {
			
			subTree.fe = subTree.right.fe + 1;
			
		}else if((subTree.right == null) && (subTree.left != null)) {
			
			subTree.fe = subTree.left.fe + 1;
			
		}else {
			
			subTree.fe = Math.max(getFE(subTree.left), getFE(subTree.right)) + 1;
			
		}
		return nuevoPadre;
	}
	
	//Metodo Insertar
	
	public void insertar(int Valor) {
		NodoArbolAVL nuevo = new NodoArbolAVL(Valor);
		if(root == null) {
			root = nuevo;
		}else {
			root = insertAVL(nuevo, root);
		}	
	}
	
	//Recorrido inOrder
	
	public void inOrder(NodoArbolAVL r) {
		
		if(r != null) {
			
			inOrder(r.left);
			System.out.println(r.toString() + " ");
			inOrder(r.right);
		}
	}
	//Recorrido in postOrder
	public void postOrder(NodoArbolAVL r) {
		
		if(r != null) {
			
			postOrder(r.left);
			postOrder(r.right);
			System.out.println(r.toString() + " ");
			
		}
		
	}
	//Recorrido in preORder
	public void preOrder(NodoArbolAVL r) {
		
		if(r != null) {
			
			System.out.println(r.toString() + " ");
			preOrder(r.left);
			preOrder(r.right);
			
		}
		
	}
	
	public static void main(String[] args) {
	
		ArbolAVL AVL = new ArbolAVL();
		//Insert
		AVL.insertar(10);
		AVL.insertar(5);
		AVL.insertar(13);
		AVL.insertar(1);
		AVL.insertar(6);
		AVL.insertar(17);
		AVL.insertar(16);
		AVL.preOrder(AVL.root);
	}
}