package com.company;
import java.util.Random;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static String ticketHoldersNames[] = new String[100];
    static int ticketHoldersTickets[] = new int[100];
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
        Random random = new Random();
        String name = getInput("what is your first name?");
        boolean ticketGot = false;
        while (ticketGot == false) {
            int ticket = random.nextInt(100);
            if (ticketsAvailable[ticket] == -1) {
                System.out.println(". . .");
            }else {
                ticketsAvailable[ticket] = -1;
                ticketHoldersNames[ticket] = name;
                ticketHoldersTickets[ticket] = ticket;
                ticketGot = true;
            }
        }
    }

    public static void checkTicket() {
        String name = getInput("what is your first name?");
        boolean validTicket = false;
        boolean nameFound = false;
        int nameAt = -1;
        while (validTicket == false) {
            for (int i = 0; i < 100; i++) {
                if (ticketHoldersNames[i].equals(name)) {
                    nameFound = true;
                    nameAt = i;
                    break;
                }
            }
            if (nameFound == false) {
                break;
            }
            String ticketStr = getInput("what is your first name?");
            int ticket = Integer.parseInt(ticketStr);
            if (ticketHoldersTickets[nameAt] == ticket) {
                boolean winCheck = false;
                int primes[] = {2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97};
                for (int i = 0; i < 25; i++) {
                    if (primes[i] == ticket) {
                        winCheck = true;
                    }
                    if (winCheck == true) {
                        System.out.println("you win a prize!");
                    }else {
                        System.out.println("not a winning ticket this time");
                    }
                }
                validTicket = true;
            }else {
                System.out.println("that is not your ticket");
            }
        }
    }




    private static void menu() {
        String answer = "";
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
        for (int i = 0; i < 100; i++) {
            ticketsAvailable[i] = i;
        }
        boolean run = true;
        while (run == true) {
            String again = getInput("would you like to enter/get another ticket");
            if (again.equals("yes")) {
                menu();
            }
            if (again.equals("yes")) {
                run = false;
            }
        }}





}
