package com.jedi.hackathons;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class App 
{
    public static void main(String[] args){

        //Open file connections
        Scanner in = null;
        BufferedWriter out = null;
        try{
            in = new Scanner(new File("A-small-attempt4.in"));
            out = new BufferedWriter(new FileWriter("result.txt" , false));
        }catch(Exception e){
            e.printStackTrace();
        }


        //Variables
        int n;
        String output = "";
        //number of cases
        n = in.nextInt();
        for(int i = 0; i < n; i++){
            output += "Case #" + (i+1) + ": ";
            if(i != n-1) output += '\n';
        }


        //output and close
        try{
            out.write(output);
            in.close();
            out.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
