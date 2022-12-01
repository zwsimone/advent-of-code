package JavaHelpers;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FileHandler {
    // public static <T> List<T> getList(String path, Class<T> type) {
    //     try {
    //         File input = new File(path);
    //         Scanner inputReader = new Scanner(input);
    //         List<T> list = new ArrayList<T>();
    //         while (inputReader.hasNext()) {
    //             list.add(inputReader.nextLine());
    //         }
    //         inputReader.close();
    //         return list;
    //     } catch (Exception e) {
    //         System.out.println("File not found.");
    //         e.printStackTrace();
    //     }
    //     return null;
    // }
    public static List<Integer> getIntegerList(String path) {
        try {
            File input = new File(path);
            Scanner inputReader = new Scanner(input);
            List<Integer> list = new ArrayList<Integer>();
            while (inputReader.hasNext()) {
                list.add(Integer.parseInt(inputReader.nextLine()));
            }
            inputReader.close();
            return list;
        } catch (Exception e) {
            System.out.println("File not found.");
            e.printStackTrace();
        }
        return null;
    }

    public static int[] getIntArray(String path) {
        List<Integer> list = getIntegerList(path);
        return list.stream().mapToInt((Integer input) -> input.intValue()).toArray();
    }

    // public static double[] getDoubleArray(String path) {
    //     List<Double> list = getList(path, Double.class);
    //     return list.stream().mapToDouble((Double input) -> input.doubleValue()).toArray();
    // }

    // public static String[] getStringArray(String path) {
    //     List<String> list = getList(path, String.class);
    //     return list.stream().map(input -> String.valueOf(input)).collect(Collectors.joining(", ")).split(", ");
    // }
}
