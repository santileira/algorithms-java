package algorithms;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class DepthFirstSearchMain {

	private static int numberOfNodes;
	private static int[][] adjMatrix;
	private static boolean[] visited;

	public static void main(String[] args) {

		numberOfNodes = 5;
		adjMatrix = new int[numberOfNodes][numberOfNodes];
		visited = new boolean[numberOfNodes];

		for (int i = 0; i < numberOfNodes; i++) {

			for (int j = 0; j < numberOfNodes; j++) {
				adjMatrix[i][j] = 0;
			}
		}

		for (int i = 0; i < numberOfNodes; i++) {
			visited[i] = false;
		}

		addEdge(0, 1);
		addEdge(0, 2);
		addEdge(0, 3);
		addEdge(1, 4);
		addEdge(2, 4);
		addEdge(3, 4);

		depthFirstSearch();


	}

	private static void depthFirstSearch() {

		visited[0] = true;

		// Array implementation of Queue
		Stack<Integer> stack = new Stack<>();

		stack.add(0);

		while (!stack.isEmpty()) {

			int element = stack.peek();
			int unvisitedVertex = getAdjUnvisitedVertex(element);


			if (unvisitedVertex == -1) {
				stack.pop();
			} else {
				visited[unvisitedVertex] = true;
				System.out.println("Agrego vertice " + unvisitedVertex);
				stack.add(unvisitedVertex);
			}


		}

	}

	private static int getAdjUnvisitedVertex(int element) {


		for (int i = 0; i < numberOfNodes; i++) {

			if (adjMatrix[element][i] == 1 && !visited[i]) {
				return i;
			}

		}

		return -1;


	}

	private static void addEdge(int nodeFrom, int nodeTo) {
		adjMatrix[nodeFrom][nodeTo] = 1;
		adjMatrix[nodeTo][nodeFrom] = 1;
	}


}
