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
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {sr, sc});
        visited[sr][sc] = true;

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            image[r][c] = color;
            for(int[] dir : directions){
            int nr = r + dir[0];
            int nc = c + dir[1];

                if(nr >= 0 && nr < image.length &&
                    nc >= 0 && nc < image[0].length &&
                    !visited[nr][nc] && image[nr][nc] == original){
                    
                        visited[nr][nc] = true;
                        q.offer(new int[]{nr, nc});
                }
            }    
        }
        return image;
    }
}