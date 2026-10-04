class Solution {
    public int makeConnected(int n, int[][] connections) {
       if(connections.length < n - 1){
            return -1;
       }
       List<List<Integer>> adj = new ArrayList<>();
       for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
       }
       for(int[] edge : connections){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
       }
       boolean[] visited = new boolean[n];
       int count = 0;
       for(int i = 0; i < n; i++){
            if(!visited[i]){
                dfs(i, adj, visited);
                count++;
            }
       }
       return count - 1;
    }

    void dfs(int node, List<List<Integer>> adj, boolean[] visited) {
        visited[node] = true;
        for (Integer nbr : adj.get(node)) {
            if (!visited[nbr]) {
                dfs(nbr, adj, visited);
            }
        }
    }
}