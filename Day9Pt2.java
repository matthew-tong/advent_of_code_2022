import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

public class Day9Pt2 {
    public static void main(String[] args) throws FileNotFoundException {
        File inputFile = new File("inputDayNine.txt");
        Scanner input = new Scanner(inputFile);
        HashSet<String> tailPlaces = new HashSet<>();
        int[][] ropes = { { 0, 0 }, { 0, 0 }, { 0, 0 }, { 0, 0 }, { 0, 0 }, { 0, 0 }, { 0, 0 }, { 0, 0 }, { 0, 0 },
                { 0, 0 } };
        tailPlaces.add(ropes[9][0] + " " + ropes[9][1]);

        while (input.hasNextLine()) {
            String instruction = input.nextLine();
            String direction = instruction.split(" ")[0];
            int unitsMoved = Integer.parseInt(instruction.split(" ")[1]);
            movePoint(ropes, input, tailPlaces, direction, unitsMoved);
        }

        input.close();
        System.out.println(tailPlaces.size());
    }

    private static void movePoint(int[][] knots, Scanner input, HashSet<String> tailPlaces, String direction,int unitsMoved) {
        for (int i = 0; i < unitsMoved; i++) {
            for (int index = 0; index < knots.length - 1; index++) {
                int[] head = knots[index];
                int[] tail = knots[index + 1];

                if(index == 0){
                    moveHead(head, direction);
                }

                moveTail(head, tail);

                if (index == knots.length - 2) {
                    tailPlaces.add(tail[0] + " " + tail[1]);
                }
            }
        }
    }


    private static void moveTail(int[] head, int[] tail) {
        int dx = head[0] - tail[0];
        int dy = head[1] - tail[1];

        if (Math.max(Math.abs(dx), Math.abs(dy)) > 1) {
            tail[0] += dx != 0 ? Math.abs(dx) / dx : 0;
            tail[1] += dy != 0 ? Math.abs(dy) / dy : 0;
        }
    }

    private static void moveHead(int[] head, String direction) {
        switch (direction) {
            case "U":
                head[1] += 1;
                break;
            case "D":
                head[1] -= 1;
                break;
            case "L":
                head[0] -= 1;
                break;
            case "R":
                head[0] += 1;
                break;
            default:
                System.out.println("error");
        }
    }
}
