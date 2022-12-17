import java.io.File;
import java.util.Scanner;
import JavaHelpers.FileHandler;

public class DayOne2021 {
    public static void main(String[] args) {
        int[] depthArr = FileHandler.getIntArray("./2021/Day 1/input.txt");
        
        // Part 1
        int part1 = getNumberOfMeasurements(depthArr);
        System.out.println("Number of measurements that are larger than the previous measurement: " + part1);

        // Part 2
        int part2 = getNumberOfSums(depthArr);
        System.out.println("Number of sums that are larger than the previous sum: " + part2);
    }

    public static int getNumberOfMeasurements(int[] inputs) {
        int currentDepth = inputs[0];
        int increasedCounter = 0;
        for (int i = 1; i < inputs.length; i++) {
            int nextDepth = inputs[i];
            if (nextDepth > currentDepth) {
                increasedCounter++;
            }
            currentDepth = nextDepth;
        }
        return increasedCounter;
    }

    public static int getNumberOfSums(int[] inputs) {
        int currentDepth = sumOfThree(inputs, 0);
        int increasedCounter = 0;
        for (int i = 1; i < inputs.length; i++) {
            if (i+2 < inputs.length) {
                int nextDepth = sumOfThree(inputs, i);
                if (nextDepth > currentDepth) {
                    increasedCounter++;
                }
                currentDepth = nextDepth;
            } else {
                break;
            }
        }
        return increasedCounter;
    }

    public static int sumOfThree(int[] arr, int index) {
        return arr[index] + arr[index+1] + arr[index+2];
    }
}
