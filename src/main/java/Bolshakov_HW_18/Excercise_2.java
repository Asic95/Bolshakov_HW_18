package Bolshakov_HW_18;

import java.util.ArrayList;
import java.util.List;


public class Excercise_2 {
    public static void main(String[] args) {

        int myArraySize = 10;
        List<Integer> myArray = new ArrayList<>();
        int startInt = 1;
        int endInt = 20;

        System.out.println("\n");
        System.out.print("Згенеровані числа: ");
        for (int k = 0; k < myArraySize; k++) {
            myArray.add((int) (startInt + Math.random() * endInt));
        }

        System.out.print(myArray);
        System.out.println();

        System.out.print("Кількість парних чисел: ");
        System.out.print(arrayCounter(myArray));

    }

    public static Integer arrayCounter(List<Integer> myArray) {
        List<Integer> filteredNumbers = myArray.stream().filter(k -> k % 2 == 0).toList();
        return filteredNumbers.size();
    }


}
