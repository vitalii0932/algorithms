import java.util.HashMap;

public class LinearSearch {

    public static void main(String[] args) {
        int[] sequence = new int[] { -2, 0, 14, 5, 7, -9, 11, 2, 5 };
        HashMap<Integer, Boolean> cases = new HashMap<>();
        cases.put(14, true);
        cases.put(-6, false);

        for (var element : cases.keySet()) {
            boolean expectedResult = cases.get(element);
            int algorithmResult = linearSearch(sequence, element);
            boolean isFound = algorithmResult != -1;

            if (isFound != expectedResult) {
                System.out.printf("Error in case: %d, expected: %b\n", element, expectedResult);
            } else {
                System.out.printf("Element: %d in position %d\n", element, algorithmResult);
            }
        }
    }

    public static int linearSearch(int[] sequence, int element) {
        for (int i = 0; i < sequence.length; i++) {
            if (sequence[i] == element) {
                return i;
            }
        }
        return -1;
    }
}