import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day4Pt1 {
    public static void main(String[] args) throws FileNotFoundException {
        File inputFile = new File("inputDayFour.txt");
        Scanner input = new Scanner(inputFile);
        int containsCount = 0;
        while (input.hasNextLine()) {
            String whole = input.nextLine();
            containsCount += checkContains(whole);
        }
        System.out.println(containsCount);
        input.close();
    }

    public static int checkContains(String whole) {
        String part1 = whole.split(",")[0];
        String part2 = whole.split(",")[1];
        int low1 = Integer.parseInt(part1.split("-")[0]);
        int high1 = Integer.parseInt(part1.split("-")[1]);
        int low2 = Integer.parseInt(part2.split("-")[0]);
        int high2 = Integer.parseInt(part2.split("-")[1]);

        if (low1 <= low2 && high1 >= high2) {
            return 1;
        } else if (low2 <= low1 && high2 >= high1) {
            return 1;
        } else {
            return 0;
        }
    }
}