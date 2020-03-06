package algorithms;

import java.util.ArrayList;
import java.util.Scanner;

public class MainSelectionSort {

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

		int element, nextElement, indexNextElement, lowerValue, indexLowerValue;
		for (int indexElement = 0; indexElement < (sizeOfArray - 1); indexElement++) {

			element = input.get(indexElement);
			lowerValue = element;
			indexLowerValue = indexElement;

			indexNextElement = indexElement + 1;

			while (indexNextElement < sizeOfArray) {

				nextElement = input.get(indexNextElement);

				if (nextElement < lowerValue) {
					lowerValue = nextElement;
					indexLowerValue = indexNextElement;
				}

				indexNextElement++;
			}

			input.set(indexElement, lowerValue);
			input.set(indexLowerValue, element);

		}

		System.out.println(input);
	}
}
