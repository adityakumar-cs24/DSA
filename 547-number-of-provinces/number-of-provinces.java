class Solution {
    public int findCircleNum(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        List<List<Integer>> adj = new ArrayList<>();
        boolean[] visited = new boolean[n];
        
        for(int i = 0; i < n; i++){
            List<Integer> temp = new ArrayList<>();
            for(int j = 0; j < m; j++){
                if(arr[i][j] == 1){
                    temp.add(j);
                }
            }
            adj.add(temp);
        }

        int count = 0;
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                count++;
                dfs(i, adj, visited);
            }
        }
        return count;
    }
    void dfs(int node, List<List<Integer>> adj, boolean[] visited){
        visited[node] = true;
        for(int nbr : adj.get(node)){
            if(!visited[nbr]){
                dfs(nbr, adj, visited);
            }
        }
    }
}