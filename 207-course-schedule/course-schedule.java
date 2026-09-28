class Solution {
    public boolean canFinish(int n, int[][] p) {
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

        while(!q.isEmpty()){
            int node = q.poll();
            for(Integer nbr : adj.get(node)){
                indegree[nbr]--;
                if(indegree[nbr] == 0){
                    q.offer(nbr);
                }
            }
        }
        for(int i = 0; i < n; i++){
            if(indegree[i] != 0){
                return false;
            }
        }
        return true;
    }
}