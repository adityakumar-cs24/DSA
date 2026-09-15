class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int res = 1;
        for(int i = 0; i < n; i++){
            if(res == nums[i]){
                res += 1;
            }
            else if(res < nums[i]){
                break;
            }
        }
        return res;
    }
}