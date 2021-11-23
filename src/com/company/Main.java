package com.company;
//did this work?
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static String ticketHolders[][] = new String[2][100];
    static int ticketsAvailable[] = new int[100];

    public static String getInput(String prompt) {
        String input = "";
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println(prompt);
            input = bufferedReader.readLine();
        } catch (Exception e) {
            System.out.println("incorrect input");
            System.out.println(e);
        }
        return (input);
    }

    public static void getTicket(){

    }

    public static void checkTicket() {

    }




    private static void menu() {
        String answer = "";
        for (int i = 0; i < 100; i++) {
            ticketsAvailable[i] = i;
        }
        try {
            while (true) {
                answer = getInput("would you like to enter a ticket number or get a ticket? (type 'enter' or 'get'");
                switch (answer) {
                    case "enter":
                        System.out.println("-entering ticket-");
                        break;
                    case "get":
                        System.out.println("-getting ticket-");
                        break;
                    default:
                        System.out.println("enter get or enter");
                        System.exit(0);
                }
            }
        } catch (Exception e) {
            System.out.println("incorrect input");
            System.out.println(e);
        }
        if (answer.equals("get")) {
            getTicket();
        }
        if (answer.equals("enter")) {
            checkTicket();
        }
    }

    public static void main(String[] args) {
        boolean run = true;
        while (run == true) {
            String again = getInput("would you like to enter/get another ticket");
            if (again.equals("yes")) {
                menu();
            }
            if (again.equals("yes")) {
                run = false;
            }
        }
    }





}
