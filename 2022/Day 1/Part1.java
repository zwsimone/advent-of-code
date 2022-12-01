import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Part1
 */
public class Part1 {

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
            // Find the elf with the most calories
            int maxCalorie = findMaxCaloriesFromElves(elves);
            System.out.println("The Elf carrying the most calories has " + maxCalorie + " calories.");
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            e.printStackTrace();
        }
    }

    private static int findMaxCaloriesFromElves(List<Integer> elves) {
        int max = 0;
        for (int elf : elves) {
            if (elf > max) {
                max = elf;
            }
        }
        return max;
    }
}