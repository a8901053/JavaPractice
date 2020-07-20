package 二十一點撲克牌遊戲;

import java.util.Comparator;

public class FinalScoreComparator implements Comparator<Player> {

    @Override
    public int compare(Player o1, Player o2) {
        return o2.getFinalScore() - o1.getFinalScore();
    }
}
