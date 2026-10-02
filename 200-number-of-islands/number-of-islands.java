class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] directions = {
            {-1, 0},
            {0, -1},
            {0, 1},
            {1, 0}
        };
        boolean[][] visited = new boolean[n][m];
        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == '1' && !visited[i][j]){
                    count++;
                    bfs(i, j, grid, visited, directions);
                }
            }
        }
        return count;
    }
    void bfs(int row, int col, char[][] grid, boolean[][] visited, int[][] directions){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {row, col});
        visited[row][col] = true;

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];

            for(int[] dir : directions){
            int nr = r + dir[0];
            int nc = c + dir[1];

                if(nr >= 0 && nr < grid.length &&
                    nc >= 0 && nc < grid[0].length){
                        if(grid[nr][nc] == '1' &&
                            !visited[nr][nc]){
                                visited[nr][nc] = true;
                                q.offer(new int[]{nr, nc});
                        }
                }
            }
        }
    }
}