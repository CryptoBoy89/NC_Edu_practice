package com.company.interfaces;

import com.company.exceptions.RouteNotFoundException;
import com.company.model.Network;
import java.util.List;

public interface RouteProvider {

    List<PathElement> getRoute(Integer firstID, Integer secondID, Network net, String criterion) throws RouteNotFoundException;
    void getDescription();
}
