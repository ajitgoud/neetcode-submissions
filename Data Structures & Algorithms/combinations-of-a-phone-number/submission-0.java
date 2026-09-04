class Solution {
    private final String[] mapping = {
            "",
            "",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList();
        if(digits==null ||digits.isEmpty()){
            return result;
        }

        backtrack(digits, 0, new StringBuilder(), result);
        return result;
    }

    private void backtrack(String digits, int index, StringBuilder current, List<String> result){
        if(index==digits.length()){
            result.add(current.toString());
            return;
        }

        int digit = digits.charAt(index)-'0';
        String letters = mapping[digit];

        for(char letter: letters.toCharArray()){
            current.append(letter);
            backtrack(digits, index+1, current, result);
            current.deleteCharAt(current.length()-1);
        }
    }

}
