import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

public class Day3Pt1 {
    static final String ALPHABETIC = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static void main(String[] args) throws FileNotFoundException {
        File inputFile = new File("inputDayThree.txt");
        Scanner input = new Scanner(inputFile);
        int priority = 0;
        while (input.hasNextLine()) {
            String line = input.nextLine();
            int length = line.length();

            String part1 = line.substring(0, length / 2);
            String part2 = line.substring(length / 2, length);

            String temp = duplicateFinder(part1, part2);
            int index = ALPHABETIC.indexOf(temp);
            if (index > 0) {
                priority += (index + 1);
            }
        }
        System.out.println(priority);
        input.close();
    }

    public static String duplicateFinder(String part1, String part2) {
        HashSet<String> set1 = new HashSet<String>();

        for (String sub : part1.split("")) {
            set1.add(sub);
        }

        for (String sub : part2.split("")) {
            if (set1.contains(sub)) { // O(1)
                return sub;
            }
        }

        return "-1";
    }
}
