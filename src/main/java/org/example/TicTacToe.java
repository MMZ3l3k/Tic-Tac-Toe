package org.example;

import java.util.Scanner;

public class TicTacToe {

    // Metoda do wyświetlania planszy
    public static void displayGrid(String[][] grid) {
        // Pętla dla pierwszych dwóch wierszy
        for (int i = 0; i < 2; i++) {
            // Pętla dla pierwszych dwóch kolumn
            for (int j = 0; j < 2; j++) {
                System.out.print(grid[i][j] + "|");
            }
            System.out.println(grid[i][2]); // Wydrukuj ostatni element w wierszu
            System.out.println(" ");
            System.out.println("------");
        }
        // Drukuj ostatni wiersz
        for (int j = 0; j < 2; j++) {
            System.out.print(grid[2][j] + "|");
        }
        System.out.println(grid[2][2]);
        System.out.println(" ");
    }
    private static boolean checkWinner(String[][] grid, String player) {
        // Sprawdź wiersze i kolumny
        for (int i = 0; i < 2; i++) {
            if (grid[i][0].equals(player) && grid[i][1].equals(player) && grid[i][2].equals(player)) {
                return true;
            }
            if (grid[0][i].equals(player) && grid[1][i].equals(player) && grid[2][i].equals(player)) {
                return true;
            }
        }

        // Sprawdź przekątne
        if (grid[0][0].equals(player) && grid[1][1].equals(player) && grid[2][2].equals(player)) {
            return true;
        }
        if (grid[0][2].equals(player) && grid[1][1].equals(player) && grid[2][0].equals(player)) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        // Inicjalizacja 3x3 planszy
        String[][] grid = new String[3][3];

        // Wypełnienie każdego pola planszy spacją
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                grid[i][j] = " ";
            }
        }

        // Nieskończona pętla dla gry (gra będzie trwać, dopóki nie przerwiemy jej manualnie)
        while (true) {
            Scanner s = new Scanner(System.in);
            displayGrid(grid);

            // Prośba o wybór gracza 1
            System.out.println("Player 1, który wiersz i kolumnę wybierasz?");
            int p1RowChoice = s.nextInt() - 1;
            int p1ColumnChoice = s.nextInt() - 1;
            grid[p1RowChoice][p1ColumnChoice] = "X"; // Umieszcz 'X' na wybranym polu
            displayGrid(grid);
            if (checkWinner(grid, "X")) {
                System.out.println("Gracz 1 wygrywa!");
                break;
            }
            System.out.println("kolejny gracz");
            System.out.println(" ");

            // Prośba o wybór gracza 2
            System.out.println("Player 2, który wiersz i kolumnę wybierasz?");
            int p2RowChoice = s.nextInt() -1 ;
            int p2ColumnChoice = s.nextInt() - 1;
            grid[p2RowChoice][p2ColumnChoice] = "0"; // Umieszcz '0' na wybranym polu
            displayGrid(grid);
            if (checkWinner(grid, "0")) {
                System.out.println("Gracz 2 wygrywa!");
                break;
            }
            System.out.println("kolejny gracz");
            System.out.println(" ");
        }
    }
}
