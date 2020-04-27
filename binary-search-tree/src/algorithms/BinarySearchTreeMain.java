package algorithms;

public class BinarySearchTreeMain {

	class Node {
		int key;
		Node left, right;

		public Node(int item) {
			key = item;
			left = right = null;
		}
	}

	Node root;

	private BinarySearchTreeMain() {
		root = null;
	}

	private void insert(int item) {
		root = insertRec(root, item);
	}

	private Node insertRec(Node root, int item) {

		if (root == null) {
			return new Node(item);
		}

		if (item < root.key) {
			root.left = insertRec(root.left, item);
		} else {
			root.right = insertRec(root.right, item);
		}

		return root;
	}

	private void inOrder() { inOrderRec(root); }

	private void inOrderRec(Node root) {
		if (root != null) {
			inOrderRec(root.left);
			System.out.println(root.key);
			inOrderRec(root.right);
		}
	}

	private void preOrder() { preOrderRec(root);}

	private void preOrderRec(Node root) {
		if (root != null) {
			System.out.println(root.key);
			preOrderRec(root.left);
			preOrderRec(root.right);
		}
	}

	private void postOrder() { postOrderRec(root);}

	private void postOrderRec(Node root) {
		if (root != null) {
			preOrderRec(root.left);
			preOrderRec(root.right);
			System.out.println(root.key);
		}
	}

	private void search(int item) {
		Node result = searchRec(root, item);

	}

	private Node searchRec(Node root, int item) {
		if (root == null || root.key == item) {
			return root;
		}

		if (item < root.key) {
			root = searchRec(root.left, item);
		} else {
			root = searchRec(root.right, item);
		}

		return root;
	}

	private void delete(int item) {
		root = deleteRec(root, item);
	}

	private Node deleteRec(Node root, int item) {
		if (root == null) {
			return root;
		}

		if (item < root.key) {
			root.left = deleteRec(root.left, item);
		} else if (item > root.key) {
			root.right = deleteRec(root.right, item);
		} else {
			if (root.left == null) {
				return root.right;
			} else if (root.right == null) {
				return root.left;
			}

			root.key = minValue(root.right);

			root.right = deleteRec(root.right, root.key);

		}

		return root;
	}

	private int minValue(Node root) {
		int minValue = root.key;
		while (root.left != null)
		{
			minValue = root.left.key;
			root = root.left;
		}
		return minValue;
	}


	// Driver Program to test above functions
	public static void main(String[] args) {
		BinarySearchTreeMain tree = new BinarySearchTreeMain();

		tree.insert(50);
		tree.insert(30);
		tree.insert(20);
		tree.insert(40);
		tree.insert(70);
		tree.insert(60);
		tree.insert(80);


		// print inorder traversal of the BST
		System.out.println("In order");
		tree.inOrder();
		tree.delete(20);
		System.out.println("In order");
		tree.inOrder();
		tree.delete(30);
		System.out.println("In order");
		tree.inOrder();
		tree.delete(50);
		System.out.println("In order");
		tree.inOrder();

		//		System.out.println("Pre order");
//		tree.preOrder();
//		System.out.println("Post order");
//		tree.postOrder();
	}
}
