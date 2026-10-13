class Solution {
    public List<List<Integer>> combinationSum(int[] arr, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        int start = 0;
        solve(arr, start, target, curr, ans);
        return ans;
    }
    void solve(int[] arr, int start, int remTarget, List<Integer> curr, List<List<Integer>> ans){
        if(remTarget == 0){
            ans.add(new ArrayList<>(curr));
            return;
        }
        if (remTarget < 0) return;
        for(int i = start; i < arr.length; i++){
            curr.add(arr[i]);
            solve(arr, i, remTarget - arr[i], curr, ans);
            curr.remove(curr.size() - 1);
        }
    }
}