class Solution {
    public int removeDuplicates(int[] nums) {
        Set<Integer> set = new LinkedHashSet<>();
        for(int num : nums){
            set.add(num);
        }
        int idx = 0;
        for(int num : set){
            nums[idx] = num;
            idx++;
        }
        return idx;
    }
}