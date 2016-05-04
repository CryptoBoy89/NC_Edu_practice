package com.company.main;

import com.company.exceptions.CommandException;
import com.company.model.Network;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        /**
         * Serialization Network object
         */
        try(FileOutputStream out = new FileOutputStream(new File("data.dat"));
            ObjectOutput objOut = new ObjectOutputStream(out)) {
            objOut.writeObject(new Network());
            out.flush();
            objOut.flush();
        }

        /**
         * Deserialization Network object
         */
        try(FileInputStream in = new FileInputStream(new File("data.dat"));
            ObjectInput objIn = new ObjectInputStream(in)) {
            Network network = (Network)objIn.readObject();
                Initializer.init(network);

        } catch (ClassNotFoundException | CommandException e) {
            throw new RuntimeException();
        }
    }
}
