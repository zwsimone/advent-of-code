package DayEight2022;

import java.util.Arrays;
import java.util.List;

import JavaHelpers.FileHandler;

public class DayEight2022 {
    public static void main(String[] args) {
        List<String> input = FileHandler.getStringList("./Java/DayEight2022/input");

        int[][] grid = new int[input.get(0).length()][input.size()];
        for (int row = 0; row < input.size(); row++) {
            String line = input.get(row);
            for (int col = 0; col < line.length(); col++) {
                grid[row][col] = line.charAt(col) - 48;
            }
        }

        int visibleTrees = 2 * (grid.length) + 2 * (grid[0].length - 2);
        for (int row = 1; row < grid.length - 1; row++) {
            for (int col = 1; col < grid[row].length - 1; col++) {
                int tree = grid[row][col];

                int[] rowTrees = getRowOfTrees(grid, row);
                int[] colTrees = getColumnOfTrees(grid, col);

                int[] leftTrees = Arrays.copyOfRange(rowTrees, 0, col);
                int[] rightTrees = Arrays.copyOfRange(rowTrees, col + 1, rowTrees.length);
                int[] topTrees = Arrays.copyOfRange(colTrees, 0, row);
                int[] bottomTrees = Arrays.copyOfRange(colTrees, row + 1, colTrees.length);

                if (tree > findMax(leftTrees) || tree > findMax(topTrees) || tree > findMax(rightTrees)
                        || tree > findMax(bottomTrees)) {
                    visibleTrees++;
                }
            }
        }

        System.out.println("Number of visible trees is " + visibleTrees);

        int maxScenicScore = 0;
        for (int row = 1; row < grid.length - 1; row++) {
            for (int col = 1; col < grid[row].length - 1; col++) {
                int[] rowTrees = getRowOfTrees(grid, row);
                int[] colTrees = getColumnOfTrees(grid, col);

                int leftViewableTrees = getNumberOfViewableTrees(col, rowTrees, -1);
                int rightViewableTrees = getNumberOfViewableTrees(col, rowTrees, 1);
                int topViewableTrees = getNumberOfViewableTrees(row, colTrees, -1);
                int bottomViewableTrees = getNumberOfViewableTrees(row, colTrees, 1);

                int score = leftViewableTrees * rightViewableTrees * topViewableTrees * bottomViewableTrees;
                if (score > maxScenicScore) {
                    maxScenicScore = score;
                }
            }
        }

        System.out.println("Max scenic score is " + maxScenicScore);
    }

    public static int[] getRowOfTrees(int[][] trees, int rowIndex) {
        return trees[rowIndex];
    }

    public static int[] getColumnOfTrees(int[][] trees, int columnIndex) {
        int[] column = new int[trees.length];

        for (int i = 0; i < trees.length; i++) {
            column[i] = trees[i][columnIndex];
        }

        return column;
    }

    public static int findMax(int[] arr) {
        int max = arr[0];

        for (int i : arr) {
            if (i > max) {
                max = i;
            }
        }

        return max;
    }

    public static int getNumberOfViewableTrees(int index, int[] trees, int direction) {
        int viewableTrees = 0;

        int maxTrees = 0;
        if (direction == -1) {
            maxTrees = index;
        } else {
            maxTrees = (trees.length - 1) - index;
        }

        int currentIndex = index + direction;
        int counter = 0;
        int tree = trees[index];
        while (counter < maxTrees) {
            if (trees[currentIndex] != 0) {
                viewableTrees++;
            }
            if (trees[currentIndex] >= tree) {
                break;
            }
            counter++;
            currentIndex = currentIndex + direction;
        }

        return viewableTrees;
    }
}