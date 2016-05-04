package com.company.main;
/**
 * the Invoker class
 */
import com.company.exceptions.CommandException;
import com.company.model.Network;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Initializer {

    public static void init(Network network) throws IOException, CommandException {

        String choice;
        System.out.println("Notes : Enter the 1st ID of the element, then the 2nd ID after 'route'. Then - name of" +
                " the network.\nPress any key for default search criterion or enter 'costs' for another search criterion.");

         try (BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))) {
             String criterion = bf.readLine(); //Choose a criterion search
                 do {
                     System.out.print("route ");
                     StringTokenizer tokenizer = new StringTokenizer(bf.readLine());
                     int id1 = Integer.parseInt(tokenizer.nextToken()); //reading ID for the first node
                     int id2 = Integer.parseInt(tokenizer.nextToken()); //reading ID for the second node
                     String nameOfTheNet = tokenizer.nextToken();
                     if (nameOfTheNet.equalsIgnoreCase("Network")) {
                         PluginLoader.loadPlugin(id1, id2, network, criterion);
                         System.out.println("\nPress any key to continue or 'n' to exit");
                         choice = bf.readLine();
                     }
                     else{
                         System.out.println("Invalid name" + "\nPress any key to continue or 'n' to exit");
                         choice = bf.readLine();
                     }

                 } while (!choice.equalsIgnoreCase("n"));
         }
    }
}
