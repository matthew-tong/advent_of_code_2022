import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Location {
    public int x;
    public int y;

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean isEqual(Location s) {
        if (s.x == this.x && s.y == this.y) {
            return true;
        } else {
            return false;
        }
    }


    public boolean canClimb(String[][] map, Location test) {
        // System.out.println(this.x + " " + this.y);
        int currentHeight = Character.getNumericValue(map[this.x][this.y].charAt(0));
        int testHeight = Character.getNumericValue(map[test.x][test.y].charAt(0));

        if (testHeight - currentHeight > 1) {
            return false;
        }

        return true;
    }

}

public class Day12Pt1 {
    static int hor = 41;
    static int vert = 61;
    static boolean[][] covered = new boolean[hor][vert];
    static String[][] map = new String[hor][vert];
    static int[] horizontal = { 1, 0, -1, 0 };
    static int[] vertical = { 0, 1, 0, -1 };

    public static void main(String[] args) throws FileNotFoundException {
        File inputFile = new File("inputDayTwelve.txt");
        Scanner input = new Scanner(inputFile);
        map = getMap(input);
        for (int i = 0; i < map.length; i++) {
            for (String s : map[i]) {
                System.out.print(s);
            }
            System.out.println();
        }
        Location start = new Location(0, 0);
        Location end = new Location(0, 0);
        for (int row = 0; row < map.length; row++) {
            for (int col = 0; col < map[row].length; col++) {
                if (map[row][col].equals("E")) {
                    end.x = row;
                    end.y = col;
                    map[row][col] = "z";
                } else if (map[row][col].equals("S")) {
                    start.x = row;
                    start.y = col;
                    map[row][col] = "a";
                }
            }
        }

        System.out.println(findFinish(start, end));

    }

    private static String[][] getMap(Scanner input) {
        int i = 0;
        while (input.hasNextLine()) {
            String line = input.nextLine();
            String[] split = line.split("");
            map[i] = split;
            i++;
        }
        return map;
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
