import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class partB {
    public static List<int[]> generateCombinations(int[] possibleValues, int length) {
        int totalCombinations = (int) Math.pow(possibleValues.length, length); // 4^6 = 4096
        List<int[]> combinations = new ArrayList<>(totalCombinations);

        for (int i = 0; i < totalCombinations; i++) {
            int[] combination = new int[length];
            int temp = i;
            for (int j = 0; j < length; j++) {
                combination[j] = possibleValues[temp % possibleValues.length];
                temp /= possibleValues.length;
            }
            combinations.add(combination);
        }

        return combinations;
    }

    public static int[] findSuitableDieB(int[] dieA) {
        int[] dieB;
        boolean isValid;
        for (int b1 = 1; b1 <= 11; b1++) {
            for (int b2 = 1; b2 <= 11; b2++) {
                for (int b3 = 1; b3 <= 11; b3++) {
                    for (int b4 = 1; b4 <= 11; b4++) {
                        for (int b5 = 1; b5 <= 11; b5++) {
                            for (int b6 = 1; b6 <= 11; b6++) {
                                dieB = new int[]{b1, b2, b3, b4, b5, b6}; // 11c5 combinations
                                isValid = checkSumProbabilities(dieA, dieB);
                                if (isValid) {
                                    return dieB;
                                }
                            }
                        }
                    }
                }
            }
        }

        return null;
    }
    public static boolean checkSumProbabilities(int[] dieA, int[] dieB) {
        int[] sumCounts = new int[100];
        for (int a : dieA) {
            for (int b : dieB) {
                sumCounts[a + b]++;
            }
        }
        int[] originalSumValues = {0, 0, 1, 2, 3, 4, 5, 6, 5, 4, 3, 2, 1};
        for (int i = 2; i <= 12; i++) {
            if (sumCounts[i] != originalSumValues[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] possibleValuesForA = {1, 2, 3 , 4}; // Constraints for Die A
        List<int[]> configurationsForA = generateCombinations(possibleValuesForA, 6);
        for (int[] dieA : configurationsForA) {
            int[] dieB = findSuitableDieB(dieA);
            if (dieB != null) {
                System.out.println("Valid configuration found:");
                System.out.println("New Die A: " + Arrays.toString(dieA));
                System.out.println("New Die B: " + Arrays.toString(dieB));
                return;
            }
        }
        System.out.println("No valid configuration found.");
    }

}
