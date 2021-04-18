
package Tickets;

import com.company.Main;
import strategy.Operator;
import strategy.User;

import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

public class TechSupportSystem implements Challenge {

    private Scanner scanner;
    private Scanner input;
    private PrintWriter output;
    private FileWriter fileWriter;
    private File file;
    private String date;
    private Operator agentOne;
    private Operator agentTwo;
    private Operator agentThree;
    private int numTickets;

    public TechSupportSystem(String path) throws IOException {
        file = new File(path);
        fileWriter = new FileWriter(file, false);
        scanner = new Scanner(file);
        fileWriter.write("");
            /*scanner = new Scanner(System.in);
            output.close();
            System.out.println("\nTotal tickets processed: " + Ticket.getTicketNumber());
            System.out.println("\nTotal tickets assigned: " + numTickets);*/
    }
    public static String getOperatorID(LinkedList<Operator> ID, String id) {
        for (Operator operator : ID) {
            if (operator.getId().equals(id))
                return operator.getName();

        }
        return null;
    }

    public String read() throws FileNotFoundException {
        scanner = new Scanner(file);
        scanner.useDelimiter("//");
        return scanner.next();
    }

    public void write(String text) throws IOException {
        fileWriter.append(text + " ");
        fileWriter.flush();
    }

    @Override
    public void getDate() {
        date = "";
        while (date.length() != 8) {
            System.out.println("Enter today's date(MMDDYYYY format): ");
            date = scanner.nextLine();
        }
    }

    public boolean openFile(String fileName) {
        file = new File(fileName);
        return file.exists();
    }

    @Override
    public void enableWriting() throws IOException {
        fileWriter = new FileWriter("commit.txt", true);
        output = new PrintWriter(fileWriter);

        output.println("-----------------");
        output.println("Ticket Report for " + date);
        output.println("-----------------\n");
    }

    /*@Override
    public void getAgents() throws IOException {
        String fileName;
        do {
            System.out.print("Enter name of the agent: ");
            fileName = scanner.nextLine();
        } while (!openFile(fileName));
        input = new Scanner(file);
        agentOne = readAgent();
        agentTwo = readAgent();
        agentThree = readAgent();

        input.close();
    }*/

    public Operator readAgent() {
        String name = input.nextLine();
        String id = input.nextLine();
        String specialist = input.nextLine();
        input.nextLine();
        return new Operator(name, id, specialist);
    }

    /*@Override
    public void processTickets() throws IOException {
        String fileName;
        Ticket currentTicket;
        Ticket lastTicket = null;

        do {
            System.out.print("Enter the name of the ticket: ");
            fileName = scanner.nextLine();
        } while (!openFile(fileName));
        System.out.println();

        input = new Scanner(file);
        while (input.hasNext()) {
            currentTicket = readTicket();
            if (lastTicket == null || !currentTicket.equals(lastTicket)) {
                assign(currentTicket);
                output.println(currentTicket + " \n");
            }
            lastTicket = currentTicket;
        }
        input.close();
    }*/

    private Ticket readTicket() {
        User request;
        String description;

        request = readClient();
        description = input.nextLine();
        input.nextLine();

        return new Ticket(date, description, request);
    }

    private User readClient() {
        String name;
        String phone;
        String email;

        name = input.nextLine();
        phone = input.nextLine();
        email = input.nextLine();
        if (email.length() == 0) {
            return new User(name, phone, email);
        } else {
            return new User(name, phone, email);
        }

    }

    private void assign(Ticket ticket) {
        User request = ticket.getRequest();
        String email = request.getEmail();
        Operator assign;

        if (agentOne.getSpecialist().equals(email)) {
            assign = agentOne;
        } else if (agentTwo.getSpecialist().equals(email)) {
            assign = agentTwo;
        } else {
            assign = agentThree;
        }
        ticket.setAgent(assign);
        System.out.println("ticket asiggned to " + assign.getName() + ".");
        numTickets++;
    }
}
