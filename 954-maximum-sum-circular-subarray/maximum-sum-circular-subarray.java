class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int curMax = nums[0];
        int normalMax = nums[0];
        for(int i = 1; i < n; i++){
            curMax = Math.max(nums[i], curMax + nums[i]);
            normalMax = Math.max(normalMax, curMax);
        }

        int[] maxSuffix = new int[n];
        maxSuffix[n - 1] = nums[n - 1];
        int suffixSum = nums[n - 1];
        for(int i = n - 2; i >= 0; i--){
            suffixSum += nums[i];
            maxSuffix[i] = Math.max(maxSuffix[i + 1], suffixSum);
        }

        int[] maxPrefix = new int[n];
        maxPrefix[0] = nums[0];
        int prefixSum = nums[0];
        for(int i = 1; i < n; i++){
            prefixSum += nums[i];
            maxPrefix[i] = Math.max(maxPrefix[i - 1], prefixSum);
        }

        int maxCircular = Integer.MIN_VALUE;
        for(int i = 0; i < n - 1; i++){
            int sum = maxPrefix[i] + maxSuffix[i + 1];
            maxCircular = Math.max(maxCircular, sum);
        }
        return Math.max(maxCircular, normalMax);
    }
}