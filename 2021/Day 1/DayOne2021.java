import java.io.File;
import java.util.Scanner;

public class DayOne2021 {
    public static void main(String[] args) {
        try {
            File input = new File("./2021/Day 1/input.txt");
            Scanner inputReader = new Scanner(input);
            int index = 0;
            int currentDepth = 0;
            int increasedCounter = 0;
            while (inputReader.hasNextLine()) {
                if (index == 0) {
                    currentDepth = Integer.parseInt(inputReader.nextLine());
                } else {
                    int nextDepth = Integer.parseInt(inputReader.nextLine());
                    if (nextDepth > currentDepth) {
                        increasedCounter++;
                    }
                    currentDepth = nextDepth;
                }
                index++;
            }
            inputReader.close();
            System.out.println("Number of measurements that are larger than the previous measurement: " + increasedCounter);
        } catch (Exception e) {
            System.out.println("File not found.");
            e.printStackTrace();
        }
    }
}
