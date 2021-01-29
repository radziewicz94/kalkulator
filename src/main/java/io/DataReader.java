package io;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DataReader {
    private Scanner sc = new Scanner(System.in);

    public double getDouble(){
        try {
            double number = sc.nextDouble();
            return number;
        }catch (InputMismatchException e){
            throw new InputMismatchException("Błędny format danych");
        }finally {
            sc.nextLine();
        }
    }
    public int getInt(){
        try {
            int number = sc.nextInt();
            return number;
        }catch (InputMismatchException e){
            throw new InputMismatchException("Błędny format danych");
        }finally {
            sc.nextLine();
        }
    }
    public void closeScanner(){
        sc.close();
    }
}
