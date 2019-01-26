/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HW1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 *
 * @author firat
 */
public class StudentdBase {

    String adresss;

    public void sortall() throws FileNotFoundException {
        File file = new File(adresss);
        Scanner f = new Scanner(new FileReader(file));
        int numberofstudents = f.nextInt();

        Student myst = new Student();
        Student[] bilgi = new Student[numberofstudents];
        for (int i = 0; i < numberofstudents; i++) {

            bilgi[i] = new Student();
            bilgi[i].ID = f.nextLong();
            bilgi[i].name = f.next();
            bilgi[i].surname = f.next();
            bilgi[i].age = f.nextInt();
            bilgi[i].admYear = f.nextInt();

        }
        bublesortID(bilgi);
        System.out.println("sortıd");
        for (int j = 0; j < bilgi.length; j++) {

            System.out.println(bilgi[j].ID + " " + bilgi[j].name + " " + bilgi[j].surname + " " + bilgi[j].age + " " + bilgi[j].admYear);
        }
        bublesortAge(bilgi);
        System.out.println("sortage");
        for (int j = 0; j < bilgi.length; j++) {

            System.out.println(bilgi[j].ID + " " + bilgi[j].name + " " + bilgi[j].surname + " " + bilgi[j].age + " " + bilgi[j].admYear);
        }
        bublesortYear(bilgi);
        for (int j = 0; j < bilgi.length; j++) {

            System.out.println(bilgi[j].ID + " " + bilgi[j].name + " " + bilgi[j].surname + " " + bilgi[j].age + " " + bilgi[j].admYear);
        }

    }

    public void bublesortID(Student[] bilgi) {
        for (int i = bilgi.length; i > 1; i--) {
            int j;
            for (j = 0; j < i - 1; j++) {
                if (bilgi[j].ID > bilgi[j + 1].ID) {
                    Student dummy = bilgi[j];
                    bilgi[j] = bilgi[j + 1];
                    bilgi[j + 1] = dummy;

                }

            }

        }

    }

    public void bublesortAge(Student[] bilgi) {
        for (int i = bilgi.length; i > 1; i--) {
            int j;
            for (j = 0; j < i - 1; j++) {
                if (bilgi[j].age > bilgi[j + 1].age) {
                    Student dummy = bilgi[j];
                    bilgi[j] = bilgi[j + 1];
                    bilgi[j + 1] = dummy;

                }

            }

        }

    }

    public void bublesortYear(Student[] bilgi) {
        for (int i = bilgi.length; i > 1; i--) {
            int j;
            for (j = 0; j < i - 1; j++) {
                if (bilgi[j].admYear > bilgi[j + 1].admYear) {
                    Student dummy = bilgi[j];
                    bilgi[j] = bilgi[j + 1];
                    bilgi[j + 1] = dummy;

                }

            }

        }

    }

}
