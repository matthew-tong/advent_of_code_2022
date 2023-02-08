import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Day11Pt2 {
    private static final int ROUNDS = 10000;
    private static final int MONKIES = 8;

    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<ArrayList<Integer>> monkeyItems = new ArrayList<>();
        for (int i = 0; i < MONKIES; i++) {
            monkeyItems.add(new ArrayList<Integer>());
        }

        File inputFile = new File("inputDayEleven.txt");
        Scanner input = new Scanner(inputFile);
        int[] touches = {0,0,0,0,0,0,0,0};

        ArrayList<String[]> ops = new ArrayList<>();
        ArrayList<Integer[]> param = new ArrayList<>();
        for (int i = 0; i < MONKIES; i++) {
            getInput(input, monkeyItems, param, ops);
        }

        for (int round = 0; round < ROUNDS; round++) {
            for (int monkey = 0; monkey < MONKIES; monkey++) {
                ArrayList<Integer> items = monkeyItems.get(monkey);
                String[] operation = ops.get(monkey);
                Integer[] parameters = param.get(monkey);
                touches[monkey] += items.size();
                doOperations(items, monkeyItems, operation, parameters);

            }
        }
        ArrayList<Integer> results = new ArrayList<Integer>();
        for (int touch: touches) {
            results.add(touch);
        }
        
        Collections.sort(results);
        Collections.reverse(results);
        
        int result = results.get(0) * results.get(1);

        System.out.println(result);
    }

    private static void doOperations(ArrayList<Integer> items, 
            ArrayList<ArrayList<Integer>> monkeyItems,
            String[] operation, 
            Integer[] parameters) {
        int value;
        int newValue;
        for (Integer item : items) {

            

            if (operation[1].equals("old")) {
                value = item;
            } else {
                value = Integer.parseInt(operation[1]);
            }



            if (operation[0].equals("+")) {
                newValue = item + value;
            } else {
                newValue = item * value;
            }

            newValue/=3;
            if(newValue % parameters[0] == 0){
                monkeyItems.get(parameters[1]).add(newValue);
            } else {
                monkeyItems.get(parameters[2]).add(newValue);
            }
        }

        items.clear();
    }

    public static void getItems(String input, ArrayList<Integer> items) {
        String[] splitItems = input.trim().split("[\\s|,]");
        for (int i = 2; i < splitItems.length; i++) {
            if (!splitItems[i].isEmpty()) {
                items.add(Integer.parseInt(splitItems[i]));
            }
        }
    }

    public static String[] getOp(String input) {
        String[] parts = input.trim().split(" ");
        String operand = parts[parts.length - 2];
        String value = parts[parts.length - 1];
        return new String[] { operand, value };
    }

    public static Integer getDivisible(String input) {
        String[] parts = input.trim().split(" ");
        String divisble = parts[parts.length - 1];
        return Integer.parseInt(divisble);
    }

    public static Integer getMonkeyNum(String input) {
        String[] parts = input.trim().split(" ");
        String monkey = parts[parts.length - 1];
        return Integer.parseInt(monkey);
    }

    public static Integer getCurMonkeyNum(String input) {
        String[] parts = input.trim().split(" ");
        return Integer.parseInt(parts[1].substring(0, 1));
    }

    private static void getInput(Scanner input,
            ArrayList<ArrayList<Integer>> monkeyItems,
            ArrayList<Integer[]> params,
            ArrayList<String[]> ops) {

        String line1 = input.nextLine();
        Integer current = getCurMonkeyNum(line1);
        ArrayList<Integer> items = monkeyItems.get(current);

        String line2 = input.nextLine();
        getItems(line2, items);

        String line3 = input.nextLine();
        String[] operation = getOp(line3);
        ops.add(operation);

        String line4 = input.nextLine();
        Integer divisible = getDivisible(line4);

        String line5 = input.nextLine();
        Integer monkey1 = getMonkeyNum(line5);

        String line6 = input.nextLine();
        Integer monkey2 = getMonkeyNum(line6);

        params.add(new Integer[] { divisible, monkey1, monkey2 });

        input.nextLine();
    }
}
    

