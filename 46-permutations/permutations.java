class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        boolean[] used = new boolean[nums.length];

        solve(nums, curr, ans, used);
        return ans;
    }
    void solve(int[] nums, List<Integer> curr, List<List<Integer>> ans, boolean[] used){
        if(nums.length == curr.size()){
            ans.add(new ArrayList<>(curr));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(used[i]){
                continue;
            }
            used[i] = true;
            curr.add(nums[i]);
            solve(nums, curr, ans, used);
            curr.remove(curr.size() - 1);
            used[i] = false;
        }
    }
}