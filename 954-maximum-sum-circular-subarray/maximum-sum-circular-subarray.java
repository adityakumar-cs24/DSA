class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int totalSum = 0;
        int curMin = 0;
        int curMax = 0;
        int maxSum = nums[0];
        int minSum = nums[0];

        for(int i = 0; i < n; i++){
            curMax = Math.max(curMax + nums[i], nums[i]);
            maxSum = Math.max(maxSum, curMax);

            curMin = Math.min(curMin + nums[i], nums[i]);
            minSum = Math.min(minSum, curMin);

            totalSum += nums[i];
        }
        int normalSum = maxSum;
        int circularSum = totalSum - minSum;

        if(totalSum == minSum){
            return normalSum;
        }
        return Math.max(normalSum, circularSum);
    }
}