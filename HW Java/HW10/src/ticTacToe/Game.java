package ticTacToe;

import java.util.Map;

public class Game {
    private final boolean log;
    private final Player[] players;

    public Game(final Player[] players) {
        this.log = false;
        this.players = players;
    }

    public int play(Board board, int round) {
        while (true) {
            for (int i = 0; i < players.length; i++) {
                final int res = move(board, players[(i + round) % players.length], (i + round) % players.length + 1);
                if (res != -1) {
                    return res;
                }
            }
        }
    }

    private int move(final Board board, final Player player, final int no) {
        final Move move = player.move(board.getPosition(), board.getCell());
        final Result result = board.makeMove(move);
        log("Player " + no + " move: " + move);
        log("Position:\n" + board);
        if (result == Result.WIN) {
            log("Player " + no +  " won");
            return no;
        } else if (result == Result.BROKEN) {
            log("Somebody is ruining game");
            return 0;
        } else if (result == Result.DRAW) {
            log("Draw");
            return 0;
        } else {
            return -1;
        }
    }

    private void log(final String message) {
        if (log) {
            System.out.println(message);
        }
    }
}
