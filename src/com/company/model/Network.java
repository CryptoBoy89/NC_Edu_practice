package com.company.model;
/**
 * Receiver class
 */
import com.company.interfaces.PathElement;
import com.company.objects.*;
import java.io.Serializable;
import java.util.*;

public class Network implements Serializable {

    private int numberOfNodes;
    private int numberOfEdges = 48;
    private Cable cable1 = new Cable(2, 0.122, 0.05);
    private Cable cable2 = new Cable(4, 0.98, 0.09);
    private Cable cable3 = new Cable(6, 0.211, 0.07);
    private Cable cable4 = new Cable(8, 0.141, 0.03);
    private Cable cable5 = new Cable(10, 0.84, 0.06);
    private Cable cable6 = new Cable(12, 0.162, 0.02);
    private Cable cable7 = new Cable(14, 0.76, 0.02);
    private Cable cable8 = new Cable(16, 0.232, 0.13);
    private Cable cable9 = new Cable(18, 0.111, 0.07);
    private Cable cable10 = new Cable(20, 0.87, 0.04);
    private Cable cable11 = new Cable(21, 0.17, 0.03);
    private Cable cable12 = new Cable(22, 0.97, 0.08);
    private PC pc1 = new PC(5, 10.5, 0.45, new IPAddress("78.193.0.104"));
    private PC pc2 = new PC(7, 9.21, 0.55, new IPAddress("92.193.0.101"));
    private PC pc3 = new PC(11, 8.67, 0.32, new IPAddress("88.196.0.142"));
    private PC pc4 = new PC(13, 7.99, 0.62, new IPAddress("65.163.0.182"));
    private PC pc5 = new PC(17, 11.8, 0.61, new IPAddress("199.170.0.99"));
    private PC pc6 = new PC(19, 6.25, 0.42, new IPAddress("114.132.0.93"));
    private Switch aSwitch = new Switch(3, 5.87, 0.18, new IPAddress("195.120.0.102"));
    private Firewall firewall = new Firewall(1, 0.13, 0.32, new IPAddress("108.102.0.96"));
    private Hub hub = new Hub(9, 2.17, 0.14);
    private Router router = new Router(15, 4.25, 0.25, new IPAddress("192.168.0.101"));
    private PathElement[] pathElements;
    private ArrayList<PathElement> adj[];
    private ArrayList<Double> weight[];

    public Network() {
        initData();
    }

    //Network init
    private void initData() {
        firewall.setElementsConnection(cable1);
        cable1.setElementsConnection(firewall, aSwitch);
        aSwitch.setElementsConnection(cable1, cable2, cable3, cable8);
        cable2.setElementsConnection(aSwitch, pc1);
        pc1.setElementsConnection(cable2);
        cable3.setElementsConnection(aSwitch, pc2);
        pc2.setElementsConnection(cable3, cable4);
        cable4.setElementsConnection(pc2, hub);
        hub.setElementsConnection(cable4, cable5, cable11);
        cable5.setElementsConnection(hub, pc3, cable6);
        pc3.setElementsConnection(cable5, cable9);
        cable6.setElementsConnection(cable5, pc4);
        pc4.setElementsConnection(cable6, cable7);
        cable7.setElementsConnection(pc4, router);
        router.setElementsConnection(cable7, cable8, cable11);
        cable8.setElementsConnection(aSwitch, router);
        pc5.setElementsConnection(cable9, cable12);
        cable9.setElementsConnection(pc3, pc5);
        pc6.setElementsConnection(cable10);
        cable10.setElementsConnection(pc6, cable11);
        cable11.setElementsConnection(hub, router, cable10, cable12);
        cable12.setElementsConnection(pc5, cable11);
        pathElements = new PathElement[]{firewall, cable1, aSwitch, cable2, pc1, cable3, pc2, cable4, hub, cable5, pc3, cable6,
                pc4, cable7, router, cable8, pc5, cable9, pc6, cable10, cable11, cable12};

        this.numberOfNodes = pathElements.length;
        /**
         *adjacency list init
         */
        adj = new ArrayList[this.numberOfNodes];
        Collection<PathElement> pathElementCollection;
        for (int i = 0; i < this.numberOfNodes; ++i) {
            pathElementCollection = pathElements[i].getConnections();
            adj[i] = new ArrayList<PathElement>(pathElementCollection);
        }

        /**
         *  list of the edges weight init
         */
        weight = new ArrayList[this.numberOfNodes];
        for (int i = 0; i < this.numberOfNodes; ++i) {
            weight[i] = new ArrayList<Double>();
        }

    }

    public int getNumberOfNodes() {
        return numberOfNodes;
    }

    public int getNumberOfEdges() {
        return numberOfEdges;
    }

    public ArrayList<PathElement>[] getAdj() {
        return adj;
    }

    public ArrayList<Double>[] getWeight() {
        return weight;
    }

    public PathElement[] getPathElements() {
        return pathElements;
    }

    public Map<Integer, PathElement> getElements() {

        return new HashMap<Integer, PathElement>(){{
                for(PathElement element : pathElements)
                    put(element.getID(), element);
            }};
    }

}