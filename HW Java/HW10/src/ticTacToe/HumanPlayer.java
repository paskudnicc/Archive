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

    public Move move(final Position position, final Cell cell) {
        out.println("Position");
        out.println(position);
        out.println(cell + "'s move");
        while (true) {
            out.println("Enter row and column");
            final Move move = new Move(in.nextInt(), in.nextInt(), cell);
            if (position.isValid(move)) {
                return move;
            }
            out.println("U stupid do it again");
        }
    }
}
