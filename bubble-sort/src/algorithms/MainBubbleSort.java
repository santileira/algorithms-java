package algorithms;

import java.util.ArrayList;
import java.util.Scanner;

public class MainBubbleSort {

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


		int element, nextElement;
		for (int indexElement = 0; indexElement < sizeOfArray - 1; indexElement++) {


			for (int index = 0; index < sizeOfArray - 1 - indexElement; index++) {

				if (input.get(index) > input.get(index + 1)) {

					element = input.get(index);
					nextElement = input.get(index + 1);
					input.set(index + 1, element);
					input.set(index, nextElement);
				}


			}


		}

		System.out.println(input);
	}
}
