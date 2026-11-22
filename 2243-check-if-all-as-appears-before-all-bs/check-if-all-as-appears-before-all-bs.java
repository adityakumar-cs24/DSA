class Solution {
    public boolean checkString(String s) {
        int count = 0;
        for(char c : s.toCharArray()){
            if(c == 'a') count++;
        }
        for(char c : s.toCharArray()){
            if(c == 'b' && count > 0) return false;
            if(c == 'a') count--;
        }
        return true;
    }
}