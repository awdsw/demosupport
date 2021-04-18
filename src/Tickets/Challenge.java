package Tickets;

import strategy.Operator;

import java.io.IOException;

public interface Challenge {

    void getDate();

    void enableWriting() throws IOException;

    //void getAgents() throws IOException;

    //void processTickets() throws IOException;

}
