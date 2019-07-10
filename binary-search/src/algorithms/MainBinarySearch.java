package algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MainBinarySearch {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int sizeOfArray = input.nextInt();

        ArrayList<Integer> array = new ArrayList<Integer>();
        int element;
        // generates array
        for (int i = 0; i < sizeOfArray; i++) {
            element = input.nextInt();
            array.add(element);
        }

        int numberOfQueries = input.nextInt();
        int indexLeft;
        int indexRight;
        int middle;
        int elementSearched;
        int value;

        // sort in ascending order.
        Collections.sort(array);

        while (numberOfQueries != 0) {
            indexLeft = 0;
            indexRight = array.size() - 1;

            elementSearched = input.nextInt();

            while (indexLeft <= indexRight) {
                middle = (indexRight + indexLeft) / 2;

                value = array.get(middle);

                if (elementSearched > value) {
                    indexLeft = middle + 1;
                } else {

                    if (elementSearched < value) {
                        indexRight = middle - 1;
                    } else {
                        System.out.println(middle + 1);
                        numberOfQueries--;
                        break;
                    }

                }
            }
        }

    }


}

