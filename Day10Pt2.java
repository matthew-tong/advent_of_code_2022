import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day10Pt2 {
    public static void main(String[] args) throws FileNotFoundException {
        // File inputFile = new File("inputDay10-test.txt");
        File inputFile = new File("inputDayTen.txt");
        Scanner input = new Scanner(inputFile);
        int cycle = 0;
        int x = 1;
        System.out.println();
        while(input.hasNextLine()) {
            String operation = input.nextLine();
            int[] data = takeOpp(operation, cycle, x);
            cycle = data[0];
            x = data[1];
        }
        input.close();
        System.out.println();
    }

    private static int[] takeOpp(String operation, int cycle, int spriteCtr){
        if(operation.equals("noop")){
            cycle++;
            printPixel(cycle, spriteCtr);
        } else {
            cycle++;
            printPixel(cycle, spriteCtr);

            cycle++;
            printPixel(cycle, spriteCtr);

            spriteCtr  += Integer.parseInt(operation.split(" ")[1]);
        }
    
        int[] data = {cycle, spriteCtr};
        return data;
    }

    private static void printPixel(int cycle, int spriteCtr){
        int pixel = cycle % 40;
        if( pixel < spriteCtr + 3 && pixel > spriteCtr - 1){
            System.out.print("#");
        } else {
            System.out.print(" ");
        }
        if (pixel == 0) {
            System.out.println();
        }
    }
}
