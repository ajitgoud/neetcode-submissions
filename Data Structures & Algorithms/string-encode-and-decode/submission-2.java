class Solution {
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str.length()).append('#').append(str);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> strs = new ArrayList<>();
        int i = 0;

        while (i < str.length()) {
            int delimeter = str.indexOf('#', i);
            int length = Integer.parseInt(str.substring(i, delimeter));
            int start = delimeter + 1;
            int end = start + length;
            strs.add(str.substring(start, end));
            i = end;
        }

        return strs;
    }
}
