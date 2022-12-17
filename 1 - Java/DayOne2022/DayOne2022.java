import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class DayOne2022 {

    public static void main(String[] args) {
        try {
            File input = new File("./2022/Day 1/input.txt");
            Scanner inputReader = new Scanner(input);
            List<Integer> elves = new ArrayList<Integer>();
            int elf = 0;
            // Read input file line by line
            while(inputReader.hasNextLine()) {
                String line = inputReader.nextLine();
                if (!line.isEmpty()) {
                    // Add to total calories of an elf
                    elf += Integer.parseInt(line);
                } else {
                    // Add total calories per elf to list of elves
                    elves.add(elf);
                    elf = 0;
                }
            }
            // Close file scanner
            inputReader.close();

            // Part 1
            // Find the elf with the most calories
            // int maxCalorie = findMaxCaloriesFromElves(elves);
            // System.out.println("The Elf carrying the most calories has " + maxCalorie + " calories.");

            // Part 2
            // Find total calories of top 3 elves
            int maxCalories = findTotalCaloriesOfTopThreeElves(elves);
            System.out.println("The total calories carried by the top three Elves has " + maxCalories + " calories.");
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            e.printStackTrace();
        }
    }

    // Part 1
    private static int findMaxCaloriesFromElves(List<Integer> elves) {
        int max = 0;
        for (int elf : elves) {
            if (elf > max) {
                max = elf;
            }
        }
        return max;
    }
    
    // Part 2
    private static int findTotalCaloriesOfTopThreeElves(List<Integer> elves) {
        Collections.sort(elves, Collections.reverseOrder());
        int totalCaloriesOfTopThreeElves = elves.get(0) + elves.get(1) + elves.get(2);
        return totalCaloriesOfTopThreeElves;
    }
}