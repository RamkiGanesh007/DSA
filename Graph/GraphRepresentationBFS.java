import java.util.*;

class GraphRepresentationBFS {

    public static void bfs(ArrayList<ArrayList<Integer>> adj, int v) {
        boolean visited[] = new boolean[v];
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        visited[0] = true;
        while (!q.isEmpty()) {
            int cv = q.poll();
            System.out.print(cv + " ");
            for (Integer n : adj.get(cv)) {
                if (!visited[n]) {
                    visited[n] = true;
                    q.add(n);
                }
            }
        }
    }

    public static void bfsrecursive(ArrayList<ArrayList<Integer>> adj, Queue<Integer> q, boolean[] visited) {
        if (q.isEmpty()) {
            return;
        }
        int v = q.poll();
        visited[v] = true;
        System.out.print(v + " ");
        for (int u : adj.get(v)) {
            if (!visited[u]) {
                visited[u] = true;
                q.add(u);
            }
        }
        bfsrecursive(adj, q, visited);
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int v = scn.nextInt();
        for (int i = 0; i < v; i++)
            adj.add(new ArrayList<>());

        adj.get(0).add(1);
        adj.get(1).add(0);

        adj.get(0).add(2);
        adj.get(2).add(0);

        adj.get(2).add(3);
        adj.get(3).add(2);

        adj.get(1).add(2);
        adj.get(2).add(1);

        adj.get(3).add(3);

        boolean visited[] = new boolean[v];
        Queue<Integer> q = new LinkedList();
        q.add(0);
        bfs(adj, v);
        System.out.println();
        bfsrecursive(adj, q, visited);

        scn.close();
    }
}