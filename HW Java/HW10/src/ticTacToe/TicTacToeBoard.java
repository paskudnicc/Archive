package ticTacToe;

import java.util.Arrays;
import java.util.Map;

public class TicTacToeBoard implements Board, Position {
    private Cell[][] cells;
    private CellType turn;
    private final int n, m, k;
    private int t;
    private final int players;

    public TicTacToeBoard(int n, int m, int k, int players) {
        this.players = players;
        this.n = n;
        this.m = m;
        this.t = n * m;
        this.k = k;
        this.cells = new Cell[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                cells[i][j] = new Cell(CellType.E, i, j);
            }
        }
        turn = CellType.X;
    }

    public Board copyOf() {
        return new TicTacToeBoard(cells, n, m, k, turn, players, t);
    }

    private TicTacToeBoard(Cell[][] cells, int n, int m, int k, CellType turn, int players, int t) {
        this.players = players;
        this.n = n;
        this.m = m;
        this.t = t;
        this.k = k;
        this.cells = new Cell[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                this.cells[i][j] = new Cell(cells[i][j].getType(), i, j);
            }
        }
        this.turn = turn;
    }

    public Position getPosition() {
        return this;
    }

    public CellType getTurn() {
        return turn;
    }

    private boolean okRow(int x) {
        return 0 <= x && x < n;
    }

    private boolean okCol(int x) {
        return 0 <= x && x < m;
    }

    public Result makeMove(final Move move) {
        if (!isValid(move)) {
            return Result.BROKEN;
        }
        t -= 1;
        if (t == 0) {
            return Result.DRAW;
        }
        int r = move.getRow();
        int c = move.getColumn();
        cells[r][c].setType(move.getValue());
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0 || !okRow(r + i) || !okCol(c + j)) {
                    continue;
                }
                if (cells[r + i][c + j].getType() == turn) {
                    int newCells;
                    if (okRow(r - i) && okCol(c - j) && cells[r - i][c - j].getType() == turn) {
                        newCells = cells[r - i][c - j].getNeighbour(-i, -j) + 1;
                    } else {
                        newCells = 1;
                    }
                    int rLine = r + i;
                    int cLine = c + j;
                    if (cells[rLine][cLine].getNeighbour(i, j) + newCells >= k - 1) {
                        return Result.WIN;
                    }
                    cells[r][c].setNeighbour(i, j, cells[rLine][cLine].getNeighbour(i, j) + 1);
                    for (int z = 0; z < cells[r][c].getNeighbour(i, j); z++) {
                        cells[rLine][cLine].setNeighbour(-i, -j, cells[rLine][cLine].getNeighbour(-i, -j) + newCells);
                        rLine = rLine + i;
                        cLine = cLine + j;
                    }
                }
            }
        }
        switch (turn) {
            case X:
                turn = CellType.O;
                break;
            case O:
                if (players > 2) {
                    turn = CellType.H;
                } else {
                    turn = CellType.X;
                }
                break;
            case H:
                if (players > 3) {
                    turn = CellType.I;
                } else {
                    turn = CellType.X;
                }
                break;
            case I:
                turn = CellType.X;
        }
        return Result.UNKNOWN;
    }

    public boolean isValid(final Move move) {
        return okRow(move.getRow()) && okCol(move.getColumn())
                && cells[move.getRow()][move.getColumn()].getType() == CellType.E
                && turn == move.getValue();
    }

    public Cell getCell(final int r, final int c) {
        if (okRow(r) && okCol(c)) {
            return cells[r][c];
        } else {
            return null;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(" ");
        for (int i = 0; i < m; i++) {
            sb.append(' ').append(i);
        }
        for (int r = 0; r < n; r++) {
            sb.append("\n");
            sb.append(r);
            for (int c = 0; c < m; c++) {
                sb.append(' ').append(cells[r][c].getChar());
            }
        }
        return sb.toString();
    }
}
