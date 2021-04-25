package strategy;

import java.util.LinkedList;

public class Operator {
    private String name;
    private String id;
    private String specialist;

    public Operator(String id, String name, String specialist) {
        this.name = name;
        this.id = id;
        this.specialist = specialist;
    }

    public Operator() {

    }

    public Operator copy() {
        Operator copyAgent = new Operator(name, id, specialist);
        return copyAgent;
    }

    public static String getOperatorID(LinkedList<Operator> ID, String id) {
        for (Operator operator : ID) {
            if (operator.getId().equals(id))
                return operator.getName();

        }
        return null;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getSpecialist() {
        return specialist;
    }

    public String toString() {
        String str = "Agent's name: " + this.name
                + "\nAgent's ID: " + this.id
                + "\nSupport specialty: " + this.specialist;
        return str;
    }
}
