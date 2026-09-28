class Solution {
    public int[] findOrder(int n, int[][] p) {
        int[] ans = new int[n];
        List<List<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[n];
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : p){
            int u = edge[0];
            int v = edge[1];

            adj.get(v).add(u);
            indegree[u]++;
        }
        Queue<Integer> q = new ArrayDeque<>();
        for(int i = 0; i < n; i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }
        int idx = 0;
        while(!q.isEmpty()){
            int node = q.poll();
            ans[idx++] = node;

            for(Integer nbr : adj.get(node)){
                indegree[nbr]--;
                if(indegree[nbr] == 0){
                    q.offer(nbr);
                }
            }
        }
        if(idx != n){
            return new int[0];
        }
        return ans;
    }
}