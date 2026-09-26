class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        HashMap<String, String> mp = new HashMap<>();
        for (var e : knowledge) {
            mp.put(e.getFirst(), e.getLast());
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                int j = s.indexOf(')', i + 2);
                String key = s.substring(i + 1, j);
                sb.append(mp.getOrDefault(key, "?"));
                i = j;
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}