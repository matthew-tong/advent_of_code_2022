import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

public class Day6Pt2 {
    public static void main(String[] args) throws FileNotFoundException {
        File inputFile = new File("inputDaySix.txt");
        Scanner input = new Scanner(inputFile);
        String line = input.nextLine();
        System.out.println(findPacketStart(line));
        input.close();
    }

    public static int findPacketStart(String input) {
        for (int i = 0; i < input.length() - 14; i++) {
            HashSet<String> chars = new HashSet<String>();
            for (int j = 1; j < 15; j++) {
                String charTemp = input.substring(i + j-1, i + j);
                if (chars.contains(charTemp)) {
                    break;
                } else if (j == 14) {
                    return i + 14;
                } else {
                    chars.add(charTemp);
                }
            }

        }

        return -1;
    }
}
