package com.company.exceptions;
/**
 * @author Maxim
 */
public class CommandException extends Exception {

    public CommandException(String str){
        super(str);
    }

    public CommandException(){
        super();
    }
}
