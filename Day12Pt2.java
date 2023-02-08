import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Day12Pt2 {
    static int hor = 41;
    static int vert = 61;
    static boolean[][] covered = null;
    static String[][] map = new String[hor][vert];
    static int[] horizontal = { 1, 0, -1, 0 };
    static int[] vertical = { 0, 1, 0, -1 };

    public static void main(String[] args) throws FileNotFoundException {
        File inputFile = new File("inputDayTwelve.txt");
        Scanner input = new Scanner(inputFile);

        getMap(input);
        Location start = new Location(0, 0);
        Location end = new Location(0, 0);

        for (int row = 0; row < map.length; row++) {
            for (int col = 0; col < map[row].length; col++) {
                if (map[row][col].equals("E")) {
                    end.x = row;
                    end.y = col;
                    map[row][col] = "z";
                }
            }
        }

        Integer steps = Integer.MAX_VALUE;
        for (int row = 0; row < hor; row++) {
            for (int col = 0; col < vert; col++) {
                if (map[row][col].equals("a")) {
                    start.x = row;
                    start.y = col;
                    covered = new boolean[hor][vert];
                    Integer newSteps = findFinish(start, end);
                    System.out.println("New steps: " + newSteps);
                    if (newSteps < steps && newSteps > 0) {
                        steps = newSteps;
                    }

                }
            }
        }

        System.out.println(steps);

    }

    private static void getMap(Scanner input) {
        int i = 0;
        while (input.hasNextLine()) {
            String line = input.nextLine();
            String[] split = line.split("");
            map[i] = split;
            i++;
        }
        return;
    }

    private static int findFinish(Location start, Location finish) {
        Queue<Location> spots = new LinkedList<Location>();
        spots.add(start);
        int needRemove;
        int steps = 0;
        int y;
        int x;

        covered[start.x][start.y] = true;

        while (!spots.isEmpty()) {
            needRemove = spots.size();
            for (int i = 0; i < needRemove; i++) {
                Location current = spots.poll();

                if (current.isEqual(finish)) {
                    return steps;
                }

                for (int j = 0; j < 4; j++) {
                    x = current.x + horizontal[j];
                    y = current.y + vertical[j];

                    if (x < hor && x >= 0 && y < vert && y >= 0) {

                        if (covered[x][y]) {
                            continue;
                        }

                        Location temp = new Location(x, y);
                        if (current.canClimb(map, temp)) {
                            spots.add(temp);
                            covered[x][y] = true;
                        }
                    }

                }
            }
            steps++;
        }

        return -1;
    }

}
