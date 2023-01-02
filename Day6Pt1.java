import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

public class Day6Pt1 {
    public static void main(String[] args) throws FileNotFoundException {
        File inputFile = new File("inputDaySix.txt");
        Scanner input = new Scanner(inputFile);
        String line = input.nextLine();
        System.out.println(findPacketStart(line));
        input.close();
    }

    public static int findPacketStart(String input) {
        for (int i = 0; i < input.length() - 4; i++) {
            HashSet<String> chars = new HashSet<String>();
            String char1 = input.substring(i, i + 1);
            chars.add(char1);
            String char2 = input.substring(i + 1, i + 2);
            if (chars.contains(char2)) {
                i++;
                continue;
            } else {
                chars.add(char2);
            }
            String char3 = input.substring(i + 2, i + 3);
            if (chars.contains(char3)) {
                i += 2;
                continue;
            } else {
                chars.add(char3);
            }
            String char4 = input.substring(i + 3, i + 4);
            if (chars.contains(char4)) {
                i += 3;
                continue;
            } else {
                return i + 4;
            }
        }

        return -1;
    }
}
