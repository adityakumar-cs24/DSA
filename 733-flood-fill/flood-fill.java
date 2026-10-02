class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;
        boolean[][] visited = new boolean[n][m];
        int original = image[sr][sc];
        int[][] directions = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };

        dfs(sr, sc, image, visited, color, original, directions);
        return image;
    }
    void dfs(int r, int c, int[][] image, boolean[][] visited, int color, int original, int[][] directions){
        visited[r][c] = true;
        image[r][c] = color;

        for(int[] dir : directions){
            int nr = r + dir[0];
            int nc = c + dir[1];

            if(nr >= 0 && nr < image.length &&
                nc >= 0 && nc < image[0].length &&
                !visited[nr][nc] && image[nr][nc] == original){
                    dfs(nr, nc, image, visited, color, original, directions);
                }
        }
    }
}