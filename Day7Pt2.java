import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Day7Pt2 {
    public static void main(String[] args) throws FileNotFoundException {

        File inputFile = new File("inputDaySeven.txt");
        Scanner input = new Scanner(inputFile);
        int totalSize = 0;
        ArrayList<Integer> candidates = new ArrayList<Integer>();
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

                if (subSum >= 3562874) {
                    candidates.add(subSum);
                }
                stack.push(subSumInt.toString());
            } else if (line.startsWith("$ cd")) {
                stack.push("cd");
            } else if (Character.isDigit(firstChar)) {
                stack.push(line.split(" ")[0]);
            }
        }
        System.out.println(totalSize);

        int subSum = 0;
        while (!stack.empty()) {
            String item = stack.pop();
            if (!item.equals("cd")) {
                subSum += Integer.parseInt(item);
            } else {
                Integer tempSumInt = subSum;
                if (subSum <= 100000) {
                    totalSize += subSum;
                }
                stack.push(tempSumInt.toString());

                if (subSum >= 3562874) {
                    candidates.add(subSum);
                }

                subSum = 0;

            }
        }
        Integer result = candidates.stream().min(Integer::compare).get();
        System.out.println(result);
        input.close();
    }
}
