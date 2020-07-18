package 五子棋;

import java.util.Scanner;

public class ChessGame {

    private Scanner input = new Scanner(System.in);
    private String[][] chessBoard;
    private Player blackPlayer;
    private Player whitePlayer;
    private int count;
    private boolean win;

    private static class ChessGameInstance {
        private static final ChessGame game = new ChessGame();
    }

    private ChessGame() {
    }

    public void startGame() {
        selectPlayMode();
        displayBoard();
        playChessUntilGameOver();
    }

    private void selectPlayMode() {
        int select;

        do {
            System.out.println("歡迎來到五子棋對戰");
            System.out.println("請選擇，1.玩家PK，2.人機對戰");
            select = input.nextInt();
        } while (select < 1 || select > 2);

        if (select == 1) {
            System.out.println("您選擇的是玩家PK");
            System.out.println("請輸入您的名稱");
            blackPlayer = new HumanPlayer(input.next());
            System.out.println("請輸入對方的名稱");
            whitePlayer = new HumanPlayer(input.next());
        } else {
            System.out.println("您選擇的是人機對戰");
            System.out.println("請輸入您的名稱");
            blackPlayer = new HumanPlayer(input.next());
            whitePlayer = new AiPlayer(this);
        }

        setUpSize();
    }

    public void setUpSize() {
        int size;

        do {
            System.out.println("請輸入棋盤大小");
            size = input.nextInt();

        } while (size < 5);

        initialization(size);

    }

    public void initialization(int inputSize) {
        win = false;
        chessBoard = new String[inputSize][inputSize];
        for (int i = 0; i < inputSize; i++) {
            for (int j = 0; j < inputSize; j++) {
                chessBoard[i][j] = "-";
            }
        }
    }

    public void playChessUntilGameOver() {
        int length = chessBoard.length;

        while (!win) {
            playChess(length, blackPlayer, "x");
            playChess(length, whitePlayer, "o");
        }

        System.out.println("要重來一局嗎Y/N");
        if (input.next().equals("Y")) {
            startGame();
        } else if (input.next().equals("N")) {
            System.exit(0);
        }
    }

    private void playChess(int length, Player blackPlayer, String chessSymbol) {
        int[] x;
        System.out.println(blackPlayer.getName() + "請選擇下的座標(x,y)");
        do {
            x = blackPlayer.playChess();
        } while (x[0] > length - 1 || x[0] < 0 || x[1] > length - 1 ||
                x[1] < 0 || !chessBoard[x[0]][x[1]].equals("-"));
        chessBoard[x[0]][x[1]] = chessSymbol;
        displayBoard();
        checkWinner(blackPlayer.getName(), x[0], x[1]);
        count++;
        if (count == length * length) {
            printGameOver(blackPlayer.getName());
        }
    }

    public static ChessGame getInstance() {
        return ChessGameInstance.game;
    }

    public void displayBoard() {
        for (int i = 0; i < chessBoard.length; i++) {
            System.out.println();

            for (int j = 0; j < chessBoard.length; j++) {
                System.out.print(chessBoard[i][j]);
            }
        }
        System.out.println();
    }

    private void printGameOver(String name) {
        if (win) {
            System.out.println("遊戲結束" + name + "勝利");
        } else {
            System.out.println("遊戲結果:平手");
        }
    }

    public String[][] getChessBoard() {
        return chessBoard;
    }

    private void checkWinner(String name, int x, int y) {
        checkVerticalLines(name, x, y);
        checkHorizontalLines(name, chessBoard[x], y);
        checkLeftDiagonalLines(name, x, y);
        checkRightDiagonalLines(name, x, y);
    }

    private void checkHorizontalLines(String name, String[] row, int y) {
        int firstPoint = 0;
        int point = 0;
        int sideLength = chessBoard.length - 1;

        for (int i = 1; i < 5; i++) {
            if (y - i < 0 || !row[y].equals(row[y - i])) break;
            firstPoint++;
            point++;
            if (point == 4) {
                win = true;
                printGameOver(name);
            }
        }
        for (int i = 1; i <= 5 - firstPoint; i++) {
            if (y + i > sideLength || !row[y].equals(row[y + i])) break;
            point++;
            if (point == 4) {
                win = true;
                printGameOver(name);
            }
        }
    }

    private void checkVerticalLines(String name, int x, int y) {
        int firstPoint = 0;
        int point = 0;
        int sideLength = chessBoard.length - 1;
        for (int i = 1; i < 5; i++) {
            if (x - i < 0 || !chessBoard[x][y].equals(chessBoard[x - i][y])) break;
            firstPoint++;
            point++;
            if (point == 4) {
                win = true;
                printGameOver(name);
            }
        }
        for (int i = 1; i <= 5 - firstPoint; i++) {
            if (x + i > sideLength || !chessBoard[x][y].equals(chessBoard[x + i][y])) break;
            point++;
            if (point == 4) {
                win = true;
                printGameOver(name);
            }
        }
    }

    private void checkRightDiagonalLines(String name, int x, int y) {
        int firstPoint = 0;
        int point = 0;
        int sideLength = chessBoard.length - 1;

        for (int i = 1; i < 5; i++) {
            if (x + i > sideLength || y - i < 0 || !chessBoard[x][y].equals(chessBoard[x + i][y - i]))
                break;
            firstPoint++;
            point++;
            if (point == 4) {
                win = true;
                printGameOver(name);
            }
        }
        for (int i = 1; i <= 5 - firstPoint; i++) {
            if (x - i < 0 || y + i > sideLength || !chessBoard[x][y].equals(chessBoard[x - i][y + i]))
                break;
            point++;
            if (point == 4) {
                win = true;
                printGameOver(name);
            }
        }
    }

    private void checkLeftDiagonalLines(String name, int x, int y) {
        int firstPoint = 0;
        int point = 0;
        int sideLength = chessBoard.length - 1;

        for (int i = 1; i < 5; i++) {
            if (x - i < 0 || y - i < 0 || !chessBoard[x][y].equals(chessBoard[x - i][y - i])) break;
            firstPoint++;
            point++;
            if (point == 4) {
                win = true;
                printGameOver(name);
            }
        }
        for (int i = 1; i <= 5 - firstPoint; i++) {
            if (x + i > sideLength || y + i > sideLength || !chessBoard[x][y].equals(chessBoard[x + i][y + i]))
                break;
            point++;
            if (point == 4) {
                win = true;
                printGameOver(name);
            }
        }
    }

}

