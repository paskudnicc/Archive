package ticTacToe;

import java.io.PrintStream;
import java.util.Scanner;


public class HumanPlayer implements Player {
    private final PrintStream out;
    private final Scanner in;

    public HumanPlayer(final PrintStream out, final Scanner in) {
        this.out = out;
        this.in = in;
    }

    public HumanPlayer() {
        this(System.out, new Scanner(System.in));
    }

    public Move move(final Position position, final CellType cell) {
        out.println(cell + "'s move");
        while (true) {
            try {
                out.println("Enter row and column");
                final Move move = new Move(in.nextInt(), in.nextInt(), cell);
                if (position.isValid(move)) {
                    return move;
                }
            } catch (Exception e) {}
            out.println("U r stupid do it again");
        }
    }
}
