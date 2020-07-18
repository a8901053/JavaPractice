package 五子棋;

public class Main {

    public static void main(String[] args) {
        start();
    }

    public static void start(){
        ChessGame game = ChessGame.getInstance();
        game.startGame();
    }
}
