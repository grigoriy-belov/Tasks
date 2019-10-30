package lesson19;

import java.io.*;
import java.util.*;

public class PathApp {
    public static void main(String[] args) {

        try (BufferedReader br = new BufferedReader(new FileReader("misc\\files\\input.txt"));
             BufferedWriter writer = new BufferedWriter(new FileWriter("misc\\files\\output.txt"))) {

            Graph graph = null;

            Map<String, Map<Integer, Integer>> cityMap = new LinkedHashMap<>();
            List<String> sources = new ArrayList<>();
            List<String> targets = new ArrayList<>();

            for (int numberOfCities = Integer.parseInt(br.readLine()); numberOfCities > 0; numberOfCities--) {
                String cityName = br.readLine();
                Map<Integer, Integer> neighbours = new HashMap<>();

                for (int numberOfNeighbours = Integer.parseInt(br.readLine()); numberOfNeighbours > 0; numberOfNeighbours--) {
                    String[] line = br.readLine().split(" ");
                    int neighbourIndex = Integer.parseInt(line[0]);
                    int cost = Integer.parseInt(line[1]);
                    neighbours.put(neighbourIndex, cost);
                }

                cityMap.put(cityName, neighbours);
            }

            for (int pathQty = Integer.parseInt(br.readLine()); pathQty > 0; pathQty--) {
                String[] names = br.readLine().split(" ");
                sources.add(names[0]);
                targets.add(names[1]);
            }

            for (int i = 0; i < sources.size(); i++) {
                Node source = null;
                Node target = null;
                graph = initializeGraphAndNodes(cityMap);
                for (Node city : graph.getNodes()) {
                    if (source != null && target != null) break;
                    if (city.getName().equals(sources.get(i))) {
                        source = city;
                    }
                    if (city.getName().equals(targets.get(i))) {
                        target = city;
                    }
                }
                ShortestPathCalculator.calculateShortestPathsFromSource(graph, source);
                writer.write(String.valueOf(graph.getTargetDistance(target)));
                writer.newLine();
            }

        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    public static Graph initializeGraphAndNodes(Map<String, Map<Integer, Integer>> cityMap) {
        Graph graph = new Graph();
        List<Node> cityList = new ArrayList<>();
        for (Map.Entry<String, Map<Integer, Integer>> stringMapEntry : cityMap.entrySet()) {
            String cityName = stringMapEntry.getKey();
            Node currentNode = new Node(cityName);
            graph.addNode(currentNode);
            cityList.add(currentNode);
        }

        int count = 0;
        for (Map.Entry<String, Map<Integer, Integer>> stringMapEntry : cityMap.entrySet()) {
            Node city = cityList.get(count);
            for (Map.Entry<Integer, Integer> entry : stringMapEntry.getValue().entrySet()) {
                Node neighbour = cityList.get(entry.getKey() - 1);
                int distance = entry.getValue();
                city.addDestination(neighbour, distance);
            }
            count++;
        }
        return graph;
    }
}
