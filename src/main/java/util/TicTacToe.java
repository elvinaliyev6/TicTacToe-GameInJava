/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Elvin Aliyev
 */
public class TicTacToe {

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

    public static void startGame() {

        JOptionPane.showMessageDialog(null, "Welcome to the Tic Tac Toe Game!", "Tic Tac Toe", 3);

        String p1 = JOptionPane.showInputDialog("Player 1, what's your name?");
        String p2 = JOptionPane.showInputDialog("Player 2, what is your name?");

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
                JOptionPane.showMessageDialog(null, p1 + "'s Turn (x)");
            } else {
                JOptionPane.showMessageDialog(null, p2 + "'s Turn (o)");
            }

            int row = 0;
            int col = 0;

            while (true) {
                System.out.println();
                String input = JOptionPane.showInputDialog("Enter a row (0,1,2): ");
                row = Integer.parseInt(input);

                String input2 = JOptionPane.showInputDialog("Enter a column (0,1,2): ");
                col = Integer.parseInt(input2);

                if (row < 0 || col < 0 || row > 2 || col > 2) {
                    JOptionPane.showMessageDialog(null, "Your row or column are out of bounds!");
                } else if (board[row][col] != '-') {
                    JOptionPane.showMessageDialog(null, "Someone has already made a move there!");
                } else {
                    //row and column are valid
                    break;
                }
            }

            board[row][col] = symbol;

            if (hasWon(board) == 'x') {
                JOptionPane.showMessageDialog(null, p1 + " has won!");
                gameEnded = true;
            } else if (hasWon(board) == 'o') {
                JOptionPane.showMessageDialog(null, p2 + " has won!");
                gameEnded = true;
            } else {
                if (hasTied(board)) {
                    JOptionPane.showMessageDialog(null, "It's a tie!");
                    gameEnded = true;
                } else {
                    player1 = !player1;
                }
            }
        }
        drawBoard(board);
    }

}
