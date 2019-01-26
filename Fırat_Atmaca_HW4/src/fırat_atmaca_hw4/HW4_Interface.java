/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fırat_atmaca_hw4;

/**
 *
 * @author firat
 */
public interface HW4_Interface {

    void BuildHash(String filename, int size);

    long ConvertInt(String mystring);

    int FindHash(long myvalue);

    void InsertHash(String mystring);

    void Display(String Outputfile);

    int NumofWord(String myword);

    String ShowMax();

    int CheckWord(String myword);

    void Sort(String Outfile);
}
