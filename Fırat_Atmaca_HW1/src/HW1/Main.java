/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HW1;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.*;

/**
 *
 * @author firat
 */
public class Main {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {

        // TODO code application logic here
        StudentdBase mydb = new StudentdBase();
        Student c;
        String dosya;
        dosya = dosyam();
        mydb.adresss = dosya;

        mydb.sortall();

    }

    public static String dosyam() {
        String dosya;
        Scanner scan = new Scanner(System.in);
        System.out.println("enter name of .txt = ");
        dosya = scan.nextLine();
        return dosya;
    }
}
