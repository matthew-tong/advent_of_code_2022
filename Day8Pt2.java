import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day8Pt2 {
    public static void main(String[] args) throws FileNotFoundException {
        Integer[][] treeData = storeInput();
        int scenicScore = 0;
        for (int row = 0; row < treeData.length; row++) {
            for (int col = 0; col < treeData[row].length; col++) {
                int scenicScoreRight = 0;
                int scenicScoreLeft = 0;
                int scenicScoreTop = 0;
                int scenicScoreBottom = 0;

                for (int i = col + 1; i < treeData[row].length; i++) {
                    if (treeData[row][col] <= treeData[row][i]) {
                        scenicScoreRight = i - col;
                        break;
                    } else {
                        scenicScoreRight = treeData[row].length - col - 1;
                    }
                }

                for (int i = col - 1; i >= 0; i--) {
                    if (treeData[row][col] <= treeData[row][i]) {
                        scenicScoreLeft = col - i;
                        break;
                    } else {
                        scenicScoreLeft = col;
                    }
                }

                for (int i = row + 1; i < treeData.length; i++) {
                    if (treeData[row][col] <= treeData[i][col]) {
                        scenicScoreBottom = i - row;
                        break;
                    } else {
                        scenicScoreBottom = treeData.length - row - 1;
                    }
                }

                for (int i = row - 1; i >= 0; i--) {
                    if (treeData[row][col] <= treeData[i][col]) {
                        scenicScoreTop = row - i;
                        break;
                    } else {
                        scenicScoreTop = row;
                    }
                }

                int subScenicScore = scenicScoreTop * scenicScoreBottom * scenicScoreRight * scenicScoreLeft;
                System.out.println(
                        scenicScoreTop + " " + scenicScoreBottom + " " + scenicScoreRight + " " + scenicScoreLeft);
                if (subScenicScore > scenicScore) {
                    scenicScore = subScenicScore;
                    System.out.println(scenicScoreTop * scenicScoreBottom * scenicScoreRight * scenicScoreLeft);

                }

            }
        }
        System.out.println(scenicScore);

    }

    public static Integer[][] storeInput() throws FileNotFoundException {
        File inputFile = new File("inputDayEight.txt");
        Scanner input = new Scanner(inputFile);
        Integer[][] treeHeights = new Integer[99][99];
        int row = 0;
        while (input.hasNextLine()) {
            String[] line = input.nextLine().split("");
            // System.out.println(line[0]);
            for (int i = 0; i < line.length; i++) {
                treeHeights[row][i] = Integer.parseInt(line[i]);
            }

            row++;
        }

        input.close();
        return treeHeights;

    }
}
