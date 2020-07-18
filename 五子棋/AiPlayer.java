package 五子棋;

public class AiPlayer extends Player {
    private ChessGame game;

    public AiPlayer(ChessGame game){
        super("AI電腦");
        this.game = game;
    }

    @Override
    public int[] playChess() {
        int [] select= new int [2];

        select[0] = (int)(Math.random()*game.getChessBoard().length+1);
        select[1] = (int)(Math.random()*game.getChessBoard().length+1);

        return select;
    }

}
