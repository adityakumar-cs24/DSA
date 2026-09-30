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
                    dfs(i, j, grid, visited, directions);
                }
            }
        }
        return count;
    }
    void dfs(int row, int col, char[][] grid, boolean[][] visited, int[][] directions){
        visited[row][col] = true;
        for(int[] dir : directions){
            int newRow = row + dir[0];
            int newCol = col + dir[1];

            if(newRow >= 0 && newRow < grid.length &&
                newCol >= 0 && newCol < grid[0].length){
                    if(grid[newRow][newCol] == '1' &&
                        !visited[newRow][newCol]){
                            dfs(newRow, newCol, grid, visited, directions);
                        }
                }
        }
    }
}