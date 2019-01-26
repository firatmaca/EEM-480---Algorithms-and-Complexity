/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fırat_atmaca_hw3;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author firat
 */
public class Fırat_Atmaca_HW3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        doldurdaGör myMaze = new doldurdaGör();
        String dosya;
        dosya = dosyam();
        myMaze.adresss = dosya;
        myMaze.ReadMazeFromFile();
        myMaze.SolveMaze();
        myMaze.PrintSolution();

    }

    public static String dosyam() {
        String dosya;
        Scanner scan = new Scanner(System.in);
        System.out.println("enter name of .txt = ");
        dosya = scan.nextLine();
        return dosya;
    }

}
