package com.company.main;
/**
 * Plugin loader
 */
import com.company.exceptions.CommandException;
import com.company.interfaces.Command;
import com.company.interfaces.PluginSearch;
import com.company.model.Network;
import java.io.IOException;
import java.util.ServiceLoader;

public class PluginLoader {
    private static ServiceLoader<Command> loader = ServiceLoader.load(Command.class);

    public static void loadPlugin(Integer id1, Integer id2, Network net, String criterion) throws CommandException, IOException {
        for(Command command : loader) {
            PluginSearch anno = command.getClass().getAnnotation(PluginSearch.class);
            if(anno.value().equalsIgnoreCase("init"))
                command.execute(id1, id2, net, criterion);
            else throw new CommandException("Command not found");
        }
    }
}
