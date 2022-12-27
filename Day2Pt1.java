import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day2Pt1 {
    static final int ROCK = 1;
    static final int PAPER = 2;
    static final int SCISSOR =3;
    static final int DRAW = 3;
    static final int WIN = 6;
    static final int LOSS = 0;
    public static void main(String[] args) throws FileNotFoundException {
        File inputFile = new File("inputDayTwo.txt");
        Scanner input = new Scanner(inputFile);
        int userScore = 0;
        while(input.hasNextLine()) {
            String game = input.nextLine();
            String[] temp = game.split(" ");
            String elf = temp[0];
            String user = temp[1];
            userScore = gameChecker(userScore, elf, user);
        }
        input.close();
        System.out.println(userScore);
    }

    public static int gameChecker(int userScore, String elf, String user) {
        if(elf.equals("A") && user.equals("X")) {
            userScore += ROCK + DRAW;
        } else if(elf.equals("B") && user.equals("X")){
            userScore += ROCK + LOSS;
        } else if(elf.equals("C") && user.equals("X")) {
            userScore += ROCK + WIN;
        } else if(elf.equals("A") && user.equals("Y")) {
            userScore += PAPER + WIN;
        } else if(elf.equals("B") && user.equals("Y")){
            userScore += PAPER + DRAW;
        } else if(elf.equals("C") && user.equals("Y")) {
            userScore += PAPER + LOSS;
        } else if(elf.equals("A") && user.equals("Z")) {
            userScore += SCISSOR + LOSS;
        } else if(elf.equals("B") && user.equals("Z")){
            userScore += SCISSOR + WIN;
        } else if(elf.equals("C") && user.equals("Z")) {
            userScore += SCISSOR + DRAW;
        }

        return userScore;
    }
}