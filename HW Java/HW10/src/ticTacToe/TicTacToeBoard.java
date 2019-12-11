package ticTacToe;

import java.util.Arrays;
import java.util.Map;

public class TicTacToeBoard implements Board, Position {
    private static final Map<Cell, Character> SYMBOLS = Map.of(
            Cell.X, 'X',
            Cell.O, 'O',
            Cell.E, '.',
            Cell.I, '|',
            Cell.H, '-'
    );

    private final Cell[][] cells;
    private final int[][][] neighbours;
    private Cell turn;
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
        for (Cell[] row : cells) {
            Arrays.fill(row, Cell.E);
        }
        this.neighbours = new int[n][m][8];
        for (int[][] row : neighbours) {
            for (int[] cell : row) {
                Arrays.fill(cell, 0);
            }
        }
        turn = Cell.X;
    }

    public Position getPosition() {
        return this;
    }

    public Cell getCell() {
        return turn;
    }

    private boolean okRow(int x) {
        return 0 <= x && x < n;
    }

    private boolean okCol(int x) {
        return 0 <= x && x < m;

    }

    private int toCode(int i, int j) {
        int x = 3 * (i + 1) + (j + 1);
        return x > 4 ? x - 1 : x;
    }

    public Result makeMove(final Move move) {
        if (!isValid(move)) {
            return Result.LOSE;
        }
        t -= 1;
        if (t < 0) {
            return Result.DRAW;
        }
        int r = move.getRow();
        int c = move.getColumn();
        cells[r][c] = move.getValue();
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0 || !okRow(r + i) || !okCol(c + j)) {
                    continue;
                }
                if (cells[r + i][c + j] == turn) {
                    int newCells;
                    if (okRow(r - i) && okCol(c - j) && cells[r - i][c - j] == turn) {
                        newCells = neighbours[r - i][c - i][toCode(-i, -j)] + 1;
                    } else {
                        newCells = 1;
                    }
                    int rLine = r + i;
                    int cLine = c + j;
                    if (neighbours[rLine][cLine][toCode(i, j)] + newCells >= k - 1) {
                        return Result.WIN;
                    }
                    neighbours[r][c][toCode(i, j)] = neighbours[rLine][cLine][toCode(i, j)] + 1;
                    for (int z = 0; z < neighbours[r][c][toCode(i, j)]; z++) {
                        neighbours[rLine][cLine][toCode(-i, -j)] += newCells;
                        rLine = rLine + i;
                        cLine = cLine + j;
                    }
                }
            }
        }
        switch (turn) {
            case X:
                turn = Cell.O;
                break;
            case O:
                if (players > 2) {
                    turn = Cell.H;
                } else {
                    turn = Cell.X;
                }
                break;
            case H:
                if (players > 3) {
                    turn = Cell.I;
                } else {
                    turn = Cell.X;
                }
                break;
            case I:
                turn = Cell.X;
        }
        return Result.UNKNOWN;
    }

    public boolean isValid(final Move move) {
        return okRow(move.getRow()) && okCol(move.getColumn())
                && cells[move.getRow()][move.getColumn()] == Cell.E
                && turn == getCell();
    }

    public Cell getCell(final int r, final int c) {
        return cells[r][c];
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(" ");
        for (int i = 0; i < m; i++) {
            sb.append(i);
        }
        for (int r = 0; r < n; r++) {
            sb.append("\n");
            sb.append(r);
            for (int c = 0; c < m; c++) {
                sb.append(SYMBOLS.get(cells[r][c]));
            }
        }
        return sb.toString();
    }
}
