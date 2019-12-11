package ticTacToe;

/**
 * @author Georgiy Korneev (kgeorgiy@kgeorgiy.info)
 */
public class Main {
    public static void main(String[] args) {
        int n = 7;
        int m = 7;
        final Game game = new Game(new HumanPlayer(), new HumanPlayer(), new HumanPlayer());
        int result;
        do {
            result = game.play(new TicTacToeBoard(n, m, 4, 3));
            System.out.println("Game result: " + result);
        } while (result != 0);
    }
}
