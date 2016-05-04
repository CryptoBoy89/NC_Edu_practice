package com.company.objects;

import com.company.interfaces.PathElement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Cable extends PassiveElement {
    private double timeDelay; //milliseconds
    private double costs; // dollars
    private Integer ID;
    private List<PathElement> elementsConnection = new ArrayList<>();
    private String info = "An electrical cable is made of two or more wires running side by side and bonded, twisted, " +
            "or braided together to form a single assembly, the ends of which can be connected to two devices, " +
            "enabling the transfer of electrical signals from one device to the other.";

    public Cable(Integer ID, double timeDelay, double costs) {
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
        return "Cable{" +
                "ID=" + ID +
                '}';
    }

}
