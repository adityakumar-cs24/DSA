class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
    
        if(grid[0][0] != 0 || grid[n - 1][n - 1] != 0){
            return -1;
        }
        int[][] directions = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1},
            {-1, -1},
            {-1, 1},
            {1, -1},
            {1, 1}
        };
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0});
        grid[0][0] = 1;
        int steps = 1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int[] cur = q.poll();
                int r = cur[0];
                int c = cur[1];
                if(r == n - 1 && c == n - 1){
                    return steps;
                }
                for(int[] dir : directions){
                    int nr = r + dir[0];
                    int nc = c + dir[1];

                    if(nr >= 0 && nr < n && nc >= 0 && nc < n 
                        && grid[nr][nc] == 0){
                            q.offer(new int[]{nr, nc});
                            grid[nr][nc] = 1;
                        }
                }
            }
            steps++;
        }
        return -1;
    }
}