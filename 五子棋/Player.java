package 五子棋;

public abstract class Player {
    private String name;

    public Player(String name) {
        this.name = name;
    }

    public abstract int[] playChess();

    public String getName() {
        return name;
    }
}
