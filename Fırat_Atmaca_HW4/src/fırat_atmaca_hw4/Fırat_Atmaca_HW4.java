/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fırat_atmaca_hw4;

import java.util.Scanner;

/**
 *
 * @author firat
 */
public class Fırat_Atmaca_HW4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String dosya;
        dosya = dosyam();
        int size;
        size = sizem();
        String outputfile;
        outputfile = outputfile();
        String outfile;
        outfile = outfile();
        cHash cobj = new cHash();
        cobj.BuildHash(dosya, size);
        cobj.sizem = size;

    }

    public static String outfile() {
        String outfile;
        Scanner scan = new Scanner(System.in);
        System.out.println("enter name of outfiletxt = ");
        outfile = scan.nextLine();
        return outfile;
    }

    public static String outputfile() {
        String outputfile;
        Scanner scan = new Scanner(System.in);
        System.out.println("enter name of outputtxt = ");
        outputfile = scan.nextLine();
        return outputfile;
    }

    public static String dosyam() {
        String dosya;
        Scanner scan = new Scanner(System.in);
        System.out.println("enter name of .txt = ");
        dosya = scan.nextLine();
        return dosya;
    }

    public static int sizem() {
        int size;
        Scanner scan = new Scanner(System.in);
        System.out.println("enter size = ");
        size = scan.nextInt();
        return size;
    }

}
