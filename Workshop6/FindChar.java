import java.io.*;
import java.util.Scanner;

/**
 * Write a program that finds all occurrences of char x in a file.
 * Print the line number, where the char x is found,
 * and the number of  occurrences  in that line.
 * */
class FindChar {
    public static void main(String[] args) throws IOException {
        if (args.length != 2)
            throw new IllegalArgumentException("use: java FincChar char file");

        // the character in a file
        int match = args[0].charAt(0);
        System.out.println(match);
        FileReader fileIn = new FileReader(args[1]);
        LineNumberReader in = new LineNumberReader(fileIn);

        int ch;
        while ((ch = in.read()) != -1) {
            if (ch == match) {
                System.out.println("'" + (char) ch + "' at line " + in.getLineNumber());
                in.close();
                //return; fine only the first one
            }
        }
        System.out.println((char) ch + " not found ");
        in.close();
    }
}
