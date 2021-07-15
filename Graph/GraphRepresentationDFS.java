import java.util.*;

class GraphRepresentationDFS {

    public static void dfs(ArrayList<ArrayList<Integer>> adj, int v) {
        Stack<Integer> stk = new Stack<>();
        boolean visited[] = new boolean[v];
        stk.push(0);
        while (!stk.empty()) {

            int ele = stk.pop();
            if (!visited[ele]) {
                System.out.print(ele + " ");
                visited[ele] = true;
            }

            for (Integer i : adj.get(ele)) {
                if (visited[i] != true) {
                    stk.push(i);
                }
            }
        }

    }

    public static void dfsrecursion(ArrayList<ArrayList<Integer>> adj, int v, boolean visited[]) {
        visited[v] = true;
        System.out.print(v + " ");
        for (Integer i : adj.get(v)) {
            if (visited[i] != true) {
                dfsrecursion(adj, i, visited);
            }
        }
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
        dfs(adj, v);
        System.out.println();
        dfsrecursion(adj, 0, visited);
        scn.close();
    }
}