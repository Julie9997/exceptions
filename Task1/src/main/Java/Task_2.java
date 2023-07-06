
import java.util.Random;

public class Task_2 {
    public static void main(String[] args) {
        int[] firstArray = fillArray(10);
        int[] secondArray = fillArray(13);

        int[] divArray = arraysDif(firstArray, secondArray);
    }

    public static int[] arraysDif(int[] firstArray, int[] secondArray) {
        if(firstArray.length != secondArray.length) throw new RuntimeException("длины массивов разные");
        int[] resultArr = new int[firstArray.length];
        for (int i = 0; i < resultArr.length; i++) {
            resultArr[i] = firstArray[i] - secondArray[i];
        }
        return resultArr;
    }

    public static int[] fillArray(int length){
        int[] array = new int[length];
        Random rnd = new Random();
        for (int i = 0; i < length; i++) {
            array[i] = rnd.nextInt(20);
        }
        return array;
    }
}