package com.company.model;

import com.company.exceptions.RouteNotFoundException;
import com.company.interfaces.PathElement;
import com.company.interfaces.RouteProvider;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DijkstraAlgorithm implements RouteProvider {

    static int INF = Integer.MAX_VALUE / 2;
    private List<PathElement> foundElementList =  new ArrayList<>(); //list for a found route
    private boolean used[]; //an array for storing information about passed and not passed vertices
    private double dist[]; //an array for storing the distance from the starting vertex
    private int ancestry[]; // an array of ancestors, need to restore the shortest path from the starting vertex
    private Network net;
    private Integer ID2;

    private void dejkstra(Integer start) {
         int numberOfNodes = net.getNumberOfNodes();
         ArrayList<PathElement> adj[] = net.getAdj();
         ArrayList<Double> weight[] = net.getWeight();

         //Arrays init
         this.used = new boolean[numberOfNodes];
         Arrays.fill(used, false);

         this.ancestry = new int[numberOfNodes];
         Arrays.fill(ancestry, -1);

         this.dist = new double[numberOfNodes];
         Arrays.fill(dist, INF);
         /**
          *The shortest distance to the start Node is equal Zero
          */
        dist[start - 1] = 0;
        for (int iter = 0; iter < numberOfNodes; ++iter) {
            int v = -1;
            double distV = INF;
            /**
             * Choose the top Node, the shortest distance to which haven't found yet
             */
            for (int i = 0; i < numberOfNodes; ++i) {
                if (used[i]) {
                    continue;
                }
                if (distV < dist[i]) {
                    continue;
                }
                v = i;
                distV = dist[i];
            }
            /**
             *consider all edges emanating from a given node
             */
            for (int i = 0; i < adj[v].size(); ++i) {
                PathElement u = adj[v].get(i);
                int res = u.getID();
                res--;
                double weightU = weight[v].get(i);
                /**
                 * Node relaxation
                 */
                if (dist[v] + weightU < dist[res]) {
                    dist[res] = dist[v] + weightU;
                    ancestry[res] = v;
                }
            }
            /**
             *marking the top node, shortest distance is found
             */

            used[v] = true;
        }
    }

    /**
     *A restore procedure to the shortest path for the array of ancestors
     * @param v is ID param
     */
    private void printWay(int v) {
        if (v == -1) {
            return;
        }
        printWay(ancestry[v]);
        int id = v + 1;
        foundElementList.add(net.getElements().get(id));

    }
    /**
     *Data output procedure
     * @param ID2
     */
    private void printData(Integer ID2) {

        if (dist[ID2-1] != INF) {
            System.out.printf("***************Info***************" + "\nLatency: " + "%.3f", dist[ID2 - 1]);
        } else {
            System.out.println("None ");
        }

        System.out.println("\nA route to the current node: " + ID2);
        if (dist[ID2-1] != INF) {
            for (PathElement value : foundElementList) {
                System.out.print(value.getID() + " -> ");
            }
        }
    }

    /**
     * Get the list of elements which was founded
     * @param ID2 of the Node
     * @return <code> List<PathElement> list </code>
     */
    private List<PathElement> getElementList(Integer ID2) {
        if (dist[ID2-1] != INF) {
            printWay(ID2-1);
        }
        return foundElementList;
    }

    /**
     * Returns the list of elements which was founded
     * @param firstID
     * @param secondID
     * @param n
     * @param criterion
     * @return
     * @throws RouteNotFoundException
     */
    @Override
    public List<PathElement> getRoute(Integer firstID, Integer secondID, Network n, String criterion) throws RouteNotFoundException {
        if((firstID <= 0) || (firstID > 22) ||(secondID <= 0) || (secondID > 22)) {
            throw new IllegalArgumentException("Invalid ID");
        }
        this.net = n;
        this.ID2 = secondID;
        chooseCriterion(criterion);
        dejkstra(firstID);
        return getElementList(secondID);
    }


    /**
     * A procedure for choice criterion of a searching
     * @param criterion
     */
    private void chooseCriterion(String criterion) {
        int j = 0;
        for (int i = 0; i < net.getNumberOfEdges(); ++i) {
            if (j < net.getNumberOfNodes()) {
                for (int k = 0; k < net.getAdj()[i].size(); ++k) {
                    if (criterion.equalsIgnoreCase("costs")) {
                        net.getWeight()[i].add(net.getPathElements()[j].getCosts());
                    }
                    else net.getWeight()[i].add(net.getPathElements()[j].getTimeDelay());
                }
                j++;
            }
        }
    }
    /**
     *Show info about a network
     */
    @Override
    public void getDescription() {
        printData(this.ID2);
    }
}
