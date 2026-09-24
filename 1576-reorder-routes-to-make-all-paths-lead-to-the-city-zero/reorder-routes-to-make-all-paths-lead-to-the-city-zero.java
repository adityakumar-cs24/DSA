class Solution {
    public int minReorder(int n, int[][] connections) {
        List<List<Integer>> fwdNbr = new ArrayList<>();
        List<List<Integer>> bwdNbr = new ArrayList<>();
        for(int i = 0; i < n; i++){
            fwdNbr.add(new ArrayList<>());
            bwdNbr.add(new ArrayList<>());
        }

        boolean[] visited = new boolean[n];
        
        for(int[] edge : connections){
            int u = edge[0];
            int v = edge[1];

            fwdNbr.get(u).add(v);
            bwdNbr.get(v).add(u);
        }

        return dfs(0, fwdNbr, bwdNbr, visited);
    }
    int dfs(int node, List<List<Integer>> fwdNbr, List<List<Integer>> bwdNbr, boolean[] visited){
        visited[node] = true;
        int count = 0;
        for(Integer nbr : fwdNbr.get(node)){
            if(!visited[nbr]){
                count++;
                count += dfs(nbr, fwdNbr, bwdNbr, visited);
            }
        }
        for(Integer nbr : bwdNbr.get(node)){
            if(!visited[nbr]){
                count += dfs(nbr, fwdNbr, bwdNbr, visited);
            }
        }
        return count;
    }
}