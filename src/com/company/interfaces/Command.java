package com.company.interfaces;
/**
 * the Command interface
 */
import com.company.exceptions.CommandException;
import com.company.model.Network;

public interface Command {
    void execute(Integer ID1, Integer ID2, Network net, String criterion) throws CommandException;
}
