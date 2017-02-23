package com.jedi.hackathons;

import com.jedi.hackathons.input.InputDto;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class App 
{
//    private static final String INPUT_FILE_NAME = "A-small-attempt4.in";
//    private static final String OUTPUT_FILE_NAME = "result.txt";

    public static void main(String[] args){

        //Open file connections
        Scanner in = null;
        BufferedWriter out = null;
        try{
            in = new Scanner(new File(args[0]));
            out = new BufferedWriter(new FileWriter(args[1] , false));
        }catch(Exception e){
            e.printStackTrace();
        }

        InputDto inputDto = readFile(in);

        //Variables
        String output = "";
        //Output and close
        try{
            out.write(output);
            in.close();
            out.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private static InputDto readFile(Scanner in) {
        return null;
    }
}
