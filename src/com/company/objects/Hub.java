package com.company.objects;

import com.company.interfaces.PathElement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Hub extends PassiveElement {
    private double timeDelay; //milliseconds
    private double costs; // dollars
    private Integer ID;
    private List<PathElement> elementsConnection = new ArrayList<>();
    private String info = "A Network hub is a network hardware device for connecting multiple Ethernet devices " +
            "together and making them act as a single network segment.";

    public Hub(Integer ID, double timeDelay, double costs) {
        if((ID < 0) || (timeDelay < 0) || (costs < 0)) {
            throw new IllegalArgumentException("Negative value of the parameter");
        }
        this.ID = ID;
        this.timeDelay = timeDelay;
        this.costs = costs;
    }

    @Override
    public double getTimeDelay() {
        return this.timeDelay;
    }

    @Override
    public double getCosts() {
        return this.costs;
    }

    public void setElementsConnection(PathElement... elements) {
        Collections.addAll(this.elementsConnection, elements);
    }

    @Override
    public Collection<PathElement> getConnections() {
        return this.elementsConnection;
    }

    @Override
    public String getInfo() {
        return this.info;
    }

    @Override
    public Integer getID() {
        return this.ID;
    }

    public void setTimeDelay(double timeDelay) {
        if(timeDelay < 0) {
            throw new IllegalArgumentException("Negative value of the parameter");
        }
        this.timeDelay = timeDelay;
    }

    public void setCosts(double costs) {
        if(costs < 0) {
            throw new IllegalArgumentException("Negative value of the parameter");
        }
        this.costs = costs;
    }

    @Override
    public String toString() {
        return "Hub{" +
                "ID=" + ID +
                '}';
    }
}
