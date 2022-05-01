package AVLTree;

public class TreeAVL {
	// Nó
	private class Node {

		int data;
		Node left;
		Node right;
		int height;
		
		public Node(int data) {
			this.data = data;
			this.height = 1;
		}
	}

	private Node root;

	public void insert(int item) {
		this.root = insert(this.root, item);
	}
	// Inserção
	private Node insert(Node node, int item) {
		
		if (node == null) {
			Node nn = new Node(item);
			return nn;
		}

		if (item > node.data) {
			node.right = insert(node.right, item);
		} else if (item < node.data) {
			node.left = insert(node.left, item);
		}

		node.height = Math.max(height(node.left), height(node.right)) + 1;

		int bf = bf(node);

		// Rotação à esquerda
		if (bf > 1 && item < node.left.data) {
			return rightRotate(node);
		}

		// Rotação à direita
		if (bf < -1 && item > node.right.data) {
			return leftRotate(node);
		}

		// Rotação Esquerda e Direita
		if (bf > 1 && item > node.left.data) {
			node.left = leftRotate(node.left);
			return rightRotate(node);
		}

		// Rotação Direita e Esquerda
		if (bf < -1 && item < node.right.data) {
			node.right = rightRotate(node.right);
			return leftRotate(node);
		}
		return node;

	}
	// Altura
	private int height(Node node) {
		if (node == null) {
			return 0;
		}

		return node.height;
	}
	// Irmãos
	private int bf(Node node) {
		if (node == null) {
			return 0;
		}

		return height(node.left) - height(node.right);
	}
	// Rotação a Direita
	private Node rightRotate(Node c) {

		Node b = c.left;
		Node T3 = b.right;

		// Rotação
		b.right = c;
		c.left = T3;

		//  Atualização
		c.height = Math.max(height(c.left), height(c.right)) + 1;
		b.height = Math.max(height(b.left), height(b.right)) + 1;

		return b;
	}
	// Rotação a Esquerda
	private Node leftRotate(Node c) {

		Node b = c.right;
		Node T2 = b.left;

		// Rotação
		b.left = c;
		c.right = T2;

		// Atualização
		c.height = Math.max(height(c.left), height(c.right)) + 1;
		b.height = Math.max(height(b.left), height(b.right)) + 1;

		return b;
	}

	public void display() {
		display(this.root);
	}
	// Tela
	private void display(Node node) {

		if (node == null) {
			return;
		}

		// Automação
		String str = "";

		//Nó a Esquerda
		if (node.left == null) {
			str += "vazio";
		} else {
			str += node.left.data;
		}
		str += " --> " + node.data + " <-- ";

		//Nó a Direita
		if (node.right == null) {
			str += "vazio";
		} else {
			str += node.right.data;
		}

		System.out.println(str);

		display(node.left);
		display(node.right);

	}

}