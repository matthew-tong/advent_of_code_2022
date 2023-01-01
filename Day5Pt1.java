import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Day5Pt1 {
    
    public static void main(String[] args) throws FileNotFoundException {
        File inputFile = new File("inputDayFive.txt");
        Scanner input = new Scanner(inputFile);

        ArrayList<ArrayList<String>> columns = new ArrayList<ArrayList<String>>();
        for (int i = 0; i < 9; i++) {
            columns.add(new ArrayList<String>());
        }

        ArrayList<String> col1 = columns.get(0);
        col1.add("N");
        col1.add("H");
        col1.add("S");
        col1.add("J");
        col1.add("F");
        col1.add("W");
        col1.add("T");
        col1.add("D");
        ArrayList<String> col2 = columns.get(1);
        col2.add("G");
        col2.add("B");
        col2.add("N");
        col2.add("T");
        col2.add("Q");
        col2.add("P");
        col2.add("R");
        col2.add("H");
        ArrayList<String> col3 = columns.get(2);
        col3.add("V");
        col3.add("Q");
        col3.add("L");
        ArrayList<String> col4 = columns.get(3);
        col4.add("Q");
        col4.add("R");
        col4.add("W");
        col4.add("S");
        col4.add("B");
        col4.add("N");
        ArrayList<String> col5 = columns.get(4);
        col5.add("B");
        col5.add("M");
        col5.add("V");
        col5.add("T");
        col5.add("F");
        col5.add("D");
        col5.add("N");
        ArrayList<String> col6 = columns.get(5);
        col6.add("R");
        col6.add("T");
        col6.add("H");
        col6.add("V");
        col6.add("B");
        col6.add("D");
        col6.add("M");
        ArrayList<String> col7 = columns.get(6);
        col7.add("J");
        col7.add("Q");
        col7.add("B");
        col7.add("D");
        ArrayList<String> col8 = columns.get(7);
        col8.add("Q");
        col8.add("H");
        col8.add("Z");
        col8.add("R");
        col8.add("V");
        col8.add("J");
        col8.add("N");
        col8.add("D");
        ArrayList<String> col9 = columns.get(8);
        col9.add("S");
        col9.add("M");
        col9.add("H");
        col9.add("N");
        col9.add("B");

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
            colBoxTo.add(colBoxFrom.get(colBoxFrom.size()-1));
            colBoxFrom.remove(colBoxFrom.size() - 1);
        }
    }
}
