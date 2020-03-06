package algorithms;

import java.util.ArrayList;
import java.util.Scanner;

public class MainInsertionSort {

	public static void main(String[] args) {

		Scanner inputScanner = new Scanner(System.in);
		int sizeOfArray = inputScanner.nextInt();

		ArrayList<Integer> input = new ArrayList<Integer>();


		int inputElement;

		System.out.println("Starting to get input data");

		// generates array
		for (int i = 0; i < sizeOfArray; i++) {
			inputElement = inputScanner.nextInt();
			input.add(inputElement);
		}

		System.out.println("Finish to get input data");


		int valueToInsert, holePosition, element;
		for (int indexElement = 1; indexElement < sizeOfArray; indexElement++) {

			valueToInsert = input.get(indexElement);
			holePosition = indexElement;

			while (holePosition > 0 && valueToInsert > input.get(holePosition - 1)) {
				element = input.get(holePosition - 1);
				input.set(holePosition, element);
				holePosition--;
			}

			input.set(holePosition, valueToInsert);


		}

		System.out.println(input);
	}
}
