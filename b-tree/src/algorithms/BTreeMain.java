package algorithms;

import java.util.ArrayList;

public class BTreeMain {

	public static void main(String[] args) {

		BTree tree = new BTree(3);

		tree.insert(10);
		tree.insert(20);
		tree.insert(5);
		tree.insert(6);
		tree.insert(12);
		tree.insert(30);
		tree.insert(7);
		tree.insert(17);

		System.out.println("Traversal of the constructed tree is ");
		tree.traverse();

		int k = 6;
		tree.search(k);

		k = 15;
		tree.search(k);


	}


}

class BTreeNode {

	int[] keys;
	int degree;
	BTreeNode[] childs;
	int n;
	boolean leaf;

	BTreeNode(int degree, boolean leaf) {

		this.keys = new int[2 * degree - 1];
		this.degree = degree;
		this.childs = new BTreeNode[2 * degree];
		this.n = 0;
		this.leaf = leaf;
	}

	public void traverse() {

		int i;
		for (i = 0; i < this.n; i++) {
			if (!this.leaf) {
				this.childs[i].traverse();
			}

			System.out.println(this.keys[i]);
		}

		if (!this.leaf) {
			this.childs[i].traverse();
		}
	}

	public void search(int value) {

		int i = 0;

		while (i < this.n && this.keys[i] < value) {
			i++;
		}

		if (this.keys[i] == value) {
			System.out.println(value);
			return;
		}

		if (this.leaf) {
			System.out.println("No existe el valor");
			return;
		}

		this.childs[i].search(value);

	}

	public void insertNonFull(int value) {


		int i = this.n - 1;
		if (this.leaf) {


			while (i >= 0 && this.keys[i] > value) {
				this.keys[i + 1] = this.keys[i];
				i--;
			}

			this.keys[i + 1] = value;
			this.n++;

		} else {

			while (i >= 0 && this.keys[i] > value) {
				i--;
			}

			if (this.childs[i + 1].n == this.degree * 2 - 1) {
				splitChild(i + 1, this.childs[i + 1]);

				if (this.keys[i + 1] > value) {
					this.childs[i + 1].insertNonFull(value);
				} else {
					this.childs[i + 2].insertNonFull(value);
				}

			} else {
				this.childs[i + 1].insertNonFull(value);
			}


		}

	}

	public void splitChild(int i, BTreeNode child) {

		BTreeNode newNode = new BTreeNode(child.degree, child.leaf);

		newNode.n = child.degree - 1;

		for (int j = 0; j < child.degree - 1; j++) {

			newNode.keys[j] = child.keys[j + child.degree];
			//child.keys.remove(j + degree);
		}

		if (!child.leaf) {

			for (int j = 0; j < child.degree - 1; j++) {

				newNode.childs[j] = child.childs[j + child.degree];

				//child.childs.remove(j + degree);

			}

		}

		child.n = child.degree - 1;

		for (int j = n; j >= i + 1; j--) {
			this.childs[j + 1] = this.childs[j];
		}


		this.childs[i + 1] = newNode;

		for (int j = n - 1; j >= i; j++) {
			this.keys[j + 1] = this.keys[j];
		}

		this.keys[i] = child.keys[child.degree - 1];

		this.n++;
	}
}

class BTree {

	BTreeNode root;
	int degree;

	BTree(int degree) {
		this.degree = degree;
	}

	public void traverse() {
		if (this.root != null) {
			this.root.traverse();
		}
	}

	public void search(int value) {
		if (this.root != null) {
			this.root.search(value);
		}
	}

	public void insert(int value) {
		if (this.root == null) {
			this.root = new BTreeNode(this.degree, true);
			this.root.keys[0] = value;
			this.root.n = 1;
		} else {

			if (this.root.n == 2 * degree - 1) {

				BTreeNode newRoot = new BTreeNode(this.degree, false);

				newRoot.childs[0] = root;

				newRoot.splitChild(0, root);

				int i = 0;

				if (newRoot.keys[0] < value) {
					i++;
				}

				newRoot.childs[i].insertNonFull(value);

				root = newRoot;

			} else {
				this.root.insertNonFull(value);
			}

		}

	}
}
