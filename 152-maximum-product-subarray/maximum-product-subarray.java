class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int curMin = nums[0];
        int curMax = nums[0];
        int max = nums[0];

        for(int i = 1; i < n; i++){
            int temp = Math.min(nums[i], Math.min(curMin * nums[i], curMax * nums[i]));

            curMax = Math.max(nums[i], Math.max(curMin * nums[i], curMax * nums[i]));
            
            curMin = temp;

            max = Math.max(max, curMax);
        }
        return max;
    }
}