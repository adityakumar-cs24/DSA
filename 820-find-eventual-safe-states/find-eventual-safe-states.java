class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V = graph.length;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < V; i++){
            adj.add(new ArrayList<>());
        }
        int[] indegree = new int[V];
        for(int u = 0; u < V; u++) {

            for(int v : graph[u]) {

                adj.get(v).add(u);
                indegree[u]++;
            }
        }
        Queue<Integer> q = new ArrayDeque<>();
        for(int i = 0; i < V; i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }
        while(!q.isEmpty()){
            int node = q.poll();
            for(Integer nbr : adj.get(node)){
                indegree[nbr]--;
                if(indegree[nbr] == 0){
                    q.offer(nbr);
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < V; i++){
            if(indegree[i] == 0){
                ans.add(i);
            }
        }
        return ans;
    }
}