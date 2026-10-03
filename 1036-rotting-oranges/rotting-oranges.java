class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] directions = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };
        Queue<int[]> q = new ArrayDeque<>();
        int fresh = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 2){
                    q.offer(new int[]{i, j});
                }
                if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }
        int time = 0;
        while(!q.isEmpty() && fresh > 0){
            int size = q.size();

            for(int i = 0; i < size; i++){
                int[] cur = q.poll();

                int r = cur[0];
                int c = cur[1];

                for(int[] dir : directions){
                    int nr = r + dir[0];
                    int nc = c + dir[1];

                    if(nr >= 0 && nr < m &&
                        nc >= 0 && nc < n &&
                        grid[nr][nc] == 1){

                            grid[nr][nc] = 2;
                            fresh--;
                            q.offer(new int[]{nr, nc});
                        }
                }
            }
            time++;
        }
        if(fresh > 0){
            return -1;
        }
        return time;
    }
}