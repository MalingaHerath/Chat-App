package com.company.client;

import java.io.IOException;

public class ChatClient2 {

    public static void main(String[] args) throws IOException {

        Client client = new Client();
        client.start();

        //scanner class to input message
        client.sendMessage("Hello From the Client.");
        client.sendMessage("How are you?");
        client.sendMessage("I'm fine");
        client.sendMessage("Thank you");
        client.sendMessage("Exit");

        System.out.println("Client finished the execution...");


    }

}
