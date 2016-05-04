package com.company.interfaces;
/**
 *
 */
import java.util.Collection;

public interface PathElement {
    double getTimeDelay();
    double getCosts();
    Collection<PathElement> getConnections();
    String getInfo();
    Integer getID();
}
