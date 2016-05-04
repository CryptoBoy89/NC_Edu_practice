package com.company.exceptions;
/**
 * A RouteNotFoundException is thrown when there is no route between nodes of a network
 * @author  Maxim
 */
public class RouteNotFoundException extends CommandException {

    /**
     * Constructs a <code>RouteNotFoundException</code> with a detail message.
     *
     * @param   str   the detail message.
     */
    public RouteNotFoundException(String str) {
       super(str);
    }
    /**
     * Constructs an <code>IllegalArgumentException</code> with no
     * detail message.
     */
    public RouteNotFoundException() {
        super();
    }
}
