// Advent of Code Day 1. Determine the totalDistance between two lists and determine how many times each number in the first list appears in the second.
// Successful

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        try {

            File inputFile = new File("src/input.txt");
            Scanner scanner = new Scanner(inputFile);

            int totalDistance = 0;

            ArrayList<Integer> firstList = new ArrayList<>();
            ArrayList<Integer> secondList = new ArrayList<>();

            // Add input to arrays
            while (scanner.hasNextLine()) {
                firstList.add(scanner.nextInt());
                secondList.add(scanner.nextInt());
            }

            // Sort the lists
            Collections.sort(firstList);
            Collections.sort(secondList);

            // Obtain the total Distance
            for (int i = 0; i < firstList.size(); i++) {
                int firstNumber = firstList.get(i);
                int secondNumber = secondList.get(i);

                totalDistance += Math.abs(firstNumber - secondNumber);
            }

            System.out.println("Total Distance: " + totalDistance);


            // Create a map to count occurrences in the second list
            Map<Integer, Integer> countMap = new HashMap<>();
            for (int num : secondList) {
                countMap.put(num, countMap.getOrDefault(num, 0) + 1);
            }

            // Calculate similarity score
            int similarityScore = 0;
            for (int num : firstList) {
                int timesFound = countMap.getOrDefault(num, 0);
                similarityScore += (num * timesFound);
            }

            System.out.println("Similarity Score: " + similarityScore);




        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
        }

    }
}