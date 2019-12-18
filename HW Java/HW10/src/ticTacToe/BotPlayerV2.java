package ticTacToe;

public class BotPlayerV2 implements Player {
    private final int n, m, k;

    public BotPlayerV2(int n, int m, int k) {
        this.n = n;
        this.m = m;
        this.k = k;
    }

    public Move move(final LockedPosition position, final CellType cell) {
        int x = 0, y = 0, pMax = -1, tMax = -1;
        Cell temp, emptyCell;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                emptyCell = position.getCell(i, j);
                if (emptyCell.getType() != CellType.E) {
                    continue;
                }
                int type = (i == 0 || i == n - 1 ? 0 : 1)
                        + (j == 0 || j == m - 1 ? 0 : 1);
                for (int it = -1; it <= 1; it++) {
                    for (int jt = -1; jt <= 1; jt++) {
                        if (it == 0 && jt == 0) {
                            continue;
                        }
                        temp = position.getCell(i + it, j + jt);
                        if (temp == null) {
                            continue;
                        }
                        if (temp.getType() == cell) {
                            if (temp.getNeighbour(it, jt) * 2 + 2 > pMax) {
                                pMax = temp.getNeighbour(it, jt) * 2 + 2;
                                tMax = type;
                                x = emptyCell.getXPos();
                                y = emptyCell.getYPos();
                            } else if (temp.getNeighbour(it, jt) * 2 + 2 == pMax) {
                                if (type > tMax) {
                                    tMax = type;
                                    x = emptyCell.getXPos();
                                    y = emptyCell.getYPos();
                                }
                            }
                        } else if (temp.getType() == CellType.E) {
                            if (0 > pMax) {
                                pMax = 0;
                                tMax = type;
                                x = emptyCell.getXPos();
                                y = emptyCell.getYPos();
                            } else if (0 == pMax) {
                                if (type > tMax) {
                                    tMax = type;
                                    x = emptyCell.getXPos();
                                    y = emptyCell.getYPos();
                                }
                            }
                        } else {
                            if (temp.getNeighbour(it, jt) * 2 + 1 > pMax) {
                                pMax = temp.getNeighbour(it, jt) * 2 + 1;
                                tMax = type;
                                x = emptyCell.getXPos();
                                y = emptyCell.getYPos();
                            } else if (temp.getNeighbour(it, jt) * 2 + 1 == pMax) {
                                if (type > tMax) {
                                    tMax = type;
                                    x = emptyCell.getXPos();
                                    y = emptyCell.getYPos();
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println(pMax);
        System.out.println(tMax);
        return new Move(x, y, cell);
    }
}
