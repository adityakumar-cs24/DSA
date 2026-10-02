class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        solve(n, n, "", ans);
        return ans;
    }
    void solve(int open, int close, String temp, List<String> ans){
        if(open == 0 && close == 0){
            ans.add(temp);
            return;
        }
        if(open > 0){
            solve(open - 1, close, temp + '(', ans);
        }
        if(close > open){
            solve(open, close - 1, temp + ')', ans);
        }
    }
}