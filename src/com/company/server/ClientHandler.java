package com.company.server;

import java.io.*;
import java.net.Socket;

public class ClientHandler implements Runnable{

    private Socket client;

    public ClientHandler(Socket socket){

        this.client = socket;

    }

    @Override
    public void run() {

        try {

            //wait for 20s before executing rest of the code
            Thread.sleep(30000);

            //receive some data
            InputStream inputStream = client.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            DataOutputStream outputStream = new DataOutputStream(client.getOutputStream());

            //continuous reading data from client
            String inputData;
            while ((inputData = bufferedReader.readLine()) != null){

                System.out.println("Client says: " + inputData);

                //send data to client
                //use scanner class to capture input
                switch (inputData){

                    case "Hello From the Client.":
                        outputStream.writeBytes("Hello from the server...\n");
                        break;
                    case "How are you?":
                        outputStream.writeBytes("I'm fine,How are you?\n");
                        break;
                    case "I'm fine":
                        outputStream.writeBytes("Okay Good to know\n");
                        break;
                    case "Thank you":
                        outputStream.writeBytes("You are welcome\n");
                        break;
                    default:
                        outputStream.writeBytes("I didn't understand that. \n");

                }

                if (inputData.equals("Exit")){
                    break;
                }
            }

            this.client.close();

        }

        catch (InterruptedException | IOException e){

            e.printStackTrace();

        }

    }

    //two ways to create thread
    //1- Extend the class using Thread Supper class
    //2- Implement the class using Runnable Interface



}
