class Solution {
    int nd;
    int ed;
    public int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean[] visited = new boolean[n];
        int count = 0;

        for(int i = 0; i < n; i++){
            if(!visited[i]){
                nd = 0;
                ed = 0;
                dfs(i, adj, visited);

                ed /= 2;
                if(ed == nd * (nd - 1) / 2){
                    count++;
                }
            }
        }
        return count;
    }
    void dfs(int node, List<List<Integer>> adj, boolean[] visited){
        visited[node] = true;
        nd++;
        ed += adj.get(node).size();
        for(Integer nbr : adj.get(node)){
            if(!visited[nbr]){
                dfs(nbr, adj, visited);
            }
        }
    }
}