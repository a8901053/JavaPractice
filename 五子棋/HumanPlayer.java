package 五子棋;

import java.util.Scanner;

public class HumanPlayer extends Player {
    public HumanPlayer(String name){
        super(name);
    }

    @Override
    public int[] playChess() {
        Scanner play = new Scanner(System.in);
        int [] select= new int [2];

        String coordinate = play.next();
        select [0] = Integer.parseInt(coordinate.split(",")[0]);
        select [1] = Integer.parseInt(coordinate.split(",")[1]);

        return select;
    }

}
