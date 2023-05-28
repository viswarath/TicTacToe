import java.util.Arrays;
import java.util.Scanner;

public class TicTacToe {
    private static Scanner scanny = new Scanner(System.in);
    private static String answer = "N";
    private static boolean gameLoop = false;
    private static String[][] board = new String[3][3];
    private static int[] coordinates = new int[2]; //int[0] is row, int[1] is column
    private static int playerNum = 1;
    private static String mark = "X";
    private static int placeMark;
    public static void main(String args[]){
        System.out.println("Welcome to Tic Tac Toe.\nEnter 'Y' to play.");
        answer = scanny.nextLine();
        initializeBoard();
        if (answer.equals("Y")){
            gameLoop = true;
            displayBoardNum();
            while(gameLoop){
                displayBoard();
                System.out.printf("Player %d, enter in the number to place '%s'\n",playerNum,mark);
                placeMark = scanny.nextInt();
                placeMarkOnBoard();
                if (winCondition()){
                    gameLoop = false;
                    break;
                }
                if (playerNum == 1){
                    playerNum = 2;
                    mark = "O";
                } else {
                    playerNum = 1;
                    mark = "X";
                }

            }
        }

        if(gameLoop == false){
            System.out.printf("Congratulations Player %d for winning the game\n", playerNum);
            displayBoard();
            scanny.close();
        }
    }

    private static boolean winCondition() {
        String check = " ";
        int count;
        for (int i = 0; i < 3; i++){
            if( !(board[i][0].equals(check)) && board[i][0].equals(board[i][1]) && board[i][0].equals(board[i][2])){
                return true;
            } else if (!(board[i][0].equals(check)) && board[0][i].equals(board[1][i]) && board[0][i].equals(board[2][i])){
                return true;
            }
        }
        if (!(board[0][0].equals(check)) && board[0][0].equals(board[1][1]) && board[0][0].equals(board[2][2])){
            return true;
        } else if (!(board[2][0].equals(check)) && board[2][0].equals(board[1][1]) && board[2][0].equals(board[0][2])){
            return true;
        }
        return false;
    }

    private static void placeMarkOnBoard() {
        translateMarkToBoard();
        board[coordinates[0]][coordinates[1]] = mark;
    }


    private static void translateMarkToBoard() {
        switch (placeMark){
            case 1: coordinates[0] = 0; coordinates[1] = 0; break;
            case 2: coordinates[0] = 0; coordinates[1] = 1; break;
            case 3: coordinates[0] = 0; coordinates[1] = 2; break;
            case 4: coordinates[0] = 1; coordinates[1] = 0; break;
            case 5: coordinates[0] = 1; coordinates[1] = 1; break;
            case 6: coordinates[0] = 1; coordinates[1] = 2; break;
            case 7: coordinates[0] = 2; coordinates[1] = 0; break;
            case 8: coordinates[0] = 2; coordinates[1] = 1; break;
            case 9: coordinates[0] = 2; coordinates[1] = 2; break;
        }
    }

    private static void displayBoardNum() {
        System.out.println("1 | 2 | 3\n'------'\n4 | 5 | 6\n'------'\n7 | 8 | 9\n");
    }

    private static void initializeBoard(){
        for (String[] row : board){
            Arrays.fill(row, " ");
        }
    }
    private static void displayBoard(){
        System.out.printf("%s | %s | %s \n'------'\n%s | %s | %s\n'------'\n%s | %s | %s\n",board[0][0],board[0][1],board[0][2],board[1][0],board[1][1],board[1][2],board[2][0],board[2][1],board[2][2]);
    }
}
