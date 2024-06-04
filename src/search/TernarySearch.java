package search;

import java.util.HashMap;

public class TernarySearch {
    public static void main(String[] args) {
        int[] sequence = new int[] { -2, 0, 3, 5, 7, 9, 11, 15, 18 };
        HashMap<Integer, Boolean> cases = new HashMap<>();
        cases.put(3, true);
        cases.put(8, false);

        for (var element : cases.keySet()) {
            boolean expectedResult = cases.get(element);
            int algorithmResult = ternarySearch(sequence, element);
            boolean isFound = algorithmResult != -1;

            if (isFound != expectedResult) {
                System.out.printf("Error in case: %d, expected: %b\n", element, expectedResult);
            } else {
                System.out.printf("Element: %d in position %d\n", element, algorithmResult);
            }
        }
    }

    public static int ternarySearch(int[] sequence, int element) {
        int left = 0;
        int right = sequence.length - 1;

        while (right > left) {
            int m1 = left + (right - left) / 3;
            int m2 = right - (right - left) / 3;

            if (sequence[m1] == element) {
                return m1;
            } else if (sequence[m2] == element) {
                return m2;
            } else if (sequence[m1] < element && element < sequence[m2]) {
                left = m1 + 1;
                right = m2 - 1;
            } else if (sequence[m1] > element) {
                right = m1 - 1;
            } else if (sequence[m2] < element) {
                left = m2 + 1;
            }
        }

        return -1;
    }
}
