/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Validation {

    public static Scanner sc = new Scanner(System.in);

    public static String inputString(String msg) {
        System.out.println(msg);
        while (true) {
            String name = sc.nextLine();
            if (!name.isEmpty()) {
                return name;
            }
            System.err.println("Empty is not allowed");
        }
    }

    public static int inputInt(String msg) {
        System.out.println(msg);
        while (true) {
            try {
                int number = Integer.parseInt(sc.nextLine());
                if (number >= 0) {
                    return number;
                }
                System.err.println("Please input a number greater than 0");
            } catch (Exception e) {
                System.err.println("Please input a number");
            }
        }
    }

    public static double inputDouble(String msg) {
        System.out.println(msg);
        while (true) {
            try {
                double number = Double.parseDouble(sc.nextLine());
                if(number >= 0){
                    return number;
                }
                System.err.println("Please input a number greater than 0");
            } catch (Exception e) {
                System.err.println("Please input a number");
            }
        }
    }
}
