package homework6;

/**
 * Created by Ootka on 08-Nov-16.
 */

//Дано 3 массива чисел. С помощью 1-2-х циклов найти
//        сумму элементов во всех массивах.
public class SumOfThreeArrays {
    public static void main(String[] args) {
        int[] arr1 = {1, 1, 1, 5, -1, 1, 10, 1};
        int[] arr2 = {1, 1, 1, 1, 2, 10, 10};
        int[] arr3 = {1, 1, 1, 10, 1, 1, 1, 1};

        System.out.println(sumOfArrays(arr1, arr2, arr3));
    }

    public static int sumOfArrays(int[] arr1, int[] arr2, int[] arr3){
        int sum = 0;
        int[] biggestArray;
        int[] otherArray1;
        int[] otherArray2;
        if (arr1.length >= arr2.length && arr1.length >= arr3.length){
            biggestArray = arr1;
            otherArray1 = arr2;
            otherArray2 = arr3;
        } else if (arr2.length >= arr1.length && arr2.length >= arr3.length){
            biggestArray = arr2;
            otherArray1 = arr1;
            otherArray2 = arr3;
        } else {
            biggestArray = arr3;
            otherArray1 = arr1;
            otherArray2 = arr2;
        }

        for (int i = 0; i < biggestArray.length; i++) {
            sum += biggestArray[i];
            if (i >= otherArray1.length){
                sum += 0;
            } else {
                sum += otherArray1[i];
            }
            if (i >= otherArray2.length) {
                sum += 0;
            } else {
                sum += otherArray2[i];
            }
        }
        return sum;
    }
}
