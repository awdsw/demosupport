package com.company;

import Tickets.Challenge;
import Tickets.TechSupportSystem;
import strategy.Operator;

import java.io.*;
import java.util.LinkedList;


import java.io.IOException;


public class Main {
    private static LinkedList<Integer> calls = new LinkedList<>();
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static Challenge challenge;

    public static boolean isOperator(LinkedList<Operator> Id) {
        boolean isOperator = true;
        for (Operator operator : Id) {
            if (operator.getId().equals("1"))
                return isOperator;
        }
        return true;
    }

    /*public static void changeAgent() throws IOException {
       // if (isOperator("1")) {

        }
    }*/


    public static void main(String[] args) throws IOException {
        TechSupportSystem tcc = new TechSupportSystem("FAQ.txt");
        Operator operator = new Operator();
        LinkedList<Operator> agent = new LinkedList<>();
        agent.add(new Operator("1", "Артем", "Оператор 1"));
        agent.add(new Operator("2", "Виктор", "Оператор 2"));
        agent.add(new Operator("3", "Ирина", "Оператор 3"));
        agent.add(new Operator("4", "Вадим", "Оператор 4"));
        /*ArrayList<User> client = new ArrayList<>();
        client.add(new User("Алефтина","89999999999","a@mail.ru"));
        ArrayList<Ticket> ticket = new ArrayList<>();
        ticket.add(new Ticket(""))*/

        System.out.println("----------------------------------------\n"
                + "Приветствуем вас в службе тех поддержки!\n" +
                "Сделайте вызов оператора или посмотрите FAQ!!!\n" +
                "----------------------------------------");
        String choice;
        do {
            System.out.println("Выберите: \n - 1 - Вызвать специалиста \n - 2 - Посмотреть FAQ \n - 3 - Посмотреть лог чата");
            String makeChoice = reader.readLine();
            if (makeChoice.equals("1")) {
                System.out.println("Здраствуйте, я ваш специалист" + ", меня зовут " + operator.getOperatorID(agent, "1") + "," + " можете задать вопрос!");
                System.out.println("Задать вопрос: ");
                choice = reader.readLine();
                System.out.println("Подождите....");
                while (true) {
                    System.out.println("\n - 1 - Принять \n - 2 - Перенаправить другому специалисту \n - 3 - Завершить и записать");
                    String makeChoice1 = reader.readLine();
                    if (makeChoice1.equals("1")) {
                        System.out.println("Ответ на вопрос: ");
                        choice = reader.readLine();
                    } else if (makeChoice1.equals("2")) {
                        System.out.println("----");
                    } else if (makeChoice1.equals("3")) {
                        System.out.println("Завершить и записать");
                        break;
                    }
                }
            } else if (makeChoice.equals("2")) {
                System.out.println("Чтение из файла");
                System.out.println(tcc.read());
            } else if (makeChoice.equals("3")) {
                System.out.println("Посмотреть лог чата");
            }

        } while (true);
    }
}