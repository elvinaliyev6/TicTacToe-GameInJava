/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.util.Scanner;

/**
 *
 * @author Elvin Aliyev
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Player 1, what's your name?");
        String p1 = sc.nextLine();

        System.out.println("Player 2, what's your name");
        String p2 = sc.nextLine();

        char[][] board = new char[3][3];
//- empty space
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
        boolean player1 = true;

        boolean gameEnded = false;
        while (!gameEnded) {
            drawBoard(board);

            char symbol = ' ';

            if (player1) {
                symbol = 'x';
            } else {
                symbol = 'o';
            }

            if (player1) {
                System.out.println(p1 + "'s Turn (x)");
            } else {
                System.out.println(p2 + "'s Turn (o)");
            }

            int row = 0;
            int col = 0;

            while (true) {
                System.out.println("Enter a row (0,1,2): ");
                row = sc.nextInt();
                System.out.println("Enter a column (0,1,2): ");
                col = sc.nextInt();

                if (row < 0 || col < 0 || row > 2 || col > 2) {
                    System.out.println("Your row or column are out of bounds!");
                } else if (board[row][col] != '-') {
                    System.out.println("Someone has already made a move there!");
                } else {
                    //row and column are valid
                    break;
                }
            }

            board[row][col] = symbol;

            if (hasWon(board) == 'x') {
                System.out.println(p1 + " has won!");
                gameEnded = true;
            } else if (hasWon(board) == 'o') {
                System.out.println(p2 + " has won!");
                gameEnded = true;
            } else {
                if (hasTied(board)) {
                    System.out.println("It's a tie!");
                    gameEnded = true;
                } else {
                    player1 = !player1;
                }
            }
        }
        drawBoard(board);
    }

    public static void drawBoard(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println("");
        }
    }

    public static char hasWon(char[][] board) {

        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1]
                    && board[i][1] == board[i][2]
                    && board[i][0] != '-') {
                return board[i][0];
            }
        }

        for (int i = 0; i < 3; i++) {
            if (board[0][i] == board[1][i]
                    && board[1][i] == board[2][i]
                    && board[0][i] != '-') {
                return board[0][i];
            }
        }

        if (board[0][0] == board[1][1]
                && board[1][1] == board[2][2]
                && board[0][0] != '-') {
            return board[0][0];
        }

        if (board[2][0] == board[1][1]
                && board[1][1] == board[0][2]
                && board[2][0] != '-') {
            return board[2][0];
        }
        return '-';
    }

    public static boolean hasTied(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }
}
