class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n; i++){
            nums[i] = nums[i] * nums[i];
        }
        Arrays.sort(nums);
        long minSum = 0;
        long maxSum = 0;

        int mid = n / 2;
        for(int i = 0; i < mid; i++){
            minSum += nums[i];
        }
        for(int j = mid; j < n; j++){
            maxSum += nums[j];
        }
        return maxSum - minSum;
    }
}