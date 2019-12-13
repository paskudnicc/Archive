package ticTacToe;

public interface Board {
    Position getPosition();

    CellType getTurn();

    Result makeMove(Move move);

    Board copyOf();
}
