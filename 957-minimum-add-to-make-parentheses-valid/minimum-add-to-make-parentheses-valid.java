class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> st = new Stack<>();
        int extra = 0;
        for(char c : s.toCharArray()){
            if(c == '('){
                st.push(')');
            }
            else if(c == ')' && !st.isEmpty()){
                st.pop();
            }
            else{
                extra++;
            }
        }
        return extra + st.size();
    }
}