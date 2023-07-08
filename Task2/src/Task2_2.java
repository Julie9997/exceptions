public class Task2_2 {
    public static void main(String[] args) {
        int[] intArray = { 1, 3, 7, 2, 55};

        try {
            int d = 0;
            double catchedRes1 = intArray[8] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
        } catch (ArithmeticException e) {
            System.out.println("Arithmetic exception " + e);
        } catch (NullPointerException e) {
            System.out.println("The element is null " + e);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Index is out of bounds " + e);
        }
    }
}
