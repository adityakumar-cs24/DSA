class Solution {
    public List<List<Integer>> combinationSum2(int[] arr, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        Arrays.sort(arr);
        solve(0, arr, target, curr, ans);
        return ans;
    }
    void solve(int start, int[] arr, int rem, List<Integer> curr, List<List<Integer>> ans){
        if(rem < 0){
            return;
        }
        if(rem == 0){
            ans.add(new ArrayList<>(curr));
            return;
        }
        for(int i = start; i < arr.length; i++){
            if(i > start && arr[i] == arr[i - 1]){
                continue;
            }
            curr.add(arr[i]);
            solve(i + 1, arr, rem - arr[i], curr, ans);
            curr.remove(curr.size() - 1);
        }
    }
}