class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        boolean[] visited = new boolean[n];
        for(int i = 0; i < n; i++){
            if(nums[i] > 0 && nums[i] <= n){
                visited[nums[i] - 1] = true;
            }
        }
        for(int i = 0; i < n; i++){
            if(visited[i] == false){
                return i + 1;
            }
        }
        return n + 1;
    }
}