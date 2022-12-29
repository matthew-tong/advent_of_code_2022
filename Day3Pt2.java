import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

public class Day3Pt2 {
    static final String ALPHABETIC = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static void main(String[] args) throws FileNotFoundException {
        File inputFile = new File("inputDayThree.txt");
        Scanner input = new Scanner(inputFile);
        int priority = 0;
        while (input.hasNextLine()) {
            String line1 = input.nextLine();
            String line2 = input.nextLine();
            String line3 = input.nextLine();
            String temp1 = duplicateFinder(line1, line2, line3);
            System.out.print(temp1 + "\t");
            int index = ALPHABETIC.indexOf(temp1);
            if (index > 0) {
                priority += (index + 1);
                System.out.println("temp: \t" +temp1 + " priority: " + priority);
            }
            
        }
        System.out.println(priority);
        input.close();
    }

    public static String duplicateFinder(String part1, String part2, String part3) {
        HashSet<String> set1 = new HashSet<String>();
        HashSet<String> set2 = new HashSet<String>();
        

        for (String sub : part1.split("")) {
            set1.add(sub);
        }

        for (String sub : part2.split("")) {
            set2.add(sub);
        }
        
        for (String sub : part3.split("")) {
            if (set1.contains(sub) && set2.contains(sub)) {
                return sub;

            }
        }

        return "-1";
    }
}
