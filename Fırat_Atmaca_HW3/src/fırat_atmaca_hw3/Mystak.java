/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fırat_atmaca_hw3;

/**
 *
 * @author firat
 */
public class Mystak {

    int kapasite = 100;
    int top = -1;
    int eleman;
    int n = 1;
    Direction[] stak;
    Direction result = new Direction();

    public Mystak() {
        stak = new Direction[kapasite];

        eleman = 0;

    }

    public void push(Direction item) {

        stak[++top] = new Direction();
        stak[top].row = item.row;
        stak[top].col = item.col;

    }

    public Direction pop() {

        if (top == -1) {
            System.out.println("stak boş");

            return null;
        }

        result.row = stak[top].row;
        result.col = stak[top].col;
        stak[top--] = null;

        return result;
    }
}
