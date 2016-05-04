package com.company.main;
/**
 * the Command for initialize algorithm
 */
import com.company.exceptions.CommandException;
import com.company.interfaces.Command;
import com.company.interfaces.PathElement;
import com.company.interfaces.PluginSearch;
import com.company.interfaces.RouteProvider;
import com.company.model.DijkstraAlgorithm;
import com.company.model.Network;
import java.util.List;

@PluginSearch(value = "init")
public class InitAlgorithm implements Command{

    @Override
    public void execute(Integer ID1, Integer ID2, Network network, String criterion) throws CommandException {
         RouteProvider provider = new DijkstraAlgorithm();
         List<PathElement> list = provider.getRoute(ID1, ID2, network, criterion);
         list.forEach(System.out::println);
         provider.getDescription();
    }
}
