package ticTacToe;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        final Map<Integer, Character> SYMBOLS = Map.of(
                0, 'X',
                1, 'O',
                2, '-',
                3, '|'
        );
        CustomScanner in = new CustomScanner(System.in);
        int n, m, k, players;
        while (true) {
            System.out.println("Plz enter board dimensions row x col and k (how many u need in row to win)");
            try {
                n = in.nextInt();
                m = in.nextInt();
                k = in.nextInt();
                if (n < 2 || m < 2) {
                    System.out.println("Too small");
                } else if (k > Integer.max(n, m)) {
                    System.out.println("k is too big. Impossible to win");
                } else {
                    break;
                }
            } catch (IOException e) {}
        }
        while (true) {
            System.out.println("How many players?");
            try {
                players = in.nextInt();
                if (players >= 2 && players <= 4) {
                    break;
                } else {
                    System.out.println("Sorry, but no");
                }
            } catch (IOException e) {}
        }
        System.out.println("For each player: h/b (human/bot)???");
        Player[] playerType = new Player[players];
        for (int i = 1; i <= players; i++) {
            while (true) {
                System.out.print(i + " player: ");
                String s = in.nextLine();
                char c = s.charAt(0);
                if (c == 'h') {
                    playerType[i - 1] = new HumanPlayer();
                    break;
                } else if (c == 'b') {
                    playerType[i - 1] = new RandomPlayer(n, m);
                    break;
                }
            }
        }
        int matches;
        while (true) {
            System.out.println("Matches to win?");
            try {
                matches = in.nextInt();
                if (matches > 0) {
                    break;
                } else {
                    System.out.println("What is wrong with you?");
                }
            } catch (IOException e) {}
        }
        final Game game = new Game(playerType);
        int result;
        int[] score = new int[players];
        Arrays.fill(score, 0);
        int i = 0;
        while (i < Integer.MAX_VALUE) {
            for (int j = 0; j < players; j++) {
                System.out.println("Player " + (j + 1) + ": Score: " + score[j] + ", now is playing: " + SYMBOLS.get((j + i) % players));
            }
            result = game.play(new TicTacToeBoard(n, m, k, playerType.length), i);
            if (result == 0) {
                System.out.println("Nobody wins");
            } else {
                System.out.println("Player " + result + " wins");
                score[result - 1]++;
                if (score[result - 1] == matches) {
                    System.out.println("Game ENDED");
                    System.out.println("Player " + result + " is too good");
                    break;
                }
            }
            i++;
        }
    }
}
