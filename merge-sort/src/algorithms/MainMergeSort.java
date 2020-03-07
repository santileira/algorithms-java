package algorithms;

import java.util.ArrayList;
import java.util.Scanner;

public class MainMergeSort {

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

		sort(input, 0, sizeOfArray - 1);

		System.out.println(input);
	}

	private static void sort(ArrayList<Integer> input, int left, int right) {

		if (left < right) {
			int middle = (right + left) / 2;

			sort(input, left, middle);
			sort(input, middle + 1, right);

			merge(input, left, middle, right);
		}
	}


	private static void merge(ArrayList<Integer> input, int left, int middle, int right) {

		int leftSize = middle - left + 1;
		int rightSize = right - middle;

		int leftIndex = 0;
		int rightIndex = 0;

		int leftElement;
		int rightElement;

		ArrayList<Integer> leftArray = new ArrayList<Integer>();
		ArrayList<Integer> rightArray = new ArrayList<Integer>();

		for (int i = 0; i < leftSize; i++) {
			leftArray.add(input.get(left + i));
		}

		for (int i = 0; i < rightSize; i++) {
			rightArray.add(input.get(middle + 1 + i));
		}

		int index = left;

		System.out.println(leftArray);
		System.out.println(rightArray);

		while (leftIndex < leftSize && rightIndex < rightSize) {

			leftElement = leftArray.get(leftIndex);
			rightElement = rightArray.get(rightIndex);

			if (leftElement < rightElement) {
				input.set(index, leftElement);
				leftIndex++;
			} else {
				input.set(index, rightElement);
				rightIndex++;
			}

			index++;

		}

		while (leftIndex < leftSize)
		{

			input.set(index, leftArray.get(leftIndex));
			leftIndex++;
			index++;
		}

		while (rightIndex < rightSize)
		{

			input.set(index, rightArray.get(rightIndex));
			rightIndex++;
			index++;
		}
	}
}


