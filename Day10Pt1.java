import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day10Pt1 {
    public static void main(String[] args) throws FileNotFoundException {
        // File inputFile = new File("inputDay10-test.txt");
        File inputFile = new File("inputDayTen.txt");
        Scanner input = new Scanner(inputFile);
        int cycle = 0;
        int x = 1;
        int signal = 0;
        while(input.hasNextLine()) {
            String operation = input.nextLine();
            int[] data = takeOpp(operation, cycle, x, signal);
            cycle = data[0];
            signal = data[1];
            x = data[2];
        }
        input.close();
        System.out.println("signal: " + signal + " cycle: " + cycle + " x: " + x);
    }

    private static int[] takeOpp(String operation, int cycle, int x, int signal){
        if(operation.equals("noop")){
            cycle++;
            signal += checkCycle(cycle, x);
        } else {
            cycle++;
            signal += checkCycle(cycle, x);

            cycle++;
            signal += checkCycle(cycle, x);

            x  += Integer.parseInt(operation.split(" ")[1]);
        }
    
        int[] data = {cycle, signal, x};
        return data;
    }

    private static int checkCycle(int cycle, int x){
        if( cycle == 20 || cycle == 60 || cycle == 100 || cycle == 140 || cycle == 180 || cycle == 220){
            System.out.println("cycle: " + cycle + " x: " + x);
            return cycle * x;
        } else {
            return 0;
        }

    }
}
