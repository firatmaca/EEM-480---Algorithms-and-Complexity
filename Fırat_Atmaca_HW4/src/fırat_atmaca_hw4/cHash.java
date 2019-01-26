/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fırat_atmaca_hw4;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author firat
 */
public class cHash implements HW4_Interface {

    Node first;
    int sizem;
    Node[] hasharr;
    int yer = 0;
    int t = 0;

    public cHash() {
        first = null;
    }

    @Override
    public void BuildHash(String filename, int size) {
        try {
            sizem = size;
            hasharr = new Node[sizem];

            for (int j = 0; j < sizem; j++) {

                hasharr[j] = new Node();

            }

            File file = new File(filename);
            Scanner f = new Scanner(new FileReader(file));

            if (first == null) {
                Node newNode = new Node();
                newNode.key = f.next();
                long a = ConvertInt(newNode.key.toString());
                newNode.value = FindHash(a);
                InsertHash(newNode.key.toString());
                newNode.next = first;
                first = newNode;
            }

            while (f.hasNext() != false) {

                Node dummy;
                dummy = first;
                while (dummy.next != null) {

                    dummy = dummy.next;
                }

                Node newNode = new Node<>();
                newNode.key = f.next();
                long b = ConvertInt(newNode.key.toString());
                newNode.value = FindHash(b);
                InsertHash(newNode.key.toString());

                newNode.next = dummy.next;
                dummy.next = newNode;

            }

        } catch (FileNotFoundException a) {
            System.out.println("yanlış");
        }
    }

    @Override
    public long ConvertInt(String mystring) {

        long toplam = 0;
        int a;
        char[] convert = new char[mystring.length()];
        convert = mystring.toCharArray();
        for (int i = 0; i < mystring.length(); i++) {
            a = i * i + 5 * i + 11;
            char x = convert[i];
            int ascii = x;
            toplam += a * ascii;
        }
        return toplam;
    }

    @Override
    public int FindHash(long myvalue) {
        myvalue = myvalue % sizem;
        int i = (int) myvalue;
        return i;
    }
    Node tmppnode;

    @Override
    public void InsertHash(String mystring) {

        long c = ConvertInt(mystring);
        int d = FindHash(c);

        Node dumy;
        dumy = hasharr[d];

        if (hasharr[d].key == null) {
            yer++;
            hasharr[d].position = yer;
            hasharr[d].key = mystring;
            hasharr[d].value = d;
            t = 1;
            hasharr[d].tekar = t;

        } else {
            while (dumy != null) {

                Long converted = ConvertInt((String) dumy.key);
                if (converted == c) {

                    yer++;
                    dumy.tekar = dumy.tekar + 1;
                    break;
                } else if (dumy.next != null) {
                    dumy = dumy.next;
                } else {
                    Node np = new Node();
                    yer++;
                    np.position = yer;
                    np.key = mystring;
                    np.value = d;
                    np.tekar = 1;
                    np.next = hasharr[d];
                    hasharr[d] = np;
                    break;

                }

            }

        }

    }

    @Override
    public void Display(String Outputfile) {
        try {
            FileWriter file = new FileWriter(Outputfile);
            BufferedWriter yaz = new BufferedWriter(file);

            Node dumy = new Node();
            for (int i = 0; i < sizem; i++) {
                dumy = hasharr[i];
                if (hasharr[i] != null) {
                    while (dumy != null) {

                        String yazılacak = (String) dumy.key;
                        String bb = String.valueOf(dumy.tekar);
                        if (yazılacak != null) {
                            yaz.write(yazılacak);

                            yaz.write(" " + bb);
                            yaz.newLine();

                        }
                        dumy = dumy.next;
                    }

                }

            }
            System.out.println(Outputfile + "dosyasına yazıldı");

            if (yaz != null) {
                yaz.close();
            }
            if (file != null) {
                file.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public int NumofWord(String myword) {
        long c = ConvertInt(myword);
        int d = FindHash(c);
        if (hasharr[d].key != null) {
            Node dumy = new Node();
            dumy = hasharr[d];
            while (dumy != null) {
                if (c == ConvertInt(dumy.key.toString())) {
                    System.out.println(myword + " adeti: " + dumy.tekar);
                    return dumy.tekar;
                } else if (dumy.next == null) {
                    break;
                }

                dumy = dumy.next;
            }
            return -1;
        } else {
            return -1;
        }

    }

    @Override
    public String ShowMax() {
        String a = "";
        int max = 0;
        Node dumy = new Node();

        for (int i = 0; i < sizem; i++) {
            dumy = hasharr[i];
            if (hasharr[i] != null) {
                while (dumy != null) {
                    if (dumy.tekar > max) {
                        max = dumy.tekar;
                        a = dumy.key.toString();

                        break;
                    }
                    dumy = dumy.next;
                }

            } else {
                return null;
            }
        }
        return a;
    }

    @Override
    public int CheckWord(String myword) {
        long c = ConvertInt(myword);
        int d = FindHash(c);
        if (hasharr[d].key != null) {
            Node dumy = new Node();
            dumy = hasharr[d];
            while (dumy != null) {
                if (c == ConvertInt(dumy.key.toString())) {
                    System.out.println(myword + " pozisyonu: " + dumy.position);
                    return (int) dumy.position;
                } else if (dumy.next == null) {
                    break;
                }

                dumy = dumy.next;
            }
            return -1;
        } else {
            return -1;
        }

    }

    @Override
    public void Sort(String Outfile) {
        int maxrep = repeatMax();
        try {
            FileWriter file = new FileWriter(Outfile);
            BufferedWriter yaz = new BufferedWriter(file);

            Node dumy = new Node();
            int j = 1;
            while (j <= maxrep) {
                for (int i = 0; i < sizem; i++) {
                    dumy = hasharr[i];

                    if (hasharr[i] != null) {
                        while (dumy != null) {

                            String yazılacak = (String) dumy.key;
                            String bb = String.valueOf(dumy.tekar);
                            if (yazılacak != null) {
                                if (dumy.tekar == j) {
                                    yaz.write(yazılacak);
                                    yaz.write(" " + bb);
                                    yaz.newLine();
                                }
                            }
                            dumy = dumy.next;
                        }

                    }

                }

                j++;
            }
            System.out.println(Outfile + "dosyasına sort yazıldı");

            if (yaz != null) {
                yaz.close();
            }
            if (file != null) {
                file.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private int Integer(Object value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private String String(int tekar) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int repeatMax() {

        int max = 0;
        Node dumy = new Node();

        for (int i = 0; i < sizem; i++) {
            dumy = hasharr[i];
            if (hasharr[i] != null) {
                while (dumy != null) {
                    if (dumy.tekar > max) {
                        max = dumy.tekar;

                        break;
                    }
                    dumy = dumy.next;
                }

            } else {
                return -1;
            }
        }
        return max;
    }

}
