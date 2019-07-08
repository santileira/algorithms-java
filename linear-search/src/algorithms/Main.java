package algorithms;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int sizeOfArray = input.nextInt();
        int elementSearched = input.nextInt();

        int result = -1;

        ArrayList<Integer> array = new ArrayList<Integer>();
        int element;

        // generates array
        for (int i = 0; i < sizeOfArray; i++) {
            element = input.nextInt();
            array.add(element);
        }

        // find the last occurrence of integer
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) == elementSearched) {
                result = i + 1;
            }
        }

        System.out.println(result);
    }
}
