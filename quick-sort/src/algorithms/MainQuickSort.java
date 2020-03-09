package algorithms;

import java.util.ArrayList;
import java.util.Scanner;

public class MainQuickSort {

	public static void main(String[] args) {

		Scanner inputScanner = new Scanner(System.in);
		int sizeOfArray = inputScanner.nextInt();

		ArrayList<Integer> input = new ArrayList<Integer>();

		int inputElement;

		// generates array
		for (int i = 0; i < sizeOfArray; i++) {
			inputElement = inputScanner.nextInt();
			input.add(inputElement);
		}

		quickSort(input, 0, sizeOfArray - 1);

		System.out.println(input);

	}


	private static void quickSort(ArrayList<Integer> input, int leftIndex, int rightIndex) {


		if (leftIndex < rightIndex) {
			int partitionPoint = partition(input, leftIndex, rightIndex);
			quickSort(input, leftIndex, partitionPoint - 1);
			quickSort(input, partitionPoint+1, rightIndex);
		}

	}

	private static int partition(ArrayList<Integer> input, int leftIndex, int rightIndex) {

		int indexOfSmallerElement = leftIndex - 1;
		int pivotElement = input.get(rightIndex);
		int leftElement, smallerElement;

		for (int j = leftIndex; j <= rightIndex - 1; j++) {

			leftElement = input.get(j);

			if (leftElement > pivotElement) {
				indexOfSmallerElement++;
				smallerElement = input.get(indexOfSmallerElement);
				input.set(indexOfSmallerElement, leftElement);
				input.set(j, smallerElement);
			}

		}

		indexOfSmallerElement++;
		smallerElement = input.get(indexOfSmallerElement);
		input.set(indexOfSmallerElement, pivotElement);
		input.set(rightIndex, smallerElement);

		return indexOfSmallerElement;

	}
}
