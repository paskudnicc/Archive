package ticTacToe;

public class Game {
    private final boolean log;
    private final int numberOfPlayers;
    private final Player player1, player2, player3, player4;

    public Game(final Player player1, final Player player2) {
        this.log = true;
        this.player1 = player1;
        this.player2 = player2;
        this.player3 = null;
        this.player4 = null;
        this.numberOfPlayers = 2;
    }

    public Game(final Player player1, final Player player2, final Player player3) {
        this.log = true;
        this.player1 = player1;
        this.player2 = player2;
        this.player3 = player3;
        this.player4 = null;
        this.numberOfPlayers = 3;
    }

    public Game(final Player player1, final Player player2, final Player player3, final Player player4) {
        this.log = true;
        this.player1 = player1;
        this.player2 = player2;
        this.player3 = player3;
        this.player4 = player4;
        this.numberOfPlayers = 4;
    }

    public int play(Board board) {
        while (true) {
            final int result1 = move(board, player1, 1);
            if (result1 != -1) {
                return result1;
            }
            final int result2 = move(board, player2, 2);
            if (result2 != -1) {
                return result2;
            }
            if (numberOfPlayers > 2) {
                final int result3 = move(board, player3, 3);
                if (result3 != -1) {
                    return result3;
                }
                if (numberOfPlayers > 3) {
                    final int result4 = move(board, player4, 4);
                    if (result4 != -1) {
                        return result4;
                    }
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
            log("Player " + no + " won");
            return no;
        } else if (result == Result.LOSE) {
            log("Player " + no + " lose");
            return -10;
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
