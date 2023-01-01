import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Stream;

public class Day5Pt2 {
    
    public static void main(String[] args) throws FileNotFoundException {
        File inputFile = new File("inputDayFive.txt");
        Scanner input = new Scanner(inputFile);

        ArrayList<ArrayList<String>> columns = new ArrayList<ArrayList<String>>();
        for (int i = 0; i < 9; i++) {
            columns.add(new ArrayList<String>());
        }

        ArrayList<String> col1 = columns.get(0);
        ArrayList<String> col2 = columns.get(1);
        ArrayList<String> col3 = columns.get(2);
        ArrayList<String> col4 = columns.get(3);
        ArrayList<String> col5 = columns.get(4);
        ArrayList<String> col6 = columns.get(5);
        ArrayList<String> col7 = columns.get(6);
        ArrayList<String> col8 = columns.get(7);
        ArrayList<String> col9 = columns.get(8); 
        String[] col1Strs = {"N", "H", "S", "J", "F", "W", "T", "D"};
        String[] col2Strs = {"G", "B", "N", "T", "Q", "P", "R", "H"};
        String[] col3Strs = {"V", "Q", "L"};
        String[] col4Strs = {"Q", "R", "W", "S", "B", "N"};
        String[] col5Strs = {"B", "M", "V", "T", "F", "D", "N"};
        String[] col6Strs = {"R", "T", "H", "V", "B", "D", "M"};
        String[] col7Strs = {"J", "Q", "B", "D"};
        String[] col8Strs = {"Q", "H", "Z", "R", "V", "J", "N", "D"};
        String[] col9Strs = {"S", "M", "H", "N", "B"};
        Stream.of(col1Strs).forEach(s -> col1.add(s));
        Stream.of(col2Strs).forEach(s -> col2.add(s));
        Stream.of(col3Strs).forEach(s -> col3.add(s));
        Stream.of(col4Strs).forEach(s -> col4.add(s));
        Stream.of(col5Strs).forEach(s -> col5.add(s));
        Stream.of(col6Strs).forEach(s -> col6.add(s));
        Stream.of(col7Strs).forEach(s -> col7.add(s));
        Stream.of(col8Strs).forEach(s -> col8.add(s));
        Stream.of(col9Strs).forEach(s -> col9.add(s));



        columns.forEach(col -> Collections.reverse(col));

        while(input.hasNextLine()){
            String[] parts = input.nextLine().split(" ");
            int boxesToMove = Integer.parseInt(parts[1]);
            int colNum1 = Integer.parseInt(parts[3]);
            int colNum2 = Integer.parseInt(parts[5]); 
            System.out.println("before move: from col: " + colNum1 + "; elements: " + columns.get(colNum1-1));
            System.out.println("before move: to col: " + colNum2 + "; elements: " + columns.get(colNum2-1));
            System.out.println("move " + boxesToMove + " boxes");
            moveBoxes(columns.get(colNum1-1), columns.get(colNum2-1), boxesToMove);
            System.out.println("after move: from col: " + colNum1 + "; elements: " + columns.get(colNum1-1));
            System.out.println("after move: to col: " + colNum2 + "; elements: " + columns.get(colNum2-1));

        }

        StringBuilder sb = new StringBuilder();
        sb.append(col1.get(col1.size()-1))
        .append(col2.get(col2.size()-1))
        .append(col3.get(col3.size()-1))
        .append(col4.get(col4.size()-1))
        .append(col5.get(col5.size()-1))
        .append(col6.get(col6.size()-1))
        .append(col7.get(col7.size()-1))
        .append(col8.get(col8.size()-1))
        .append(col9.get(col9.size()-1));
        System.out.println(sb.toString());
        input.close();
    }

    public static void moveBoxes(ArrayList<String> colBoxFrom, ArrayList<String> colBoxTo, int boxesToMove) {
        for(int i = 0; i < boxesToMove; i++) {
            System.out.println("box size: " + colBoxFrom.size());
            colBoxTo.add(colBoxFrom.get(colBoxFrom.size() - boxesToMove + i));
            colBoxFrom.remove(colBoxFrom.size() - boxesToMove + i);
        }
    }
}
