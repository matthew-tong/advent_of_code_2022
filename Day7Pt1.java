import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class Day7Pt1 {
    public static void main(String[] args) throws FileNotFoundException {

        File inputFile = new File("inputDaySeven.txt");
        Scanner input = new Scanner(inputFile);
        int totalSize = 0;

        Stack<String> stack = new Stack<String>();
        while (input.hasNextLine()) {
            String line = input.nextLine();
            char firstChar = line.toCharArray()[0];
            if (line.startsWith("$ cd ..")) {
                String item = "0";
                int subSum = 0;
                while (!item.equals("cd")) {
                    subSum += Integer.parseInt(item);
                    item = stack.pop();
                }

                Integer subSumInt = subSum;
                if (subSum <= 100000) {
                    totalSize += subSum;
                }
                stack.push(subSumInt.toString());
            } else if (line.startsWith("$ cd")) {
                stack.push("cd");
            } else if (Character.isDigit(firstChar)) {
                stack.push(line.split(" ")[0]);
            }
        }
        System.out.println(totalSize);

        int tempSum = 0;
        while (!stack.empty()) {
            String item = stack.pop();
            if (!item.equals("cd")) {
                tempSum += Integer.parseInt(item);
            } else {
                Integer tempSumInt = tempSum;
                if (tempSum <= 100000) {
                    totalSize += tempSum;
                }
                stack.push(tempSumInt.toString());
                tempSum = 0;
            }
        }

        System.out.println(totalSize);
        input.close();
    }
}
