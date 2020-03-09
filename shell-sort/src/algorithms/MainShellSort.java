package algorithms;

import java.util.ArrayList;
import java.util.Scanner;

public class MainShellSort {

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


		for (int gap = sizeOfArray/2; gap > 0; gap /= 2) {
			for (int i = gap; i < sizeOfArray; i++) {

				int temp = input.get(i);

				int j;
				for (j = i; j >= gap && input.get(j) < input.get(j - gap); j=j-gap){

					int element = input.get(j - gap);
					input.set(j, element);

				}

				input.set(j, temp);

			}

		}

		System.out.println(input);
	}
}
