import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day1Pt1 {
    public static void main(String[] args) {
        File inputFile = new File("input.txt");
        Scanner input = null;
        try {
            input = new Scanner(inputFile);
            int calories = 0;
            int largestCal = checkCal(calories, calories, input);
            System.out.println(largestCal);

        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } finally {
            if (input != null) {
                input.close();
            }
        }
    }

    public static int checkCal(int largestCal, int calories, Scanner input) {
        while (input.hasNextLine()) {
            String line = input.nextLine();
            while (!line.equals("")) {
                calories += Integer.parseInt(line);

                if (input.hasNextLine()) {
                    line = input.nextLine();
                } else {
                    break;
                }
            }

            if (calories > largestCal) {
                largestCal = calories;
            }
            calories = 0;
        }
        return largestCal;
    }

}
