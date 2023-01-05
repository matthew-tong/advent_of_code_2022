import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day8Pt1 {
    public static void main(String[] args) throws FileNotFoundException {
        Integer[][] treeData = storeInput();
        int showing = 0;
        for (int row = 0; row < treeData.length; row++) {
            for (int col = 0; col < treeData[row].length; col++) {
                boolean visibleFromLeft = true;
                boolean visibleFromRight = true;
                boolean visibleFromTop = true;
                boolean visibleFromBottom = true;

                for(int i = col+1; i < treeData[row].length; i++){
                    if(treeData[row][col] <= treeData[row][i]){
                        visibleFromRight = false;
                        break;
                    }
                }
                
                if(visibleFromRight){
                    showing++;
                    continue;
                }
                
                for(int i = 0; i < col; i++){
                    if(treeData[row][col] <= treeData[row][i]){
                        visibleFromLeft = false;
                        break;
                    }
                }

                if(visibleFromLeft){
                    showing++;
                    continue;
                }
                
                for(int i = row+1; i < treeData.length; i++){
                    if(treeData[row][col] <= treeData[i][col]){
                        visibleFromBottom = false;
                        break;
                    }
                }

                if(visibleFromBottom){
                    showing++;
                    continue;
                }
                
                for(int i = 0; i < row; i++){
                    if(treeData[row][col] <= treeData[i][col]){
                        visibleFromTop = false;
                        break;
                    }
                }

                if(visibleFromTop){
                    showing++;
                }
        }
    }
        System.out.println(showing);

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
