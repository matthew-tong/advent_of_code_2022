import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day1Pt2 {
    public static void main(String[] args) {
        File inputFile = new File("input.txt");
        Scanner input = null;

        try {
            // step1: declare 3 variables, all initialized to Min
            int first = Integer.MIN_VALUE;
            int second = Integer.MIN_VALUE;
            int third = Integer.MIN_VALUE;
            input = new Scanner(inputFile);

            // step2: read one number from the file
            while (input.hasNextLine()) {
                int calories = getNextCaloriesFromFile(input);

                // step3: compare this number with 3 variables and update them accordingly
                if (calories > third) {
                    if (calories > second) {
                        if (calories > first) {
                            third = second;
                            second = first;
                            first = calories;

                        } else {
                            third = second;
                            second = calories;
                        }
                    } else {
                        third = calories;
                    }
                }
            }

            int total = first + second + third;

            System.out.println(total);

        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } finally {
            if (input != null) {
                input.close();
            }
        }
    }

    public static int getNextCaloriesFromFile(Scanner input) {
        int calories = 0;
        while (input.hasNextLine()) {
            String line = input.nextLine();
            if (line == "") {
                break;
            }
            calories += Integer.parseInt(line);
        }
        return calories;
    }

}