import java.util.*;

/**
 * PROBLEM 14: Most Connected Node  (time budget: 15 min)
 *
 * You are given a list of undirected connections between nodes, where
 * edges[i] = {a, b} means node a and node b are directly connected.
 * Return the node that has the most direct connections. If several nodes
 * tie, return the smallest node number.
 *
 * Examples:
 *   edges = [[1,2],[1,3],[2,3],[1,4]] -> 1
 *       (node 1 has 3 neighbours: 2, 3, 4)
 *   edges = [[1,2],[3,4]]             -> 1
 *       (all nodes have 1 neighbour, smallest is 1)
 *   edges = [[5,6],[5,7],[6,7],[7,8]] -> 7
 *       (node 7 has 3 neighbours: 5, 6, 8)
 *
 * Constraints:
 *   1 <= edges.length <= 100000
 *   1 <= a, b <= 100000, a != b
 *   No duplicate edges.
 *
 * Practice goal: build the adjacency list Map<Integer, List<Integer>>
 * using computeIfAbsent, then scan it for the answer.
 *
 * Write your solution in mostConnected, then run main to check.
 */
public class Problem14 {

    public static int mostConnected(int[][] edges) {
        Map<Integer,List<Integer>> map = new HashMap<>();
        for (int i = 0; i < edges.length; i ++){
            map.computeIfAbsent(edges[i][0],k -> new ArrayList<>()).add(edges[i][1]);
            map.computeIfAbsent(edges[i][1],k -> new ArrayList<>()).add(edges[i][0]);
        }
        int best = 0;
        int node = 0;
        for (Map.Entry<Integer,List<Integer>> j : map.entrySet()){
            if (best < j.getValue().size()){
                best = j.getValue().size();
                node = j.getKey();
            }if (best == j.getValue().size())
                node = Math.min(j.getKey(),node);
        }

        return node;
    }

    public static void main(String[] args) {
        check(mostConnected(new int[][]{{1, 2}, {1, 3}, {2, 3}, {1, 4}}), 1);
        check(mostConnected(new int[][]{{1, 2}, {3, 4}}), 1);
        check(mostConnected(new int[][]{{5, 6}, {5, 7}, {6, 7}, {7, 8}}), 7);
        check(mostConnected(new int[][]{{9, 2}}), 2);
    }

    private static void check(int actual, int expected) {
        System.out.println((actual == expected ? "PASS" : "FAIL")
                + " expected=" + expected
                + " actual=" + actual);
    }
}
