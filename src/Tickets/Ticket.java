package Tickets;

import strategy.Operator;
import strategy.User;

public class Ticket {
    private static int ticketNumber;
    private String id;
    private String description;
    private User request;
    private Operator assign;

    public Ticket(String date, String description, User request) {
        ticketNumber++;
        id = date + " " + ticketNumber;
        this.description = description;
        this.request = new User(request);
    }


    public static int getTicketNumber() {
        return ticketNumber;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public User getRequest() {
        return request;
    }

    public void setAgent(Operator assign) {

        String name = assign.getName();
        String id = assign.getId();
        String specialist = assign.getSpecialist();
        assign = new Operator(name, id, specialist);
        //this.assign = assign;
    }

    public String toString() {
        String data = "ID#: " + getId();
        data += "\nProblem: " + getDescription();
        data += "\n----Requsted----\n" + request;
        data += "\n----Assigned----\n" + assign;

        return data;
    }

    public boolean equals(Ticket other) {
        if (description.equals(other.description) && request.equals(other.request)) {
            return true;
        } else {
            return false;
        }
    }
}