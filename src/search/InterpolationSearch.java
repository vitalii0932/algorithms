package search;

import java.util.HashMap;

public class InterpolationSearch {
    public static void main(String[] args) {
        int[] sequence = new int[] { -2, 0, 3, 5, 7, 9, 11, 15, 18 };
        HashMap<Integer, Boolean> cases = new HashMap<>();
        cases.put(3, true);
        cases.put(8, false);

        for (var element : cases.keySet()) {
            boolean expectedResult = cases.get(element);
            int algorithmResult = interpolationSearch(sequence, element);
            boolean isFound = algorithmResult != -1;

            if (isFound != expectedResult) {
                System.out.printf("Error in case: %d, expected: %b\n", element, expectedResult);
            } else {
                System.out.printf("Element: %d in position %d\n", element, algorithmResult);
            }
        }
    }

    public static int interpolationSearch(int[] sequence, int element) {
        int leftIndex = 0;
        int rightIndex = sequence.length - 1;
        int leftElement = sequence[leftIndex];
        int rightElement = sequence[rightIndex];

        while (leftElement < element && element < rightElement) {
            int index = (element - leftElement) * (leftIndex - rightIndex) / (leftElement - rightElement) + leftIndex;
            
            if (sequence[index] == element) {
                return index;
            } else if (sequence[index] < element) {
                leftIndex = index + 1;
            } else {
                rightElement = index - 1;
            }

            leftElement = sequence[leftIndex];
            rightElement = sequence[rightIndex];
        }

        return -1;
    }
}
