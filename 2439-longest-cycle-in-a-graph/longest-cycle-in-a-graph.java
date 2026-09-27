class Solution {
    int maxLen = -1;
    public int longestCycle(int[] edges) {
        int V = edges.length;
        boolean[] visited = new boolean[V];
        int[] curPath = new int[V];
        
        for(int i = 0; i < V; i++){
            if(!visited[i]){
                dfs(i, edges, visited, curPath, 0);
            }
        }
        return maxLen;
    }
    void dfs(int node, int[] edges, boolean[] visited, int[] curPath, int cycleLen){
        cycleLen++;
        visited[node] = true;
        curPath[node] = cycleLen;

        int nbr = edges[node];

        if(nbr != -1){
            if(!visited[nbr]){
                dfs(nbr, edges, visited, curPath, cycleLen);
            }
            else if(curPath[nbr] != 0){
                int curCycleLen = curPath[node] - curPath[nbr] + 1;
                maxLen = Math.max(maxLen, curCycleLen);
            }
        }
        curPath[node] = 0;
    }
}