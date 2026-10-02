class Solution {
    int max;
    int count;

    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] directions = {
                { -1, 0 },
                { 1, 0 },
                { 0, -1 },
                { 0, 1 }
        };
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    count = 1;
                    dfs(i, j, grid, visited, directions);
                    max = Math.max(max, count);
                }
            }
        }
        return max;
    }

    void dfs(int row, int col, int[][] grid, boolean[][] visited, int[][] directions) {
        visited[row][col] = true;
        for (int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];

            if (newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length) {
                if (!visited[newRow][newCol] && grid[newRow][newCol] == 1) {
                    count++;
                    dfs(newRow, newCol, grid, visited, directions);
                }
            }
        }
    }
}