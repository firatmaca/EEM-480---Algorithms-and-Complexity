/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fırat_atmaca_hw3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 *
 * @author firat
 */
public class doldurdaGör implements HW3Maze {

    int[][] mazetablosu = new int[10][10];

    Mystak fırat = new Mystak();
    String adresss;

    Direction result = new Direction();
    Direction here = new Direction();
    Direction next = new Direction();
    Direction prev = new Direction();
    Direction basla = new Direction();

    @Override
    public void ReadMazeFromFile() {

        try {

            File file = new File(adresss);
            Scanner f = new Scanner(new FileReader(file));
            for (int i = 1; i <= 8; i++) {
                for (int j = 1; j <= 8; j++) {
                    mazetablosu[i][j] = f.nextInt();
                }
            }

        } catch (FileNotFoundException a) {
            System.out.println("yanlış");

        }

    }

    public Direction ilki() {
        for (int i = 0; i <= 9; i++) {
            for (int j = 0; j <= 9; j++) {
                if (mazetablosu[i][j] == 1) {
                    basla.row = i;
                    basla.col = j;

                }
            }
        }
        return basla;
    }

    @Override
    public void SolveMaze() {
        Direction[] offset = new Direction[8];
        for (int i = 0; i <= 7; i++) {
            offset[i] = new Direction();
        }

        offset[0].row = 0;
        offset[0].col = 1; // D    

        offset[1].row = 1;
        offset[1].col = 0; // G

        offset[2].row = 0;
        offset[2].col = -1; // B

        offset[3].row = -1;
        offset[3].col = 0; // K

        offset[4].row = -1;
        offset[4].col = 1; //kD

        offset[5].row = -1;
        offset[5].col = -1; //KB

        offset[6].row = 1;
        offset[6].col = 1; //GD

        offset[7].row = 1;
        offset[7].col = -1; //GB

        for (int i = 0; i <= 9; i++) {
            mazetablosu[0][i] = mazetablosu[9][i] = 0; // bottom and top
            mazetablosu[i][0] = mazetablosu[i][9] = 0; // left and right
        }

        int option = 0;
        int LastOption = 7;
        int a = 2;

        ilki();
        here = basla;
        fırat.push(here);

        while (here.row != 9 || here.col != 9) {

            int r = 0;
            int c = 0;
            while (option <= LastOption) {

                r = here.row + offset[option].row;
                c = here.col + offset[option].col;
                if (mazetablosu[r][c] == a) {
                    next.row = r;
                    next.col = c;
                    a++;
                    break;
                }

                option++;
            }

            if (option <= LastOption) {

                next = new Direction(r, c);
             

                prev.row = here.row;
                prev.col = here.col;
                here.row = next.row;
                here.col = next.col;

                option = 0;

                fırat.push(next);
                if (a == 33) {
                    break;
                }

            } else {

                next = fırat.pop();

                mazetablosu[next.row][next.col] = 0;

                if (a != 2) {

                    here.row = prev.row;
                    here.col = prev.col;
                    option = 0;
                    a--;

                } else {
                    ilki();
                    here = basla;
                    fırat.push(here);
                    option = 0;
                    a = 2;
                }

            }

        }

    }

    @Override
    public void PrintSolution() {
        int f;

        Mystak fırat1 = new Mystak();
        System.out.println("32-1 path ");
        for (f = 0; f < 32; f++) {
            Direction son = fırat.pop();

            fırat1.push(son);

            System.out.print(son.row + "." + son.col + " ");

        }
        System.out.println(" ");
        System.out.println("1-32 path");
        for (f = 0; f < 32; f++) {

            Direction son1 = fırat1.pop();

            System.out.print(son1.row + "." + son1.col + " ");

        }

    }

}
